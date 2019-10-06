import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private Vehicle car;
    private Vehicle car1;
//    private static final Font font = new Font("Arial",Font.BOLD, 24);


    Display() {
        setFocusable(true); // is false by default...
        setPreferredSize(new Dimension(800,200));
        setBackground(new Color(220,200,250));
    }

    void setCar(Vehicle car) {
        this.car = car;
    }

    void setCar1(Vehicle car1){
        this.car1 = car1;
    }

    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        car.draw(graphics);
        car1.draw(graphics);
        new Road().paintOneway(graphics);
        new TrafficLight().paint(graphics);


//        graphics.drawString("world", 200, 100);
//        graphics.fillRect(0,0,800,10);
//        graphics.setColor(Color.white);
    }

}
