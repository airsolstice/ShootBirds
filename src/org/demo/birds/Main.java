package org.demo.birds;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class Main {
    /**
     * 程序入口
     */
    public static void main(String[] args) {
//        test1();
        GameFrame frame = new GameFrame();
        frame.setVisible(true);
    }

    public static void test1(){
        JFrame jframe = new JFrame();
        jframe.setSize(800, 600);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon airplane = new ImageIcon("res/airplane.png");
        JPanel panel = new JPanel();

        panel.getGraphics().drawImage(airplane.getImage(), 150-25, 200-80, 50, 80, jframe.getContentPane());

        jframe.getContentPane().add(panel);
        jframe.setVisible(true);
    }

    public static void test() throws Exception {
        BufferedImage sourceImage = ImageIO.read(new FileInputStream("res/4.gif"));
        BufferedImage dstImage = null;
        //AffineTransform transform = new AffineTransform(-1,0,0,1,sourceImage.getWidth()-1,0);//水平翻转
//        AffineTransform transform = new   AffineTransform(1,0,0,-1,0,sourceImage.getHeight()-1);//垂直翻转
        AffineTransform transform = new AffineTransform(-1, 0, 0.5, -1, sourceImage.getWidth() - 1, sourceImage.getHeight() - 1);//旋转180度
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        dstImage = op.filter(sourceImage, null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Source Transform", new JLabel(new ImageIcon(sourceImage)));
        tabbedPane.add("Affine Transform", new JLabel(new ImageIcon(dstImage)));

        JFrame jframe = new JFrame();
        jframe.setSize(800, 600);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.getContentPane().add(tabbedPane);
        jframe.setVisible(true);
    }
}
