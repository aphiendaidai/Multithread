package thread;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import view.ClockMainView;

public class ThreadOfEveryClock extends Thread {
	ClockMainView view;
	String timeZone;
	public ThreadOfEveryClock(ClockMainView view, String timeZone) {
		this.view = view;
		this.timeZone = timeZone;
	}

	public void run() {
		while (true) {
			ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("UTC+" + timeZone));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = currentTime.format(formatter);

			view.updateTime(formattedTime);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
