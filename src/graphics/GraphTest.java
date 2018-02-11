package graphics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class GraphTest {
	
	@Test
	public void test(){
		Graph G = new Graph(2);
		G.addEdge(0, 0);
		System.out.println(G);
	}
	
	/**
	 * 图的测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		String file = args[0];
		try {
			BufferedReader reader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(file)));
			Graph G = new Graph(reader);
			System.out.println(G);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
