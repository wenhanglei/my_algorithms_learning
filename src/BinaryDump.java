/**
 * ��ȡ����̨������ӡһ��������������׼���
 * @author Administrator
 *
 */
public class BinaryDump {
	public static void main(String[] args) {
		//��ȡÿ���ַ���Ҫ��λ���
		int width = Integer.parseInt(args[0]);
		//�ܵĶ�����λ����
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
