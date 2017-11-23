import java.util.Scanner;


public class DegreesOfSeparation {
	/**
	 * 使用广度优先遍历实现分离度查询
	 * @param args
	 */
	public static void main(String[] args) {
		//构造符号图
		SymbolGraph SG = new SymbolGraph(args[0], args[1]);
		int s = SG.index(args[2]);
		
		BreadthFirstPaths bfp = new BreadthFirstPaths(SG.G, s);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("please inter your film performer:");
		String name = scanner.nextLine();           //获得需要查询的演员姓名
		for(int v : bfp.pathTo(SG.index(name))) {
			System.out.println(SG.name(v));
		}
	}

}