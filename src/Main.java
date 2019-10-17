import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;


public class Main {
    JFrame frame = new JFrame("CarTrafficSimulator");
    Display display = new Display();
//    Display display1 = new Display();
    JPanel trafficBoard = new JPanel();
    JPanel trafficBoard2 = new JPanel();
    JLabel countdownText = new JLabel();
    JButton changeRoad = new JButton("Three roads mode");
    final Color[] color = {new Color(0, 255, 0)};

    public void oneWay() {
        Vehicle car = new Vehicle(100, 150, 70, 35, Color.RED);
        Vehicle car2 = new Vehicle(850,100, 70,35, Color.BLUE);
        //frame.add(trafficLight,BorderLayout.WEST);
        display.setCar(car);
        display.setCar2(car2);

        trafficBoard.setFocusable(true);
        trafficBoard.setPreferredSize(new Dimension(300, 80));
        trafficBoard.setBackground(Color.GREEN);
        trafficBoard.add(countdownText);
        frame.add(trafficBoard, BorderLayout.NORTH);

        //TrafficLight trafficLight = new TrafficLight();

        java.util.Timer timer2 = new java.util.Timer();

        timer2.scheduleAtFixedRate(new TimerTask() {
            Color light_color = Color.GREEN;
            int countdown = 3;

            @Override
            public void run() {
                countdown = countdown - 1;
                switch (countdown) {
                    case -1:
                        light_color = Color.RED;
                        trafficBoard.setBackground(light_color);
                        countdown = 14;
                        break;
                    case 7:
                        light_color = Color.GREEN;
                        trafficBoard.setBackground(light_color);
                        new TrafficLight().repaint();
                        break;
                }
                if (Color.RED.equals(light_color)) {
                    car.stop();
                    car2.stop();
                } else if (Color.GREEN.equals(light_color)) {
                    car.set_xDir();
                    car.move(display.getSize());
                    car2.set_xDir2();
                    car2.moveToLeft(display.getSize());
                }
                countdownText.setText(String.valueOf(countdown));

            }
        }, 0, 1000);

        // frame-by-frame animation loop
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.move(display.getSize());
                car2.move(display.getSize());
                display.repaint();
//                display.repaint();
            }
        });
        timer.start();
    }

    public void threeWays(){
        Vehicle car3 = new Vehicle(500,540,35,70,Color.gray);
        Vehicle car4 = new Vehicle(585,-110,35,70,Color.yellow);
        Vehicle car5 = new Vehicle(100,200,70,35,Color.cyan);
        Vehicle car6 = new Vehicle(100,250,70,35,Color.orange);
        display.setCar3(car3);
        display.setCar4(car4);
        display.setCar5(car5);
        display.setCar6(car6);


        trafficBoard.setFocusable(true);
        trafficBoard.setPreferredSize(new Dimension(300, 80));
        trafficBoard.setBackground(Color.GREEN);
        trafficBoard.add(countdownText);
        frame.add(trafficBoard, BorderLayout.NORTH);

        trafficBoard2.setFocusable(true);
        trafficBoard2.setPreferredSize(new Dimension(80,600));
        trafficBoard2.setBackground(Color.GREEN);
//        trafficBoard2.add(countdownText);
        frame.add(trafficBoard2,BorderLayout.EAST);

        java.util.Timer timer2 = new java.util.Timer();
        timer2.scheduleAtFixedRate(new TimerTask() {
            Color light_color = Color.GREEN;
            int countDown = 3;

            @Override
            public void run() {
                countDown = countDown - 1;
                switch (countDown){
                    case -1:
                        light_color = Color.red;
                        trafficBoard.setBackground(light_color);
                        countDown = 14;
                        break;
                    case 7:
                        light_color = Color.GREEN;
                        trafficBoard.setBackground(light_color);
                        new TrafficLight().repaint();
                        break;
                }
                if (Color.red.equals(light_color)){
                    car3.stop();
                    car4.stop();
                    car5.set_xDir();
                    car6.set_xDir();

                    car5.move(display.getSize());

                    car6.move(display.getSize());
                }else if (Color.GREEN.equals(light_color)){
                    car3.set_yDir();
                    car3.moveToTop(display.getSize());
                    car4.set_yDir2();
                    car4.moveToBottom(display.getSize());
//                    car5.stop();
//                    car6.stop();
                }
                countdownText.setText(String.valueOf(countDown));
            }

        },0,1000);
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car3.moveToTop(display.getSize());
                car4.moveToBottom(display.getSize());
                car5.move(display.getSize());
                car6.move(display.getSize());
                display.repaint();
            }
        });
        timer.start();
    }

    public void showGUI(){
        frame.add(changeRoad, BorderLayout.SOUTH);
        frame.setSize(1000,800);
        frame.add(display, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.oneWay();
        main.threeWays();
        main.showGUI();
    }

}