package max_flow;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 流网络
 * @author wenhanglei
 */
public class FlowNetwork {
	
	//存储所有边的邻接链表
	private List<FlowEdge>[] adj;
	//顶点个数
	private int V;
	//边的个数
	private int E;
	
	/**
	 * 顶点个数为v的空流网络构造函数
	 * @param V
	 */
	public FlowNetwork(int V) {
		adj = (List<FlowEdge>[]) new Object[V];
		this.V = V;
	}
	
	public FlowNetwork(BufferedReader reader) throws IOException{
		//获取顶点的数量
		this.V = Integer.parseInt(reader.readLine());
		//获取边的数量
		this.E = Integer.parseInt(reader.readLine());
		//初始化装载有向边的邻接表
		this.adj = (List<FlowEdge>[]) new List[this.V];
		String line = null;
		while((line = reader.readLine()) != null){
			String[] strs = line.split(" ");
			//调用FlowEdge的构造函数
			FlowEdge e = new FlowEdge(Integer.parseInt(strs[0]),
					Integer.parseInt(strs[1]),
					Double.parseDouble(strs[2]));
			addEdge(e);
		}
	}
	
	/**
	 * @return 该流网络的顶点的个数
	 */
	public int V() {
		return V;
	}
	
	/**
	 * @return 返回当前流网络的边的条数
	 */
	public int E() {
		return E;
	}
	
	/**
	 * 向当前流网络中添加一个边e
	 * @param e
	 */
	public void addEdge(FlowEdge e) {
		//判断链表是否存在，如果不存在则先创建链表
		if(adj[e.from()] == null) 
			adj[e.from()] = new LinkedList<FlowEdge>();
		if(adj[e.to()] == null)
			adj[e.to()] = new LinkedList<FlowEdge>();
		//向网络流中添加边
		adj[e.from()].add(e);
		adj[e.to()].add(e);
	}
	
	/**
	 * @param v
	 * @return 顶点v指向的所有边的迭代器
	 */
	public Iterable<FlowEdge> adj(int v) {
		if(adj[v] != null)
			return adj[v];
		else return null;
	}
	
	/**
	 * @return 当前网络流中所有边
	 */
	public Iterable<FlowEdge> edges() {
		Set<FlowEdge> set = new HashSet<FlowEdge>();
		for(int i = 0; i < V; i++){
			if(adj[i] != null){
				set.addAll(adj[i]);
			}
		}
		return set;
	}
}
