package graphics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CycleTest {
	public static void main(String[] args) {
		String file = args[0];
		try {
			BufferedReader reader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(file)));
			Graph G = new Graph(reader);
			Cycle c = new Cycle(G);
			System.out.println(c.hasCycle());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
