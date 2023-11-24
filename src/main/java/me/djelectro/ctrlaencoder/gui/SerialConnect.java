package me.djelectro.ctrlaencoder.gui;

import javax.swing.*;

public class SerialConnect extends JFrame {

    private JPanel contentPane;
    private JButton connectButton;
    private JComboBox comboBox1;
    private JTextField textField1;

    public SerialConnect(String[] serialConnectChoices){
        //contentPane.setVisible(true);
       setContentPane(contentPane);
       // getRootPane().setVisible(true);
        for(String item : serialConnectChoices){
            comboBox1.addItem(item);
        }

    }
}
