package com.javafx;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;

class ColorWithName1 {
    private String mName = "";
    private Color mColor;

    ColorWithName1(Color color, String name){
        mColor = color;
        mName = name;
    }

    public Color getColor(){
        return mColor;
    }

    public String getName(){
        return mName;
    }

}

public class App extends Application {

    ArrayList<ColorWithName> mColors = new ArrayList<>();
    ArrayList<Node> mItems = new ArrayList<>();

    @Override
    public void init() throws Exception {
        super.init();

        mColors.add(new ColorWithName(Color.AQUAMARINE,"Aquamarine"));
        mColors.add(new ColorWithName(Color.BISQUE,"Bisque"));

    }

    private int randomNumber(int max){
        return (int)(Math.random()*max)+1;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();

        Scene scene = new Scene(group, 640, 480);

        Circle circle = new Circle();
        circle.setCenterX(0);
        circle.setCenterY(0);

        circle.setRadius(500);
        circle.setFill(mColors.get(0).getColor());

        URL url = getClass().getResource("ptak.gif");

        Image image = new Image(url.toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);


        //group.getChildren().add(circle);
        group.getChildren().add(imageView);

        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(2));
        tt.setNode(imageView);

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                double oldX = imageView.getTranslateX();
                double oldY = imageView.getTranslateY();

                System.out.println("elo"+oldX+", "+oldY);

                double newX = event.getX();
                double newY = event.getY();

            //   group.getChildren().remove(imageView);
              group.getChildren().removeAll(mItems);

               Node item = addItem(newX,newY);
            //   mItems.add(item);
                group.getChildren().addAll(mItems);
            //    group.getChildren().add(imageView);


            if(newX>oldX)
                imageView.setScaleX(1);
                else
                imageView.setScaleX(-1);

                tt.setFromX(oldX);
                tt.setFromY(oldY);

                tt.setToX(newX);

                tt.setToY(event.getY());

                tt.stop();
                tt.play();

                ColorWithName color = mColors.get(randomNumber(mColors.size())-1);
                circle.setFill(color.getColor());

            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Node addItem(double x, double y){
        Circle circle = new Circle();
        circle.setCenterY(y);
        circle.setCenterX(x);
        circle.setRadius(Math.random()*20+10);

        circle.setRadius(10);
        circle.setFill(Color.YELLOW);

        mItems.add(circle);

        return circle;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
