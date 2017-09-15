import java.util.Arrays;

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
		
	}
}

















