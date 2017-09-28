package com.javarush.task.test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by Zver on 01.09.2017.
 */
public class MyApp extends Application{
    public void start(Stage stage) {
        Circle circ = new Circle(40, 40, 30);
        Group root = new Group(circ);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("My JavaFX Application");
        getHostServices().showDocument("http://ya.ru");
        stage.setScene(scene);
        stage.show();
    }
}
