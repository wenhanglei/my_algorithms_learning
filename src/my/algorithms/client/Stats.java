package my.algorithms.client;

import java.io.IOException;
import java.util.Scanner;

import my.algorithms.adt.Bag;

public class Stats {
	/**
	 * �ӿ���̨��ȡ��������������ݵ�ƽ��ֵ�ͱ�׼��
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//�������ڴ洢�������ݵ�bag����
		Bag<Integer> data = new Bag<Integer>();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			//��ȡ�û������벢��ӵ�bag������
			data.add(scanner.nextInt());
		}
		//�����������ݵ�ƽ��ֵ
		double sum = 0;
		for (int i : data){
			sum += i;
		}
		double mean = sum/data.size();
		//�����������ݵı�׼��
		double temp = 0;
		for (int i : data){
			temp += (i-mean)*(i-mean);
		}
		double dev = Math.sqrt(temp/(data.size()-1));
		System.out.println("Mean: " + mean);
		System.out.println("dev: " + dev);
	}

}
