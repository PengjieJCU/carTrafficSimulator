import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private Vehicle car;
    private Vehicle car2;
    private Vehicle car3;
    private Vehicle car4;
    private Vehicle car5;
    private Vehicle car6;
//    private static final Font font = new Font("Arial",Font.BOLD, 24);


    Display() {
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
    void setCar3(Vehicle car3){this.car3 = car3;}
    void setCar4(Vehicle car4){this.car4 = car4;}
    void setCar5(Vehicle car5){this.car5 = car5;}
    void setCar6(Vehicle car6){this.car6 = car6;}

    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

//        car.draw(graphics);
//        car2.draw(graphics);
        car3.draw(graphics);
        car4.draw(graphics);
        car5.draw(graphics);
        car6.draw(graphics);
//        new Road().paintOneway(graphics);
        new Road().paintThreeways(graphics);
        new TrafficLight().paint(graphics);


//        graphics.drawString("world", 200, 100);
//        graphics.fillRect(0,0,800,10);
//        graphics.setColor(Color.white);
    }

}
