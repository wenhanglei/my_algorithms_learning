
public class SequentialSearchST<Key, Value> {
	/**
	 * �ڵ��ڲ������ڴ洢Ԫ����
	 * @author Administrator
	 *
	 */
	private class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	//ͷ���
	private Node head;
	//���ű��size
	private int N=0;
	/**
	 * ���ű�ĳ�ʼ������
	 */
	SequentialSearchST() {}
	/**
	 * �����ֵ��
	 * @param key
	 * @param val
	 */
	void put(Key key, Value val) {
		Node tmp = head;
		while(head != null && tmp.next != null){
			if(tmp.key.equals(key)){
				tmp.val = val;
				return;
			}
			tmp = tmp.next;
		}
		head = new Node(key, val, head);
		N++;
	}
	/**
	 * ��ȡ��Ӧ����ֵ
	 * @param key
	 * @return
	 */
	Value get(Key key) {
		Node tmp = head;
		while(tmp.next != null) {
			if(tmp.key.equals(key)){
				return tmp.val;
			}
			tmp = tmp.next;
		}
		return null;
	}
	/**
	 * ɾ����ֵ��
	 * @param key
	 */
	void delete(Key key) {
		put(key, null);
		N--;
	}
	/**
	 * �Ƿ��н�Ϊkey�ļ�ֵ��
	 * @param key
	 * @return
	 */
	boolean contains(Key key) {
		return get(key) != null;
	}
	/**
	 * ���ű��Ƿ�Ϊ��
	 * @return
	 */
	boolean isEmpty() {
		return N == 0;
	}
	/**
	 * ���ط��ű�Ĵ�С
	 * @return
	 */
	int size() {
		return N;
	}
	/**
	 * ����key������
	 * @return
	 */
	Iterable<Key> keys() {
		return null;
	}
	public static void main(String[] args) {
		String[] data = {"S", "E", "A", "R", "C", "H", "E", "X", "A", "M", "P", "L", "E"};
		//����װ�����ݵķ��ű�
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = 0; i < data.length; i++) {
			st.put(data[i], i);
		}
	}
}





















