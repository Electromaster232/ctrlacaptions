package me.djelectro.ctrlaencoder.tui;

import me.djelectro.ctrlaencoder.serial.DeviceConnection;
import me.djelectro.ctrlaencoder.serial.LocalSerialConnection;

import java.util.HashMap;

public class ConnectionMenu extends Menu {
    public ConnectionMenu(DeviceConnection deviceConnection) {
        super("Device Connection Menu", "Select an option", new HashMap<Integer, String>() {{
            put(1, "Go Back");
            put(2, "Connect/Disconnect");

        }});


        setExtra("Currently Connected: " + deviceConnection.isConnected());
        print();
    }

    @Override
    public void doAnswer(int choice){
        switch (choice){
            case 1 -> {
                menuHistory.get(menuHistory.size()-2).print();
            }
            case 2 -> {
                DeviceConnection.instances.add(new LocalSerialConnection());
                System.out.println("New Local Serial Connection Created");
                print();
            }
            default -> {

            }
        }
    }

}
