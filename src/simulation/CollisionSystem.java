package simulation;

import java.util.Date;

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
		this.pts = pts;
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
		//插入重绘事件
		pq.insert(new Event(t+1.0/HZ, null, null));
		//仿真循环
		Event e;
		while(!pq.isEmpty()){
			e = pq.delMin();
			//判断事件内容
			if(!e.isValid()) continue;
			while(t < e.time){
				for(int i = 0; i < pts.length; i++)
					pts[i].move(1);
				redraw();
				t++;
			}
			if(e.a == null && e.b != null){             //与垂直墙碰撞
				e.b.bounceOffVerticalWall();
			}else if(e.a != null && e.b == null){       //与水平墙碰撞
				e.a.bounceOffHorizontalWall();
			}else if(e.a != null && e.b != null){                                      //粒子碰撞
				e.a.bounceOff(e.b);
			}
			//绘制碰撞后的图像
			redraw();
			//预测碰撞粒子的下次碰撞
			predictCollitions(e.a, limit);
			predictCollitions(e.b, limit);
		}
	}
	
	/**
	 * 重新绘制该碰撞系统
	 */
	private void redraw() {
		//清空当前绘制的图案
		StdDraw.clear();
		//绘制新的图案
		for(int i = 0; i < pts.length; i++) {
			pts[i].draw();
		}
		//显示该图案
		StdDraw.show();
		//暂停20毫秒
		StdDraw.pause(20);
		//插入下一次的绘制事件
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
		
		//创建一组随机粒子
		Particle[] pts = new Particle[2];
		for(int i = 0; i < pts.length; i++) {
			pts[i] = new Particle();
		}
		
		//获取这组粒子构成的碰撞系统对象
		CollisionSystem collisionSystem = new CollisionSystem(pts);
		//调用仿真函数
		collisionSystem.simulate(10000);
	}
	
}
