package my.algorithms.adt;

import java.util.Scanner;

public class FixedCapacityStackOfStrings {
	//用于保存数据的String数组 
	private String[] data;
	//用于保存stack的size
	private int N;
	/**
	 * 构造函数
	 */
	public FixedCapacityStackOfStrings(int cap) {
		//初始化stack的大小
		data = new String[cap];
	}
	/**
	 * 判断是否为空
	 */
	public boolean isEmpty() {
		return N==0;
	}
	/**
	 * 入栈方法
	 */
	public void push(String s) {
		//保存字符串
		data[N++] = s;
	}
	/**
	 * 出栈方法
	 */
	public String pop() {
		//改变stack的大小
		return data[--N];
	}
	/**
	 * 返回stack的size
	 */
	public int size() {
		return N;
	}
	
	static class Test {
		public static void main(String[] args) {
			//构造stack实例
			FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(5);
			//构造获取输入的scanner
			Scanner scanner = new Scanner(System.in);
			//读取控制台输入
			String input = scanner.nextLine();
			scanner.close();
			//切割字符串
			String[] data = input.split(" ");
			//存储数据
			for (int i = 0; i < data.length; i ++) {
				if (!data[i].equals("-")) {
					stack.push(data[i]);
				} else {
					System.out.print(stack.pop() + " ");
				}
			}
			System.out.println("(" + stack.size() + " left on the stack)");
		}
	}
}
























