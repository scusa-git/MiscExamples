package exp.test.runnable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RunnableMain {

	public static void main(String[] args) {

		BlockingQueue<String> queue = new LinkedBlockingQueue<>(1);

		RunnableSource source = new RunnableSource();
		RunnableTarget target = new RunnableTarget();

		Runnable sourceQueue = source.writeToQueue(queue);
		Runnable targetQueue = target.readFromQueue(queue);

		Thread dataFromSource = new Thread(sourceQueue);
		dataFromSource.setName("DataFromSource");
		Thread dataToTarget = new Thread(targetQueue);
		dataToTarget.setName("DataToTarget");

		dataFromSource.start();
		dataToTarget.start();

	}

}
