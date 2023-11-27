package me.djelectro.ctrlaencoder.serial;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

public interface SerialConnection {

    String[] getInterfaces();

    void setInterface(String inter);
    void connect();

    byte[] readBytes(int bytesToRead);
    void writeBytes(byte[] bytes);

    int getAvailableBytes();

    static byte[] strictStringToBytes(String s, Charset charset) throws CharacterCodingException {
        ByteBuffer x  = charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).encode(CharBuffer.wrap(s));
        byte[] b = new byte[x.remaining()];
        x.get(b);
        return b;
    }

    static byte[] concat(byte[]... bytes){
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
