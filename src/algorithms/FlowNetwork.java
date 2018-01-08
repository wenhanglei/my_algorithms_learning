package algorithms;

import java.util.ArrayList;
import java.util.List;

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
		
	}
	
	/**
	 * @param v
	 * @return 顶点v指向的所有边的迭代器
	 */
	public Iterable<FlowEdge> adj(int v) {
		return null;
	}
	
	/**
	 * @return 当前网络流中所有边
	 */
	public Iterable<FlowEdge> edges() {
		return null;
	}
}
