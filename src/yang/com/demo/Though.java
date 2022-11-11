package yang.com.demo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 槽子
 * 屏幕下方，用于匹配卡牌的槽子
 */
public class Though extends JPanel {
    /**
     * 定时器，用于处理延迟删除效果
     */
    private Timer timer = new Timer();
    public Though(){
        //设置调试边框
        //setBorder(new LineBorder(Color.RED));
        //设置大小
        setSize((Card.WIDTH+5) * 7, Card.HEIGHT + 15 );
        //设置位置
        setLocation(20, 633);
        //设置背景透明
        setOpaque(false);
        //创建流布局，其中的组件安装先后次序排列
        FlowLayout flowLayout = new FlowLayout();
        //设置布局的元素的对齐方式: 从头对其
        flowLayout.setAlignment(FlowLayout.LEADING);
        //设置横向缝隙
        flowLayout.setHgap(3);
        //将布局设置到面板
        setLayout(flowLayout);
    }

    /**
     * 将牌添加到槽子中
     * @param card 被添加的牌
     *
     */
    public void addCard(Card card){
        //从当前 panel 中拿到全部的牌 getComponents()，Swing提供的方法
        // found 代表是否找到插入位置，如果是-1就是没有找到插入位置
        // index 代表组件的位置，每次查找会自动增加1
        int found = -1, index = 0;
        //按照顺序查找牌
        for(Component component: getComponents()){
            Card current = (Card) component;
            //sameAs 方法用于比较两个牌是否具有相同的name
            if (current.sameAs(card)){
                found = index;
                break;
            }
            index++;
        }
        //如果没有找到， 就插入到最后
        if(found == -1){
            add(card); //就插入到最后，调用从JPanel继承的方法，将组件添加到界面
        }else{
            add(card, found); //找到了就在中间插入
        }
        //处理消除卡牌，利用定时器，实现延迟删除
        int remove = found;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                removeCards(card, remove);
            }
        }, 200); //延迟200毫秒再删除


        //添加以后，进行界面重绘，否则看到不到牌
        updateUI();
    }

    /**
     * 检查是否出现3个一组的卡牌，如果有就消除这些卡牌
     * @param card 正在插入的卡牌
     * @param found 找到插入的位置，如果-1就表示追加
     */
    private void removeCards(Card card, int found) {
        //如果在最后插入就不需要，消除牌
        if (found == -1){
            return;
        }
        //如果插入位置，到最后 不够3就不需要消除
        if(getComponentCount() - found < 3){
            return;
        }
        //下下一张不一样，就不需要消除
        Card nextNextCard = (Card) getComponent(found+2);
        if (! card.sameAs(nextNextCard)){
            return;
        }
        //连续3张一样，连续删除3个牌
        remove(found);
        remove(found);
        remove(found);
        //重绘界面
        updateUI();
    }

    /**
     * 检查槽子是否满了
     */
    public boolean isFull(){
        return getComponentCount() == 7;
    }
}
