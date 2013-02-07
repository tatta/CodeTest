import java.io.File;

/**
 * Launcher contains the main() method. Creates a File with the entered path.
 * Creates a model and view object which it sends to the Controller constructor.
 * 
 * @author Siddhartha Pattni
 * 
 */
public class Launcher {

	/**
	 * @param args
	 *            arg[0] - path arg[1] - command in this case "ls" where "ls"
	 *            means list directory contents args[2] is which flag the user
	 *            enters
	 * 
	 *            -l is for detailed list, time stamp and permissions -c is sort
	 *            by time of last modification -r recursively listing
	 *            subdirectories for the chosen path
	 */
	public static void main(String[] args) {
		File file = null;
		try {
			file = new File(args[0]);
		} catch (NullPointerException e) {
			System.err.println("Pathname argument is null");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Please enter folder path");
		}

		Model model = new Model(file);
		View view = new View();
		new Controller(args, model, view);
	}

}
