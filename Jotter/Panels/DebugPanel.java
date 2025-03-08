package Jotter.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public final class DebugPanel extends Panel {

    private final static Color bgColor = Color.LIGHT_GRAY;
    private final static Dimension dim = new Dimension(0, 80);
    private final static String pos = BorderLayout.SOUTH;
    private final TitledBorder BORDER = new TitledBorder(new EtchedBorder(), this.toString());

    public DebugPanel() {
        super(bgColor, dim, pos);
        super.setBorder(BORDER);
    }

    @Override
    public DebugPanel getPanel() {
        return this;
    }

    @Override
    public String toString() {
        return "DEBG_PANEL";
    }
}
