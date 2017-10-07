
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	/**
	 * 构造函数
	 */
	public BinarySearchST() {
		
	}
	/**
	 * 添加item
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val){
		
	}
	/**
	 * 返回健key的值
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
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
		return false;
	}
	/**
	 * 返回symboltable的大小
	 * @return
	 */
	int size() {
		return 0;
	}
	/**
	 * 范围最小的健
	 * @return
	 */
	Key min() {
		return null;
	}
	/**
	 * 返回最大的健
	 * @return
	 */
	Key max() {
		return null;
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
		return null;
	}
	/**
	 * 返回key的排序
	 * @param key
	 * @return
	 */
	int rank(Key key) {
		return 0;
	}
	/**
	 * 返回第k个健
	 * @param k
	 * @return
	 */
	Key select(int k) {
		return null;
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























