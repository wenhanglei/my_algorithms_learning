package algorithms;
/**
 * 读取控制台参数打印一个二进制流到标准输出
 * @author Administrator
 *
 */
public class BinaryDump {
	public static void main(String[] args) {
		//读取每个字符需要的位宽度
		int width = Integer.parseInt(args[0]);
		//总的二进制位个数
		int cnt;
		for(cnt = 0; !BinaryStdIn.isEmpty(); cnt++) {
			if(width == 0) continue;
			if(cnt != 0 && cnt % width == 0)
				System.out.println();
			if(BinaryStdIn.readBoolean()) 
				System.out.print("1");
			else System.out.print("0");
		}
		System.out.println();
		System.out.println(cnt + " bits");
	}
}