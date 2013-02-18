package org.coding.MavenAssignment;

import static org.junit.Assert.*;

import java.io.File;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * JUnit test case for verifying that the LS functionality works.
 * 
 * Enter path below
 * 
 * @author Siddhartha Pattni
 * 
 */
public class TestLSFunctionality extends TestCase {
	String[] args;
	Controller controller;
	Model model;
	View view;
	File[] expected, actual;

	@Before
	public void setUp() throws Exception {
		args = new String[3];
		args[0] = "/home/arja/Desktop/test2";
		args[1] = "ls";
		model = new Model(new File("/home/arja/Desktop/test2"));
		view = new View();

		actual = model.getListFiles();
		model.getAlphabeticalSortedList(actual);

		expected = new File[4];
		expected[0] = new File("/home/arja/Desktop/test2/A.txt");
		expected[1] = new File("/home/arja/Desktop/test2/B.txt");
		expected[2] = new File("/home/arja/Desktop/test2/C.txt");
		expected[3] = new File("/home/arja/Desktop/test2/childFolder");

		System.out.println(actual[0] + " " + expected[0]);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertArrayEquals(expected, actual);
	}

}
