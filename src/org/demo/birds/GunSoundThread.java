package org.demo.birds;

import java.applet.Applet;
import java.applet.AudioClip;

public class GunSoundThread implements Runnable {

    @Override
    public void run() {

        try {
            AudioClip clip = Applet.newAudioClip(getClass().getResource("/GunSound.wav"));
            clip.play();
            Thread.sleep(200);
            clip.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
