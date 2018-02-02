package re;

public class NFATest {
	
	public static void main(String[] args) {
		NFA nfa = new NFA("((A*B|AC)D)");
		nfa.recognize("AABD");
	}
}
