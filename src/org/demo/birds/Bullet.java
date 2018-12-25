package org.demo.birds;

class Bullet {
    private static Bullet bullet;
    private int num=100;

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