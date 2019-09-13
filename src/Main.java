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
        trafficBoard.setBackground(color[0]);
        trafficBoard.add(countdownText);

        //TrafficLight trafficLight = new TrafficLight();
        Vehicle car = new Vehicle(100,150,70, 35, Color.RED);

        java.util.Timer timer2 = new java.util.Timer();

        timer2.scheduleAtFixedRate(new TimerTask() {
            int countdown = 3;
            @Override
            public void run() {

                countdown = countdown - 1;

                if(countdown == -1){
                    countdown = 3;
                    trafficBoard.setBackground(Color.RED);
                    car.stop();
                    if(countdown == -1){
                        car.move(display.getSize());
                        new TrafficLight().repaint();
                    }
                }




                countdownText.setText(String.valueOf(countdown));

            }
        },0,1000);



        // frame-by-frame animation loop
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.move(display.getSize());
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
