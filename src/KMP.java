
public class KMP {
	
	private static int R;
	//有限自动状态机
	private int[][] dfa;
	private String pat;
	
	/**
	 * 构造函数
	 * @param pat
	 */
	public KMP(String pat) {
		this.pat = pat;
		R = 256;
		int M = pat.length();
		dfa[pat.charAt(0)][0] = 1;
		for(int x = 0, j = 1; j < M; j++) {
			for(int i = 0; i < R; i++) 
				dfa[i][j] = dfa[i][x];
			dfa[pat.charAt(j)][j] = j+1;
			x = dfa[pat.charAt(j)][x];
		}
		
	}
	
	public int search(String text) {
		int N = text.length();
		int M = pat.length();
		int index = N;
		for(int i = 0, j = 0; i < N-M+1; i++) {
			if(j == M) { index = i-M; break; }
			j = dfa[text.charAt(i)][j];
		}
		return index;
	}
	
}
