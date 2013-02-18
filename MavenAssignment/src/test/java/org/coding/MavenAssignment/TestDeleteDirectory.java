package org.coding.MavenAssignment;

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
public class TestDeleteDirectory {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() {
		File folder = new File("/home/arja/Desktop/test2");
		File textFileA = new File(folder, "A.txt");
		File textFileB = new File(folder, "B.txt");
		File textFileC = new File(folder, "C.txt");
		File childFolder = new File(folder, "childFolder");
		File childTextFileD = new File(childFolder, "D.txt");
		File childTextFileE = new File(childFolder, "E.txt");
		assertTrue(childTextFileE.delete());
		assertTrue(childTextFileD.delete());
		assertTrue(childFolder.delete());

		assertTrue(textFileC.delete());
		assertTrue(textFileB.delete());
		assertTrue(textFileA.delete());

		assertTrue(folder.delete());
	}

}
