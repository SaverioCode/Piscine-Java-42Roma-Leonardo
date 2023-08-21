
import	java.io.File;
import	java.nio.file.Files;
import	java.nio.file.Path;
import	java.nio.file.Paths;

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

	private static void	executeMv(String[] input) {
		Path	whatPath, wherePath;
		File	whatFile, whereFile;

		
		whatFile = new File(input[1]);
		if (where.isAbsolute() == false && where.isFile() == false) {
			if (where.getAbsolutePath() == null) {
				System.err.println("Error: invalid file name.")
			}
		}
		
		where = new File(input[2]);
		if (where.isAbsolute() == true) {

			Files.move()
		}
		// if (where.exists() == true) {
			System.out.println(where.getAbsolutePath());
		// }
	}

	public void	executeCd(String pathStr) {
		File	path;
		Path	absolutePath;

		path = new File(pathStr);
		if (path.isDirectory() == true) {
			
		}
		else if ((absolutePath = Paths.get(this.directory.toString(), pathStr)) != null) {
			pathStr = absolutePath.toString();
			path = new File(pathStr);
		}
		else {
			System.err.println("Error: path not found.");
			return ;
		}
		this.directory = new File(pathStr);
		System.setProperty("user.dir", pathStr);
	}
}
