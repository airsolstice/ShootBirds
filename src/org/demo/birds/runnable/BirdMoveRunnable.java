package org.demo.birds.runnable;

import org.demo.birds.jframe.GameFrame;
import org.demo.birds.bean.Bird;

import java.awt.Component;

public class BirdMoveRunnable implements Runnable {

    private Bird bird;
    private Component com;
    private long delay = 100;

    public BirdMoveRunnable(Bird bird, Component com, long delay) {
        this.bird = bird;
        this.com = com;
        this.delay = delay;
    }

    public void run() {
        try {
            while (!bird.isLeave()) {
                if (bird.getY() > GameFrame.DEFAULT_FRAME_HEIGHT)
                    bird.setLeave(true);
                bird.move(com.getBounds());
                com.repaint();
                Thread.sleep(delay);
            }
        } catch (Exception e) {

        }
    }

}
