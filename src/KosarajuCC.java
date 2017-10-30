/**
 * ǿ��ͨͼ����
 * @author Administrator
 *
 */
public class KosarajuCC {
	
	private boolean[] marked;
	private int count;
	private int[] id;
	
	/**
	 * ���캯��
	 * @param G
	 */
	public KosarajuCC(Digraph G) {
		/*
		 * 1�� ����һ��ͼ��ʹ��DepthFirstOrder��������õ���ͼ
		 * 2�� ��ԭͼ�ϸ��������ʹ��������ȱ���
		 * 3�� �ڵݹ麯��dfs�����е����ж��㹹��һ��ǿ��ͨ����
		 */
		id = new int[G.V()];
		for(int i = 0; i < id.length; i++)
			id[i] = i;
		marked = new boolean[G.V()];
		Digraph rg = G.reverse();
		DepthFirstOrder dfo = new DepthFirstOrder(G);
		for(int v : dfo.reversePost()){
			if(!marked[v]){
				dfs(rg, v);
				count++;
			}
		}
	}
	private void dfs(Digraph G, int x) {
		marked[x] = true;
		id[x] = count;
		for(int v : G.adj(x)){
			if(!marked[v]) {
				dfs(G, v);
			}
		}
	}
	/**
	 * ����v�Ͷ���w�Ƿ�ǿ����
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
	/**
	 * @return ������ͼ��ǿ��ͨ��ͼ�ĸ���
	 */
	public int count() {
		return count;
	}
	/**
	 * @param v ����ͼ�еĶ���
	 * @return �ö��������ĸ�ǿ��ͨ��ͼ
	 */
	public int id(int v) {
		return id[v];
	}
}


















