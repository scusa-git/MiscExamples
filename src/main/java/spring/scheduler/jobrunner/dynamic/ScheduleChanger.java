package spring.scheduler.jobrunner.dynamic;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleChanger {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleChanger.class);

	@Autowired
	private DynamicSchedule dynamicSchedule;

	@Scheduled(fixedDelay = 30000)
	public void change() {
		Random rnd = new Random();
		int nextTimeout = rnd.nextInt(30000);
		logger.debug("Changing poll time to: {}", nextTimeout);
		dynamicSchedule.reset(nextTimeout);
	}

}
