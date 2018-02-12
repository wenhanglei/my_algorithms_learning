package graphics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 图的连通分量客户应用
 * @author wenhanglei
 */
public class CCClient {
	
	public static void main(String[] args) {
		String file = args[0];
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file)));
			Graph G = new Graph(reader);
			CC cc = new DepthFirstCC(G);
			
			Set<Integer>[] components = new HashSet[cc.count()];
			for(int i = 0; i < G.V(); i++){
				if(components[cc.id(i)] == null)
					components[cc.id(i)] = new HashSet<Integer>();
				components[cc.id(i)].add(i);
			}
			for(int i = 0; i < cc.count(); i++){
				System.out.print(i + " : ");
				for(int v : components[i]){
					System.out.print(v + " ");
				}
				System.out.println();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
