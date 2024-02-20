package me.djelectro.ctrlaencoder.utils;

import javafx.util.Pair;
import me.djelectro.ctrlaencoder.serial.ConnectionType;
import me.djelectro.ctrlaencoder.serial.DeviceConnection;

import java.util.ArrayList;
import java.util.HashMap;

public class SaveLoadData {

    public static void saveProject(String fileName){
        // Grab all open DeviceConnection instances, get device type and portname, and save to json
        HashMap<String, Pair<String, ConnectionType>> dList = new HashMap<>();
        for(String x : DeviceConnection.instances.keySet()){
            DeviceConnection y = DeviceConnection.instances.get(x);
            dList.put(x, new Pair<>(y.getDeviceName(), y.getConnType()));
        }
        System.out.println(dList);
    }
}
