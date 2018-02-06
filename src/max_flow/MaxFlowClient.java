package max_flow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxFlowClient {
	
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
		FlowNetwork fn = new FlowNetwork(reader);
	}

}












