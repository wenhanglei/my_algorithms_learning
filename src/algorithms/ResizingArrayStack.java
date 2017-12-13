package algorithms;
import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item> {
	//用于装载数据的数组
	private Item[] a;
	//当前stack的大小
	private int N;
	/**
	 * 初始化函数
	 */
	public ResizingArrayStack(int size) {
		a = (Item[])new Object[size];
	}
	/**
	 * 默认函数
	 */
	public ResizingArrayStack() {
	}
	/**
	 * 入栈方法
	 * @param i
	 */
	public void push(Item i) {
		if(N == a.length)
			resize(2 * a.length);
		a[N++] = i;

	}
	/**
	 * 出栈方法
	 * @return
	 */
	public Item pop() {
		Item temp = a[--N];
		a[N] = null;
		if(N > 0 && N == a.length/4) resize(a.length/2);
		return temp;
	}
	/**
	 * 返回stack的大小
	 * @return
	 */
	public int size() {
		return N;
	}
	/**
	 * 判断stack是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	/**
	 * 复制当前栈到指定大小的新栈
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