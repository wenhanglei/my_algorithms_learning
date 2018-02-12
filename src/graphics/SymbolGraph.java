package graphics;
/**
 * 字符串表示顶点的无向图
 * @author wenhanglei
 */
public class SymbolGraph {
	
	private Graph G;
	
	/**
	 * 构造函数
	 */
	public SymbolGraph(String filename, String delim) {
	}
	
	/**
	 * 是否包含顶点key
	 * @param key
	 * @return
	 */
	public boolean contains(String key){
		return false;
	}
	
	/**
	 * 返回顶点key在无向图中表示的索引
	 * @param key
	 */
	public int index(String key){
		return 0;
	}
	
	/**
	 * 在无向图中索引为v的顶点的名称
	 * @param v
	 * @return
	 */
	public String name(int v){
		return null;
	}
	
	/**
	 * 返回以下标为索引的无向图
	 */
	public Graph G(){
		return G;
	}

}
