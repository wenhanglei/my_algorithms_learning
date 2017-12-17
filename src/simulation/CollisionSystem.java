package simulation;

import java.util.Timer;
import java.util.TimerTask;

import algorithms.MinPQ;

public class CollisionSystem {
	//存放事件的优先队列
	private MinPQ<Event> pq;
	//碰撞系统的粒子总数
//	private final int num;
	//碰撞仿真粒子的容器
	private Particle[] ptcs;
	//当前时间
	private double t;
	
	/**
	 * 构造函数：
	 *  1. 设置整个碰撞系统的粒子总数
	 *  2. 随机创建所有的粒子
	 * 	3. 使用predictCollition初始化事件队列
	 */
	public CollisionSystem() {
//		//设置碰撞粒子总数为20个
//		num = 20;
//		//初始化所有的粒子
//		ptcs = new Particle[num];
//		for(int i = 0; i < num; i++)
//			ptcs[i] = new Particle();
//		//创建事件队列
//		pq = new MinPQ<Event>();
//		//使用predictCollitions初始化事件队列
//		//初始化当前时间
//		t = new Date().getTime();
//		for(int i = 0; i < num; i++) {
//			//0.2秒以外的事件不考虑
//			predictCollitions(ptcs[i], t+200);
//		}
		
	}
	/**
	 * 绘制方法
	 */
	public void show() {
		Particle p = new Particle(0.1, 0.5, 0.002, 0, 0.01, 0.5);
		p.draw();
		
	}
	
	/**
	 * 仿真函数：
	 * 	1. 从优先队列取出即将发生碰撞事件
	 *  2. 判断碰撞事件是否合法, 如果不和法返回步骤1
	 *  3. 以简单的直线运动先前推进时间t
	 *  4. 更新碰撞后的粒子速度
	 *  5. 使用predictCollition预测碰撞粒子参与的可能发生的碰撞事件插入到优先队列中
	 */
//	public void simulate() {
//		//从优先队列中取出即将发生碰撞的事件
//		Event e = null;
//		//最小时间片段
//		double dt = 5;
//		//当前时间 
//		double t = new Date().getTime();
//		while(true){
//			e = pq.deMin();
//			//如果碰撞事件不合法则继续
//			if(!e.isValid()) continue;
//			//以简单的直线运动更新粒子的位置
//			while(t+dt < e.time) {
//				for(int i = 0; i < num; i++) {
//					ptcs[i].move(dt);
//				}
//				t += dt;
//			}
//			//更新碰撞后的粒子速度并且预测粒子可能参加的碰撞事件
//			if(e.a != null && e.b != null) {
//				e.a.bounceOff(e.b);
//				e.b.bounceOff(e.a);
//				predictCollitions(e.a, t+20);
//				predictCollitions(e.b, t+20);
//			}else if(e.a == null) {
//				e.b.bounceOffHorizontalWall();
//				predictCollitions(e.b, t+20);
//			}else {
//				e.a.bounceOffVerticalWall();
//				predictCollitions(e.a, t+20);
//			}
//		}
//	}
	
	/**
	 * 预测粒子a可能出现的碰撞情况并把碰撞事件存放到事件队列中
	 * limit 我们关心的事件必须发生的时刻，如果事件时间大于该时刻则不关心
	 */
//	public final void predictCollitions(Particle a, double limit) {
//		if(a == null) return;
//		//粒子a与其他粒子的碰撞
//		for(int i = 0; i < num; i++) {
//			Particle b = ptcs[i];
//			if(b != a) {
//				double dt = a.timeTOHit(b);
//				if(t+dt < limit)
//					pq.insert(new Event(t+dt, a, b));
//			}
//		}
//		//粒子a与水平墙的碰撞
//		double dX = a.timeToHitHorizontalWall();
//		if(t+dX < limit){
//			pq.insert(new Event(t+dX, null, a));
//		}
//		//粒子a与垂直墙碰撞
//		double dY = a.timeToHitVerticalWall();
//		if(t+dY < limit){
//			pq.insert(new Event(t+dY, a, null));
//		}
//	}
	
	public static void main(String[] args) {
		CollisionSystem syst = new CollisionSystem();
		syst.show();
	}
}
