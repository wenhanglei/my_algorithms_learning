import java.util.Arrays;


public class MergeBU {
	/**
	 * 辅助数组
	 */
	private static Comparable[] aux;
	/**
	 * 排序算法
	 */
	public void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1; sz < N; sz = sz + sz)
			for(int i = 0; i < N-sz; i =i+sz+sz)
				merge(a, i, i+sz-1, Math.min(i+sz+sz-1, N-1));
	}
	/**
	 * 归并方法
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 * @return
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		for(int i = 0; i < a.length; i++)
			aux[i] = a[i];
		int i = lo;
		int k = mid+1;
		for (int j = i;j < hi+1;j++){
			if(i < mid+1 && k < hi+1 && less(aux[i], aux[k])){
				a[j] = aux[i++]; 
			}else if(i < mid+1 && k < hi+1){
				a[j] = aux[k]; k++;
			}else if(i == mid+1){
				a[j] = aux[k++]; 
			}else{
				a[j] = aux[i++];
			}
		}
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
		String[] data = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
//		Integer[] data = {3, 1, 2, 5, 7, 6, 4};
//		String[] test = {"E", "E", "G", "M", "R", "A", "C", "E", "R", "T"};
		MergeSort ms = new MergeSort();
		ms.sort(data);
		System.out.println(Arrays.toString(data));
	}
}