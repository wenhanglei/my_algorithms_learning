
public class MSD {
	
	//��ĸ������ĸ����
	private static int R = 256;
	private static String[] aux;
	//��ĸ��
	private static Alphabet alpha;

	
	/**
	 * �����Чλ�ַ�������ʵ��
	 */
	public static void sort(String[] a) {
		if(a == null) return;
		
	}
	
	private static void sort(String[] a, int lo, int hi, int index){
		//��ȡ�ַ�������Ĵ�С
		int N = hi-lo;
		//������������
		aux = new String[N];
		//����Ƶ�ʼ�������
		int[] count = new int[R+2];
		//��ȡ�����Чλ����ΪR������
		for(int i = 0; i < N; i++) {
			int msd = (int)toChar(a[i], index)+1;
			count[msd+1]++;
		}
		//���������Чλ���±�
		for(int i = 0; i < N; i++) {
			count[i+1] += count[i];
		}
		//�Ը��������������
		for(int i = 0; i < N; i++) {
			int msd = (int)toChar(a[i], index)+1;
			aux[count[msd]++] = a[i];
		}
		//�޸�ԭ�����е�����
		for(int i = 0; i < N; i++) {
			a[i] = aux[i];
		}
		
		for(int i = 0; i < count.length; i++) {
			sort(a, count[i], count[i+1], index+1);
		}
	}
	
	private static int toChar(String s, int i) {
		if(i > s.length()) return -1;
		return s.charAt(i);
	}
	
	public static void main(String[] args) {
		
	}
}












