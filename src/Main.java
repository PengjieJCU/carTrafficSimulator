import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;


public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CarTrafficSimulator");
        Display display = new Display();
        JPanel trafficBoard = new JPanel();
        JLabel countdownText = new JLabel();
        final Color[] color = {new Color(0, 255, 0)};



        trafficBoard.setFocusable(true);
        trafficBoard.setPreferredSize(new Dimension(300,80));
        trafficBoard.setBackground(Color.GREEN);
        trafficBoard.add(countdownText);




        //TrafficLight trafficLight = new TrafficLight();
        Vehicle car = new Vehicle(100,150,70, 35, Color.RED);
//        Vehicle car2 = new Vehicle(180,300, 70,35, Color.BLUE);

        java.util.Timer timer2 = new java.util.Timer();

        timer2.scheduleAtFixedRate(new TimerTask() {
            Color light_color = Color.GREEN;
            int countdown = 3;
            @Override
            public void run() {

                countdown = countdown - 1;
                switch (countdown){
                    case -1:
                        light_color = Color.RED;
                        trafficBoard.setBackground(light_color);
                        countdown = 12;
                        break;
                    case 6:
                        light_color = Color.GREEN;
                        trafficBoard.setBackground(light_color);
                        new TrafficLight().repaint();
                        break;
                }
                if (Color.RED.equals(light_color)) {
                    car.stop();
//                    car2.stop();
                } else if (Color.GREEN.equals(light_color)) {
                    car.set_xDir();
                    car.move(display.getSize());
//                    car2.set_xDir();
//                    car2.move(display.getSize());
                }



//                if(countdown == -1) {
//                    trafficBoard.setBackground(Color.RED);
//                    car.stop();
//                    countdown = 3;
//                    if (countdown == 1){
//                        trafficBoard.setBackground(Color.GREEN);
//                        car.move(display.getSize());
//                        new TrafficLight().repaint();
//                    }
//                }
                countdownText.setText(String.valueOf(countdown));

            }
        },0,1000);



        // frame-by-frame animation loop
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.move(display.getSize());
//                car2.move(display.getSize());
                display.repaint();

            }
        });
        timer.start();

        frame.setSize(1000,800);
        frame.add(display, BorderLayout.CENTER);
        frame.add(trafficBoard, BorderLayout.NORTH);

        //frame.add(trafficLight,BorderLayout.WEST);
        display.setCar(car);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }





}