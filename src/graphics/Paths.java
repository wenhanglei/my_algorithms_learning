package graphics;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 解决无向图的单源路径问题
 * @author wenhanglei
 */
public abstract class Paths {

	/**
	 * 是否存在一条s到v的路径
	 * @param v
	 * @return
	 */
	public abstract boolean hasPathTo(int v);
	
	/**
	 * 返回一条s到v的路径
	 * @param v
	 * @return
	 */
	public abstract Iterable<Integer> pathTo(int v);
}
