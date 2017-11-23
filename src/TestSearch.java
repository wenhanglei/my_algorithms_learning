import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 图查找算法的测试函数
 * @author Administrator
 *
 */
public class TestSearch {
	
	public static void main(String[] args) throws Exception {
		/*
		 * 1、 构造图实例
		 * 2、 通过图实例构造查找对象
		 * 3、 调用查找对象获得图的相应属性
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










