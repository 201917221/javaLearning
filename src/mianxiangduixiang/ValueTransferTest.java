package mianxiangduixiang;

public class ValueTransferTest {
	public static void main(String[] args) {
		
		String s = "hello";
		//String s = new String("hello");
		
		ValueTransferTest test = new ValueTransferTest();
		test.change(s);
		
		System.out.println(s);//hi~~ x；hello √

	}

	
	public void change(String s){
		s = "hi~~";
		//s= new String("hi~~");
		System.out.println(1);
	}
}
