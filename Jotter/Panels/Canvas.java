package Jotter.Panels;

import javax.swing.*;
import Jotter.Shapes.Circle;
import Jotter.Shapes.Shape;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public final class Canvas extends Panel {

    private final List<Shape> shapes = new ArrayList<>();
    private Shape activeShape = null;

    public Canvas() {
        super(Color.WHITE, new Dimension(800, 600), BorderLayout.CENTER);
        setBorder(BorderFactory.createTitledBorder(this.toString()));

        initMouseListeners();
    }

    private void initMouseListeners() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (int i = shapes.size() - 1; i >= 0; i--) { // Start from top-most shape
                    Shape shape = shapes.get(i);

                    if (shape.isMouseNearEdge(e.getX(), e.getY())) {
                        bringToFront(shape);
                        activeShape = shape;
                        shape.setResizing(true);
                        repaint();
                        return;
                    } else if (shape.isInside(e.getX(), e.getY())) {
                        bringToFront(shape);
                        activeShape = shape;
                        shape.setDragging(true);
                        repaint();
                        return;
                    }
                }

                // ✅ Click outside: Create a new circle and bring it to front
                activeShape = new Circle(e.getX(), e.getY(), 30, Color.BLUE);
                shapes.add(activeShape);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (activeShape != null) {
                    activeShape.setResizing(false);
                    activeShape.setDragging(false);
                }
                activeShape = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (activeShape != null) {
                    if (activeShape.isResizing()) {
                        activeShape.resize(e.getX(), e.getY());
                    } else if (activeShape.isDragging()) {
                        activeShape.move(e.getX(), e.getY());
                    }
                    repaint();
                }
            }
        });
    }

    /**
     * ✅ Moves the given shape to the end of the list, making it the topmost shape.
     */
    private void bringToFront(Shape shape) {
        shapes.remove(shape);
        shapes.add(shape);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
    }

    @Override
    public Canvas getPanel() {
        return this;
    }

    @Override
    public String toString() {
        return "CANVAS";
    }
}
