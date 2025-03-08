package Jotter.Buttons;

import javax.swing.ImageIcon;

public final class CircleButton extends Button {

    private static final String IMG_PATH = "Resources/CIRCLE_ICON.png";
    private static final boolean IS_STICKY = true;

    public CircleButton() {
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
            "Circle button, selected color: %s",
            super.getSelectedColor()
        );
    }
}
