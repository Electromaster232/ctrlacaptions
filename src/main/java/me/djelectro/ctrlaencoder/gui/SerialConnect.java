package me.djelectro.ctrlaencoder.gui;

import me.djelectro.ctrlaencoder.serial.DeviceConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SerialConnect extends JFrame {

    private JPanel contentPane;
    private JButton connectButton;
    private JComboBox comboBox1;

    public SerialConnect(DeviceConnection connInterface){
        //contentPane.setVisible(true);
       setContentPane(contentPane);
       // getRootPane().setVisible(true);
        for(String item : connInterface.getInterfaces()){
            comboBox1.addItem(item);
        }

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }


}
