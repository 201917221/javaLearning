package test;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Scanner;
public class TestOne
{
    public  static  void add(Byte b)
    {  b = b++;  }
    public static void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }public static void main(String[] args) {


    { System.out.println("Finally");
    int k=3;
    System.out.println(k--==3&&k++==3);
    int[] a=new int[]{1,2,3};
    if (true&&false)
        System.out.println(1);}
    {{}
//        char c = '\\t';//编译错误 字符过多
   //  char c = '';//编译错误 空字符
        {} System.out.println("Finally");{}
        int a = 2;

        //a+=a*=a;
        //a=a+(a*=a);
        a=a+ a*a;
        System.out.println(a);


        boolean b = ++a>a;  System.out.println(b);
        int a1 = 10;//int b4=++a1++;应为变量
        int b1 = ++a1 + a1++;System.out.println(b1);
      //  String pass-word = "sitm128sw"; xx

        String name = "张三", sex = "男";
        long l1 = 0x50;
        long l4 = 100000000000L;
        int c = 0;int a2=1,b2=1;
        System.out.println(a2 == b2 ? a2 < c ? "1" : "2" : "3");
        System.out.println(a2 > b2 ? "1" : true ? "3" : "4");
        int total = 0;
        for (int i = 0, j = 5; total < 10 || j > 3; ++i, --j) {
            total += (i + j);
            System.out.println(total +"  "+i+"  "+j);
        }
        System.out.println(total);
        test();
    }
}

}
