
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	
	//保存健的数组
	private Key[] keys;
	//保存值的数组
	private Value[] values;
	//符号表的大小
	private int N = 0;
	/**
	 * 构造函数
	 */
	public BinarySearchST(int capacity) {
		keys = (Key[])new Comparable[capacity];
		values = (Value[])new Object[capacity];
	}
	/**
	 * 添加item
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
	 * 返回健key的值
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
	 * 删除键值对
	 * @param key
	 */
	public void delete(Key key) {
		
	}
	/**
	 * 是否含有健为key的item
	 * @param key
	 * @return
	 */
	boolean contains(Key key) {
		return false;
	}
	/**
	 * 是否为空
	 * @return
	 */
	boolean isEmpty() {
		return N <= 0;
	}
	/**
	 * 返回symboltable的大小
	 * @return
	 */
	int size() {
		return N;
	}
	/**
	 * 范围最小的健
	 * @return
	 */
	Key min() {
		return keys[0];
	}
	/**
	 * 返回最大的健
	 * @return
	 */
	Key max() {
		return keys[N-1];
	}
	/**
	 * 返回最近的小于key的健
	 * @param key
	 * @return
	 */
	Key floor(Key key) {
		return null;
	}
	/**
	 * 返回最近的大于key的健
	 * @param key
	 * @return
	 */
	Key ceiling(Key key) {
		return keys[rank(key)];
	}
	/**
	 * 返回key的排序
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
	 * 返回第k个健
	 * @param k
	 * @return
	 */
	Key select(int k) {
		return keys[k];
	}
	/**
	 * 删除最小的key
	 */
	void deleteMin() {
		
	}
	/**
	 * 删除最大的key
	 */
	void deleteMax() {
		
	}
	/**
	 * 返回lo与hi之间的key的个数
	 * @param lo
	 * @param hi
	 * @return
	 */
	int size(Key lo, Key hi){
		return 0;
	}
	/**
	 * 返回lo，hi之间的key的迭代器
	 * @param lo
	 * @param hi
	 * @return
	 */
	Iterable<Key> keys(Key lo, Key hi) {
		return null;
	}
}























