package ru.geekbrains.pavel_loginov.lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    public Window() {
        setSize(500, 500);
        setLocation(500, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        add(panel, BorderLayout.NORTH);

        JButton exitButton = new JButton("Exit");

        ActionListener exitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        exitButton.addActionListener(exitListener);

        panel.add(exitButton);

        JButton button2 = new JButton("Button");
        panel.add(button2);
    }
}
