package me.djelectro.ctrlaencoder;

import me.djelectro.ctrlaencoder.gui.SerialConnect;
import me.djelectro.ctrlaencoder.serial.LocalSerialConnection;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Evertz Ctrl-A Data Protocol Encoder");
//        System.out.println("Demo, please enter device name exactly as it appears");
//
//        System.out.println(SerialConnection.getInterfaces());
//        Scanner sc = new Scanner(System.in);
//        String user = sc.nextLine();
//
//        CtrlAProtocolCoder a = new CtrlAProtocolCoder(user);
//        a.connect();
        SerialConnect dialog = new SerialConnect(new LocalSerialConnection());
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}