package org.demo.birds.jframe;

import org.demo.birds.runnable.GameStartRunnable;
import org.demo.birds.runnable.BirdFlyRunnable;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 游戏框体
 */
public class GameFrame extends JFrame {

    /**
     * 框体大小
     */
    public static final int DEFAULT_FRAME_WIDTH = 450;
    public static final int DEFAULT_FRAME_HEIGHT = 550;

    //
    private JButton start;
    //
    private JTextField birdNumText, bulletNumText, field3;
    //
    private JLabel label1, label2, label3;
    //
    private BirdPanel panel;

    public GameFrame() {
        // 设置应用图标
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/icon.gif"));
        init();
        setLayout();
    }

    private void setLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        Box box = Box.createVerticalBox();
        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createHorizontalBox();
        box1.add(label1);
        box1.add(getBirdNumText());
        box1.add(start);
        box2.add(label2);
        box2.add(getBulletNumText());
        box2.add(label3);
        box2.add(field3);
        box.add(box1);
        box.add(box2);
        add(panel, BorderLayout.CENTER);
        add(box, BorderLayout.SOUTH);
        // 设置按钮监听
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
    }

    private void init() {

        label1 = new JLabel("剩余鸟的数目");
        label2 = new JLabel("剩余子弹数目");
        label3 = new JLabel("打死鸟数");
        field3 = new JTextField(10);
        field3.setEditable(false);
        setBirdNumText(new JTextField(20));
        setBulletNumText(new JTextField(10));
        getBirdNumText().setEditable(false);
        getBulletNumText().setEditable(false);
        panel = new BirdPanel();
        start = new JButton("开始游戏");
        panel.add(start);
    }

    public void startGame() {
        Runnable rr = new BirdFlyRunnable(panel);
        Thread t = new Thread(rr);
        t.start();
        Runnable rr2 = new GameStartRunnable(panel, this);
        Thread tt = new Thread(rr2);
        tt.start();
    }

    public JTextField getBirdNumText() {
        return birdNumText;
    }

    public void setBirdNumText(JTextField birdNumText) {
        this.birdNumText = birdNumText;
    }

    public JTextField getBulletNumText() {
        return bulletNumText;
    }

    public void setBulletNumText(JTextField bulletNumText) {
        this.bulletNumText = bulletNumText;
    }

    public JTextField getField3() {
        return field3;
    }

    public void setField3(JTextField field3) {
        this.field3 = field3;
    }

}
