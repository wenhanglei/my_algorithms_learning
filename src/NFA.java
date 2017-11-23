
public class NFA {
	
	//表示无限自动状态机的有向图
	private Digraph G;
	//用于匹配的模版的字符数或自动状态机的总状态数
	private int M;
	//用于匹配的正则表达式
	private char[] re;
	
	/**
	 * 无限自动状态机的构造
	 * @param regexp
	 */
	public NFA(String regexp) {
		Stack<Integer> ops = new Stack<Integer>();
		re = regexp.toCharArray();
		M = re.length;
		G = new Digraph(M+1);
		
		for(int i = 0; i < M; i++) {
			int lp = i;
			if(re[i] == '(' || re[i] == '|')
				ops.push(i);
			else if(re[i] == ')') {
				int or = ops.pop();
				if(re[or] == '|') {
					lp = ops.pop();
					G.addEdge(lp, or+1);
					G.addEdge(or, i);
				}
				else lp = or;
			}
			if(i < M-1 && re[i+1] == '*'){
				G.addEdge(lp, i+1);
				G.addEdge(i+1, lp);
			}
			if(re[i] == '(' || re[i] == '*' || re[i] == ')')
				G.addEdge(i, i+1);
		}
	}
	
	/**
	 * @param text
	 * @return 是否匹配字符串的有向图模拟
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