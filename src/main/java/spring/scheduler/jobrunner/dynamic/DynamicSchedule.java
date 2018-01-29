package spring.scheduler.jobrunner.dynamic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.stereotype.Component;

public class DynamicSchedule implements Trigger {

	private static final Logger logger = LoggerFactory.getLogger(DynamicSchedule.class);
	private static final SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	private TaskScheduler scheduler;
	private Runnable task;
	private ScheduledFuture<?> future;
	// private JobStateHolder jobStateHolder;
	private int delay;

	public DynamicSchedule(TaskScheduler scheduler, Runnable task, int delay) {
		this.scheduler = scheduler;
		this.task = task;
		// this.jobStateHolder = jobStateHolder;
		reset(delay);
	}

	public void reset(int delay) {
		if (future != null) {
			logger.debug("Cancelling task...");
			future.cancel(true);
		}
		this.delay = delay;
		logger.debug("Starting task...");
		future = scheduler.schedule(task, this);
	}

	public void stopJob() {
		if (future != null) {
			logger.debug("Cancelling task...");
			future.cancel(true);
		}
	}

	@Override
	public Date nextExecutionTime(TriggerContext triggerContext) {

		Date nextExecutionTime = null;

		Date lastCompletionTime = triggerContext.lastCompletionTime();
		// task.
		//
		// String jobName = jobStateHolder.getJobName();
		// boolean jobComplete = jobStateHolder.isJobComplete();

		// if (jobComplete) {
		// logger.debug("JOB [{}] is complete !!!", jobName);
		logger.debug("LastCompletionTime:  {}", lastCompletionTime);
		stopJob();
		// } else {

		Date lastTime = triggerContext.lastActualExecutionTime();
		// Date nextExecutionTime = (lastTime == null) ? new Date() : new
		// Date(lastTime.getTime() + delay);
		// nextExecutionTime = (lastTime == null) ? new Date() : new
		// Date(lastTime.getTime() + delay);

		// nextExecutionTime = (lastCompletionTime == null) ? new Date() : new
		// Date(lastCompletionTime.getTime() + 30000);

		nextExecutionTime = new Date(new Date().getTime() + 30000);

		logger.debug("DynamicSchedule -- delay: {}", delay);
		logger.debug("LastActualExecutionTime:  {}", (lastTime == null ? null : df.format(lastTime)));
		logger.debug("NextExecutionTime:        {}", df.format(nextExecutionTime));
		// }
		return nextExecutionTime;
	}

}
