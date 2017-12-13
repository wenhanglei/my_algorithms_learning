package algorithms;

public class StopWatch {
	private long startTime;
	public StopWatch() {
		startTime = System.currentTimeMillis();
	}
	public long elapsedTime() {
		long stopTime = System.currentTimeMillis();
		return (stopTime-startTime)/1000;
	}
}