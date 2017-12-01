import java.util.ArrayList;
import java.util.List;

/**
 * 霍夫曼编码
 * @author Administrator
 *
 */
public class Huffman {
	//字符表的总的字符个数
	private static int R = 256;
	
	/**
	 * 节点类
	 * @author Administrator
	 */
	private static class Node implements Comparable<Node>{
		//左字典树
		private Node left;
		//右字典树
		private Node right;
		//字符频率
		private int freq;
		//存储在该节点的字符
		private char ch;
		
		public Node(Node left, Node right, int freq, char ch) {
			this.left = left;
			this.right = right;
			this.freq = freq;
			this.ch = ch;
		}
		//判断该节点是不是字典树的叶子节点
		private boolean isLeaf() {
			return left == null && right == null;
		}
		//判断当前节点和另外一个节点的重复频率大小
		@Override
		public int compareTo(Node other) {
			return this.freq - other.freq;
		}
	}
	
	/**
	 * 恢复原字符流的函数
	 */
	public static void expand() {
		//读取输入流中字典树
		Node root = readTrie();
		//读取字符总数
		int N = BinaryStdIn.readInt();
		//读取二进制输入流
		for(int i = 0; i < N; i++) {
			Node cur = root;
			while(!cur.isLeaf()){
				if(BinaryStdIn.readBoolean() == true)
					cur = cur.right;
				cur = cur.left;
			}
			BinaryStdOut.write(cur.ch);
		}
		BinaryStdOut.close();
	}
	
	public static void compress() {
		/*
		 * 1. 读取标准输入
		 * 2. 统计每个字符的出现频率
		 * 3. 根据字符频率创建huffman编码字典树
		 * 4. 创建与字典树对应的编码表
		 * 5. 向标准输出打印编码为二进制流的字典树
		 * 6. 向标准输出打印编码为二进制流的字符总数统计
		 * 7. 使用编码表打印编码后的输入字符串
		 */
		//统计字符频率
		int[] freq = new int[R];
		char[] chs = BinaryStdIn.readString().toCharArray();
		for(int i = 0; i < chs.length; i++) 
			freq[chs[i]]++;
		BinaryStdIn.close();
		//根据字符频率创建huffman编码字典树
		Node root = buildTrie(freq);
		//根据字典树创建与之对应的编码表
		String[] st = buildCode(root);
		//向标准输出打印编码为二进制流的字典树
		writeTrie(root);
		//向标准输出流打印字符总数
		BinaryStdOut.write(chs.length);
		//使用编码表打印编码后的字符串的二进制流
		compress(chs, st);
	}
	
	/**
	 * 压缩算法
	 */
	public static void compress(char[] chs, String[] st) {
		if(st == null) throw new RuntimeException("编码表未初始化");
		for(int i = 0; i < chs.length; i++) {
			String code = st[i];
			for(int j = 0; j < code.length(); j++) {
				if(code.charAt(j) == '1')
					BinaryStdOut.write(true);
				else 
					BinaryStdOut.write(false);
			}
			
		}
		BinaryStdOut.close();
	}
	/**
	 * 构建压缩编码需要使用到的编码表
	 * @param root
	 * @return
	 */
	private static String[] buildCode(Node root) {
		if(root == null) return null;
		String[] st = new String[R];
		buildCode(st, root, "");
		return st;
	}
	private static void buildCode(String[] st, Node x, String str){
		if(x == null) return;
		if(x.isLeaf()) {
			st[x.ch] = str;return;
		}
		buildCode(st, x.left, str+"0");
		buildCode(st, x.right, str+"1");
	}
	
	/**
	 * 读取输入流中的字典树
	 * @return
	 */
	private static Node readTrie() {
		Node root = new Node(null, null, 0, '\0');
		boolean isLeft = true;
		while(!BinaryStdIn.isEmpty()){
			Boolean isLeaf = BinaryStdIn.readBoolean();
			if(!isLeaf){
				Node n = new Node(null, null, 0, '\0');
				if(isLeft) root.left = n;
				else root.right = n;
			}else {
				Node n = new Node(null, null, 0, BinaryStdIn.readChar());
				if(isLeft) root.left = n;
				else root.right = n;
			}
			isLeft = !isLeft;
		}
		return root;
	}
	
	/**
	 * 根据字符频率数组构造字典树
	 * @param freq
	 * @return
	 */
	private static Node buildTrie(int[] freq) {
		//创建用于查找最小值的优先队列
		MinPQ<Node> pq = new MinPQ<Node>(freq.length);
		//遍历节点树容器构建字典树
		for(int i = 0; i < freq.length; i++) {
			if(freq[i] != 0) {
				pq.insert(new Node(null, null, freq[i], '\0'));
			}
		}
		while(pq.size() > 1){
			Node last = pq.deMin();
			Node seLst = pq.deMin();
			Node newNode = new Node(seLst, last, 
					last.freq + seLst.freq, '\0');
			pq.insert(newNode);
		}
		return pq.deMin();
	}

	/**
	 * 向标准输出流打印编码字典树
	 */
	private static void writeTrie(Node x) {
		/*
		 * 先序遍历该字典树
		 */
		if(x == null) return;
		//如果该节点是叶子节点
		if(x.isLeaf()) {
			//打印1
			BinaryStdOut.write(true);
			//打印该字符
			BinaryStdOut.write(x.ch);
		}else {                       //如果该节点不是叶子节点
			BinaryStdOut.write(false);
		}
		writeTrie(x.left);
		writeTrie(x.right);
	}
	
}