

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.yaml.snakeyaml.Yaml;

public class SumOfOddNumbersPage {

	/*
	 * @parameters 
	 * @author Prashant Jeet Singh
	 * @createdDate <26/6/2018>
	 */
	@BeforeClass
/*	public static void verifySumationOfOddNumbers() {
		try {
			Yaml yaml = new Yaml();
			InputStream ios = new FileInputStream(new File("E:\\Eclipse Workspace\\QAAutomation\\src\\test\\resources\\qaAutomation\\TestData\\testData.yaml"));
			Map<String,Object> result = (Map<String,Object>)yaml.load(ios);
			String a = (String) result.get("Starting range");
		     System.out.println(result.toString());
		     Collection<Object> file = result.values();
		     System.out.println(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		verifySumationOfOddNumbers();
		
	}*/
	public static void main(String[] args) throws FileNotFoundException {
		// Create a stream to hold the output
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    PrintStream old = System.out;
	    // Tell Java to use your special stream
	    System.out.println("Foofoofoo!Shibu");
	    System.setOut(ps);
	    // Print some output: goes to your special stream
	    System.out.println("Foofoofoo!Shibu");
	    // Put things back
	    System.out.flush();
	    System.setOut(old);
	    // Show what happened
	    System.out.println("Here: " + baos.toString());

	    } 
}
