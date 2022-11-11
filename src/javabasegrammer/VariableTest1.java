package javabasegrammer;

public class VariableTest1 {
    public static void main(String[] args) {
        byte bt1=12;
        byte bt2=13;
        //byte b=bt1+bt2;//编译不通过
        byte b= (byte) (bt1+bt2);
        int[][][][] arr=new int[1][1][1][1];
        int[]arr1[]={{1,2},{2,4}};
    }
}
