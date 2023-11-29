package me.djelectro.ctrlaencoder.serial;

import java.util.ArrayList;
import java.util.HashMap;

public interface DeviceConnection {

    public static HashMap<String, DeviceConnection> instances = new HashMap<>();

    String getDeviceName();

    String[] getInterfaces();

    void setInterface(String inter);
    void connect();
    boolean isConnected();

    byte[] readBytes(int bytesToRead);
    void writeBytes(byte[] bytes);

    int getAvailableBytes();


}
