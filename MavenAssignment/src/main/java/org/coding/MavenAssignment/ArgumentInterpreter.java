package org.coding.MavenAssignment;

/**
 * Interprets what the user enters and reports that to Controller class using
 * the static final int's below.
 * 
 * E.g LS represents the user entering "ls". where "ls" means list directory
 * contents.
 * 
 * @author Siddhartha Pattni
 * 
 */
public class ArgumentInterpreter {
	static final int LS = 1;
	static final int LS_L = 2;
	static final int LS_C = 3;
	static final int LS_R = 4;
	static final int LS_LC = 5;
	static final int LS_RC = 6;
	static final int LS_LR = 7;
	static final int LS_LCR = 8;

	private String[] args;

	public ArgumentInterpreter(String[] args) {
		this.args = args;
	}

	public boolean readCommand() {
		String command = "";
		if (args.length > 0) {
			try {
				command = args[1];
				if (command.length() == 2) {
					if (command.charAt(0) == 'l' && command.charAt(1) == 's') {
						return true;
					} else {
						System.err.println("Please enter command ls");
						return false;
					}

				} else {
					System.err.println("Please enter command");
					return false;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("Please enter command");
			}

		}
		return false;
	}

	public int readFlag() {
		if (args.length <= 2) {
			return LS;
		} else {
			String flag = "";
			try {
				flag = args[2];
				return dashChecker(flag);
			} catch (StringIndexOutOfBoundsException e) {
				System.err.println("command not found");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println(e);
			}
		}
		return 0;
	}

	private int dashChecker(String flag) {
		if (flag.startsWith("-")) {
			if (flag.length() > 2) {
				return flagCheck(flag.toCharArray());
			} else {
				if (flag.charAt(1) == 'l')
					return LS_L;
				else if (flag.charAt(1) == 'c')
					return LS_C;
				else if (flag.charAt(1) == 'r')
					return LS_R;
			}
		} else
			System.err.println("Flag must start with [-flag]");
		return 0;
	}

	private int flagCheck(char[] enteredFlags) {
		if (enteredFlags[1] == 'l') {
			if (enteredFlags[2] == 'c' && enteredFlags[3] == 'r') {
				System.out.println("here");
				return LS_LCR;
			} else if (enteredFlags[2] == 'c') {
				return LS_LC;
			} else if (enteredFlags[2] == 'r') {
				return LS_LR;
			}
			return LS_L;
		} else if (enteredFlags[1] == 'r') {
			if (enteredFlags[2] == 'c') {
				return LS_RC;
			}
			return LS_R;
		} else if (enteredFlags[1] == 'c') {
			return LS_C;
		}
		System.err.println("must enter either -l, -c, -r");
		return 0;
	}
}
