package me.djelectro.ctrlaencoder.serial;

import com.fazecast.jSerialComm.*;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

public class SerialConnection {
    private SerialPort comPort;
    private boolean portOpen = false;

    public static String getInterfaces(){
        return Arrays.toString(SerialPort.getCommPorts());
    }

    public SerialConnection(String port){
        this.comPort = SerialPort.getCommPort(port);
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

    public byte[] readBytes(int bytesToRead){
        byte[] byteArray = new byte[bytesToRead];
        comPort.readBytes(byteArray, bytesToRead);
        return byteArray;
    }

    public static byte[] strictStringToBytes(String s, Charset charset) throws CharacterCodingException {
        ByteBuffer x  = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).encode(CharBuffer.wrap(s));
        byte[] b = new byte[x.remaining()];
        x.get(b);
        return b;
    }

    public static byte[] concat(byte[]... bytes){
        // Total the length of each byte array
        int len = 0;
        for(byte[] x : bytes){
            len += x.length;
        }
        int index = 0;
        byte[] res = new byte[len];
        for(byte[] x : bytes){
            for (byte y : x){
                res[index] = y;
                index++;
            }
        }
        return res;
    }
}
