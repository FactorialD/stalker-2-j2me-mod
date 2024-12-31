import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class SomeUpgradeDrawClass extends Class_4b3 {

   
   public Vector upgradesArr;
   public int var_83;
   public int someYPos;
   public int var_f5;
   public int descMenuId;
   public int var_166;
   public Image var_18d = null;
   public int var_1be = -1;

   public SomeUpgradeDrawClass(int descMenuId, int xPos, int yPos, int var4, int windowHeight, int var6) {
      super(0, xPos, yPos, var4, windowHeight, var6, (Planet)null);
      super.var_c7c = windowHeight;
      this.descMenuId = descMenuId;
      this.var_83 = super.yPos + 25;
      this.someYPos = super.yPos + windowHeight - DESC_WINDOW_HEIGHT - UPGRADE_WINDOW_MARGIN;
      this.var_f5 = super.xPos + 5;
      super.var_5d4 = false;
      super.var_1f3 = windowHeight;
      String var7 = "";
      switch(this.descMenuId) {
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
         var7 = SomeUtilClass.getStr("УРОН");
      case 6:
      case 7:
      case 8:
      case 9:
      default:
         break;
      case 10:
         var7 = SomeUtilClass.getStr("ХОДОВ");
         super.var_6f5 = new Random();
         --this.someYPos;
      }

      if (var7 != "") {
         int var10001 = super.xPos + super.var_124;
         int var10002 = var7.length();
         this.addMenu2Option(var10001 - var10002 * 5 - 5, this.var_83 - 10, var7, false);
      }

      this.addMenu2Option(super.xPos + 5, this.var_83 - 10, SomeUtilClass.getStr("ИМЯ"), false);
   }

   public void addUpgradeToMenuList(String upgradeName, int upgradeId) {
      if (this.upgradesArr == null) {
         this.upgradesArr = new Vector();
      }

      UpgradeDto upgrade = new UpgradeDto(this);
      upgrade.upgradeName = upgradeName;
      upgrade.upgradeId = upgradeId;
      this.upgradesArr.addElement(upgrade);
      this.var_166 = 0;

      for(int upgradeIndex = 0; upgradeIndex < this.upgradesArr.size(); ++upgradeIndex) {
         int var4 = this.var_83 + upgradeIndex * (5 + 3);
         if (var4 + 5 + 3 >= this.someYPos) {
            break;
         }

         ++this.var_166;
      }

      if (this.var_166 < this.upgradesArr.size()) {
         this.var_f5 = super.xPos + 5 + 8;
         if (super.curUpImg == null) {
            try {
               super.curUpImg = Image.createImage("/images/cur_up.png");
               super.curDownImg = Image.createImage("/images/cur_down.png");
               super.polImg = Image.createImage("/images/pol.png");
            } catch (IOException e) {
            }
         }
      }

   }

   public void sub_90(Graphics g) {
      int var2 = 0;
      this.sub_108(g);
      g.setColor(4573456);
      g.setStrokeStyle(1);
      int textXPos = super.xPos + 5;
      int textYPos = this.var_83 - 10 + 5 + 2;
      int var9 = super.xPos + super.var_124 - 5;
      int var10004 = this.var_83 - 10;
      g.drawLine(textXPos, textYPos, var9, var10004 + 5 + 2);
      g.setStrokeStyle(0);
      this.var_166 = 0;
      int temp;
      if (this.upgradesArr != null) {
         for(temp = super.var_368; temp < this.upgradesArr.size(); ++temp) {
            UpgradeDto upgrade = (UpgradeDto)this.upgradesArr.elementAt(temp);
            textXPos = temp - super.var_368;
            int var6 = this.var_83 + textXPos * (5 + 3);
            if (var6 + 5 + 3 >= this.someYPos) {
               break; //draw not all upgrades, only few
            }

            if (super.var_3c8 == temp) {
               g.setColor(2565927);
               g.fillRect(this.var_f5, var6 + 2, super.var_124 - 5 - (this.var_f5 - super.xPos), 6);//draw selected item
               g.setColor(3750201);
               g.drawLine(this.var_f5, var6 + 8, super.xPos + super.var_124 - 5, var6 + 8);
               g.setColor(4013373);
               g.drawLine(super.xPos + super.var_124 - 5, var6 + 2, super.xPos + super.var_124 - 5, var6 + 8);
               this.drawUpgradeInfo(g, upgrade.upgradeId);
            }

            if (this.descMenuId == 10 && upgrade.upgradeId >= 4095) {
               GameScreen.gameScreen.sub_fcf(g, this.var_f5, var6, upgrade.upgradeName, GameScreen.gameScreen.rMiniFrontImg);
            } else {
               GameScreen.gameScreen.sub_fcf(g, this.var_f5, var6, upgrade.upgradeName, GameScreen.gameScreen.rMiniFront2Img);
            }

            this.sub_c9(g, var6, upgrade.upgradeId);
            var2 = var6;
            ++this.var_166;
         }
      }

      if (this.descMenuId != 11) {
         if (super.curUpImg != null) {
            g.drawImage(super.curUpImg, super.xPos + 5, this.var_83, 20);
            g.drawImage(super.curDownImg, super.xPos + 5, var2, 20);
            temp = var2 - (this.var_83 + super.curUpImg.getHeight() + 2) - super.polImg.getHeight();
            temp = this.var_83 + super.curUpImg.getHeight() + temp * (super.var_3c8 + 1) / this.upgradesArr.size();
            g.drawImage(super.polImg, super.xPos + 5, temp, 20);
         }

      }
   }

   public void sub_c9(Graphics g, int var2, int var3) {
      String var4 = "";
      switch(this.descMenuId) {
      case 1:
         var4 = "" + GameScreen.gameScreen.rangItemsArr[var3].weight;
         break;
      case 2:
         var4 = "" + GameScreen.gameScreen.staminaItemsArr[var3].statValue;
         break;
      case 3:
         var4 = "" + GameScreen.gameScreen.costumeItemsArr[var3].statValue;
         break;
      case 4:
         var4 = "" + GameScreen.gameScreen.attackSpeedItemsArr[var3].statValue;
         break;
      case 5:
         var4 = "" + GameScreen.gameScreen.weaponItemsArr[var3].statValue;
      case 6:
      case 7:
      case 8:
      case 9:
      default:
         break;
      case 10:
         if (super.somePlanet == null) {
            var4 = "0";
         } else {
            var4 = "" + super.somePlanet.var_1df.sub_402(var3, super.somePlanet.sub_35d(GameScreen.gameScreen.sub_122a(super.somePlanet.var_1df.var_4f)));
         }
      }

      int var10000 = super.xPos + super.var_124;
      int var10001 = var4.length();
      GameScreen var10002 = GameScreen.gameScreen;
      int var5 = var10000 - var10001 * 5 - 10;
      if (this.descMenuId == 10 && var3 >= 4095) {
         GameScreen.gameScreen.sub_fcf(g, var5, var2, var4, GameScreen.gameScreen.rMiniFrontImg);
      } else {
         GameScreen.gameScreen.sub_fcf(g, var5, var2, var4, GameScreen.gameScreen.rMiniFront2Img);
      }

   }

   public void drawUpgradeInfo(Graphics g, int buyId) {
      String var3 = "";
      if (this.descMenuId >= 1 && this.descMenuId <= 5) {
         this.drawInfoWindowFrame(g, super.xPos + 5, this.someYPos, super.var_124 - 10, DESC_WINDOW_HEIGHT);
      }

      if (this.descMenuId == 10) {
         if (buyId >= 4095) {
            this.drawInfoWindowFrame(g, super.xPos + 5, this.someYPos, super.var_124 - 10 - 35, DESC_WINDOW_HEIGHT);
         } else {
            this.drawInfoWindowFrame(g, super.xPos + 5, this.someYPos, super.var_124 - 10, DESC_WINDOW_HEIGHT);
         }
      }

      switch(this.descMenuId) {
      case 1:
         this.drawSomeMiniDescText(g, this.someYPos + 5, "ЦЕНА:", GameScreen.gameScreen.rangItemsArr[buyId].price + " K");
         this.drawSomeMiniDescText(g, this.someYPos + 5 + 8, "ВЕС:", "" + GameScreen.gameScreen.rangItemsArr[buyId].weight);
         break;
      case 2:
         this.drawSomeMiniDescText(g, this.someYPos + 5, "ВЕС:", "" + GameScreen.gameScreen.staminaItemsArr[buyId].weight);
         this.drawSomeMiniDescText(g, this.someYPos + 5 + 8, "ЦЕНА:", GameScreen.gameScreen.staminaItemsArr[buyId].price + " K");
         this.drawSomeMiniDescText(g, this.someYPos + 5 + 8 + 8, "ВЫНОСЛИВОСТЬ:", "" + GameScreen.gameScreen.staminaItemsArr[buyId].statValue);
         break;
      case 3:
         this.drawSomeMiniDescText(g, this.someYPos + 5, "ВЕС:", "" + GameScreen.gameScreen.costumeItemsArr[buyId].weight);
         this.drawSomeMiniDescText(g, this.someYPos + 5 + 8, "ЦЕНА:", GameScreen.gameScreen.costumeItemsArr[buyId].price + " K");
         this.drawSomeMiniDescText(g, this.someYPos + 5 + 8 + 8, "БРОНЯ:", "" + GameScreen.gameScreen.costumeItemsArr[buyId].statValue);
         break;
      case 4:
         this.drawSomeMiniDescText(g, this.someYPos + 5, "ВЕС:", "" + GameScreen.gameScreen.attackSpeedItemsArr[buyId].weight);
         this.drawSomeMiniDescText(g, this.someYPos + 5 + 8, "ЦЕНА:", GameScreen.gameScreen.attackSpeedItemsArr[buyId].price + " K");
         this.drawSomeMiniDescText(g, this.someYPos + 5 + 8 + 8, "БОЕПРИПАСЫ:", "" + GameScreen.gameScreen.attackSpeedItemsArr[buyId].statValue);
         break;
      case 5:
         this.drawSomeMiniDescText(g, this.someYPos + 5, "ВЕС:", "" + GameScreen.gameScreen.weaponItemsArr[buyId].weight);
         this.drawSomeMiniDescText(g, this.someYPos + 5 + 8, "ЦЕНА:", GameScreen.gameScreen.weaponItemsArr[buyId].price + " K");
         this.drawSomeMiniDescText(g, this.someYPos + 5 + 8 + 8, "УРОН:", "" + GameScreen.gameScreen.weaponItemsArr[buyId].statValue);
      case 6:
      case 7:
      case 8:
      case 9:
      default:
         break;
      case 10: // draw rectangle with text for buildings
         if (buyId == 255) {
            if (this.var_1be != super.var_3c8) {
               this.drawSomeBgRect(super.var_124 - 13, DESC_WINDOW_HEIGHT, DESC_WINDOW_BG_COLOR);
               SomeUtilClass.drawLittleTextInRect2(this.var_18d.getGraphics(), SomeUtilClass.getStr("УВЕЛИЧИВАЕТСЯ ПРИРОСТ НАСЕЛЕНИЯ В ЛАГЕРЕ"), 0, 0, super.var_124 - 13, DESC_WINDOW_HEIGHT);
            }
         } else if (buyId == 511) {
            if (this.var_1be != super.var_3c8) {
               this.drawSomeBgRect(super.var_124 - 13, DESC_WINDOW_HEIGHT, DESC_WINDOW_BG_COLOR);
               SomeUtilClass.drawLittleTextInRect2(this.var_18d.getGraphics(), SomeUtilClass.getStr("УВЕЛИЧИВАЕТСЯ ДОХОД ЛАГЕРЯ"), 0, 0, super.var_124 - 13, DESC_WINDOW_HEIGHT);
            }
         } else if (buyId == 767) {
            if (this.var_1be != super.var_3c8) {
               this.drawSomeBgRect(super.var_124 - 13, DESC_WINDOW_HEIGHT, DESC_WINDOW_BG_COLOR);
               SomeUtilClass.drawLittleTextInRect2(this.var_18d.getGraphics(), SomeUtilClass.getStr("ОТРЯД СТАЛКЕРОВ ДЛЯ СОЗДАНИЯ НОВОГО ЛАГЕРЯ"), 0, 0, super.var_124 - 13, DESC_WINDOW_HEIGHT);
            }
         } else {
            if (buyId >= 4095) { // draw ship
               GameScreen.gameScreen.var_d5c.projectsArr[buyId - 4095].sub_62f(g, super.xPos + 8, this.someYPos + 5, super.var_124 - 10 - 35, 30);
               int var4 = super.xPos + 5 + super.var_124 - 10 - 30;
               g.drawImage(GameScreen.gameScreen.selShipImg, var4, this.someYPos + 2, 20);
               g.setColor(0);
               g.fillRect(var4 + 1, this.someYPos + 3, 26, 26);
               if (Math.abs(super.var_6f5.nextInt() % 3) == 0) {
                  this.sub_2bf(var4 + 1, this.someYPos + 2, DESC_WINDOW_HEIGHT, DESC_WINDOW_HEIGHT);
               }

               this.sub_2d0(g);
               int var5 = GameScreen.gameScreen.var_d5c.projectsArr[buyId - 4095].sub_18d(28);
               GameScreen.gameScreen.sub_240c(g, var4, this.someYPos + 1, var5, GameScreen.gameScreen.var_d5c.var_1c6, 30, false, (Image)null);
               return;
            }

            if (buyId < 255 && this.var_1be != super.var_3c8) {
               this.drawSomeBgRect(super.var_124 - 13, DESC_WINDOW_HEIGHT, DESC_WINDOW_BG_COLOR);
               SomeUtilClass.drawLittleTextInRect2(this.var_18d.getGraphics(), GameScreen.gameScreen.buildingDictArr[buyId].var_144, 0, 0, super.var_124 - 13, DESC_WINDOW_HEIGHT);
            }
         }

         if (this.var_18d != null) {
            g.drawImage(this.var_18d, super.xPos + 8, this.someYPos + 5, 20);
         }
      }

   }

   public void drawSomeBgRect(int width, int height, int bgColor) {
      if (this.var_18d == null) {
         this.var_18d = Image.createImage(width, height);
      }

      Graphics g = this.var_18d.getGraphics();
      g.setColor(bgColor);
      g.fillRect(0, 0, width, height);
      this.var_1be = super.var_3c8;
   }

   public void drawSomeMiniDescText(Graphics g, int var2, String var3, String var4) {
      GameScreen.gameScreen.sub_fcf(g, super.xPos + 10, var2, SomeUtilClass.getStr(var3), GameScreen.gameScreen.rMiniFront2Img);
      GameScreen var10000 = GameScreen.gameScreen;
      int var10002 = super.xPos + super.var_124 - 10;
      int var10003 = var4.length();
      var10000.sub_fcf(g, var10002 - var10003 * 5, var2, var4, GameScreen.gameScreen.rMiniFront2Img);
   }

   public void sub_1b3() {
      if (this.upgradesArr != null) {
         --super.var_3c8;
         if (super.var_3c8 < 0) {
            super.var_3c8 = this.upgradesArr.size() - 1;
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
      if (this.upgradesArr != null) {
         ++super.var_3c8;
         if (super.var_3c8 >= this.upgradesArr.size()) {
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
      if (this.descMenuId == 10) {
      }

   }

   public void sub_253() {
      if (this.descMenuId == 10) {
      }

   }

   public void drawBuildHeader(String str) {
      this.addMenu2Option(super.xPos + (super.var_124 - SomeUtilClass.getStr(str).length() * 8) / 2, super.yPos + 4, SomeUtilClass.getStr(str), true);
   }
  

   public int sub_2eb() {
      if (this.upgradesArr == null) {
         return 0;
      } else {
         UpgradeDto upgrade = (UpgradeDto)this.upgradesArr.elementAt(super.var_3c8);
         return upgrade != null ? upgrade.upgradeId : 0;
      }
   }

   public void sub_30d(int var1) {
      if (this.upgradesArr != null) {
         for(int var3 = 0; var3 < this.upgradesArr.size(); ++var3) {
            UpgradeDto var2 = (UpgradeDto)this.upgradesArr.elementAt(var3);
            if (var2.upgradeId == var1) {
               return;
            }

            this.sub_1bf();
         }

      }
   }


}
