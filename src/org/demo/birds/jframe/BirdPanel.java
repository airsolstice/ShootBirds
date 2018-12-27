package org.demo.birds.jframe;

import org.demo.birds.bean.Bird;
import org.demo.birds.listener.MouseClickListener;
import org.demo.birds.listener.MouseMoveListener;

import java.awt.*;
import java.util.ArrayList;
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
    private ArrayList<Bird> birds = new ArrayList<Bird>();

    public BirdPanel() {
        MouseClickListener clickListener = new MouseClickListener(this);
        MouseMoveListener moveListener = new MouseMoveListener(this);
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(moveListener);
        this.setLayout(null);
    }

    public void add(Bird b) {
        birds.add(b);
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("res/background.jpg");

        this.setBackground(Color.BLUE);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(icon.getImage(), 0, 0, icon.getIconWidth(), icon.getIconHeight(), Color.CYAN, this);
        g2.setStroke(new BasicStroke(5.0f));
        g2.setColor(Color.BLUE);
        g2.drawLine(x1, y1, x2, y2);
        g2.drawOval(x3-5, y3-5, 10,10);
        ImageIcon airplane = new ImageIcon("res/airplane.png");
        g2.drawImage(airplane.getImage(), x1 - width / 2, y1 - height + 10, width, height, this);

        for (Bird b : birds) {
            if (!b.isLeave()){
                g2.fill(b.getShape());
                g2.drawImage(b.getImage(), b.getX(), b.getY(), b.getImageX(), b.getImageY(), this);
            }
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

    public void drawOval(int x, int y){
        x3 = x;
        y3 = y;
        repaint();
    }
}
