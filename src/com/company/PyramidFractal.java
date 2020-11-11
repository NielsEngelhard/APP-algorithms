package com.company;

import javax.swing.*;
import java.awt.*;

public class PyramidFractal extends JFrame {

    public final static int WIDTH = 1400;
    public final static int HEIGHT = 1400;

    public PyramidFractal(){
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        drawPyramid(g, 600, 200, 9);
    }

    public void drawPyramid(Graphics g, int begin_x, int begin_y, int loops) {
        // base_case
        if(loops <= 0) {
            return;
        }
        g.drawLine(begin_x, begin_y, begin_x + 50, begin_y + 50); // rechterlijn
        g.drawLine(begin_x, begin_y, begin_x - 50, begin_y + 50); // linkerlijn
        g.drawLine(begin_x + 50, begin_y + 50, begin_x - 50, begin_y + 50); // middelste lijn

        drawPyramid(g, begin_x - 50, begin_y + 50, loops - 1);
        drawPyramid(g, begin_x + 50, begin_y + 50, loops - 1);
    }



    public static void main(String[] args){
        new PyramidFractal();
    }

}
