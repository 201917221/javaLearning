package javabasegrammer;

public class ForForTest {
    public static void main(String[] args) {
        for (int i=1;i<=5;i++){
            for (int j=5-i;j>=1;j--){
                System.out.print(" ");
            }
            for (int k=i;k>=1;k--){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i=1;i<=4;i++){
            for (int j=i;j>=1;j--){
                System.out.print(" ");
            }
            for (int k=5-i;k>=1;k--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
