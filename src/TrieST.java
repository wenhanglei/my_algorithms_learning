
public class TrieST<Value> {
	
	private class Node {
		private Value val;
		private Node[] nodes;
		Node(int R) {
			nodes = (Node[]) new Object[R];
		}
	}
	
	private int N;
	private Node root;
	private int R;
	
	/**
	 * 构造函数
	 */
	public TrieST(int R) {
		root = new Node(R);
		N = 0;
		this.R = R;
	}
	
	public TrieST() {
		this(256);
	}
	/**
	 * @param s
	 * @return 返回健为 s的值
	 */
	public Value get(String key) {
		if(key == null) return null;
		Node curr = root;
		for(int i = 0; i < key.length(); i++) {
			int j = (int)key.charAt(i);
			if(curr.nodes[j] == null) return null;
			curr = curr.nodes[j];
		}
		if(curr.val != null) return curr.val;
		else return null;
	}
	/**
	 * 向符号表里添加键值对
	 * @param s
	 * @param v
	 */
	public void put(String key, Value val) {
		if(key == null && val == null) return;
		Node curr = root;
		for(int i = 0; i < key.length(); i++) {
			int j = (int)key.charAt(i);
			if(curr.nodes[j] == null)
				curr.nodes[j] = new Node(R);
			if(i == key.length() - 1) {
				curr.val = val;
				N++;
			}
		}
	}
	/**
	 * 删除健为key的键值对
	 * @param key
	 */
	public void delete(String key) {
		
	}
	/**
	 * @param key
	 * @return 该符号表是否包含健为key的键值对
	 */ 
	public boolean contains(String key) {
		return get(key) != null;
	}
	/**
	 * @return 该符号表是否为空
	 */
	public boolean isEmptry() {
		return N <= 0;
	}
	/**
	 * @param s
	 * @return 该字符串在符号表中的最长公共前缀
	 */
	public String longestPrefixOf(String s) {
		return null;
	}
	/**
	 * @param s
	 * @return 符号表中包含前缀s的所有字符串
	 */
	public Iterable<String> keysWithPrefix(String s) {
		return null;
	}
	/**
	 * @param s
	 * @return 返回符号表中与字符串s相匹配的所有字符串
	 */
	public Iterable<String> keysThatMatch(String s) {
		return null;
	}
	/**
	 * @return 符号表中的键值对个数
	 */
	public int size() {
		return N;
	}
	/**
	 * @return 返回符号表中的所有字符串健
	 */
	public Iterable<String> keys() {
		return null;
	}
}
