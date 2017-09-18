
public class WeightedQuickUnionUF {
	//���������sites
	private int[] id;
	//component������
	private int N;
	//���ڵ���������size
	private int[] size;
	/**
	 * ���캯��
	 */
	public WeightedQuickUnionUF(int i) {
		//��ʼ������
		id = new int[i];
		size = new int[i];
		for (int j = 0; j < i; j++) {
			id[j] = j;
			size[j] = 1;
		}
		//��ʼ��component����
		N = i;
	}
	/**
	 * ��������site
	 */
	//weighted quick unionʵ��
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
	 * �����ض�site�����Ǹ�component
	 */
	//weighted quick unionʵ��
	public int find(int p) {
		while(p != id[p]) p = id[p];
		return p;
	}
	
	/**
	 * �ж�����site�Ƿ�����
	 */
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	/**
	 * ��������sites�ܵ�component����
	 */
	public int count() {
		return N;
	}
	
	/**
	 * ���Զ�̬���ӵĺ���
	 */
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		//�ܵ�sites����
//		int num = new Integer(scan.nextLine());
//		//��ʼ��UF����
//		UF uf = new UF(num);
//		while(scan.hasNext()) {
//			String line = scan.nextLine();
//			String[] ns = line.split(" ");
//			//��ȡ��������
//			int numL = new Integer(ns[0]);
//			int numR = new Integer(ns[1]);
//			
//			//�������Ƿ��Ѿ�����
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
