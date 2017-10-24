import java.util.Iterator;

/**
 * ������ʵ�ֵ�ջ
 * @author Administrator
 *
 */
public class Stack<Item> implements Iterable<Item>{
	/**
	 * �ڵ��ڲ���
	 */
	private class Node {
		Item item;
		Node next;
	}
	//ͷ���
	private Node first;
	//stack��size
	private int N;
	
	/**
	 * ���캯��
	 */
	Stack() {}
	/**
	 * �Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	/**
	 * ջ��С
	 */
	public int size() {
		return N;
	}
	
	/**
	 * ������ջ
	 */
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	/**
	 * ���ݳ�ջ
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















