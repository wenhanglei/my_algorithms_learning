
public class IndexMinPQ<Item extends Comparable<Item>> {
	//���ڴ洢�������ݵ�����
	private Integer[] heap;
	private Comparable[] pq;
	//����size
	private int N = 0;
	
	/**
	 * ���캯��
	 * @param maxN
	 */
	IndexMinPQ(int maxN){
		pq = new Comparable[maxN];
		heap = new Integer[maxN+1];
	}
	/**
	 * ����item�������±�k
	 * @param k
	 * @param item
	 */
	void insert(int k, Item item) {
		heap[++N] = k;
		pq[k] = item;
		swim(N);
	}
	/**
	 * �ı��±�kΪitem
	 * @param k
	 * @param item
	 */
	void change(int k, Item item) {
		pq[k] = item;
	}
	/**
	 * �±�k���Ƿ����item
	 * @param k
	 * @return
	 */
	boolean contains(int k) {
		return pq[k] != null;
	}
	/**
	 * ɾ���±�k����item
	 * @param k
	 */
	void delete(int k) {
		pq[k] = null;
		
	}
	/**
	 * ������Сitem
	 * @return
	 */
	Item min() {
		return (Item)pq[minIndex()];
	}
	/**
	 * ���� ��Сitem���±�
	 * @return
	 */
	int minIndex() {
		return heap[1];
	}
	/**
	 * ɾ����Сitem
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
	 * �ö����Ƿ�Ϊ��
	 * @return
	 */
	boolean isEmpty() {
		return N <= 0;
	}
	/**
	 * �ö��е�size
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
	 * �ָ���˳��
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
	 * ���Է���
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



















