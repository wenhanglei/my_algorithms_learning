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
	Node first;
	//β�ڵ�
	Node last;
	//stack��size
	int N;
	
	/**
	 * ���캯��
	 */
	Stack() {}
	
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

}















