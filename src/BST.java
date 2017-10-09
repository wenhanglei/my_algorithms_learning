
public class BST<Key extends Comparable<Key>, Value> {
	/**
	 * �������ṹ�Ľڵ���
	 * @author Administrator
	 *
	 */
	private class Node{
		//����Ľ�
		private Key key;
		//�����ֵ
		private Value val;
		//�������ڵ�
		Node left;
		//�������ڵ�
		Node right;
		//�ýڵ����е��ӽڵ�ĸ���
		private int N;
		//Ĭ�Ϲ��캯��
		Node() {
		}
		//�������Ĺ��캯��
		Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}
	
	//���ڵ�
	private Node root;
	/**
	 * ���캯��
	 */
	public BST(){
	}
	/**
	 * ��Ӽ�ֵ��
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {
		if(root == null){
			root = new Node(key, val);
		}else {
			put(root, key, val);
		}
	}
	/**
	 * �����ݹ麯��
	 * @param n
	 * @param key
	 * @param val
	 */
	private void put(Node n, Key key, Value val) {
		if(n == null) {
			n = new Node(key, val);
			return;
		}
		int i = key.compareTo(n.key);
		if(i == 0){
			n.key = key;
			n.val = val;
			return;
		}else if(i < 0){
			put(n.left, key, val);
		}else{
			put(n.right, key, val);
		}
	}
	/**
	 * ��ȡ��λkey��ֵ
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return get(root, key);
	}
	/**
	 * �ݹ鸨������
	 * @param x
	 * @param key
	 * @return
	 */
	private Value get(Node x, Key key) {
		int i = key.compareTo(x.key);
		if(x == null) return null;
		else{
		if(i == 0) return x.val;
		else if(i < 0) return get(x.left, key);
		else return get(x.right, key);
		}
	}
	/**
	 * ��ȡ�ڵ�ļ���
	 * @param n
	 * @return
	 */
	private int size(Node n) {
		if(n == null) return 0;
		return size(n.left) + size(n.right) + 1;
	}
	/**
	 * ���Ժ���
	 * @param args
	 */
	public static void main(String[] args) {
		String[] data = {"S", "E", "A", "R", "C", "H", "E", "X", "A", "P"};
		//������ֲ�����
		BST<String, Integer> bst = new BST<String, Integer>();
		for(int i = 0; i < data.length; i++) {
			bst.put(data[i], i);
		}
	}
	
}

























