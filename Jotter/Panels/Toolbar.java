package Jotter.Panels;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import Jotter.Buttons.Button;
import Jotter.Buttons.CircleButton;
import Jotter.Buttons.ColorButton;
import Jotter.Buttons.SquareButton;
import Jotter.Buttons.TriangleButton;
import java.awt.*;
import java.util.ArrayList;

public final class Toolbar extends Panel {

    private static final Color BG_COLOR = Color.LIGHT_GRAY;
    private static final Dimension DIMENSION = new Dimension(0, 105);
    private static final String POSITION = BorderLayout.NORTH;
    private final TitledBorder BORDER = new TitledBorder(new EtchedBorder(), this.toString());
    private ArrayList<Button> buttons = new ArrayList<>();

    public Toolbar() {
        super(BG_COLOR, DIMENSION, POSITION);
        super.setBorder(BORDER);
        super.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        this.buttons = initButtons();
        this.addButtons();
    }

    private ArrayList<Button> initButtons() {
        ArrayList<Button> tempButtons = new ArrayList<Button>();

        tempButtons.add(new CircleButton());
        tempButtons.add(new SquareButton());
        tempButtons.add(new TriangleButton());
        tempButtons.add(new ColorButton());

        return tempButtons;
    }

    private void addButtons() {
        buttons.forEach(this::add);
    }

    @Override
    public Toolbar getPanel() {
        return this;
    }

    @Override
    public String toString() {
        return "TOOLBAR";
    }
}
