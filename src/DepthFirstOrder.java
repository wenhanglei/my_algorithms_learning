
public class DepthFirstOrder {
	
	private boolean[] marked;
	private Queue<Integer> preOrder;
	private Queue<Integer> postOrder;
	private Stack<Integer> reversePostOrder;
	
	public DepthFirstOrder(Digraph G) {
		marked = new boolean[G.V()];
		preOrder = new Queue<Integer>();
		postOrder = new Queue<Integer>();
		reversePostOrder = new Stack<Integer>();
		for(int i = 0; i < G.V(); i++)
			if(!marked[i]) dfs(G, i);
	}
	public DepthFirstOrder(EdgeWeightedDigraph G) {
		marked = new boolean[G.V()];
		preOrder = new Queue<Integer>();
		postOrder = new Queue<Integer>();
		reversePostOrder = new Stack<Integer>();
		for(int i = 0; i < G.V(); i++)
			if(!marked[i]) dfs(G, i);
	}
	private void dfs(EdgeWeightedDigraph G, int x) {
		marked[x] = true;
		preOrder.enqueue(x);
		for(DirectedEdge e : G.adj(x)) {
			int v = e.to();
			if(!marked[v]) {
				dfs(G, v);
			}
		}
		postOrder.enqueue(x);
		reversePostOrder.push(x);
	}
	private void dfs(Digraph G, int x) {
		marked[x] = true;
		preOrder.enqueue(x);
		for(int v : G.adj(x)) {
			if(!marked[v]) {
				dfs(G, v);
			}
		}
		postOrder.enqueue(x);
		reversePostOrder.push(x);
	}
	
	public Iterable<Integer> pre() {
		return preOrder;
	}
	
	public Iterable<Integer> post() {
		return postOrder;
	}
	
	public Iterable<Integer> reversePost() {
		return reversePostOrder;
	}

}