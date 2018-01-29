package exp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;

public class ZipTest {

	private final static String dest = "C:/hermann/JASPERREPORTS_ALL/CSV_Reports/1078";

	public static void readFiles() throws IOException {

		FileOutputStream fos = new FileOutputStream(Paths.get(dest, "all.zip").toString());
		ZipOutputStream zos = new ZipOutputStream(fos);

		Path dir = Paths.get(dest);
		DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{pdf,csv}");

		for (Path file : stream) {
			System.out.println(file.getFileName());
			ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());

			zos.putNextEntry(zipEntry);

			FileInputStream fis = new FileInputStream(file.toAbsolutePath().toString());
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fis.read(buffer)) > 0) {
				zos.write(buffer, 0, len);
			}
			zos.closeEntry();
			fis.close();
		}
		zos.close();
		fos.close();
	}

	public static Path createZip_ORIGIN(String clob, Path zipFilePath, String sourceDirectory) {

		Map<String, String> attributes = new HashMap<>();
		attributes.put("create", "true");
		attributes.put("overwrite", "true");

		System.out.println("zipFilePath: " + zipFilePath);

		// Path zipFilePath = Paths.get(reportsDirectory, zipFileName);

		String reportsAsZip = zipFilePath.toFile().toURI().toString();

		URI zipFile = URI.create("jar:".concat(reportsAsZip));
		// URI zipFile = URI.create(String.format("jar:%s", reportsAsZip));
		// URI zipFile = URI.create(String.format("jar:file:/%s", reportsAsZip));
		// logger.debug("zipFile:{}", zipFile);

		Path dir = Paths.get(sourceDirectory);

		try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {

			// Iterable<Path> rootDirectories = zipFileSys.getRootDirectories();
			// rootDirectories.forEach(path ->System.out.println(path));

			try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir, clob);) {

				// Spliterator<Path> spliterator = directoryStream.spliterator();
				// spliterator.forEachRemaining(p->System.out.println("spl:"+p));

				for (Path file : directoryStream) {
					System.out.println("Path file:" + file.getFileName());
					Files.copy(file, zipFileSys.getPath(file.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return zipFilePath;
	}

	public static Path createZip(String glob, Path zipFilePath, String sourceDirectory) {

		Map<String, String> attributes = new HashMap<>();
		attributes.put("create", "true");
		attributes.put("overwrite", "true");

		System.out.println("zipFilePath: " + zipFilePath);

		// Path zipFilePath = Paths.get(reportsDirectory, zipFileName);

		String reportsAsZip = zipFilePath.toFile().toURI().toString();

		URI zipFile = URI.create("jar:".concat(reportsAsZip));
		Path dir = Paths.get(sourceDirectory);

		try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {

			zipRecursive(zipFileSys, dir, dir, glob);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return zipFilePath;
	}

	private static void getZipRoot(FileSystem zipFileSys) {
		zipFileSys.getRootDirectories().forEach(System.out::println);
	}

	private static void zipRecursive(FileSystem zipFileSys, Path dir, Path subDir, String glob) throws IOException {

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(subDir, glob);) {

			for (Path file : directoryStream) {
				// System.out.println("Path temp:" + dir);
				// System.out.println("Path file:" + file);
				// System.out.println();

				// #################
				// System.out.println("Relativize:"+dir.relativize(file));
				// System.out.println();

				// #################

				Path zp = zipFileSys.getPath(dir.relativize(file).toString());

				System.out.println("zp:" + zp);

				Files.copy(file, zp, StandardCopyOption.REPLACE_EXISTING);

				if (file.toFile().isDirectory()) {

					zipRecursive(zipFileSys, dir, file, glob);
				}
			}
		}
	}

	private static void unZipRecursive(String targetDirectory, Path dir, Path subDir, String glob) throws IOException {

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(subDir, glob);) {

			for (Path file : directoryStream) {
				// System.out.println("Path temp:" + dir);
				// System.out.println("Path file:" + file);
				// System.out.println();

				// #################
				// System.out.println("Relativize:"+dir.relativize(file));
				// System.out.println();

				// #################

				Path target = Paths.get(targetDirectory, dir.relativize(file).toString());

				System.out.println("target:" + target);

				Files.copy(file, target, StandardCopyOption.REPLACE_EXISTING);

				// if (file.toFile().isDirectory()) {
				if (target.toFile().isDirectory()) {

					unZipRecursive(targetDirectory, dir, file, glob);
				}
			}
		}
	}

	public static Path unZip(String clob, Path zipFilePath, String targetDirectory) {

		Map<String, String> attributes = new HashMap<>();
		attributes.put("create", "true");
		attributes.put("overwrite", "true");

		System.out.println("zipFilePath: " + zipFilePath);

		// Path zipFilePath = Paths.get(reportsDirectory, zipFileName);

		String reportsAsZip = zipFilePath.toFile().toURI().toString();

		URI zipFile = URI.create("jar:".concat(reportsAsZip));
		// URI zipFile = URI.create(String.format("jar:%s", reportsAsZip));
		// URI zipFile = URI.create(String.format("jar:file:/%s", reportsAsZip));
		// logger.debug("zipFile:{}", zipFile);

		Path dir = null;

		try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {

			Iterator<Path> iterator = zipFileSys.getRootDirectories().iterator();
			while (iterator.hasNext()) {
				dir = iterator.next();
				break;
			}

			unZipRecursive(targetDirectory, dir, dir, clob);

			// try (DirectoryStream<Path> directoryStream =
			// Files.newDirectoryStream(dir, clob);) {
			// for (Path file : directoryStream) {
			// System.out.println("zip file:"+file);
			//
			// Path path = Paths.get(targetDirectory, file.getFileName().toString());
			//
			// System.out.println("unZip -> Target:"+ path);
			//
			// Files.copy(file, path, StandardCopyOption.REPLACE_EXISTING);
			// }
			// }

		} catch (IOException e) {
			e.printStackTrace();
		}

		return zipFilePath;
	}

	public static void dfg() throws IOException {

		Map<String, String> attributes = new HashMap<>();
		attributes.put("create", "true");
		attributes.put("overwrite", "true");

		String h = Paths.get(dest, "aHaH.zip").toFile().toURI().toString();

		URI zipFile = URI.create("jar:".concat(h));
		System.out.println("zipFile: " + zipFile);

		// URI zipURI = URI.create(String.format("jar:file:/%s",
		// this.getOutputFile()));
		// zipfs = FileSystems.newFileSystem(zipURI, env);

		Path dir = Paths.get(dest);

		try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {

			System.out.println(zipFileSys.getClass());
			System.out.println(zipFileSys.provider());

			try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir, "*.{pdf,csv}");) {

				for (Path file : directoryStream) {

					Files.copy(file, zipFileSys.getPath(file.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);

				}
			}
		}

	}

	public static void ftpFS() throws IOException {

		URI ftp = URI.create("ftp://crushftp.com/Docs/");

		try (FileSystem ftpFileSys = FileSystems.newFileSystem(ftp, null);) {

			System.out.println(ftpFileSys.isOpen());

		}
	}

	public static void main(String[] args) throws Exception {

		// String glob = "{*,*.*}";
		String glob = "*";
		Path zipFilePath = Paths.get("C:/hermann/TEST", "zip_fertig", "test.zip");
		String sourceFilesDirectory = "C:/hermann/TEST/zip_test_source";
		String targetDirectory = "C:/hermann/TEST/target";

		Path zipPath = createZip(glob, zipFilePath, sourceFilesDirectory);
		System.out.println(zipPath);

		Path unZip = unZip(glob, zipFilePath, targetDirectory);
		System.out.println(unZip);
		// ZipTest.readFiles();

		// ZipTest.dfg();
		// ZipTest.ftpFS();
	}
}