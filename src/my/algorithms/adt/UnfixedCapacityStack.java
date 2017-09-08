package my.algorithms.adt;

import java.util.Scanner;

public class UnfixedCapacityStack<Item> {
	//用于保存数据的String数组 
	private Item[] data;
	//用于保存stack的size
	private int N;
	/**
	 * 构造函数
	 */
	public UnfixedCapacityStack(int cap) {
		//初始化stack的大小
		data = (Item[])new Object[cap];
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
	public void push(Item s) {
		//检查stack的大小是否不足
		//如果stack满了
		if (data.length == N) {
			resize(2*N);
		} else data[N++] = s;
	}
	/**
	 * 出栈方法
	 */
	public Item pop() {
		//改变stack的大小，如果data的size小于四分之一则a.length减半
		Item temp = data[--N];
		//消除游荡的Ttem对象
		data[N] = null;
		//判断是否等于四分之一
		if (N > 0 && N == data.length/4) resize(data.length/2);
		return temp;
	}
	/**
	 * 返回stack的size
	 */
	public int size() {
		return N;
	}
	/**
	 * 复杂当前stack到指定大小的新栈
	 */
	private void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	/**
	 * 测试栈实现的嵌套类
	 * @author Administrator
	 *
	 */
	static class Test {
		public static void main(String[] args) {
			//构造stack实例
			UnfixedCapacityStack<String> stack = new UnfixedCapacityStack<String>(100);
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
























