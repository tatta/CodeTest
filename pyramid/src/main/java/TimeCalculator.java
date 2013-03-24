import java.util.Scanner;

public class TimeCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[][] pyramid;
		readFromKeyboard();
		pyramid = waterLevelCalculator();
		printMatrix(pyramid);
		pyramid = nodeTimeCalcualtor(pyramid);
		printMatrix(pyramid);

		long antalSekunder = 0;

		// antalSekunder = getTotalTime from timePyramid[rad][glass];

		System.out.println("Det tar " + antalSekunder + " sekunder.");

	}

	/**
	 * Calculates the time for each glass, this time is depending on what the
	 * water level that each glass receives.
	 * 
	 * @param pyramid
	 *            In parameter is the matrix that contains the water level.
	 * 
	 * @return a matrix that contains the time for each wine glass. This matrix
	 *         is then used when calculating the total time.
	 */
	public static double[][] nodeTimeCalcualtor(double[][] pyramid) {
		int counter = 1;
		double prevTime = 0;
		double[][] timePyramid = new double[50][50];
		System.out.println("Antal sekunder per nod");
		System.out.println();

		for (int i = 0; i < 49; i++) {
			for (int j = 0; j < counter; j++) {
				prevTime = 10 / pyramid[i][j];
				timePyramid[i][j] = prevTime;
			}
			counter++;
		}
		return timePyramid;
	}

	/**
	 * Generic method for printing the matrix
	 * 
	 * the matrix pyramid can contain the level of water that each glass or time
	 * it takes to fill each wine glass.
	 * 
	 * @param pyramid
	 */
	public static void printMatrix(double[][] pyramid) {
		int counter = 1;

		for (int i = 0; i < 49; i++) {
			for (int j = 0; j < counter; j++) {
				System.out.print(pyramid[i][j] + " ");
			}
			System.out.println();
			counter++;
		}

	}

	/**
	 * Calculates the water lever for each wine glass.
	 * 
	 * pyramid[][] matrix contains the level of water for every wine glass. The
	 * first glass gets 1 unit, second gets 1/2, third gets 1/2...1/2*X
	 * 
	 */
	public static double[][] waterLevelCalculator() {
		double[][] pyramid = new double[50][50];
		double number = 1;
		pyramid[0][0] = number;
		double temp = 0;
		int counter = 1;

		// Divides [0][0] with two and adds to left and right child for every
		// node.
		for (int i = 0; i < 49; i++) {
			for (int j = 0; j < counter; j++) {
				temp = pyramid[i][j] / 2;
				pyramid[i + 1][j] += temp;
				pyramid[i + 1][j + 1] += temp;
			}
			counter++;
		}

		return pyramid;

	}

	/**
	 * Reads from the keyboard.
	 * 
	 * Creates a scanner that reads from keyboard. User asks for the time it
	 * takes for a specific glass on a row to start dripping.
	 */
	public static void readFromKeyboard() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Rad ?");
		int rad = scan.nextInt();
		System.out.println("Glas ?");
		int glass = scan.nextInt();
	}
}
