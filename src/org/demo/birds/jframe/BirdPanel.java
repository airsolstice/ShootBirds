package org.demo.birds.jframe;

import org.demo.birds.bean.Bird;
import org.demo.birds.listener.MouseClickListener;
import org.demo.birds.listener.MouseMoveListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

/**
 * 游戏画板
 */
public class BirdPanel extends JPanel {

    /**
     * 炮弹基底坐标
     */
    private int x1 = GameFrame.DEFAULT_FRAME_WIDTH / 2;
    private int y1 = GameFrame.DEFAULT_FRAME_HEIGHT - 100;
    /**
     * 初始枪口坐标
     */
    private int x2 = GameFrame.DEFAULT_FRAME_WIDTH / 2;
    private int y2 = GameFrame.DEFAULT_FRAME_HEIGHT - 120;
    /**
     * 子弹初始坐标
     */
    private int x3 = x1;
    private int y3 = y1;

    /**
     * 飞机大小
     */
    private int width = 150;
    private int height = 150;

    /**
     * 鸟容器，为了防止多线程并发错误，加上安全锁
     */
    private List<Bird> birds = Collections.synchronizedList(new ArrayList<>());

    public BirdPanel() {
        this.addMouseListener(new MouseClickListener(this));
        this.addMouseMotionListener(new MouseMoveListener(this));
        this.setLayout(null);
    }

    /**
     * 添加一只鸟到画板
     */
    public void add(Bird b) {
        birds.add(b);
    }

    /**
     * 绘制画板
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // 绘制背景
        ImageIcon icon = new ImageIcon(getClass().getResource("/background.png"));
        this.setBackground(Color.BLUE);
        g2.drawImage(icon.getImage(), 0, 0, icon.getIconWidth(), icon.getIconHeight(), Color.CYAN, this);


        // 绘制飞机
        ImageIcon airplane = new ImageIcon(getClass().getResource("/airplane.png"));
        g2.drawImage(airplane.getImage(), x1 - width / 2, y1 - height + 10, width, height, this);

        // 绘制枪底座
        g2.fillOval(x1 - 8, y1 - 58, 16, 16);

        // 绘制枪筒
        g2.setStroke(new BasicStroke(5.0f));
        g2.setColor(new Color(112, 112, 112));
        g2.drawLine(x1, y1 - 50, x2, y2 - 70);

        // 绘制子弹
        g2.drawOval(x3 - 5, y3 - 55, 10, 10);

        // 绘制鸟
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

    /**
     * 重绘枪筒
     * @param x
     * @param y
     */
    public void drawLine(int x, int y) {
        x2 = x;
        y2 = y;
        repaint();
    }

    /**
     *  重绘子弹
     * @param x
     * @param y
     */
    public void drawOval(int x, int y) {
        x3 = x;
        y3 = y;
        repaint();
    }
}
