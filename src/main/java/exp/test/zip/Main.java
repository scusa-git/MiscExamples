package exp.test.zip;

public class Main {

	public static void main(String[] args) {
		// if (args.length != 3) {
		// System.out.print("Requires 3 arguments: [ sync | async ] [ input
		// directory ] [ output file ]");
		// return;
		// }

		String async = "async";
		String inDir = "C:/hermann/JASPERREPORTS_ALL/CSV_Reports/1078";
		String outFile = "C:/hermann/JASPERREPORTS_ALL/CSV_Reports/1078/uuuuuu.zip";
		args = new String[] { async, inDir, outFile };

		Archiver archiver = null;

		if (args[0].equals("sync")) {
			System.out.println("Using synchronous archiver.");
			archiver = new SimpleArchiver(args[1], args[2]);
		} else {
			System.out.println("Using threaded archiver.");
			archiver = new ThreadedArchiver(args[1], args[2]);
		}

		System.out.println("Beginning archiving...");
		long startTime = System.nanoTime();

		archiver.run();

		try {
			archiver.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Archiving interrupted...");
			return;
		}

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		double secondsElapsed = (double) elapsedTime / 1000000000.0;

		System.out.println("Archiving complete!");
		System.out.printf("Archived %s files in %s seconds.", archiver.getCount(), secondsElapsed);
	}

}