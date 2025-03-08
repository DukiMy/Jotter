package Jotter.Buttons;

import javax.swing.ImageIcon;

public final class TriangleButton extends Button {

    private static final String IMG_PATH = "Resources/TRIANGLE_ICON.png";
    private static final boolean IS_STICKY = true;

    public TriangleButton() {
        super.setIcon(new ImageIcon(IMG_PATH));
        super.setIsSticky(IS_STICKY);
    }

    @Override
    protected void action() {
        super.reInitBackground();
    }

    @Override 
    public String toString() {
        return String.format(
            "Triangle button, selected color: %s",
            super.getSelectedColor()
        );
    }
}