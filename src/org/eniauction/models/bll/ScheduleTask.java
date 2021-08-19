package org.eniauction.models.bll;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleTask {

	public Date getMidnight() {

		Long time = new Date().getTime();
		Date midnight = new Date(time - time % (24 * 60 * 60 * 1000));

		return midnight;
	}

	public void scheduleDailyTask() {
		TimerTask closeAuction = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub de comparaison des dates de début et fin des
				// enchères

			}

		};

		Timer timer = new Timer();
		timer.schedule(closeAuction, getMidnight());

	}

}
