package Jotter.Buttons;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.BorderFactory.createBevelBorder;
import static javax.swing.border.BevelBorder.RAISED;
import static javax.swing.border.BevelBorder.LOWERED;
import static java.awt.Color.LIGHT_GRAY;

public abstract class Button extends JButton {

    private static Button selectedShape = null;
    private static Color selectedColor = null;
    private static MouseAdapter mouseListener = null;
    private boolean isSticky = true;

    public Button() {
        this.initStyle();
        this.initMouseListener();
        super.addMouseListener(mouseListener);
    }

    private void initStyle() {
        this.setPreferredSize(new Dimension(80, 80));
        this.setBorder(createBevelBorder(RAISED));
        this.setContentAreaFilled(true);
        this.setBackground(LIGHT_GRAY);
    }

    public Button getSelectedShape() {
        return selectedShape;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color color) {
        selectedColor = color;
    }

    protected void setIsSticky(boolean isSticky) {
        this.isSticky = isSticky;
    }

    protected void reInitBackground() {
        this.setBackground(selectedColor);
    }

    private void initMouseListener() {
        mouseListener = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent evt) {
                // Återställer senast använda knapp
                if (selectedShape != null && selectedShape != Button.this) { 
                    selectedShape.setBorder(createBevelBorder(RAISED));
                    selectedShape.setBackground(LIGHT_GRAY);
                }

                // Anger vald knapp
                selectedShape = Button.this;
                selectedShape.setBorder(createBevelBorder(LOWERED));
            }
            
            @Override
            public void mouseReleased(MouseEvent evt) {

                // Trycker upp knapp där IS_STICKY == false
                if (Button.this.isSticky == false) {
                    selectedShape.setBorder(createBevelBorder(RAISED));
                }

                // action blockerar eventet om action() sätts i mousePressed.
                action();

                System.out.println(Button.this);
            }
        };
    }

    protected abstract void action();
}
