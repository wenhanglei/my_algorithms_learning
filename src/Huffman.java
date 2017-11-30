import java.util.ArrayList;
import java.util.List;

/**
 * 霍夫曼编码
 * @author Administrator
 *
 */
public class Huffman {
	//字符表的总的字符个数
	private int R = 256;
	//编码表
	private String[] st;
	//用于构建编码表的字典树
	private Node root;
	
	/**
	 * 节点类
	 * @author Administrator
	 */
	private class Node implements Comparable<Node>{
		//左字典树
		private Node left;
		//右字典树
		private Node right;
		//字符频率
		private int freq;
		//存储在该节点的字符
		private char ch;
		
		public Node() {
		}
		
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
	public void expand() {
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
	
	/**
	 * 压缩算法
	 */
	public void compress() {
		if(st == null) throw new RuntimeException("编码表未初始化");
		while(!BinaryStdIn.isEmpty()){
			//从标准输入读取一个字符
			char ch = BinaryStdIn.readChar();
			String code = st[ch];
			if(code != null && !code.equals("")){
				for(int i = 0; i < code.length(); i++) {
					BinaryStdOut.write(
							code.charAt(i)=='1'?true:false);
				}
			}
		}
		BinaryStdOut.close();
	}
	
	/**
	 * 构建压缩编码需要使用到的编码表
	 */
	private void buildCode() {
		/*
		 * 1. 遍历整个字典树
		 * 2. 保存经过的路径
		 */
		st = new String[R];
		reverse(root, "");
	}
	
	private void reverse(Node x, String code) {
		if(x.isLeaf()) {
			st[x.ch] = code;
			return;
		}
		reverse(x.left, code+"0");
		reverse(x.right, code+"1");
	}
	
	/**
	 * 读取输入流中的字典树
	 * @return
	 */
	private Node readTrie() {
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
	 * 构造字典树
	 * @return
	 */
	private Node buildTrie() {
		//用于保存字典树节点的容器
		Node[] nodes = new Node[R];
		//从标准输入中读取所有字符
		String s = BinaryStdIn.readString();
		//nodes中非空节点的个数
		int num = 0;
		//遍历该字符串获得所有的字符计算频度
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(nodes[c] == null) {
				nodes[c] = new Node(null,null,1,c);
				num++;
			}
			else nodes[c].freq++;
		}
		//创建用于查找最小值的优先队列
		MinPQ<Node> pq = new MinPQ<Node>(num);
		//遍历节点树容器构建字典树
		for(int i = 0; i < nodes.length; i++) {
			if(nodes[i] != null) {
				pq.insert(nodes[i]);
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
	private void writeTrie(Node x) {
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
	
	public static void main(String[] args) {
		Huffman hfm = new Huffman();
		hfm.compress();
	}

}













