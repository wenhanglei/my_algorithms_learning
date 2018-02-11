package graphics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 无向图查找测试
 * @author wenhanglei
 */
public class SearchTest {
	
	public static void main(String[] args) {
		String file = args[0];
		int s = Integer.parseInt(args[1]);
		try {
			BufferedReader reader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(file)));
			Graph G = new Graph(reader);
			Search search = new Search(G, s);
			String str = "";
			String res = "";
			for(int i = 0; i < G.V(); i++){
				if(search.marked(i))
					str += (i+" ");
				else{
					res += "Not connected";
				}
			}
			if(res.isEmpty())
				res += "Connected";
			System.out.println(str);
			System.out.println(res);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
