package yang.com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 卡牌
 * 屏幕上显示的卡牌
 * 继承于JButton 按钮，用于处理鼠标事件
 */
public class Card extends JButton {

    public static final int WIDTH = 58;
    public static final int HEIGHT = 60;

    /**
     * 创建卡牌
     * @param name 卡牌的名字：刷子，树桩，干草，火，等
     */
    public Card(String name) {
        //正常显示的图标
        setIcon(new ImageIcon("images/" + name + ".png"));
        //被压下面时候的图标
        setDisabledIcon(new ImageIcon("images/" + name + "2.png"));
        //设置大小
        setSize(59, 66);
        //设置卡牌的名字
        setName(name);
        //去除边框
        setBorderPainted(false);
        //设置透明绘制（不绘制按钮背景）
        setContentAreaFilled(false);
        //设置首选大小
        setPreferredSize(new Dimension(59,66));
    }
    @Override
    public String toString() {
        return getName();
    }

    /**
     * 检查当前牌是否压住 另外一张牌 card
     * @param card 另外一张牌
     * @return 是否压住了
     */
    public boolean covered(Card card){
        int x1 = card.getX() - WIDTH;
        int x2 = card.getX() + WIDTH;
        int y1 = card.getY() - HEIGHT;
        int y2 = card.getY() + HEIGHT;
        return getX() > x1 && getX() < x2 && getY() > y1 && getY() < y2;
    }

    public boolean sameAs(Card card){
        return getName().equals(card.getName());
    }

    public void removeActionListeners(){
        for (ActionListener l:getActionListeners()){
            removeActionListener(l);
        }
    }
}
