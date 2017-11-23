
public class Edge implements Comparable<Edge> {
	
	private double weight;
	private int v;
	private int w;
	
	/**
	 * 构造函数
	 * @param v
	 * @param w
	 * @param weight
	 */
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	/**
	 * @return 该边的权值
	 */
	public double weight() {
		return weight;
	}
	/**
	 * @return 边的任意一个顶点
	 */
	public int either() {
		return v;
	}
	/**
	 * @return 该边的另一个顶点
	 */
	public int other(int x) {
		if(x == v) return w;
		else if(x == w) return this.v;
		else throw new RuntimeException("no exist edges");
	}
	@Override
	public int compareTo(Edge that) {
		if(weight > that.weight) return 1;
		else if(weight < that.weight) return -1;
		else return 0;
	}
	@Override
	public String toString() {
		return String.format("%d-%d %.2f", v, w, weight);
	}
}


















