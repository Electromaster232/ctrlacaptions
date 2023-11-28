package me.djelectro.ctrlaencoder.tui;

import java.io.Serial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainMenu extends Menu {

    public MainMenu() {
        super("Main Menu", "Select a category", new HashMap<Integer, String>() {{

            //put(1, "Open Test Menu");
            put(1, "Serial Connection Control");
            put(2, "Quit");

        }});


        print();
    }

    @Override
    public void doAnswer(int choice){
        switch(choice){
            case 1 -> {
                goSerial();
            }
            case 2 -> {
                quit();
            }

        }
    }

    public void goSerial(){
        new SerialMenu();
    }

    public static void quit(){
        System.exit(666);
    }
}
