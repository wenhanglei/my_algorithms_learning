package my.algorithms.adt;

import java.util.Scanner;

public class UnfixedCapacityStack<Item> {
	//���ڱ������ݵ�String���� 
	private Item[] data;
	//���ڱ���stack��size
	private int N;
	/**
	 * ���캯��
	 */
	public UnfixedCapacityStack(int cap) {
		//��ʼ��stack�Ĵ�С
		data = (Item[])new Object[cap];
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
	public void push(Item s) {
		//���stack�Ĵ�С�Ƿ���
		//���stack����
		if (data.length == N) {
			resize(2*N);
		} else data[N++] = s;
	}
	/**
	 * ��ջ����
	 */
	public Item pop() {
		//�ı�stack�Ĵ�С�����data��sizeС���ķ�֮һ��a.length����
		Item temp = data[--N];
		//�����ε���Ttem����
		data[N] = null;
		//�ж��Ƿ�����ķ�֮һ
		if (N > 0 && N == data.length/4) resize(data.length/2);
		return temp;
	}
	/**
	 * ����stack��size
	 */
	public int size() {
		return N;
	}
	/**
	 * ���ӵ�ǰstack��ָ����С����ջ
	 */
	private void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	/**
	 * ����ջʵ�ֵ�Ƕ����
	 * @author Administrator
	 *
	 */
	static class Test {
		public static void main(String[] args) {
			//����stackʵ��
			UnfixedCapacityStack<String> stack = new UnfixedCapacityStack<String>(100);
			//�����ȡ�����scanner
			Scanner scanner = new Scanner(System.in);
			//��ȡ����̨����
			String input = scanner.nextLine();
			scanner.close();
			//�и��ַ���
			String[] data = input.split(" ");
			//�洢����
			for (int i = 0; i < data.length; i ++) {
				if (!data[i].equals("-")) {
					stack.push(data[i]);
				} else {
					System.out.print(stack.pop() + " ");
				}
			}
			System.out.println("(" + stack.size() + " left on the stack)");
		}
	}
}
























