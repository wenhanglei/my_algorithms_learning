import java.util.Iterator;


public class Bag<Item> implements Iterable<Item>{
	//ͷ���
	private Node first;
	//Bag��size
	private int N;
	/**
	 * �ڵ��ڲ���
	 */
	private class Node {
		Item item;
		Node next;
	}
	
	/**
	 * ���캯��
	 */
	Bag() {}
	/**
	 * �Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	/**
	 * bag��С
	 */
	public int size() {
		return N;
	}
	/**
	 * �������
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
			//��ǰ�ڵ�
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
