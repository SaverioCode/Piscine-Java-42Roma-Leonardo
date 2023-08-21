
import	java.io.File;

public class	Commands {
	private	static Commands	instance;
	private static File		directory;

	private Commands(File path) {
		this.directory = path;
	}
	
	public static Commands getInstance(File path) {
		if (instance == null) {
			instance = new Commands(path);
		}
		return (instance);
	}

	public void	execute(String[] input) {
		if (input == null) {
			return ;
		}
		if (input.length == 1) {
			if (input[0].equals("ls") == true) {
				executeLs();
				return ;
			}
			if (input[0].equals("exit") == true) {
				executeExit();
			}
		}
		else if (input[0].equals("cd") == true && input.length == 2) {
			executeCd(input[1]);
			return ;
		}
		// else if (input[0].equals("mv") == true && input.length == 3) {
		// 	executeMv();
		// 	return ;
		// }
		System.err.println("Error: command not found.");
	}

	private void	executeLs() {
		String[]		list;

		list = this.directory.list(null);
		for (String str: list) {
			System.out.println(str);
		}
	}

	private static void	executeExit() {
		System.exit(0);
	}

	// public static void	executeMv(String[] input) {

	// }

	public void	executeCd(String pathStr) {
		File	path;

		path = new File(pathStr);
		if (path.isDirectory() == false) {
			System.err.println("Error: path not found.");
			return ;
		}
		System.setProperty("user.dir", pathStr);
		this.directory = path;
	}
}
