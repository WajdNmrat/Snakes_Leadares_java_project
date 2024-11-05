package Controller;

import Model.Screen;

public class ScreenController {
	
	public static Screen screen;

	public static void setScreenSize(int width, int height) {
		screen = new Screen();
		screen.setWidth(width);
		screen.setHeight(height);
	}
	
	public static int getScreenWidth() {
		return screen.getWidth();
	}
	
	public static int getScreenHeight() {
		return screen.getHeight();
	}
}
