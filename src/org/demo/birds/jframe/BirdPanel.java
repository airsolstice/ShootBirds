package org.demo.birds.jframe;

import org.demo.birds.bean.Bird;
import org.demo.birds.listener.MouseClickListener;
import org.demo.birds.listener.MouseMoveListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

public class BirdPanel extends JPanel {
    private int x1 = GameFrame.DEFAULT_FRAME_WIDTH / 2;
    private int y1 = GameFrame.DEFAULT_FRAME_HEIGHT - 100;
    private int x2 = GameFrame.DEFAULT_FRAME_WIDTH / 2;
    private int y2 = GameFrame.DEFAULT_FRAME_HEIGHT - 120;
    private int x3 = x1;
    private int y3 = y1;

    private int width = 100;
    private int height = 100;

    private List<Bird> birds = Collections.synchronizedList(new ArrayList<>());

    public BirdPanel() {
        this.addMouseListener(new MouseClickListener(this));
        this.addMouseMotionListener(new MouseMoveListener(this));
        this.setLayout(null);
    }

    public void add(Bird b) {
        birds.add(b);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("res/background.png");

        this.setBackground(Color.BLUE);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(icon.getImage(), 0, 0, icon.getIconWidth(), icon.getIconHeight(), Color.CYAN, this);
        g2.setStroke(new BasicStroke(5.0f));
        g2.setColor(new Color(112, 112, 112));
        ImageIcon airplane = new ImageIcon("res/airplane.png");
        g2.drawImage(airplane.getImage(), x1 - width / 2, y1 - height + 10, width, height, this);
        g2.fillOval(x1 - 8, y1 - 58, 16, 16);
        g2.drawLine(x1, y1 - 50, x2, y2 - 70);
        g2.drawOval(x3 - 5, y3 - 55, 10, 10);

        for (int i = 0; i < birds.size(); i++) {
            Bird b = birds.get(i);
            if (!b.isLeave()) {
                g2.fill(b.getShape());
                g2.drawImage(b.getImage(), b.getX(), b.getY(), b.getImageX(), b.getImageY(), this);
            }
        }
    }

    public List<Bird> getList() {
        return birds;
    }

    public void drawLine(int x, int y) {
        x2 = x;
        y2 = y;
        repaint();
    }

    public void drawOval(int x, int y) {
        x3 = x;
        y3 = y;
        repaint();
    }
}
