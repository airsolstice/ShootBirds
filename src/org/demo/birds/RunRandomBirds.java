package org.demo.birds;

import java.util.Random;

public class RunRandomBirds implements Runnable {
    private BirdPanel panel;

    public RunRandomBirds(BirdPanel panel) {
        this.panel = panel;
    }

    public void run() {
        try {
            Random rand = new Random();
            for (int i = 0; i < 50; i++) {
                int y = rand.nextInt() % 100;
                if (y < 0)
                    y = -y;
                int delay1 = rand.nextInt() % 1000;
                delay1 = Math.abs(delay1);
                if (delay1 == 0)
                    delay1 = 100;
                int delay = rand.nextInt() % 100;
                delay = Math.abs(delay);
                if (delay <= 20)
                    delay += 20;
                Bird b = new Bird(0, y, 10);
                panel.add(b);
                Runnable r = new RunnableThread(b, panel, delay);
                Thread t = new Thread(r);
                t.start();
                Thread.sleep(delay1);

            }

        } catch (Exception e) {

        }
    }

}
