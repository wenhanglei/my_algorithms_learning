
public class DirectedEdge {
	
	private int v;
	private int w;
	private double weight;
	
	/**
	 * ���캯��
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
	 * @return �ü�Ȩ����ߵ�Ȩֵ
	 */
	public double weight() {
		return weight;
	}
	/**
	 * @param v
	 * @return ������ߵ�Դ����
	 */
	public int from() {
		return v;
	}
	/**
	 * @return ���������ָ��Ķ���
	 */
	public int to() {
		return w;
	}
	
	@Override
	public String toString() {
		return String.format("%d-%d %.2f", v, w, weight);
	}
}


















