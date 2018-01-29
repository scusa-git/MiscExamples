package exp.nio.test;

import java.util.Map;

public class EnvironmentVariables {

	private Map<String, String> environmentVariables;

	private static final class InstanceHolder {
		static final EnvironmentVariables INSTANCE = new EnvironmentVariables();
	}

	private EnvironmentVariables() {
		environmentVariables = System.getenv();
	}

	public static EnvironmentVariables instance() {
		return InstanceHolder.INSTANCE;
	}

	public Map<String, String> getVariables() {
		return environmentVariables;
	}

	public String getVariable(String key) {
		return environmentVariables.get(key);
	}
}
