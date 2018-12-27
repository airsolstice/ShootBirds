package org.demo.birds.bean;

public class Bullet {
    private static Bullet bullet;
    private int num=50;

    private  Bullet() {
    }

    public static Bullet getInstance() {
        if(bullet==null)
            bullet=new Bullet();
        return bullet;
    }

    public int getNum() {
        return num;
    }

    public void setNum() {
        num--;
    }

}