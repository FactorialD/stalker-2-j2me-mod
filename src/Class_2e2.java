import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Class_2e2 extends Class_4b3 {
   public Vector var_2b;
   public int var_83;
   public int var_d1;
   public int var_f5;
   public int var_135;
   public int var_166;
   public Image var_18d = null;
   public int var_1be = -1;

   public Class_2e2(int var1, int var2, int var3, int var4, int var5, int var6) {
      super(0, var2, var3, var4, var5, var6, (Planet)null);
      super.var_c7c = var5;
      this.var_135 = var1;
      this.var_83 = super.yPos + 25;
      this.var_d1 = super.yPos + var5 - 35;
      this.var_f5 = super.xPos + 5;
      super.var_5d4 = false;
      super.var_1f3 = var5;
      String var7 = "";
      switch(this.var_135) {
      case 1:
         var7 = SomeUtilClass.getStr("ВЕС");
         break;
      case 2:
         var7 = SomeUtilClass.getStr("ВЫНОСЛИВОСТЬ");
         break;
      case 3:
         var7 = SomeUtilClass.getStr("БРОНЯ");
         break;
      case 4:
         var7 = SomeUtilClass.getStr("БОЕПРИПАСЫ");
         break;
      case 5:
         var7 = SomeUtilClass.getStr("МОЩНОСТЬ");
      case 6:
      case 7:
      case 8:
      case 9:
      default:
         break;
      case 10:
         var7 = SomeUtilClass.getStr("ХОДОВ");
         super.var_6f5 = new Random();
         --this.var_d1;
      }

      if (var7 != "") {
         int var10001 = super.xPos + super.var_124;
         int var10002 = var7.length();
         GameScreen var10003 = GameScreen.gameScreen;
         this.addMenu2Option(var10001 - var10002 * 5 - 5, this.var_83 - 10, var7, false);
      }

      this.addMenu2Option(super.xPos + 5, this.var_83 - 10, SomeUtilClass.getStr("ИМЯ"), false);
   }

   public void sub_4b(String upgradeName, int var2) {
      if (this.var_2b == null) {
         this.var_2b = new Vector();
      }

      UpgradeDto var3 = new UpgradeDto(this);
      var3.upgradeName = upgradeName;
      var3.var_2e = var2;
      this.var_2b.addElement(var3);
      this.var_166 = 0;

      for(int var5 = 0; var5 < this.var_2b.size(); ++var5) {
         GameScreen var10002 = GameScreen.gameScreen;
         int var4 = this.var_83 + var5 * (5 + 3);
         GameScreen var10001 = GameScreen.gameScreen;
         if (var4 + 5 + 3 >= this.var_d1) {
            break;
         }

         ++this.var_166;
      }

      if (this.var_166 < this.var_2b.size()) {
         this.var_f5 = super.xPos + 5 + 8;
         if (super.curUpImg == null) {
            try {
               super.curUpImg = Image.createImage("/images/cur_up.png");
               super.curDownImg = Image.createImage("/images/cur_down.png");
               super.polImg = Image.createImage("/images/pol.png");
            } catch (IOException var6) {
            }
         }
      }

   }

   public void sub_90(Graphics var1) {
      int var2 = 0;
      this.sub_108(var1);
      var1.setColor(4573456);
      var1.setStrokeStyle(1);
      int var10001 = super.xPos + 5;
      int var10002 = this.var_83 - 10;
      GameScreen var10003 = GameScreen.gameScreen;
      var10002 = var10002 + 5 + 2;
      int var9 = super.xPos + super.var_124 - 5;
      int var10004 = this.var_83 - 10;
      GameScreen var10005 = GameScreen.gameScreen;
      var1.drawLine(var10001, var10002, var9, var10004 + 5 + 2);
      var1.setStrokeStyle(0);
      boolean var3 = false;
      this.var_166 = 0;
      int var5;
      if (this.var_2b != null) {
         for(var5 = super.var_368; var5 < this.var_2b.size(); ++var5) {
            UpgradeDto var4 = (UpgradeDto)this.var_2b.elementAt(var5);
            var10001 = var5 - super.var_368;
            GameScreen var8 = GameScreen.gameScreen;
            int var6 = this.var_83 + var10001 * (5 + 3);
            GameScreen var7 = GameScreen.gameScreen;
            if (var6 + 5 + 3 >= this.var_d1) {
               break;
            }

            if (super.var_3c8 == var5) {
               var1.setColor(2565927);
               var1.fillRect(this.var_f5, var6 + 2, super.var_124 - 5 - (this.var_f5 - super.xPos), 6);
               var1.setColor(3750201);
               var1.drawLine(this.var_f5, var6 + 8, super.xPos + super.var_124 - 5, var6 + 8);
               var1.setColor(4013373);
               var1.drawLine(super.xPos + super.var_124 - 5, var6 + 2, super.xPos + super.var_124 - 5, var6 + 8);
               this.sub_10d(var1, var4.var_2e);
            }

            if (this.var_135 == 10 && var4.var_2e >= 4095) {
               GameScreen.gameScreen.sub_fcf(var1, this.var_f5, var6, var4.upgradeName, GameScreen.gameScreen.rMiniFrontImg);
            } else {
               GameScreen.gameScreen.sub_fcf(var1, this.var_f5, var6, var4.upgradeName, GameScreen.gameScreen.rMiniFront2Img);
            }

            this.sub_c9(var1, var6, var4.var_2e);
            var2 = var6;
            ++this.var_166;
         }
      }

      if (this.var_135 != 11) {
         if (super.curUpImg != null) {
            var1.drawImage(super.curUpImg, super.xPos + 5, this.var_83, 20);
            var1.drawImage(super.curDownImg, super.xPos + 5, var2, 20);
            var5 = var2 - (this.var_83 + super.curUpImg.getHeight() + 2) - super.polImg.getHeight();
            var5 = this.var_83 + super.curUpImg.getHeight() + var5 * (super.var_3c8 + 1) / this.var_2b.size();
            var1.drawImage(super.polImg, super.xPos + 5, var5, 20);
         }

      }
   }

   public void sub_c9(Graphics var1, int var2, int var3) {
      String var4 = "";
      switch(this.var_135) {
      case 1:
         var4 = "" + GameScreen.gameScreen.var_1058[var3].someInt1;
         break;
      case 2:
         var4 = "" + GameScreen.gameScreen.var_1095[var3].someInt3;
         break;
      case 3:
         var4 = "" + GameScreen.gameScreen.var_10d4[var3].someInt3;
         break;
      case 4:
         var4 = "" + GameScreen.gameScreen.var_1116[var3].someInt3;
         break;
      case 5:
         var4 = "" + GameScreen.gameScreen.var_1171[var3].someInt3;
      case 6:
      case 7:
      case 8:
      case 9:
      default:
         break;
      case 10:
         if (super.var_4dd == null) {
            var4 = "0";
         } else {
            var4 = "" + super.var_4dd.var_1df.sub_402(var3, super.var_4dd.sub_35d(GameScreen.gameScreen.sub_122a(super.var_4dd.var_1df.var_4f)));
         }
      }

      int var10000 = super.xPos + super.var_124;
      int var10001 = var4.length();
      GameScreen var10002 = GameScreen.gameScreen;
      int var5 = var10000 - var10001 * 5 - 10;
      if (this.var_135 == 10 && var3 >= 4095) {
         GameScreen.gameScreen.sub_fcf(var1, var5, var2, var4, GameScreen.gameScreen.rMiniFrontImg);
      } else {
         GameScreen.gameScreen.sub_fcf(var1, var5, var2, var4, GameScreen.gameScreen.rMiniFront2Img);
      }

   }

   public void sub_10d(Graphics var1, int var2) {
      String var3 = "";
      if (this.var_135 >= 1 && this.var_135 <= 5) {
         this.sub_514(var1, super.xPos + 5, this.var_d1, super.var_124 - 10, 30);
      }

      if (this.var_135 == 10) {
         if (var2 >= 4095) {
            this.sub_514(var1, super.xPos + 5, this.var_d1, super.var_124 - 10 - 35, 30);
         } else {
            this.sub_514(var1, super.xPos + 5, this.var_d1, super.var_124 - 10, 30);
         }
      }

      switch(this.var_135) {
      case 1:
         this.sub_186(var1, this.var_d1 + 5, "ЦЕНА:", GameScreen.gameScreen.var_1058[var2].someInt2 + " K");
         this.sub_186(var1, this.var_d1 + 5 + 8, "ВЕС:", "" + GameScreen.gameScreen.var_1058[var2].someInt1);
         break;
      case 2:
         this.sub_186(var1, this.var_d1 + 5, "ВЕС:", "" + GameScreen.gameScreen.var_1095[var2].someInt1);
         this.sub_186(var1, this.var_d1 + 5 + 8, "ЦЕНА:", GameScreen.gameScreen.var_1095[var2].someInt2 + " K");
         this.sub_186(var1, this.var_d1 + 5 + 8 + 8, "ВЫНОСЛИВОСТЬ:", "" + GameScreen.gameScreen.var_1095[var2].someInt3);
         break;
      case 3:
         this.sub_186(var1, this.var_d1 + 5, "ВЕС:", "" + GameScreen.gameScreen.var_10d4[var2].someInt1);
         this.sub_186(var1, this.var_d1 + 5 + 8, "ЦЕНА:", GameScreen.gameScreen.var_10d4[var2].someInt2 + " K");
         this.sub_186(var1, this.var_d1 + 5 + 8 + 8, "БРОНЯ:", "" + GameScreen.gameScreen.var_10d4[var2].someInt3);
         break;
      case 4:
         this.sub_186(var1, this.var_d1 + 5, "ВЕС:", "" + GameScreen.gameScreen.var_1116[var2].someInt1);
         this.sub_186(var1, this.var_d1 + 5 + 8, "ЦЕНА:", GameScreen.gameScreen.var_1116[var2].someInt2 + " K");
         this.sub_186(var1, this.var_d1 + 5 + 8 + 8, "СКОРОСТЬ:", "" + GameScreen.gameScreen.var_1116[var2].someInt3);
         break;
      case 5:
         this.sub_186(var1, this.var_d1 + 5, "ВЕС:", "" + GameScreen.gameScreen.var_1171[var2].someInt1);
         this.sub_186(var1, this.var_d1 + 5 + 8, "ЦЕНА:", GameScreen.gameScreen.var_1171[var2].someInt2 + " K");
         this.sub_186(var1, this.var_d1 + 5 + 8 + 8, "МОЩНОСТЬ:", "" + GameScreen.gameScreen.var_1171[var2].someInt3);
      case 6:
      case 7:
      case 8:
      case 9:
      default:
         break;
      case 10:
         if (var2 == 255) {
            if (this.var_1be != super.var_3c8) {
               this.sub_152(super.var_124 - 13, 25, 2171169);
               SomeUtilClass.sub_1db(this.var_18d.getGraphics(), SomeUtilClass.getStr("УВЕЛИЧИВАЕТСЯ ПРИРОСТ НАСЕЛЕНИЯ В ЛАГЕРЕ"), 0, 0, super.var_124 - 13, 25);
            }
         } else if (var2 == 511) {
            if (this.var_1be != super.var_3c8) {
               this.sub_152(super.var_124 - 13, 25, 2171169);
               SomeUtilClass.sub_1db(this.var_18d.getGraphics(), SomeUtilClass.getStr("УВЕЛИЧИВАЕТСЯ ДОХОД ЛАГЕРЯ"), 0, 0, super.var_124 - 13, 25);
            }
         } else if (var2 == 767) {
            if (this.var_1be != super.var_3c8) {
               this.sub_152(super.var_124 - 13, 25, 2171169);
               SomeUtilClass.sub_1db(this.var_18d.getGraphics(), SomeUtilClass.getStr("ОТРЯД СТАЛКЕРОВ ДЛЯ СОЗДАНИЯ НОВОГО ЛАГЕРЯ"), 0, 0, super.var_124 - 13, 25);
            }
         } else {
            if (var2 >= 4095) {
               GameScreen.gameScreen.var_d5c.projectsArr[var2 - 4095].sub_62f(var1, super.xPos + 8, this.var_d1 + 5, super.var_124 - 10 - 35, 30);
               int var4 = super.xPos + 5 + super.var_124 - 10 - 30;
               var1.drawImage(GameScreen.gameScreen.selShipImg, var4, this.var_d1 + 2, 20);
               var1.setColor(0);
               var1.fillRect(var4 + 1, this.var_d1 + 3, 26, 26);
               if (Math.abs(super.var_6f5.nextInt() % 3) == 0) {
                  this.sub_2bf(var4 + 1, this.var_d1 + 2, 25, 25);
               }

               this.sub_2d0(var1);
               int var5 = GameScreen.gameScreen.var_d5c.projectsArr[var2 - 4095].sub_18d(28);
               GameScreen.gameScreen.sub_240c(var1, var4, this.var_d1 + 1, var5, GameScreen.gameScreen.var_d5c.var_1c6, 30, false, (Image)null);
               return;
            }

            if (var2 < 255 && this.var_1be != super.var_3c8) {
               this.sub_152(super.var_124 - 13, 25, 2171169);
               SomeUtilClass.sub_1db(this.var_18d.getGraphics(), GameScreen.gameScreen.buildingDictArr[var2].var_144, 0, 0, super.var_124 - 13, 25);
            }
         }

         if (this.var_18d != null) {
            var1.drawImage(this.var_18d, super.xPos + 8, this.var_d1 + 5, 20);
         }
      }

   }

   public void sub_152(int var1, int var2, int var3) {
      if (this.var_18d == null) {
         this.var_18d = Image.createImage(var1, var2);
      }

      Graphics g = this.var_18d.getGraphics();
      g.setColor(var3);
      g.fillRect(0, 0, var1, var2);
      this.var_1be = super.var_3c8;
   }

   public void sub_186(Graphics var1, int var2, String var3, String var4) {
      GameScreen.gameScreen.sub_fcf(var1, super.xPos + 10, var2, SomeUtilClass.getStr(var3), GameScreen.gameScreen.rMiniFront2Img);
      GameScreen var10000 = GameScreen.gameScreen;
      int var10002 = super.xPos + super.var_124 - 10;
      int var10003 = var4.length();
      GameScreen var10004 = GameScreen.gameScreen;
      var10000.sub_fcf(var1, var10002 - var10003 * 5, var2, var4, GameScreen.gameScreen.rMiniFront2Img);
   }

   public void sub_1b3() {
      if (this.var_2b != null) {
         --super.var_3c8;
         if (super.var_3c8 < 0) {
            super.var_3c8 = this.var_2b.size() - 1;
            super.var_368 = super.var_3c8 - this.var_166 + 1;
            if (super.var_368 < 0) {
               super.var_368 = 0;
            }
         }

         if (super.var_3c8 < super.var_368) {
            --super.var_368;
         }

      }
   }

   public void sub_1bf() {
      if (this.var_2b != null) {
         ++super.var_3c8;
         if (super.var_3c8 >= this.var_2b.size()) {
            --super.var_3c8;
            super.var_3c8 = 0;
            super.var_368 = 0;
         }

         if (super.var_3c8 >= super.var_368 + this.var_166) {
            ++super.var_368;
         }

      }
   }

   public void sub_21e() {
      if (this.var_135 == 10) {
      }

   }

   public void sub_253() {
      if (this.var_135 == 10) {
      }

   }

   public void sub_2af(String var1) {
      this.addMenu2Option(super.xPos + (super.var_124 - SomeUtilClass.getStr(var1).length() * 8) / 2, super.yPos + 4, SomeUtilClass.getStr(var1), true);
   }

   public int sub_2eb() {
      if (this.var_2b == null) {
         return 0;
      } else {
         UpgradeDto var1 = (UpgradeDto)this.var_2b.elementAt(super.var_3c8);
         return var1 != null ? var1.var_2e : 0;
      }
   }

   public void sub_30d(int var1) {
      if (this.var_2b != null) {
         for(int var3 = 0; var3 < this.var_2b.size(); ++var3) {
            UpgradeDto var2 = (UpgradeDto)this.var_2b.elementAt(var3);
            if (var2.var_2e == var1) {
               return;
            }

            this.sub_1bf();
         }

      }
   }
}
