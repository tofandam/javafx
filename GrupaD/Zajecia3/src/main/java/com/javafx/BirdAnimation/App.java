package com.javafx.BirdAnimation;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

class ColorWithName {
    private String mName = "";
    private Color mColor;

    ColorWithName(Color color, String name){
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

        circle.setRadius(50);
        circle.setFill(mColors.get(0).getColor());

        group.getChildren().add(circle);

        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(2));
        tt.setNode(circle);

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                tt.setFromX(circle.getTranslateX());
                tt.setFromY(circle.getTranslateY());
                tt.setToX(event.getX());
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


    public static void main(String[] args) {
        launch(args);
    }
}
