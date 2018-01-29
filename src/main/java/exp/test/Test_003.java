package exp.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Test_003 {

	public static void main(String[] args) {

		Path path_001 = Paths.get("aaa", "bbb", "ccc");
		Path path_002 = Paths.get("aaa", "bbb", "ccc", "ddd", "eee");

		Path path_003 = Paths.get("aaa", "bbb", "ccc.txt");
		Path path_004 = Paths.get("bbb", "archive", "xxx.txt");

		System.out.println(path_001.relativize(path_002));
		System.out.println(path_003.resolveSibling(path_004));
	}

}
