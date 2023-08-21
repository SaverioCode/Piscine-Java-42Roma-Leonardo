
import	java.nio.file.Files;
import	java.nio.file.Paths;
import	java.nio.file.Path;
// import	java.util.stream;

public class	Commands {
	private	static Commands	instance;
	private static Path		directory;

	private Commands(Path path) {
		this.directory = path;
	}

	public static Commands getInstance(Path path) {
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
			// if (input[0].equals("ls") == true) {
			// 	executeLs();
			// 	return ;
			// }
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

	// private void	executeLs() {
	// 	Stream<Path>	list;
	// 	String			str;

	// 	list = Files.list(this.directory);
	// 	for (Path result: list) {
	// 		str = result.toString();
	// 		System.out.println(str);
	// 	}
	// 	System.out.println();
	// }

	private static void	executeExit() {
		System.exit(0);
	}

	// public static void	executeMv(String[] input) {

	// }

	public void	executeCd(String pathStr) {
		Path	path;

		path = Paths.get(pathStr);
		if (Files.isDirectory(path) == false) {
			System.err.println("Error: path not found.");
			return ;
		}
		// Files.setWorkingDirectory(path);
		this.directory = path;
	}
}
