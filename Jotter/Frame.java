package Jotter;

import javax.swing.JFrame;
import Jotter.Panels.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

final class Frame extends JFrame {

    private static final Toolbar TOOLBAR = new Toolbar();
    private static final Canvas CANVAS = new Canvas();
    private static final DebugPanel DEBUG_PANEL = new DebugPanel();

    private Frame() {
        super.setMinimumSize(new Dimension(600, 400));
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setTitle(this.toString());
        super.add(TOOLBAR, TOOLBAR.getPosition());
        super.add(CANVAS, CANVAS.getPosition());
        super.add(DEBUG_PANEL, DEBUG_PANEL.getPosition());
        super.setVisible(true);
    }

    @Override
    public String toString() {
        return "CIRKELGÅNG";
    }

    public static void main(String[] args) {
        new Frame();
    }
}
