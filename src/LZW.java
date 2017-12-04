/**
 * LZW压缩算法
 * @author Administrator
 *
 */
public class LZW {
	//输入字符的数量
	private static final int R = 256;
	//编码后的编码字符的数量
	private static final int L = 4096;
	//编码位宽
	private static final int W = 12;
	/**
	 * 压缩算法
	 */
	public static void compress() {
		/*
		 * 1. 从标准输入中读取字符串s
		 * 2. 在编码表中查找与s匹配的最大前缀
		 * 3. 输出该前缀对应的8bit编码
		 * 4. 读取s后的一个字符添加到该前缀之后组成新的前缀保存到编码表中
		 * 		* 如果编码表中的索引用完则不在装载
		 */
		//获取字符串
		String input = BinaryStdIn.readString();
		//初始化字典树
		TrieST<Integer> st = new TrieST<Integer>();
		for(int i = 0; i < R; i++) {
			st.put("" + (char)i, i);
		}
		//R表示文件尾
		int code = R+1;
		while(input.length() > 0) {
			//获取当前字典树中最长子串
			String s = st.longestPrefixOf(input);
			//向标准输出中打印编码后的子串
			BinaryStdOut.write(st.get(s), W);
			int t = s.length();
			//将s添加到符号表
			if(t < input.length() && code < L)
				st.put(input.substring(0,t+1), code++);
			input = input.substring(t);
		}
		//打印eof符号
		BinaryStdOut.write(R);
		//关闭输出连接
		BinaryStdOut.close();
	}
	/**
	 * 恢复算法
	 */
	public static void expand() {
		//构造用于解码的字符串数组
		String[] st = new String[L];
		//下一个可用的编码值
		int i;
		//使用字符初始化字符串数组
		for(i = 0; i < R; i++) 
			st[i] = "" + (char)i;
		st[i++] = " ";
		int codeword = BinaryStdIn.readInt(W);
		String val = st[codeword];
		while(true) {
			//向标准输出打印当前子串
			BinaryStdOut.write(val);
			codeword = BinaryStdIn.readInt(W);
			//如果碰到eof符号停止运行
			if (codeword == R) break;
			String s = st[codeword];
			if(i == codeword)
				s = val + val.charAt(0);
			if(i < L)
				st[i++] = val + s.charAt(0);
			val = s;
		}
		BinaryStdOut.close();
	}
	
	public static void main(String[] args) {
		System.out.println(String.valueOf((char)65));
		System.out.println((int)'A');
	}

}
