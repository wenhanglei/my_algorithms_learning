/**
 * ��Ϊ0��������������
 * @author Administrator
 *
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] arr = {1, 5, -2, -3, 4, 7, 3, 9, 2};
		//twosum������
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				int temp = arr[i] + arr[j];
				if(temp == 0) num++;
			}
		}
		System.out.println(num + " tuples");
	}
}
