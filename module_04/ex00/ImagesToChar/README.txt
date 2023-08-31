
In order to compile correctly run the command below:
	javac -d target -s ImagesToChar/src
	src/*/*/*/*.java

After run the code with:
	java App --whiteToChar=<CHARACTER> --blackToChar=<CHARACTER>

eg.
	javac -d target -s ImagestoChar/src
	java App --whiteToChar=. --blackToChar=0 --path=<PATH_TO_FILE>

Int this example after proprely compiling the program is going to be executed
converting the white pixel of an images to "." and the black one to "0"
