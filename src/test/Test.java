package test;

import java.util.Date;


public class Test {
	
	public void foo() {
		A b = new A();
		b.a = 20;
	}
	
	public static void main(String[] args) {
		System.out.println(new Date().getTime());
	}
	
	class A{
		private int a;
	}
}

class B{
	private int a;
}