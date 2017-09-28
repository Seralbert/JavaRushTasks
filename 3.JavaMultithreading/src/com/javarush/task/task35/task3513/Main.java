package com.javarush.task.task35.task3513;

import javax.swing.*;

/**
 * Created by USER-PC on 15.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setTitle("2048");
        mainFrame.setResizable(false);
        mainFrame.setSize(450,500);

        mainFrame.add(controller.getView());

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
