package me.djelectro.ctrlaencoder.serial;

public interface SerialConnection {

    String[] getInterfaces();

    void setInterface(String inter);
    void connect();

    byte[] readBytes(int bytesToRead);
    void writeBytes(byte[] bytes);

    int getAvailableBytes();


}
