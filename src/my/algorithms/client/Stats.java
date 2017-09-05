package my.algorithms.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Stats {
	/**
	 * 从控制台获取输入的数据求数据的平均值和标准差
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			System.out.println("No." + i + ":");
			int a = scanner.nextInt();
			arr[i] = a;
		}
		System.out.println(Arrays.toString(arr));
			
	}

}
