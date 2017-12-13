package algorithms;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 求和为0的三个数的数量
 * @author Administrator
 *
 */
public class ThreeSum {
	public static int count(int[] a) {
		int num = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				for(int k = j+1; k < a.length; k++) {
					if ((a[i] + a[j] + a[k]) == 0) num++;
				}
			}
		}
		return num;
	}
	public static void main(String[] args) {
		int[] arr = In.readInts();
		StopWatch eT = new StopWatch();
		int num = count(arr);
		double time = eT.elapsedTime();
		System.out.println(num + "triples " + time + 
				"seconds elapsed.");
	}
}