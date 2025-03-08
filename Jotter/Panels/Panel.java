package Jotter.Panels;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

 public abstract class Panel extends JPanel {

    private String position;

    protected Panel(Color bgColor, Dimension dim, String position) {
        super.setBackground(bgColor);
        super.setPreferredSize(dim);
        this.position = position;
    }

    public abstract Panel getPanel();

    public String getPosition() {
        return position;
    }
 }
 