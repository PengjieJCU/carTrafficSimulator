import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

public class TrafficLight extends JPanel {
    JLabel countdownboard = new JLabel();
    int number;

    public TrafficLight(){
//        setFocusable(true);
//        setPreferredSize(new Dimension(300,80));
//        setBackground(new Color(100,200,12));
//        add(countdownboard);

        Timer timer = new Timer();
        timer.schedule(new App(), 0, 1000);
    }

    class App extends TimerTask {
        int countdown = 10;

        public void run() {
            countdown = countdown - 1;
            System.out.println(countdown);
//            countdownboard.setText(String.valueOf(countdown));
            //label.setText(countdown +"second's left");
        }
    }

    public void paint(Graphics g){


//
//        if (number == 0){
//            System.out.println(countdownboard);
//        }
        g.fillRect(500,100,50,50);
        g.setColor(Color.RED);
    }




}


