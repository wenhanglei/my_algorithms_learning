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
	Node first;
	//尾节点
	Node last;
	//stack的size
	int N;
	
	/**
	 * 构造函数
	 */
	Stack() {}
	
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

}















