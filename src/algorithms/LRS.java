package algorithms;
/**
 * 查找文本中最长的至少重复一次的字符串(longest Repeated Substring)
 * @author wenhanglei
 */
public class LRS {
	private String Lrs;
	
	public LRS(String text) {
		//构造后缀数组
		SuffixArray sfa = new SuffixArray(text);
		//用于保存最长匹配前缀的长度
		int len = 0;
		//最长匹配前缀在后缀数组中的下标
		int index = 0;
		//遍历后缀数组查找最长匹配前缀的位置
		for(int i = 0; i < sfa.length(); i++) {
			if(sfa.lcp(i) > len){
				len = sfa.lcp(i);
				index = i;
			}
		}
		//获取最长匹配前缀的字符串并保存到Lrs中
		this.Lrs = sfa.select(index).substring(0, len);
		
	}
	
	public static void main(String[] args) {
		String tinyTale = "it was the best of times it was the worst of times"
				+ " it was the age of wisdom it was the age of foolishness"
				+ " it was the epoch of belief it was the epoch of incredulity"
				+ " it was the season of light it was the season of darkness"
				+ " it was the spring of hope it was the winter of despair";
		
		LRS lrs = new LRS(tinyTale);
		System.out.println(lrs.Lrs);
	}
}
