package me.djelectro.ctrlaencoder.gui;

import me.djelectro.ctrlaencoder.serial.SerialConnection;

import javax.swing.*;

public class SerialConnect extends JFrame {

    private JPanel contentPane;
    private JButton connectButton;
    private JComboBox comboBox1;
    private JTextField textField1;

    public SerialConnect(SerialConnection connInterface){
        //contentPane.setVisible(true);
       setContentPane(contentPane);
       // getRootPane().setVisible(true);
        for(String item : connInterface.getInterfaces()){
            comboBox1.addItem(item);
        }

    }
}
