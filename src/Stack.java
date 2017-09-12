/**
 * ������ʵ�ֵ�ջ
 * @author Administrator
 *
 */
public class Stack<Item> {
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

}















