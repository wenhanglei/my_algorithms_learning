package my.algorithms.adt;

import java.util.Scanner;

public class FixedCapacityStack<Item> {
	//���ڱ������ݵ�String���� 
	private Item[] data;
	//���ڱ���stack��size
	private int N;
	/**
	 * ���캯��
	 */
	public FixedCapacityStack(int cap) {
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
		//�����ַ���
		data[N++] = s;
	}
	/**
	 * ��ջ����
	 */
	public Item pop() {
		//�ı�stack�Ĵ�С
		return data[--N];
	}
	/**
	 * ����stack��size
	 */
	public int size() {
		return N;
	}
	
	static class Test {
		public static void main(String[] args) {
			//����stackʵ��
			FixedCapacityStack<String> stack = new FixedCapacityStack<String>(100);
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
























