package org.eniauction.models.bll;

import java.util.Timer;

public class ScheduledTask {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MaTask(), 1000, 5000);

	}
}
