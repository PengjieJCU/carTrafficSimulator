import javax.swing.*;
import java.awt.*;

public class FourWaysRoad extends JPanel {
    private Vehicle car9;
    private Vehicle car10;
    private Vehicle car11;
    private Vehicle car12;
    private Vehicle car13;
    private Vehicle car14;
    private Vehicle car15;


    FourWaysRoad() {
        setFocusable(true); // is false by default...
        setPreferredSize(new Dimension(800,200));
        setBackground(new Color(220,200,250));
    }

    void setCar9(Vehicle car9){this.car9 = car9;}
    void setCar10(Vehicle car10){this.car10 = car10;}
    void setCar11(Vehicle car11){this.car11 = car11;}
    void setCar12(Vehicle car12){this.car12 = car12;}
    void setCar13(Vehicle car13){this.car13 = car13;}
    void setCar14(Vehicle car14){this.car14 = car14;}
    void setCar15(Vehicle car15){this.car15 = car15;}

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        car9.draw(graphics);
        car10.draw(graphics);
        car11.draw(graphics);
        car12.draw(graphics);
        car13.draw(graphics);
        car14.draw(graphics);
        car15.draw(graphics);

        new Road().paintFourWays(graphics);
        new TrafficLight().paint(graphics);
    }
}
