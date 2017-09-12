/**
 * 用链表实现的栈
 * @author Administrator
 *
 */
public class Stack<Item> {
	/**
	 * 节点内部类
	 */
	private class Node {
		Item item;
		Node next;
	}
	//头结点
	private Node first;
	//stack的size
	private int N;
	
	/**
	 * 构造函数
	 */
	Stack() {}
	/**
	 * 是否为空
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	/**
	 * 栈大小
	 */
	public int size() {
		return N;
	}
	
	/**
	 * 数据入栈
	 */
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	/**
	 * 数据出栈
	 */
	public Item pop() {
		Item temp = first.item;
		first = first.next;
		N--;
		return temp;
	}

}















