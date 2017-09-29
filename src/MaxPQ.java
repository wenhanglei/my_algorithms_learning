
public class MaxPQ<Key extends Comparable<Key>> {
	//��������key������
	private Key[] pq;
	//���ȶ��еĴ�С
	private int N = 0;
	
	/**
	 * Ĭ�Ϲ��캯��
	 */
	MaxPQ() {
		pq = (Key[])new Object[9];
		N = 8;
	}
	/**
	 * sizeΪmax�Ĺ��캯��
	 * @param max
	 */
	MaxPQ(int max) {
		N = max;
		pq = (Key[])new Object[N+1];
	}
	/**
	 * ����Ϊa�Ĺ��캯��
	 * @param a
	 */
	MaxPQ(Key[] a) {
		N = a.length;
		pq = (Key[])new Object[N+1];
		for(int i = 0; i < N; i++)
			pq[i+1] = a[i];
	}
	/**
	 * ��������v
	 * @param v
	 */
	void insert(Key v) {
		if(N == pq.length) resize(2*pq.length);
		pq[++N] = v;
		swim(N);
	}
	/**
	 * �������ֵ
	 * @return
	 */
	Key max() {
		return pq[1];
	}
	/**
	 * �Ƴ����������ֵ
	 * @return
	 */
	Key delMax() {
		if(pq.length/4 == N) resize(pq.length/2);
		Key tmp = pq[1];
		pq[1] = pq[N];
		pq[N--] = null;
		sink(1);
		return tmp;
	}
	/**
	 * ���ȶ����Ƿ�Ϊ��
	 * @return
	 */
	boolean isEmpty() { 
		return N > 0;
	}
	/**
	 * �������ȶ���size
	 * @return
	 */
	int size() {
		return N;
	}
	/**
	 * �Ƚ�a�� b�±괦key�Ĵ�С
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean less(int a, int b) {
		return pq[a].compareTo(pq[b]) < 0;
	}
	/**
	 * ����a��b����key
	 * @param a
	 * @param b
	 */
	private void exch(int a, int b) {
		Key tmp = (Key)new Object();
		tmp = pq[a];
		pq[a] = pq[b];
		pq[b] = tmp;
	}
	/**
	 * �ָ�����ѵ�˳��
	 */
	private void swim(int i) {
		while(less(i/2, i) && i > 1) {
			exch(i, i/2);
			i = i/2;
		}
	}
	/**
	 * �ö����µĻָ�����ѵ�˳��
	 * @param i
	 */
	private void sink(int i) {
		while(2*i <= N){
			int j = 2*i;
			if(j < N && less(j, j+1)) j++;
			if(less(j, i)) break;
			exch(i, j);
			i = j;
		}
	}
	private void resize(int maxSize) {
		Key[] temp = (Key[])new Object[maxSize];
		for (int i = 1; i <= N; i++)
			temp[i] = pq[i];
		pq = temp;
	}
	/**
	 * ���в��Է���
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}




















