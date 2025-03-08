package Jotter.Shapes;

import java.awt.*;

public abstract class Shape {

    protected int x, y, width, height;
    protected boolean isResizing = false;
    protected boolean isDragging = false;
    protected static final int BORDER_MARGIN = 5;
    protected Color color;

    public Shape(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public abstract void draw(Graphics2D g);
    public abstract boolean isMouseNearEdge(int mx, int my);
    public abstract boolean isInside(int mx, int my);
    public abstract void resize(int mx, int my);

    public void move(int mx, int my) {
        this.x = mx - width / 2;
        this.y = my - height / 2;
    }

    public void setResizing(boolean resizing) {
        isResizing = resizing;
    }

    public void setDragging(boolean dragging) {
        isDragging = dragging;
    }

    public boolean isResizing() {
        return isResizing;
    }

    public boolean isDragging() {
        return isDragging;
    }
}
