package me.djelectro.ctrlaencoder.serial;

import com.fazecast.jSerialComm.*;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

public class LocalSerialConnection implements SerialConnection {
    private SerialPort comPort;
    private boolean portOpen = false;

    public String[] getInterfaces(){
        return getInterfacesString();
    }

    public void setInterface(String inter){
        this.comPort = SerialPort.getCommPort(inter);
    }

    public static String[] getInterfacesString(){
        SerialPort[] interfaces = SerialPort.getCommPorts();
        String[] res = new String[interfaces.length];
        int index = 0;
        for(SerialPort x : interfaces){
            res[index] = x.getDescriptivePortName();
            index++;
        }
        return res;
    }

    public LocalSerialConnection(){}

    public LocalSerialConnection(String inter){
        this.comPort = SerialPort.getCommPort(inter);
    }

    public void connect(){
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING | SerialPort.TIMEOUT_WRITE_BLOCKING, 10000, 0);
        comPort.openPort();
        //comPort.flushIOBuffers();
        portOpen = true;
    }

    public void writeBytes(byte[] bytes){
        if(!portOpen)
            throw new RuntimeException("Port is not connected");
        comPort.writeBytes(bytes, bytes.length);
    }

    public int getAvailableBytes() {
        if(!portOpen)
            throw new RuntimeException("Port is not connected");
        return comPort.bytesAvailable();
    }

    public byte[] readBytes(int bytesToRead){
        if(!portOpen)
            throw new RuntimeException("Port is not connected");
        byte[] byteArray = new byte[bytesToRead];
        comPort.readBytes(byteArray, bytesToRead);
        return byteArray;
    }


}
