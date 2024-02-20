package me.djelectro.ctrlaencoder.gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import me.djelectro.ctrlaencoder.serial.ConnectionType;
import me.djelectro.ctrlaencoder.serial.DeviceConnection;

import java.io.IOException;
import java.util.List;

public class NewDevice {
    private Stage primaryStage;

    @FXML
    private ChoiceBox<ConnectionType> deviceDropdown;

    @FXML
    private TextField nameBox;

    @FXML
    private TextField stringBox;

    @FXML
    void execute(ActionEvent event) {

    }
    public NewDevice(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public NewDevice(){

    }


    public void showWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/CreateDevice.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle ("New Serial Device");
        primaryStage.show();
    }

    @FXML
    void initialize() {
        deviceDropdown.setItems(FXCollections.observableList(List.of(ConnectionType.values())));
    }



}
