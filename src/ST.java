
public class ST<Key, Value> {
	/**
	 * ���ű�ĳ�ʼ������
	 */
	ST() {}
	/**
	 * �����ֵ��
	 * @param key
	 * @param val
	 */
	void put(Key key, Value val) {}
	/**
	 * ��ȡ��Ӧ����ֵ
	 * @param key
	 * @return
	 */
	Value get(Key key) {
		return null;
	}
	/**
	 * ɾ����ֵ��
	 * @param key
	 */
	void delete(Key key) {}
	/**
	 * �Ƿ��н�Ϊkey�ļ�ֵ��
	 * @param key
	 * @return
	 */
	boolean contains(Key key) {
		return false;
	}
	/**
	 * ���ű��Ƿ�Ϊ��
	 * @return
	 */
	boolean isEmpty() {
		return false;
	}
	/**
	 * ���ط��ű�Ĵ�С
	 * @return
	 */
	int size() {
		return 0;
	}
	/**
	 * ����key������
	 * @return
	 */
	Iterable<Key> keys() {
		return null;
	}
}




















