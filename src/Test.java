
public class Test {
	public static void main(String[] args) {
		ResizingArrayStack<String> a = new ResizingArrayStack<String>(2);
		//����stack�Ĵ�С
		System.out.println(a.size());
		//�Ƿ�Ϊ��
		System.out.println(a.isEmpty());
		a.push("hahah");
		a.push("kaka");
		a.push("baba");
		a.push("mama");
		a.push("biabia");
		System.out.println(a.size());
//		System.out.println(a.pop());
//		System.out.println(a.pop());
//		System.out.println(a.pop());
		System.out.println("----------------------------------");
		for (String s : a) {
			System.out.println(s);
		}
		
	}
}
