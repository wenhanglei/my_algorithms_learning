
public class BST<Key extends Comparable<Key>, Value> {
	/**
	 * 构造树结构的节点类
	 * @author Administrator
	 *
	 */
	private class Node{
		//保存的健
		private Key key;
		//保存的值
		private Value val;
		//左子树节点
		Node left;
		//右子树节点
		Node right;
		//该节点所有的子节点的个数
		private int N;
		//默认构造函数
		Node() {
		}
		//带参数的构造函数
		Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	//根节点
	private Node root;
	/**
	 * 构造函数
	 */
	public BST(){
	}
	/**
	 * 添加键值对
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	/**
	 * 辅助递归函数
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
	 * 获取键位key的值
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return get(root, key);
	}
	/**
	 * 递归辅助函数
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
	 * 返回最小的健
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
	 * 返回最大的健
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
	 * 返回最近的小于key的健
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
	 * 返回最近的大于key的健
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
	 * 返回第k个健
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
	 * 返回key的排序
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
	 * 删除最小的key
	 */
	void deleteMin() {
		
	}
	/**
	 * 删除最大的key
	 */
	void deleteMax() {
		
	}
	/**
	 * 获取节点的计数
	 * @param n
	 * @return
	 */
	private int size(Node n) {
		if(n == null) return 0;
		else return n.N;
	}
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		String[] data = {"S", "E", "A", "R", "C", "H", "E", "X", "A", "P"};
		//构造二分查找树
		BST<String, Integer> bst = new BST<String, Integer>();
		for(int i = 0; i < data.length; i++) {
			bst.put(data[i], i);
		}
	}
	
}

























