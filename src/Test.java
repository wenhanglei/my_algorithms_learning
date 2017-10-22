import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;


public class Test {
	public static void main(String[] args) throws IOException {
		
		System.out.println(StdIn.readInt());
		StdIn.readInt();
		while(StdIn.hasNextLine()){
			String[] data = StdIn.readLine().split(" ");
			if(data[0] != null && !data[0].equals("")){
				int i = Integer.parseInt(data[0]);
				System.out.println(i);
			}
		}
//		OutputStream os = new FileOutputStream("haha.txt");
//		OutputStreamWriter wr = new OutputStreamWriter(os);
//		PrintWriter w = new PrintWriter(wr);
//		w.write("ni shi yi ge da sb!");
//		w.close();
//		wr.close();
//		os.close();
		
		
//		ResizingArrayStack<String> a = new ResizingArrayStack<String>(2);
//		//返回stack的大小
//		System.out.println(a.size());
//		//是否为空
//		System.out.println(a.isEmpty());
//		a.push("hahah");
//		a.push("kaka");
//		a.push("baba");
//		a.push("mama");
//		a.push("biabia");
//		System.out.println(a.size());
//		System.out.println(a.pop());
//		System.out.println(a.pop());
//		System.out.println(a.pop());
//		System.out.println("----------------------------------");
//		for (String s : a) {
//			System.out.println(s);
//		}
	}
}
