package simulation;

/**
 * 粒子碰撞仿真的粒子类
 * @author Administrator
 *
 */
public class Particle {
	/**
	 * 在单位方框内随机创建一个粒子类
	 */
	public Particle() {
	}
	/**
	 * 依据特定位置，速度，粒子半径，质量创建粒子对象
	 */
	public Particle(double rx, double ry, 
			double vx, double vy, double s, double mass){
	}
	/**
	 * 绘制该粒子对象
	 */
	public void draw() {
	}
	/**
	 * 移动粒子状态到dt时间后的状态
	 */
	public void move(double dt) {
		
	}
	/**
	 * 该粒子可能涉及的碰撞次数
	 */
	public int count() {
		return 0;
	}
	/**
	 * 该粒子碰撞b粒子的时间
	 */
	public double timeTOHit(Particle b) {
		return 0;
	}
	/**
	 * 该粒子碰撞水平墙的时间
	 */
	public double timeToHitHorizontalWall() {
		return 0;
	}
	/**
	 * 该粒子碰撞垂直墙的时间
	 */
	public double timeToHitVerticalWall() {
		return 0;
	}
	/**
	 * 与粒子b碰撞后改变该粒子的速度
	 */
	public void bounceOff(Particle b) {
		
	}
	/**
	 * 与水平墙碰撞后改变该粒子的速度
	 */
	public void bounceOffHorizontalWall() {
		
	}
	/**
	 * 与垂直墙碰撞后修改该粒子的速度
	 */
	public void bounceOffVerticalWall() {
		
	}
}
















