package simulation;

import java.awt.Color;
import java.util.Random;

/**
 * 粒子碰撞仿真的粒子类
 * @author Administrator
 *
 */
public class Particle {
	//无穷大
	private static final double INFINITY = Double.POSITIVE_INFINITY;
	//粒子的当前位置
	private double rx, ry;
	//粒子水平方向和垂直方向的速度分量
	private double vx, vy;
	//粒子的半径
	private double s;
	//粒子的质量
	private double mass;
	//碰撞次数
	private int count;
	//粒子颜色
	private Color color;
	
	
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
	public double timeTOHit(Particle that) {
		if (this == that) return INFINITY;
        double dx  = that.rx - this.rx;
        double dy  = that.ry - this.ry;
        double dvx = that.vx - this.vx;
        double dvy = that.vy - this.vy;
        double dvdr = dx*dvx + dy*dvy;
        if (dvdr > 0) return INFINITY;
        double dvdv = dvx*dvx + dvy*dvy;
        double drdr = dx*dx + dy*dy;
        double sigma = this.s + that.s;
        double d = (dvdr*dvdr) - dvdv * (drdr - sigma*sigma);
        if (d < 0) return INFINITY;
        return -(dvdr + Math.sqrt(d)) / dvdv;
	}
	/**
	 * 该粒子碰撞水平墙的时间
	 */
	public double timeToHitHorizontalWall() {
		//如果粒子速度为0
		if(vy == 0) return INFINITY;
		//如果该粒子向上边移动
		else if(vx > 0) {
			return (1.0-ry-s)/vy;
		}else{                            //如果粒子向下移动
			return s-ry/vy;
		}
	}
	/**
	 * 该粒子碰撞垂直墙的时间
	 */
	public double timeToHitVerticalWall() {
		//如果粒子速度为0
		if(vx == 0) return INFINITY;
		//如果该粒子向右边移动
		else if(vx > 0) {
			return (1.0-rx-s)/vx;
		}else{                            //如果粒子向左移动
			return s-rx/vx;
		}
	}
	/**
	 * 与粒子b碰撞后改变该粒子的速度
	 */
	public void bounceOff(Particle that) {
		double dx  = that.rx - this.rx;
        double dy  = that.ry - this.ry;
        double dvx = that.vx - this.vx;
        double dvy = that.vy - this.vy;
        double dvdr = dx*dvx + dy*dvy;             
        double dist = this.s + that.s;

        double magnitude = 2 * this.mass * that.mass * dvdr / ((this.mass + that.mass) * dist);

        double fx = magnitude * dx / dist;
        double fy = magnitude * dy / dist;

        this.vx += fx / this.mass;
        this.vy += fy / this.mass;
        that.vx -= fx / that.mass;
        that.vy -= fy / that.mass;

        this.count++;
        that.count++;
	}
	/**
	 * 与水平墙碰撞后改变该粒子的速度
	 */
	public void bounceOffHorizontalWall() {
		vy = -vy;
        count++;
	}
	/**
	 * 与垂直墙碰撞后修改该粒子的速度
	 */
	public void bounceOffVerticalWall() {
		vx = -vx;
        count++;
	}
	
	public double kineticEnergy() {
        return 0.5 * mass * (vx*vx + vy*vy);
    }
}
















