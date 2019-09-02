package com.company;

import javax.swing.*;
import java.awt.*;

public class Road extends JFrame{

    public void paint(Graphics g){
        g.drawLine(100,100,400,100);
        g.drawLine(100,200,400,200);

        g.drawLine(600,100,900,100);
        g.drawLine(600,200,900,200);

        g.setColor(Color.blue);
    }
}
