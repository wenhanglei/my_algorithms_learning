import java.util.HashMap;


public class SymbolGraph {
	
	private HashMap<String, Integer> st;
	private String[] keys;
	Graph G;
	
	/**
	 * 符号图的构造函数
	 * @param filename
	 * @param delim
	 */
	public SymbolGraph(String filename, String delim) {
		st = new HashMap<String, Integer>();
		In in = new In(filename);
		while(in.hasNextLine()){
			String[] vs = in.readLine().split(delim);
			for(int i = 0; i < vs.length; i++){
				if(!st.containsKey(vs[i])) st.put(vs[i], st.size());
			}
		}
		keys = new String[st.size()];
		for(String key : st.keySet()) {
			keys[st.get(key)] = key;
		}
		G = new Graph(st.size());
		in = new In(filename);
		while(in.hasNextLine()) {
			String[] vs = in.readLine().split(delim);
			int v = st.get(vs[0]);
			for(int i = 1; i < vs.length; i++) {
				G.addEdge(v, st.get(vs[i]));
			}
		}
	}
	/**
	 * 图是否包含顶点key
	 * @param key
	 * @return
	 */
	public boolean contains(String key) {
		return st.containsKey(key);
	}
	/**
	 * 返回下标v的key
	 * @param v
	 * @return
	 */
	public String name(int v) {
		return keys[v];
	}
	/**
	 * 返回顶点key的下标
	 * @param key
	 * @return
	 */
	public int index(String key) {
		return (int)st.get(key);
	}
	/**
	 * 返回底层图
	 * @return
	 */
	public Graph G() {
		return G;
	}
}














