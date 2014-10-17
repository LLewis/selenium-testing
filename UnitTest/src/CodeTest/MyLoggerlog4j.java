package CodeTest;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.Test;

/**
 * Can user Logger in any application.  Logger needs Formatter and Handler .
 * FileHandler is used to store all the log messages in a log file.
 * A simple formatter is used to format the log messages in human readable form
 * @author llewis
 *
 */
public class MyLoggerlog4j {
	
@Test
public void TestLogger(){
	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;
	
	try{
		//block to configure the logger with handler and formatter
		fh = new FileHandler("c\\MyLogFile.log", true);
		logger.addHandler(fh);
		logger.setLevel(Level.ALL);
		SimpleFormatter formatter = new SimpleFormatter();
		
		//the following statement is used to log any messages
		logger.log(Level.WARNING, "My first log");
	}catch (SecurityException e1){
		e1.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
	}

}

