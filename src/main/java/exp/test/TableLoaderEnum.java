package exp.test;

public enum TableLoaderEnum {

	T_TMP_DUADV("T_TMP_DUADV", "duadv.ctl", "TADV.txt", false);

	private String tableName;
	private String controlFileName;
	private String dataFileName;
	private boolean allowedMoveDataFile;

	private TableLoaderEnum(String tableName, String controlFileName, String dataFileName, boolean allowedMoveDataFile) {
		this.tableName = tableName;
		this.controlFileName = controlFileName;
		this.dataFileName = dataFileName;
		this.allowedMoveDataFile = allowedMoveDataFile;
	}

	public String getTableName() {
		return tableName;
	}

	public String getControlFileName() {
		return controlFileName;
	}

	public String getDataFileName() {
		return dataFileName;
	}

	public boolean isAllowedMoveDataFile() {
		return allowedMoveDataFile;
	}
}
