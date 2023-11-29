package me.djelectro.ctrlaencoder.gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import me.djelectro.ctrlaencoder.serial.DeviceConnection;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainAppWindow {
    private static Stage primaryStage;

    @FXML
    private ChoiceBox<String> deviceSelect;

    public MainAppWindow(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public MainAppWindow(){

    }

    public void showWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/MainAppWindow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle ("AEI Caption Cue Server");
        primaryStage.show();
    }

    @FXML
    private void testButton(ActionEvent event){
        event.consume();
        try {
            new SerialConnect(primaryStage, DeviceConnection.instances.get(deviceSelect.getValue())).showWindow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize(){
        deviceSelect.setItems(FXCollections.observableList((DeviceConnection.instances.keySet().stream().toList())));
    }

}
