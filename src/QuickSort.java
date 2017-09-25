import java.util.Arrays;


public class QuickSort {
	/**
	 * 排序算法
	 */
	public void sort(Comparable[] a) {
		int lo = 0;
		int hi = a.length-1;
		sort(a, lo, hi);
	}
	
	private void sort(Comparable[] a, int lo, int hi) {
		int mid = partition(a, lo, hi);
		sort(a, lo, mid-1);
		sort(a, mid+1, hi);
	}
	
	private int partition(Comparable[] a, int lo, int hi) {
		int mid = lo+1;
		while(mid < hi){
			if(less(a[lo], a[mid])){
				while(less(a[lo], a[hi])) hi--;
				exch(a, mid, hi);
				hi--;
				mid++;
			}else {
				while(less(a[mid], a[lo])) mid++;
				continue;
			}
		}
		exch(a, lo, hi);
		return hi;
	}
	
	/**
	 * 比较大小
	 */
	private static boolean less(Comparable a, Comparable b) {
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
//		String[] data = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
//		Integer[] data = {3, 1, 2, 5, 7, 6, 4};
//		String[] test = {"E", "E", "G", "M", "R", "A", "C", "E", "R", "T"};
		String[] data  = {"K", "R", "A", "T", "E", "L", "E", "P", "U", "I", "M", "Q", "C", "X", "O", "S" };
		QuickSort qs = new QuickSort();
		qs.sort(data);
		System.out.println(Arrays.toString(data));
	}
}
