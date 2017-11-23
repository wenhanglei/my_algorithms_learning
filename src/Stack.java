import java.util.Iterator;

/**
 * 用链表实现的栈
 * @author Administrator
 *
 */
public class Stack<Item> implements Iterable<Item>{
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
	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>(){
			Node tmp = first;
			@Override
			public boolean hasNext() {
				if(tmp.next != null) return true;
				else return false;
			}
			@Override
			public Item next() {
				Item item = tmp.item;
				tmp = tmp.next;
				return item;
			}
			@Override
			public void remove() {
			}
		};
	}

}














