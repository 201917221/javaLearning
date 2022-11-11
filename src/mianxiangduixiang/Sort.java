package mianxiangduixiang;
import java.util.Arrays;
import java.util.Scanner;
public class Sort {
    public static void main(String[] args) {
        int a[]= new int[]{45,15,64,75,0};
        for (int i= 0;i<a.length-1;i++){
            for (int j = 0; j <a.length-1-i; j++) {
                if (a[j]>a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        Scanner scanner=new Scanner(System.in);
        int i=scanner.nextInt();
    }
}
