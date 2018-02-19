package graphics;
/**
 * 使用符号图完成分离度查找
 * @author wenhanglei
 */
public class DegreesOfSeparation {
	
	public static void main(String[] args) {
		SymbolGraph SG = new SymbolGraph(args[0], "/");
		Graph G = SG.G();
		int index = SG.index("Bacon, Kevin");
		int index2 = SG.index("Kidman, Nicole");
		BreadthFirstPaths bfp = new BreadthFirstPaths(G, index);
		for(int v : bfp.pathTo(index2)){
			System.out.println(SG.name(v));
		}
	}

}
