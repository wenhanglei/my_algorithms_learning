
public class DirectedEdge {
	
	private int v;
	private int w;
	private double weight;
	
	/**
	 * 构造函数
	 * @param v
	 * @param w
	 * @param weight
	 */
	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	/**
	 * @return 该加权有向边的权值
	 */
	public double weight() {
		return weight;
	}
	/**
	 * @param v
	 * @return 该有向边的源顶点
	 */
	public int from() {
		return v;
	}
	/**
	 * @return 该有向边所指向的顶点
	 */
	public int to() {
		return w;
	}
	
	@Override
	public String toString() {
		return String.format("%d-%d %.2f", v, w, weight);
	}
}

















