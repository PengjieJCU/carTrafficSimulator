import java.awt.*;
import java.util.Random;

class Car {
    private int x,y;
    private int xDir, yDir;

    private int size;
    private Color color;

    private static final Random random = new Random();

    Car(int size, Color color) {
        x = 0;
        y = 0;
        xDir = 1;
        yDir = 0;
        this.size = size;
        this.color = color;
    }

//        void toggleMotion() {
//            if (xDir != 0) {
//                xDir = 0;
//            } else {
//                xDir = 10;
//            }
//            if (yDir != 0) {
//                yDir = 0;
//            } else {
//                yDir = 5;
//            }
//        }

        void move(Dimension size) {
        // update position based on current direction
        x = x + xDir;
        y = y + yDir;

        // move from left to right side
            if ((xDir > 0 && x+this.size/2 > 400)
                || (xDir < 0 && x-this.size/2 < 0)) {
            xDir = -1 * xDir;
        }

        // bounce on top or bottom edge
//        if ((yDir > 0 && y+this.size/2 > size.height)
//                || (yDir < 0 && y-this.size/2 < 0)) {
//            yDir = -1 * yDir;
//        }
    }

    void draw(Graphics graphics) {
//        int topLeftX = x;
//        int topLeftY = y ;
//        //int insetSize = 5 + random.nextInt(16);

        Graphics localGraphics = graphics.create(); // isolate changes here for: colour, transform, etc.
        localGraphics.setColor(color);
        localGraphics.fillRect(x, y,
                size , size );
        //localGraphics.drawOval(topLeftX, topLeftY, size, size);
        localGraphics.dispose();
    }
}
