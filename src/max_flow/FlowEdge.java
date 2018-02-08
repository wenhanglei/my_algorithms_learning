package max_flow;
/**
 * 网络流的边
 * @author wenhanglei
 */
public class FlowEdge {
	
	private int from;
	private int to;
	private double capacity;
	private double flow;
	
	/**
	 * 网络流边的构造函数
	 * @param v w 边的两个顶点
	 * @param cap 该边的最大流量
	 */
	public FlowEdge(int v, int w, double cap) {
		this.from = v;
		this.to = w;
		this.capacity = cap;
	}
	
	/**
	 * @return 该边的流入顶点
	 */
	public int from() {
		return from;
	}
	
	/**
	 * @return 该边流向的顶点
	 */
	public int to() {
		return to;
	}
	
	/**
	 * @param v
	 * @return 该边与v顶点相对应的另一个顶点
	 */
	public int other(int v) {
		if(v == from) return to;
		else if(v == to) return from;
		else return -1;
	}
	
	/**
	 * @return 该边的最大的流量
	 */
	public double capacity() {
		return capacity();
	}
	
	/**
	 * @return 该边当前的流量
	 */
	public double flow() {
		return flow();
	}
	
	/**
	 * @param v
	 * @return 该边当前相对与顶点v的残差流量
	 */
	public double residualCapacityTo(int v) {
		if(v == to) return capacity-flow;
		if(v == from) return flow;
		return 0;
	}
	
	/**
	 * 向顶点v的流向添加残留网络流量
	 * @param v
	 * @param delta
	 */
	public void addResidualFlowTo(int v, double delta){
		if(v == to)
			flow -= delta;
		else if(v == from)
			flow += delta;
		else throw new RuntimeException("添加流量异常");
	}
	
	/**
	 * 向顶点v的流向添加cap的流量
	 */
	public void addFlowTo(int v, double cap) {
		if(v == to) flow += cap;
		if(v == from) flow -= cap;
	}

	@Override
	public String toString() {
		return String.format("%d->%d %.2f %.2f", from, to, capacity, flow);
	}
	
}
