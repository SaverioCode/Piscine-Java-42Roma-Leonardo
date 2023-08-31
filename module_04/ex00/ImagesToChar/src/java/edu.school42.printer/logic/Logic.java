
package edu.school42.printer.logic;

import	java.awt.image.BufferedImage;
import	java.awt.Color;
import	javax.imageio.ImageIO;
import	java.io.FileInputStream;
import	java.io.IOException;

public class	Logic {
	public static Logic				instance;
	private static int				whiteChar, blackChar;
	private static int				width, height;
	private static BufferedImage	image;
	private static int[][]			picture;

	private Logic(String path, int newWhiteChar, int newBlackChar) throws IOException {
		image = ImageIO.read(new FileInputStream(path));
		whiteChar = newWhiteChar;
		blackChar = newBlackChar;
	}

	public static Logic	getInstance(String path, int newWhiteCahr, int newBlackChar) throws IOException {
		if (instance == null) {
			instance = new Logic(path, newWhiteCahr, newBlackChar);
		}
		return (instance);
	}

	public static void	createPicture() {
		int		black, white;
		int		pixelColor, pixel = 0;

		black = Color.black.getRGB();
		white = Color.white.getRGB();
		width = image.getWidth();
		height = image.getHeight();
		picture = new int[width][height];
	
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				pixelColor = image.getRGB(x, y);
				if (pixelColor == black) {
					pixel = blackChar;
				}
				else if (pixelColor == white) {
					pixel = whiteChar;
				}
				else {
					System.err.println("Error: picture has to be black and white only.");
					System.exit(1);
				}
				picture[x][y] = pixel;
			}
		}
	}

	public static void	printPicture() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				System.out.print(picture[x][y]);
			}
		}
	}
}
