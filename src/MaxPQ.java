
public class MaxPQ<Key extends Comparable<Key>> {
	//保存所有key的数组
	private Key[] pq;
	//优先队列的大小
	private int N = 0;
	
	/**
	 * 默认构造函数
	 */
	MaxPQ() {
		pq = (Key[])new Object[9];
		N = 8;
	}
	/**
	 * size为max的构造函数
	 * @param max
	 */
	MaxPQ(int max) {
		N = max;
		pq = (Key[])new Object[N+1];
	}
	/**
	 * 参数为a的构造函数
	 * @param a
	 */
	MaxPQ(Key[] a) {
		N = a.length;
		pq = (Key[])new Object[N+1];
		for(int i = 0; i < N; i++)
			pq[i+1] = a[i];
	}
	/**
	 * 插入数据v
	 * @param v
	 */
	void insert(Key v) {
		if(N == pq.length) resize(2*pq.length);
		pq[++N] = v;
		swim(N);
	}
	/**
	 * 返回最大值
	 * @return
	 */
	Key max() {
		return pq[1];
	}
	/**
	 * 移除并返回最大值
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
	 * 优先队列是否为空
	 * @return
	 */
	boolean isEmpty() { 
		return N > 0;
	}
	/**
	 * 返回优先队列size
	 * @return
	 */
	int size() {
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
		while(less(i/2, i) && i > 1) {
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
	 * 队列测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}



















