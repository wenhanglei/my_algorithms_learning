package algorithms;

public class LSD {
	
	public static void sort(String[] a, int W){
		//获取字符串数组的大小
		int N = a.length;
		//创建辅助数组
		String[] aux = new String[N];
		//创建计数数组
		int[] count = new int[256+1];
		for(int j = 0; j < W; j++) {
			for(int i = 0; i < N; i++) {
				//获取最低有效位的在基数为256的数值
				int lsd = (int)a[i].charAt(W-1);
				count[lsd+1]++;
			}
			//计算最低有效位的下标
			for(int i = 0; i < N; i++) {
				count[i+1] += count[i];
			}
			//对辅助数组进行排序
			for(int i = 0; i < N; i++) {
				int lsd = (int)a[i].charAt(W-1);
				aux[count[lsd]++] = a[i];
			}
			//修改原数组中的排序
			for(int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
		}
	}

}