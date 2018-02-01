package max_flow;
/**
 * 网络流的边
 * @author wenhanglei
 */
public class FlowEdge {
	
	/**
	 * 网络流边的构造函数
	 * @param v w 边的两个顶点
	 * @param cap 该边的最大流量
	 */
	public FlowEdge(int v, int w, double cap) {
	}
	
	/**
	 * @return 该边的流入顶点
	 */
	public int from() {
		return 0;
	}
	
	/**
	 * @return 该边流向的顶点
	 */
	public int to() {
		return 0;
	}
	
	/**
	 * @param v
	 * @return 该边与v顶点相对应的另一个顶点
	 */
	public int other(int v) {
		return 0;
	}
	
	/**
	 * @return 该边的最大的流量
	 */
	public double capacity() {
		return 0;
	}
	
	/**
	 * @return 该边当前的流量
	 */
	public double flow() {
		return 0;
	}
	
	/**
	 * @param v
	 * @return 该边当前相对与顶点v的残差流量
	 */
	public double residualCapacityTo(int v) {
		return 0;
	}
	
	/**
	 * 向顶点v的流向添加cap的流量
	 */
	public void addFlowTo(int v, double cap) {
		
	}
}
