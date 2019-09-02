package com.company;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        new Main().launchFrame();


    }

    public void launchFrame(){
        System.out.println("****************************");
        setBounds(200,200,640,480);
        setSize(1000,650);
        setLocation(150, 150);

        setTitle("Car Traffic Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
        JLabel jLabel = new JLabel("City");
        contentPane.add(jLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void paint(Graphics g){
        g.drawLine(100,100,400,100);
        g.drawLine(100,150,155,150);
        g.drawLine(175,150,230,150);
        g.drawLine(250,150,305,150);
        g.drawLine(325,150,380,150);
        g.drawLine(100,200,400,200);

        g.drawLine(600,100,900,100);
        g.drawLine(600,150,655,150);
        g.drawLine(675,150,730,150);
        g.drawLine(750,150,805,150);
        g.drawLine(825,150,880,150);
        g.drawLine(600,200,900,200);

        g.setColor(Color.black);
    }
}
