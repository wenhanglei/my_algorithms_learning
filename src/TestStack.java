import junit.framework.TestCase;

public class TestStack extends TestCase{
	Stack<String> stack;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		//����ջ����
		stack = new Stack<String>();
	}
	
	public void testPush() {
		stack.push("haha");
		assertEquals(1, stack.N);
	}
}
