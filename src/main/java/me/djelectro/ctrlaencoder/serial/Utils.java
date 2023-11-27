package me.djelectro.ctrlaencoder.serial;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

public class Utils {
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
