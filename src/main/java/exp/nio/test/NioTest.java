package exp.nio.test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.UserPrincipal;
import java.util.HashMap;
import java.util.Map;

public class NioTest {

	private static final String FILE = "C:/hermann/BASH/aaa.sh";
	private static final String DIRECTORY = "C:/hermann/BASH/";

	public static void fs() throws IOException {

		// FileSystem fileSystem = FileSystems.getDefault();

		// File file = Paths.get(FILE).toFile();

		// Paths.get(FILE).getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("ex62426");

		UserPrincipal ex = Paths.get(FILE).getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("ex62426");

		// FileSystem fileSystem2 = Paths.get(FILE).getFileSystem();

		Map<String, String> attributes = new HashMap<>();
		attributes.put("create", "true");
		attributes.put("overwrite", "true");

		Path dir = Paths.get(DIRECTORY);
		System.out.println("DIR: " + dir.toString());

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir, "*.{txt,csv,rtf,sh}");) {
			for (Path file : directoryStream) {

				System.out.println("File name: " + file.getFileName());
				// Files.copy(file, zipFileSys.getPath(file.getFileName().toString()),
				// StandardCopyOption.REPLACE_EXISTING);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// System.out.println("Hallo");
		fs();
	}

}
