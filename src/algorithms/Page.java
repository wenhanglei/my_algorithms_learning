package algorithms;
/**
 * 关联类型Key和一个page,page表示包含有最多m个page链接的节点
 */
public class Page<Key> {
	private final boolean isBottom;
	
	/**
	 * 构建一个新的节点，如果是外部结点bottom为true，如果为内部节点bottom为false
	 */
	public Page(boolean bottom) {
		this.isBottom = bottom;
	}
	
	/**
	 * 添加一个key，page关联
	 */
	public void put(Key key) {
		
	}
	
	/**
	 * 添加健key到当前外部节点中
	 */
	public void add(Key key) {
		
	}
	
	/**
	 * 添加健key到当前内部节点中
	 */
	public void add(Page page) {
		
	}
	
	/**
	 * 当前page结点是否包含健key
	 */
	public boolean contains(Key key) {
		return false;
	}
	
	/**
	 * 当前节点是否是外部节点
	 */
	public boolean isExternal() {
		return false;
	}
	
	/**
	 * 返回包含键为key的子树的根结点引用
	 */
	public Page next(Key key) {
		return null;
	}
	
	/**
	 * 返回用于遍历当前节点所有key，page键值对的迭代器
	 */
	public Iterable<Key> keys() {
		return null;
	}

	/**
	 * 当前节点的关联是否溢出
	 */
	private boolean isFull() {
		return false;
	}

	/**
	 * 将当前结点分裂成两个，返回新生成的结点引用
	 */
	private Page split() {
		return null;
	}

}
