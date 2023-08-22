
import	java.io.File;
import	java.nio.file.Files;
import	java.nio.file.Path;
import	java.nio.file.Paths;
import	java.io.IOException;

public class	Commands extends IOException {
	private	static Commands	instance;
	private static File		directory;

	private Commands(String path) {
		executeCd(path);
	}
	
	public static Commands getInstance(String path) {
		if (instance == null) {
			instance = new Commands(path);
		}
		return (instance);
	}

	public void	execute(String[] input) throws IOException {
		if (input == null) {
			return ;
		}
		if (input[0].equals("ls") == true) {
			if (input.length != 1) {
				System.err.println("Error: \"ls\" has to be without arguments.");
				return ;
			}
			executeLs();
		}
		else if (input[0].equals("exit") == true) {
			if (input.length != 1) {
				System.err.println("Error: \"exit\" has to be without arguments.");
				return ;
			}
			executeExit();
		}
		else if (input[0].equals("cd") == true) {
			if (input.length != 2) {
				System.err.println("Error: cd <FOLDER_NAME>.");
				return ;
			}
			executeCd(input[1]);
		}
		else if (input[0].equals("mv") == true) {
			if (input.length != 3) {
				System.err.println("Error: mv <WHAT> <WHERE>.");
				return ;
			}
			executeMv(input);
		}
		else {
			System.err.println("Error: command not found.");
		}
	}

	private void	executeLs() {
		String[]	list;
		File		file;
		long		size;

		list = this.directory.list(null);
		for (String str: list) {
			file = new File(str);
			if (file.isHidden() == true) {
				continue ;
			}
			size = file.length() / 1024;
			System.out.println(str + " " + size + " KB");
		}
	}

	private static void	executeExit() {
		System.exit(0);
	}

	private static void	executeMv(String[] input) throws IOException {
		Path	whatPath, wherePath;
		File	whatFile, whereFile;
		String	whatPathStr, wherePathStr;

		
		whatFile = new File(input[1]);
		if ((whatPathStr = whatFile.getAbsolutePath()) == null) {
			System.err.printf("Error: %s is not a valid file.\n", input[1]);
			return ;
		}
		whatPath = Paths.get(input[1]);
		whereFile = new File(input[2]);
		if ((wherePathStr = whereFile.getAbsolutePath()) != null) {
			wherePath = Paths.get(wherePathStr);
		}
		else {
			wherePath = Paths.get(input[2]);
		}
		Files.move(whatPath, wherePath);
	}

	public void	executeCd(String pathStr) {
		File	path;

		if (this.directory != null && pathStr.charAt(0) != '/') {
			pathStr = this.directory.toString() + "/" + pathStr;
		}
		path = new File(pathStr);
		if (path.isDirectory() == false) {
			System.err.println("Error: path not found.");
			return ;
		}
		this.directory = new File(pathStr);
		System.setProperty("user.dir", pathStr);
	}
}
