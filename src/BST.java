
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
		Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
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
		root = put(root, key, val);
	}
	/**
	 * �����ݹ麯��
	 * @param n
	 * @param key
	 * @param val
	 */
	private Node put(Node n, Key key, Value val) {
		if(n == null) return new Node(key, val, 1);
		int cmp = key.compareTo(n.key);
		if(cmp < 0){
			n.left = put(n.left, key, val);
		}else if(cmp > 0){
			n.right = put(n.right, key, val);
		}else{
			n.val = val;
		}
		n.N = size(n.left) + size(n.right) + 1;
		return n;
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
		if(x == null) return null;
		int i = key.compareTo(x.key);	
		if(i == 0) return x.val;
		else if(i < 0) return get(x.left, key);
		else return get(x.right, key);
	}
	/**
	 * ������С�Ľ�
	 * @return
	 */
	Key min() {
		return min(root).key;
	}
	private Node min(Node x){
		if(x.left == null) return x;
		else return min(x.left);
	}
	/**
	 * �������Ľ�
	 * @return
	 */
	Key max() {
		return max(root).key;
	}
	private Node max(Node x){
		if(x.right == null) return x;
		else return max(x.right);
	}
	/**
	 * ���������С��key�Ľ�
	 * @param key
	 * @return
	 */
	Node floor(Key key) {
		return floor(root, key);
	}
	private Node floor(Node x, Key key) {
		int cmp = x.key.compareTo(key);
		if(cmp < 0) {
			if(x.right == null) return x;
			else return floor(x.left, key);
		}
		else if(cmp > 0) {
			if(x.left == null) return null;
			return floor(x.right, key);
		}
		else return x;
	}
	/**
	 * ��������Ĵ���key�Ľ�
	 * @param key
	 * @return
	 */
	Node ceiling(Key key) {
		return null;
	}
	private Node ceiling(Node x, Key key) {
		int cmp = x.key.compareTo(key);
		if(cmp < 0) {
			if(x.right == null) return null;
			else return floor(x.right, key);
		}
		else if(cmp > 0) {
			if(x.left == null) return x;
			return floor(x.left, key);
		}
		else return x;
	}
	/**
	 * ���ص�k����
	 * @param k
	 * @return
	 */
	Key select(int k) {
		Node tmp = select(root, k);
		if(tmp == null) return null;
		else return tmp.key;
	}
	private Node select(Node x, int k){
		if (x==null) return null;
		int t = size(x.left);
		if(t == k) return x;
		if(t > k){
			return select(x.left, k);
		}else{
			return select(x.right, k-t);
		}
	}
	/**
	 * ����key������
	 * @param key
	 * @return
	 */
	int rank(Key key) {
		return rank(root, key);
	}
	private int rank(Node x, Key key) {
		if(x == null) return 0;
		int cmp = x.key.compareTo(key);
		if(cmp == 0) return size(x.left);
		if(cmp < 0){
			return rank(x.left, key);
		}else{
			return size(x.left) + rank(x.right, key);
		}
	}
	/**
	 * ɾ����С��key
	 */
	void deleteMin() {
		
	}
	/**
	 * ɾ������key
	 */
	void deleteMax() {
		
	}
	/**
	 * ��ȡ�ڵ�ļ���
	 * @param n
	 * @return
	 */
	private int size(Node n) {
		if(n == null) return 0;
		else return n.N;
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

























