package graphics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 单元路径问题的测试函数
 * @author wenhanglei
 */
public class PathsTest {
	
	public static void main(String[] args) {
		String file = args[0];
		int s = Integer.parseInt(args[1]);
		
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file)));
			Graph G = new Graph(reader);
			
			Paths p = new BreadthFirstPaths(G, s);
			for(int i = 0; i < G.V(); i++){
				if(p.hasPathTo(i)){
					System.out.print(s + " to " + i + ": ");
					for(int v : p.pathTo(i)){
						if(v == i)
							System.out.print(v);
						else System.out.print(v + "-");
					}
					System.out.println();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
