
public class Queue<Item> {
	/**
	 * �ڵ��ڲ���
	 */
	private class Node {
		Item item;
		Node next;
	}
	//ͷ���
	private Node first;
	//β�ڵ�
	private Node last;
	//���д�С
	private int N;
	/**
	 * ���캯��
	 */
	public Queue() {
		first = new Node();
		last = first;
	}
	/**
	 * �Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	/**
	 * ���д�С
	 */
	public int size() {
		return N;
	}
	/**
	 * ������������
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
	 * �Ӷ������Ƴ�����
	 */
	public Item dequeue() {
		Item temp = first.item;
		first = first.next;
		N--;
		return temp;
	}

}
