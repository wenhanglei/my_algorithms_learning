package algorithms;

public class WeightedQuickUnionUF {
	//保存的所有sites
	private int[] id;
	//component的数量
	private int N;
	//各节点所属树的size
	private int[] size;
	/**
	 * 构造函数
	 */
	public WeightedQuickUnionUF(int i) {
		//初始化数组
		id = new int[i];
		size = new int[i];
		for (int j = 0; j < i; j++) {
			id[j] = j;
			size[j] = 1;
		}
		//初始化component数量
		N = i;
	}
	/**
	 * 关联两个site
	 */
	//weighted quick union实现
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if( i == j) return;
		if(size[i] < size[j]) {
			id[j] = id[i];
			size[i] += size[j];
		}
		id[i] = id[j];
		size[j] += size[i];
		N--;
	}
	/**
	 * 查找特定site属于那个component
	 */
	//weighted quick union实现
	public int find(int p) {
		while(p != id[p]) p = id[p];
		return p;
	}
	
	/**
	 * 判断两个site是否连接
	 */
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	/**
	 * 返回所有sites总的component数量
	 */
	public int count() {
		return N;
	}
	
	/**
	 * 测试动态连接的函数
	 */
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		//总的sites数量
//		int num = new Integer(scan.nextLine());
//		//初始化UF对象
//		UF uf = new UF(num);
//		while(scan.hasNext()) {
//			String line = scan.nextLine();
//			String[] ns = line.split(" ");
//			//读取的两个数
//			int numL = new Integer(ns[0]);
//			int numR = new Integer(ns[1]);
//			
//			//两个数是否已经连接
//			if (!uf.connected(numL, numR)) {
//				uf.union(numL, numR);
//				System.out.println(line);
//			}
//		}
//		System.out.println(uf.count() + " components");
		
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
		int[][] data = {
				{4, 3},
				{3, 8},
				{6, 5},
				{9, 4},
				{2, 1},
				{8, 9},
				{5, 0},
				{7, 2},
				{6, 1},
				{1, 0},
				{6, 7}
		};
		System.out.println(uf.connected(4, 3));
		for (int i = 0; i < data.length; i++) {
			if (!uf.connected(data[i][0], data[i][1])) 
				uf.union(data[i][0], data[i][1]);
		}
		System.out.println(uf.count());
	}
}