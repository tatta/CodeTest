package JUnit;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * JUnit test case for creating deleting the test directory
 * 
 * Enter path below
 * 
 * @author Siddhartha Pattni
 *
 */
public class DeleteTestDirectory {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		File file = new File("/home.......");		
		if(file.delete())		
			System.out.println("Deleted file");
		else
			System.out.println("No file deleted");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
