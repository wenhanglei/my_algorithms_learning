package max_flow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FordFurkerson {
	
	//顶点是否遍历的标记
	private boolean[] marked;
	private FlowEdge[] edgeTo;
	private double maxflow;
	
	public FordFurkerson(FlowNetwork G, int s, int t) {
		edgeTo = new FlowEdge[G.V()];
		this.maxflow = 0;
		//如果增广路径存在
		while(hasAugmentingPath(G, s, t)){
			double min = Double.POSITIVE_INFINITY;
			int curr = t;
			while(curr != s){
				FlowEdge e = edgeTo[curr];
				if(e.residualCapacityTo(curr) < min)
					min = e.residualCapacityTo(curr);
				curr = e.other(curr);
			}
			curr = t;
			while(curr != s){
				FlowEdge e = edgeTo[curr];
				curr = e.other(curr);
				e.addResidualFlowTo(curr, min);
			}
			maxflow += min;
		}
	}
	
	/**
	 * 判断是否含有增广路径
	 */
	private boolean hasAugmentingPath(FlowNetwork G, int s, int t){
		//广度优先遍历的队列
		Queue<Integer> queue = new LinkedList<Integer>();
		marked = new boolean[G.V()];
		//源点入队
		queue.offer(s);
		marked[s] = true;
		while(!queue.isEmpty()){
			//获取当前顶点的下一层的所有顶点
			Integer v = queue.poll();
			for(FlowEdge e : G.adj(v)){
				int temp = e.other(v);
				if(!marked[temp] && e.residualCapacityTo(temp) > 0){
					edgeTo[temp] = e;
					queue.offer(temp);
					marked[temp] = true;
				}
			}
		}
		return marked[t];
	}

	/**
	 * 判断顶点v的流是否均衡
	 */
	private boolean localEq(FlowNetwork G, int v){
		double EPSILON = 1e-11;
		double sum = 0;
		for(FlowEdge e : G.adj(v)){
			if(e.from() == v) sum -= e.flow();
			else sum += e.flow();
		}
		return Math.abs(sum) < EPSILON;
	}
	
	private boolean isFeasible(FlowNetwork G){
		//检查每条边非负并且小于capacity
		for(FlowEdge e : G.edges()){
			if(e.flow() < 0) return false;
			if(e.flow() > e.capacity()) return false;
		}
		
		//检查每个顶点是否局部均衡
		for(int i = 1; i < G.V()-1; i++){
			if(!localEq(G, i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		String fileName = args[0];
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(fileName)));
		FlowNetwork G = new FlowNetwork(reader);
		FordFurkerson ff = new FordFurkerson(G, 0, G.V()-1);
		for(int i = 0; i < G.V(); i++){
			for(FlowEdge e : G.adj(i)){
				if(e.from() == i)
					System.out.println(e);
			}
		}
		System.out.println(ff.maxflow);
	}

}