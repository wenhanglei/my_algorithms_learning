
public class MSD {
	
	//传入的字符串数组
	private String[] a;
	//字母表中字母总数
	private int R = 256;
	//字母表
	private Alphabet alpha;
	
	/**
	 * 最高有效位字符串排序构造函数
	 * @param a
	 */
	public MSD(String[] a, Alphabet alpha) {
		this.a = a;
		this.alpha = alpha;
	}
	
	/**
	 * 最高有效位字符串排序实现
	 */
	public void sort() {
		int[] count = sort(0, a.length, 1);
		for(int i = 0; i < count.length; i++){
			sort(count[i], count[i+1], 2);
		}
	}
	
	private int[] sort(int lo, int hi, int w){
		//获取字符串数组的大小
		int N = hi-lo+1;
		//创建辅助数组
		String[] aux = new String[N];
		//创建频率计数数组
		int[] count = new int[R+2];
		//获取最高有效位基数为R的索引
		for(int i = 0; i < N; i++) {
			int msd = (int)toChar(a[i], w-1)+1;
			count[msd+1]++;
		}
		//计算最低有效位的下标
		for(int i = 0; i < N; i++) {
			count[i+1] += count[i];
		}
		//对辅助数组进行排序
		for(int i = 0; i < N; i++) {
			int msd = (int)toChar(a[i], w-1)+1;
			aux[count[msd]++] = a[i];
		}
		//修改原数组中的排序
		for(int i = 0; i < N; i++) {
			a[i] = aux[i];
		}
		return count;
	}
	
	private int toChar(String s, int i) {
		if(i > s.length()) return -1;
		return s.charAt(i);
	}
	
	public static void main(String[] args) {
		
	}
}












