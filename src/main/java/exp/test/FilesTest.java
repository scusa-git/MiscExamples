package exp.test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FilesTest {
	
	public static void findFiles() {
		
//		String path = "c:/MARS/utl_files";
		String path = "C:/MARS/sql_loader_logs";
		Path filesPath = Paths.get(path);
		
		File filesToSend = filesPath.toFile();//.exists()
		if (filesToSend.exists() && filesToSend.isDirectory()) {
			File[] filesToSendArray = filesToSend.listFiles();
			if (filesToSendArray==null || filesToSendArray.length==0) {
				System.out.println("No reports to send.");
			} else {
				System.out.println("Yes reports be to send.");
			}
		}
	}
	
	public static File directoryToDelete(String baseDirectory) {
		
		String subDirectory = LocalDate.now().minusDays(9L).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println("subDirectory: " + subDirectory);
		
		Path path = Paths.get(baseDirectory, subDirectory);
		System.out.println("Reports path to delete: " + path);
		
		return path.toFile();
	}
	
	public static void deleteDirectory(File path) {
		
		for (File file : path.listFiles()) {
			if (file.isDirectory()) {
				deleteDirectory(file);
			}
			System.out.println("File "+ file.getName()+ " wird gelöscht.");
			file.delete();
		}
		path.delete();
	}
	
	public static void main(String[] args) {
		//findFiles();
//		System.out.println("Files.exists(null, LinkOption.NOFOLLOW_LINKS): " +Files.exists(null, LinkOption.NOFOLLOW_LINKS));
		// delete directory
		String reportsBaseDirectory = "C:/MARS/mars_reports/reports";
		deleteDirectory(directoryToDelete(reportsBaseDirectory));
		
	}

}
