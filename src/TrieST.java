
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
	 * ���캯��
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
	 * @return ���ؽ�Ϊ s��ֵ
	 */
	//get�����ĵݹ�ʵ��
	public Value get(String key) {
		if(key == null) return null;
		Node curr = get(root, key, 0);
		if(curr.val != null) return curr.val;
		else return null;
	}
	
	private  Node get(Node node, String key, int i) {
		if(i >= key.length()) return null;
		else if(node.nodes[key.charAt(i)] == null) return null;
		else return get(node.nodes[key.charAt(i)], key, i+1);
	}
	
	//get�����ķǵݹ�ʵ��
//	public Value get(String key) {
//		if(key == null) return null;
//		Node curr = root;
//		for(int i = 0; i < key.length(); i++) {
//			int j = (int)key.charAt(i);
//			if(curr.nodes[j] == null) return null;
//			curr = curr.nodes[j];
//		}
//		if(curr.val != null) return curr.val;
//		else return null;
//	}
	/**
	 * ����ű�����Ӽ�ֵ��
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
	 * ɾ����Ϊkey�ļ�ֵ��
	 * @param key
	 */
	public void delete(String key) {
		if(key == null) return;
		root = delete(root, key, 0);
	}
	private Node delete(Node node, String key, int d) {
		if(node == null) return null;
		if(d == key.length())
			if(node.val != null) node.val = null;
		else{
			char c = key.charAt(d);
			node.nodes[c] = delete(node.nodes[c], key, d+1);
		}
		if(node.val != null) return node;
		for(char i = 0; i < R; i++){
			if(node.nodes[i] != null) return node;
		}
		return null;
	}
	/**
	 * @param key
	 * @return �÷��ű��Ƿ������Ϊkey�ļ�ֵ��
	 */ 
	public boolean contains(String key) {
		return get(key) != null;
	}
	/**
	 * @return �÷��ű��Ƿ�Ϊ��
	 */
	public boolean isEmptry() {
		return N <= 0;
	}
	/**
	 * @param s
	 * @return ���ַ����ڷ��ű��е������ǰ׺
	 */
	public String longestPrefixOf(String s) {
		if(s == null) return null;
		int len = search(root, s, 0, 0);
		return s.substring(0, len);
	}
	
	private int search(Node node, String pat, int d, int length){
		if(d > pat.length()) return length;
		if(node == null) return length;
		int next = pat.charAt(d);
		if(node.nodes[next] == null) return length;
		else if(node.val != null) length = d;
		return search(node.nodes[next], pat, d+1, length);
	}
	
	/**
	 * @param s
	 * @return ���ű��а���ǰ׺s�������ַ���
	 */
	public Iterable<String> keysWithPrefix(String s) {
		Queue<String> q = new Queue<String>();
		collect(get(root, s, 0), s, q);
		return q;
	}
	/**
	 * @param s
	 * @return ���ط��ű������ַ���s��ƥ��������ַ���
	 */
	public Iterable<String> keysThatMatch(String s) {
		if(s == null) return null;
		Queue<String> q = new Queue<String>();
		collect(root, "", s, q);
		return q;
	}
	private void collect(Node node, String pre, String pat, Queue<String> q){
		if(node == null) return;
		int d = pre.length();
		if(d == pat.length() && node.val != null) q.enqueue(pre);
		if(d == pat.length()) return;
		for(char c = 0; c < R; c++){
			if(pat.charAt(d) == '.' || c == pat.charAt(d))
				collect(node.nodes[c], pre+c, pat, q);
		}
	}
	
	/**
	 * @return ���ű��еļ�ֵ�Ը���
	 */
	public int size() {
		return N;
	}
	/**
	 * @return ���ط��ű��е������ַ�����
	 */
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}
	private void collect(Node node, String s, Queue q) {
		if(node == null) return;
		if(node.val != null) {
			q.enqueue(s);
		}
		for(int i = 0; i < R; i++) {
			if(node.nodes[i] != null){
				String tmp = s + (char)i;
				collect(node.nodes[i], tmp, q);
			}
		}
	}
}
















