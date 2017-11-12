
public class BruteForceSubstringSearch {
	
	public static int search(String text, String pat) {
		
		//�ı��ܵ��ַ���
		int N = text.length();
		//ģ���ַ������ַ���
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
		String text = "������ְ֣�������!";
		String pat = "�ְ�";
		System.out.println(search(text, pat));
	}
}
