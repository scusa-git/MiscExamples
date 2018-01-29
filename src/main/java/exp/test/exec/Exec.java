package exp.test.exec;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Exec {

	public static void exec() {

		ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "echo", "%PATH%");
		Map<String, String> env = processBuilder.environment();

		Set<String> keySet = env.keySet();
		for (String key : keySet) {
			System.out.println(key + ":" + env.get(key));
		}

	}

	public static void exec2() {

		ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "echo", "%POPO%", "%POPO3%");
		Map<String, String> env = processBuilder.environment();
		env.put("POPO", "PURUM");
		env.put("POPO3", "PURUM3");

		Process process = null;
		try {
			process = processBuilder.start();
			System.out.println(process.waitFor());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			process.destroy();
		}

	}

	public static void exec3() {

		ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "echo", "%POPO%", "%POPO3%");
		Map<String, String> env = processBuilder.environment();
		env.remove("POPO");
		env.remove("POPO3");

		try (InputStream inputStream = processBuilder.start().getInputStream();) {
			System.out.println(new Scanner(inputStream).nextLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("exec2");
		exec2();
		System.out.println("exec3");
		exec3();
	}
}
