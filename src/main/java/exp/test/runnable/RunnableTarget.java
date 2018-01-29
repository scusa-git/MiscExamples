package exp.test.runnable;

import java.util.concurrent.BlockingQueue;

public class RunnableTarget {

	public Runnable readFromQueue(final BlockingQueue<String> queue) {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {

					String st = "";

					while (!(st = queue.take()).isEmpty()) {

						System.out.println(st);

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		return runnable;
	}

}
