package graphics;

public class GraphClient {
	
	/**
	 * @param G
	 * @return 无向图G顶点v度数
	 */
	public static int degree(Graph G, int v){
		int degree = 0;
		for(int i : G.adj(v))
			degree++;
		return degree;
	}
	
	/**
	 * @param G
	 * @return 返回无向图的最大的度数
	 */
	public static int MaxDegree(Graph G){
		int max = 0;
		for(int i = 0; i < G.V(); i++){
			if(degree(G, i) > max)
				max = degree(G, i);
		}
		return max;
	}
	
	/**
	 * @param G
	 * @return 无向图G的平均度数
	 */
	public static int avgDegree(Graph G){
		return 2*G.E()/G.V();
	}
	
	/**
	 * 返回无向图中的自环的数量
	 * @param G
	 * @return
	 */
	public static int numberOfSelfLoops(Graph G){
		int count = 0;
		for(int i = 0; i < G.V(); i++){
			for(int v : G.adj(i)){
				if(v == i) count++;
			}
		}
		return count/2;
	}
	
}















