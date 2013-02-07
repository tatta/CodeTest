import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * Controller class in MVC pattern
 * 
 * Calls functions depending on what the user enters. Checks the permissions for
 * files and folders.
 * 
 * @author Siddhartha Pattni
 * 
 */
public class Controller {
	private Model model;
	private View view;
	private ArrayList<File> recursiveNames = new ArrayList<File>();
	private ArgumentInterpreter interpreter;

	public Controller(String[] args, Model model, View view) {
		this.model = model;
		this.view = view;
		interpreter = new ArgumentInterpreter(args);
		keyboardParser();
	}

	public void keyboardParser() {
		if (interpreter.readCommand()) {
			switch (interpreter.readFlag()) {
			case ArgumentInterpreter.LS:
				File[] list = model.getListFiles();
				File[] sortedList = model.getSortedList(list);
				view.printList(sortedList);
				break;
			case ArgumentInterpreter.LS_L:
				view.printList((createDetailedList(model.getListFiles())));
				break;
			case ArgumentInterpreter.LS_C:
				view.printList(model.getSortedList(model.getListFiles()));
				break;
			case ArgumentInterpreter.LS_R:
				view.printList(model.getSortedList(getAllFilesRecursiv()));
				break;
			case ArgumentInterpreter.LS_LC:
				view.printList(createDetailedList(model.getSortedList(model
						.getListFiles())));
				break;
			case ArgumentInterpreter.LS_RC:
				view.printList(model.getSortedList(getAllFilesRecursiv()));
				break;
			case ArgumentInterpreter.LS_LR:
				view.printList(createDetailedList(getAllFilesRecursiv()));
				break;
			case ArgumentInterpreter.LS_LCR:
				view.printList(createDetailedList(model
						.getSortedList(getAllFilesRecursiv())));
				break;
			}
		}

	}

	/**
	 * r if reading is permitted -r if not.
	 * 
	 * Order is r: readable w: writable x: executable
	 */
	public File[] createDetailedList(File[] folderList) {
		File[] temp = new File[folderList.length];
		String permissions = "";
		for (int i = 0; i < folderList.length; i++) {
			if (folderList[i].canRead())
				permissions += "r";
			else
				permissions += "-r";
			if (folderList[i].canWrite())
				permissions += "w";
			else
				permissions += "-w";
			if (folderList[i].canExecute())
				permissions += "x";
			else
				permissions += "-x";
			String date = longToDateString(folderList[i].lastModified());
			temp[i] = new File(permissions + "\t" + date + "\t"
					+ folderList[i].getName());
			permissions = "";
		}
		return temp;
	}

	private String longToDateString(long millis) {
		Date date = new Date(millis);
		return date.toString();

	}

	public File[] getAllFilesRecursiv() {
		recursion(model.getFile());
		File[] temp = new File[model.getListFiles().length];
		for (int i = 0; i < recursiveNames.size(); i++) {
			temp[i] = recursiveNames.get(i);
		}

		return temp;
	}

	private void recursion(File file) {
		File[] list = file.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory())
				recursion(list[i]);
			else
				recursiveNames.add(list[i]);
		}
	}

}
