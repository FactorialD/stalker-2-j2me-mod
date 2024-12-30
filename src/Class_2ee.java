import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Class_2ee extends Class_4b3 {
   public int var_3b = 0;
   public Image[] cImgArr = new Image[3];
   public Image[] crImgArr = new Image[3];
   public Image symRightImg = null;
   public boolean[] var_1c7 = null;
   public int var_218;
   public int var_244;
   public int var_256 = 0;
   public int var_270;
   public boolean var_2b1;
   public int var_2ca;
   public boolean var_32a;
   public boolean var_376;
   public Vector var_3c2;
   public int var_3d5 = -1;
   public int var_42a = -1;
   public Image var_43c = null;
   public String var_448 = "";
   public String var_487 = "";
   public String var_4ac = "";
   public int var_507 = 0;
   public boolean var_552 = false;
   public int var_5ae = 9;

   public Class_2ee(int var1, int var2, Planet var3, int var4, Class_2a9 var5) {
      super(0, 0, 0, 0, 0, 3158064, (Planet)null);
      super.var_124 = 106;
      super.var_c7c = super.var_124;
      super.var_b2b = 1;
      super.var_cbe = 3;
      if (var4 > 3) {
         try {
            super.curUpImg = Image.createImage("/images/cur_up.png");
            super.curDownImg = Image.createImage("/images/cur_down.png");
            super.polImg = Image.createImage("/images/pol.png");
         } catch (IOException var8) {
         }
      } else {
         super.var_124 -= 12;
      }

      try {
         this.cImgArr[0] = Image.createImage("/images/c0.png");
         this.cImgArr[1] = Image.createImage("/images/c1.png");
         this.cImgArr[2] = Image.createImage("/images/c2.png");
         this.crImgArr[0] = Image.createImage("/images/cr0.png");
         this.crImgArr[1] = Image.createImage("/images/cr1.png");
         this.crImgArr[2] = Image.createImage("/images/cr2.png");
         this.symRightImg = Image.createImage("/images/sym_right.png");
         super.blueLineImg = Image.createImage("/images/blueline.png");
         super.rPanelImg = Image.createImage("/images/rpanel.png");
         super.rHouseImg = Image.createImage("/images/rhouse.png");
      } catch (IOException e) {
      }

      this.var_1c7 = new boolean[var4];

      int var6;
      for(var6 = 0; var6 < this.var_1c7.length; ++var6) {
         this.var_1c7[var6] = true;
      }

      super.yPos = GameScreen.gameScreen.getHeight() - DESC_WINDOW_HEIGHT;
      this.var_2ca = 2;
      this.var_32a = GameScreen.gameScreen.sub_15d8(GameScreen.gameScreen.someXCellPos, GameScreen.gameScreen.someYCellPos, 1).sub_236() == var5.var_1c6;
      if (this.var_32a) {
         this.var_376 = true;
      } else {
         this.var_376 = false;
      }

      super.var_53a = var5;
      super.somePlanet = var3;
      if (var3 != null) {
         if (!this.var_32a) {
            this.addMenu1Option(0, super.yPos + 9, SomeUtilClass.getStr("О ЛАГЕРЕ"), true);
         } else {
            if (var3.var_1df != null && var3.var_1df.var_4f == var5.var_1c6) {
               this.addMenu1Option(0, super.yPos + 9, SomeUtilClass.getStr("ЛАГЕРЬ"), true);
               this.var_2ca = 0;
            } else if (this.sub_173() && var3.var_1df == null) {
               this.addMenu1Option(0, super.yPos + 9, SomeUtilClass.getStr("ОСНОВАТЬ ЛАГЕРЬ"), true);
               this.var_2ca = 1;
               if (super.var_124 < 106) {
                  super.var_124 = 106;
               }
            } else {
               this.addMenu1Option(0, super.yPos + 9, SomeUtilClass.getStr("О ЛАГЕРЕ"), true);
            }

            this.addMenu1Option(0, super.yPos + 19, SomeUtilClass.getStr("ОТПРАВИТЬ"), true);
         }
      } else {
         super.var_3c8 = 2;
      }

      super.var_43b = null;
      super.var_6f5 = new Random();
      this.var_270 = 0;
      this.var_2b1 = false;
      this.var_3c2 = new Vector();

      for(var6 = 0; var6 < var4; ++var6) {
         this.var_3c2.addElement(GameScreen.gameScreen.sub_1648(var6 + 1));
      }

      super.windowHeight = super.var_b2b * 30 + 18;
      if (super.menuOptions2Arr != null) {
         switch(super.menuOptions2Arr.size()) {
         case 0:
         default:
            break;
         case 1:
            super.windowHeight += 10;
            super.yPos -= 10;
            this.var_5ae += 10;
            break;
         case 2:
            super.windowHeight += 20;
            super.yPos -= 20;
            this.var_5ae += 20;
         }
      }

      super.var_e5a = 3;
   }

   public void sub_2b(Graphics var1) {
      int var5;
      int var6;
      int var7;
      if (super.var_3c8 == 3) {
         String var10 = SomeUtilClass.getStr("ВЫБЕРИТЕ");
         int var12 = var1.getClipHeight() - 35;
         GameScreen.gameScreen.drawFancyText(var1, (var1.getClipWidth() - var10.length() * 8) / 2, var12, var10, super.var_42f);
         var12 += 10;
         var10 = SomeUtilClass.getStr("ЦЕЛЬ ХОДКИ");
         GameScreen.gameScreen.drawFancyText(var1, (var1.getClipWidth() - var10.length() * 8) / 2, var12, var10, super.var_42f);
         Planet var13 = GameScreen.gameScreen.sub_76d(GameScreen.gameScreen.someXCellPos, GameScreen.gameScreen.someYCellPos);
         this.var_2b1 = false;
         if (var13 != null) {
            var5 = GameScreen.gameScreen.sub_16be(this.var_218, this.var_244, GameScreen.gameScreen.someXCellPos, GameScreen.gameScreen.someYCellPos);
            var6 = this.sub_237();
            GameScreen.gameScreen.sub_10f9(var1, var1.getClipWidth() - this.var_270, GameScreen.gameScreen.var_8e4 + 5, this.var_270, 13, 880901, 3);
            if (var5 <= this.sub_26b(var6)) {
               if (this.var_270 < 70) {
                  this.var_270 += 10;
               }

               if (this.var_270 > 70) {
                  this.var_270 -= 10;
               }

               this.var_2b1 = true;
               if (this.var_270 == 70) {
                  var7 = GameScreen.gameScreen.sub_16cc(this.var_218, this.var_244, GameScreen.gameScreen.someXCellPos, GameScreen.gameScreen.someYCellPos, var6, GameScreen.gameScreen.var_d5c.var_1c6);
                  GameScreen.gameScreen.drawFancyText(var1, var1.getClipWidth() - this.var_270 + 5, GameScreen.gameScreen.var_8e4 + 5 + 4, SomeUtilClass.getStepsStr(var7), super.var_42f);
               }
            } else {
               if (this.var_270 < 110) {
                  this.var_270 += 10;
               }

               if (this.var_270 > 110) {
                  this.var_270 -= 10;
               }

               if (this.var_270 == 110) {
                  GameScreen.gameScreen.drawFancyText(var1, var1.getClipWidth() - this.var_270 + 5, GameScreen.gameScreen.var_8e4 + 5 + 4, SomeUtilClass.getStr("НЕ ДОЙТИ"), super.var_42f);
               }
            }
         } else if (this.var_270 > 0) {
            GameScreen.gameScreen.sub_10f9(var1, var1.getClipWidth() - this.var_270, GameScreen.gameScreen.var_8e4 + 5, this.var_270, 13, 880901, 3);
            this.var_270 -= 10;
         }

      } else {
         byte var2 = 0;
         if (super.var_1f3 < super.var_124) {
            super.var_1f3 += 20;
         }

         if (super.var_1f3 > super.var_124) {
            super.var_1f3 = super.var_124;
         }

         int var9 = var2 - super.var_124 + super.var_1f3;
         int var4;
         if (super.var_c28 == null) {
            super.var_c28 = Image.createImage(super.var_124, super.windowHeight);
            Graphics var3 = super.var_c28.getGraphics();
            var3.setColor(0);
            var3.fillRect(0, 0, super.var_124, super.windowHeight);
            var3.setColor(1052688);
            var3.fillRect(0, 9, super.var_124 - 5, super.windowHeight - 18);
            this.sub_788(var3, 0, 0, super.var_124, super.windowHeight);
            var3.setColor(2171169);
            super.rPanelImg = null;
            var4 = 0;

            for(var5 = 1; var5 <= super.var_cbe; ++var5) {
               var4 += 30;
               var3.drawLine(var4, this.var_5ae, var4, super.var_b2b * 30 + this.var_5ae - 1);
            }

            if (this.var_5ae > 9) {
               var3.drawLine(0, this.var_5ae - 1, super.var_124 - 5, this.var_5ae - 1);
            }

            if (this.var_5ae > 19) {
               var3.drawLine(0, this.var_5ae - 11, super.var_124 - 5, this.var_5ae - 11);
            }
         } else {
            var1.drawImage(super.var_c28, var9, super.yPos, 20);
         }

         this.sub_2a4(var1, var9);
         var4 = super.yPos + this.var_5ae;
         var6 = var9;

         int var8;
         Class_4f2 var11;
         for(var7 = 0; var7 < super.var_cbe; ++var7) {
            var5 = super.var_368 * super.var_cbe + var7;
            if (var5 >= this.var_3c2.size()) {
               break;
            }

            var11 = (Class_4f2)this.var_3c2.elementAt(var5);
            if (this.var_3b == var5 && super.var_3c8 == 2) {
               var1.drawImage(GameScreen.gameScreen.selShipImg, var6 + 1, var4 + 1, 20);
               var1.setColor(0);
               var1.fillRect(var6 + 2, var4 + 2, 26, 26);
               if (Math.abs(super.var_6f5.nextInt() % 3) == 0) {
                  this.sub_2bf(var6 + 2, var4 + 2, 25, 25);
               }

               this.sub_2d0(var1);
            }

            if (var11 != null) {
               var8 = var11.sub_18d(28);
               GameScreen.gameScreen.sub_240c(var1, var6, var4, var8, var11.sub_236(), 30, this.var_3b == var5 && super.var_3c8 == 2, (Image)null);
               GameScreen.gameScreen.sub_fcf(var1, var6 + 3, var4 + 3, "" + var11.sub_264(), GameScreen.gameScreen.rMiniFrontImg);
               if (this.var_32a) {
                  this.sub_73d(var1, var6 + 4, var4 + 26, var11.var_195);
                  this.sub_5de(var1, var6 + 24, var4 + 5, var11.var_1ef);
                  if (this.var_1c7[var5] && super.somePlanet != null) {
                     GameScreen.gameScreen.sub_fcf(var1, var6 + 9, var4 + 20, SomeUtilClass.getStr("ВЫБ"), GameScreen.gameScreen.rMiniFront2Img);
                  }
               }
            }

            var6 += 30;
         }

         var7 = this.var_1c7.length / super.var_cbe;
         if (var7 * super.var_cbe < this.var_1c7.length) {
            ++var7;
         }

         if (var7 > super.var_b2b) {
            var1.drawImage(super.curUpImg, var9 + super.var_124 - 12, super.yPos + this.var_5ae + 2, 20);
            var1.drawImage(super.curDownImg, var9 + super.var_124 - 12, super.yPos + super.windowHeight - 14, 20);
            var8 = super.var_368 * (super.var_b2b * 30 - 18) / (var7 - super.var_b2b);
            var1.drawImage(super.polImg, var9 + super.var_124 - 12, super.yPos + var8 + this.var_5ae + 7, 20);
         }

         var11 = (Class_4f2)this.var_3c2.elementAt(this.var_3b);
         this.sub_806(var1, var11, super.var_3c8 == 2);
      }
   }

   public void sub_52() {
      if (super.var_3c8 != 3 && super.somePlanet != null) {
         if (super.var_3c8 > 0) {
            --super.var_3c8;
         }

         super.rectArr = null;
         if (!this.var_32a && super.var_3c8 == 1) {
            super.var_3c8 = 0;
         }

      }
   }

   public void sub_60() {
      if (super.var_3c8 != 3 && super.somePlanet != null) {
         if (super.var_3c8 < 2) {
            ++super.var_3c8;
         }

         if (!this.var_32a && super.var_3c8 == 1) {
            super.var_3c8 = 2;
         }

      }
   }

   public void sub_af() {
      if (super.var_3c8 == 2) {
         if (this.var_3b < this.var_1c7.length - 1) {
            ++this.var_3b;
            super.rectArr = null;
         }

         if (this.var_3b - super.var_368 * super.var_cbe >= super.var_cbe * super.var_b2b) {
            ++super.var_368;
         }

      }
   }

   public void sub_e4() {
      if (super.var_3c8 == 2) {
         if (this.var_3b > 0) {
            --this.var_3b;
            super.rectArr = null;
         }

         if (this.var_3b < super.var_368 * super.var_cbe) {
            --super.var_368;
         }

      }
   }

   public void sub_134(int var1, int var2) {
      for(int var4 = 0; var4 < this.var_1c7.length; ++var4) {
         Class_4f2 var3 = GameScreen.gameScreen.sub_1648(var4 + 1);
         if (this.var_1c7[var4]) {
            var3.sub_2d0(var1, var2);
         }
      }

   }

   public boolean sub_173() {
      for(int var2 = 0; var2 < this.var_1c7.length; ++var2) {
         Class_4f2 var1 = GameScreen.gameScreen.sub_1648(var2 + 1);
         if (var1.sub_613()) {
            return true;
         }
      }

      return false;
   }

   public void sub_194(Graphics var1, int var2, int var3, boolean var4) {
      if (GameScreen.gameScreen.sub_16be(this.var_218, this.var_244, GameScreen.gameScreen.someXCellPos, GameScreen.gameScreen.someYCellPos) <= this.sub_26b(this.sub_237())) {
         this.var_2b1 = true;
      } else {
         this.var_2b1 = false;
      }

      int var6 = this.var_256;

      for(int var7 = 0; var7 < 3; ++var7) {
         Image var5;
         if (this.var_2b1) {
            var5 = this.cImgArr[var6];
         } else {
            var5 = this.crImgArr[var6];
         }

         var1.drawImage(var5, var2 - (5 + var7 * 3), var3 - (5 + var7 * 3), 20);
         var1.drawImage(var5, var2 + 3 + var7 * 3, var3 + 3 + var7 * 3, 20);
         var1.drawImage(var5, var2 - (5 + var7 * 3), var3 + 3 + var7 * 3, 20);
         var1.drawImage(var5, var2 + 3 + var7 * 3, var3 - (5 + var7 * 3), 20);
         ++var6;
         if (var6 > 2) {
            var6 = 0;
         }
      }

      if (var4) {
         ++this.var_256;
         if (this.var_256 > 2) {
            this.var_256 = 0;
         }
      }

   }

   public int sub_1c2() {
      if (this.var_42a != this.var_3b) {
         Class_4f2 var1 = (Class_4f2)this.var_3c2.elementAt(this.var_3b);
         if (var1.sub_599()) {
            this.var_507 = 26;
         } else {
            this.var_507 = 14;
         }
      }

      return this.var_507;
   }

   public void sub_1dd(Graphics var1, int var2) {
      Class_4f2 var3 = (Class_4f2)this.var_3c2.elementAt(this.var_3b);
      byte var4 = 5;
      if (this.var_42a != this.var_3b) {
         this.var_43c = GameScreen.gameScreen.sub_1194(var3.sub_236());
         if (this.var_376) {
            this.var_448 = var3.sub_64d();
         } else {
            this.var_448 = SomeUtilClass.getStr("А:") + "?" + " " + SomeUtilClass.getStr("З:") + "?" + " " + SomeUtilClass.getStr("В:") + "?";
         }

         if (var3.sub_599()) {
            this.var_487 = GameScreen.gameScreen.sub_1693(var3);
            int var5 = GameScreen.gameScreen.sub_16cc(var3.sub_309(), var3.sub_31a(), var3.sub_362(), var3.sub_3a1(), GameScreen.gameScreen.sub_145e(var3.sub_1f2()), GameScreen.gameScreen.var_d5c.var_1c6);
            if (var5 != 65535) {
               this.var_4ac = SomeUtilClass.getStepsStr(var5);
            }
         }

         this.var_42a = this.var_3b;
      }

      if (this.var_43c != null) {
         var1.drawImage(this.var_43c, var2, var4 - 4, 20);
      }

      GameScreen.gameScreen.sub_fcf(var1, var2 + 15, var4, this.var_448, GameScreen.gameScreen.rMiniFront2Img);
      if (var3.sub_599()) {
         int var6 = var4 + 13;
         var1.drawImage(this.symRightImg, var2, var6 - 4, 20);
         GameScreen.gameScreen.sub_fcf(var1, var2 + 15, var6 - 1, this.var_487, GameScreen.gameScreen.rMiniFront2Img);
         GameScreen var10000 = GameScreen.gameScreen;
         int var10002 = var2 + 110;
         int var10003 = this.var_4ac.length();
         GameScreen var10004 = GameScreen.gameScreen;
         var10000.sub_fcf(var1, var10002 - var10003 * 5 - 5, var6 - 1, this.var_4ac, GameScreen.gameScreen.rMiniFront2Img);
      }
   }

   public int sub_237() {
      int var1 = 268435455;

      for(int var3 = 0; var3 < this.var_1c7.length; ++var3) {
         if (this.var_1c7[var3]) {
            Class_4f2 var2 = (Class_4f2)this.var_3c2.elementAt(var3);
            if (var2 != null && var1 > var2.sub_530()) {
               var1 = var2.sub_530();
            }
         }
      }

      if (var1 == 268435455) {
         return 0;
      } else {
         return var1;
      }
   }

   public int sub_26b(int var1) {
      return super.somePlanet != null && super.somePlanet.var_1df != null && super.var_53a.var_1c6 == super.somePlanet.var_1df.var_4f ? var1 * 6 : var1 * 4;
   }

   public void sub_2a4(Graphics g, int var2) {
      if (super.menuOptions2Arr != null) {
         for(int var4 = 0; var4 < super.menuOptions2Arr.size(); ++var4) {
            MenuOptionDto var3 = (MenuOptionDto)super.menuOptions2Arr.elementAt(var4);
            if (super.var_3c8 == var4) {
               this.sub_8d8(g, var2 - 5, var3.yPos - 2 - this.var_5ae + 4, super.var_124 - 4, super.blueLineImg);
            }

            if (this.var_2ca == 0 && var4 == 0) {
               GameScreen.gameScreen.drawFancyText(g, var2 + 2 + 16, var3.yPos - this.var_5ae + 9, var3.str, super.var_42f);
            } else {
               GameScreen.gameScreen.drawFancyText(g, var2 + 2, var3.yPos - this.var_5ae + 9, var3.str, super.var_42f);
            }

            if (this.var_2ca == 0 && var4 == 0) {
               g.drawImage(super.rHouseImg, var2 + 1, var3.yPos - 1 - this.var_5ae + 9, 20);
            }
         }

      }
   }
}
