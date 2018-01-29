package exp.test;

public class TableLoaderEnumMain {

	public static void main(String[] args) {
		TableLoaderEnum tTmpDuadv = TableLoaderEnum.T_TMP_DUADV;

		System.out.println(tTmpDuadv.getTableName());
		System.out.println(tTmpDuadv.getControlFileName());
		System.out.println(tTmpDuadv.getDataFileName());
		System.out.println(tTmpDuadv.isAllowedMoveDataFile());

	}

}
