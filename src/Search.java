
public class Search {
	
	private boolean[] marked;
	private int count;
	
	public Search() {
	}
	/**
	 * ���ι��캯��
	 * @param g
	 * @param source
	 */
	public Search(Graph G, int s) {
		/*
		 * ������ȱ���DFS
		 * 1�� ����Ѿ��������Ķ���
		 * 2�� ��������û�б�ǵ��ڽӶ���
		 */
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	/**
	 * ������ȱ���
	 * @param v
	 */
	private void dfs(Graph G, int v){
		marked[v] = true;
		count++;
		for(int i : G.adj(v)){
			if(!marked[i]) dfs(G, i);
		}
	}
	/**
	 * ����v�Ƿ��s����
	 * @param v
	 * @return
	 */
	public boolean Marked(int v) {
		return marked[v];
	}
	/**
	 * ������Դ�����������е������
	 * @return
	 */
	public int count() {
		return count;
	}
	
}

















