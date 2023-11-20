package com.dmtryii.animation;

import com.dmtryii.animation.config.ConfigApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener {
    private final int WIDTH = ConfigApp.WIDTH_SCREEN;
    private final int HEIGHT = ConfigApp.HEIGHT_SCREEN;
    private Image enemy;
    private Timer timer;
    private int xVelocity = 1;
    private int yVelocity = 1;
    private int x = 0;
    private int y = 0;

    private int randEnemy;

    Panel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        enemy = new ImageIcon(ConfigApp.imagesPath + "bv0.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(enemy, x, y, null);
    }

    public void getRandomEnemy() {
        int n = (int) (Math.random() * 8);
        while (n == randEnemy || n > 8) {
            n = (int) (Math.random() * 8);
            n += 1;
        }

        randEnemy = n;
        enemy = new ImageIcon(ConfigApp.imagesPath + "bv" + randEnemy + ".png").getImage();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(x >= WIDTH - enemy.getWidth(null) || x < 0) {
            xVelocity = xVelocity * -1;
            getRandomEnemy();
        }
        x = x + xVelocity;

        if(y >= HEIGHT - enemy.getHeight(null) || y < 0) {
            yVelocity = yVelocity * -1;
            getRandomEnemy();
        }
        y = y + yVelocity;

        repaint();
    }
}
