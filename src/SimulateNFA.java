
public class SimulateNFA {
	
	//��ʾ�����Զ�״̬��������ͼ
	private Digraph G;
	//����ƥ���ģ����ַ������Զ�״̬������״̬��
	private int M;
	//����ƥ���������ʽ
	private int[] re;
	
	/**
	 * @param text
	 * @return �Ƿ�ƥ���ַ���������ͼģ��
	 */
	public boolean recognize(String txt) {
		Bag<Integer> pc = new Bag<Integer>();
		DirectedDFS dfs = new DirectedDFS(G, 0);
		for(int i = 0; i < G.V(); i++) 
			if(dfs.marked(i)) pc.add(i);
		
		for(int i = 0; i < txt.length(); i++) {
			Bag<Integer> match = new Bag<Integer>();
			for(int v : pc){
				if(v < M)
					if(re[v] == txt.charAt(i) || re[v] == '.' )
						match.add(v+1);
			}
			pc = new Bag<Integer>();
			dfs = new DirectedDFS(G, match);
			for(int v = 0; v < G.V(); i++)
				if(dfs.marked(v)) pc.add(v);
		}
		for(int v : pc) if(v == M) return true;
		return false;
	}

}
