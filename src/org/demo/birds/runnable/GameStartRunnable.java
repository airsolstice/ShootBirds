package org.demo.birds.runnable;

import org.demo.birds.jframe.BirdPanel;
import org.demo.birds.jframe.GameFrame;
import org.demo.birds.bean.Bird;
import org.demo.birds.bean.Bullet;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GameStartRunnable implements Runnable {

    private BirdPanel panel;
    private ArrayList<Bird> birds;
    private int remainBirds = 50, deadBirds = 0;
    private GameFrame frame;

    public GameStartRunnable(BirdPanel panel, GameFrame frame) {
        this.panel = panel;
        this.frame = frame;
    }

    @SuppressWarnings("deprecation")
    public void run() {
        try {
            while (true) {
                birds = panel.getList();
                remainBirds = 50;
                deadBirds = 0;
                for (Bird b : birds) {

                    if (b.isDead() || b.isLeave()) {
                        remainBirds--;
                    }
                    if (b.isDead())
                        deadBirds++;
                }
                frame.getBirdNumText().setText("" + remainBirds + "ֻ");
                frame.getBulletNumText().setText("" + Bullet.getInstance().getNum() + "发");
                frame.getField3().setText("" + deadBirds + "ֻ");
                Thread.sleep(100);
                if (remainBirds > 0) {
                    AudioClip clip = Applet.newAudioClip(getClass().getResource("/bird.wav"));
                    clip.play();
                    try {
                        Thread.sleep(100);
                        clip.stop();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (remainBirds == 0) {
                    if (deadBirds >= 25) {
                        JOptionPane.showMessageDialog(null, "游戏结束!" + "\n" + "您的花费了" + (100 - Bullet.getInstance().getNum()) + "发子弹" + "打死了" + deadBirds + "只鸟" + "\n你真是神枪手！");
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "游戏结束!" + "\n" + "您的花费了" + (100 - Bullet.getInstance().getNum()) + "发子弹" + "打死了" + deadBirds + "只鸟");
                        System.exit(0);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("抛出这个异常不知道是怎么回事？");
        }
    }
}
