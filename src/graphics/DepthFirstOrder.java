package graphics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 先深序列
 * @author wenhanglei
 */
public class DepthFirstOrder {
	
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DepthFirstOrder(Digraph G, int s) {
		marked = new boolean[G.V()];
		pre = new LinkedList<>();
		post = new LinkedList<>();
		reversePost = new Stack<>();
		for(int i = 0; i < G.V(); i++)
			if(!marked[i]) dfs(G, i);
	}
	
	private void dfs(Digraph G, int w){
		pre.offer(w);
		marked[w] = true;
		for(Integer v : G.adj(w)){
			if(!marked[v]){
				dfs(G, v);
			}
		}
		post.offer(w);
		reversePost.push(w);
	}
	
	/**
	 * 先深序列
	 */
	public Iterable<Integer> preorder(){
		return pre;
	}
	
	public Iterable<Integer> postorder(){
		return post;
	}
	
	public Iterable<Integer> reversePost(){
		return reversePost;
	}

}
