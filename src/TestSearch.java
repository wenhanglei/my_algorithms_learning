import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * ͼ�����㷨�Ĳ��Ժ���
 * @author Administrator
 *
 */
public class TestSearch {
	
	public static void main(String[] args) throws Exception {
		/*
		 * 1�� ����ͼʵ��
		 * 2�� ͨ��ͼʵ��������Ҷ���
		 * 3�� ���ò��Ҷ�����ͼ����Ӧ����
		 */
		In in = new In(args[0]);
		int s = Integer.parseInt(args[1]);
		Graph g = new Graph(in);
		
		Search search = new Search(g, s);
		for(int i = 0; i < g.V(); i++){
			if(search.Marked(i)) System.out.print(i + " ");
		}
		System.out.println();
		if(search.count() != g.V())
			System.out.println("Not ");
		System.out.println("connected");
	}

}











