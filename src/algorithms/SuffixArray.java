package algorithms;
/**
 * 后缀数组实现类
 */
public class SuffixArray {
	
	private String[] array;                //后缀数组
	private int[] lcp;                     //后缀字符串对应的最长匹配前缀的长度数组
	private int N;                         //text的长度
	
	/**
	 * 后缀数组的构造函数
	 */
	public SuffixArray(String text) {
		//初始化text的长度
		this.N = text.length();
		//初始化后缀数组
		array = new String[N];
		//初始化后缀字符串的最长匹配前缀的长度数组
		lcp = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = text.substring(i);
		}
	}
	
	/**
	 * 用于构造后缀数组的文本长度
	 */
	public int length() {
		return N;
	}
	
	/**
	 * 返回后缀数组中的第i个后缀字符串
	 */
	public String select(int i) {
		return array[i];
	}
	
	/**
	 * 返回后缀数组中第i个后缀字符串在输入文本中的下标索引
	 */
	public int index(int i) {
		return N - select(i).length();
	}
	
	/**
	 * 返回后缀数组下标为i的后缀的最长匹配前缀的长度
	 */
	public int lcp(int i) {
		if(i == 0) return 0;
		String curr = select(i);
		String pre = select(i-1);
		return 0;
	}
	
	private int lcp(String a, String b) {
		int pre = 0;
		return 0;
	}
	
	/**
	 * 返回与字符串key相匹配的后缀字符串在该后缀数组中的下标位置
	 */
	public int rank(String key) {
		return 0;
	}
}
