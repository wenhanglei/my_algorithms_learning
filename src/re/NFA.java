package re;

import algorithms.Digraph;
import algorithms.DirectedDFS;

public class NFA {
	private char[] states;          //自动机的所有状态
	private int N;                  //自动机的状态数量
	private DirectedDFS dfs;        //有向图的深度优先遍历
	/**
	 * 非确定性有限状态自动机构造函数
	 */
	public NFA(char[] pattern) {
		//初始化自动机的状态数量
		N = pattern.length+3;
		//初始化自动机的所有状态
		states = new char[N];
		states[0] = '(';
		states[pattern.length+1] = ')';
		states[pattern.length+1] = ' ';
		Digraph d;
		
	}
}
