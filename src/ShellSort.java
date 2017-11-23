
public class ShellSort {
	/**
	 * 排序算法
	 */
	public void sort(Comparable[] a) {
		int N = a.length;
		int n = (int)(Math.log(2*N+1)/Math.log(3));
		for (int i = n; i > 0; i--){
			int j = (int)((Math.pow(3, i)-1)/2);
			for(int k = 0; k < j; k++){
				for(int l = k+j; l < N; l += j){
					for(int m = l; m > k && less(a[m], a[m-j]); m -= j)
						exch(a, m, m-j);
				}
			}
		}
	}
	/*public void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(less(a[i], a[j])) {
					Comparable tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
			}
		}
	}*/
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
//		Integer[] data = {3, 1, 2, 5, 7, 6, 4};
		ShellSort s = new ShellSort();
		s.sort(data);
		s.show(data);
	}
}