package simulation;

import java.awt.Color;
import java.util.Random;

/**
 * 粒子碰撞仿真的粒子类
 * @author Administrator
 *
 */
public class Particle {
	//粒子的当前位置
	double rx, ry;
	//粒子水平方向和垂直方向的速度分量
	double vx, vy;
	//粒子的半径
	double s;
	//粒子的质量
	double mass;
	//碰撞次数
	int count;
	//粒子颜色
	Color color;
	
	
	/**
	 * 在单位方框内随机创建一个粒子类
	 */
	public Particle() {
		Random random = new Random();
		this.rx = LwhRandom.uniform(0.0, 1.0);
		this.ry = LwhRandom.uniform(0.0, 1.0);
		this.vx = LwhRandom.uniform(-0.005, 0.005);
		this.vy = LwhRandom.uniform(-0.005, 0.005);
		this.s = 0.01;
		this.mass = 0.5;
		color = StdDraw.GRAY;
		
	}
	/**
	 * 依据特定位置，速度，粒子半径，质量创建粒子对象
	 */
	public Particle(double rx, double ry, 
			double vx, double vy, double s, double mass){
		this.rx = rx;
		this.ry = ry;
		this.vx = vx;
		this.vy = vy;
		this.s = s;
		this.mass = mass;
		this.color = StdDraw.GRAY;
	}
	/**
	 * 绘制该粒子对象
	 */
	public void draw() {
		//设置粒子的颜色
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(rx, ry, s);
	}
	/**
	 * 移动粒子状态到dt时间后的状态
	 */
	public void move(double dt) {
		rx = vx*dt + rx;
		ry = vx*dt + ry;
	}
	/**
	 * 该粒子可能涉及的碰撞次数
	 */
	public int count() {
		return count;
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
















