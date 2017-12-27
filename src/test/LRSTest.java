package test;
/**
 * 给定两个字符串，查找它们的最长匹配的前缀（longest common prefix）LCP
 */
public class LRSTest {
	
	/**
	 * 获取两个字符串中的最长匹配前缀的长度
	 */
	public static int lcp(String str1, String str2){
		int N = Math.min(str1.length(), str2.length());
		for(int i = 0; i < N; i++)
			if(str1.charAt(i) != str2.charAt(i)) return i;
		return N;
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		LRSTest test = new LRSTest();
		int lcp = lcp("acctgttaac", "accgttaa");
		System.out.println(lcp);
	}
}
