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
            byte[] bytes = SerialConnection.concat(CtrlCodes.CTRL_A.asByte(), SerialConnection.strictStringToBytes("?", Charset.defaultCharset()), CtrlCodes.ENTER.asByte());
            sc.writeBytes(bytes);
            byte[] res = sc.readBytes(51);
            System.out.println(new String(res));
        } catch (CharacterCodingException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
