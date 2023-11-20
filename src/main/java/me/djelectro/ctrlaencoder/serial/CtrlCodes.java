package me.djelectro.ctrlaencoder.serial;

public enum CtrlCodes {

    CTRL_A (1);

    private final int asciiCode;
    CtrlCodes(int i) {
        this.asciiCode = i;
    }

    public byte[] asByte(){
        byte[] a = new byte[1];
        a[0] = (byte) asciiCode;
        return a;
    }
}
