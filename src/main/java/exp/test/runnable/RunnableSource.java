package exp.test.runnable;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class RunnableSource {

	public Runnable writeToQueue(final BlockingQueue<String> targetQueue) {

		System.out.println("START SOURCE");

		final String test = "AAA";
		String prev = "";

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				try {

					for (int i = 0; i < 31; i++) {

						targetQueue.offer(test + "_" + i);

					}

					// Terminating
					targetQueue.put("");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		return runnable;
	}

}
