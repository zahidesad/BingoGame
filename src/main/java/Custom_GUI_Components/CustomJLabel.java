package Custom_GUI_Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CustomJLabel extends JLabel {

    private Color color = Color.WHITE;
    private Color borderColor = new Color(30, 136, 56);
    private int radius = 0;

    public CustomJLabel() {
       //setContentAreaFilled(false); // Remove default background
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Paint background
        g2.setColor(color);
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        // Paint text (inherited from JLabel)
        super.paintComponent(g);
    }
}
