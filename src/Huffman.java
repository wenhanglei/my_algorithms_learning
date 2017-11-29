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
	private class Node{
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
		private int CompareTo(Node other) {
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
			if(!code.equals("")) st[x.ch] = code;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		Huffman hfm = new Huffman();
		hfm.compress();
	}

}













