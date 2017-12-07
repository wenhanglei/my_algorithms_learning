package simulation;

public class CollisionSystem {
	/**
	 * 碰撞预测函数
	 * @param a
	 * @param limit
	 */
	private void predictCollisions(Particle a, double limit) {
		if(a == null) return;
		for(int i = 0; i < particles.length; i++) {
			double dt = a.timeTOHit(particles[i]);
			if(t + dt <= limit)
				pq.inset(new Event(t + dt, a, particles[i]));
		}
		double dtX = a.timeToHitVerticalWall();
		if(t + dtX <= limit)
			p.inset(new Event(t + dtX, a, null));
		double dtY = a.timeToHitHorizontalWall();
		if(t + dtY <= limit)
			pq.insert(new Event(t + dtY, null, a));
	}
}
