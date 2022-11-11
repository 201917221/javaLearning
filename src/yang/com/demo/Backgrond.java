package yang.com.demo;

import javax.swing.*;

/**
 * 屏幕上的背景
 * JLabel 用于显示图片
 */
public class Backgrond extends JLabel {
    public Backgrond(){
        //为标签添加背景，设置显示内容
        setIcon(new ImageIcon("images/背景.jpg"));
        //设置显示位置
        setLocation(0,0);
        //设置显示大小， 这个大小和图片一样
        setSize(480, 800);
    }
}
