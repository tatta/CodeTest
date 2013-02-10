package assignment;

import java.io.File;

/**
 * View class in MVC pattern
 * 
 * Handles all the printing to the user Prints what the Controller class sends
 * to it
 * 
 * 
 * @author Siddhartha Pattni
 * 
 */
public class View {

	public void printList(String[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

	public void printList(File[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].getName() + " ");
		}
	}

	public void printLine(String line) {
		System.out.println(line);

	}
}
