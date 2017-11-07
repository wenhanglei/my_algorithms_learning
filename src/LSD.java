
public class LSD {
	
	public static void sort(String[] a, int W){
		//��ȡ�ַ�������Ĵ�С
		int N = a.length;
		//������������
		String[] aux = new String[N];
		//������������
		int[] count = new int[256+1];
		for(int j = 0; j < W; j++) {
			for(int i = 0; i < N; i++) {
				//��ȡ�����Чλ���ڻ���Ϊ256����ֵ
				int lsd = (int)a[i].charAt(W-1);
				count[lsd+1]++;
			}
			//���������Чλ���±�
			for(int i = 0; i < N; i++) {
				count[i+1] += count[i];
			}
			//�Ը��������������
			for(int i = 0; i < N; i++) {
				int lsd = (int)a[i].charAt(W-1);
				aux[count[lsd]++] = a[i];
			}
			//�޸�ԭ�����е�����
			for(int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
		}
	}

}
