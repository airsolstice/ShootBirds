package org.demo.birds.bean;

/**
 * 弹夹实体
 */
public class Bullet {
    /**
     * 弹夹单例引用
     */
    private static Bullet bullet;
    /**
     * 子弹数量
     */
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

    public void reset(){
        num = 100;
    }

}