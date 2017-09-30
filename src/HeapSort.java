
public class HeapSort {
	
	public static void sort(Comparable[] a) {
		int N = a.length/2;
		while(N>=1)
			sink(a, N--, a.length);
		for(int i = 1; i < a.length; i++){
			exch(a, 0, a.length-i);
			sink(a, 1, a.length-i);
		}
		
	}
	
	
	public static void sink(Comparable[] a, int i, int N) {
		while(2*i <= N){
			int j = 2*i;
			if(j+1 <= N && less(a[j], a[j-1])) j--;
			if(!less(a[i-1], a[j])) break;
			exch(a, i-1, j);
			i = j+1;
		}
	}
	
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	public static void exch(Comparable[] arr, int a, int b) {
		Comparable tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void main(String[] args) {
		String[] data = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		HeapSort hs = new HeapSort();
		HeapSort.sort(data);
		
	}
}
