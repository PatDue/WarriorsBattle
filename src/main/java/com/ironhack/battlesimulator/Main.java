package com.ironhack.battlesimulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("Start Game?");
            System.out.println("Start (1) ?");
            System.out.println("Exit (2) ?");
            Scanner input = new Scanner(System.in);
            String i = input.next();
            Boolean isPlaying = true;

            while (isPlaying == true) {
                switch (i) {
                    case "1":
                        Game game1 = new Game();
                        game1.startGame();
                        break;

                    case "2":
                        System.exit(0);
                    default:
                        System.out.println("Enter '1' or '2' !");
                        break;
                }

                System.out.println("Start Game?");
                System.out.println("Start (1) ?");
                System.out.println("Exit (2) ?");
                i = input.next();
            }
        }

    }
}


