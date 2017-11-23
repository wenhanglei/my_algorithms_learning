
public class MinPQ<Key extends Comparable> {
	
	private Key[] pq;
	private int N = 0;
	
	public MinPQ() {
		pq = (Key[])new Object[9];
		N = 8;
	}
	
	public MinPQ(int max) {
		N = max;
		pq = (Key[])new Object[N+1];
	}
	
	public MinPQ(Key[] a) {
		N = a.length;
		pq = (Key[])new Object[N+1];
		for(int i = 0; i < N; i++)
			pq[i+1] = a[i];
	}
	
	public void insert(Key v) {
		if(N == pq.length) resize(2*pq.length);
		pq[++N] = v;
		swim(N);
		
	}
	
	public Key min() {
		return pq[1];
	}
	
	public Key deMin() {
		if(pq.length/4 == N) resize(pq.length/2);
		Key tmp = pq[1];
		pq[1] = pq[N];
		pq[N--] = null;
		sink(1);
		return tmp;
	}
	
	public boolean isEmpty() {
		return N > 0;
	}
	
	public int size() {
		return N;
	}
	
	/**
	 * 比较a， b下标处key的大小
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean less(int a, int b) {
		return pq[a].compareTo(pq[b]) < 0;
	}
	/**
	 * 交换a，b处的key
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
	 * 恢复二叉堆的顺序
	 */
	private void swim(int i) {
		while(less(i, i/2) && i > 1) {
			exch(i, i/2);
			i = i/2;
		}
	}
	/**
	 * 置顶向下的恢复二叉堆的顺序
	 * @param i
	 */
	private void sink(int i) {
		while(2*i <= N){
			int j = 2*i;
			if(j < N && less(j+1, j)) j++;
			if(less(i, j)) break;
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

}












