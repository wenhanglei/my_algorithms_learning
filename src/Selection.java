import java.util.Scanner;


public class Selection {
	/**
	 * �����㷨
	 */
	public void sort(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			int min = i;
			for(int j = i+1; j < a.length; j++) {
				if(less(a[j], a[min]))
					min = j;
			}
			exch(a, min, i);
		}
	}
	/**
	 * �Ƚϴ�С
	 */
	private boolean less(Comparable a, Comparable b) {
		return (a.compareTo(b) < 0);
	}
	/**
	 * ����λ��
	 * @param arr
	 */
	private void exch(Comparable[] arr, int a, int b) {
		Comparable tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	/**
	 * ��ʾ������
	 */
	public void show(Comparable[] a){
		for(int i = 0; i < a.length; i++) {
			if (i == a.length-1)
				System.out.print(a[i]);
			else
				System.out.print(a[i] + ", ");
		}
	}
	/**
	 * �����õ�������
	 */
	public static void main(String[] args) {
		String[] data = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		Selection s = new Selection();
		s.sort(data);
		s.show(data);
	}
}

























