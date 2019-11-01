import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;


public class Main{
    JFrame frame = new JFrame("CarTrafficSimulator");
    CarsInThreeWaysRoad threeWays = new CarsInThreeWaysRoad();
    CarsInOneWayRoad oneway = new CarsInOneWayRoad();
    CarsInFourWaysRoad fourWays = new CarsInFourWaysRoad();
    //    CarsInThreeWaysRoad display1 = new CarsInThreeWaysRoad();
    JPanel trafficBoard = new JPanel();
    JPanel trafficBoard2 = new JPanel();
    JLabel countdownText = new JLabel();
    JPanel buttonPanel = new JPanel();

    JButton oneRoadMode = new JButton("One road mode");
    JButton threeRoadsMode = new JButton("Three roads mode");
    JButton fourRoadsMode = new JButton("Four roads mode");
    final Color[] color = {new Color(0, 255, 0)};

    public void oneWay() {
        frame.remove(threeWays);
        frame.remove(fourWays);
        frame.remove(trafficBoard);
        frame.remove(trafficBoard2);

        VehicleMoving car = new VehicleMoving(100, 150, 70, 35, Color.RED);
        VehicleMoving car2 = new VehicleMoving(850, 100, 70, 35, Color.BLUE);
        //frame.add(trafficLight,BorderLayout.WEST);
        oneway.setCar(car);
        oneway.setCar2(car2);

        trafficBoard.setFocusable(true);
        trafficBoard.setPreferredSize(new Dimension(300, 80));
        trafficBoard.setBackground(Color.GREEN);
        trafficBoard.add(countdownText);
        frame.add(trafficBoard, BorderLayout.NORTH);

        //TrafficLight trafficLight = new TrafficLight();

        java.util.Timer timer1 = new java.util.Timer();

        timer1.scheduleAtFixedRate(new TimerTask() {
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
                    car.oneWayMove(threeWays.getSize());
                    car2.set_xDir2();
                    car2.moveToLeft(threeWays.getSize());
                }
                countdownText.setText(String.valueOf(countdown));

            }
        }, 0, 1000);

        // frame-by-frame animation loop
        Timer timer_2 = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.oneWayMove(oneway.getSize());
                car2.moveToLeft(oneway.getSize());
                oneway.repaint();
            }
        });

        timer_2.start();
        frame.add(oneway, BorderLayout.CENTER);
//        timer1.cancel();
//        timer_2.start();
    }

    public void threeWays() {
        frame.remove(oneway);
        frame.remove(fourWays);
        frame.remove(trafficBoard);
        frame.remove(trafficBoard2);
        VehicleMoving car3 = new VehicleMoving(500, 510, 35, 70, Color.gray);
        VehicleMoving car4 = new VehicleMoving(585, -160, 35, 70, Color.yellow);
        VehicleMoving car5 = new VehicleMoving(180, 200, 70, 35, Color.cyan);
        VehicleMoving car6 = new VehicleMoving(100, 200, 70, 35, Color.orange);
        VehicleMoving car7 = new VehicleMoving(500, 600, 35, 70, Color.BLUE);
        VehicleMoving car8 = new VehicleMoving(585, -80, 35, 70, Color.red);
        threeWays.setCar3(car3);
        threeWays.setCar4(car4);
        threeWays.setCar5(car5);
        threeWays.setCar6(car6);
        threeWays.setCar7(car7);
        threeWays.setCar8(car8);


        trafficBoard.setFocusable(true);
        trafficBoard.setPreferredSize(new Dimension(300, 80));
        trafficBoard.setBackground(Color.GREEN);
        trafficBoard.add(countdownText);
        frame.add(trafficBoard, BorderLayout.NORTH);

        trafficBoard2.setFocusable(true);
        trafficBoard2.setPreferredSize(new Dimension(80, 600));
        trafficBoard2.setBackground(Color.GREEN);
//        trafficBoard2.add(countdownText);
        frame.add(trafficBoard2, BorderLayout.EAST);

        java.util.Timer timer2 = new java.util.Timer();
        timer2.scheduleAtFixedRate(new TimerTask() {
            Color light_color = Color.GREEN;
            int countDown = 3;

            @Override
            public void run() {
                countDown = countDown - 1;
                switch (countDown) {
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
                if (Color.red.equals(light_color)) {
                    car3.stop();
                    car4.stop();
                    car5.set_xDir();
                    car6.set_xDir();
                    car5.move(threeWays.getSize());
                    car6.moveToRightAndBottom(threeWays.getSize());
                    car7.stop();
                    car8.stop();
                } else if (Color.GREEN.equals(light_color)) {
                    car3.set_yDir();
                    car3.moveToTop(threeWays.getSize());
                    car4.set_yDir2();
                    car4.moveToBottom(threeWays.getSize());
                    car7.set_yDir2();
                    car7.moveToTopAndLeft(threeWays.getSize());
                    car8.set_yDir();
                    car8.moveToBottonAndLeft(threeWays.getSize());
//                    car5.stop();
//                    car6.stop();
                }
                countdownText.setText(String.valueOf(countDown));
            }

        }, 0, 1000);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car3.moveToTop(threeWays.getSize());
                car4.moveToBottom(threeWays.getSize());
                car5.move(threeWays.getSize());
                car6.moveToRightAndBottom(threeWays.getSize());
                car7.moveToTopAndLeft(threeWays.getSize());
                car8.moveToBottonAndLeft(threeWays.getSize());
                threeWays.repaint();
            }
        });
        timer.start();
        frame.add(threeWays, BorderLayout.CENTER);
//        timer2.cancel();
//        timer.start();
    }

    public void fourWays(){
        frame.remove(oneway);
        frame.remove(threeWays);
        frame.remove(trafficBoard);
        frame.remove(trafficBoard2);
        VehicleMoving car9 = new VehicleMoving(500, 510, 35, 70, Color.gray);
        VehicleMoving car10 = new VehicleMoving(585, -160, 35, 70, Color.yellow);
        VehicleMoving car11 = new VehicleMoving(180, 200, 70, 35, Color.cyan);
        VehicleMoving car12 = new VehicleMoving(100, 200, 70, 35, Color.orange);
        VehicleMoving car13 = new VehicleMoving(500, 600, 35, 70, Color.BLUE);
        VehicleMoving car14 = new VehicleMoving(585, -80, 35, 70, Color.red);
        VehicleMoving car15 = new VehicleMoving(20,200,70,35,Color.magenta);
//        VehicleMoving car16 = new VehicleMoving(500,520,35,70,Color.cyan);
//        VehicleMoving car9 = new VehicleMoving()
        fourWays.setCar9(car9);
        fourWays.setCar10(car10);
        fourWays.setCar11(car11);
        fourWays.setCar12(car12);
        fourWays.setCar13(car13);
        fourWays.setCar14(car14);
        fourWays.setCar15(car15);
//        fourWays.setCar16(car16);


        trafficBoard.setFocusable(true);
        trafficBoard.setPreferredSize(new Dimension(300, 80));
        trafficBoard.setBackground(Color.GREEN);
        trafficBoard.add(countdownText);
        frame.add(trafficBoard, BorderLayout.NORTH);

        trafficBoard2.setFocusable(true);
        trafficBoard2.setPreferredSize(new Dimension(80, 600));
        trafficBoard2.setBackground(Color.GREEN);
//        trafficBoard2.add(countdownText);
        frame.add(trafficBoard2, BorderLayout.EAST);

        java.util.Timer timer2 = new java.util.Timer();
        timer2.scheduleAtFixedRate(new TimerTask() {
            Color light_color = Color.GREEN;
            int countDown = 3;

            @Override
            public void run() {
                countDown = countDown - 1;
                switch (countDown) {
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
                if (Color.red.equals(light_color)) {
                    car9.stop();
                    car10.stop();
                    car11.set_xDir();
                    car12.set_xDir();
                    car11.move(fourWays.getSize());
                    car12.moveToRightAndBottom(fourWays.getSize());
                    car13.stop();
                    car14.stop();
//                    car16.stop();
                } else if (Color.GREEN.equals(light_color)) {
                    car9.set_yDir();
                    car9.moveToTop(fourWays.getSize());
                    car10.set_yDir2();
                    car10.moveToBottom(fourWays.getSize());
                    car13.set_yDir2();
                    car13.moveToTopAndLeft(fourWays.getSize());
                    car14.set_yDir();
                    car14.moveToBottonAndLeft(fourWays.getSize());
                    car15.set_xDir();
                    car15.moveToLeft(fourWays.getSize());
//                    car16.set_yDir2();
//                    car16.moveToTopAndRight(fourWays.getSize());
//                    car11.stop();
//                    car12.stop();
                }
                countdownText.setText(String.valueOf(countDown));
            }

        }, 0, 1000);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car9.moveToTop(fourWays.getSize());
                car10.moveToBottom(fourWays.getSize());
                car11.move(fourWays.getSize());
                car12.moveToRightAndBottom(fourWays.getSize());
                car13.moveToTopAndLeft(fourWays.getSize());
                car14.moveToBottonAndLeft(fourWays.getSize());
                car15.moveToLeft(fourWays.getSize());
//                car16.moveToTopAndRight(fourWays.getSize());
                fourWays.repaint();
            }
        });
        timer.start();
        frame.add(fourWays, BorderLayout.CENTER);
    }
    public void showGUI() {
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(oneRoadMode);
        buttonPanel.add(threeRoadsMode);
        buttonPanel.add(fourRoadsMode);
        frame.add(buttonPanel, "South");
        oneRoadMode.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 26));
        threeRoadsMode.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 26));
        fourRoadsMode.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 26));

        oneRoadMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Switch to One Way");
                oneWay();
            }
        });

        threeRoadsMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Switch to 3 Ways");
                threeWays();
            }
        });

        fourRoadsMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Switch to 4 ways");
                fourWays();
            }
        });

        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.oneWay();
//        main.CarsInThreeWaysRoad();
        main.fourWays();
        main.showGUI();
    }
}