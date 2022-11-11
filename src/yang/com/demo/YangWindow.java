package yang.com.demo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 羊了个羊的游戏窗口
 */
public class YangWindow extends JFrame {

    /**
     * 窗口中的内容面板
     */
    private JPanel panel = new JPanel();

    /**
     * 创建窗口背景对象
     */
    private Backgrond backgrond = new Backgrond();

    /**
     * 存储屏幕上摆放的卡牌
     *
     */
    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * 屏幕下方的槽子
     */
    private Though though = new Though();

    /**
     * 利用字符串数字存储卡牌的名字
     */
    private String[] names =
            {"刷子","剪刀","叉子","奶瓶","干草","手套","树桩","棉花",
            "毛线", "水桶","火","玉米","白菜","草","萝卜","铃铛"};

    public YangWindow(){
        //利用从 JFrame继承的方法， 设置窗口的标题
        setTitle("羊了个羊"); //设置窗口的标题
        //设置窗口的大小：宽高
        setSize(500,850);
        //设置居中显示
        setLocationRelativeTo(null);
        //设置默认的窗口关闭功能为：关闭即退出
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //更换窗口图标
        setIconImage(new ImageIcon("images/草.png").getImage());
        //将面板添加到窗口中
        add(panel);
        //去除panel的默认布局规则，使用自定义布局
        panel.setLayout(null);
        //将背景添加到 面板中
        panel.add(backgrond);
        //把槽子放到窗口中
        panel.add(though, 0);
        //调用初始化方法
        initGame();
    }

    /**
     * 初始化羊了个羊游戏
     */
    private void initGame(){
        //创建9轮次牌！
        createCards(12);
        print();
        //Java提供的，集合元素打乱(洗牌)算法
        Collections.shuffle(cards);
        print();
        //将卡牌按照顺序摆放到 窗口中
        deal(0, 6, 7, 34, 100);
        deal(42, 5, 6, 34+30, 100+30);
        deal(42+30, 5, 7, 34, 100+60);
        deal(42+30+35, 5, 6, 34+30, 100+30);
        //deal(42+30+35+30, 4, 5, 34+30+30, 100+30+30);
        deal(42+30+35+30, 60, 34,100+370);
        //检查牌是否被压住，压住设置为 disable 没有 压住 设置为enable
        checkCardsOnTop();
        //为每个来添加鼠标动作处理
        addCardsAction();
    }

    /**
     * 为卡牌添加动作事件处理功能
     */
    private void addCardsAction() {
        for(Card card: cards){
            card.addActionListener(e->{
                // e.getSource() 可以获得被点击的卡牌
                Card selected = (Card) e.getSource();
                System.out.println("点击了卡牌:"+selected);
                //如果槽子是满的，就弹出对话框，显示：槽子满了！ 直接结束程序，不再处理后续逻辑
                if (though.isFull()){
                    JOptionPane.showMessageDialog(panel, "槽子满了！");
                    return;
                }
                //去除选定牌的鼠标事件
                selected.removeActionListeners();
                //从cards中删除选定的牌
                cards.remove(selected);
                //从显示面板中删除选定的牌
                panel.remove(selected);
                //检查上方牌
                checkCardsOnTop();
                //把删除的牌， 添加到槽子里面
                though.addCard(selected);
                //触发panel的重绘
                panel.repaint();
            });
        }
    }

    /**
     * 检查每个牌，是否是上方牌
     */
    private void checkCardsOnTop(){
        for (int i=0; i<cards.size(); i++){
            //取出cards中的每个牌
            Card card1 = cards.get(i);
            card1.setEnabled(true);
            //将当前牌和后面的每个牌比较，看看后面牌是否压住当前牌
            for (int j=i+1; j<cards.size(); j++){
                Card card2 = cards.get(j);
                //如果第二张牌压住了第一张牌，则第一张是下方牌
                if (card2.covered(card1)){
                    card1.setEnabled(false);
                }
            }
        }
    }

    /**
     * 摆牌方法
     * @param start 开始位置， 就是cards集合中开始摆放牌的起始位置
     * @param rows  摆放行数
     * @param cols  摆放列数
     */
    private void deal(int start, int rows, int cols, int x, int y){
        for(int i=0; i<rows * cols && i+start < cards.size(); i++){
            Card card = cards.get(i + start);
            int x_ = x + i % cols * Card.WIDTH;
            int y_ = y + i / cols * Card.HEIGHT;
            card.setLocation(x_,y_);
            panel.add(card, 0);
        }
    }

    private void deal(int start, int count, int x, int y){
        int x_ = x;
        for(int i=0; i<count && i+start < cards.size(); i++){
            Card card = cards.get(i + start);
            card.setLocation(x_,y);
            x_ += 5;
            panel.add(card, 0);
        }
    }

    private void print(){
        int i = 1;
        for(Card card:cards){
            System.out.print(card+" ");
            if (i++ % 16==0){
                System.out.println();
            }
        }
    }

    /**
     * 创建全部的卡牌对象，存储的到集合中，
     * @param times 是创建的轮次，应该为3的倍数，方便后期3个一组进行消除
     */
    private void createCards(int times) {
        for (int i=0; i<times; i++){
            for (String name: names) {
                cards.add(new Card(name));
            }
        }
    }


    public static void main(String[] args) {
        YangWindow window = new YangWindow();
        //显示窗口
        window.setVisible(true);
    }
}
