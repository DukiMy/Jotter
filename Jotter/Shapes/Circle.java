package Jotter.Shapes;

import java.awt.*;

public class Circle extends Shape {

    public Circle(int x, int y, int radius, Color color) {
        super(x - radius, y - radius, radius * 2, radius * 2, color);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
        g.drawOval(x, y, width, height);
    }

    @Override
    public boolean isMouseNearEdge(int mx, int my) {
        int centerX = x + width / 2;
        int centerY = y + height / 2;
        int radius = width / 2;
        double distance = Math.sqrt(Math.pow(mx - centerX, 2) + Math.pow(my - centerY, 2));
        return Math.abs(distance - radius) < BORDER_MARGIN;
    }

    @Override
    public boolean isInside(int mx, int my) {
        int centerX = x + width / 2;
        int centerY = y + height / 2;
        int radius = width / 2;
        double distance = Math.sqrt(Math.pow(mx - centerX, 2) + Math.pow(my - centerY, 2));
        return distance < radius;
    }

    @Override
    public void resize(int mx, int my) {
        int centerX = x + width / 2;
        int centerY = y + height / 2;

        int newRadius = (int) Math.sqrt(Math.pow(mx - centerX, 2) + Math.pow(my - centerY, 2));

        x = centerX - newRadius;
        y = centerY - newRadius;
        width = height = newRadius * 2;
    }
}
