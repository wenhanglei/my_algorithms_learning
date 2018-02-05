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
		double in = 0, out = 0;
		for(FlowEdge e : G.edges()){
			if(e.from() == v){
				out += e.flow();
			}
			if(e.to() == v){
				in += e.flow();
			}
		}
		return in == out;
	}
	
	private boolean isFeasible(FlowNetwork G){
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		String fileName = args[0];
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(fileName)));
		FlowNetwork fn = new FlowNetwork(reader);
	}

}












