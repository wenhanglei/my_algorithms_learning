import java.util.Scanner;


public class DegreesOfSeparation {
	/**
	 * ʹ�ù�����ȱ���ʵ�ַ���Ȳ�ѯ
	 * @param args
	 */
	public static void main(String[] args) {
		//�������ͼ
		SymbolGraph SG = new SymbolGraph(args[0], args[1]);
		int s = SG.index(args[2]);
		
		BreadthFirstPaths bfp = new BreadthFirstPaths(SG.G, s);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("please inter your film performer:");
		String name = scanner.nextLine();           //�����Ҫ��ѯ����Ա����
		for(int v : bfp.pathTo(SG.index(name))) {
			System.out.println(SG.name(v));
		}
	}

}
