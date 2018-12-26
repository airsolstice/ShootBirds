package org.demo.birds;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MouseListener extends MouseAdapter {

    private BirdPanel panel;
    private int width = GameFrame.DEFAULT_FRAME_WIDTH / 2;
    private int height = GameFrame.DEFAULT_FRAME_HEIGHT - 100;
    private ArrayList<Bird> list;

    public MouseListener(BirdPanel panel) {
        this.panel = panel;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 1) {
            list = panel.getList();
            Bullet.getInstance().setNum();
            int num = Bullet.getInstance().getNum();
            int y = evt.getY();
            int x = evt.getX();
            if(y >= height){
                return;
            }

            if (num > 0) {
                GunSoundThread rr = new GunSoundThread();
                Thread tt1 = new Thread(rr);
                tt1.start();

                GunPlayerThread gpt = new GunPlayerThread(panel, x, y);
                Thread tt2 = new Thread(gpt);
                tt2.start();

            } else {
                JOptionPane.showMessageDialog(null, "子弹打光");
                Thread.currentThread().destroy();
            }


            for (Bird b : list) {
                int x1 = b.getX();
                int x2 = x1 + 50;
                int y3 = b.getY();

                int x3 = width - (height - y3) * (width - x) / (height - y);
                if (x3 >= x1 && x3 <= x2) {
                    b.setDead(true);
                }
            }
        }
    }

}

class MouseMove implements MouseMotionListener {
    private BirdPanel panel;
    private int width = GameFrame.DEFAULT_FRAME_WIDTH / 2;
    private int height = GameFrame.DEFAULT_FRAME_HEIGHT - 100;
    private double l = 15;

    public MouseMove(BirdPanel panel) {
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