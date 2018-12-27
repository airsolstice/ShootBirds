package org.demo.birds.bean;

import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * 鸟类实体
 */
public class Bird {

    /**
     * 坐标x，y
     */
    private int x, y;
    /**
     * x，y坐标变化标量
     */
    private int dx, dy = 30;
    /**
     * 鸟标志
     */
    private boolean dead = false, leave = false;

    public Bird(int x, int y, int dx) {
        this.x = x;
        this.y = y;
        this.dx = dx;
    }

    /**
     * 一个间隔周期，鸟移动一个固定长度
     * @param bounds
     */
    public void move(Rectangle2D bounds) {
        if (x >= bounds.getMaxX() + 200) {
            leave = true;
        }
        if (isDead()) {
            y += dy;
        }
        x += dx;
    }

    /**
     * 获取鸟头顶靶子
     */
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, 30, 10);
    }

    /**
     * 获取鸟图片
     */
    public Image getImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/bird1.png"));
        return icon.getImage();
    }

    /**
     * 获取鸟图片
     */
    public int getImageX() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/bird1.png"));
        return icon.getIconWidth();
    }

    /**
     * 获取鸟图片
     */
    public int getImageY() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/bird1.png"));
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
