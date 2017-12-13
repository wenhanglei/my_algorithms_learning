package algorithms;

public class SeparateChainingHashST<Key, Value> {
	
	//散列值
	private int M;
	//哈希表的大小
	private int N;
	//用于保存数据的list数组
	private SequentialSearchST<Key, Value>[] st;
	
	
	/**
	 * 构造函数
	 */
	public SeparateChainingHashST() {
		this(997);
	}
	public SeparateChainingHashST(int M){
		st =(SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		this.M = M;
		for(int i = 0; i < M; i++){
			st[i] = new SequentialSearchST();
		}
	}
	/**
	 * 添加键值对
	 * @param key
	 * @param val
	 */
	void put(Key key, Value val){
		st[hash(key)].put(key, val);
		N++;
	}
	/**
	 * 返回键为key的值
	 * @param key
	 * @return
	 */
	Value get(Key key) {
		return (Value)st[hash(key)].get(key);
	}
	/**
	 * 删除键为key的键值对
	 * @param key
	 */
	void delete(Key key) {
		st[hash(key)].delete(key);
	}
	/**
	 * 是否存在健为key的键值对
	 * @param key
	 * @return
	 */
	boolean contains(Key key) {
		return st[hash(key)].contains(key);
	}
	/**
	 * 哈希表是否为空
	 * @param key
	 * @return
	 */
	boolean isEmpty(Key key) {
		return N == 0;
	}
	/**
	 * 哈希表的大小
	 * @return
	 */
	int size() {
		return N;
	}
	/**
	 * 返回可用于遍历该哈希表的迭代器
	 * @return
	 */
	Iterable<Key> keys() {
		return null;
	}
	/**
	 * 计算传入健的哈希值
	 * @param key
	 * @return
	 */
	private int hash(Key key){
		return((key.hashCode() & 0x7fffffff) % M);
	}
	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
















