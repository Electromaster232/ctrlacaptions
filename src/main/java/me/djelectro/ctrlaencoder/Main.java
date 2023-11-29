package me.djelectro.ctrlaencoder;

import javafx.application.Application;
import javafx.stage.Stage;
import me.djelectro.ctrlaencoder.gui.MainAppWindow;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new MainAppWindow(stage).showWindow();
    }
}