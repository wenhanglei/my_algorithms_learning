import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * 遗传学基因编码数据的数据压缩和恢复
 * @author Administrator
 *
 */
public class Genome {
	
	/**
	 * 数据压缩方法
	 * @throws IOException 
	 */
	public static void compress() throws IOException {
//		BufferedReader reader = new BufferedReader(
//				new InputStreamReader(System.in));
//		System.out.println(reader.readLine());
//		while(!BinaryStdIn.isEmpty()) {
//			char c = BinaryStdIn.readChar();
//			
//		}
		BinaryStdOut.write(0, 2);
		BinaryStdOut.flush();
	}
	/**
	 * 数据恢复方法
	 */
	public static void extend() {
		
	}
	/**
	 * 测试方法
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		if(args[0] == "-") compress(); //如果是控制台传递的参数为减号则压缩文件
//		else if(args[0] == "+") extend(); //如果是加好则恢复文件
		//读取文件流
		//包装文件流
		 BufferedInputStream is = new BufferedInputStream(
						new FileInputStream("/e:/think_in_java/test.txt"));
		//保存标准输入流
		InputStream intmp = System.in;
		//将获得的文件流赋值给标准输入流
		System.setIn(is);
		//输出流重定向
		PrintStream os = new PrintStream(
				new FileOutputStream("/e:/think_in_java/data.txt"));
		System.setOut(os);
		compress();
	}
}
