package org.demo.birds.listener;

import org.demo.birds.jframe.BirdPanel;
import org.demo.birds.jframe.GameFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * 鼠标移动监听事件
 */
public class MouseMoveListener implements MouseMotionListener {
    private BirdPanel panel;
    private int width = GameFrame.DEFAULT_FRAME_WIDTH / 2;
    private int height = GameFrame.DEFAULT_FRAME_HEIGHT - 100;
    private double l = 30;

    public MouseMoveListener(BirdPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x0 = e.getX();
        int y0 = e.getY();
        double x = width - l * (width - x0) / (Math.sqrt((width - x0) * (width - x0) + (height - y0) * (height - y0)));
        double y = height - l * (height - y0) / (Math.sqrt((width - x0) * (width - x0) + (height - y0) * (height - y0)));
        this.panel.drawLine((int) x, (int) y);
    }

}