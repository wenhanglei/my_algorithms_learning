/**
 * LZW压缩算法
 * @author Administrator
 *
 */
public class LZW {
	//用于查找最长子串的字典树符号表
//	public static TrieST<Integer> codeword = new TrieST<Integer>(256);
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
		String s = BinaryStdIn.readString();
		//初始化字典树
//		for(int i = 41; i < 80; i++) 
//			codeword.put(String.valueOf(i), i);
		
	}
	/**
	 * 恢复算法
	 */
	public static void expand() {
		
	}
	
	public static void main(String[] args) {
		System.out.println(String.valueOf((char)65));
		System.out.println((int)'A');
	}

}
