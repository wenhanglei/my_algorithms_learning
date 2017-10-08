
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	
	//���潡������
	private Key[] keys;
	//����ֵ������
	private Value[] values;
	//���ű�Ĵ�С
	private int N = 0;
	/**
	 * ���캯��
	 */
	public BinarySearchST(int capacity) {
		keys = (Key[])new Comparable[capacity];
		values = (Value[])new Object[capacity];
	}
	/**
	 * ���item
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val){
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0){
			values[i] = val; return;
		}
		for(int j = N; j > i; j--){
			keys[j] = keys[j-1]; values[j] = values[j-1];
		}
		keys[i] = key; values[i] = val;
		N++;
	}
	/**
	 * ���ؽ�key��ֵ
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) return values[i];
		else
			return null;
	}
	/**
	 * ɾ����ֵ��
	 * @param key
	 */
	public void delete(Key key) {
		
	}
	/**
	 * �Ƿ��н�Ϊkey��item
	 * @param key
	 * @return
	 */
	boolean contains(Key key) {
		return false;
	}
	/**
	 * �Ƿ�Ϊ��
	 * @return
	 */
	boolean isEmpty() {
		return N <= 0;
	}
	/**
	 * ����symboltable�Ĵ�С
	 * @return
	 */
	int size() {
		return N;
	}
	/**
	 * ��Χ��С�Ľ�
	 * @return
	 */
	Key min() {
		return keys[0];
	}
	/**
	 * �������Ľ�
	 * @return
	 */
	Key max() {
		return keys[N-1];
	}
	/**
	 * ���������С��key�Ľ�
	 * @param key
	 * @return
	 */
	Key floor(Key key) {
		return null;
	}
	/**
	 * ��������Ĵ���key�Ľ�
	 * @param key
	 * @return
	 */
	Key ceiling(Key key) {
		return keys[rank(key)];
	}
	/**
	 * ����key������
	 * @param key
	 * @return
	 */
	int rank(Key key) {
		int i = 0;
		int j = N-1;
		int mid = 0;
		while(i != j){
			mid = (i+j)/2;
			if(keys[mid].compareTo(key) == 0){
				return mid;
			} else if(keys[mid].compareTo(key) < 0){
				j = mid;
			}else {
				i = mid;
			}
		}
		return mid;
	}
	/**
	 * ���ص�k����
	 * @param k
	 * @return
	 */
	Key select(int k) {
		return keys[k];
	}
	/**
	 * ɾ����С��key
	 */
	void deleteMin() {
		
	}
	/**
	 * ɾ������key
	 */
	void deleteMax() {
		
	}
	/**
	 * ����lo��hi֮���key�ĸ���
	 * @param lo
	 * @param hi
	 * @return
	 */
	int size(Key lo, Key hi){
		return 0;
	}
	/**
	 * ����lo��hi֮���key�ĵ�����
	 * @param lo
	 * @param hi
	 * @return
	 */
	Iterable<Key> keys(Key lo, Key hi) {
		return null;
	}
}























