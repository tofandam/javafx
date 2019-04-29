/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package PuzzleEnumExample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

class PuzzleElement extends ImageView {

    private int mI, mJ;
    private int mDimension;

    @FunctionalInterface
    public interface onPuzzleClicked{
        void onClicked(int i, int j);
    }

    onPuzzleClicked mListener;

    public void setOnPuzzleClickedListener(onPuzzleClicked listener){
        mListener = listener;
    }

    WritableImage mImage;

    PuzzleElement(WritableImage image, int dimension, int i, int j){
        super(image);

        mDimension = dimension;

        this.setX(i*dimension);

        mI = i;
        mJ = j;
    }
}

public class App extends Application {

    PuzzleElement[][] mPuzzle = new PuzzleElement[2][2];

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();

        Scene scene = new Scene(group,500,500);

        createPuzzle();

        group.getChildren().add(mPuzzle[0][0]);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createPuzzle(){
        Image image = new Image(getClass().getResource("elephant.png").toString());

        PixelReader reader = image.getPixelReader();
        WritableImage newImage = new WritableImage(reader, 0, 0, (int)image.getWidth()/2, (int)image.getHeight()/2);

        mPuzzle[0][0] = new PuzzleElement(newImage,(int)(image.getWidth()/2),0,0);
    }
}