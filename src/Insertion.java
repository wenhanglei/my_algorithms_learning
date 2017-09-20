
public class Insertion {
	/**
	 * 排序算法
	 */
	public void sort(Comparable[] a) {
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
//		Integer[] data = {3, 1, 2, 5, 7, 6, 4};
		Insertion s = new Insertion();
		s.sort(data);
		s.show(data);
	}
}
