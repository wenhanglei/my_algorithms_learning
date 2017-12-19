package simulation;

import java.util.Timer;
import java.util.TimerTask;

import algorithms.MinPQ;

public class CollisionSystem {
	
	private MinPQ<Event> pq;                    //存放事件的优先队列
	private final int num;                      //碰撞系统的粒子总数
	private Particle[] ptcs;                    //碰撞仿真粒子的容器
	private double t;                           //当前时间
	
	/**
	 * 构造函数：
	 *  1. 设置整个碰撞系统的粒子总数
	 *  2. 随机创建所有的粒子
	 * 	3. 使用predictCollition初始化事件队列
	 */
	public CollisionSystem() {
		//设置碰撞粒子总数为20个
		num = 20;
		//初始化所有的粒子
		ptcs = new Particle[num];
		for(int i = 0; i < num; i++)
			ptcs[i] = new Particle();
		//创建事件队列
		pq = new MinPQ<Event>();
		//使用predictCollitions初始化事件队列
		//初始化当前时间
		for(int i = 0; i < num; i++) {
			//0.2秒以外的事件不考虑
			predictCollitions(ptcs[i], t+200);
		}
	}
	
	/**
	 * 仿真函数：
	 * 	1. 从优先队列取出即将发生碰撞事件
	 *  2. 判断碰撞事件是否合法, 如果不和法返回步骤1
	 *  3. 以简单的直线运动先前推进时间t
	 *  4. 更新碰撞后的粒子速度
	 *  5. 使用predictCollition预测碰撞粒子参与的可能发生的碰撞事件插入到优先队列中
	 */
	public void simulate() {
	
	}
	
	/**
	 * 预测粒子a可能出现的碰撞情况并把碰撞事件存放到事件队列中
	 * limit 我们关心的事件必须发生的时刻，如果事件时间大于该时刻则不关心
	 */
	public final void predictCollitions(Particle a, double limit) {
		if(a == null) return;
		//粒子a与其他粒子的碰撞
		for(int i = 0; i < num; i++) {
			Particle b = ptcs[i];
			if(b != a) {
				double dt = a.timeTOHit(b);
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
		StdDraw.setCanvasSize(800, 800);
		//开启双缓存
		StdDraw.enableDoubleBuffering();
		
		//获取碰撞系统对象
		CollisionSystem collisionSystem = new CollisionSystem();
		//调用仿真函数
		
	}
	
}
