import java.util.Arrays;


public class QuickSort {
	/**
	 * �����㷨
	 */
	public void sort(Comparable[] a) {
		int lo = 0;
		int hi = a.length-1;
		sort(a, lo, hi);
	}
	
	private void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		int mid = partition(a, lo, hi);
		sort(a, lo, mid-1);
		sort(a, mid+1, hi);
	}
	/**
	 * �Ż���ķָ��㷨
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		Comparable v = a[lo];        //�ָ�ֵ
		while(true) {
			while(less(a[++i], v)) if(i == hi) break;
			while(less(v, a[--j])) if(j == lo) break;
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	/**
	 * �㶼�����ŵĴ���
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 *//*
	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo+1;
		if(i == hi) {
			if(less(a[i], a[lo]))
				exch(a, lo, i); 
			return hi;
		} else {
			while(true) {
				while(i <= hi && !less(a[lo], a[i])) i++;
				if(i > hi){
					exch(a, lo, hi);
					return hi;
				}
				while(less(a[lo], a[hi]) && hi > lo) hi--;
				if(hi == lo){
					return hi;
				}
				if(i < hi)
					exch(a, i, hi);
				else {
					exch(a, lo, hi);
					return hi;
				}
			}
		}
	}*/
	
	/**
	 * �Ƚϴ�С
	 */
	private static boolean less(Comparable a, Comparable b) {
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
//		String[] data = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
//		Integer[] data = {3, 1, 2, 5, 7, 6, 4};
//		String[] test = {"E", "E", "G", "M", "R", "A", "C", "E", "R", "T"};
		String[] data  = {"K", "R", "A", "T", "E", "L", "E", "P", "U", "I", "M", "Q", "C", "X", "O", "S" };
		QuickSort qs = new QuickSort();
		qs.sort(data);
		System.out.println(Arrays.toString(data));
	}
}
