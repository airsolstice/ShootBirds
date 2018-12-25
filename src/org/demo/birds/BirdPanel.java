package org.demo.birds;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class BirdPanel extends JPanel {
    private int x1 = 130, y1 = 260, x2 = 130, y2 = 260;
    private ArrayList<Bird> birds = new ArrayList<Bird>();

    public BirdPanel() {
        MouseListener listener = new MouseListener(this);
        MouseMove move = new MouseMove(this);
        this.addMouseListener(listener);
        this.addMouseMotionListener(move);
    }

    public void add(Bird b) {
        birds.add(b);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("res/background.jpg");

        this.setBackground(Color.BLUE);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(icon.getImage(), 0, 0, icon.getIconWidth(), icon.getIconHeight(), Color.CYAN, this);
        g2.setStroke(new BasicStroke(10.0f));
        g2.setColor(Color.GRAY);
        g2.drawLine(x1, y1, x2, y2);


        for (Bird b : birds) {
            if (!b.isLeave())
                g2.fill(b.getShape());
                g2.drawImage(b.getImage(), b.getX(), b.getY(), b.getImageX(), b.getImageY(), this);
        }
    }

    public ArrayList<Bird> getList() {
        return birds;
    }

    public void drawLine(int x, int y) {
        x2 = x;
        y2 = y;
        repaint();
    }

}
