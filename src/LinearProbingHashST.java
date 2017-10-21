
public class LinearProbingHashST<Key, Value> {
	
	//��ϣ�������ݵ�����
	private Key[] keys;
	private Value[] vals;
	//��ϣ�������
	private int M;
	//��ϣ��Ĵ�С
	private int N;
	
	/**
	 * ���캯��
	 */
	public LinearProbingHashST() {
	}
	/**
	 * �������Ĺ��캯��
	 * @param M
	 */
	public LinearProbingHashST(int M) {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
		this.M = M;
	}
	
	/**
	 * ��Ӽ�Ϊkey�ļ�ֵ��
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
	 * ���ؼ�Ϊkey��ֵ
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
	 * ɾ����Ϊkey�ļ�ֵ��
	 * @param key
	 */
	void delete(Key key) {
		//��������ǲ���ȷ��
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
	 * �Ƿ���ڽ�Ϊkey�ļ�ֵ��
	 * @param key
	 * @return
	 */
	boolean contains(Key key) {
		if(get(key) == null) return false;
		else return true;
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
