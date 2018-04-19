package exp.test.checksum;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.apache.commons.codec.digest.DigestUtils;

public class CheckSumForFile {
	
	private Path filePath;
	
	public CheckSumForFile(Path filePath) {
		this.filePath = filePath;
	}

	public String getMD5() {
		
		String md5 = null;
		
		try (InputStream fileInputStream = Files.newInputStream(this.filePath, StandardOpenOption.READ);) {
			
			md5 = DigestUtils.md5Hex(fileInputStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return md5;
		
	}
	
	
}
