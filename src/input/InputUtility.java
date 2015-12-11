package input;

public class InputUtility {
	private static int mouseX,mouseY;
	private static boolean[] clickOnTurret = new boolean[7];
	private static boolean mouseLeftDown,mouseRightDown;
	private static boolean alreadyClick;
	private static boolean mouseLeftTriggered,mouseRightTriggered;
	private static boolean[] keyPressed = new boolean[256];
	private static boolean[] keyTriggered = new boolean[256];
	
	public static int getMouseX() {
		return mouseX; 
	}
	public static void setMouseX(int mouseX) {
		InputUtility.mouseX = mouseX;
	}
	public static int getMouseY() {
		return mouseY;
	}
	public static void setMouseY(int mouseY) {
		InputUtility.mouseY = mouseY;
	}
	public static boolean getClickOnTurret(int i) {
		return clickOnTurret[i];
	}
	public static void setClickOnTurret(boolean clickOnTurret,int i) {
		InputUtility.clickOnTurret[i] = clickOnTurret;
	}
	public static boolean isMouseLeftDown() {
		return mouseLeftDown;
	}
	public static void setMouseLeftDown(boolean mouseLeftDown) {
		InputUtility.mouseLeftDown = mouseLeftDown;
	}
	public static boolean isMouseRightDown() {
		return mouseRightDown;
	}
	public static void setMouseRightDown(boolean mouseRightDown) {
		InputUtility.mouseRightDown = mouseRightDown;
	}
	public static boolean isMouseLeftTriggered() {
		return mouseLeftTriggered;
	}
	public static void setMouseLeftTriggered(boolean mouseLeftTriggered) {
		InputUtility.mouseLeftTriggered = mouseLeftTriggered;
	}
	public static boolean isMouseRightTriggered() {
		return mouseRightTriggered;
	}
	public static void setMouseRightTriggered(boolean mouseRightTriggered) {
		InputUtility.mouseRightTriggered = mouseRightTriggered;
	}
	public static boolean isAlreadyClick() {
		return alreadyClick;
	}
	public static void setAlreadyClick(boolean alreadyClick) {
		InputUtility.alreadyClick = alreadyClick;
	}
	
	
}
