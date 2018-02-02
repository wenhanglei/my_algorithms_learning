package re;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import algorithms.Digraph;
import algorithms.DirectedDFS;
/**
 * 非确定性有限状态自动机
 * @author wenhanglei
 */
public class NFA {
	private char[] re;          //自动机的所有状态
	private int N;                  //自动机的状态数量
	private Digraph G;              //自动机的状态有向图
	/**
	 * 非确定性有限状态自动机构造函数
	 * 默认pattern是带有括号的
	 */
	public NFA(String pattern) {
		N = pattern.length();
		re = pattern.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		//创建带有N个顶点的有向图
		G = new Digraph(N+1);
		for(int i = 0; i < N; i++){
			char ch = re[i];
			if(ch == '('){
				stack.push(i);
				G.addEdge(i, i+1);
			}else if(ch == '*'){
				G.addEdge(i, i-1);
				G.addEdge(i-1, i);
				G.addEdge(i, i+1);
			}else if(ch == '|'){
				G.addEdge(stack.pop(), i+1);
				stack.push(i);
			}else if(ch == ')'){
				if(re[stack.peek()] == '|'){
					G.addEdge(stack.pop(), i);
				}else if(i != N-1){
					G.addEdge(stack.peek(), i+1);
					G.addEdge(i+1, stack.pop());
				}
				G.addEdge(i, i+1);
			}
		}
	}
	
	public boolean recognize(String str){
		Set<Integer> set = new HashSet<Integer>();
		char[] chs = str.toCharArray();
		DirectedDFS dfs = null;
		Object[] sources = null;
		set.add(0);
		
		//遍历str中的所有字符
		for(int k = 0; k < chs.length; k++){
			//获取需要遍历的所有出发点
			sources = set.toArray();
			set.clear();
			//遍历所有源点，获取所有空过渡可达点
			for(int i = 0; i < sources.length; i++){
				int index = (int) sources[i];
				dfs = new DirectedDFS(G, index);
				for(int j = 0; j < G.V(); j++){
					if(dfs.marked(j))
						set.add(j);
				}
			}
			
			//获取需要检测的所有可达点
			sources = set.toArray();
			set.clear();
			//遍历所有可达点，添加下一轮需要检查的源点
			for(int i = 0; i < sources.length; i++){
				int index = (int) sources[i];
				if(re[index] == chs[k])
					set.add(index+1);
			}
		}
		//获取需要遍历的所有出发点
		sources = set.toArray();
		set.clear();
		//遍历所有源点，获取所有空过渡可达点
		for(int i = 0; i < sources.length; i++){
			int index = (int) sources[i];
			dfs = new DirectedDFS(G, index);
			for(int j = 0; j < G.V(); j++){
				if(dfs.marked(j))
					set.add(j);
			}
		}
		if(set.contains(N))
			return true;
		return false;
	}
}
















