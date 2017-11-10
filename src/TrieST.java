
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
		return null;
	}
	/**
	 * @param s
	 * @return ���ű��а���ǰ׺s�������ַ���
	 */
	public Iterable<String> keysWithPrefix(String s) {
		return null;
	}
	/**
	 * @param s
	 * @return ���ط��ű������ַ���s��ƥ��������ַ���
	 */
	public Iterable<String> keysThatMatch(String s) {
		return null;
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
		return null;
	}
}
