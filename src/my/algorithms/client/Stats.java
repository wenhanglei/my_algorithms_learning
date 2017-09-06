package my.algorithms.client;

import java.io.IOException;
import java.util.Scanner;

import my.algorithms.adt.Bag;

public class Stats {
	/**
	 * 从控制台获取输入的数据求数据的平均值和标准差
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//创建用于存储输入数据的bag容器
		Bag<Integer> data = new Bag<Integer>();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			//获取用户的输入并添加到bag容器中
			data.add(scanner.nextInt());
		}
		//计算输入数据的平均值
		double sum = 0;
		for (int i : data){
			sum += i;
		}
		double mean = sum/data.size();
		//计算输入数据的标准差
		double temp = 0;
		for (int i : data){
			temp += (i-mean)*(i-mean);
		}
		double dev = Math.sqrt(temp/(data.size()-1));
		System.out.println("Mean: " + mean);
		System.out.println("dev: " + dev);
	}

}
