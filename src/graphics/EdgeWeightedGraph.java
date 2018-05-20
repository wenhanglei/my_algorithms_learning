package graphics;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 加权无向图
 * @author wenhanglei
 */
public class EdgeWeightedGraph {
	
	private LinkedList<Edge>[] edgeTo;
	private final int V;                        //顶点的个数
	private int E;                        //边的数量
	
	public EdgeWeightedGraph(int V) {
		this.V = V;
		edgeTo = (LinkedList<Edge>[]) new LinkedList[V];
		for(int i = 0; i < V; i++){
			edgeTo[i] = new LinkedList<Edge>();
		}
	}
	
//	public EdgeWeightedGraph(BufferedReader reader) {
//	}
	
	/**
	 * 返回顶点数量
	 */
	public int V(){
		return V;
	}
	
	/**
	 * 返回边的数量
	 */
	public int E(){
		return E;
	}
	
	/**
	 * 向该加权无向图添加一条加权边
	 * @param e
	 */
	public void addEdge(Edge e){
		int v = e.either();
		edgeTo[v].add(e);
		edgeTo[e.other(v)].add(e);
		E++;
	}
	
	/**
	 * 返回顶点v的邻边
	 * @return
	 */
	public Iterable<Edge> adj(int v){
		return edgeTo[v];
	}
	
	/**
	 * 返回该加权图的所有边
	 */
	public Iterable<Edge> edges(){
		Set<Edge> set = new HashSet<>();
		for(int i = 0; i < edgeTo.length; i++){
			set.addAll(edgeTo[i]);
		}
		return set;
	}
	
}
