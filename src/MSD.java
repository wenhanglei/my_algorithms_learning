
public class MSD {
	
	//字母表中字母总数
	private static int R = 256;
	private static String[] aux;
	//字母表
	private static Alphabet alpha;

	
	/**
	 * 最高有效位字符串排序实现
	 */
	public static void sort(String[] a) {
		if(a == null) return;
		
	}
	
	private static void sort(String[] a, int lo, int hi, int index){
		//获取字符串数组的大小
		int N = hi-lo;
		//创建辅助数组
		aux = new String[N];
		//创建频率计数数组
		int[] count = new int[R+2];
		//获取最高有效位基数为R的索引
		for(int i = 0; i < N; i++) {
			int msd = (int)toChar(a[i], index)+1;
			count[msd+1]++;
		}
		//计算最低有效位的下标
		for(int i = 0; i < N; i++) {
			count[i+1] += count[i];
		}
		//对辅助数组进行排序
		for(int i = 0; i < N; i++) {
			int msd = (int)toChar(a[i], index)+1;
			aux[count[msd]++] = a[i];
		}
		//修改原数组中的排序
		for(int i = 0; i < N; i++) {
			a[i] = aux[i];
		}
		
		for(int i = 0; i < count.length; i++) {
			sort(a, count[i], count[i+1], index+1);
		}
	}
	
	private static int toChar(String s, int i) {
		if(i > s.length()) return -1;
		return s.charAt(i);
	}
	
	public static void main(String[] args) {
		
	}
}











