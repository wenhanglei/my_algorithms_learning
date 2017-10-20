
public class SeparateChainingHashST<Key, Value> {
	
	//ɢ��ֵ
	private int M;
	//��ϣ��Ĵ�С
	private int N;
	//���ڱ������ݵ�list����
	private SequentialSearchST<Key, Value>[] st;
	
	
	/**
	 * ���캯��
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
	 * ��Ӽ�ֵ��
	 * @param key
	 * @param val
	 */
	void put(Key key, Value val){
		st[hash(key)].put(key, val);
		N++;
	}
	/**
	 * ���ؼ�Ϊkey��ֵ
	 * @param key
	 * @return
	 */
	Value get(Key key) {
		return (Value)st[hash(key)].get(key);
	}
	/**
	 * ɾ����Ϊkey�ļ�ֵ��
	 * @param key
	 */
	void delete(Key key) {
		st[hash(key)].delete(key);
	}
	/**
	 * �Ƿ���ڽ�Ϊkey�ļ�ֵ��
	 * @param key
	 * @return
	 */
	boolean contains(Key key) {
		return st[hash(key)].contains(key);
	}
	/**
	 * ��ϣ���Ƿ�Ϊ��
	 * @param key
	 * @return
	 */
	boolean isEmpty(Key key) {
		return N == 0;
	}
	/**
	 * ��ϣ��Ĵ�С
	 * @return
	 */
	int size() {
		return N;
	}
	/**
	 * ���ؿ����ڱ����ù�ϣ��ĵ�����
	 * @return
	 */
	Iterable<Key> keys() {
		return null;
	}
	/**
	 * ���㴫�뽡�Ĺ�ϣֵ
	 * @param key
	 * @return
	 */
	private int hash(Key key){
		return((key.hashCode() & 0x7fffffff) % M);
	}
	/**
	 * ���Ժ���
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}

















