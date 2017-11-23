
public class LinearProbingHashST<Key, Value> {
	
	//哈希表保存数据的容器
	private Key[] keys;
	private Value[] vals;
	//哈希表的容量
	private int M;
	//哈希表的大小
	private int N;
	
	/**
	 * 构造函数
	 */
	public LinearProbingHashST() {
	}
	/**
	 * 带参数的构造函数
	 * @param M
	 */
	public LinearProbingHashST(int M) {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
		this.M = M;
	}
	
	/**
	 * 添加键为key的键值对
	 * @param key
	 */
	void put(Key key, Value val){
		int index = hash(key);
		if(keys[index].equals(key)) vals[index] = val;
		else if(keys[index] == null) {
			keys[index] = key;
			vals[index] = val;
			N++;
		}else{
			for(;keys[index].equals(key) || keys[index] == null;index = (index++)%M);
			if(keys[index] == null) keys[index] = key;
			vals[index] = val;
			N++;
		}
	}
	/**
	 * 返回键为key的值
	 * @param key
	 * @return
	 */
	Value get(Key key) {
		int index = hash(key);
		if(keys[index] == null) return null;
		else if(keys[index].equals(key)) return vals[index];
		else {
			for(;keys[index].equals(key) || keys[index] == null;index = (index++)%M);
			if(keys[index] == null) return null;
			return vals[index];
		}
	}
	/**
	 * 删除键为key的键值对
	 * @param key
	 */
	void delete(Key key) {
		//这个方法是不正确的
		/*int index = hash(key);
		if(keys[index].equals(key)){
			vals[index] = null;
			N--;
		}else{
			for(;keys[index].equals(key) || keys[index] == null; index=(index++)%M);
			if(keys[index].equals(key)) vals[index] = null;
			N--;
		}*/
	}
	/**
	 * 是否存在健为key的键值对
	 * @param key
	 * @return
	 */
	boolean contains(Key key) {
		if(get(key) == null) return false;
		else return true;
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