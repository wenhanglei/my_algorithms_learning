package algorithms;

public class SequentialSearchST<Key, Value> {
	/**
	 * 节点内部类由于存储元数据
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
	//头结点
	private Node head;
	//符号表的size
	private int N=0;
	/**
	 * 符号表的初始化函数
	 */
	SequentialSearchST() {}
	/**
	 * 保存键值对
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
	 * 获取对应键的值
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
	 * 删除键值对
	 * @param key
	 */
	void delete(Key key) {
		put(key, null);
		N--;
	}
	/**
	 * 是否含有健为key的键值对
	 * @param key
	 * @return
	 */
	boolean contains(Key key) {
		return get(key) != null;
	}
	/**
	 * 符号表是否为空
	 * @return
	 */
	boolean isEmpty() {
		return N == 0;
	}
	/**
	 * 返回符号表的大小
	 * @return
	 */
	int size() {
		return N;
	}
	/**
	 * 返回key迭代器
	 * @return
	 */
	Iterable<Key> keys() {
		return null;
	}
	public static void main(String[] args) {
		String[] data = {"S", "E", "A", "R", "C", "H", "E", "X", "A", "M", "P", "L", "E"};
		//用于装载数据的符号表
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = 0; i < data.length; i++) {
			st.put(data[i], i);
		}
	}
}




















