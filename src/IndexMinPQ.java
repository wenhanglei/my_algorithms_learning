
public class IndexMinPQ<Item extends Comparable<Item>> {
	//用于存储队列数据的数组
	private Integer[] heap;
	private Comparable[] pq;
	//队列size
	private int N = 0;
	
	/**
	 * 构造函数
	 * @param maxN
	 */
	IndexMinPQ(int maxN){
		pq = new Comparable[maxN];
		heap = new Integer[maxN+1];
	}
	/**
	 * 插入item并关联下标k
	 * @param k
	 * @param item
	 */
	void insert(int k, Item item) {
		heap[++N] = k;
		pq[k] = item;
		swim(N);
	}
	/**
	 * 改变下标k为item
	 * @param k
	 * @param item
	 */
	void change(int k, Item item) {
		pq[k] = item;
	}
	/**
	 * 下标k处是否包含item
	 * @param k
	 * @return
	 */
	boolean contains(int k) {
		return pq[k] != null;
	}
	/**
	 * 删除下标k处的item
	 * @param k
	 */
	void delete(int k) {
		pq[k] = null;
		
	}
	/**
	 * 返回最小item
	 * @return
	 */
	Item min() {
		return (Item)pq[minIndex()];
	}
	/**
	 * 返回 最小item的下标
	 * @return
	 */
	int minIndex() {
		return heap[1];
	}
	/**
	 * 删除最小item
	 * @return
	 */
	int delMin() {
		int tmp = heap[1];
		heap[1] = heap[N];
		heap[N--] = null;
		sink(1);
		return tmp;
	}
	/**
	 * 该队列是否为空
	 * @return
	 */
	boolean isEmpty() {
		return N <= 0;
	}
	/**
	 * 该队列的size
	 * @return
	 */
	int size() {
		return N;
	}
	
	private boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private void exch(int a, int b) {
		Integer tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	/**
	 * 恢复堆顺序
	 * @param i
	 */
	private void swim(int i) {
		while(less(pq[heap[i]], pq[heap[i/2]])) {
			exch(i, i/2);
			i = i/2;
		}
	}
	private void sink(int i) {
		while(2*i <= N){
			int j = 2*i;
			if(j < N && less(pq[heap[j++]], pq[heap[j]])) j++;
			if(less(pq[heap[i]], pq[heap[j]])) break;
			exch(i, j);
			i = j;
		}
	}

	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] data = {5, 2, 1, 3, 6};
		IndexMinPQ<Integer> pq = new IndexMinPQ<Integer>(5);
		System.out.println(pq.isEmpty());
		pq.insert(0, data[0]);
		pq.insert(1, data[1]);
		System.out.println(pq.isEmpty());
		System.out.println(pq.size());
	}
}


















