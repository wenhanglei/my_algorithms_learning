import java.util.HashMap;


public class SymbolDigraph {
	
	//底层的有向图
	private Digraph G;
	//保存索引的map
	private HashMap<String, Integer> st;
	//用于查询下标对应的顶点字符串的数组
	private String[] keys;
	
	/**
	 * 构造函数
	 */
	public SymbolDigraph(String filename, String delim) {
		st = new HashMap<String, Integer>();
		In in = new In(filename);
		while(in.hasNextLine()){
			String[] vertex = in.readLine().split(delim);
			for(String v : vertex){
				if(!st.containsKey(v))
					st.put(v, st.size());
			}
		}
		keys = new String[st.size()];
		for(String key : st.keySet()){
			keys[st.get(key)] = key;
		}
		G = new Digraph(st.size());
		in = new In(filename);
		while(in.hasNextLine()){
			String[] keys = in.readLine().split(delim);
			int v = st.get(keys[0]);
			for(int i = 1; i < keys.length; i++)
				G.addEdge(v, st.get(keys[i]));
		}
		
	}
	/**
	 * 返回字符串顶点在索引图中的下标
	 * @param name
	 * @return
	 */
	public int index(String name){
		return st.get(name);
	}
	/**
	 * 返回表示下标为index的顶点的字符串
	 * @param index
	 * @return
	 */
	public String name(int index) {
		return keys[index];
	}
	/**
	 * 符号有向图是否包含顶点key
	 * @param key
	 * @return
	 */
	public boolean contains(String key) {
		if(st == null) return false;
		else if(st.containsKey(key)) return true;
		else return false;
	}
	/**
	 * 返回底层的有向图
	 * @return
	 */
	public Digraph G() {
		return G;
	}

}
















