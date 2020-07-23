package javaCore.GUI.javaFX.javaFX_3D;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * @author Ross Khapilov
 * @version 1.0 07.06.2018
 */
public class First3DExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("First 3D Example");
        primaryStage.setScene(makeScene());
        primaryStage.show();
    }

    private Scene makeScene() {
        Sphere sphere = new Sphere(100);
        //Добавляем в группу и располагаем в в координатам XY
        Group root = new Group(sphere);
        root.setTranslateX(320);
        root.setTranslateY(240);
        //Добавляем группу на сцену и добавляем сглаживание
        Scene scene = new Scene(root, 640, 480,
                true, SceneAntialiasing.BALANCED);
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
