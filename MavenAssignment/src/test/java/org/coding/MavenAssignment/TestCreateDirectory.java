package org.coding.MavenAssignment;

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
public class TestCreateDirectory {
	File folder = new File("/home/arja/Desktop/test2");
	File textFileA = new File(folder, "A.txt");
	File textFileB = new File(folder, "B.txt");
	File textFileC = new File(folder, "C.txt");
	File childFolder = new File(folder, "childFolder");
	File childTextFileD = new File(childFolder, "D.txt");
	File childTextFileE = new File(childFolder, "E.txt");

	@Before
	public void setUp() throws Exception {

		if (folder.mkdir()) {
			System.out.println("Created directory");
			textFileA.createNewFile();
			textFileB.createNewFile();
			textFileC.createNewFile();

			childFolder.mkdir();
			childTextFileD.createNewFile();
			childTextFileE.createNewFile();

			textFileA.setReadOnly();
			textFileB.setExecutable(false);
			textFileC.setWritable(false);

		}
	}

	@Test
	public void test() {
		assertTrue(folder.exists());
		assertTrue(textFileA.exists());
		assertTrue(textFileB.exists());
		assertTrue(textFileC.exists());

		assertTrue(folder.isDirectory());
		assertTrue(textFileA.isFile());

		assertTrue(textFileA.exists());
		assertTrue(textFileB.exists());
		assertTrue(textFileC.exists());

		assertTrue(childFolder.isDirectory());
		assertTrue(childTextFileD.isFile());
		assertTrue(childTextFileE.isFile());

		assertTrue(textFileA.canRead());
		assertFalse(textFileA.canWrite());
		assertFalse(textFileA.canExecute());

		assertTrue(textFileB.canRead());
		assertTrue(textFileB.canWrite());
		assertFalse(textFileB.canExecute());

		assertTrue(textFileC.canRead());
		assertFalse(textFileC.canWrite());
		assertFalse(textFileC.canExecute());
	}

}
