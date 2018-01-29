package exp.test.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;

public class Singleton {

	private Properties properties;

	private static final class InstanceHolder {
		static final Singleton INSTANCE = new Singleton();
	}

	private Singleton() {
		properties = new Properties();

		Path marsConfigPath = Paths.get("C:\\hermann\\git-new\\mars\\config\\hermann\\mars.properties");
		System.out.println("MARS Configuration Path:" + marsConfigPath);

		File marsConfigFile = marsConfigPath.toFile();

		try (InputStream stream = new FileInputStream(marsConfigFile)) {
			properties.load(stream);
		} catch (IOException e) {
			System.out.println("Could not load configuration file");
		}

	}

	public static Singleton getInstance() {
		if (InstanceHolder.INSTANCE == null) {
			System.out.println("INSTANCE not exist");
		} else {
			System.out.println(InstanceHolder.INSTANCE.toString());
		}
		return InstanceHolder.INSTANCE;
	}

	public void getProperties() {

		Set<Object> keySet = properties.keySet();
		for (Object key : keySet) {
			System.out.println("key:" + key + " -> value:" + properties.getProperty(key.toString()));
		}

	}
}
