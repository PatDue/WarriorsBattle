package com.ironhack.battlesimulator.output;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.ActionListBox;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.dialogs.ActionListDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.ironhack.battlesimulator.Game;
import com.ironhack.battlesimulator.Graveyard;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


public class GameMenu {
    private Screen screen;
    private DefaultTerminalFactory terminalFactory;
    private Terminal terminal;

    {
        try {
            terminalFactory = new DefaultTerminalFactory();
            TerminalSize tSize = new TerminalSize(35,14);
            terminalFactory.setInitialTerminalSize(tSize);
            screen = terminalFactory.createScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    TextColor foreC = TextColor.ANSI.RED;
    TextColor backC = TextColor.ANSI.BLACK;


    public void startMenu() throws IOException {

        //init screen fro game menu
        screen.startScreen();
        //setup();

        // Setup WindowBasedTextGUI for dialogs
        final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
        ActionListDialogBuilder dibuild =  new ActionListDialogBuilder().setTitle("Warrior Battle Game Menu").setDescription("Choose your step").setCanCancel(false);
        dibuild.addAction("Start Game",new Runnable() {
            @Override
            public void run () {
                Game game1 = new Game();
                game1.startGame();
            }
        });


        dibuild.addAction("Visit Graveyard",new Runnable() {
            @Override
            public void run () {

                Graveyard.showGraveyardMembers();
                try {
                    screen.startScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        dibuild.addAction("Exit",new Runnable() {
            @Override
            public void run () {
                System.exit(0);
            }
        });


        dibuild.build().showDialog(textGUI);




    }

    public void setup() throws IOException {
        cursorWait(0, 0, 1111);
        typeln(">_ GET READY FOR SOME ACTION!", 0, 0);
        cursorWait(0, 0, 999);
        typeln(">_ MAKE YOURSELF COMFORTABLE", 0, 4);
        cursorWait(0, 0, 888);
        typeln(">_ ....................................................", 0, 6);
        cursorWait(0, 0, 1111);
        typeln(">_ ET LUDOS INCIPERE", 0, 6);
        cursorWait(0, 0, 888);
    }

    public void typeln(String msg, int col, int row) {
        TextColor defC = foreC;
        foreC = TextColor.ANSI.GREEN;
        int interval = 11;

        for (int i = 0; i < msg.length(); i++) {
            screen.setCursorPosition(new TerminalPosition(col+i, row));
            screen.setCharacter( (col+i), row, new TextCharacter(msg.charAt(i), foreC, backC));

            try {
                screen.refresh();
                Thread.sleep(ThreadLocalRandom.current().nextInt(interval*3));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        foreC = defC;
    }

    public void cursorWait(int col, int row, int millis) {

        screen.setCursorPosition(null);

        try {
            screen.refresh();

            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




}