package com.sud;

import javax.swing.JFrame;

public class Frame extends JFrame{
    Panel panel = new Panel();
    public Frame(){
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(panel);
    }
}
