package test;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestCalendar {
	public static void main(String[] args) throws InterruptedException {
		long initialTime = System.currentTimeMillis();
		TimeUnit.SECONDS.sleep(3);
		long stopTime = System.currentTimeMillis();
		System.out.println(initialTime);
		System.out.println(stopTime);
		long elpasedTime = stopTime - initialTime;
		long eT = TimeUnit.MILLISECONDS.toSeconds(elpasedTime);
		System.out.println(eT);
	}
}