import java.util.Arrays;


public class TestPartition {
	public int partition(Comparable[] a , int lo, int hi) {
		int mid = lo + 1;
		if(less(a[lo], a[mid])) return mid;
		return 0;
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
	public static void main(String[] args) {
		Integer[] arr = {3, 1};
		TestPartition tp = new TestPartition();
		tp.partition(arr, 0, 1);
		System.out.println(Arrays.toString(arr));
	}
}
