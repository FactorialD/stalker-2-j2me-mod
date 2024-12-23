import java.io.IOException;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;

public class Stars extends MIDlet implements CommandListener {
	public int leftSoftKeyCode = -6;
	public int rightSoftKeyCode = -7;
	public static boolean var_b9 = true;
	public static Stars thisStars = null;
	private GameScreen gameScreen = null;
	public Form var_14a = null;
	private Command var_17d = new Command("Back", 2, 0);
	private Command var_196 = new Command("Back", 2, 0);
	private Command var_1b7 = new Command("Ok", 8, 1);
	private List var_209 = null;
	public String[] helpMenuNamesArr = new String[] { "Введение в игру", "Начало игры", "Лагеря", "Армия", "Создание лагерей",
			"Проектирование бойцов", "Налоги и мораль", "Научные исследования", "Разработчики игры" };

	public Stars() {
		thisStars = this;
		this.setSoftKeyCodes();
	}

	public void setSoftKeyCodes() {
		switch (0) { // so, sofkeys works not on all phones...
		case 0: // most phones soft keys
			this.leftSoftKeyCode = -6; //Left soft key
			this.rightSoftKeyCode = -7; //Right soft key
			break;
		case 1: // Motorola Razr, V550, E1000, ... Panasonic VS3
			this.leftSoftKeyCode = -21; //Left soft key
			this.rightSoftKeyCode = -22; //Right soft key
			break;
		case 2: // Siemens Devices
			this.leftSoftKeyCode = -1; //Left soft key
			this.rightSoftKeyCode = -4;  //Right soft key
		}

	}

	public void startApp() {
		if (this.gameScreen == null) {
			this.gameScreen = new GameScreen(false);
			this.gameScreen.setFullScreenMode(true);
			this.gameScreen.setCommandListener(this);
			this.gameScreen.sub_269();
			Display.getDisplay(this).setCurrent(this.gameScreen);
		} else {
			this.gameScreen.var_e = false;
			if (this.gameScreen.musicManager != null) {
				//here set music playing after resume app
				this.gameScreen.musicManager.changeMusicId(4);
			}
		}

	}

	public void destroyApp(boolean var1) {
		Display.getDisplay(this).setCurrent((Displayable) null);
		if (this.gameScreen != null) {
			if (this.gameScreen.var_d5) {
				this.gameScreen.sub_1cbe();
			}

			this.gameScreen.sub_274();
		}

		this.notifyDestroyed();
	}

	public void pauseApp() {
		if (this.gameScreen != null) {
			this.gameScreen.sub_1cbe();
			if (this.gameScreen.musicManager != null) {
				this.gameScreen.musicManager.sub_59();
			}
		}

	}

	public void sub_5f() {
		if (this.gameScreen != null && this.gameScreen.musicManager != null) {
			this.gameScreen.musicManager.sub_19();
			this.gameScreen.musicManager = null;
		}

		this.destroyApp(false);
		this.notifyDestroyed();
	}

	public void commandAction(Command var1, Displayable var2) {
		if (var1 == this.var_17d) {
			Display.getDisplay(this).setCurrent(this.gameScreen);
			this.var_209 = null;
		} else if (var1 != this.var_1b7 && var1 != List.SELECT_COMMAND) {
			if (var1 == this.var_196) {
				Display.getDisplay(this).setCurrent(this.var_209);
				this.var_14a = null;
			}

		} else {
			this.sub_ba(this.var_209.getSelectedIndex());
		}
	}

	public void sub_7d() {
		if (this.var_209 == null) {
			this.var_209 = new List(SomeUtilClass.getStr("ПОМОЩЬ"), 3, this.helpMenuNamesArr, (Image[]) null);
			this.var_209.addCommand(this.var_17d);
			this.var_209.setCommandListener(this);
			Display.getDisplay(this).setCurrent(this.var_209);
		}
	}

	public void sub_ba(int var1) {
		String var2 = SomeUtilClass.loadDictionaryFile(GameScreen.gameScreen, "mainhelp");
		String var3 = "";
		String var4 = "";

		for (int var5 = 0; var5 < 10; ++var5) {
			var4 = SomeUtilClass.sub_106(var2, var1 + "" + var5);
			if (var4 == "") {
				break;
			}

			var3 = var3 + var4 + '\n';
		}

		if (var3 != "") {
			this.var_14a = new Form(this.helpMenuNamesArr[var1]);
			this.var_14a.append(var3);
			this.var_14a.addCommand(this.var_196);
			this.var_14a.setCommandListener(this);
			Display.getDisplay(this).setCurrent(this.var_14a);
		}
	}

	public void sub_111(int var1) {
		Display.getDisplay(this).vibrate(var1);
	}
}
