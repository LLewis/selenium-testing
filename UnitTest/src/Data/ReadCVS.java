package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class ReadCVS {
	
	@Test
	public void readMyCVSFile (){
		

	     try {

	      BufferedReader reader = new BufferedReader(new

	    FileReader("C:\\lsl.txt"));

	      System.out.println(reader.readLine());


	    } catch (IOException e) {


	      System.out.println(e);






	    } 






	 

    } 

	

}
