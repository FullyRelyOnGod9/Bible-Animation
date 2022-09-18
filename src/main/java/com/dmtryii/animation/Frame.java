package com.dmtryii.animation;

import javax.swing.JFrame;

public class Frame extends JFrame {
    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("DVD-Animation");
        this.add(new Panel());
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
