package org.demo.birds.runnable;

import org.demo.birds.jframe.BirdPanel;
import org.demo.birds.bean.Bird;

import java.util.Random;

/**
 * 鸟飞行轨迹生成
 */
public class BirdFlyRunnable implements Runnable {
    private BirdPanel panel;

    public BirdFlyRunnable(BirdPanel panel) {
        this.panel = panel;
    }

    public void run() {
        try {
            Random rand = new Random();
            for (int i = 0; i < 50; i++) {
                int y = rand.nextInt() % 100;
                if (y < 0)
                    y = -y;

                int delay1 = rand.nextInt() % 1500;
                delay1 = Math.abs(delay1);
                if (delay1 == 0)
                    delay1 = 700;

                int delay = rand.nextInt() % 300;
                delay = Math.abs(delay);
                if (delay <= 20)
                    delay += 20;
                Bird b = new Bird(0, y, 10);
                panel.add(b);
                Runnable r = new BirdMoveRunnable(b, panel, delay);
                Thread t = new Thread(r);
                t.start();
                Thread.sleep(delay1);
                if(i % 5 == 0){
                    Thread.sleep(2000);
                }
            }

        } catch (Exception e) {

        }
    }

}
