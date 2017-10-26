import java.util.HashMap;


public class SymbolGraph {
	
	private HashMap<String, Integer> st;
	private String[] keys;
	Graph G;
	
	/**
	 * ����ͼ�Ĺ��캯��
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
	 * ͼ�Ƿ��������key
	 * @param key
	 * @return
	 */
	public boolean contains(String key) {
		return st.containsKey(key);
	}
	/**
	 * �����±�v��key
	 * @param v
	 * @return
	 */
	public String name(int v) {
		return keys[v];
	}
	/**
	 * ���ض���key���±�
	 * @param key
	 * @return
	 */
	public int index(String key) {
		return (int)st.get(key);
	}
	/**
	 * ���صײ�ͼ
	 * @return
	 */
	public Graph G() {
		return G;
	}
}















