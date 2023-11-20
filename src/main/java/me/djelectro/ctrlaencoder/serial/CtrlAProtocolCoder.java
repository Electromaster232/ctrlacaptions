package me.djelectro.ctrlaencoder.serial;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

public class CtrlAProtocolCoder {

    private SerialConnection sc;

    public CtrlAProtocolCoder(String serialPort){
        sc = new SerialConnection(serialPort);
    }

    public boolean connect(){
        sc.connect();
        try {
            byte[] bytes = SerialConnection.concat(CtrlCodes.CTRL_A.asByte(), SerialConnection.strictStringToBytes("?", Charset.defaultCharset()));
            sc.writeBytes(bytes);
            System.out.println(new String(sc.readBytes(10)));
        } catch (CharacterCodingException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
