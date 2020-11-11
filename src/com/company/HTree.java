package com.company;

import java.awt.*;

import javax.swing.JFrame;

public class HTree extends JFrame {
        public final static int WIDTH = 500;
        public final static int HEIGHT = 500;
        public final static double FACTOR = 0.71f;



    public HTree(){
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    @Override
    public void paint(Graphics g) {
        drawRuler(g, 50, 400, 5);

    }

    public void drawRuler(Graphics g, int left, int right, int level) {
        if (level < 1) {
            return;
        }

        int mid = ( left + right) / 2;

        g.drawLine(mid, 80, mid,  80 - level * 5);

        drawRuler(g, left, mid - 1, level -1);
        drawRuler(g, mid + 1, right, level - 1);
    }



    public static void main(String[] args){
        new HTree().setVisible(true);
    }
}