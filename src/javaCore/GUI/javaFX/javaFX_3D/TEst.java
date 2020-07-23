package javaCore.GUI.javaFX.javaFX_3D;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 * @author Ross Khapilov
 * @version 1.0 07.06.2018
 */
public class TEst extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Cylinder cX = new Cylinder(4,60);
        Cylinder cY = new Cylinder(4,60);
        Cylinder cZ = new Cylinder(4,60);

        Rotate rx = new Rotate(90,Rotate.X_AXIS);
        Rotate ry = new Rotate(90,Rotate.Y_AXIS);
        Rotate rz = new Rotate(90,Rotate.Z_AXIS);

        cX.getTransforms().add(rx);
        cY.getTransforms().add(ry);
        cZ.getTransforms().add(rz);

        cX.setTranslateZ(-30);
        cY.setTranslateY(-30);
        cZ.setTranslateX(30);
//
        cX.setMaterial(new PhongMaterial(Color.RED));
        cY.setMaterial(new PhongMaterial(Color.GREEN));
        cZ.setMaterial(new PhongMaterial(Color.BLUE));

        Group root = new Group(cX,cY,cZ);
        root.setTranslateX(350);
        root.setTranslateY(350);
        root.setTranslateZ(100);

        Scene scene = new Scene(root,700,700,false,SceneAntialiasing.BALANCED);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
