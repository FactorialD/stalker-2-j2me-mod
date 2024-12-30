import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.rms.RecordComparator;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordFilter;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class GameScreen extends GameCanvas implements Runnable {
	public boolean var_e = false;
	public boolean var_4b = true;
	public static boolean var_73 = false;
	public boolean var_90 = false;
	public long var_9e = 0L;
	public boolean var_d5 = false;
	public boolean var_138 = false;
	public boolean var_188 = false;
	public boolean var_1a6 = false;
	public int var_1d1 = 40;
	public boolean var_232;
	public static GameScreen gameScreen = null;
	public GameActionState gameActionState = new GameActionState(this);
	public int var_31a;
	// location images
	public Image[] locationsImgArr = new Image[9];
	// Game map image
	public Image mapImg = null;
	// Location background image
	public Image locationBgImg = null;

	public Image[] ugolImgArr = new Image[4];
	public Image rMiniFrontImg = null;
	public Image rMiniFront2Img = null;
	public Image rBigFrontImg = null;
	public Image formTopImg = null;
	public Image formRightImg = null;
	public Image buttonImg = null;
	public Image button2Img = null;
	public Image xpImg = null;
	public Image np2Img = null;
	public Image fsImg = null;
	public Image formZakImg = null;
	public Image selShipImg = null;
	public Image[] shipImgArr = new Image[6];
	public Image topPanelLImg = null;
	public Image topPanelRImg = null;
	public Image topPanelMIng = null;
	public int var_6f1 = 60;
	public int var_728 = 0;
	public int var_73d = 0;
	public int var_794 = 0;
	public int var_7d3 = 0;
	public int var_869 = 0;
	public int var_881 = 0;
	public int var_8e4 = 0;
	public int var_918 = 0;
	public int var_970 = 0;
	public int var_99e = 0;
	public Class_4b3 var_9b3 = null;
	public GameRect gameRect;
	public int xMapBias;
	public int yMapBias;
	public int someXCellPos;
	public int someYCellPos;
	public int someXCellPos2 = 0;
	public int someYCellPos2 = 0;
	public int var_b3a;
	public int var_b4d;
	public int var_b9b;
	public Vector planetsArr = null;
	public String[] locationNamesArr = new String[36];
	public int[] var_bfd = new int[60];
	public int var_c5c = 0;
	public int var_caa = 0;
	public int var_d05;
	public SomeThreadPainterClass var_d0f = null;
	public Vector var_d39 = null;
	public Class_2a9 var_d5c;
	public boolean var_d8f;
	public Vector var_da5 = null;
	public Vector var_dc6 = null;
	public Class_2ee var_e29 = null;
	public int var_e3d = 0;
	public int var_e9e = 0;
	public int gameCurrentMonth;
	public int gameCurrentYear;
	public Random random;
	public boolean var_f42 = true;
	public int var_f80 = 0;
	public boolean var_fa3 = false;
	public Upgrade[] buildingDictArr = new Upgrade[31]; // словарь построек
	public Class_4b[] var_fc9 = new Class_4b[64];
	public Class_35d var_1029 = null;
	public StalkerStatDto[] rangItemsArr = new StalkerStatDto[6];
	public StalkerStatDto[] staminaItemsArr = new StalkerStatDto[5];
	public StalkerStatDto[] costumeItemsArr = new StalkerStatDto[6];
	public StalkerStatDto[] attackSpeedItemsArr = new StalkerStatDto[5];
	public StalkerStatDto[] weaponItemsArr = new StalkerStatDto[14];
	public byte[] var_1185 = new byte[14];
	public int[] var_11cd = new int[14];
	public Upgrade[] passiveUpgradesDictArr = new Upgrade[9]; // словарь пассивных улучшений
	public Upgrade[] artifactsDictArr = new Upgrade[10];// словарь артефактов
	public boolean var_12a6 = false;
	public Planet var_12b8 = null;
	public String var_12f1 = "0";
	public int var_134a = 0;
	public String var_138d = "0";
	public int var_13ae = 0;
	public int var_13cb = 0;
	public Image[] var_1421 = new Image[2];
	public SomeBattleClass var_143d = null;
	public boolean var_1490 = false;
	public boolean var_14c8 = false;
	public static Image lampImg = null;
	public boolean var_153f = false;
	public int var_1591;
	public int var_15c2;
	public boolean[][] var_15fe = (boolean[][]) null;
	public StalkerStatDto[] var_164f = new StalkerStatDto[10];
	public boolean var_169a = true;
	public boolean var_16d3 = true;
	public boolean var_1730 = false;
	public boolean var_173f = false;
	public int var_1759 = 0;
	public int var_17a7 = 40;
	public String var_1807 = "";
	public Class_2a9 var_1819 = null;
	public int var_186d = 3;
	public int var_1899 = 1;
	public Image[] groupSidesImgArr = new Image[6];
	public int var_190d = 1;
	public String var_1965 = "";
	public Class_4b3 var_19ae = null;
	public int var_19fd = 0;
	public Vector var_1a2b = null;
	public Image gameLogoMainImg = null;
	public Image gameLogoSecondary = null;
	public Image devLogoImg = null;
	public IntroPainter introPainter = null;
	public MusicManager musicManager = null;
	public Image var_1b9d = null;
	public Image var_1bd6 = null;
	public boolean var_1c2f = false;
	public boolean var_1c3c = true;
	public long var_1c79 = 0L;
	public String otherSymbolsStr = "0123456789$+-.,:=()?%";
	public int var_1d2e = -1;
	public int var_1d90 = 0;

	public int gameBackgroundColor = 6444859; // color of space at background

	public GameScreen(boolean var1) {
		super(var1);
		this.gameActionState.clearAllStates();
		gameScreen = this;
		this.var_d8f = false;

		int var2;
		try {
			this.formTopImg = Image.createImage("/images/form_top.png");
			this.formRightImg = Image.createImage("/images/form_right.png");
			this.rBigFrontImg = Image.createImage("/images/rbigfont.png");
			this.rMiniFrontImg = Image.createImage("/images/rminifont.png");
			this.rMiniFront2Img = Image.createImage("/images/rminifont2.png");

			for (var2 = 0; var2 < this.groupSidesImgArr.length; ++var2) {
				this.groupSidesImgArr[var2] = Image.createImage("/images/p" + var2 + ".png");
			}
		} catch (IOException var3) {
			System.out.println("Could not find the bitmap");
		}

		this.gameRect = new GameRect();
		this.var_b3a = 0;
		this.var_1a6 = false;
		this.var_b4d = 0;
		this.random = new Random();
		this.sub_1a3();
		this.sub_462(0);
		this.sub_462(1);
		this.var_90 = this.sub_1cae();
		this.gcAndSleep();

		for (var2 = 0; var2 < this.var_164f.length; ++var2) {
			this.var_164f[var2] = new StalkerStatDto();
			this.var_164f[var2].someStr = "";
			this.var_164f[var2].price = 0;
		}

		this.sub_14();
		this.sub_1bfe();
		if (this.var_169a) {
			this.musicManager = new MusicManager();
			this.musicManager.start();
		}

		this.introPainter = new IntroPainter();
	}

	public void hideNotify() {
		this.var_e = true;
		if (this.musicManager != null) {
			this.musicManager.sub_59();
		}

	}

	public void showNotify() {
		this.var_e = false;
		if (this.musicManager != null) {
			this.musicManager.changeMusicId(4);
		}

	}

	public void sub_14() {
		this.var_1a2b = new Vector();

		for (int var1 = 0; var1 < 6; ++var1) {
			try {
				InputStream var2 = this.getClass().getResourceAsStream("/images/ship" + var1 + ".msk");
				if (var2 == null) {
					return;
				}

				DataInputStream var3 = new DataInputStream(var2);
				byte var4 = var3.readByte();
				int[] var5 = new int[var4];

				for (int var6 = 0; var6 < var4; ++var6) {
					var5[var6] = var3.readByte();
					var5[var6] |= var3.readByte() << 8;
					var5[var6] |= var3.readByte() << 16;
					var5[var6] |= var3.readByte() << 24;
				}

				this.var_1a2b.addElement(var5);
				var3.close();
			} catch (IOException var7) {
				return;
			}
		}

	}

	public void loadSomeImages() {
		this.gameLogoMainImg = null;
		this.gameLogoSecondary = null;
		this.devLogoImg = null;

		try {
			// load location images
			int i;
			for (i = 0; i < 9; i++) {
				this.locationsImgArr[i] = Image.createImage("/images/locations/location" + i + ".png");
			}
			// load map image
			this.mapImg = Image.createImage("/images/game_map_full.png");
			this.locationBgImg = Image.createImage("/images/location_bg.png");

			this.buttonImg = Image.createImage("/images/button.png");
			this.button2Img = this.createMirrorHorizontalCopy(this.buttonImg);
			this.xpImg = Image.createImage("/images/xp.png");
			this.np2Img = Image.createImage("/images/np2.png");
			this.fsImg = Image.createImage("/images/fs.png");
			this.formZakImg = Image.createImage("/images/form_zak.png");
			this.topPanelLImg = Image.createImage("/images/toppanel_l.png");
			this.topPanelRImg = Image.createImage("/images/toppanel_r.png");
			this.topPanelMIng = Image.createImage("/images/toppanel_m.png");
			this.selShipImg = Image.createImage("/images/selship.png");

			for (i = 0; i < 4; ++i) {
				this.ugolImgArr[i] = Image.createImage("/images/ugol" + i + ".png");
			}

			for (i = 0; i < 6; ++i) {
				this.shipImgArr[i] = Image.createImage("/images/ship" + i + ".png");
			}

			lampImg = Image.createImage("/images/lamp.png");
		} catch (IOException var2) {
			System.out.println("Could not find the bitmap");
		}

	}

	public void unloadImagesAndGc() {
		this.mapImg = null;
		this.locationBgImg = null;
		this.buttonImg = null;
		this.button2Img = null;
		this.xpImg = null;
		this.np2Img = null;
		this.fsImg = null;
		this.formZakImg = null;
		this.topPanelLImg = null;
		this.topPanelRImg = null;
		this.topPanelMIng = null;
		this.selShipImg = null;
		lampImg = null;

		int tempIndex;
		for (tempIndex = 0; tempIndex < 4; ++tempIndex) {
			this.ugolImgArr[tempIndex] = null;
		}

		for (tempIndex = 0; tempIndex < 6; ++tempIndex) {
			this.shipImgArr[tempIndex] = null;
		}

		for (tempIndex = 0; tempIndex < 9; ++tempIndex) {
			this.locationsImgArr[tempIndex] = null;
		}

		this.gcAndSleep();
	}

	public void gcAndSleep() {
		System.gc();

		try {
			Thread.sleep(200L);
		} catch (InterruptedException var2) {
		}

	}

	public Image createMirrorHorizontalCopy(Image var1) {
		return Image.createImage(var1, 0, 0, var1.getWidth(), var1.getHeight(), 2);
	}

	public void sub_190(Graphics var1, int var2, int var3, String var4, boolean var5) {
		if (var5) {
			var1.drawImage(this.buttonImg, var2, var3, 20);
		} else {
			var1.drawImage(this.button2Img, var2, var3, 20);
		}

		var2 += (this.buttonImg.getWidth() - var4.length() * 8) / 2;
		if (var4 == "МЕНЮ") {
			--var2;
		}

		this.drawFancyText(var1, var2, var3 + 2, var4, this.rBigFrontImg);
	}

	public void sub_1a3() {
		String var1 = SomeUtilClass.loadDictionaryFile(this, "builds");

		int var2;
		for (var2 = 0; var2 < 31; ++var2) {
			this.buildingDictArr[var2] = new Upgrade(this);
			this.buildingDictArr[var2].var_11 = SomeUtilClass.sub_106(var1, "N" + var2);
			if (this.buildingDictArr[var2].var_11 != "") {
				this.buildingDictArr[var2].var_68 = SomeUtilClass.sub_106(var1, "n" + var2);
				this.buildingDictArr[var2].var_144 = SomeUtilClass.sub_106(var1, "D" + var2);

				try {
					this.buildingDictArr[var2].var_175 = Integer.parseInt(SomeUtilClass.sub_106(var1, "C" + var2));
					this.buildingDictArr[var2].var_1c1 = Integer.parseInt(SomeUtilClass.sub_106(var1, "S" + var2));
					this.buildingDictArr[var2].var_1ed = Byte.parseByte(SomeUtilClass.sub_106(var1, "T" + var2));
					this.buildingDictArr[var2].var_225 = Byte.parseByte(SomeUtilClass.sub_106(var1, "I" + var2));
				} catch (NumberFormatException var7) {
				}
			}
		}

		var1 = SomeUtilClass.loadDictionaryFile(this, "bonus");

		for (var2 = 0; var2 < 9; ++var2) {
			this.passiveUpgradesDictArr[var2] = new Upgrade(this);
			this.passiveUpgradesDictArr[var2].var_11 = SomeUtilClass.sub_106(var1, "N" + var2);
			this.passiveUpgradesDictArr[var2].var_144 = SomeUtilClass.sub_106(var1, "D" + var2);

			try {
				this.passiveUpgradesDictArr[var2].var_1ed = Byte.parseByte(SomeUtilClass.sub_106(var1, "T" + var2));
			} catch (NumberFormatException var6) {
			}
		}

		var1 = SomeUtilClass.loadDictionaryFile(this, "artefact");

		for (var2 = 0; var2 < 10; ++var2) {
			this.artifactsDictArr[var2] = new Upgrade(this);
			this.artifactsDictArr[var2].var_11 = SomeUtilClass.sub_106(var1, "N" + var2);
			this.artifactsDictArr[var2].var_144 = SomeUtilClass.sub_106(var1, "D" + var2);

			try {
				this.artifactsDictArr[var2].var_175 = Integer.parseInt(SomeUtilClass.sub_106(var1, "C" + var2));
				this.artifactsDictArr[var2].var_1ed = Byte.parseByte(SomeUtilClass.sub_106(var1, "T" + var2));
				this.artifactsDictArr[var2].var_1c1 = 0;
			} catch (NumberFormatException var5) {
			}
		}

		var1 = SomeUtilClass.loadDictionaryFile(this, "tech");

		for (var2 = 0; var2 < 64; ++var2) {
			this.var_fc9[var2] = new Class_4b(this);

			try {
				this.var_fc9[var2].var_16 = Integer.parseInt(SomeUtilClass.sub_106(var1, "C" + var2));
			} catch (NumberFormatException var4) {
				this.var_fc9[var2].var_16 = 10000;
			}

			this.sub_224(SomeUtilClass.sub_106(var1, "L" + var2), this.var_fc9[var2].var_2d);
		}

		this.sub_1f2("corpus", this.rangItemsArr, false);
		this.sub_1f2("engine", this.staminaItemsArr, false);
		this.sub_1f2("armor", this.costumeItemsArr, false);
		this.sub_1f2("computer", this.attackSpeedItemsArr, false);
		this.sub_1f2("weapon", this.weaponItemsArr, true);
		var1 = SomeUtilClass.loadDictionaryFile(this, "stars");
		SomeUtilClass.sub_e6(var1, this.locationNamesArr);
	}

	public void sub_1f2(String var1, StalkerStatDto[] var2, boolean var3) {
		String var4 = SomeUtilClass.loadDictionaryFile(this, var1);

		for (int var5 = 0; var5 < var2.length; ++var5) {
			var2[var5] = new StalkerStatDto();
			var2[var5].someStr = SomeUtilClass.sub_106(var4, "N" + var5);

			try {
				var2[var5].price = Integer.parseInt(SomeUtilClass.sub_106(var4, "C" + var5));
				var2[var5].weight = Integer.parseInt(SomeUtilClass.sub_106(var4, "S" + var5));
				var2[var5].statValue = Integer.parseInt(SomeUtilClass.sub_106(var4, "P" + var5));
				var2[var5].someByte = Byte.parseByte(SomeUtilClass.sub_106(var4, "T" + var5));
				if (var3) {
					this.var_1185[var5] = Byte.parseByte(SomeUtilClass.sub_106(var4, "V" + var5));
					this.var_11cd[var5] = Integer.parseInt(SomeUtilClass.sub_106(var4, "M" + var5));
				}
			} catch (NumberFormatException var7) {
			}
		}

	}

	public void sub_224(String var1, byte[] var2) {
		for (int var3 = 0; var3 < var2.length; ++var3) {
			var2[var3] = 1;
			if (var1.length() > var3) {
				var2[var3] = (byte) (var1.charAt(var3) - 48);
			}
		}

	}

	public void sub_269() {
		this.var_138 = true;
		Thread var1 = null;
		var1 = new Thread(this);
		var1.start();
	}

	public void sub_274() {
		this.var_138 = false;
	}

	public void maybeMainDrawingMethod(Graphics g) {
		if (this.introPainter != null) {
			this.introPainter.showIntro(g);
			if (this.introPainter.var_208) {
				if (this.introPainter.var_c1 < 150) {
					this.introPainter.var_c1 = 150;
				}

				if (this.introPainter.var_c1 > 150) {
					this.introPainter.var_c1 = 300;
				}

				this.introPainter.var_208 = false;
				this.gameActionState.clearAllStates();
			}

			if (this.introPainter.var_c1 >= this.introPainter.var_11b) {
				this.introPainter = null;
				this.var_1a6 = true;
			}

		} else { // if introPainter is null
			if (this.var_143d != null) {
				this.var_31a = 2;
				if (this.var_143d.var_281) {
					this.var_143d = null;
					this.sub_c7e();
					if (this.var_143d != null) {
						this.var_31a = 2;
					} else {
						this.var_31a = 1;
					}
				}
			}

			switch (this.var_31a) {
			case 1: // draw game field, cosmos and planets
				 //g.setColor(0);
				 //g.setColor(this.gameBackgroundColor);
				 //g.fillRect(0, 0, g.getClipWidth(), g.getClipHeight());
				 // draw location background
				 g.drawImage(locationBgImg, 0, 0, 20);

				 
				//xPos = var3.sub_ed() - this.xMapBias;
				//yPos = var3.sub_120() - this.yMapBias;
				
				
				if (this.var_9b3 == null && !this.var_1c2f) {
					this.var_9b3 = new Class_4b3(13, 0, 20, this.getWidth(), this.getHeight(), 3158064,
							(Planet) null);
					this.var_9b3.var_1f3 = 0;
					this.var_1c2f = true;
				}

				if (this.var_d5c.var_914 && this.var_9b3 == null) {
					this.var_9b3 = new Class_4b3(6, 0, 0, 0, 0, 0, (Planet) null);
					this.var_9b3.var_26e = "";
					this.var_9b3.addMenu2Option(-1, this.var_9b3.yPos + 15, SomeUtilClass.getStr("ВЫ ПРОИГРАЛИ"),
							false);
				}

				if (this.var_d5c.var_96d && this.var_9b3 == null) {
					this.var_9b3 = new Class_4b3(6, 0, 0, 0, 0, 3158064, (Planet) null);
					this.var_9b3.var_26e = "";
					this.var_9b3.addMenu2Option(-1, this.var_9b3.yPos + 15, SomeUtilClass.getStr("ВЫ ПОБЕДИЛИ"), false);
					this.sub_2258(this.var_d5c);
				}

				this.var_12a6 = true;
				if (this.gameActionState.numPound) {
					this.sub_6e1();
				}

				if (this.gameActionState.numStar) {
					this.sub_6ec();
				}

				if (this.var_19ae != null) {
					this.sub_2328();
				} else if (this.var_9b3 != null) {
					this.sub_509();
				} else if (this.var_e29 != null) {
					this.sub_5d8();
				} else if (this.var_1029 != null) {
					this.sub_580();
				} else {
					this.sub_622();
				}

				this.someDrawingFunction2(g, false);
				this.var_12a6 = false;
				this.flushGraphics();
				break;
			case 2:
				this.var_12a6 = true;
				this.var_143d.sub_1da();
				this.var_143d.someBattleMethod(g);
				this.var_12a6 = false;
				if (this.var_143d.var_640) {
					this.flushGraphics();
				}
				break;
			case 3:
				g.setColor(0);
				g.fillRect(0, 0, g.getClipWidth(), g.getClipHeight());
				this.var_12a6 = true;
				if (this.var_9b3 != null) {
					this.var_9b3.sub_108(g);
				}

				this.sub_99b();
				this.var_12a6 = false;
				this.flushGraphics();
			}

		}
	}

	public void sub_2d5(Graphics g, Planet planet) {
		int screenXPos = this.someXCellPos * 20 - this.xMapBias;
		int screenYPos = this.someYCellPos * 20 - this.yMapBias;
		byte var5 = 20;
		boolean var6 = true;
		if (this.var_e29 != null && this.var_e29.var_3c8 == 3 && planet != null) {
			++this.var_b3a;
			if (this.var_b3a > 5) {
				this.var_b3a = 0;
				this.var_e29.sub_194(g, screenXPos + 10, screenYPos + 10, true);
			} else {
				this.var_e29.sub_194(g, screenXPos + 10, screenYPos + 10, false);
			}
		} else {
			++this.var_b3a;
			if (this.var_b3a > 5) {
				var5 = 18;
				++screenXPos;
				++screenYPos;
				if (this.var_b3a > 10) {
					this.var_b3a = 0;
				}
			}

			if (this.var_9b3 == null && this.var_1029 == null) {
				//draw cursors on planet
				g.drawImage(this.ugolImgArr[0], screenXPos, screenYPos, 20);
				g.drawImage(this.ugolImgArr[1], screenXPos + var5 - this.ugolImgArr[1].getWidth(), screenYPos, 20);
				g.drawImage(this.ugolImgArr[2], screenXPos + var5 - this.ugolImgArr[2].getWidth(),
						screenYPos + var5 - this.ugolImgArr[2].getHeight(), 20);
				g.drawImage(this.ugolImgArr[3], screenXPos, screenYPos + var5 - this.ugolImgArr[3].getHeight(), 20);
			}
		}

		if (screenXPos < 0 || screenYPos < 0 || screenXPos > this.getWidth() || screenYPos > this.getHeight()) {
			this.sub_6a1();
			this.sub_6a1();
		}

		boolean var7 = this.var_9b3 == null && this.var_e29 == null && this.var_1029 == null
				|| this.var_9b3 != null && this.var_9b3.menuId == 13 && !this.var_9b3.var_b64;
		if (!this.var_232) {
			this.sub_10d7(g, this.var_728, this.var_73d, this.var_6f1, 14, 880901);
			if (var7) {
				this.sub_190(g, this.var_869, this.var_881, SomeUtilClass.getStr("ХОД"), false);
			} else {
				this.sub_190(g, this.var_869, this.var_881, SomeUtilClass.getStr("ПОМ"), false);
			}

			this.sub_333(g, this.var_728, this.var_73d, true);
		} else if (var7) {
			this.sub_10d7(g, this.var_728, this.var_73d, this.var_6f1, 14, 880901);
			this.var_d8f = false;
			this.sub_333(g, this.var_728, this.var_73d, true);
		} else {
			int var8 = 0;
			if (this.var_9b3 != null) {
				var8 = this.var_9b3.var_1f3;
			} else if (this.var_e29 != null) {
				var8 = this.var_e29.var_1f3;
			} else if (this.var_1029 != null) {
				var8 = this.var_1029.var_1f3;
			}

			int var9 = this.var_6f1 - var8;
			if (this.var_d8f) {
				var9 = 0;
			}

			if (var9 < this.var_794) {
				var9 = this.var_794;
				this.sub_190(g, this.var_869, this.var_881, SomeUtilClass.getStr("ПОМ"), false);
				this.var_d8f = true;
			}

			this.sub_10d7(g, this.var_728, this.var_73d, var9, 14, 880901);
			this.sub_333(g, this.var_728, this.var_73d, false);
		}

		if (var7) {
			this.sub_190(g, this.var_7d3, this.var_881, SomeUtilClass.getStr("МЕНЮ"), true);
		} else {
			this.sub_190(g, this.var_7d3, this.var_881, SomeUtilClass.getStr("ЗАКР"), true);
		}

		if (this.var_1029 == null) {
			if (this.var_e29 != null && this.var_e29.var_3c8 == 2) {
				this.sub_10d7(g, this.var_99e, 0, 110, this.var_8e4, 880901);
				if (this.var_8e4 < this.var_e29.sub_1c2()) {
					this.var_8e4 += 2;
				}

				if (this.var_8e4 > this.var_e29.sub_1c2()) {
					this.var_8e4 -= 2;
				}

				if (this.var_8e4 == this.var_e29.sub_1c2()) {
					this.var_e29.sub_1dd(g, this.var_99e + 3);
				}
			} else {
				boolean var10 = planet != null;
				if (this.getHeight() <= 128 && var10 && this.var_9b3 != null) {
					var10 = this.var_9b3.menuId == 7 || this.var_9b3.menuId == 9;
				}

				if (var10) {
					if (this.var_9b3 != null && this.var_9b3.menuId == 7) {
						if (this.var_9b3.var_ab3 == 0) {
							if (this.var_8e4 > 0) {
								this.sub_10d7(g, this.var_99e, 0, 110, this.var_8e4, 880901);
								this.var_8e4 -= 2;
							} else {
								byte var11 = 23;
								if (this.getHeight() < 160) {
									var11 = 16;
									if (this.var_9b3.var_3c8 == 0) {
										this.var_9b3.sub_491(g, 5, this.var_970 - var11 + 1, this.getWidth() - 10);
									}

									this.var_9b3.sub_442(g, 5, this.var_970 - var11 + 4);
								} else {
									if (this.var_9b3.var_3c8 == 0) {
										this.var_9b3.sub_491(g, 5, this.var_970 - var11 + 7, this.getWidth() - 10);
									}

									this.sub_1086(g, 5, this.var_970 - var11, this.getWidth() - 10);
									this.var_9b3.sub_442(g, 5, this.var_970 - var11 + 9);
								}

								if (this.var_970 < var11) {
									this.var_970 += 5;
									if (this.var_970 > var11) {
										this.var_970 = var11;
									}
								}
							}
						}
					} else {
						this.var_970 = 0;
						this.sub_10d7(g, this.var_99e, 0, 110, this.var_8e4, 880901);
						if (planet != null) {
							planet.drawOwnedLocationTopPanel(g, this.var_99e + 3, -11 + this.var_8e4, this.var_d5c.var_1c6);
						}

						if (this.var_8e4 < 14) {
							this.var_8e4 += 2;
						}

						if (this.var_8e4 > 14) {
							this.var_8e4 -= 2;
						}
					}
				} else if (this.var_8e4 > 0) {
					this.sub_10d7(g, this.var_99e, 0, 110, this.var_8e4, 880901);
					this.var_8e4 -= 2;
				}
			}

			if (this.var_9b3 != null) {
				this.var_9b3.sub_108(g);
				if (this.var_9b3.menuId == 2) {
					this.sub_389(g, this.var_9b3.yPos - 12);
				}

				if (this.var_9b3.menuId == 13 && this.var_9b3.var_1f3 < 0) {
					this.var_9b3 = null;
					if (this.gameCurrentMonth == 1 && this.gameCurrentYear == 2023) {
						this.sub_22a8(0);
					}

					return;
				}
			}

			if (this.var_e29 != null) {
				this.var_e29.sub_2b(g);
			}

			if (this.var_19ae != null) {
				this.var_19ae.sub_108(g);
			}

		}
	}

	public void sub_30b(Graphics var1) {
		var1.setClip(this.var_1591, this.var_15c2, 5, 9);
		if (this.var_153f) {
			var1.drawImage(lampImg, this.var_1591, this.var_15c2, 20);
		} else {
			var1.drawImage(lampImg, this.var_1591 - 5, this.var_15c2, 20);
		}

		var1.setClip(0, 0, this.getWidth(), this.getHeight());
	}

	public void sub_333(Graphics var1, int var2, int var3, boolean var4) {
		if (this.var_1490) {
			int var5 = var2 + 5;
			if (lampImg != null) {
				this.var_1591 = var5;
				this.var_15c2 = var3 + 3;
				this.sub_30b(var1);
				var5 += 8;
			}

			this.sub_fcf(var1, var5, var3 + 5, SomeUtilClass.getStr("ЖДИТЕ..."), this.rMiniFront2Img);
		} else {
			if (this.var_134a != this.var_d5c.var_f6 || var4 && this.sub_dda(this.var_d5c) != this.var_13ae) {
				this.sub_3db();
			}

			this.sub_fcf(var1, var2 + 4, var3 + 5, this.var_12f1, this.rMiniFront2Img);
			if (var4) {
				this.sub_fcf(var1, this.var_13cb, var3 + 5, this.var_138d, this.rMiniFront2Img);
			}

		}
	}

	public void sub_389(Graphics g, int yPos) {
		int xPos = 42;
		if (this.gameCurrentMonth >= 10) {
			xPos += 7;
		}

		xPos = (this.getWidth() - xPos) / 2;
		this.drawFancyText(g, xPos, yPos, this.gameCurrentMonth + "." + this.gameCurrentYear, this.rBigFrontImg);
	}

	public void sub_395() {
		this.gameRect.x1 = 0;
		this.gameRect.y1 = 0;
		this.gameRect.x2 = this.getWidth() - 1;
		this.gameRect.y2 = this.getHeight() - 1;
		this.gameRect.xLen = this.gameRect.x2 - this.gameRect.x1;
		this.gameRect.yLen = this.gameRect.y2 - this.gameRect.y1;
		if (this.getWidth() <= 128) {
			this.var_6f1 = 70;
		}

		if (this.getWidth() >= 176) {
			this.var_6f1 = 80;
		}

		if (this.getWidth() > 128) {
			this.var_232 = false;
			this.var_728 = (this.getWidth() - this.var_6f1) / 2;
			this.var_869 = this.var_728 + this.var_6f1 + 2;
		} else {
			this.var_232 = true;
			this.var_728 = (this.getWidth() - this.var_6f1 - this.buttonImg.getWidth()) / 2 + this.buttonImg.getWidth()
					+ 1;
			this.var_794 = (this.getWidth() / 2 - this.var_728) * 2;
			this.var_869 = this.var_728 + this.var_794 + 2;
		}

		this.var_73d = this.getHeight() - 14 - 1;
		this.var_99e = (this.getWidth() - 110) / 2;
		this.var_7d3 = this.var_728 - this.buttonImg.getWidth() - 1;
		this.var_881 = this.getHeight() - this.buttonImg.getHeight();
		this.var_1c3c = false;
	}

	public void sub_3db() {
		this.var_12f1 = this.var_d5c.var_f6 + " K";
		if (this.var_d5c.var_f6 > 999) {
			this.var_12f1 = this.var_d5c.var_f6 / 1000 + "K K";
		}

		if (this.var_d5c.var_f6 > 999999) {
			this.var_12f1 = this.var_d5c.var_f6 / 10000000 + "M K";
		}

		this.var_134a = this.var_d5c.var_f6;
		int var1 = this.sub_dda(this.var_d5c);
		if (var1 > 999) {
			this.var_138d = "+" + var1 / 1000 + "B";
		} else if (var1 >= 0) {
			this.var_138d = "+" + var1;
		} else {
			this.var_138d = "" + var1;
		}

		this.var_13ae = var1;
		this.var_13cb = this.var_728 + this.var_6f1 - 5 - this.var_138d.length() * 5;
	}

	public void drawPlanet(Graphics g, int xPos, int yPos, int starIndex) {
		byte starHeight = 20;
		if (starIndex <= 4) {
			starHeight = 14;
			xPos += 3;
			yPos += 3;
		}

		g.setClip(xPos - this.locationsImgArr[starIndex].getWidth() / 2,
					yPos - this.locationsImgArr[starIndex].getHeight() / 2, this.locationsImgArr[starIndex].getWidth(),
					this.locationsImgArr[starIndex].getHeight());
		g.drawImage(this.locationsImgArr[starIndex], xPos - this.locationsImgArr[starIndex].getWidth() / 2,
					yPos - this.locationsImgArr[starIndex].getHeight() / 2, 20);


	}

	public void someDrawingFunction2(Graphics g, boolean var2) {
		if (this.planetsArr != null) {
			if (this.var_1c3c) {
				this.sub_395();
			}

			if (this.someXCellPos2 != this.someXCellPos || this.someYCellPos2 != this.someYCellPos) {
				this.var_12b8 = this.sub_76d(this.someXCellPos, this.someYCellPos);
				this.someXCellPos2 = this.someXCellPos;
				this.someYCellPos2 = this.someYCellPos;
			}

			if (this.sub_6a1() && this.var_12b8 != null) {
				this.sub_6a1();
			}

			int var7 = 16777215;
			int var8 = 10461087;
			if (this.var_e9e != 0) {
				var7 = 255 - this.var_e9e << 16 | 255 - this.var_e9e << 8 | 255 - this.var_e9e;
				var8 = 159 - this.var_e9e;
				if (var8 > 255) {
					var8 = 255;
				}

				if (var8 < 0) {
					var8 = 0;
				}

				var8 |= var8 << 16 | var8 << 8;
			}

			if (this.var_9b3 == null || this.var_9b3 != null && this.var_9b3.menuId == 7
					|| this.var_9b3 != null && this.var_9b3.menuId == 10
					|| this.var_9b3 != null && this.var_9b3.menuId == 13) {
				if (this.var_e9e > 0) {
					this.var_e9e -= 10;
				}

				if (this.var_e9e < 0) {
					this.var_e9e = 0;
				}
			} else {
				this.var_e9e += 10;
				if (this.var_e9e > 160) {
					this.var_e9e = 160;
				}
			}

			int var9 = -1;
			boolean var10 = false;

			int xPos;
			int yPos;
			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < 60; ++var11) {
				xPos = this.var_bfd[var11] & 4095;
				yPos = this.var_bfd[var11] >> 12 & 4095;
				int var6 = this.var_bfd[var11] >> 24 & 255;
				if (var6 != var9) {
					var9 = var6;
					if (var6 == 0) {
						g.setColor(var8);
					} else {
						g.setColor(var7);
					}
				}

				if (var6 <= 1) {
					g.drawLine(xPos, yPos, xPos, yPos);
				} else {
					if (this.var_c5c == 0 && this.random.nextInt() % 100 == 1) {
						this.var_c5c = this.var_bfd[var11];
					}

					var12 = 0;
					if (this.var_c5c == this.var_bfd[var11]) {
						var10 = true;
						this.var_caa += 5;
						if (this.var_caa > 100) {
							var12 = 200 - this.var_caa;
						} else {
							var12 = this.var_caa;
						}

						if (this.var_caa > 200) {
							this.var_caa = 0;
							this.var_c5c = 0;
						}
					}

					if (var12 == 0) {
						if (var6 == 3) {
							g.drawImage(this.var_1421[0], xPos - 2, yPos - 2, 20);
						} else {
							g.drawImage(this.var_1421[1], xPos - 2, yPos - 2, 20);
						}
					} else {
						var13 = 2695473;
						if (var6 == 3) {
							var13 = 3219761;
						}

						if (var12 > 50) {
							g.setColor(SomeUtilClass.sub_28f(var13, 100 - var12));
							g.drawLine(xPos, yPos - 3, xPos, yPos + 3);
							g.drawLine(xPos - 3, yPos, xPos + 3, yPos);
						}

						g.setColor(SomeUtilClass.sub_28f(var13, -var12));
						g.drawLine(xPos - 2, yPos, xPos + 2, yPos);
						g.drawLine(xPos, yPos - 2, xPos, yPos + 2);
						g.setColor(var13);
						g.drawLine(xPos - 1, yPos - 1, xPos + 1, yPos + 1);
						g.drawLine(xPos + 1, yPos - 1, xPos - 1, yPos + 1);
						if (var6 == 3) {
							var13 = 6507098;
						} else {
							var13 = 5915210;
						}

						g.setColor(SomeUtilClass.sub_28f(var13, -var12));
						g.drawLine(xPos - 1, yPos, xPos + 1, yPos);
						g.drawLine(xPos, yPos - 1, xPos, yPos + 1);
						if (var6 == 3) {
							var13 = 16777215;
						} else {
							var13 = 10263758;
						}

						g.setColor(var13);
						g.drawLine(xPos, yPos, xPos, yPos);
					}
				}
			}

			if (!var10) {
				this.var_caa = 0;
				this.var_c5c = 0;
			}

			if (!var2) {
				if (this.var_9b3 != null && this.var_9b3.menuId == 7) {
					this.sub_2d5(g, this.var_12b8);
				} else if (this.var_1029 != null) {
					this.sub_2d5(g, (Planet) null);
					this.var_1029.sub_1c4(this, g);
					if (this.var_19ae != null) {
						this.var_19ae.sub_108(g);
					}

				} else {
					// drawing game map
					g.drawImage(mapImg, -this.xMapBias, -this.yMapBias, 20);
					// Drawing planets
					for (var11 = 0; var11 < this.planetsArr.size(); ++var11) {
						Planet planet = (Planet) this.planetsArr.elementAt(var11);
						xPos = planet.getXAbsolutePosition() - this.xMapBias;
						yPos = planet.getYAbsolutePosition() - this.yMapBias;
						// if planet on game screen, then draw it
						if (xPos >= -50 && xPos <= this.gameRect.x2 && yPos >= -50 && yPos <= this.gameRect.y2) {
							this.drawPlanet(g, xPos, yPos, planet.var_9b);
							xPos += (20 - planet.sub_96().length() * 5) / 2;
							yPos = yPos + 20 + 2;
							var12 = this.sub_fcf(g, xPos, yPos, planet.sub_96(), this.rMiniFrontImg);
							if (planet.var_1df != null && planet.sub_150(this.var_d5c.var_1c6)) {
								var13 = this.sub_121c(planet.var_1df.var_4f);
								g.setColor(var13);
								g.drawLine(xPos, yPos + 7, var12 - 2, yPos + 7);
							}
						}
					}

					if (this.var_da5 != null) {
						for (var13 = 0; var13 < this.var_da5.size(); ++var13) {
							Class_4f2 var14 = (Class_4f2) this.var_da5.elementAt(var13);
							if (var14.var_27d) {
								xPos = var14.sub_3eb() - this.xMapBias;
								yPos = var14.sub_445() - this.yMapBias;
								if (var14.var_2d9) {
									xPos += 23;
									yPos += 3;
								} else {
									xPos += 7;
									yPos += 7;
								}

								if (var14.sub_599() && var14.var_261) {
									var14.sub_4dc(g, xPos, yPos, var14.sub_362() * 20 - this.xMapBias + 10,
											var14.sub_3a1() * 20 - this.yMapBias + 10, this.var_e3d);
								}

								if (xPos >= -20 && xPos <= this.gameRect.x2 && yPos >= -20
										&& yPos <= this.gameRect.y2) {
									var14.sub_499(g, xPos, yPos, this.sub_121c(var14.sub_236()));
								}
							}
						}
					}

					++this.var_e3d;
					if (this.var_e3d >= 48) {
						this.var_e3d = 0;
					}

					this.sub_2d5(g, this.var_12b8);
				}
			}
		}
	}

	public void sub_462(int var1) {
		this.var_1421[var1] = Image.createImage(5, 5);
		int var2 = 2695473;
		if (var1 == 0) {
			var2 = 3219761;
		}

		Graphics g = this.var_1421[var1].getGraphics();
		g.setColor(0);
		g.fillRect(0, 0, 5, 5);
		byte var4 = 2;
		byte var5 = 2;
		g.setColor(var2);
		g.drawLine(var4 - 2, var5, var4 + 2, var5);
		g.drawLine(var4, var5 - 2, var4, var5 + 2);
		g.drawLine(var4 - 1, var5 - 1, var4 + 1, var5 + 1);
		g.drawLine(var4 + 1, var5 - 1, var4 - 1, var5 + 1);
		if (var1 == 0) {
			var2 = 6507098;
		} else {
			var2 = 5915210;
		}

		g.setColor(var2);
		g.drawLine(var4 - 1, var5, var4 + 1, var5);
		g.drawLine(var4, var5 - 1, var4, var5 + 1);
		if (var1 == 0) {
			var2 = 16777215;
		} else {
			var2 = 10263758;
		}

		g.setColor(var2);
		g.drawLine(var4, var5, var4, var5);
	}

	public void sub_4b5(int var1) {
		switch (var1) {
		case 0:
			this.var_9b3 = null;
			this.var_1490 = true;
			break;
		case 1:
			this.var_9b3 = new Class_4b3(9, 0, 0, this.getWidth(), this.getHeight(), 0, (Planet) null);
			break;
		case 2:
			this.var_9b3 = new Class_4b3(10, 0, 0, this.getWidth(), this.getHeight(), 0, (Planet) null);
			break;
		case 3:
			this.sub_178d();
			break;
		case 4:
			this.var_9b3 = null;
			this.var_9b3 = new Class_4b3(3, (this.getWidth() - 110) / 2, (this.getHeight() - 97) / 2, 110, 97, 3158064,
					(Planet) null);
			int var2 = 0;

			while (true) {
				Class_2a9 var10001 = this.var_d5c;
				if (var2 >= 5) {
					this.var_9b3.var_53a = this.var_d5c;
					this.var_9b3.sub_bd();
					return;
				}

				this.var_9b3.addMenu1Option(this.var_9b3.xPos + 8, this.var_9b3.yPos + 50 + var2 * 8,
						var2 + 1 + "." + this.var_d5c.projectsArr[var2].projectName, false);
				++var2;
			}
		case 5:
			this.var_9b3 = new Class_4b3(16, (this.getWidth() - 93) / 2, (this.getHeight() - 40) / 2, 93, 40, 0,
					(Planet) null);
			break;
		case 6:
			this.sub_2247();
			break;
		case 7:
			this.var_9b3 = null;
			this.var_1a6 = true;
		}

	}

	public void sub_509() {
		if (this.var_9b3 != null) {
			this.var_f42 = true;
			if (this.var_b4d > 0) {
				this.var_b4d -= this.var_1d1;
			} else {
				if (this.gameActionState.up) {
					this.var_9b3.sub_140();
					this.var_b4d = 250;
					this.gameActionState.up = false;
				}

				if (this.gameActionState.down) {
					this.var_9b3.sub_18d();
					this.var_b4d = 250;
					this.gameActionState.down = false;
				}

				if (this.gameActionState.right) {
					this.var_9b3.sub_197();
					this.var_b4d = 250;
					this.gameActionState.right = false;
				}

				if (this.gameActionState.left) {
					this.var_9b3.sub_1ea();
					this.var_b4d = 250;
					this.gameActionState.left = false;
				}

				if (this.gameActionState.fire) {
					label180: switch (this.var_9b3.menuId) {
					case 1:
						this.var_9b3 = null;
						break;
					case 2:
						this.sub_4b5(this.var_9b3.var_3c8);
						break;
					case 3:
						int var1 = this.var_9b3.var_3c8;
						this.var_9b3 = null;
						this.var_9b3 = new Class_4b3(4, (this.getWidth() - 124) / 2, (this.getHeight() - 107) / 2, 124,
								107, 3158064, (Planet) null);
						this.var_9b3.var_57d = this.var_d5c.projectsArr[var1];
						this.var_9b3.sub_bd();
						this.var_9b3.var_409 = var1;
						break;
					case 4:
						if (this.var_9b3.var_73e == null) {
							if (this.var_9b3.var_3c8 == 0) {
								if (this.var_9b3.var_79a == null) {
									this.var_9b3.var_79a = new Class_18c(SomeUtilClass.getStr("ИМЯ СТАЛКЕРА"),
											(this.getWidth() - 106) / 2, (this.getHeight() - 32) / 2,
											this.var_9b3.var_57d.projectName, 3158064);
								} else {
									this.var_9b3.var_79a.var_6d = this.var_9b3.var_79a.var_6d.trim();
									this.var_9b3.var_57d.projectName = this.var_9b3.var_79a.var_6d;
									this.var_9b3.var_79a = null;
									this.var_9b3.sub_bd();
								}
							} else {
								int var6 = this.getWidth() - 94;
								if (var6 > this.var_9b3.xPos + this.var_9b3.var_124 / 2) {
									var6 = this.var_9b3.xPos + this.var_9b3.var_124 / 2;
								}

								this.var_9b3.var_73e = new SomeUpgradeDrawClass(this.var_9b3.var_3c8, var6,
										(this.getHeight() - 97) / 2, 94, 97, 3158064);
								this.var_9b3.sub_258();
							}
						} else {
							this.var_9b3.sub_266();
							this.var_9b3.var_73e = null;
							this.var_9b3.sub_bd();
						}
						break;
					case 5:
						if (this.var_9b3.var_3c8 == 0) {
							this.sub_52d(this.var_d5c, this.sub_76d(this.someXCellPos, this.someYCellPos));
							this.sub_555(this.someXCellPos, this.someYCellPos);
						}

						this.var_9b3 = null;
						break;
					case 6:
						this.var_9b3 = null;
						if (this.var_d5c.var_914 && this.sub_ad7() || this.var_d5c.var_96d) {
							this.sub_b1a(this.var_d5c.var_96d);
						}
						break;
					case 7:
						if (this.var_9b3.var_3c8 > 0) {
							if (this.var_9b3.var_3c8 == 4 && this.var_9b3.var_b77 != null) {
								if (this.var_9b3.var_b77.menuId == 6) {
									this.var_9b3.var_b77 = null;
								} else if (this.var_9b3.var_b77.menuId == 12) {
									if (this.var_9b3.var_b77.var_3c8 == 0) {
										this.var_9b3.somePlanet.var_1df.sub_3b5();
									}

									this.var_9b3.var_b77 = null;
								}
							} else if (this.var_9b3.var_73e == null) {
								this.var_9b3.drawUpgradesMenu();
							} else {
								this.var_9b3.sub_266();
								this.var_9b3.var_73e = null;
							}
						} else if (this.var_9b3.var_3c8 == 0) {
							this.var_9b3.var_b03 = !this.var_9b3.var_b03;
							if (this.var_9b3.var_b03) {
								if (this.getHeight() < 160) {
									this.var_9b3.var_ab3 = -this.topPanelMIng.getHeight();
								} else {
									this.var_9b3.var_ab3 = 0;
								}
							}
						}
					case 8:
					case 11:
					case 12:
					case 15:
					default:
						break;
					case 9:
						if (this.var_9b3.var_b77 != null) {
							this.var_9b3.var_b77 = null;
						} else {
							Planet var2 = this.sub_76d(this.someXCellPos, this.someYCellPos);
							if (var2 == null) {
								break;
							}

							if (this.var_9b3.var_d47 == 10) {
								if (var2.var_1df != null && var2.var_1df.var_4f == this.var_d5c.var_1c6) {
									this.sub_1a71(var2.planetCoords);
								}
							} else {
								if (!var2.sub_150(this.var_d5c.var_1c6)) {
									break;
								}

								if (var2.var_1df == null
										|| var2.var_1df != null && var2.var_1df.var_4f != this.var_d5c.var_1c6) {
									this.var_9b3.var_b77 = new Class_4b3(1, (this.getWidth() - 82) / 2,
											(this.getHeight() - 72) / 2, 82, 72, 3158064, var2);
								}

								if (var2.var_1df != null && var2.var_1df.var_4f == this.var_d5c.var_1c6) {
									this.var_9b3 = new Class_4b3(7, 0, 0, this.getWidth(), this.getHeight(), 3158064,
											var2);
								}
							}
						}
						break;
					case 10:
						Class_4f2 var3;
						if (this.var_9b3.var_b77 != null) {
							var3 = this.sub_135b(this.var_d5c.var_1c6, this.var_9b3.var_3c8 + 1);
							switch (this.var_9b3.var_b77.menuId) {
							case 11:
								if (this.var_9b3.var_b77.var_3c8 == 1) {
									this.var_9b3.var_b77 = new Class_4b3(12, 0, 0, 0, 0, 3158064, (Planet) null);
									this.var_9b3.var_b77.var_1f3 = 82;
									this.var_9b3.var_b77.var_caf = var3.sub_6df();
									this.var_9b3.var_b77.var_26e = var3.sub_1af() + " " + var3.sub_264();
									this.var_9b3.var_b77.addMenu2Option(-1, this.var_9b3.var_b77.yPos + 15,
											SomeUtilClass.getStr("ПРОДАТЬ"), false);
									this.var_9b3.var_b77.addMenu2Option(-1, this.var_9b3.var_b77.yPos + 22,
											SomeUtilClass.getStr("ЗА") + " " + var3.sub_6df() + " K", false);
								} else if (this.var_9b3.var_b77.var_3c8 == 0) {
									this.var_9b3.var_d47 = 1;
									this.var_9b3.var_b77 = null;
									this.var_9b3.var_57d = var3;

									try {
										this.var_9b3.var_d8e = Image.createImage("/images/charrow.png");
									} catch (IOException var5) {
									}
								} else if (this.var_9b3.var_b77.var_3c8 == 2) {
									this.var_9b3.var_b77 = null;
								}
								break label180;
							case 12:
								if (this.var_9b3.var_b77.var_3c8 == 0) {
									this.sub_14c3(this.var_d5c, var3);
									--this.var_9b3.var_caf;
									this.var_9b3.var_3c8 = 0;
									this.var_9b3.var_368 = 0;
									this.sub_1392();
								}

								this.var_9b3.var_b77 = null;
							}
						} else {
							if (this.var_9b3.var_caf > 0 && this.var_9b3.var_d47 == 0) {
								this.var_9b3.var_b77 = new Class_4b3(11, (this.getWidth() - 110) / 2,
										(this.getHeight() - 88) / 2, 110, 88, 3158064, (Planet) null);
								this.var_9b3.var_b77.var_caf = this.var_9b3.var_3c8 + 1;
								this.var_9b3.var_b77.var_1f3 = 110;
								this.var_9b3.var_b77.var_53a = this.var_d5c;
								this.var_9b3.var_b77.var_3c8 = 2;
							}

							if (this.var_9b3.var_d47 == 1) {
								var3 = this.sub_135b(this.var_d5c.var_1c6, this.var_9b3.var_3c8 + 1);
								if (var3 == null) {
									break;
								}

								if (var3.sub_6f2((Class_4f2) this.var_9b3.var_57d)) {
									var3.sub_73f((Class_4f2) this.var_9b3.var_57d);
									this.var_9b3.var_57d = null;
									this.var_9b3.var_d47 = 0;
									this.var_9b3.var_d8e = null;
								}
							}

							if (this.var_9b3.var_d47 == 10) {
								this.sub_1a92(this.var_9b3.var_3c8 + 1);
							}
						}
						break;
					case 13:
						if (this.var_9b3.var_b64) {
							this.var_9b3 = null;
							this.var_d5c.sub_675();
							if (this.var_d5c.var_6eb >= 0) {
								this.sub_19f8();
							}

							if (this.var_d5c.var_723) {
								this.var_d5c.var_723 = false;
								this.sub_178d();
							}
						}
						break;
					case 14:
						this.sub_1a34();
						break;
					case 16:
					case 17:
						this.var_9b3 = null;
					}

					this.gameActionState.fire = false;
				}

			}
		}
	}

	public void sub_52d(Class_2a9 var1, Planet var2) {
		if (var2 != null) {
			var2.var_1df = new Class_139(var1.var_1c6);
			if (var1.var_47e && this.var_190d == 2) {
				switch (var1.var_8c) {
				case 0:
				case 1:
					var2.var_1df.sub_cd(0);
					break;
				case 2:
					var2.var_1df.sub_cd(2);
					break;
				case 3:
					var2.var_1df.sub_cd(1);
				}

				if (var1.var_3d2) {
					var2.var_1df.sub_1e(var2.var_1df.getCurrentPopulation() + 1);
				}
			}

		}
	}

	public void sub_555(int var1, int var2) {
		for (int var4 = 0; var4 < this.sub_1592(var1, var2); ++var4) {
			Class_4f2 var3 = this.sub_15d8(var1, var2, var4 + 1);
			if (var3.sub_613()) {
				this.sub_1601(var3);
			}
		}

	}

	public void sub_580() {
		if (this.var_b4d > 0) {
			this.var_b4d -= this.var_1d1;
		} else {
			if (this.gameActionState.up) {
				this.var_b4d = 250;
				this.var_1029.sub_81();
			}

			if (this.gameActionState.down) {
				this.var_b4d = 250;
				this.var_1029.sub_e1();
			}

			if (this.gameActionState.left) {
				this.var_b4d = 250;
				this.var_1029.sub_164();
			}

			if (this.gameActionState.right) {
				this.var_b4d = 250;
				this.var_1029.sub_13b();
			}

			if (this.gameActionState.fire) {
				if (this.var_1029.sub_62()) {
					this.gameActionState.fire = false;
					return;
				}

				if (this.var_1029.var_1d8 == null) {
					if (this.var_1029.var_3a > 0 && this.var_1029.var_3c8 > 0) {
						this.var_1029.sub_33c();
					}

					if (this.var_1029.var_3a == 0 && this.var_1029.var_3c8 > 0) {
						if (this.var_1029.var_3c8 <= 5) {
							this.var_d5c.sub_50c(this.var_1029.var_3c8 - 1);
						}

						if (this.var_1029.var_3c8 == 6) {
							this.var_d5c.var_622 = 50;
						}
					}
				} else {
					if (this.var_1029.var_1d8.var_3c8 == 0) {
						this.var_1029.sub_39f();
					}

					this.var_1029.var_1d8 = null;
				}

				this.gameActionState.fire = false;
			}

		}
	}

	public void sub_5d8() {
		if (this.var_b4d > 0) {
			this.var_b4d -= this.var_1d1;
		} else {
			if (this.var_e29.var_3c8 == 3) {
				this.sub_622();
			}

			if (this.gameActionState.up) {
				this.var_b4d = 250;
				this.var_e29.sub_52();
			}

			if (this.gameActionState.down) {
				this.var_b4d = 250;
				this.var_e29.sub_60();
			}

			if (this.gameActionState.left) {
				this.var_b4d = 250;
				this.var_e29.sub_e4();
			}

			if (this.gameActionState.right) {
				this.var_b4d = 250;
				this.var_e29.sub_af();
			}

			if (this.gameActionState.fire) {
				if (this.var_e29.var_3c8 == 3) {
					if (this.sub_76d(this.someXCellPos, this.someYCellPos) != null && this.var_e29.var_2b1) {
						int var1 = this.someXCellPos;
						int var2 = this.someYCellPos;
						this.someXCellPos = this.var_e29.var_218;
						this.someYCellPos = this.var_e29.var_244;
						this.var_e29.sub_134(var1, var2);
						this.var_e29 = null;
						this.sub_1392();
					}

					this.gameActionState.fire = false;
					return;
				}

				if (this.var_e29.var_3c8 == 2) {
					this.var_e29.var_1c7[this.var_e29.var_3b] = !this.var_e29.var_1c7[this.var_e29.var_3b];
				}

				if (this.var_e29.var_3c8 == 1) {
					if (!this.var_e29.var_32a) {
						this.gameActionState.fire = false;
						return;
					}

					this.var_e29.var_3c8 = 3;
				}

				if (this.var_e29.var_3c8 == 0) {
					if (this.var_e29.var_2ca == 1) {
						this.var_9b3 = new Class_4b3(5, (this.getWidth() - 82 - 30) / 2,
								(this.getHeight() - 72 - 5) / 2, 112, 77, 3158064, this.var_e29.somePlanet);
					}

					if (this.var_e29.var_2ca == 0) {
						this.var_9b3 = new Class_4b3(7, 0, 0, this.getWidth(), this.getHeight(), 3158064,
								this.var_e29.somePlanet);
					}

					if (this.var_e29.var_2ca == 2) {
						if (this.var_e29.somePlanet.sub_150(this.var_d5c.var_1c6)) {
							this.var_9b3 = new Class_4b3(1, (this.getWidth() - 82) / 2, (this.getHeight() - 72) / 2, 82,
									72, 3158064, this.var_e29.somePlanet);
						} else {
							this.var_9b3 = new Class_4b3(6, 0, 0, 0, 0, 3158064, (Planet) null);
							this.var_9b3.var_26e = this.var_e29.somePlanet.sub_96();
							this.var_9b3.addMenu2Option(-1, this.var_9b3.yPos + 15,
									SomeUtilClass.getStr("НЕ ИССЛЕДОВАНО"), false);
						}
					}

					this.var_e29 = null;
				}

				this.gameActionState.fire = false;
			}

		}
	}

	public void sub_622() {
		if (this.var_b4d > 0) {
			this.var_b4d -= this.var_1d1;
		} else {
			if (this.gameActionState.up) {
				if (this.someYCellPos > 0) {
					--this.someYCellPos;
				}

				this.var_b4d = 250;
			}

			if (this.gameActionState.down) {
				if (this.someYCellPos < this.var_b9b - 1) {
					++this.someYCellPos;
				}

				this.var_b4d = 250;
			}

			if (this.gameActionState.left) {
				if (this.someXCellPos > 0) {
					--this.someXCellPos;
				}

				this.var_b4d = 250;
			}

			if (this.gameActionState.right) {
				if (this.someXCellPos < this.var_b9b - 1) {
					++this.someXCellPos;
				}

				this.var_b4d = 250;
			}

			if (this.gameActionState.fire && this.var_e29 == null) {
				this.sub_67a();
				this.gameActionState.fire = false;
			}

			if (this.gameActionState.num1) {
				if (this.var_9b3 == null && this.var_e29 == null && this.var_1029 == null) {
					this.var_9b3 = new Class_4b3(9, 0, 0, this.getWidth(), this.getHeight(), 0, (Planet) null);
				}

				this.gameActionState.num1 = false;
			}

			if (this.gameActionState.num3) {
				if (this.var_9b3 == null && this.var_e29 == null && this.var_1029 == null) {
					this.var_9b3 = new Class_4b3(10, 0, 0, this.getWidth(), this.getHeight(), 0, (Planet) null);
				}

				this.gameActionState.num3 = false;
			}

			if (this.gameActionState.num7) {
				if (this.var_9b3 == null && this.var_e29 == null && this.var_1029 == null) {
					this.sub_178d();
				}

				this.gameActionState.num7 = false;
			}

			if (this.gameActionState.num9) {
				if (this.var_9b3 == null && this.var_e29 == null && this.var_1029 == null) {
					this.sub_4b5(4);
				}

				this.gameActionState.num9 = false;
			}

		}
	}

	public void sub_650(Planet var1, int var2) {
		this.var_e29 = new Class_2ee(this.getHeight(), this.getWidth(), var1, var2, this.var_d5c);
		this.var_e29.var_218 = this.someXCellPos;
		this.var_e29.var_244 = this.someYCellPos;
	}

	public void sub_67a() {
		int var1 = this.sub_1592(this.someXCellPos, this.someYCellPos);
		Planet var2 = this.sub_76d(this.someXCellPos, this.someYCellPos);
		if (var1 > 0 && this.var_9b3 == null && this.sub_15d8(this.someXCellPos, this.someYCellPos, 1).var_27d) {
			this.sub_650(var2, var1);
		} else if (var2 == null && var1 == 0 && this.var_9b3 == null && this.var_e29 == null) {
			this.var_9b3 = new Class_4b3(2, (this.getWidth() - 94) / 2, (this.getHeight() - 92) / 2, 94, 92, 3158064,
					(Planet) null);
		} else {
			if (var2.sub_150(this.var_d5c.var_1c6)) {
				if (var2.var_1df == null || var2.var_1df != null && var2.var_1df.var_4f != this.var_d5c.var_1c6) {
					this.var_9b3 = new Class_4b3(1, (this.getWidth() - 82) / 2, (this.getHeight() - 72) / 2, 82, 72,
							3158064, var2);
				}

				if (var2.var_1df != null && var2.var_1df.var_4f == this.var_d5c.var_1c6) {
					this.var_9b3 = new Class_4b3(7, 0, 0, this.getWidth(), this.getHeight(), 3158064, var2);
				}
			}

		}
	}

	public boolean sub_6a1() {
		int var1 = this.someXCellPos * 20 - this.xMapBias + 10;
		int var2 = this.someYCellPos * 20 - this.yMapBias + 10;
		int var3 = this.xMapBias;
		int var4 = this.yMapBias;
		if (var1 - 1 > this.getWidth() / 2 && this.xMapBias < this.var_b9b * 20 - this.gameRect.xLen) {
			this.xMapBias += 3;
		}

		if (var1 + 1 < this.getWidth() / 2 && this.xMapBias > 0) {
			this.xMapBias -= 3;
		}

		if (var2 - 1 > this.getHeight() / 2 && this.yMapBias < this.var_b9b * 20 - this.gameRect.yLen) {
			this.yMapBias += 3;
		}

		if (var2 + 1 < this.getHeight() / 2 && this.yMapBias > 0) {
			this.yMapBias -= 3;
		}

		if (this.xMapBias < 0) {
			this.xMapBias = 0;
		}

		if (this.yMapBias < 0) {
			this.yMapBias = 0;
		}

		if (this.xMapBias == var3 && this.yMapBias == var4) {
			return false;
		} else {
			this.sub_f70(this.xMapBias - var3, this.yMapBias - var4);
			return true;
		}
	}

	public void sub_6e1() {
		this.gameActionState.numPound = false;
		if (this.var_19ae != null) {
			this.var_19ae = null;
			if (this.var_19fd == 0) {
				this.sub_22a8(1);
			}

		} else if (this.var_9b3 == null && this.var_e29 == null && this.var_1029 == null) {
			this.var_1490 = true;
		} else {
			if (this.var_9b3 != null && this.var_9b3.var_e5a != -1) {
				this.sub_22a8(this.var_9b3.var_e5a);
			}

			if (this.var_e29 != null && this.var_e29.var_e5a != -1) {
				this.sub_22a8(this.var_e29.var_e5a);
			}

			if (this.var_1029 != null && this.var_1029.var_e5a != -1) {
				this.sub_22a8(this.var_1029.var_e5a);
			}

		}
	}

	public void sub_6ec() {
		this.gameActionState.numStar = false;
		if (this.var_19ae != null) {
			this.var_19ae = null;
			if (this.var_19fd == 0) {
				this.sub_22a8(1);
			}

		} else if (this.var_1029 != null) {
			if (this.var_1029.var_1d8 != null) {
				this.var_1029.var_1d8 = null;
			} else {
				this.var_1029 = null;
			}
		} else {
			if (this.var_9b3 == null) {
				if (this.var_e29 == null) {
					this.var_9b3 = new Class_4b3(2, (this.getWidth() - 94) / 2, (this.getHeight() - 92) / 2, 94, 92,
							3158064, (Planet) null);
				} else if (this.var_e29.var_3c8 == 3) {
					this.var_e29.var_3c8 = 1;
					this.someXCellPos = this.var_e29.var_218;
					this.someYCellPos = this.var_e29.var_244;
				} else {
					this.var_e29 = null;
				}
			} else {
				if (this.var_9b3.menuId == 1) {
					this.var_9b3 = null;
					return;
				}

				if (this.var_9b3.menuId == 4) {
					int var1 = this.var_9b3.var_409;
					if (this.var_9b3.var_73e != null) {
						this.var_9b3.var_73e = null;
					} else if (this.var_9b3.var_79a != null) {
						this.var_9b3.var_79a = null;
					} else {
						this.sub_4b5(4);
						this.var_9b3.var_3c8 = var1;
						this.var_9b3.sub_bd();
					}

					return;
				}

				if (this.var_9b3.menuId == 7) {
					if (this.var_9b3.var_b77 != null) {
						this.var_9b3.var_b77 = null;
						return;
					}

					if (this.var_9b3.var_73e != null) {
						this.var_9b3.var_73e = null;
						return;
					}

					this.var_9b3 = null;
					return;
				}

				if (this.var_9b3.menuId == 9) {
					if (this.var_9b3.var_d47 == 10) {
						this.sub_1a71(0);
						return;
					}

					this.var_9b3 = null;
					return;
				}

				if (this.var_9b3.menuId == 10) {
					if (this.var_9b3.var_d47 == 10) {
						this.sub_1a92(this.var_9b3.var_3c8 + 1);
						return;
					}

					if (this.var_9b3.var_d47 == 1) {
						this.var_9b3.var_57d = null;
						this.var_9b3.var_d47 = 0;
						this.var_9b3.var_d8e = null;
						return;
					}

					if (this.var_9b3.var_b77 != null) {
						this.var_9b3.var_b77 = null;
						return;
					}

					this.var_9b3 = null;
					return;
				}

				if (this.var_9b3.menuId == 13) {
					if (this.var_9b3.var_b64) {
						this.var_9b3 = null;
						this.var_d5c.sub_675();
						if (this.var_d5c.var_6eb >= 0) {
							this.sub_19f8();
						}

						if (this.var_d5c.var_723) {
							this.var_d5c.var_723 = false;
							this.sub_178d();
						}
					}

					return;
				}

				if (this.var_9b3.menuId == 14) {
					this.sub_1a34();
					return;
				}

				if (this.var_9b3.menuId == 6 && (this.var_d5c.var_914 && this.sub_ad7() || this.var_d5c.var_96d)) {
					this.sub_b1a(this.var_d5c.var_96d);
				}

				this.var_9b3 = null;
			}

		}
	}

	public void keyPressed(int key) {
		if (this.introPainter != null) {
			this.introPainter.var_208 = true;
		} else if (key == Stars.thisStars.leftSoftKeyCode) {
			this.gameActionState.numStar = true;
		} else if (key == Stars.thisStars.rightSoftKeyCode) {
			this.gameActionState.numPound = true;
		} else {
			int var2 = this.getGameAction(key);
			if (var2 == 1) {
				this.gameActionState.up = true;
			}

			if (var2 == 6) {
				this.gameActionState.down = true;
			}

			if (var2 == 2) {
				this.gameActionState.left = true;
			}

			if (var2 == 5) {
				this.gameActionState.right = true;
			}

			if (var2 == 8) {
				this.gameActionState.fire = true;
			}

			if (key == 55) {
				this.gameActionState.num7 = true;
			}

			if (key == 57) {
				this.gameActionState.num9 = true;
			}

			if (key == 49) {
				this.gameActionState.num1 = true;
			}

			if (key == 51) {
				this.gameActionState.num3 = true;
			}

			if (key == 42) {
				this.gameActionState.numStar = true;
			}

			if (key == 35) {
				this.gameActionState.numPound = true;
			}

			if (!this.var_12a6 && this.var_31a == 1) {
				if (this.var_19ae != null) {
					return;
				}

				if (this.var_9b3 != null && var2 != 8 && this.var_9b3.menuId != 9) {
					this.sub_509();
				}

				if (this.var_1029 != null && var2 != 8) {
					this.sub_580();
				}
			}

		}
	}

	public void keyReleased(int key) {
		if (key == 55) {
			this.gameActionState.num7 = false;
		}

		if (key == 57) {
			this.gameActionState.num9 = false;
		}

		if (key == 49) {
			this.gameActionState.num1 = false;
		}

		if (key == 51) {
			this.gameActionState.num3 = false;
		}

		this.var_b4d = 0;
		int gameAction = this.getGameAction(key);
		if (gameAction == 1) {
			this.gameActionState.up = false;
		}

		if (gameAction == 6) {
			this.gameActionState.down = false;
		}

		if (gameAction == 2) {
			this.gameActionState.left = false;
		}

		if (gameAction == 5) {
			this.gameActionState.right = false;
		}

		if (gameAction == 8) {
			this.gameActionState.fire = false;
		}

	}

	public void run() {
		int var1 = 0;
		Graphics g = this.getGraphics();
		long var5 = 0L;

		while (this.var_138) {
			long var7 = System.currentTimeMillis();
			if (this.var_188) {
				this.var_188 = false;
				this.sub_9e3();
			}

			if (this.var_1a6) {
				if (this.var_d5) {
					this.unloadImagesAndGc();
					this.var_90 = true;
				}

				this.var_1a6 = false;
				this.sub_979();
				if (this.musicManager != null) {
					// here set music for all game
					this.musicManager.changeMusicId(3);
				}
			}

			if (this.var_1490) {
				this.sub_b75();
				this.var_1490 = false;
			}

			if (this.var_14c8) {
				for (int var9 = 0; var9 < 115; ++var9) {
					this.sub_b75();
				}

				this.var_14c8 = false;
			}

			if (!this.var_e) {
				this.maybeMainDrawingMethod(g);
			}

			++var1;
			if (var1 > 50) {
				System.gc();
				var1 = 0;
				this.var_9e = var5 / 50L;
				var5 = 0L;
			}

			try {
				long var3 = System.currentTimeMillis() - var7;
				var5 += var3;
				if (var3 < (long) this.var_1d1) {
					Thread.sleep((long) this.var_1d1 - var3);
				} else {
					Thread.yield();
				}
			} catch (InterruptedException e) {
			}
		}

	}

	public int sub_718(int var1) {
		int var2 = 0;
		int var3 = 0;
		if (this.planetsArr == null) {
			return 0;
		} else {
			for (int var5 = 0; var5 < this.planetsArr.size(); ++var5) {
				Planet var4 = (Planet) this.planetsArr.elementAt(var5);
				if (var4.var_1df != null && var4.var_1df.var_4f == var1) {
					var2 += var4.var_1df.var_19d;
					++var3;
				}
			}

			return var2 / var3;
		}
	}

	public Planet sub_76d(int var1, int var2) {
		if (this.planetsArr == null) {
			return null;
		} else {
			for (int var4 = 0; var4 < this.planetsArr.size(); ++var4) {
				Planet var3 = (Planet) this.planetsArr.elementAt(var4);
				if (var3.getXAbsoluteSector() == var1 && var3.getYAbsoluteSector() == var2) {
					return var3;
				}
			}

			return null;
		}
	}

	public Planet sub_78d(int var1) {
		if (this.planetsArr == null) {
			return null;
		} else {
			for (int var3 = 0; var3 < this.planetsArr.size(); ++var3) {
				Planet var2 = (Planet) this.planetsArr.elementAt(var3);
				if (var2.planetCoords == var1) {
					return var2;
				}
			}

			return null;
		}
	}

	public int sub_7b7(Class_2a9 var1) {
		int var2 = 0;
		if (this.planetsArr == null) {
			return 0;
		} else {
			for (int var4 = 0; var4 < this.planetsArr.size(); ++var4) {
				Planet var3 = (Planet) this.planetsArr.elementAt(var4);
				if (var3.var_1df != null && var3.var_1df.var_4f == var1.var_1c6) {
					++var2;
				}
			}

			return var2;
		}
	}

	public int sub_7d3(Class_2a9 var1) {
		int var2 = 0;
		if (this.planetsArr == null) {
			return 0;
		} else {
			for (int var4 = 0; var4 < this.planetsArr.size(); ++var4) {
				Planet var3 = (Planet) this.planetsArr.elementAt(var4);
				if (var3.var_1df != null && var3.var_1df.var_4f == var1.var_1c6) {
					var2 += var3.var_1df.getCurrentPopulation();
				}
			}

			return var2;
		}
	}

	public int sub_80b(Class_2a9 var1) {
		int var2 = 0;
		if (this.planetsArr == null) {
			return 0;
		} else {
			for (int var4 = 0; var4 < this.planetsArr.size(); ++var4) {
				Planet var3 = (Planet) this.planetsArr.elementAt(var4);
				if (var3.var_1df != null && var3.var_1df.var_4f == var1.var_1c6) {
					var2 += var3.var_1df.sub_125();
				}
			}

			return var2;
		}
	}

	public Planet sub_862(Class_2a9 var1, int var2) {
		int var3 = 0;
		if (this.planetsArr == null) {
			return null;
		} else {
			for (int var5 = 0; var5 < this.planetsArr.size(); ++var5) {
				Planet var4 = (Planet) this.planetsArr.elementAt(var5);
				if (var4.var_1df != null && var4.var_1df.var_4f == var1.var_1c6) {
					++var3;
				}

				if (var3 == var2) {
					return var4;
				}
			}

			return null;
		}
	}

	public Planet sub_8b2(Planet var1) {
		if (this.planetsArr == null) {
			return null;
		} else {
			boolean var3 = false;

			Planet var2;
			int var5;
			for (var5 = 0; var5 < this.planetsArr.size(); ++var5) {
				var2 = (Planet) this.planetsArr.elementAt(var5);
				if (var2.getXAbsoluteSector() == var1.getXAbsoluteSector() && var2.getYAbsoluteSector() == var1.getYAbsoluteSector()) {
					++var5;
					break;
				}
			}

			int var4 = 0;

			do {
				if (var5 >= this.planetsArr.size()) {
					var5 = 0;
				}

				var2 = (Planet) this.planetsArr.elementAt(var5);
				if (var2.var_1df != null && var2.var_1df.var_4f == var1.var_1df.var_4f) {
					return var2;
				}

				++var5;
				++var4;
			} while (var4 <= 5000);

			return var1;
		}
	}

	public Planet sub_8e6(Planet var1) {
		if (this.planetsArr == null) {
			return null;
		} else {
			boolean var3 = false;

			Planet var2;
			int var5;
			for (var5 = 0; var5 < this.planetsArr.size(); ++var5) {
				var2 = (Planet) this.planetsArr.elementAt(var5);
				if (var2.getXAbsoluteSector() == var1.getXAbsoluteSector() && var2.getYAbsoluteSector() == var1.getYAbsoluteSector()) {
					--var5;
					break;
				}
			}

			int var4 = 0;

			do {
				if (var5 < 0) {
					var5 = this.planetsArr.size() - 1;
				}

				var2 = (Planet) this.planetsArr.elementAt(var5);
				if (var2.var_1df != null && var2.var_1df.var_4f == var1.var_1df.var_4f) {
					return var2;
				}

				--var5;
				++var4;
			} while (var4 <= 5000);

			return var1;
		}
	}

	public int sub_920(int var1) {
		if (this.planetsArr == null) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < this.planetsArr.size(); ++var4) {
				Planet var2 = (Planet) this.planetsArr.elementAt(var4);
				if (var2.var_1df != null && var2.var_1df.var_4f == var1) {
					var3 += var2.sub_406();
				}
			}

			return var3;
		}
	}

	public int sub_931(int var1) {
		int var2 = 0;
		if (this.var_da5 == null) {
			return 0;
		} else {
			for (int var4 = 0; var4 < this.var_da5.size(); ++var4) {
				Class_4f2 var3 = (Class_4f2) this.var_da5.elementAt(var4);
				if (var3.sub_236() == var1) {
					if (var3.sub_18d(28) == 5) {
						var2 += 2;
					} else {
						var2 += var3.sub_18d(28) + 1;
					}
				}
			}

			return var2;
		}
	}

	public void sub_979() {
		this.var_31a = 3;
		this.var_9b3 = new Class_4b3(15, 0, 0, this.getWidth(), this.getHeight(), 0, (Planet) null);
		if (this.var_d5) {
			this.var_9b3.var_1f3 = 300;
		}

	}

	public void sub_99b() {
		if (this.var_9b3 != null) {
			if (this.var_b4d > 0) {
				this.var_b4d -= this.var_1d1;
			} else {
				if (this.gameActionState.up) {
					this.var_9b3.sub_140();
					this.var_b4d = 250;
					this.gameActionState.up = false;
				}

				if (this.gameActionState.down) {
					this.var_9b3.sub_18d();
					this.var_b4d = 250;
					this.gameActionState.down = false;
				}

				if (this.gameActionState.right) {
					this.var_9b3.sub_197();
					this.var_b4d = 250;
					this.gameActionState.right = false;
				}

				if (this.gameActionState.left) {
					this.var_9b3.sub_1ea();
					this.var_b4d = 250;
					this.gameActionState.left = false;
				}

				if (!this.var_1730 || !this.gameActionState.numStar && !this.gameActionState.numPound
						&& !this.gameActionState.fire) {
					if (this.var_1759 > 0) {
						++this.var_1759;
						if (this.var_17a7 < this.var_1759 || this.gameActionState.fire || this.gameActionState.numStar
								|| this.gameActionState.numPound) {
							if (!this.var_fa3) {
								this.var_9b3 = null;
								this.var_188 = true;
							} else {
								this.var_9b3.var_1f3 = 0;
								this.var_fa3 = false;
							}

							this.gameActionState.clearAllStates();
							this.var_1759 = 0;
							this.var_1807 = "";
							return;
						}
					}

					if (this.var_173f) {
						if (this.gameActionState.numStar) {
							this.var_173f = false;
							this.var_9b3.var_3c8 = this.var_9b3.menuOptions2Arr.size() - 5;
						}

						if (this.gameActionState.numPound) {
							this.var_1759 = 1;
							this.var_173f = false;
							this.sub_22c9();
							this.var_17a7 = SomeUtilClass.sub_1a5(this.var_1807, this.getWidth() - 10);
							this.var_17a7 = this.var_17a7 * 9 + this.getHeight();
						}

						if (this.gameActionState.fire) {
							this.sub_9b3();
						}

						this.gameActionState.numStar = false;
						this.gameActionState.numPound = false;
						this.gameActionState.fire = false;
					} else {
						if (this.gameActionState.fire) {
							this.var_b4d = 250;
							if (this.var_9b3.var_b77 != null) {
								if (this.var_9b3.var_b77.var_3c8 == 2) {
									this.var_9b3.var_b77 = null;
									this.sub_1bcc();
									if (this.var_169a) {
										if (this.musicManager == null) {
											this.musicManager = new MusicManager();
											this.musicManager.start();
											this.musicManager.changeMusicId(1);
										}
									} else if (this.musicManager != null) {
										this.musicManager.sub_19();
										this.musicManager = null;
									}
								} else if (this.var_9b3.var_b77.var_3c8 == 0) {
									this.var_169a = !this.var_169a;
								} else if (this.var_9b3.var_b77.var_3c8 == 1) {
									this.var_16d3 = !this.var_16d3;
								}

								this.gameActionState.fire = false;
								return;
							}

							if (!this.var_9b3.var_b03) {
								this.var_9b3.var_1f3 = 300;
								this.gameActionState.fire = false;
								return;
							}

							int var1 = this.var_9b3.var_3c8;
							if (this.var_9b3.menuOptions2Arr.size() == 5) {
								++var1;
							}

							switch (var1) {
							case 0:
								this.var_9b3 = null;
								this.gameActionState.fire = false;
								this.gcAndSleep();
								if (this.var_d5) {
									this.loadSomeImages();
									this.var_31a = 1;
								} else {
									this.sub_1c60();
								}

								return;
							case 1:
								this.var_173f = true;
								this.gameActionState.fire = false;
								this.var_9b3.var_bdb = 0;
								this.var_1819 = new Class_2a9(100, 0, 0);
								this.var_1819.playerGroupName = SomeUtilClass.getStr("ВОЛЬНЫЕ");
								this.var_9b3.var_3c8 = 0;
								this.var_186d = 3;
								this.var_1899 = 1;
								return;
							case 2:
								this.var_9b3.var_b77 = new Class_4b3(21, (this.getWidth() - 110) / 2,
										(this.getHeight() - 54) / 2, 110, 54, 3158064, (Planet) null);
								this.var_9b3.var_b77.var_1f3 = 110;
								this.gameActionState.fire = false;
								return;
							case 3:
								this.var_1730 = true;
								this.gameActionState.fire = false;
								return;
							case 4:
								this.gameActionState.fire = false;
								Stars.thisStars.sub_7d();
								return;
							case 5:
								this.var_31a = 0;
								this.var_9b3 = null;
								this.sub_274();
								Stars.thisStars.sub_5f();
								return;
							}
						}

					}
				} else {
					this.var_1730 = false;
					this.gameActionState.numStar = false;
					this.gameActionState.numPound = false;
					this.gameActionState.fire = false;
				}
			}
		}
	}

	public void sub_9b3() {
		switch (this.var_9b3.var_3c8) {
		case 0:
			if (this.var_9b3.var_79a == null) {
				this.var_9b3.var_79a = new Class_18c(SomeUtilClass.getStr("ИМЯ"), (this.getWidth() - 106) / 2,
						(this.getHeight() - 32) / 2, this.var_1819.playerGroupName, 3158064);
			} else {
				this.var_9b3.var_79a.var_6d = this.var_9b3.var_79a.var_6d.trim();
				this.var_1819.playerGroupName = this.var_9b3.var_79a.var_6d;
				this.var_9b3.var_79a = null;
			}
			break;
		case 1:
			if (this.var_1819.var_8c < Class_2a9.var_29.length - 1) {
				++this.var_1819.var_8c;
			} else {
				this.var_1819.var_8c = 0;
			}
			break;
		case 2:
			if (this.var_186d < 5) {
				++this.var_186d;
			} else {
				this.var_186d = 1;
			}
			break;
		case 3:
			if (this.var_1899 < 2) {
				++this.var_1899;
			} else {
				this.var_1899 = 0;
			}
			break;
		case 4:
			this.var_1759 = 1;
			this.var_173f = false;
			this.sub_22c9();
			this.var_17a7 = SomeUtilClass.sub_1a5(this.var_1807, this.getWidth() - 10);
			this.var_17a7 = this.var_17a7 * 9 + this.getHeight();
		}

	}

	public void sub_9e3() {
		this.var_d5c = null;
		this.var_d39 = null;
		this.planetsArr = null;
		this.var_da5 = null;
		this.var_dc6 = null;
		this.gcAndSleep();
		if (this.buttonImg == null) {
			this.loadSomeImages();
		}

		this.var_dc6 = new Vector();
		this.var_d39 = new Vector();
		this.var_d5c = new Class_2a9(100, 0, 0);
		this.var_d5c.var_8c = this.var_1819.var_8c;
		this.var_d5c.playerGroupName = this.var_1819.playerGroupName;
		this.var_d39.addElement(this.var_d5c);
		this.var_190d = this.var_1899;
		Random var1 = new Random();
		int var2 = 100 + this.var_190d * 100;

		for (int var3 = 0; var3 < this.var_186d; ++var3) {
			int var4 = var3;
			if (this.var_186d < 5) {
				do {
					var4 = Math.abs(var1.nextInt() % 5);
				} while (this.sub_a39(SomeUtilClass.enemyNamesArr[var4]));
			}

			this.var_d5c = new Class_2a9(var2, var4 + 1, var3 + 1);
			this.var_d5c.var_47e = true;
			this.var_d5c.playerGroupName = SomeUtilClass.enemyNamesArr[var4];
			this.var_d5c.var_8c = (byte) Math.abs(var1.nextInt() % 4);
			if (this.var_d5c.var_8c == 0) {
				if (Math.abs(var1.nextInt() % 2) == 0) {
					this.var_d5c.var_3d2 = true;
				}

				if (Math.abs(var1.nextInt() % 2) == 0) {
					this.var_d5c.var_430 = true;
				}
			}

			this.var_d39.addElement(this.var_d5c);
		}

		this.xMapBias = 0;
		this.yMapBias = 0;
		this.someXCellPos = 0;
		this.someYCellPos = 0;
		this.var_31a = 1;
		this.sub_ebc(30);
		this.var_d5c = (Class_2a9) this.var_d39.elementAt(0);
		this.gameCurrentMonth = 1;
		this.gameCurrentYear = 2023;
		this.sub_a50();
		this.var_1c3c = true;
		this.var_d5 = true;
	}

	public boolean sub_a39(String var1) {
		for (int var3 = 0; var3 < this.var_d39.size(); ++var3) {
			Class_2a9 var2 = (Class_2a9) this.var_d39.elementAt(var3);
			if (var2.playerGroupName == var1) {
				return true;
			}
		}

		return false;
	}

	public void sub_a50() {
		this.someXCellPos2 = 0;
		this.someYCellPos2 = 0;
		this.someXCellPos = this.var_d5c.var_277;
		this.someYCellPos = this.var_d5c.var_2c3;
		this.sub_1392();
		this.sub_13fa(this.var_d5c);
		this.sub_1ce5();
		this.var_f42 = true;
		this.var_d5c.var_96d = this.sub_a7c();
		if (this.var_d5c.var_47e) {
			this.sub_b9c();
			this.var_d5c.sub_675();
			if (!var_73) {
				this.sub_b75();
			}
		} else {
			this.var_1c2f = false;
			if (this.sub_7b7(this.var_d5c) == 0) {
				this.var_d5c.var_914 = true;
			}
		}

	}

	public boolean sub_a7c() {
		for (int var1 = 0; var1 < this.var_d39.size(); ++var1) {
			Class_2a9 var2 = (Class_2a9) this.var_d39.elementAt(var1);
			if (var2.var_1c6 != this.var_d5c.var_1c6 && this.sub_7b7(var2) > 0) {
				return false;
			}
		}

		return true;
	}

	public boolean sub_ad7() {
		int var1 = 0;

		for (int var2 = 0; var2 < this.var_d39.size(); ++var2) {
			Class_2a9 var3 = (Class_2a9) this.var_d39.elementAt(var2);
			if (!var3.var_47e && !var3.var_914) {
				++var1;
			}
		}

		return var1 == 0;
	}

	public void sub_b1a(boolean var1) {
		this.var_1a6 = true;
		this.var_90 = false;
		this.var_d5 = false;
		SomeUtilClass.deleteRecordFromStore("PLAYERS");
		this.var_1759 = 1;
		String var2 = SomeUtilClass.loadDictionaryFile(this, "intro");
		if (var1) {
			this.var_1807 = SomeUtilClass.sub_106(var2, "I1");
		} else {
			this.var_1807 = SomeUtilClass.sub_106(var2, "I2");
		}

		this.var_17a7 = SomeUtilClass.sub_1a5(this.var_1807, this.getWidth() - 10);
		this.var_17a7 = this.var_17a7 * 9 + this.getHeight();
		this.var_fa3 = true;
	}

	public void sub_b75() {
		if (!this.var_d5c.var_47e) {
			this.var_153f = false;
		}

		this.var_d5c.var_277 = this.someXCellPos;
		this.var_d5c.var_2c3 = this.someYCellPos;

		for (int var2 = 0; var2 < this.var_d39.size(); ++var2) {
			Class_2a9 var1 = (Class_2a9) this.var_d39.elementAt(var2);
			if (var1.var_1c6 == this.var_d5c.var_1c6) {
				if (var2 == this.var_d39.size() - 1) {
					this.var_d5c = (Class_2a9) this.var_d39.elementAt(0);
					this.sub_bdf();
				} else {
					this.var_d5c = (Class_2a9) this.var_d39.elementAt(var2 + 1);
				}
				break;
			}
		}

		this.sub_a50();
	}

	public void sub_b9c() {
		if (this.planetsArr != null) {
			this.var_d5c.var_7e2 = false;
			this.sub_2057(this.var_d5c);
			this.sub_2029(this.var_d5c);
			this.sub_200f(this.var_d5c);
			this.sub_20cc(this.var_d5c);

			for (int var2 = 0; var2 < this.planetsArr.size(); ++var2) {
				Planet var1 = (Planet) this.planetsArr.elementAt(var2);
				if (var1.var_1df != null && var1.var_1df.var_4f == this.var_d5c.var_1c6) {
					if (this.var_d5c.var_7e2) {
						if (var1.var_1df.jobId < 4095) {
							var1.var_1df.jobId = 4095 + var1.sub_5b2();
						}
					} else if (var1.var_1df.jobId == 511 || var1.var_1df.jobId == 255) {
						var1.sub_60d();
					}

					var1.sub_661();
				}
			}

			if (lampImg != null) {
				this.var_153f = !this.var_153f;
				this.sub_30b(this.getGraphics());
				this.flushGraphics();
			}

		}
	}

	public void sub_bdf() {
		Class_4f2 var1 = null;
		Planet var2 = null;
		Object var3 = null;
		int var5;
		if (this.planetsArr != null) {
			for (var5 = 0; var5 < this.planetsArr.size(); ++var5) {
				var2 = (Planet) this.planetsArr.elementAt(var5);
				var2.sub_470();
			}
		}

		Class_2a9 var4;
		int var6;
		if (this.var_da5 != null) {
			for (var5 = 0; var5 < this.var_da5.size(); ++var5) {
				var1 = (Class_4f2) this.var_da5.elementAt(var5);
				if (var1.sub_599() && this.sub_1716(var1.sub_309(), var1.sub_31a(), var1.sub_362(), var1.sub_3a1(),
						var1.sub_236())) {
					var1.sub_2c4(var1.sub_362(), var1.sub_3a1());
				}

				var1.sub_5d2();
				var2 = this.sub_76d(var1.sub_309(), var1.sub_31a());
				if (var2 != null) {
					if (!var2.sub_150(var1.sub_236())) {
						var2.sub_181(var1.sub_236());
						var4 = this.sub_122a(var1.sub_236());
						if (var4 != null) {
							var4.sub_640(7, var2.planetCoords, "");
						}
					}

					if (var2.var_1df != null) {
						if (var2.var_1df.var_4f == var1.sub_236()) {
							if (var1.var_195 > 0) {
								var1.sub_f0();
								var4 = this.sub_122a(var1.sub_236());
								if (var4.sub_e8(4)) {
									var1.var_195 = 0;
								}
							}
						} else if (!this.sub_c40(var2)) {
							this.sub_bfc(var1.sub_309(), var1.sub_31a(), var1.sub_236(), var2.var_1df.var_4f);
						}
					}

					var6 = this.sub_17e8(var2);
					if (var6 >= 0 && var6 < 10) {
						var4 = this.sub_122a(var1.sub_236());
						if (var4 != null) {
							var4.sub_2c0(var6);
							var4.sub_640(8, var2.planetCoords, "");
						}

						this.artifactsDictArr[var6].var_1c1 = 0;
						this.artifactsDictArr[var6].var_68 = var2.sub_96();
					}
				}
			}
		}

		for (var5 = 0; var5 < this.var_d39.size(); ++var5) {
			var4 = (Class_2a9) this.var_d39.elementAt(var5);
			var6 = this.sub_dda(var4);
			var4.var_f6 += var6;
			this.sub_21e9(var4, var6);
			var4.var_605 += this.sub_d38(var4);
			var4.sub_367(this.sub_d73(var4));
		}

		++this.gameCurrentMonth;
		if (this.gameCurrentMonth == 13) {
			++this.gameCurrentYear;
			this.gameCurrentMonth = 1;
		}

		this.sub_c7e();
	}

	public void sub_bfc(int var1, int var2, int var3, int var4) {
		int var5 = this.sub_1592(var1, var2);

		for (int var7 = 0; var7 < var5; ++var7) {
			Class_4f2 var6 = this.sub_15d8(var1, var2, var7 + 1);
			if (var6.sub_236() == var4) {
				var6.sub_12d(var3);
			}
		}

		Planet var9 = this.sub_76d(var1, var2);
		if (var9 != null && var9.var_1df != null && var9.var_1df.var_4f == var4) {
			var9.var_1df.var_4f = var3;
			var9.var_1df.var_178 = 0;
			var9.var_1df.var_19d /= 2;
			Class_2a9 var8 = this.sub_122a(var3);
			if (var8 != null) {
				var8.sub_640(9, var9.planetCoords, "");
			}

			var8 = this.sub_122a(var4);
			if (var8 != null) {
				var8.sub_640(10, var9.planetCoords, "");
			}
		}

	}

	public boolean sub_c40(Planet var1) {
		int var2 = 0;
		int var3 = this.sub_1592(var1.getXAbsoluteSector(), var1.getYAbsoluteSector());

		for (int var4 = 0; var4 < var3; ++var4) {
			Class_4f2 var5 = this.sub_15d8(var1.getXAbsoluteSector(), var1.getYAbsoluteSector(), var4 + 1);
			if (var5.sub_236() == var1.var_1df.var_4f) {
				var2 += var5.sub_582();
			}
		}

		if (var2 > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean sub_c7e() {
		this.var_143d = null;
		if (this.var_da5 != null) {
			for (int var2 = 0; var2 < this.var_da5.size(); ++var2) {
				Class_4f2 var1 = (Class_4f2) this.var_da5.elementAt(var2);
				int var3 = this.sub_1588(var1);
				if (var3 >= 0) {
					if (this.sub_c8f(var1.sub_309(), var1.sub_31a(), var1.sub_236(), var3)) {
						this.var_143d = new SomeBattleClass(true, var1.sub_309(), var1.sub_31a(), var1.sub_236(), var3);
					} else {
						this.var_143d = new SomeBattleClass(true, var1.sub_309(), var1.sub_31a(), var3, var1.sub_236());
					}

					return true;
				}
			}
		}

		return false;
	}

	public boolean sub_c8f(int var1, int var2, int var3, int var4) {
		int var5 = 0;
		int var6 = 0;
		int var7 = gameScreen.sub_1592(var1, var2);
		Planet var8 = this.sub_76d(var1, var2);
		if (var8 != null && var8.var_1df != null) {
			if (var8.var_1df.var_4f == var3) {
				return false;
			}

			if (var8.var_1df.var_4f == var4) {
				return true;
			}
		}

		for (int var10 = 0; var10 < var7; ++var10) {
			Class_4f2 var9 = gameScreen.sub_15d8(var1, var2, var10 + 1);
			if (var9.sub_236() == var3) {
				var5 += this.attackSpeedItemsArr[var9.sub_18d(24)].statValue;
			}

			if (var9.sub_236() == var4) {
				var6 += this.attackSpeedItemsArr[var9.sub_18d(24)].statValue;
			}
		}

		return var5 > var6;
	}

	public int sub_cd0(int var1) {
		if (var1 >= 0 && var1 < 255) {
			return this.var_fc9[var1].var_16;
		} else {
			return var1 >= 255 && var1 < this.artifactsDictArr.length + 255 ? this.artifactsDictArr[var1 - 255].var_175 : 0;
		}
	}

	public int sub_d1d(Class_2a9 var1, int var2, int var3) {
		boolean var4 = true;
		boolean var5 = false;
		int var7 = this.sub_cd0(var2) - var1.var_605;
		if (var7 <= 0) {
			return 1;
		} else if (var3 == 0) {
			return 999;
		} else {
			int var6 = var7 / var3;
			if (var6 == 0 || var6 * var3 < var7) {
				++var6;
			}

			return var6;
		}
	}

	public int sub_d38(Class_2a9 var1) {
		return this.sub_dbc(var1) * var1.var_622 / 100;
	}

	public int sub_d73(Class_2a9 var1) {
		return this.sub_dbc(var1) * (100 - var1.var_622) / 100;
	}

	public int sub_dbc(Class_2a9 var1) {
		int var2 = 0;
		if (this.planetsArr != null) {
			for (int var4 = 0; var4 < this.planetsArr.size(); ++var4) {
				Planet var3 = (Planet) this.planetsArr.elementAt(var4);
				if (var3.var_1df != null && var3.var_1df.var_4f == var1.var_1c6) {
					var2 += var3.sub_36e(var1);
				}
			}
		}

		return var2;
	}

	public int sub_dda(Class_2a9 var1) {
		if (!this.var_f42) {
			return this.var_f80;
		} else {
			this.var_f80 = this.sub_e1f(var1) - this.sub_e6e(var1);
			return this.var_f80;
		}
	}

	public int sub_e1f(Class_2a9 var1) {
		int var2 = 0;
		if (this.planetsArr != null) {
			for (int var4 = 0; var4 < this.planetsArr.size(); ++var4) {
				Planet var3 = (Planet) this.planetsArr.elementAt(var4);
				if (var3.var_1df != null && var3.var_1df.var_4f == var1.var_1c6) {
					var2 += var3.sub_391(var1);
				}
			}
		}

		return var2;
	}

	public int sub_e6e(Class_2a9 var1) {
		int var2 = 0;
		int var4;
		if (this.planetsArr != null) {
			for (var4 = 0; var4 < this.planetsArr.size(); ++var4) {
				Planet var3 = (Planet) this.planetsArr.elementAt(var4);
				if (var3.var_1df != null && var3.var_1df.var_4f == var1.var_1c6) {
					var2 += var3.sub_3ef();
				}
			}
		}

		var4 = this.sub_931(var1.var_1c6);
		int var5 = this.sub_920(var1.var_1c6);
		if (var4 <= var5) {
			var2 += var4;
		} else {
			var2 += var5;
			var2 += (var4 - var5) * 3;
		}

		return var2;
	}

	public void sub_ebc(int var1) {
		boolean[] var2 = new boolean[36];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			var2[var3] = false;
		}

		this.var_d05 = 0;
		this.var_d0f = new SomeThreadPainterClass(this.getGraphics());
		this.var_d0f.start();
		boolean var13 = false;
		this.var_b9b = var1;
		Random var6 = null;
		var6 = new Random();
		this.planetsArr = new Vector();
		int var8 = var1 * 2;
		this.sub_f61();

		Planet var7;
		int var10;
		for (var10 = 0; var10 < var8; ++var10) {
			this.var_d05 = 100 * var10 / var8;
			int var4 = Math.abs(var6.nextInt() % (var1 - 2)) + 1;
			int var5 = Math.abs(var6.nextInt() % (var1 - 2)) + 1;
			if (var4 == 0) {
				++var4;
			}

			if (var5 == 0) {
				++var5;
			}

			var13 = false;

			int var12;
			for (int var11 = var4 - 2; var11 <= var4 + 2; ++var11) {
				for (var12 = var5 - 2; var12 <= var5 + 2; ++var12) {
					if (this.sub_76d(var11, var12) != null) {
						var13 = true;
						break;
					}
				}
			}

			if (!var13) {
				boolean var14 = true;

				for (var12 = 0; var12 < 36; ++var12) {
					if (!var2[var12]) {
						var14 = false;
						break;
					}
				}

				int var9;
				if (var14) {
					var9 = -1;
				} else {
					var9 = Math.abs(var6.nextInt() % 36);

					while (var2[var9]) {
						++var9;
						if (var9 >= 36) {
							var9 = 0;
						}
					}

					var2[var9] = true;
				}

				var7 = new Planet(var6.nextInt() % 9, var4, var5, var9);
				var7.sub_3a();
				if (var9 == -1) {
					var7.sub_ab("ЗВЕЗДА" + var10);
				}

				this.planetsArr.addElement(var7);
			}
		}

		for (var10 = 0; var10 < 10 && this.planetsArr.size() > var10 + this.var_d39.size(); ++var10) {
			var7 = (Planet) this.planetsArr.elementAt(var10 + this.var_d39.size());
			this.artifactsDictArr[var10].var_1c1 = var7.planetCoords;
		}

		for (var10 = 0; var10 < this.var_d39.size(); ++var10) {
			var7 = (Planet) this.planetsArr.elementAt(var10);
			this.var_d5c = (Class_2a9) this.var_d39.elementAt(var10);
			var7.sub_181(this.var_d5c.var_1c6);
			var7.var_1df = new Class_139(this.var_d5c.var_1c6);
			var7.var_9b = 0;
			var7.var_e5 = SomeUtilClass.sub_73(0);
			var7.sub_3a();
			this.var_d5c.var_277 = var7.getXAbsoluteSector();
			this.var_d5c.var_2c3 = var7.getYAbsoluteSector();
			this.sub_14a6(this.var_d5c, 0, var7.getXAbsoluteSector(), var7.getYAbsoluteSector(), false);
			this.sub_14a6(this.var_d5c, 0, var7.getXAbsoluteSector(), var7.getYAbsoluteSector(), false);
			this.sub_14a6(this.var_d5c, 1, var7.getXAbsoluteSector(), var7.getYAbsoluteSector(), false);
			this.sub_14a6(this.var_d5c, 2, var7.getXAbsoluteSector(), var7.getYAbsoluteSector(), false);
			this.sub_1527(this.var_d5c, var7.getXAbsoluteSector(), var7.getYAbsoluteSector());
		}

		this.var_d05 = 100;
		this.var_d0f = null;
		this.sub_f01();
	}

	public void sub_f01() {
		if (this.var_15fe == null) {
			this.var_15fe = new boolean[this.var_b9b][this.var_b9b];
		}

		for (int var1 = 0; var1 < this.var_b9b; ++var1) {
			for (int var2 = 0; var2 < this.var_b9b; ++var2) {
				this.var_15fe[var1][var2] = this.sub_76d(var1, var2) != null;
			}
		}

	}

	public boolean sub_f16(int var1, int var2) {
		return var1 >= 0 && var2 >= 0 && var1 < this.var_b9b && var2 < this.var_b9b ? this.var_15fe[var1][var2] : false;
	}

	public void sub_f61() {
		for (int var1 = 0; var1 < 60; ++var1) {
			this.var_bfd[var1] = Math.abs(this.random.nextInt() % this.getWidth());
			this.var_bfd[var1] |= Math.abs(this.random.nextInt() % this.getHeight()) << 12;
			if (Math.abs(this.random.nextInt() % 15) == 1) {
				this.var_bfd[var1] |= Math.abs(this.random.nextInt() % 2) + 3 << 24;
			} else {
				this.var_bfd[var1] |= Math.abs(this.random.nextInt() % 2) << 24;
			}
		}

	}

	public void sub_f70(int var1, int var2) {
		for (int var6 = 0; var6 < 60; ++var6) {
			int var3 = this.var_bfd[var6] & 4095;
			int var4 = this.var_bfd[var6] >> 12 & 4095;
			int var5 = this.var_bfd[var6] >> 24 & 15;
			if (var5 <= 1) {
				var3 -= var1 / 3 * (var5 + 1);
				var4 -= var2 / 3 * (var5 + 1);
			} else {
				var3 -= var1 / 3;
				var4 -= var2 / 3;
			}

			if (var3 < 0) {
				var3 = this.getWidth();
				var4 = Math.abs(this.random.nextInt() % this.getHeight());
				var5 = Math.abs(this.random.nextInt() % 2);
				if (Math.abs(this.random.nextInt() % 15) == 1) {
					var5 += 3;
				}
			} else if (var4 < 0) {
				var3 = Math.abs(this.random.nextInt() % this.getWidth());
				var4 = this.getHeight();
				var5 = Math.abs(this.random.nextInt() % 2);
				if (Math.abs(this.random.nextInt() % 15) == 1) {
					var5 += 3;
				}
			} else if (var3 > this.getWidth()) {
				var3 = 0;
				var4 = Math.abs(this.random.nextInt() % this.getHeight());
				var5 = Math.abs(this.random.nextInt() % 2);
				if (Math.abs(this.random.nextInt() % 15) == 1) {
					var5 += 3;
				}
			} else if (var4 > this.getHeight()) {
				var3 = Math.abs(this.random.nextInt() % this.getWidth());
				var4 = 0;
				var5 = Math.abs(this.random.nextInt() % 2);
				if (Math.abs(this.random.nextInt() % 15) == 1) {
					var5 += 3;
				}
			}

			this.var_bfd[var6] = var3;
			this.var_bfd[var6] |= var4 << 12;
			this.var_bfd[var6] |= var5 << 24;
		}

	}

	public int sub_fcf(Graphics var1, int var2, int var3, String var4, Image var5) {
		int var6 = var4.length();

		for (int var9 = 0; var9 < var6; ++var9) {
			char var7 = var4.charAt(var9);
			int var8;
			if (var7 >= 1040 && var7 <= 1071) {
				var8 = var7 - 1040;
				if (var8 <= 15) {
					var1.setClip(var2, var3, 5, 5);
					var1.drawImage(var5, var2 - var8 * 5, var3, 20);
				} else {
					var1.setClip(var2, var3, 5, 6);
					var1.drawImage(var5, var2 - (var8 - 16) * 5, var3 - 5, 20);
				}

				if (var7 == 1044 || var7 == 1046 || var7 == 1052 || var7 == 1060 || var7 == 1064 || var7 == 1065
						|| var7 == 1067 || var7 == 1070) {
					++var2;
				}

				if (var7 == 1043 || var7 == 1045 || var7 == 1057 || var7 == 1058 || var7 == 1068) {
					--var2;
				}

				if (var7 == 1049) {
					var1.setClip(var2, var3 - 1, 4, 1);
					var1.drawImage(var5, var2, var3 - 1, 20);
				}

				var2 += 5;
			} else {
				var8 = this.otherSymbolsStr.indexOf(var7);
				if (var8 != -1) {
					var1.setClip(var2, var3, 5, 6);
					var1.drawImage(var5, var2 - var8 * 5, var3 - 15, 20);
				}

				var2 += 5;
			}
		}

		var1.setClip(0, 0, this.getWidth(), this.getHeight());
		return var2;
	}

	public void drawFancyText(Graphics g, int xPos, int yPos, String text, Image fontImg) {
		int textLength = text.length();
		boolean var8 = false;

		for (int var9 = 0; var9 < textLength; ++var9) {//тут рисуется текст из рисованного шрифта
			char var7 = text.charAt(var9);
			g.setClip(xPos, yPos, 7, 7);
			if (var7 >= '0' && var7 <= '9') {
				g.drawImage(fontImg, xPos - 14 - (var7 - 48) * 7, yPos - 21, 20);
			}

			if (var7 == '-') {
				g.drawImage(fontImg, xPos, yPos - 21, 20);
				xPos += 7;
			} else if (var7 == '.') {
				g.drawImage(fontImg, xPos - 7, yPos - 21, 20);
				xPos += 6;
			} else {
				if (var7 >= 1040 && var7 <= 1071) {
					int var10 = var7 - 1040;
					if (var10 <= 17) {
						g.drawImage(fontImg, xPos - var10 * 7, yPos, 20);
					} else {
						if (var7 > 1067) {
							++var10;
						}

						if (var7 > 1070) {
							++var10;
						}

						if (var7 == 1067 || var7 == 1070) {
							g.setClip(xPos, yPos, 10, 7);
						}

						g.drawImage(fontImg, xPos - (var10 - 18) * 7, yPos - 7, 20);
					}

					if (var7 == 1046 || var7 == 1052 || var7 == 1064 || var7 == 1065 || var7 == 1052 || var7 == 1067
							|| var7 == 1070) {
						++xPos;
					}

					if (var7 == 1067 || var7 == 1070) {
						xPos += 2;
					}

					if (var7 == 1054 || var7 == 1047) {
						--xPos;
					}
				}

				xPos += 8;
			}
		}

		g.setClip(0, 0, this.getWidth(), this.getHeight());
	}

	public void sub_1086(Graphics var1, int var2, int var3, int var4) {
		var1.drawImage(this.topPanelLImg, var2, var3, 20);
		int var5 = var4 - this.topPanelLImg.getWidth() - this.topPanelRImg.getWidth();

		for (int var6 = 0; var6 <= var5; var6 += this.topPanelMIng.getWidth()) {
			if (var6 + this.topPanelMIng.getWidth() <= var5) {
				var1.drawImage(this.topPanelMIng, var2 + var6 + this.topPanelLImg.getWidth(), var3, 20);
			} else {
				var1.setClip(var2 + var6 + this.topPanelLImg.getWidth(), var3, var5 - var6,
						this.topPanelMIng.getHeight());
				var1.drawImage(this.topPanelMIng, var2 + var6 + this.topPanelLImg.getWidth(), var3, 20);
				var1.setClip(0, 0, this.getWidth(), this.getHeight());
			}
		}

		var1.drawImage(this.topPanelRImg, var2 + var5 + this.topPanelLImg.getWidth(), var3, 20);
	}

	public void sub_10d7(Graphics var1, int var2, int var3, int var4, int var5, int var6) {
		var1.setColor(4276545);
		var1.drawLine(var2, var3, var2, var3 + var5);
		var1.drawLine(var2 + var4, var3, var2 + var4, var3 + var5);
		var1.setColor(7237230);

		for (int var7 = 1; var7 < var5 - 2; var7 += 3) {
			var1.drawLine(var2, var3 + var7, var2, var3 + var7);
			var1.drawLine(var2 + var4, var3 + var7, var2 + var4, var3 + var7);
		}

		var1.setColor(var6);
		var1.fillRect(var2 + 2, var3 + 1, var4 - 3, var5 - 1);
	}

	public void sub_10f9(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		var1.setColor(4276545);
		var1.drawLine(var2, var3, var2 + var4, var3);
		var1.drawLine(var2, var3 + var5, var2 + var4, var3 + var5);
		var1.setColor(7237230);
		int var8 = 1;
		if (var7 < 0) {
			var8 = var4;
		}

		while (var8 < var4 - 2) {
			var1.drawLine(var2 + var8, var3, var2 + var8, var3);
			var1.drawLine(var2 + var8, var3 + var5, var2 + var8, var3 + var5);
			var8 += var7;
		}

		var1.setColor(var6);
		var1.fillRect(var2, var3 + 2, var4 - 1, var5 - 3);
	}

	public void sub_114f(Graphics var1, int var2, int var3, int var4, int var5, int var6, Image var7) {
		int var8 = 2;
		int var9 = 2;
		var1.setColor(var6);
		var1.fillRect(var2 + 2, var3 + 2, var4 - 4, var5 - 4);
		var1.setColor(8093814);
		var1.drawRect(var2, var3, 1, 1);

		while (var8 < var4 - 2) {
			var1.drawImage(this.formTopImg, var2 + var8, var3, 20);
			var1.drawImage(this.formTopImg, var2 + var8, var3 + var5 - 2, 20);
			var8 += this.formTopImg.getWidth();
		}

		var1.drawRect(var8 + var2, var3, 1, 1);
		var1.drawRect(var8 + var2, var3 + var5 - 2, 1, 1);
		var1.drawRect(var2, var3 + var5 - 2, 1, 1);

		while (var9 < var5 - 2) {
			var1.drawImage(this.formRightImg, var2, var3 + var9, 20);
			var1.drawImage(this.formRightImg, var2 + var4 - 2, var3 + var9, 20);
			var9 += this.formRightImg.getHeight();
		}

		if (var7 != null) {
			var1.drawImage(var7, var2 + 5, var3 + 5, 20);
			var1.drawImage(var7, var2 + var4 - 7, var3 + 5, 20);
		}

	}

	public Image sub_1194(int var1) {
		for (int var3 = 0; var3 < this.var_d39.size(); ++var3) {
			Class_2a9 var2 = (Class_2a9) this.var_d39.elementAt(var3);
			if (var2.var_1c6 == var1) {
				return var2.var_6c8;
			}
		}

		return null;
	}

	public String sub_11e1(int var1) {
		for (int var3 = 0; var3 < this.var_d39.size(); ++var3) {
			Class_2a9 var2 = (Class_2a9) this.var_d39.elementAt(var3);
			if (var2.var_1c6 == var1) {
				return var2.playerGroupName;
			}
		}

		return "";
	}

	public int sub_121c(int var1) {
		for (int var3 = 0; var3 < this.var_d39.size(); ++var3) {
			Class_2a9 var2 = (Class_2a9) this.var_d39.elementAt(var3);
			if (var2.var_1c6 == var1) {
				return var2.sub_5ef();
			}
		}

		return 0;
	}

	public Class_2a9 sub_122a(int var1) {
		for (int var3 = 0; var3 < this.var_d39.size(); ++var3) {
			Class_2a9 var2 = (Class_2a9) this.var_d39.elementAt(var3);
			if (var2.var_1c6 == var1) {
				return var2;
			}
		}

		return null;
	}

	public int sub_126e(Class_2a9 var1) {
		int var3 = 1;
		if (this.var_da5 == null) {
			return 0;
		} else {
			while (true) {
				boolean var4 = false;

				for (int var5 = 0; var5 < this.var_da5.size(); ++var5) {
					Class_4f2 var2 = (Class_4f2) this.var_da5.elementAt(var5);
					if (var2.sub_236() == var1.var_1c6 && var2.sub_264() == var3) {
						var4 = true;
						break;
					}
				}

				if (!var4) {
					return var3;
				}

				++var3;
			}
		}
	}

	public int sub_129f() {
		int var1 = 1;
		if (this.var_da5 == null) {
			return 0;
		} else {
			while (true) {
				boolean var3 = false;

				for (int var4 = 0; var4 < this.var_da5.size(); ++var4) {
					Class_4f2 var2 = (Class_4f2) this.var_da5.elementAt(var4);
					if (var2.sub_1f2() == var1) {
						var3 = true;
						break;
					}
				}

				if (!var3) {
					return var1;
				}

				++var1;
			}
		}
	}

	public int sub_12f7(int var1, int var2, int var3, int var4) {
		Class_4f2 var5 = null;
		if (this.var_da5 != null) {
			for (int var6 = 0; var6 < this.var_da5.size(); ++var6) {
				var5 = (Class_4f2) this.var_da5.elementAt(var6);
				if (var5.sub_309() == var1 && var5.sub_31a() == var2 && var5.sub_362() == var3 && var5.sub_3a1() == var4
						&& var5.sub_1f2() != 0) {
					return var5.sub_1f2();
				}
			}
		}

		return 0;
	}

	public int sub_132f(int var1) {
		int var2 = 0;
		Class_4f2 var3 = null;
		if (this.var_da5 != null) {
			for (int var4 = 0; var4 < this.var_da5.size(); ++var4) {
				var3 = (Class_4f2) this.var_da5.elementAt(var4);
				if (var3.sub_236() == var1) {
					++var2;
				}
			}
		}

		return var2;
	}

	public Class_4f2 sub_135b(int var1, int var2) {
		int var3 = 0;
		Class_4f2 var4 = null;
		if (this.var_da5 != null) {
			for (int var5 = 0; var5 < this.var_da5.size(); ++var5) {
				var4 = (Class_4f2) this.var_da5.elementAt(var5);
				if (var4.sub_236() == var1) {
					++var3;
					if (var3 == var2) {
						return var4;
					}
				}
			}
		}

		return null;
	}

	public void sub_1392() {
		Class_4f2 var1 = null;
		if (this.var_da5 != null) {
			int var2;
			for (var2 = 0; var2 < this.var_da5.size(); ++var2) {
				var1 = (Class_4f2) this.var_da5.elementAt(var2);
				var1.sub_20e(0);
			}

			for (var2 = 0; var2 < this.var_da5.size(); ++var2) {
				var1 = (Class_4f2) this.var_da5.elementAt(var2);
				int var3 = this.sub_12f7(var1.sub_309(), var1.sub_31a(), var1.sub_362(), var1.sub_3a1());
				if (var3 == 0) {
					var1.var_261 = true;
					var1.sub_20e(this.sub_129f());
				} else {
					var1.sub_20e(var3);
					var1.var_261 = false;
				}
			}

		}
	}

	public void sub_13e1(Planet var1) {
		byte var2 = 6;
		if (this.var_da5 != null) {
			for (int var4 = var1.getXAbsoluteSector() - var2; var4 <= var1.getXAbsoluteSector() + var2; ++var4) {
				for (int var5 = var1.getYAbsoluteSector() - var2; var5 <= var1.getYAbsoluteSector() + var2; ++var5) {
					for (int var6 = 0; var6 < this.var_da5.size(); ++var6) {
						Class_4f2 var3 = (Class_4f2) this.var_da5.elementAt(var6);
						if (var3.sub_309() == var4 && var3.sub_31a() == var5) {
							var3.var_27d = true;
						}
					}
				}
			}

		}
	}

	public void sub_13fa(Class_2a9 var1) {
		if (this.var_da5 != null) {
			for (int var3 = 0; var3 < this.var_da5.size(); ++var3) {
				Class_4f2 var2 = (Class_4f2) this.var_da5.elementAt(var3);
				var2.var_2d9 = this.sub_76d(var2.sub_309(), var2.sub_31a()) != null;
				var2.var_27d = false;
				if (var2.sub_236() == var1.var_1c6) {
					var2.var_27d = true;
				}
			}

			if (this.planetsArr != null) {
				for (int var4 = 0; var4 < this.planetsArr.size(); ++var4) {
					Planet var5 = (Planet) this.planetsArr.elementAt(var4);
					if (var5.var_1df != null && var5.var_1df.var_4f == var1.var_1c6) {
						this.sub_13e1(var5);
					}
				}

			}
		}
	}

	public int sub_145e(int var1) {
		int var2 = 268435455;
		Class_4f2 var3 = null;
		if (this.var_da5 != null) {
			for (int var4 = 0; var4 < this.var_da5.size(); ++var4) {
				var3 = (Class_4f2) this.var_da5.elementAt(var4);
				if (var3.sub_1f2() == var1 && var3.sub_530() < var2) {
					var2 = var3.sub_530();
				}
			}
		}

		return var2 == 268435455 ? 0 : var2;
	}

	public void sub_14a6(Class_2a9 var1, int var2, int var3, int var4, boolean var5) {
		Class_4f2 var6 = new Class_4f2(var1.var_1c6, this.sub_126e(var1), var1.projectsArr[var2], var3, var4);
		if (var5) {
			var6.var_1ef = 1;
		}

		if (this.var_da5 == null) {
			this.var_da5 = new Vector();
		}

		this.var_da5.addElement(var6);
	}

	public void sub_14c3(Class_2a9 var1, Class_4f2 var2) {
		if (this.var_da5 != null) {
			for (int var4 = 0; var4 < this.var_da5.size(); ++var4) {
				Class_4f2 var3 = (Class_4f2) this.var_da5.elementAt(var4);
				if (var2.sub_264() == var3.sub_264() && var2.sub_236() == var3.sub_236()) {
					var1.var_f6 += var3.sub_6df();
					this.var_da5.removeElementAt(var4);
					return;
				}
			}
		}

	}

	public void sub_1527(Class_2a9 var1, int var2, int var3) {
		Project var4 = new Project();
		var4.sub_14c(var1);
		Class_4f2 var5 = new Class_4f2(var1.var_1c6, this.sub_126e(var1), var4, var2, var3);
		if (this.var_da5 == null) {
			this.var_da5 = new Vector();
		}

		this.var_da5.addElement(var5);
	}

	public int sub_1588(Class_4f2 var1) {
		Class_4f2 var2 = null;
		if (this.var_da5 != null) {
			for (int var3 = 0; var3 < this.var_da5.size(); ++var3) {
				var2 = (Class_4f2) this.var_da5.elementAt(var3);
				if (var2.sub_236() != var1.sub_236() && var2.sub_309() == var1.sub_309()
						&& var2.sub_31a() == var1.sub_31a()) {
					return var2.sub_236();
				}
			}
		}

		return -1;
	}

	public int sub_1592(int var1, int var2) {
		int var3 = 0;
		Class_4f2 var4 = null;
		if (this.var_da5 != null) {
			for (int var5 = 0; var5 < this.var_da5.size(); ++var5) {
				var4 = (Class_4f2) this.var_da5.elementAt(var5);
				if (var4.sub_309() == var1 && var4.sub_31a() == var2) {
					++var3;
				}
			}
		}

		return var3;
	}

	public Class_4f2 sub_15d8(int var1, int var2, int var3) {
		int var4 = 0;
		Class_4f2 var5 = null;
		if (this.var_da5 != null) {
			for (int var6 = 0; var6 < this.var_da5.size(); ++var6) {
				var5 = (Class_4f2) this.var_da5.elementAt(var6);
				if (var5.sub_309() == var1 && var5.sub_31a() == var2) {
					++var4;
					if (var4 == var3) {
						return var5;
					}
				}
			}
		}

		return null;
	}

	public void sub_1601(Class_4f2 var1) {
		Class_4f2 var2 = null;
		if (this.var_da5 != null) {
			for (int var3 = 0; var3 < this.var_da5.size(); ++var3) {
				var2 = (Class_4f2) this.var_da5.elementAt(var3);
				if (var2.sub_236() == var1.sub_236() && var2.sub_264() == var1.sub_264()) {
					this.var_da5.removeElementAt(var3);
					break;
				}
			}
		}

	}

	public Class_4f2 sub_1648(int var1) {
		return this.sub_15d8(this.someXCellPos, this.someYCellPos, var1);
	}

	public String sub_1693(Class_4f2 var1) {
		Planet var2 = this.sub_76d(var1.sub_362(), var1.sub_3a1());
		return var2 != null ? var2.sub_96() : "";
	}

	public int sub_16be(int var1, int var2, int var3, int var4) {
		return Math.abs(var3 - var1) >= Math.abs(var4 - var2) ? Math.abs(var3 - var1) : Math.abs(var4 - var2);
	}

	public int sub_16cc(int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7 = 0;
		int var8 = this.sub_16be(var1, var2, var3, var4);
		if (var8 <= 0) {
			return 0;
		} else if (var5 <= 0) {
			return 65535;
		} else if (this.sub_1716(var1, var2, var3, var4, var6)) {
			return 1;
		} else {
			while (var8 > 0) {
				var8 -= var5;
				++var7;
			}

			return var7;
		}
	}

	public boolean sub_1716(int var1, int var2, int var3, int var4, int var5) {
		Planet var6 = this.sub_76d(var1, var2);
		Planet var7 = this.sub_76d(var3, var4);
		if (var6 != null && var7 != null) {
			return var7.var_1df != null && var7.var_1df.var_4f == var5 && var6.var_1df != null
					&& var6.var_1df.var_4f == var5 && var6.var_1df.sub_e3(24) && var7.var_1df.sub_e3(24);
		} else {
			return false;
		}
	}

	public boolean sub_1778(Class_4f2 var1, int var2, int var3) {
		Planet var4 = this.sub_76d(var2, var3);
		if (var4 == null) {
			return false;
		} else {
			return var4.var_1df != null && var4.var_1df.var_4f != var1.sub_236() ? var4.var_1df.sub_e3(25) : false;
		}
	}

	public void sub_178d() {
		if (this.var_1029 == null) {
			this.var_9b3 = null;
			this.var_1029 = new Class_35d(this.getWidth(), this.getHeight());
		}
	}

	public boolean sub_1797(int var1, int var2) {
		Class_2a9 var3 = this.sub_122a(var1);
		return var3 == null ? false : var3.sub_e8(var2);
	}

	public int sub_17e8(Planet var1) {
		for (int var2 = 0; var2 < 10; ++var2) {
			if (this.artifactsDictArr[var2].var_1c1 == var1.planetCoords) {
				return var2;
			}
		}

		return -1;
	}

	public void sub_1827() {
		for (int var1 = 1; var1 < this.var_b9b; ++var1) {
			for (int var2 = -var1; var2 <= var1; ++var2) {
				for (int var3 = -var1; var3 <= var1; ++var3) {
					if (this.sub_76d(this.someXCellPos + var2, this.someYCellPos + var3) != null) {
						this.someXCellPos += var2;
						this.someYCellPos += var3;
						return;
					}
				}
			}
		}

	}

	public void sub_1886(int var1) {
		for (int var2 = var1; Math.abs(var2) <= this.var_b9b; var2 += var1) {
			for (int var3 = 0; var3 <= Math.abs(var2); ++var3) {
				if (this.sub_76d(this.someXCellPos + var3, this.someYCellPos + var2) != null) {
					this.someXCellPos += var3;
					this.someYCellPos += var2;
					return;
				}

				if (this.sub_76d(this.someXCellPos - var3, this.someYCellPos + var2) != null) {
					this.someXCellPos -= var3;
					this.someYCellPos += var2;
					return;
				}
			}
		}

	}

	public void sub_18d3(int var1) {
		for (int var2 = var1; Math.abs(var2) <= this.var_b9b; var2 += var1) {
			for (int var3 = 0; var3 <= Math.abs(var2); ++var3) {
				if (this.sub_76d(this.someXCellPos + var2, this.someYCellPos + var3) != null) {
					this.someXCellPos += var2;
					this.someYCellPos += var3;
					return;
				}

				if (this.sub_76d(this.someXCellPos + var2, this.someYCellPos - var3) != null) {
					this.someXCellPos += var2;
					this.someYCellPos -= var3;
					return;
				}
			}
		}

	}

	public int sub_18f9(String var1) {
		for (int var3 = 0; var3 < this.var_dc6.size(); ++var3) {
			String var2 = (String) this.var_dc6.elementAt(var3);
			if (var2 == var1) {
				return var3;
			}
		}

		return -1;
	}

	public int sub_1941(String var1) {
		this.var_dc6.addElement(var1);
		return this.var_dc6.size() - 1;
	}

	public String sub_19a5(int var1, int var2) {
		if (var1 >= 255) {
			if (var2 == 0) {
				return SomeUtilClass.getStr("АРТЕФАКТ") + " " + (var1 - 255 + 1);
			} else if (var2 == 1) {
				return "ART";
			} else {
				this.var_1d2e = var1 - 255;
				return "OK";
			}
		} else {
			int var3;
			for (var3 = 0; var3 < 6; ++var3) {
				if (this.costumeItemsArr[var3].someByte == var1) {
					if (var2 == 0) {
						return this.costumeItemsArr[var3].someStr + " " + SomeUtilClass.getStr("БРОНЯ");
					}

					if (var2 == 1) {
						return "A";
					}

					this.var_1d2e = var3;
					return "OK";
				}
			}

			for (var3 = 0; var3 < 9; ++var3) {
				if (this.passiveUpgradesDictArr[var3].var_1ed == var1) {
					if (var2 == 0) {
						return this.passiveUpgradesDictArr[var3].var_11;
					}

					if (var2 == 1) {
						return "B";
					}

					this.var_1d2e = var3;
					return "OK";
				}
			}

			for (var3 = 0; var3 < 31; ++var3) {
				if (this.buildingDictArr[var3].var_1ed == var1) {
					if (var2 == 0) {
						return this.buildingDictArr[var3].var_11;
					}

					if (var2 == 1) {
						return "BU";
					}

					this.var_1d2e = var3;
					return "OK";
				}
			}

			for (var3 = 0; var3 < 5; ++var3) {
				if (this.attackSpeedItemsArr[var3].someByte == var1) {
					if (var2 == 0) {
						return this.attackSpeedItemsArr[var3].someStr + " " + SomeUtilClass.getStr("БОЕПРИПАСЫ");
					}

					if (var2 == 1) {
						return "C";
					}

					this.var_1d2e = var3;
					return "OK";
				}
			}

			for (var3 = 0; var3 < 5; ++var3) {
				if (this.staminaItemsArr[var3].someByte == var1) {
					if (var2 == 0) {
						return this.staminaItemsArr[var3].someStr + " " + SomeUtilClass.getStr("ВЫНОСЛИВОСТЬ");
					}

					if (var2 == 1) {
						return "E";
					}

					this.var_1d2e = var3;
					return "OK";
				}
			}

			for (var3 = 0; var3 < 14; ++var3) {
				if (this.weaponItemsArr[var3].someByte == var1) {
					if (var2 == 0) {
						return this.weaponItemsArr[var3].someStr;
					}

					if (var2 == 1) {
						return "W";
					}

					this.var_1d2e = var3;
					return "OK";
				}
			}

			return "";
		}
	}

	public void sub_19f8() {
		if (this.artifactsDictArr[this.var_d5c.var_6eb].var_1ed == 1) {
			this.var_9b3 = new Class_4b3(14, 0, 0, this.getWidth(), this.getHeight(), 0, (Planet) null);
			this.var_9b3.addMenu2Option(-1, this.var_9b3.yPos + 13, SomeUtilClass.getStr("ВЫБЕРИТЕ ЛЕГЕРЬ"), false);
			this.var_9b3.addMenu2Option(-1, this.var_9b3.yPos + 13 + 7, SomeUtilClass.getStr("ДЛЯ АРТЕФАКТА"), false);
		} else {
			this.var_9b3 = new Class_4b3(14, 0, 0, this.getWidth(), this.getHeight(), 0, (Planet) null);
			this.var_9b3.addMenu2Option(-1, this.var_9b3.yPos + 13, SomeUtilClass.getStr("ВЫБЕРИТЕ ОТРЯД"), false);
			this.var_9b3.addMenu2Option(-1, this.var_9b3.yPos + 13 + 7, SomeUtilClass.getStr("ДЛЯ АРТЕФАКТА"), false);
		}

	}

	public void sub_1a34() {
		if (this.artifactsDictArr[this.var_d5c.var_6eb].var_1ed == 1) {
			this.var_9b3 = new Class_4b3(9, 0, 0, this.getWidth(), this.getHeight(), 0, (Planet) null);
			this.var_9b3.var_d47 = 10;
		} else {
			this.var_9b3 = new Class_4b3(10, 0, 0, this.getWidth(), this.getHeight(), 0, (Planet) null);
			this.var_9b3.var_d47 = 10;
		}

	}

	public void sub_1a71(int var1) {
		Planet var2;
		if (var1 == 0) {
			var2 = this.sub_862(this.var_d5c, 1);
		} else {
			var2 = this.sub_78d(var1);
		}

		if (var2 != null && var2.var_1df != null) {
			var2.var_1df.sub_12f(this.var_d5c.var_6eb);
		}

		this.var_d5c.var_6eb = -1;
		this.sub_178d();
	}

	public void sub_1a92(int var1) {
		Class_4f2 var2 = this.sub_135b(this.var_d5c.var_1c6, var1);
		if (var2 != null) {
			var2.sub_62(this.var_d5c.var_6eb);
			if (this.var_d5c.var_6eb == 9) {
				var2.var_1ef = (byte) (var2.var_1ef + 3);
			}

			this.var_d5c.var_6eb = -1;
			this.sub_178d();
		}
	}

	public boolean sub_1a9e(RecordStore var1) {
		try {
			ByteArrayOutputStream var2 = new ByteArrayOutputStream();
			DataOutputStream var3 = new DataOutputStream(var2);

			try {
				byte var4 = 1;
				var3.writeByte(var4);
				var3.writeInt(this.var_da5.size());

				for (int var6 = 0; var6 < this.var_da5.size(); ++var6) {
					Class_4f2 var5 = (Class_4f2) this.var_da5.elementAt(var6);
					var3.writeInt(var5.var_65);
					var3.writeInt(var5.var_8a);
					var3.writeInt(var5.var_2a);
					var3.writeInt(var5.var_3e);
					var3.writeInt(var5.var_6e);
					var3.writeInt(var5.var_cb);
					var3.writeInt(var5.var_15d);
					var3.writeByte(var5.var_195);
					var3.writeByte(var5.var_1ef);
					var3.writeByte(var5.var_21d);
				}

				var3.close();
				var2.close();
			} catch (IOException var7) {
			}

			byte[] var9 = var2.toByteArray();
			var1.addRecord(var9, 0, var9.length);
			return true;
		} catch (RecordStoreException var8) {
			return false;
		}
	}

	public boolean sub_1ad1(byte[] var1) {
		ByteArrayInputStream var2 = new ByteArrayInputStream(var1);
		DataInputStream var3 = new DataInputStream(var2);

		try {
			byte var4 = var3.readByte();
			int var5 = var3.readInt();

			for (int var7 = 0; var7 < var5; ++var7) {
				Class_4f2 var6 = new Class_4f2();
				var6.var_65 = var3.readInt();
				var6.var_8a = var3.readInt();
				var6.var_2a = var3.readInt();
				var6.var_3e = var3.readInt();
				var6.var_6e = var3.readInt();
				var6.var_cb = var3.readInt();
				var6.var_15d = var3.readInt();
				var6.var_195 = var3.readByte();
				var6.var_1ef = var3.readByte();
				var6.var_21d = var3.readByte();
				this.var_da5.addElement(var6);
			}

			var3.close();
			var2.close();
			return true;
		} catch (IOException var8) {
			return false;
		}
	}

	public boolean sub_1ae6(RecordStore var1) {
		try {
			ByteArrayOutputStream var2 = new ByteArrayOutputStream();
			DataOutputStream var3 = new DataOutputStream(var2);

			try {
				byte var4 = 1;
				var3.writeByte(var4);
				var3.writeInt(this.var_dc6.size());
				var3.writeInt(this.gameCurrentYear);
				var3.writeInt(this.gameCurrentMonth);
				var3.writeInt(this.var_d39.size());
				var3.writeInt(this.var_b9b);
				var3.writeInt(this.var_190d);

				for (int var6 = 0; var6 < this.var_dc6.size(); ++var6) {
					String var5 = (String) this.var_dc6.elementAt(var6);
					var3.writeUTF(var5);
				}

				var3.close();
				var2.close();
			} catch (IOException var7) {
			}

			byte[] var9 = var2.toByteArray();
			var1.addRecord(var9, 0, var9.length);
			return true;
		} catch (RecordStoreException var8) {
			return false;
		}
	}

	public boolean sub_1af8(byte[] var1) {
		ByteArrayInputStream var2 = new ByteArrayInputStream(var1);
		DataInputStream var3 = new DataInputStream(var2);

		try {
			byte var4 = var3.readByte();
			int var5 = var3.readInt();
			this.gameCurrentYear = var3.readInt();
			this.gameCurrentMonth = var3.readInt();
			this.var_1d90 = var3.readInt();
			this.var_b9b = var3.readInt();
			this.var_190d = var3.readInt();

			for (int var6 = 0; var6 < var5; ++var6) {
				this.var_dc6.addElement(var3.readUTF());
			}

			var3.close();
			var2.close();
			return true;
		} catch (IOException var7) {
			return false;
		}
	}

	public boolean sub_1b44(byte[] var1) {
		ByteArrayInputStream var2 = new ByteArrayInputStream(var1);
		DataInputStream var3 = new DataInputStream(var2);

		try {
			byte var4 = var3.readByte();
			int var5 = var3.readInt();
			Planet var6 = null;

			for (int var7 = 0; var7 < var5; ++var7) {
				var6 = new Planet();
				var6.var_5a = var3.readInt();
				if (var6.var_5a == -1) {
					var6.sub_ab("ЗВЕЗДА" + var7);
				}

				var6.var_9b = var3.readInt();
				var6.var_e5 = var3.readInt();
				var6.var_fa = var3.readInt();
				var6.planetCoords = var3.readInt();
				if (var3.readBoolean()) {
					var6.var_1df = new Class_139(0);
					var6.var_1df.var_4f = var3.readInt();
					var6.var_1df.var_5f = var3.readInt();
					var6.var_1df.var_bd = var3.readInt();
					var6.var_1df.jobId = var3.readInt();
					var6.var_1df.var_136 = var3.readInt();
					var6.var_1df.var_141 = var3.readInt();
					var6.var_1df.var_178 = var3.readInt();
					var6.var_1df.var_19d = var3.readInt();
				}

				var6.sub_3a();
				this.planetsArr.addElement(var6);
			}

			var3.close();
			var2.close();
			return true;
		} catch (IOException var8) {
			return false;
		}
	}

	public boolean sub_1b98(RecordStore var1) {
		if (this.planetsArr == null) {
			return false;
		} else {
			try {
				ByteArrayOutputStream var2 = new ByteArrayOutputStream();
				DataOutputStream var3 = new DataOutputStream(var2);

				try {
					byte var4 = 1;
					int var5 = this.planetsArr.size();
					var3.writeByte(var4);
					var3.writeInt(var5);

					for (int var7 = 0; var7 < this.planetsArr.size(); ++var7) {
						Planet var6 = (Planet) this.planetsArr.elementAt(var7);
						var3.writeInt(var6.var_5a);
						var3.writeInt(var6.var_9b);
						var3.writeInt(var6.var_e5);
						var3.writeInt(var6.var_fa);
						var3.writeInt(var6.planetCoords);
						var3.writeBoolean(var6.var_1df != null);
						if (var6.var_1df != null) {
							var3.writeInt(var6.var_1df.var_4f);
							var3.writeInt(var6.var_1df.var_5f);
							var3.writeInt(var6.var_1df.var_bd);
							var3.writeInt(var6.var_1df.jobId);
							var3.writeInt(var6.var_1df.var_136);
							var3.writeInt(var6.var_1df.var_141);
							var3.writeInt(var6.var_1df.var_178);
							var3.writeInt(var6.var_1df.var_19d);
						}
					}

					var3.close();
					var2.close();
				} catch (IOException var8) {
				}

				byte[] var10 = var2.toByteArray();
				var1.addRecord(var10, 0, var10.length);
				return true;
			} catch (RecordStoreException var9) {
				return false;
			}
		}
	}

	public boolean sub_1bcc() {
		SomeUtilClass.deleteRecordFromStore("MOGCOMMON");

		try {
			RecordStore var1 = RecordStore.openRecordStore("MOGCOMMON", true);
			ByteArrayOutputStream var2 = new ByteArrayOutputStream();
			DataOutputStream var3 = new DataOutputStream(var2);

			try {
				var3.writeBoolean(this.var_169a);
				var3.writeBoolean(this.var_16d3);

				for (int var4 = 0; var4 < this.var_164f.length; ++var4) {
					var3.writeUTF(this.var_164f[var4].someStr);
					var3.writeInt(this.var_164f[var4].price);
				}

				var3.close();
				var2.close();
			} catch (IOException var5) {
			}

			byte[] var7 = var2.toByteArray();
			var1.addRecord(var7, 0, var7.length);
			var1.closeRecordStore();
			return true;
		} catch (RecordStoreException var6) {
			return false;
		}
	}

	public boolean sub_1bfe() {
		try {
			RecordStore var1 = RecordStore.openRecordStore("MOGCOMMON", true);
			RecordEnumeration var2 = var1.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
			if (var2.hasNextElement()) {
				byte[] var3 = var2.nextRecord();
				ByteArrayInputStream var4 = new ByteArrayInputStream(var3);
				DataInputStream var5 = new DataInputStream(var4);

				try {
					this.var_169a = var5.readBoolean();
					this.var_16d3 = var5.readBoolean();

					for (int var6 = 0; var6 < this.var_164f.length; ++var6) {
						this.var_164f[var6].someStr = var5.readUTF();
						this.var_164f[var6].price = var5.readInt();
					}

					var5.close();
					var4.close();
				} catch (IOException var8) {
					return false;
				}
			}

			return true;
		} catch (RecordStoreException var9) {
			try {
				RecordStore.deleteRecordStore("MOGCOMMON");
			} catch (RecordStoreException var7) {
			}

			return false;
		}
	}

	public boolean sub_1c60() {
		this.var_d05 = 0;
		this.var_d0f = new SomeThreadPainterClass(this.getGraphics());
		this.var_d0f.start();

		RecordStore var1;
		RecordEnumeration var2;
		byte[] var3;
		try {
			var1 = RecordStore.openRecordStore("PLAYERS", true);
			var2 = var1.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
			this.var_d39 = new Vector();

			while (true) {
				if (!var2.hasNextElement()) {
					var1.closeRecordStore();
					break;
				}

				var3 = var2.nextRecord();
				Class_2a9 var4 = new Class_2a9();
				var4.sub_82c(var3);
				this.var_d39.addElement(var4);
			}
		} catch (RecordStoreException var12) {
			try {
				RecordStore.deleteRecordStore("PLAYERS");
			} catch (RecordStoreException var6) {
			}

			return false;
		}

		this.var_d05 = 25;

		try {
			var1 = RecordStore.openRecordStore("STARS", true);
			var2 = var1.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
			if (var2.hasNextElement()) {
				var3 = var2.nextRecord();
				this.planetsArr = new Vector();
				this.sub_1b44(var3);
			}

			var1.closeRecordStore();
		} catch (RecordStoreException var11) {
			try {
				RecordStore.deleteRecordStore("STARS");
			} catch (RecordStoreException var5) {
			}

			return false;
		}

		this.var_d05 = 50;

		try {
			var1 = RecordStore.openRecordStore("SHIPS", true);
			var2 = var1.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
			if (var2.hasNextElement()) {
				var3 = var2.nextRecord();
				this.var_da5 = new Vector();
				this.sub_1ad1(var3);
			}

			var1.closeRecordStore();
		} catch (RecordStoreException var10) {
			try {
				RecordStore.deleteRecordStore("SHIPS");
			} catch (RecordStoreException var7) {
			}

			return false;
		}

		this.var_d05 = 75;

		try {
			var1 = RecordStore.openRecordStore("SHIPSNAME", true);
			var2 = var1.enumerateRecords((RecordFilter) null, (RecordComparator) null, false);
			if (var2.hasNextElement()) {
				var3 = var2.nextRecord();
				this.var_dc6 = new Vector();
				this.sub_1af8(var3);
			}

			var1.closeRecordStore();
		} catch (RecordStoreException var9) {
			try {
				RecordStore.deleteRecordStore("SHIPSNAME");
			} catch (RecordStoreException var8) {
			}

			return false;
		}

		if (this.buttonImg == null) {
			this.loadSomeImages();
		}

		this.var_1c3c = true;
		this.var_d5 = true;
		this.var_d5c = (Class_2a9) this.var_d39.elementAt(0);
		this.var_31a = 1;
		this.sub_f61();
		this.sub_f01();
		this.var_d05 = 100;
		this.var_d0f = null;
		this.sub_a50();
		return true;
	}

	public boolean sub_1cae() {
		try {
			RecordStore var1 = RecordStore.openRecordStore("PLAYERS", false);
			var1.closeRecordStore();
			return true;
		} catch (RecordStoreException var2) {
			return false;
		}
	}

	public boolean sub_1cbe() {
		SomeUtilClass.deleteRecordFromStore("PLAYERS");

		RecordStore var2;
		try {
			var2 = RecordStore.openRecordStore("PLAYERS", true);
			int var3 = 0;

			while (true) {
				if (var3 >= this.var_d39.size()) {
					var2.closeRecordStore();
					break;
				}

				Class_2a9 var1 = (Class_2a9) this.var_d39.elementAt(var3);
				var1.sub_881(var2);
				++var3;
			}
		} catch (RecordStoreException var7) {
			return false;
		}

		SomeUtilClass.deleteRecordFromStore("STARS");

		try {
			var2 = RecordStore.openRecordStore("STARS", true);
			this.sub_1b98(var2);
			var2.closeRecordStore();
		} catch (RecordStoreException var6) {
			return false;
		}

		SomeUtilClass.deleteRecordFromStore("SHIPS");

		try {
			var2 = RecordStore.openRecordStore("SHIPS", true);
			this.sub_1a9e(var2);
			var2.closeRecordStore();
		} catch (RecordStoreException var5) {
			return false;
		}

		SomeUtilClass.deleteRecordFromStore("SHIPSNAME");

		try {
			var2 = RecordStore.openRecordStore("SHIPSNAME", true);
			this.sub_1ae6(var2);
			var2.closeRecordStore();
			return true;
		} catch (RecordStoreException var4) {
			return false;
		}
	}

	public void sub_1ce5() {
		for (int var2 = 0; var2 < this.var_d39.size(); ++var2) {
			Class_2a9 var1 = (Class_2a9) this.var_d39.elementAt(var2);
			var1.var_76d = this.sub_1cf7(var1);
			var1.sub_143();
		}

	}

	public int sub_1cf7(Class_2a9 var1) {
		int var2 = 0;
		Class_4f2 var3 = null;
		if (this.var_da5 != null) {
			for (int var4 = 0; var4 < this.var_da5.size(); ++var4) {
				var3 = (Class_4f2) this.var_da5.elementAt(var4);
				if (var3.sub_236() == var1.var_1c6) {
					var2 += var3.sub_698();
				}
			}
		}

		return var2;
	}

	public int sub_1d56(int var1, int var2, int var3, Class_2a9 var4) {
		int var5 = 0;

		for (int var6 = -var3; var6 <= var3; ++var6) {
			for (int var7 = -var3; var7 <= var3; ++var7) {
				if (this.sub_f16(var1 + var6, var2 + var7)) {
					Planet var8 = this.sub_76d(var1 + var6, var2 + var7);
					if (var8 != null && var8.var_1df != null && var8.var_1df.var_4f == var4.var_1c6) {
						++var5;
					}
				}
			}
		}

		return var5;
	}

	public int sub_1d6d(Planet var1, int var2, Class_2a9 var3) {
		var1.var_1df.var_204 = false;
		int var4 = 0;
		Class_4f2 var5 = null;
		int var6;
		if (this.var_da5 != null) {
			for (var6 = 0; var6 < this.var_da5.size(); ++var6) {
				var5 = (Class_4f2) this.var_da5.elementAt(var6);
				if (var5.sub_236() != var3.var_1c6
						&& (var5.sub_78d(var1.getXAbsoluteSector(), var1.getYAbsoluteSector(), var2) || var5.var_cb == var1.planetCoords)) {
					var4 += var5.sub_698();
					if (var5.var_cb == var1.planetCoords) {
						var1.var_1df.var_204 = true;
						var3.var_7e2 = true;
					}
				} else if (var5.sub_236() == var3.var_1c6 && var5.var_6e == var1.planetCoords && !var5.sub_599()) {
					var4 -= var5.sub_698();
				} else if (var5.sub_236() == var3.var_1c6 && var5.var_cb == var1.planetCoords && var5.sub_599()) {
					var4 -= var5.sub_698();
				}
			}
		}

		var6 = this.sub_1d56(var1.getXAbsoluteSector(), var1.getYAbsoluteSector(), var2, var3);
		if (var6 != 0) {
			var4 /= var6;
		}

		return var4;
	}

	public int sub_1d7b(Planet var1) {
		int var2 = 0;
		Class_4f2 var3 = null;
		if (this.var_da5 != null) {
			for (int var4 = 0; var4 < this.var_da5.size(); ++var4) {
				var3 = (Class_4f2) this.var_da5.elementAt(var4);
				if (var3.var_6e == var1.planetCoords) {
					var2 += var3.sub_698();
				}
			}
		}

		return var2;
	}

	public int sub_1db6(Class_2a9 var1) {
		int var3 = 0;

		for (int var4 = 0; var4 < gameScreen.var_d39.size(); ++var4) {
			Class_2a9 var2 = (Class_2a9) gameScreen.var_d39.elementAt(var4);
			if (var2.var_1c6 != var1.var_1c6 && var2.var_76d > var1.var_76d) {
				++var3;
			}
		}

		if (var3 > 0) {
			return var3 + 1;
		} else {
			return 1;
		}
	}

	public int sub_1dcf(Class_2a9 var1) {
		int var2 = 0;
		Class_4f2 var3 = null;
		if (this.var_da5 != null) {
			for (int var4 = 0; var4 < this.var_da5.size(); ++var4) {
				var3 = (Class_4f2) this.var_da5.elementAt(var4);
				if (var3.sub_236() == var1.var_1c6) {
					var2 += var3.sub_18d(28) + 1;
				}
			}
		}

		return var2;
	}

	public int sub_1e30(Class_2a9 var1) {
		Project var2 = new Project();
		var2.sub_14c(var1);
		return var2.sub_530();
	}

	public int sub_1e4e(Class_2a9 var1) {
		return 6 * this.sub_1e30(var1);
	}

	public int sub_1e9e(int var1, int var2, int var3, boolean var4) {
		int var5 = 0;
		int var6 = 0;

		for (int var7 = -var3; var7 <= var3; ++var7) {
			for (int var8 = -var3; var8 <= var3; ++var8) {
				if (this.sub_f16(var1 + var7, var2 + var8)) {
					Planet var9 = this.sub_76d(var1 + var7, var2 + var8);
					if (var9 != null && var9.var_1df == null) {
						var6 += var9.var_210 / 3;
						++var5;
					}
				}
			}
		}

		if (var5 == 0) {
			return 0;
		} else {
			if (var4) {
				var6 /= var5;
			} else {
				var6 /= var5 * 2;
			}

			return var6;
		}
	}

	public boolean sub_1edf(Planet var1) {
		if (this.var_da5 != null) {
			for (int var3 = 0; var3 < this.var_da5.size(); ++var3) {
				Class_4f2 var2 = (Class_4f2) this.var_da5.elementAt(var3);
				if (var2.var_cb == var1.planetCoords || var2.var_6e == var1.planetCoords) {
					return true;
				}
			}
		}

		return false;
	}

	public Planet sub_1f16(int var1, int var2, int var3) {
		Planet var4 = null;
		int var5 = 0;

		for (int var6 = -var3; var6 <= var3; ++var6) {
			for (int var7 = -var3; var7 <= var3; ++var7) {
				if (this.sub_f16(var1 + var6, var2 + var7)) {
					Planet var8 = this.sub_76d(var1 + var6, var2 + var7);
					if (var8 != null && var8.var_1df == null && !this.sub_1edf(var8) && var8.var_210 > var5) {
						var4 = var8;
						var5 = var8.var_210;
					}
				}
			}
		}

		return var4;
	}

	public Planet sub_1f66(Class_2a9 var1, int var2, int var3, int var4) {
		Planet var5 = null;
		int var6 = 0;
		int var7 = 0;

		for (int var8 = -var4; var8 <= var4; ++var8) {
			for (int var9 = -var4; var9 <= var4; ++var9) {
				if (this.sub_f16(var2 + var8, var3 + var9)) {
					Planet var10 = this.sub_76d(var2 + var8, var3 + var9);
					if (var10 != null && var10.var_1df != null && var10.var_1df.var_4f != var1.var_1c6) {
						if (var10.var_210 > var6) {
							var5 = var10;
							var6 = var10.var_210;
						}
					} else if (var10 != null && var10.var_1df == null && var10.var_210 > var7) {
						var7 = var10.var_210;
					}
				}
			}
		}

		if (var1.var_8c == 1) {
			return var5;
		} else if (var6 > var7) {
			return var5;
		} else {
			return null;
		}
	}

	public int sub_1f92(Class_2a9 var1) {
		int var2 = 0;
		Class_4f2 var3 = null;
		if (this.var_da5 != null) {
			for (int var4 = 0; var4 < this.var_da5.size(); ++var4) {
				var3 = (Class_4f2) this.var_da5.elementAt(var4);
				if (var3.sub_236() == var1.var_1c6 && var3.sub_613()) {
					++var2;
				}
			}
		}

		return var2;
	}

	public int sub_1fb8(Class_2a9 var1) {
		int var2 = 0;

		for (int var4 = 0; var4 < this.planetsArr.size(); ++var4) {
			Planet var3 = (Planet) this.planetsArr.elementAt(var4);
			if (var3.var_1df != null && var3.var_1df.var_4f == var1.var_1c6 && var3.var_1df.var_19d > 550) {
				var2 += (1100 - var3.var_1df.var_19d) / 55;
			}
		}

		return var2;
	}

	public Class_4f2 sub_1fcc(Planet var1) {
		int var2 = this.sub_1592(var1.getXAbsoluteSector(), var1.getYAbsoluteSector());

		for (int var3 = 0; var3 < var2; ++var3) {
			Class_4f2 var4 = this.sub_15d8(var1.getXAbsoluteSector(), var1.getYAbsoluteSector(), var3 + 1);
			if (var4 != null && !var4.sub_599()) {
				return var4;
			}
		}

		return null;
	}

	public void sub_200f(Class_2a9 var1) {
		if (this.var_da5 != null) {
			if (var1.var_80a != null && var1.var_821 != null && var1.var_853 == 0) {
				int var2 = this.sub_1d7b(var1.var_821);
				int var3 = this.sub_1d7b(var1.var_80a);
				boolean var4 = false;
				if (var1.var_8c == 1) {
					if (var2 + var2 / 4 <= var3) {
						var4 = true;
					}
				} else if (var2 + var2 / 2 <= var3) {
					var4 = true;
				}

				Class_2a9 var5;
				if (var4) {
					var5 = this.sub_122a(var1.var_821.var_1df.var_4f);
					if (var5 == null) {
						return;
					}

					if (var5.var_76d > var1.var_76d + var1.var_76d / 4) {
						var4 = false;
					}

					if (var1.var_80a.var_1df.var_204) {
						var4 = false;
					}
				}

				if (var4) {
					var5 = null;
					int var6 = 0;

					do {
						Class_4f2 var7 = this.sub_1fcc(var1.var_80a);
						if (var7 == null) {
							break;
						}

						var7.var_cb = var1.var_821.planetCoords;
						++var6;
					} while (var6 <= 10000);
				}

			}
		}
	}

	public void sub_2029(Class_2a9 var1) {
		if (this.var_da5 != null) {
			int var3 = this.sub_7b7(var1);
			if (var3 != 0) {
				Planet[] var4 = new Planet[var3];
				var3 = 0;
				int var5 = 0;
				var1.var_80a = null;
				var1.var_821 = null;
				int var6 = this.sub_1e4e(var1);

				Planet var2;
				int var7;
				for (var7 = 0; var7 < this.planetsArr.size(); ++var7) {
					var2 = (Planet) this.planetsArr.elementAt(var7);
					if (var2.var_1df != null && var2.var_1df.var_4f == var1.var_1c6) {
						var2.var_1df.var_1e2 = this.sub_1d6d(var2, var6, var1);
						var4[var3] = var2;
						++var3;
						if (var1.var_853 == 0) {
							Planet var8 = this.sub_1f66(var1, var2.getXAbsoluteSector(), var2.getYAbsoluteSector(), var6);
							if (var8 != null && var8.var_210 > var5) {
								var5 = var8.var_210;
								var1.var_80a = var2;
								var1.var_821 = var8;
							}
						}
					}
				}

				int var12;
				for (var7 = 0; var7 < var4.length; ++var7) {
					for (var12 = var7 + 1; var12 < var4.length; ++var12) {
						if (var4[var7].var_1df.var_204 != var4[var12].var_1df.var_204) {
							if (!var4[var7].var_1df.var_204) {
								var2 = var4[var12];
								var4[var12] = var4[var7];
								var4[var7] = var2;
							}
						} else if (var4[var7].var_1df.var_1e2 < var4[var12].var_1df.var_1e2) {
							var2 = var4[var12];
							var4[var12] = var4[var7];
							var4[var7] = var2;
						}
					}
				}

				Class_4f2 var11 = null;

				for (var12 = 0; var12 < var4.length; ++var12) {
					while (var4[var12].var_1df.var_1e2 > 0) {
						boolean var9 = false;

						for (int var10 = var4.length - 1; var10 > var12; --var10) {
							var11 = this.sub_1fcc(var4[var10]);
							if (var11 != null) {
								Class_139 var10000;
								if (var4[var10].var_1df.var_1e2 + var11.sub_698() < 0) {
									var11.var_cb = var4[var12].planetCoords;
									var10000 = var4[var12].var_1df;
									var10000.var_1e2 -= var11.sub_698();
									var10000 = var4[var10].var_1df;
									var10000.var_1e2 += var11.sub_698();
									var9 = true;
								} else if (var4[var12].sub_2aa(var1) > var4[var10].sub_2aa(var1)) {
									var11.var_cb = var4[var12].planetCoords;
									var10000 = var4[var12].var_1df;
									var10000.var_1e2 -= var11.sub_698();
									var10000 = var4[var10].var_1df;
									var10000.var_1e2 += var11.sub_698();
									var9 = true;
								}
								break;
							}
						}

						if (!var9) {
							break;
						}
					}
				}

				if (var1.var_80a != null) {
					for (var12 = 0; var12 < var4.length; ++var12) {
						if (var4[var12].planetCoords != var1.var_80a.planetCoords) {
							int var13 = 0;

							do {
								var11 = this.sub_1fcc(var4[var12]);
								if (var11 == null || var4[var12].var_1df.var_204
										|| var4[var12].var_1df.var_1e2 + var11.sub_698() >= 0) {
									break;
								}

								var11.var_cb = var1.var_80a.planetCoords;
								++var13;
							} while (var13 <= 5000);
						}
					}

				}
			}
		}
	}

	public void sub_2057(Class_2a9 var1) {
		Class_4f2 var2 = null;
		if (this.var_da5 != null) {
			for (int var3 = 0; var3 < this.var_da5.size(); ++var3) {
				var2 = (Class_4f2) this.var_da5.elementAt(var3);
				if (var2.sub_236() == var1.var_1c6 && var2.sub_613() && !var2.sub_599()) {
					Planet var4 = this.sub_76d(var2.sub_309(), var2.sub_31a());
					if (var4 != null) {
						if (var4.var_1df == null) {
							this.sub_52d(var1, var4);
							this.sub_555(var2.sub_309(), var2.sub_31a());
						} else {
							Planet var5 = this.sub_1f16(var2.sub_309(), var2.sub_31a(), this.sub_1e4e(var1));
							if (var5 != null) {
								var2.var_cb = var5.planetCoords;
							}
						}
					}
				}
			}
		}

	}

	public int sub_20a1(Class_2a9 var1, int var2) {
		return 1;
	}

	public void sub_20ab(Class_2a9 var1) {
		int var2 = this.sub_dbc(var1);
		if (var2 < 12) {
			if (var1.var_5da != 0) {
				var1.var_622 = 100;
			} else {
				var1.var_622 = 0;
			}
		} else if (var1.var_5da == 0) {
			var1.var_622 = 0;
		} else {
			var1.var_622 = 50;
		}

	}

	public void sub_20cc(Class_2a9 var1) {
		if (var1.var_5da == 0) {
			int var2 = 0;
			int var3 = -1;

			for (int var4 = 0; var4 < 64; ++var4) {
				if (!var1.sub_139(var4) && var1.sub_3bf(this.var_fc9[var4])) {
					int var5 = this.sub_20a1(var1, var4);
					if (var5 > var2) {
						var2 = var5;
						var3 = var4;
					}
				}
			}

			if (var3 != -1) {
				var1.var_5da = var3;
			}
		}

		this.sub_20ab(var1);
	}

	public void sub_211c(Class_2a9 var1) {
		int var2 = 16777215;
		int var3 = -1;
		if (var1.var_f6 < 0) {
			if (this.var_da5 != null) {
				for (int var4 = 0; var4 < this.var_da5.size(); ++var4) {
					Class_4f2 var5 = (Class_4f2) this.var_da5.elementAt(var4);
					if (var5.sub_236() == var1.var_1c6 && !var5.sub_599() && var5.sub_698() < var2) {
						var3 = var4;
						var2 = var5.sub_698();
					}
				}
			}

			if (var3 != -1) {
				Class_4f2 var6 = (Class_4f2) this.var_da5.elementAt(var3);
				this.sub_14c3(var1, var6);
			}
		}

	}

	public void sub_2157(Class_2a9 var1) {
		Project var2 = new Project();
		Project var3 = new Project();
		int var4 = var1.sub_16d();

		for (int var5 = 0; var5 < var1.projectsArr.length; ++var5) {
			var3.var_8a = var1.projectsArr[var5].var_8a;
			var3.var_65 = var1.projectsArr[var5].var_65;
			var2.var_8a = var1.projectsArr[var5].var_8a;
			var2.sub_1d7(24, var1.sub_1c4());
			var2.sub_1d7(20, var4);
			var2.sub_1d7(8, var1.sub_1d4());
			var2.sub_1d7(0, 1);
			var2.sub_1d7(28, var5);

			for (int var6 = 0; var6 < var1.sub_213(); ++var6) {
				int var7 = var1.sub_272(var6 + 1);
				int var8 = 1;
				int var9 = 1;
				int var10 = 1;
				var2.sub_1d7(12, var10);
				int var11 = 0;

				do {
					this.sub_2193(var2, var7, var9, var8);
					if (var2.sub_4d4() < 0) {
						break;
					}

					while (var2.sub_530() < this.staminaItemsArr[var4].statValue) {
						++var10;
						var2.sub_1d7(12, var10);
						if (var2.sub_4d4() < 0) {
							break;
						}
					}

					if (var2.sub_698() > var3.sub_698()) {
						var3.var_8a = var2.var_8a;
						var3.var_65 = var2.var_65;
					}

					++var9;
					if (var2.sub_53b() < var2.sub_582()) {
						++var8;
					}

					if (var9 > 99 || var8 > 99) {
						break;
					}

					++var11;
				} while (var11 <= 10000);
			}

			var1.projectsArr[var5].var_8a = var3.var_8a;
			var1.projectsArr[var5].var_65 = var3.var_65;
		}

	}

	public void sub_2193(Project var1, int var2, int var3, int var4) {
		var1.sub_449(var2, var3);
		var1.sub_1d7(0, var4);
	}

	public void sub_21e9(Class_2a9 var1, int var2) {
		if (var1.var_f6 < 0 && var2 <= 0) {
			Random var3 = new Random();
			int var4 = this.sub_132f(var1.var_1c6);
			if (var4 <= 0) {
				return;
			}

			int var5;
			Class_4f2 var6;
			if (Math.abs(var3.nextInt() % 5) == 0) {
				var5 = Math.abs(var3.nextInt() % var4);
				var6 = this.sub_135b(var1.var_1c6, var5 + 1);
				if (var6 != null) {
					var1.sub_640(30, 0, var6.sub_1af() + var6.sub_264());
					this.sub_1601(var6);
				}

				return;
			}

			if (Math.abs(var3.nextInt() % 5) == 0) {
				var5 = Math.abs(var3.nextInt() % var4);
				var6 = this.sub_135b(var1.var_1c6, var5 + 1);
				if (var6 != null) {
					var1.sub_640(31, 0, var6.sub_1af() + var6.sub_264());
					this.sub_14c3(var1, var6);
				}

				return;
			}
		}

	}

	public void sub_2247() {
		int var1 = 40 + this.var_d39.size() * 11;
		byte var2 = 116;
		this.var_9b3 = new Class_4b3(17, (this.getWidth() - var2) / 2, (this.getHeight() - var1) / 2, var2, var1, 0,
				(Planet) null);
	}

	public void sub_2258(Class_2a9 var1) {
		int var2 = var1.sub_88e();
		String var3 = "";
		int var4 = 0;

		int var5;
		for (var5 = 0; var5 < this.var_164f.length; ++var5) {
			if (var2 >= this.var_164f[var5].price) {
				var3 = this.var_164f[var5].someStr;
				var4 = this.var_164f[var5].price;
				this.var_164f[var5].someStr = var1.playerGroupName;
				this.var_164f[var5].price = var2;
				break;
			}
		}

		for (int var6 = this.var_164f.length - 1; var6 >= var5 + 1; --var6) {
			if (var6 == var5 + 1) {
				this.var_164f[var6].someStr = var3;
				this.var_164f[var6].price = var4;
			} else {
				this.var_164f[var6].someStr = this.var_164f[var6 - 1].someStr;
				this.var_164f[var6].price = this.var_164f[var6 - 1].price;
			}
		}

		this.sub_1bcc();
	}

	public void sub_22a8(int var1) {
		String var2 = SomeUtilClass.loadDictionaryFile(this, "help");
		this.var_1965 = SomeUtilClass.sub_106(var2, "H" + var1);
		String var3 = SomeUtilClass.sub_106(var2, "P" + var1);
		if (this.var_1965 != "") {
			byte var4 = 104;
			byte var5 = 104;
			int var6 = (this.getWidth() - var4) / 2;
			int var7 = (this.getHeight() - var5) / 2;
			if (var3.length() == 2) {
				if (var3.charAt(0) == 'L') {
					var6 = 5;
				}

				if (var3.charAt(0) == 'R') {
					var6 = this.getWidth() - var4 - 5;
				}

				if (var3.charAt(1) == 'T') {
					var7 = 5;
				}

				if (var3.charAt(1) == 'B') {
					var7 = this.getHeight() - var5 - 5;
				}
			}

			this.var_19ae = new Class_4b3(20, var6, var7, var4, var5, 3158064, (Planet) null);
			this.var_19fd = var1;
		}
	}

	public void sub_22c9() {
		String var1 = SomeUtilClass.loadDictionaryFile(this, "intro");
		this.var_1807 = SomeUtilClass.sub_106(var1, "I0");
	}

	public void sub_2328() {
		if (this.gameActionState.fire) {
			if (this.var_19ae.var_3c8 == 1) {
				Class_4b3 var10000 = this.var_19ae;
				var10000.var_368 += this.var_19ae.var_cbe;
			} else {
				this.var_19ae = null;
				if (this.var_19fd == 0) {
					this.sub_22a8(1);
				}
			}
		}

		this.gameActionState.clearAllStates();
	}

	public int[] sub_2354(int var1) {
		int[] var2 = null;
		if (var1 < this.var_1a2b.size()) {
			var2 = (int[]) this.var_1a2b.elementAt(var1);
		}

		return var2;
	}

	public void sub_23b5(Graphics var1, int[] var2, int var3, int var4, int var5, int var6, boolean var7) {
		boolean var8 = false;
		boolean var9 = false;
		boolean var10 = false;
		boolean var11 = false;
		var1.setColor(var5);

		for (int var12 = 0; var12 < var2.length; ++var12) {
			int var13 = var2[var12] & 255;
			int var14 = var2[var12] >> 8 & 255;
			int var15 = var2[var12] >> 16 & 255;
			int var16 = var2[var12] >> 24 & 255;
			if (var7) {
				var13 = var6 - var13;
				var15 = var6 - var15;
				if (var6 % 2 == 0) {
					--var13;
					--var15;
				}
			}

			var1.drawLine(var3 + var13, var4 + var14, var3 + var15, var4 + var16);
		}

	}

	public void sub_23f0(Graphics var1, int var2, int var3, int var4, int var5, boolean var6) {
		int var7 = 0;
		byte var8 = 0;
		int var9 = 0;
		byte var10 = 0;
		var1.setColor(16580352);
		switch (var4) {
		case 0:
			var7 = 9;
			var8 = 4;
			var9 = 9;
			var10 = 5;
			break;
		case 1:
			var7 = 12;
			var8 = 5;
			var9 = 12;
			var10 = 7;
			break;
		case 2:
			var7 = 12;
			var8 = 7;
			var9 = 12;
			var10 = 8;
			break;
		case 3:
			var7 = 19;
			var8 = 7;
			var9 = 19;
			var10 = 11;
			break;
		case 4:
			var7 = 23;
			var8 = 7;
			var9 = 23;
			var10 = 17;
			break;
		case 5:
			var7 = 27;
			var8 = 6;
			var9 = 27;
			var10 = 14;
		}

		if (var6) {
			var7 = var5 - var7;
			var9 = var5 - var9;
			if (var5 % 2 == 0) {
				--var7;
				--var9;
			}
		}

		var1.drawLine(var2 + var7, var3 + var8, var2 + var9, var3 + var10);
	}

	public void sub_240c(Graphics var1, int var2, int var3, int var4, int var5, int var6, boolean var7, Image var8) {
		Image var9 = this.shipImgArr[var4];
		if (var8 != null) {
			var9 = var8;
		}

		var2 += (var6 - var9.getWidth()) / 2;
		var3 += (var6 - var9.getHeight()) / 2;
		if (var7) {
			this.sub_23f0(var1, var2, var3, var4, var9.getWidth(), var8 != null);
		}

		var1.drawImage(var9, var2, var3, 20);
		int var10 = this.sub_121c(var5);
		if (var4 != 0 || var10 != 13843735) {
			int[] var11 = this.sub_2354(var4);
			if (var11 != null) {
				this.sub_23b5(var1, var11, var2, var3, var10, var9.getWidth(), var8 != null);
			}

		}
	}
}
