package com.ironhack.battlesimulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {

            Scanner input = new Scanner(System.in);
            String i;
            Boolean isPlaying = true;

            while (isPlaying == true) {

                System.out.println("\n" + (char)27 + "[7m"+ "----- Do you want to start the game? -----" + "\033[0m" + "\n");
                System.out.println("Start the game: "+ (char)27 + "\033[1m"+ "(1)"+ "\033[0m");
                System.out.println("Visit the Graveyard: "+ (char)27 + "\033[1m"+ "(2)"+ "\033[0m");
                System.out.println("Exit Game " + (char)27 + "\033[1m"+ "(3)"+ "\033[0m");
                i = input.next();

                switch (i) {
                    case "1":
                        Game game1 = new Game();
                        game1.startGame();
                        break;
                    case "2":
                        Graveyard.showGraveyardMembers();
                        break;

                    case "3":
                        System.exit(0);
                    default:
                        System.out.println("mach es richtig !!");
                        break;
                }

            }
        }

    }
}


