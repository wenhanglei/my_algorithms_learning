package graphics;
/**
 * 加权无向边
 * @author wenhanglei
 */
public class Edge implements Comparable<Edge>{
	
	private final double weight;
	private final int v;
	private final int w;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight(){
		return weight;
	}
	
	public int either(){
		return v;
	}
	
	public int other(int i){
		if(i == v) return w;
		if(i == w) return v;
		else throw new IllegalArgumentException("您传入的参数错误！");
	}
	
	@Override
	public int compareTo(Edge o) {
		if(weight > o.weight()) return 1;
		else if(weight < o.weight()) return -1;
		else return 0;
	}
	
	@Override
	public String toString() {
		return v +"-" + w;
	}
	
}
