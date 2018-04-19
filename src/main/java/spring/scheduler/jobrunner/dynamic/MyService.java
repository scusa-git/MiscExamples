package spring.scheduler.jobrunner.dynamic;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	public void exec() {
		System.out.println("EXEC at:"+new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
	}

}
