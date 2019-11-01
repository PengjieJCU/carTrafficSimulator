import javax.swing.*;
import java.awt.*;

public class OneWayRoad extends JPanel {
    private Vehicle car;
    private Vehicle car2;

    OneWayRoad() {
        setFocusable(true); // is false by default...
        setPreferredSize(new Dimension(800,200));
        setBackground(new Color(220,200,250));
    }

    void setCar(Vehicle car) {
        this.car = car;
    }
    void setCar2(Vehicle car2){
        this.car2 = car2;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        car.draw(graphics);
        car2.draw(graphics);

        new Road().paintOneway(graphics);
        new TrafficLight().paint(graphics);

    }

}
