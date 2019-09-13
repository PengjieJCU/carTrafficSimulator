import java.awt.*;
import java.util.Random;

class Vehicle {
    private int x,y;
    private int xDir, yDir;

    private int width;
    private int length;
    private Color color;

    private static final Random random = new Random();

    Vehicle(int x, int y, int width, int length, Color color) {
        xDir = 1;
        yDir = 0;
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.color = color;
    }

    void stop(){
        //if (x == 350){
        xDir = 0;
        yDir = 0;}
    //}

    void move(Dimension size) {
        // update position based on current direction
        x = x + xDir;
        y = y + yDir;


        // move from left to right side
        if ((xDir > 0 && x+this.width /2 > 800)
                || (xDir < 0 && x-this.width /2 < 0))
        {
            xDir = -1 * xDir;

        }
    }

    void draw(Graphics graphics) {
        Graphics localGraphics = graphics.create(); // isolate changes here for: colour, transform, etc.
        localGraphics.setColor(color);
        localGraphics.fillRect(x, y, width, length);
        //localGraphics.drawOval(topLeftX, topLeftY, width, width);
        localGraphics.dispose();
    }
}