package org.demo.birds.bean;

import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;

public class Bird {

    private int x, y;
    private int dx, dy = 30;
    private boolean dead = false, leave = false;

    public Bird(int x, int y, int dx) {
        this.x = x;
        this.y = y;
        this.dx = dx;
    }

    public void move(Rectangle2D bounds) {
        if (x >= bounds.getMaxX() + 200) {
            leave = true;
        }
        if (isDead()) {
            y += dy;
        }
        x += dx;
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, 30, 10);
    }

    public Image getImage() {
        ImageIcon icon = new ImageIcon("res/4.gif");
        return icon.getImage();
    }

    public int getImageX() {
        ImageIcon icon = new ImageIcon("res/4.gif");
        return icon.getIconWidth();
    }

    public int getImageY() {
        ImageIcon icon = new ImageIcon("res/4.gif");
        return icon.getIconHeight();
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isLeave() {
        return leave;
    }

    public void setLeave(boolean leave) {
        this.leave = leave;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
