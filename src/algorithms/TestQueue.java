package algorithms;
import java.util.Scanner;


public class TestQueue {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String line = scan.nextLine();
		String line = "to be or not to - be - - that - - - is";
		String[] ws = line.split(" ");
		Queue<String> queue = new Queue<String>();
		for (String w : ws) {
			if (w.equals("-")) {
				System.out.print(queue.dequeue() + " ");
			}
			else queue.enqueue(w);
		}
		System.out.println("(" + queue.size() + " left on queue.)");
	}
}