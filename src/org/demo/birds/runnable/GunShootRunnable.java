package org.demo.birds.runnable;


import org.demo.birds.jframe.BirdPanel;
import org.demo.birds.jframe.GameFrame;

public class GunShootRunnable implements Runnable {

    private int endX;
    private int endY;
    public static int startX = GameFrame.DEFAULT_FRAME_WIDTH / 2;
    public static int startY = GameFrame.DEFAULT_FRAME_HEIGHT - 100;

    private BirdPanel panel;

    public GunShootRunnable(BirdPanel panel, int x, int y) {
        this.endX = x;
        this.endY = y;
        this.panel = panel;
    }

    @Override
    public void run() {
        float k1 = startX - endX;
        float k2 = startY - endY;
        float k = k1 / k2;
        if(k < 0){
            for (int i = startX; i < GameFrame.DEFAULT_FRAME_WIDTH; i += 10) {
                float currentY = endY + 1 / k * (i - endX);
                panel.drawOval(i, (int) currentY);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if(k == 0){
            for (int i = startY; i >0; i -= 10) {
                panel.drawOval(startX, i);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else {
            for (int i = startX; i > 0; i -= 10) {
                float currentY = endY + 1 / k * (i - endX);
                panel.drawOval(i, (int) currentY);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
