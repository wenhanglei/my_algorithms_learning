
public class MSD {
	
	//������ַ�������
	private String[] a;
	//��ĸ������ĸ����
	private int R = 256;
	//��ĸ��
	private Alphabet alpha;
	
	/**
	 * �����Чλ�ַ��������캯��
	 * @param a
	 */
	public MSD(String[] a, Alphabet alpha) {
		this.a = a;
		this.alpha = alpha;
	}
	
	/**
	 * �����Чλ�ַ�������ʵ��
	 */
	public void sort() {
		int[] count = sort(0, a.length, 1);
		for(int i = 0; i < count.length; i++){
			sort(count[i], count[i+1], 2);
		}
	}
	
	private int[] sort(int lo, int hi, int w){
		//��ȡ�ַ�������Ĵ�С
		int N = hi-lo+1;
		//������������
		String[] aux = new String[N];
		//����Ƶ�ʼ�������
		int[] count = new int[R+2];
		//��ȡ�����Чλ����ΪR������
		for(int i = 0; i < N; i++) {
			int msd = (int)toChar(a[i], w-1)+1;
			count[msd+1]++;
		}
		//���������Чλ���±�
		for(int i = 0; i < N; i++) {
			count[i+1] += count[i];
		}
		//�Ը��������������
		for(int i = 0; i < N; i++) {
			int msd = (int)toChar(a[i], w-1)+1;
			aux[count[msd]++] = a[i];
		}
		//�޸�ԭ�����е�����
		for(int i = 0; i < N; i++) {
			a[i] = aux[i];
		}
		return count;
	}
	
	private int toChar(String s, int i) {
		if(i > s.length()) return -1;
		return s.charAt(i);
	}
	
	public static void main(String[] args) {
		
	}
}












