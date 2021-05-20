package com.ironhack.battlesimulator;

import com.ironhack.battlesimulator.output.BattleScreen;
import com.ironhack.battlesimulator.output.GameMenu;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new BattleScreen().setVisible(true);
        //Menue.startMenue();
        GameMenu myG = new GameMenu();

        while (true) {
            try {
                myG.startMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scanner input = new Scanner(System.in);
            String i;
            Boolean isPlaying = true;

//            while (isPlaying == true) {
//
//                System.out.println("Start Game?");
//                System.out.println("Start (1) ?");
//                System.out.println("Visit Graveyard (2) ?");
//                System.out.println("Exit (3) ?");
//                i = input.next();
//
//
//                switch (i) {
//                    case "1":
//                        Game game1 = new Game();
//                        game1.startGame();
//                        break;
//                    case "2":
//                        Graveyard.showGraveyardMembers();
//                        break;
//
//                    case "3":
//                        System.exit(0);
//                    default:
//                        System.out.println("mach es richtig !!");
//                        break;
//                }
//
//            }
        }

    }
}


