package com.ironhack.battlesimulator.output;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

public class BattleScreen {

    private JTextArea textArea;

    private JButton buttonStart = new JButton("Start");
    private JButton buttonClear = new JButton("Clear");

    private PrintStream standardOut;

    public BattleScreen() {
        JFrame bJFrame = new JFrame();
        bJFrame.setTitle("Battle Field");
        textArea = new JTextArea(300, 300);
        textArea.setEditable(false);
        textArea.setFont(textArea.getFont().deriveFont(18f));
        //bJFrame.add(textArea);
        bJFrame.setVisible(true);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));

        // keeps reference of standard output stream
        standardOut = System.out;

        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);

        // creates the GUI
        bJFrame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        bJFrame.add(new JScrollPane(textArea), constraints);


        bJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bJFrame.setSize(700, 800);
        bJFrame.setLocationRelativeTo(null);    // centers on screen
    }

}
