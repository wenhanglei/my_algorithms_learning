package my.algorithms.adt;

public class FixedCapacityStackOfStrings {
	//���ڱ������ݵ�String���� 
	private String[] data;
	//���ڱ���stack��size
	private int N;
	/**
	 * ���캯��
	 */
	public FixedCapacityStackOfStrings(int cap) {
		//��ʼ��stack�Ĵ�С
		data = new String[cap];
	}
	/**
	 * �ж��Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return N==0;
	}
	/**
	 * ��ջ����
	 */
	public void push(String s) {
		//�����ַ���
		data[N++] = s;
	}
	/**
	 * ��ջ����
	 */
	public String pop() {
		//�ı�stack�Ĵ�С
		return data[--N];
	}
	/**
	 * ����stack��size
	 */
	public int size() {
		return N;
	}
}
























