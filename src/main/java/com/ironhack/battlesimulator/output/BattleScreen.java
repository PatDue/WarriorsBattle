package com.ironhack.battlesimulator.output;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Date;

public class BattleScreen extends JFrame{

    private JTextArea textArea;

    private JButton buttonStart = new JButton("Start");
    private JButton buttonClear = new JButton("Clear");

    private PrintStream standardOut;

    public BattleScreen() {
        super("Battle Field");

        textArea = new JTextArea(3, 3);
        textArea.setEditable(false);
        textArea.setFont(textArea.getFont().deriveFont(18f));
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));

        // keeps reference of standard output stream
        standardOut = System.out;

        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);

        // creates the GUI
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;

        //add(buttonStart, constraints);

        //constraints.gridx = 1;
        //add(buttonClear, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        add(new JScrollPane(textArea), constraints);

        // adds event handler for button Start
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //printLog();
            }
        });

        // adds event handler for button Clear
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // clears the text area
                try {
                    textArea.getDocument().remove(0,
                            textArea.getDocument().getLength());
                    standardOut.println("Text area cleared");
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setLocationRelativeTo(null);    // centers on screen
    }

    /**
     * Prints log statements for testing in a thread
     */
    private void printLog() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Time now is " + (new Date()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }


}
