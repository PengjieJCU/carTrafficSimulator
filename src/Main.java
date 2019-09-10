import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


// this is what an anonymous inner class does... kind of :)
//class Anon implements ActionListener {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CarTrafficSimulator");
        Display display = new Display();
        Car car = new Car(50, Color.RED);

        // frame-by-frame animation loop
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.move(display.getSize());

                display.repaint();

            }
        });
        timer.start();

//        display.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                System.out.println(e.getKeyCode());
//                if (e.getKeyCode() == 32) {
//                    car.toggleMotion();
//                }
//            }
//        });
        frame.setSize(800,800);
        frame.add(display);
        display.setCar(car);



        frame.setBackground(new Color(0,0,0));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
