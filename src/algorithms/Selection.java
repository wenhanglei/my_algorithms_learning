package algorithms;
import java.util.Scanner;


public class Selection {
	/**
	 * 排序算法
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
	 * 比较大小
	 */
	private boolean less(Comparable a, Comparable b) {
		return (a.compareTo(b) < 0);
	}
	/**
	 * 交换位置
	 * @param arr
	 */
	private void exch(Comparable[] arr, int a, int b) {
		Comparable tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	/**
	 * 显示排序结果
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
	 * 测试用的主函数
	 */
	public static void main(String[] args) {
		String[] data = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		Selection s = new Selection();
		s.sort(data);
		s.show(data);
	}
}
























