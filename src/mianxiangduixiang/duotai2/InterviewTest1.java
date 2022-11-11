package mianxiangduixiang.duotai2;

import org.junit.Test;

//考查多态的笔试题目：
public class InterviewTest1 {

	@Test
	public void test1(){
		String str=null;
		System.out.println(str.charAt(0));
	}
	public static void main(String[] args) {
		Base1 base = new Sub1();
		base.add(1, 2, 3);

		Sub1 s = (Sub1)base;
		s.add(1,2,3);
	}
}

class Base1 {
	public void add(int a, int... arr) {
		System.out.println("base1");
	}
}

class Sub1 extends Base1 {

	public void add(int a, int b, int c) {
		System.out.println("sub_2");
	}
	public void add(int a, int[] arr) {
		System.out.println("sub_1");
	}



}