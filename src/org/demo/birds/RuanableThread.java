package org.demo.birds;

import java.awt.Component;

public class RuanableThread implements Runnable {

    private Bird bird;
    private Component com;
    private long delay = 100;

    public RuanableThread(Bird bird, Component com, long delay) {
        this.bird = bird;
        this.com = com;
        this.delay = delay;
    }

    public void run() {
        try {
            while (!bird.isLeave()) {
                if (bird.getY() > 265)
                    bird.setLeave(true);
                bird.move(com.getBounds());
                com.repaint();
                Thread.sleep(delay);
            }
        } catch (Exception e) {

        }
    }

}
