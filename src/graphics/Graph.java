package graphics;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * 无向图抽象数据结构
 * @author wenhanglei
 *
 */
public class Graph {
	
	private int V;
	private int E;
	private LinkedList<Integer>[] adj;
	
	/**
	 * 无向图构造函数
	 * @param V
	 */
	public Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];
	}
	
	/**
	 * 无向图构造函数
	 * @param reader
	 * @throws IOException 
	 */
	public Graph(BufferedReader reader) throws IOException{
		//初始化顶点数量
		V = Integer.parseInt(reader.readLine());
		//初始化边的数量
		E = Integer.parseInt(reader.readLine());
		//初始化邻接表
		adj = new LinkedList[V];
		String line = null;
		while((line = reader.readLine()) != null){
			String[] strs = line.split(" ");
			int v = Integer.parseInt(strs[0]);
			int w = Integer.parseInt(strs[1]);
			addEdge(v, w);
		}
	}
	
	/**
	 * @return 当前无向图的顶点数量
	 */
	public int V() {
		return V;
	}
	
	/**
	 * @return 当前无向图的边的数量
	 */
	public int E() {
		return E;
	}
	
	/**
	 * 向该无向图中添加连接v和w的边
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w){
		if(adj[v] == null)
			adj[v] = new LinkedList<Integer>();
		if(adj[w] == null)
			adj[w] = new LinkedList<Integer>();
		adj[v].add(w);
		adj[w].add(v);
	}
	
	/**
	 * @param v
	 * @return 与v相连的所有顶点
	 */
	public Iterable<Integer> adj(int v){
		if(adj[v] != null)
			return adj[v];
		return null;
	}

	@Override
	public String toString() {
		String s = V + " vertices, " + E + " edges\n";
		for(int i = 0; i < V; i++){
			s += i + ": ";
			if(adj(i) != null){
				for(int v : adj(i)){
					s += v + " ";
				}
			}
			s += "\n";
		}
		return s;
	}

}
