import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item> {
	//����װ�����ݵ�����
	private Item[] a;
	//��ǰstack�Ĵ�С
	private int N;
	/**
	 * ��ʼ������
	 */
	public ResizingArrayStack(int size) {
		a = (Item[])new Object[size];
	}
	/**
	 * Ĭ�Ϻ���
	 */
	public ResizingArrayStack() {
	}
	/**
	 * ��ջ����
	 * @param i
	 */
	public void push(Item i) {
		if(N == a.length)
			resize(2 * a.length);
		a[N++] = i;

	}
	/**
	 * ��ջ����
	 * @return
	 */
	public Item pop() {
		Item temp = a[--N];
		a[N] = null;
		if(N > 0 && N == a.length/4) resize(a.length/2);
		return temp;
	}
	/**
	 * ����stack�Ĵ�С
	 * @return
	 */
	public int size() {
		return N;
	}
	/**
	 * �ж�stack�Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	/**
	 * ���Ƶ�ǰջ��ָ����С����ջ
	 */
	private void resize(int maxSize) {
		Item[] temp = (Item[])new Object[maxSize];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}
	
	@Override
	public Iterator<Item> iterator() {
		 return new Iterator<Item>() {
			 private int i = N;

			@Override
			public boolean hasNext() {
				return i > 0;
			}

			@Override
			public Item next() {
				return a[--i];
			}

			@Override
			public void remove() {
			
			}
		 };
	}

}
