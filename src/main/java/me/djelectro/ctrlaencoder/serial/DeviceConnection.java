package me.djelectro.ctrlaencoder.serial;

import java.util.ArrayList;

public interface DeviceConnection {

    public static ArrayList<DeviceConnection> instances = new ArrayList<>();

    String getDeviceName();

    String[] getInterfaces();

    void setInterface(String inter);
    void connect();
    boolean isConnected();

    byte[] readBytes(int bytesToRead);
    void writeBytes(byte[] bytes);

    int getAvailableBytes();


}
