package JUnit;

import static org.junit.Assert.*;

import java.io.File;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test case for creating a test directory
 * 
 * Enter path below
 * 
 * @author Siddhartha Pattni
 * 
 */
public class CreateTestDirectory {
	File file = new File("/home.....");

	@Before
	public void setUp() throws Exception {

		if (file.mkdir()) {
			System.out.println("Created directory");
			if (file.createNewFile()) {
				System.out.println("Created file");
				if (file.mkdirs()) {
					System.out.println("Created directory");
					if (file.createNewFile()) {
						System.out.println("Created file");
					}
				}
			} else
				System.out.println("no file created");
		} else
			System.out.println("No directory created");
		if (file.mkdirs()) {
			System.out.println("Created directory");
			if (file.createNewFile()) {
				System.out.println("Created file");
				if (file.mkdirs()) {
					System.out.println("Created directory");
					if (file.createNewFile()) {
						System.out.println("Created file");
					}
				}
			} else
				System.out.println("no file created");
		} else
			System.out.println("No directory created");

	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
