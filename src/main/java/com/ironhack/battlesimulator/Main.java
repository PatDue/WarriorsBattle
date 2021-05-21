package com.ironhack.battlesimulator;

import com.ironhack.battlesimulator.output.BattleScreen;
import com.ironhack.battlesimulator.output.GameMenu;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //init the output windows
        GameMenu myG = new GameMenu();
        BattleScreen myB = new BattleScreen();
        //myB.setVisible(true);

        while (true) {
            try {
                myG.startMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scanner input = new Scanner(System.in);
            String i;
            Boolean isPlaying = true;
        }

    }
}


