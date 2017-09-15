import java.util.Arrays;

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
	public void union(int p, int q) {
		id[p] = id[q];
	}
	/**
	 * �����ض�site�����Ǹ�component
	 */
	public int find(int p) {
		return id[p];
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
		
	}
}

















