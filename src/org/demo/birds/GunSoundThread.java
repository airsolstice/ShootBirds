package org.demo.birds;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class GunSoundThread implements Runnable {

    @Override
    public void run() {

        try {
            AudioClip clip = Applet.newAudioClip(new URL("file://res/GunSound.wav"));
            clip.play();
            Thread.sleep(200);
            clip.stop();
        } catch (InterruptedException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}