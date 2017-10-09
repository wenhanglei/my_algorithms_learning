
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
		Node(Key key, Value val) {
			this.key = key;
			this.val = val;
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
		if(root == null){
			root = new Node(key, val);
		}else {
			put(root, key, val);
		}
	}
	/**
	 * 辅助递归函数
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
		int i = key.compareTo(x.key);
		if(x == null) return null;
		else{
		if(i == 0) return x.val;
		else if(i < 0) return get(x.left, key);
		else return get(x.right, key);
		}
	}
	/**
	 * 获取节点的计数
	 * @param n
	 * @return
	 */
	private int size(Node n) {
		if(n == null) return 0;
		return size(n.left) + size(n.right) + 1;
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

























