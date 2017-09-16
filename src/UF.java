import java.util.Scanner;

/**
 * 联合查找类
 * @author Administrator
 *
 */
public  class UF {
	//保存的所有sites
	private int[] id;
	//component的数量
	private int N;
	/**
	 * 构造函数
	 */
	public UF(int i) {
		//初始化数组
		id = new int[i];
		for (int j = 0; j < i; j++) id[j] = j;
		//初始化component数量
		N = i;
	}
	/**
	 * 关联两个site
	 */
	public void union(int p, int q) {
		id[p] = id[q];
	}
	/**
	 * 查找特定site属于那个component
	 */
	public int find(int p) {
		return id[p];
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
		Scanner scan = new Scanner(System.in);
		//中的sites数量
		int num = new Integer(scan.nextLine());
		//初始化UF对象
		UF uf = new UF(num);
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] ns = line.split(" ");
			//读取的两个数
			int numL = new Integer(ns[0]);
			int numR = new Integer(ns[1]);
			
			//两个数是否已经连接
			if (!uf.connected(numL, numR)) {
				uf.union(numL, numR);
				System.out.println(line);
			}
		}
		System.out.println(uf.count() + " components");
	}
}

















