
public class KMP {
	
	private static int R;
	
	public static void search(String text, String pat) {
		int[][] dfa = new int[R][pat.length()];
		
		int x = 0;
		for(int i = 0; i < pat.length();) {
			for(int j = 0; j < R; j++) {
				dfa[j][i] = dfa[i][x];
			}
			dfa[pat.charAt(i)][i] = ++i;
			x = dfa[pat.charAt(i)][x];
		}
		
		
	}
	
}
