
public class BruteForceSubstringSearch {
	
	public static int search(String text, String pat) {
		
		//文本总的字符数
		int N = text.length();
		//模版字符串的字符数
		int M = pat.length();
		
		for(int i = 0;i < N-M+1;i++) {
			int j;
			for(j = 0; j < M; j++) {
				if(text.charAt(i+j) != pat.charAt(j)) break;
			}
			if(j == M) return i;
		}
		return N;
	}
	
	public static void main(String[] args) {
		String text = "我是你爸爸，大撒比!";
		String pat = "爸爸";
		System.out.println(search(text, pat));
	}
}
