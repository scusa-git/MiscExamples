package exp.scpsftp;

import java.io.IOException;
import java.nio.file.Paths;

import net.schmizz.sshj.SSHClient;


/** This example demonstrates uploading of a file over SCP to the SSH server. */
public class SCPUpload {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SSHClient ssh = new SSHClient();
		
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");//, ".ssh"
		
		String sshPath = Paths.get(userHome, ".ssh").toString();
		
		System.out.println("User name:" +userName);
		System.out.println("User home:" +userHome);
		System.out.println("SSH path:" +sshPath);
		
		ssh.loadKnownHosts();
		
		
		ssh.connect("localhost");
		try {
			
			
			
			
			
			ssh.authPublickey(userName);

			// Present here to demo algorithm renegotiation - could have just put this
			// before connect()
			// Make sure JZlib is in classpath for this to work
			ssh.useCompression();
			
//			final String src = Paths.get(userHome, "test_file").toString();
			// final String src = userHome + File.separator + "test_file";
			
//			ssh.newSCPFileTransfer().upload(new FileSystemFile(src), "/tmp/");
		} finally {
			ssh.disconnect();
		}
	}
}
