import java.util.Iterator;


public class Bag<Item> implements Iterable<Item>{
	//头结点
	private Node first;
	//Bag的size
	private int N;
	/**
	 * 节点内部类
	 */
	private class Node {
		Item item;
		Node next;
	}
	
	/**
	 * 构造函数
	 */
	Bag() {}
	/**
	 * 是否为空
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	/**
	 * bag大小
	 */
	public int size() {
		return N;
	}
	/**
	 * 添加数据
	 */
	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			//当前节点
			private Node current = first;
			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Item next() {
				Item temp = current.item;
				current = current.next;
				return temp;
			}

			@Override
			public void remove() {
			}
			
		};
	}
}
