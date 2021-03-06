package simulation;

import java.awt.Color;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.events.EventException;

public class CollisionSystem {

	private final static double HZ = 0.5;      //绘制的频率
	
	private MinPQ<Event> pq;                   //存放事件的优先队列
	private Particle[] pts;                    //碰撞仿真粒子的容器
	private double t = 0.0;                    //模拟时钟
	
	/**
	 * 构造函数：
	 *  1. 设置整个碰撞系统的粒子总数
	 *  2. 随机创建所有的粒子
	 * 	3. 使用predictCollition初始化事件队列
	 */
	public CollisionSystem() {
	}
	
	public CollisionSystem(Particle[] pts) {
		this.pts = pts.clone();
	}

	/**
	 * 仿真函数：
	 * 	1. 从优先队列取出即将发生碰撞事件
	 *  2. 判断碰撞事件是否合法, 如果不和法返回步骤1
	 *  3. 以简单的直线运动先前推进时间t
	 *  4. 更新碰撞后的粒子速度
	 *  5. 使用predictCollition预测碰撞粒子参与的可能发生的碰撞事件插入到优先队列中
	 */
//	public void simulate(double limit) {
//		//初始化事件队列
//		for(int i = 0; i < pts.length; i++) {
//			predictCollitions(pts[i], limit);
//		}
//		//插入重绘事件
//		pq.insert(new Event(t+1.0/HZ, null, null));
//		while(!pq.isEmpty()){
//			//从当前优先队列取出即将发生的碰撞事件
//			Event e = pq.deMin();
//			//判断碰撞事件是否合法
//			if(!e.isValid())                  //如果碰撞事件不合法
//				continue;
//			//如果碰撞事件合法
//			
//			
//		}
//			
//	}
	public void simulate(double limit) {
		//初始化事件队列
		pq = new MinPQ<Event>();
		for(int i = 0; i < pts.length; i++) {
			predictCollitions(pts[i], limit);
		}
		//第一次绘制事件
		pq.insert(new Event(0, null, null));
		while(!pq.isEmpty()){
			//获取即将发生的事件
			Event e = pq.delMin();
			//如果该事件不合法则继续读取下一个将事件
			if(!e.isValid()) continue;
			
			//绘制图像到事件发生之前的时刻
			for(int i = 0; i < pts.length; i++) 
				pts[i].move(e.time - t);
			//修改时间参数
			t = e.time;
			
			//获取碰撞的粒子
			Particle a = e.a;
			Particle b = e.b;
			
			//修改粒子碰撞后的运动状态
			
			if(e.a == null && e.b != null) e.b.bounceOffHorizontalWall();
			else if(e.a != null && e.b == null) e.a.bounceOffVerticalWall();
			else if(e.a != null && e.b != null) e.a.bounceOff(e.b);
			else redraw(limit);
			
			//预测碰撞后粒子新的碰撞事件
			predictCollitions(a, limit);
			predictCollitions(b, limit);
		}
	}
	
	/**
	 * 重新绘制该碰撞系统
	 */
	private void redraw(double limit) {
		//清空当前绘制的图案
		StdDraw.clear();
		//绘制新的图案
		for(int i = 0; i < pts.length; i++) {
			pts[i].draw();
		}
		//显示该图案
		StdDraw.show();
		//暂停20毫秒
		StdDraw.pause(2);
		//插入下一次的绘制事件
		if(t < limit)
			pq.insert(new Event(t+1.0/HZ, null, null));
	}
	
	/**
	 * 预测粒子a可能出现的碰撞情况并把碰撞事件存放到事件队列中
	 * limit 我们关心的事件必须发生的时刻，如果事件时间大于该时刻则不关心
	 */
	private final void predictCollitions(Particle a, double limit) {
		if(a == null) return;
		//粒子a与其他粒子的碰撞
		for(int i = 0; i < pts.length; i++) {
			Particle b = pts[i];
			if(b != a) {
				double dt = a.timeToHit(b);
				if(t+dt < limit)
					pq.insert(new Event(t+dt, a, b));
			}
		}
		//粒子a与水平墙的碰撞
		double dX = a.timeToHitHorizontalWall();
		if(t+dX < limit){
			pq.insert(new Event(t+dX, null, a));
		}
		//粒子a与垂直墙碰撞
		double dY = a.timeToHitVerticalWall();
		if(t+dY < limit){
			pq.insert(new Event(t+dY, a, null));
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		//绘制主窗口
		StdDraw.setCanvasSize(500, 500);
		//开启双缓存
		StdDraw.enableDoubleBuffering();
		
		//创建一组随机粒子
//		Particle[] pts = new Particle[100];
//		for(int i = 0; i < pts.length; i++) {
//			pts[i] = new Particle();
//		}
		//创建指定粒子
		Particle[] pts = new Particle[1];
		pts[0] = new Particle(0, 0.5, 0.0005, 0, 0.02, 0.5, Color.BLACK);
		
		//获取这组粒子构成的碰撞系统对象
		CollisionSystem collisionSystem = new CollisionSystem(pts);
		//调用仿真函数
		collisionSystem.simulate(10000);
	}
	
}
