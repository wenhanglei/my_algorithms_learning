package my.algorithms.adt;

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
}
























