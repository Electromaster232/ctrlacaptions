package me.djelectro.ctrlaencoder.gui;

import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import me.djelectro.ctrlaencoder.serial.DeviceConnection;
import me.djelectro.ctrlaencoder.serial.LocalSerialConnection;

import java.io.IOException;
import java.util.List;

public class SerialConnect {
    private Stage primaryStage;

    @FXML
    private ChoiceBox<String> serialbox;

    private DeviceConnection deviceConnection;

    public SerialConnect(Stage primaryStage, DeviceConnection deviceConnection){
        this.primaryStage = primaryStage;
        this.deviceConnection = deviceConnection;
    }


    public void showWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/SerialConnect.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle ("Device Connection Manager");
        primaryStage.show();
    }

    @FXML
    void initialize() {
        assert serialbox != null : "fx:id=\"serialbox\" was not injected: check your FXML file 'SerialConnect.fxml'.";
        serialbox.setItems(FXCollections.observableList(List.of(deviceConnection.getInterfaces())));
    }



}
