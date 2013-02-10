package assignment;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Model class in MVC pattern
 * 
 * Receives a File from the Launcher class for the chosen path.
 * 
 * Returns arrays of abstract pathnames denoting files in the directory.
 * 
 * 
 * @author Siddhartha Pattni
 * 
 */
public class Model {
	private File file;

	public Model(File file) {
		this.file = file;
	}

	public File[] getTimestampSortedList(File[] list) {
		Arrays.sort(list, new Comparator<File>() {
			public int compare(File f1, File f2) {
				return Long.valueOf(f1.lastModified()).compareTo(
						f2.lastModified());
			}
		});
		return list;
	}

	public String[] getList() {
		return file.list();
	}

	public File[] getListFiles() {
		return file.listFiles();
	}

	public File[] getAlphabeticalSortedList(File[] list) {
		Arrays.sort(list);
		return list;
	}

	public File getFile() {
		return file;
	}
}
