import java.util.Scanner;

/**
 * ���ϲ�����
 * @author Administrator
 *
 */
public  class UF {
	//���������sites
	private int[] id;
	//component������
	private int N;
	/**
	 * ���캯��
	 */
	public UF(int i) {
		//��ʼ������
		id = new int[i];
		for (int j = 0; j < i; j++) id[j] = j;
		//��ʼ��component����
		N = i;
	}
	/**
	 * ��������site
	 */
	//�������ϵ�ʵ�ַ���
	public void union(int p, int q) {
		p = find(p);
		q = find(q);
		if(p == q) return;
		id[p] = id[q];
		N--;
	}
	
	//���ٲ��ҵ�ʵ�ַ���
	/*public void union(int p, int q) {
		if(id[p] == id[q]) return;
		else {
			int temp = id[p];
			for (int i = 0; i < id.length; i++) {
				if(id[i] == temp)
					id[i] = id[q];
			}
			N--;
		}
	}*/
	/**
	 * �����ض�site�����Ǹ�component
	 */
	//�������ϵ�ʵ�ַ���
	public int find(int p) {
		do {
			p = id[p];
		} while (p != id[p]);
		return p;
	}
	//���ٲ��ҵ�ʵ�ַ���
	/*public int find(int p) {
		return id[p];
	}*/
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
		
		UF uf = new UF(10);
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

















