import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class SomeUtilClass {
   public static final int[] var_19 = new int[]{16711680, 15013888, 12401408, 9397248, 4760576, 194048, 3538688, 9174784, 12320512, 15007488, 16776960};
   public static final String[] scienceBranchNamesArr = new String[]{"ФИЗИКА", "ХИМИЯ", "КОМПЬЮТЕРЫ", "БИОЛОГИЯ", "СОЦИОЛОГИЯ"};
   public static final String[] scienceBranchNames2Arr = new String[]{"ФИЗИКИ", "ХИМИИ", "КОМПЬЮТЕРОВ", "БИОЛОГИИ", "СОЦИОЛОГИИ"};
   public static final String[] enemyNamesArr = new String[]{"ВАРТА", "ДОЛГ", "СВОБОДА", "БАНДИТЫ", "НАЕМНИКИ"};

   public static int sub_21(int var0, int var1, int var2, int var3) {
      return var2 << 8 | var1 << 16 | var0 << 24 | var3;
   }

   public static int sub_73(int var0) {
      switch(var0) {
      case 0:
         return sub_21(12, 4, 3, 3);
      case 1:
         return sub_21(10, 3, 4, 3);
      case 2:
         return sub_21(12, 4, 3, 4);
      case 3:
         return sub_21(4, 1, 6, 3);
      case 4:
         return sub_21(4, 1, 5, 6);
      case 5:
         return sub_21(8, 3, 3, 6);
      case 6:
         return sub_21(6, 2, 2, 2);
      case 7:
         return sub_21(20, 5, 5, 5);
      case 8:
         return sub_21(15, 3, 2, 6);
      default:
         return 0;
      }
   }

   public static String getStr(String str) {
      return str;
   }

   public static void sub_e6(String var0, String[] var1) {
      boolean var2 = false;
      int var3 = 0;
      int var4 = 0;

      while(true) {
         int var5 = var0.indexOf(10, var3);
         if (var5 == -1 || var4 >= var1.length) {
            break;
         }

         var1[var4] = var0.substring(var3, var5 - 1);
         var3 = var5 + 1;
         if (var5 >= var0.length()) {
            break;
         }

         ++var4;
      }

   }

   public static String sub_106(String var0, String var1) {
      int var2 = var0.indexOf(var1 + "=");
      if (var2 == -1) {
         return "";
      } else {
         var2 += var1.length() + 1;
         int var3 = var0.indexOf(10, var2);
         return var3 < var2 ? "" : var0.substring(var2, var3 - 1);
      }
   }

   public static String loadDictionaryFile(GameScreen gameScreen, String fileName) {
      String textData = "";
      InputStream inputStream = gameScreen.getClass().getResourceAsStream("/texts/" + fileName + ".txt");
      if (inputStream == null) {
         return "";
      } else {
         try {
            textData = readDataFromTextFile(inputStream);
            inputStream.close();
            return textData;
         } catch (IOException var5) {
            return "";
         }
      }
   }

   public static String readDataFromTextFile(InputStream inputStream) {
      StringBuffer buffer = null;
	try {
		buffer = new StringBuffer(inputStream.available());
		
	      int var2;
	      for(boolean var3 = false; -1 != (var2 = inputStream.read()); buffer.append((char)var2)) {
	         if (var2 > 191) {
	            var2 += 848;
	         } else if (var2 >= 128) {
	            if (var2 == 184) {
	               var2 = 63;
	            } else if (var2 == 168) {
	               var2 = 1080;
	            } else {
	               var2 = 63;
	            }
	         }
	      }

	     
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return buffer.toString();

   }

   public static int sub_1a5(String var0, int var1) {
      return sub_1c6(var0, var1, 5 + 4);
   }

   public static int sub_1c6(String var0, int var1, int var2) {
      new String();
      int var4 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;

      int var9;
      do {
         var9 = var0.indexOf(32, var4);
         if (var9 <= 0) {
            var9 = var0.length();
         }

         String var3 = var0.substring(var4, var9);
         int var10000 = var3.length();
         if (var10000 * 5 + var7 > var1) {
            var8 += var2;
            ++var6;
            var7 = 0;
         }

         int var10 = 5 * var3.length();
         var7 += var10 + 5;
         var4 = var9 + 1;
      } while(var9 < var0.length());

      return var6 + 1;
   }

   public static boolean drawLittleTextInRect2(Graphics g, String str, int xPos, int yPos, int width, int length) {
      return drawLittleTextInRect(g, str, xPos, yPos, width, length, 5 + 4);
   }

   public static boolean drawLittleTextInRect(Graphics g, String str, int xPos, int yPos, int width, int length, int yStep) {
      int var8 = 0;
      int var11 = 0;
      boolean var12 = false;
      int curXPos = xPos;
      int curYPos = yPos;

      while(true) {
         int var15 = str.indexOf(32, var8);
         int var16 = str.indexOf(10, var8);
         if (var16 >= 0 && var16 < var15) {
            var15 = var16;
            var12 = true;
         } else {
            var12 = false;
         }

         if (var15 <= 0) {
            var15 = str.length();
         }

         String var7 = str.substring(var8, var15);
         int var10000 = var7.length();
         if (var10000 * 5 + curXPos > width) {
            curYPos += yStep;
            ++var11;
            curXPos = xPos;
            if (curYPos >= length) {
               break;
            }
         }

         GameScreen.gameScreen.sub_fcf(g, curXPos, curYPos, var7, GameScreen.gameScreen.rMiniFront2Img);
         int var17 = 5 * var7.length();

         curXPos += var17 + 5;
         var8 = var15 + 1;
         if (var15 >= str.length()) {
            break;
         }

         if (var12) {
            curYPos += yStep;
            ++var11;
            curXPos = xPos;
            if (curYPos >= length) {
               break;
            }
         }
      }

      return false;
   }

   public static int sub_28f(int var0, int var1) {
      int var2 = var0 >> 16 & 255;
      int var3 = var0 >> 8 & 255;
      int var4 = var0 & 255;
      var2 -= var1;
      var3 -= var1;
      var4 -= var1;
      if (var2 < 0) {
         var2 = 0;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      if (var4 < 0) {
         var4 = 0;
      }

      if (var2 > 255) {
         var2 = 255;
      }

      if (var3 > 255) {
         var3 = 255;
      }

      if (var4 > 255) {
         var4 = 255;
      }

      return var2 << 16 | var3 << 8 | var4;
   }

   public static int sub_2ed(int var0) {
      int var1 = -1;

      for(int var2 = 1; var0 >= 0; ++var1) {
         var0 -= var2;
         var2 += 2;
      }

      return var1;
   }

   //Draws some strange 3 line figure...
   public static void drawSomeLittleFigure(Graphics g, int x1, int y1, int colorInt) {
      g.setColor(colorInt);
      g.drawLine(x1 + 4, y1 + 1, x1 + 5, y1 + 1);
      g.drawLine(x1 + 4, y1 + 6, x1 + 5, y1 + 6);
      g.drawLine(x1 + 7, y1 + 3, x1 + 7, y1 + 4);
   }

   public static String getStepsStr(int steps) {
      if (steps == 1) {
         return steps + " " + getStr("ХОД");
      } else {
         return steps >= 2 && steps <= 4 ? steps + " " + getStr("ХОДА") : steps + " " + getStr("ХОДОВ");
      }
   }

   public static void deleteRecordFromStore(String recordStoreName) {
      try {
         RecordStore.deleteRecordStore(recordStoreName);
      } catch (RecordStoreException var2) {
      }

   }
}
