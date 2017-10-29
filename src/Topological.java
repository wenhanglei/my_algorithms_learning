
public class Topological {
	
	private boolean isDAG = true;
	private Iterable<Integer> order;
	/**
	 * �����޻�ͼ�����������캯��
	 * @param G
	 */
	public Topological(Digraph G) {
		DirectedCycle dc = new DirectedCycle(G);
		DepthFirstOrder dfo = new DepthFirstOrder(G);
		if(dc.hasCycle()) isDAG = false;
		
		order = dfo.reversePost();
	}
	/**
	 * ��ͼ�Ƿ��������޻�ͼ
	 * @return
	 */
	public boolean isDAG() {
		return isDAG;
	}
	/**
	 * ���ظ�ͼ����������
	 * @return
	 */
	public Iterable<Integer> order() {
		return order;
	}
}
