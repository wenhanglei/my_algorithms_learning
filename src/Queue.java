
public class Queue<Item> {
	/**
	 * 节点内部类
	 */
	private class Node {
		Item item;
		Node next;
	}
	//头结点
	private Node first;
	//尾节点
	private Node last;
	//队列大小
	private int N;
	/**
	 * 构造函数
	 */
	public Queue() {
		first = new Node();
		last = first;
	}
	/**
	 * 是否为空
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	/**
	 * 队列大小
	 */
	public int size() {
		return N;
	}
	/**
	 * 向队列添加数据
	 */
	public void enqueue(Item item) {
		if(N==0){
			last.item = item;
		} else {
			Node oldLast = last;
			last = new Node();
			last.item = item;
			oldLast.next = last;
		}
		N++;
	}
	/**
	 * 从队列中移除数据
	 */
	public Item dequeue() {
		Item temp = first.item;
		first = first.next;
		N--;
		return temp;
	}

}
