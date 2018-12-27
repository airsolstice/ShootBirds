package org.demo.birds.listener;

import org.demo.birds.bean.Bird;
import org.demo.birds.bean.Bullet;
import org.demo.birds.jframe.BirdPanel;
import org.demo.birds.jframe.GameFrame;
import org.demo.birds.runnable.GunShootRunnable;
import org.demo.birds.runnable.GunSoundRunnable;

import java.awt.event.*;
import java.util.List;
import javax.swing.JOptionPane;

public class MouseClickListener extends MouseAdapter {

    private BirdPanel panel;
    private int width = GameFrame.DEFAULT_FRAME_WIDTH / 2;
    private int height = GameFrame.DEFAULT_FRAME_HEIGHT - 100;
    private List<Bird> list;

    public MouseClickListener(BirdPanel panel) {
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
                GunSoundRunnable rr = new GunSoundRunnable();
                Thread tt1 = new Thread(rr);
                tt1.start();

                GunShootRunnable gpt = new GunShootRunnable(panel, x, y);
                Thread tt2 = new Thread(gpt);
                tt2.start();

            } else {
                JOptionPane.showMessageDialog(null, "子弹打光");
//                Thread.currentThread().destroy();
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
