import java.util.HashMap;


public class SymbolDigraph {
	
	//�ײ������ͼ
	private Digraph G;
	//����������map
	private HashMap<String, Integer> st;
	//���ڲ�ѯ�±��Ӧ�Ķ����ַ���������
	private String[] keys;
	
	/**
	 * ���캯��
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
	 * �����ַ�������������ͼ�е��±�
	 * @param name
	 * @return
	 */
	public int index(String name){
		return st.get(name);
	}
	/**
	 * ���ر�ʾ�±�Ϊindex�Ķ�����ַ���
	 * @param index
	 * @return
	 */
	public String name(int index) {
		return keys[index];
	}
	/**
	 * ��������ͼ�Ƿ��������key
	 * @param key
	 * @return
	 */
	public boolean contains(String key) {
		if(st == null) return false;
		else if(st.containsKey(key)) return true;
		else return false;
	}
	/**
	 * ���صײ������ͼ
	 * @return
	 */
	public Digraph G() {
		return G;
	}

}
















