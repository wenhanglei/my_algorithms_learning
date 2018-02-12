package graphics;
/**
 * 无向图的连通分量api
 * @author wenhanglei
 *
 */
public abstract class CC {
	
	/**
	 * 顶点v和顶点w是否相连
	 * @param v
	 * @param w
	 * @return
	 */
	public abstract boolean connected(int v, int w);
	
	/**
	 * 当前图的连通分量的数量
	 * @return
	 */
	public abstract int count();
	
	/**
	 * 顶点v属于那一个连通分量
	 * @param v
	 * @return
	 */
	public abstract int id(int v);

}
