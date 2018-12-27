package org.demo.birds.runnable;

import java.applet.Applet;
import java.applet.AudioClip;

public class GunSoundRunnable implements Runnable {

    @Override
    public void run() {

        try {
            AudioClip clip = Applet.newAudioClip(getClass().getResource("/gunsound.wav"));
            clip.play();
            Thread.sleep(200);
            clip.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
