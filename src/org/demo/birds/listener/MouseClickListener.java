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

/**
 * 鼠标点击事件监听
 */
public class MouseClickListener extends MouseAdapter {

    private BirdPanel panel;
    /**
     * 炮台底座坐标
     */
    private int width = GameFrame.DEFAULT_FRAME_WIDTH / 2;
    private int height = GameFrame.DEFAULT_FRAME_HEIGHT - 100;

    private List<Bird> birds;

    public MouseClickListener(BirdPanel panel) {
        this.panel = panel;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 1) {
            birds = panel.getList();
            Bullet.getInstance().setNum();
            int num = Bullet.getInstance().getNum();

            // 获取鼠标点击位置坐标
            int y = evt.getY();
            int x = evt.getX();
            if(y >= height){
                return;
            }

            if (num > 0) {
                // 枪声
                GunSoundRunnable rr = new GunSoundRunnable();
                Thread tt1 = new Thread(rr);
                tt1.start();

                // 子弹轨迹线程
                GunShootRunnable gpt = new GunShootRunnable(panel, x, y);
                Thread tt2 = new Thread(gpt);
                tt2.start();

            } else {
                // 如果子弹用尽，则弹出提示
                JOptionPane.showMessageDialog(null, "子弹打光");
//                Thread.currentThread().destroy();
            }

            // 判断鸟是否被击中
            for (Bird b : birds) {
                int x1 = b.getX();
                // 命中因子
                int x2 = x1 + 70;
                int y3 = b.getY();

                // 等比矩形原理
                int x3 = width - (height - y3) * (width - x) / (height - y);
                if (x3 >= x1 && x3 <= x2) {
                    b.setDead(true);
                }
            }
        }
    }

}
