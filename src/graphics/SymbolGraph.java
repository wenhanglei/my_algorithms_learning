package graphics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 字符串表示顶点的无向图
 * @author wenhanglei
 */
public class SymbolGraph {
	
	private Graph G;
	private HashMap<String, Integer> index;
	private String[] names;
	//顶点的数量
	private int N;
	
	/**
	 * 构造函数
	 */
	public SymbolGraph(String filename, String delim) {
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(filename)));
			index = new HashMap<String, Integer>();
			String line = null;
			while((line=reader.readLine()) != null){
				String[] strs = line.split(delim);
				for(int i = 0; i < strs.length; i++){
					if(!index.containsKey(strs[i])){
						index.put(strs[i], N++);
					}
				}
			}
			names = new String[N];
			G = new Graph(N);
			for(Entry<String, Integer> en : index.entrySet()){
				names[en.getValue()] = en.getKey();
			}
			reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(filename)));
			while((line=reader.readLine()) != null){
				String[] strs = line.split(delim);
				for(int i = 1; i < strs.length; i++){
					G.addEdge(index.get(strs[0]), index.get(strs[i]));
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 是否包含顶点key
	 * @param key
	 * @return
	 */
	public boolean contains(String key){
		return index.containsKey(key);
	}
	
	/**
	 * 返回顶点key在无向图中表示的索引
	 * @param key
	 */
	public int index(String key){
		if(contains(key))
			return index.get(key);
		else return -1;
	}
	
	/**
	 * 在无向图中索引为v的顶点的名称
	 * @param v
	 * @return
	 */
	public String name(int v){
		if(v >= 0 && v < names.length)
			return names[v];
		else return null;
	}
	
	/**
	 * 返回以下标为索引的无向图
	 */
	public Graph G(){
		return G;
	}

}
