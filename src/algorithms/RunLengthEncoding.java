package algorithms;
/**
 * 行程编码实现
 * @author Administrator
 *
 */
public class RunLengthEncoding {
	
	/**
	 * 压缩方法
	 */
	public void compress() {
		
		/*
		 * 1. 从标准输入中读取一个二进制位
		 * 2. 判断该二进制位是否与前一个二进制为相同：
		 * 		> 如果不同向标准输出流写入计数count的值，并重置count为0
		 * 		> 如果和上一位相同并且计数值达到最大，则向标准输出流写入该count值，再记下count为0，重置count
		 * 3. 累加count的值
		 */
		boolean curr = BinaryStdIn.readBoolean();
		int count = 1;                           //默认第一个值为0
		if(curr == true) 
			count = 0;                           //如果第一个值为1，则重置count
		while(!BinaryStdIn.isEmpty()){
			//从标准输入流中读取一位
			boolean next = BinaryStdIn.readBoolean();
			if(next != curr) { 
				BinaryStdOut.write(count, 8);           //记下count的值
				count = 0;                              //重置count为0
			}else if(next == curr && count == 255) {      //如果计数到达最大值
				BinaryStdOut.write(count, 8);
				BinaryStdOut.write(0, 8);
				count = 0;
			}
			count++;
		}
		BinaryStdOut.flush();
		BinaryStdOut.close();
	}
	/**
	 * 恢复方法
	 */
	public void extend() {
		/*
		 * 1. 从标准输入中读取一个8位的int数值
		 * 2. 遍历该数值向标准输出交替打印0和1
		 */
		boolean isOne = false;
		while(!BinaryStdIn.isEmpty()) {
			int count = BinaryStdIn.readInt(8);
			for(int i = 0; i < count; i++) {
				BinaryStdOut.write(isOne);
			}
			isOne = !isOne;
		}
		BinaryStdOut.close();
	}
	/**
	 * 用于测试的方法
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}















