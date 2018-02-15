package graphics;
/**
 * 符号图测试类
 * @author wenhanglei
 */
public class SymbolGraphTest {
	
	public static void main(String[] args) {
		String file = args[0];
		String delim = args[1];
		
		SymbolGraph SG = new SymbolGraph(file, delim);
		Graph G = SG.G();
		for(int i = 0; i < G.V(); i++){
			System.out.println(SG.name(i));
			for(int v : G.adj(i)){
				System.out.println("    " + SG.name(v));
			}
		}
	}

}
