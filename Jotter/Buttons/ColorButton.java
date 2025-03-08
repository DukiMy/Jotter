package Jotter.Buttons;

import java.awt.Color;
import javax.swing.ImageIcon;
import static javax.swing.JColorChooser.showDialog;
import static java.awt.Color.WHITE;

public final class ColorButton extends Button {
    
    private static final String IMG_PATH = "Resources/COLOR_ICON.png";
    private static final boolean IS_STICKY = false;

    public ColorButton() {
        super.setIcon(new ImageIcon(IMG_PATH));
        super.setIsSticky(IS_STICKY);
    }

    @Override
    protected void action() {
        Color previousColor = super.getSelectedColor();

        // Kallar på dialogruta som returnar vald färg
        super.setSelectedColor(
            showDialog(null, "Pick a Color", WHITE)
        );

        // Sätter senast valda färg ifall användare inte gör ett färgval.
        if (super.getSelectedColor() == null) {
            super.setSelectedColor(previousColor);
        }

        super.reInitBackground();
    }

    @Override 
    public String toString() {
        return String.format(
            "Color button, selected color: %s",
            super.getSelectedColor()
        );
    }
}
