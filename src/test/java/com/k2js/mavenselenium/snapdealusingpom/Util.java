package com.k2js.mavenselenium.snapdealusingpom;

public class Util {
	public static void sleepTime(long l) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
