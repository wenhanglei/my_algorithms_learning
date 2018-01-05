package algorithms;

/**
 * 查找关键字在文本上下文中的出现位置（Key-Work-In-Context）
 * 
 * @author wenhanglei
 */
public class KWIC {
	public static void main(String[] args) {
		// 用于查找的文本，可以从文件中读取
		String text = "";
		// 通过输入的文本创建后缀数组
		SuffixArray sfa = new SuffixArray(text);
		// 需要查找的关键字，可以从控制台读取
		String key = "";
		// 查找并显示所有包含关键字的上下文
		for (int i = sfa.rank(key); i < sfa.length()
				&& sfa.select(i).startsWith(key); i++) {
			int begin = sfa.index(i);
			int end = begin+10;
			System.out.println(text.substring(begin, end));
		}
	}
}
