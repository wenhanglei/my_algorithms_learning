package simulation;

public class Event implements Comparable<Event> {
	//碰撞事件的发生时间
	private final double time;
	//碰撞事件的事件源
	private final Particle a, b;
	//事件源的已碰撞次数
	private final int countA, countB;
	
	/**事件对象的初始化
	 * 如果a粒子为null则表示与水平墙碰撞
	 * 如果b粒子为null则表示与垂直墙碰撞
	 */
	public Event(double t, Particle a, Particle b) {
		this.time = t;
		this.a = a;
		this.b = b;
		if(a != null) countA = a.count(); else countA = -1;
		if(b != null) countB = b.count(); else countB = -1;
	}
	//该世间是否是有效碰撞事件
	public boolean isValid() {
		if(a != null && a.count() != countA) return false;
		if(b != null && b.count() != countB) return false;
		return true;
	}

	@Override
	public int compareTo(Event that) {
		if(this.time > that.time) return 1;
		else if(this.time < that.time) return -1;
		else return 0;
	}
}
