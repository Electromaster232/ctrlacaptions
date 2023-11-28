package me.djelectro.ctrlaencoder.tui;

import me.djelectro.ctrlaencoder.serial.DeviceConnection;
import me.djelectro.ctrlaencoder.serial.LocalSerialConnection;

import java.util.ArrayList;
import java.util.HashMap;

public class SerialMenu extends Menu {
    public SerialMenu() {
        super("Device Connection Menu", "Select an option", new HashMap<Integer, String>() {{
            put(1, "Go Back");
            put(2, "Create New Device");
            int x = 3;
            for(DeviceConnection c : DeviceConnection.instances){
                put(x, c.getDeviceName());
                x++;
            }

        }});


        setExtra("Hello World");
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
                updateAnswers(new HashMap<Integer, String>() {{
                    put(1, "Go Back");
                    put(2, "Create New Device");
                    int x = 3;
                    for(DeviceConnection c : DeviceConnection.instances){
                        put(x, c.getDeviceName());
                        x++;
                    }

                }});
                print();
            }
            default -> {

            }
        }
    }

}
