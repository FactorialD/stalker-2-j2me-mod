import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Planet {
   public int var_5a;
   public int var_9b;
   public int var_e5;
   public int var_fa;
   private String var_140 = null;
   public int planetCoords; // saves coordinates as integer sector coordinates, X is high 16 bits, y is low 16 bits
   public Class_139 var_1df = null;
   public int var_210 = 0;

   public Planet(int var1, int planetXsector, int planetYSector, int var4) {
      this.var_9b = Math.abs(var1);
      this.planetCoords = planetXsector | planetYSector << 16;
      this.var_5a = var4;
      this.var_e5 = SomeUtilClass.sub_73(this.var_9b);
      this.var_fa = 0;
   }

   public void sub_3a() {
      this.var_210 = this.sub_248() * (this.sub_1a4() + this.sub_1a4() + this.sub_224());
   }

   public Planet() {
   }

   public String sub_96() {
      if (this.var_140 != null) {
         return this.var_140;
      } else {
         return this.var_5a >= 0 && this.var_5a < GameScreen.gameScreen.locationNamesArr.length ? GameScreen.gameScreen.locationNamesArr[this.var_5a] : "XS";
      }
   }

   public void sub_ab(String var1) {
      this.var_140 = new String(var1);
   }

   public int getXAbsoluteSector() {
      return this.planetCoords & '\uffff';
   }

   public int getYAbsoluteSector() {
      return this.planetCoords >> 16;
   }

   public int getXAbsolutePosition() {
      return (this.planetCoords & '\uffff') * 20;
   }

   public int getYAbsolutePosition() {
      return (this.planetCoords >> 16) * 20;
   }

   public boolean sub_150(int var1) {
      int var2 = 1 << var1;
      return (this.var_fa & var2) != 0;
   }

   public void sub_181(int var1) {
      int var2 = 1 << var1;
      this.var_fa |= var2;
   }

   public int sub_1a4() {
      return this.var_e5 >> 16 & 255;
   }

   public int sub_1d1() {
      return this.var_e5 >> 8 & 255;
   }

   public int sub_224() {
      return this.var_e5 & 255;
   }

   public int sub_248() {// возвращает 12 для строки сверху на панели "3.12"
      int var1 = this.var_e5 >> 24 & 255;
      if (this.var_1df != null) {
         if (this.var_1df.sub_e3(26)) {
            var1 += 2;
         }

         if (GameScreen.gameScreen.sub_1797(this.var_1df.var_4f, 0)) {
            var1 += 5;
         }

         if (this.var_1df.sub_15b(7)) {
            var1 *= 2;
         }
      }

      return var1;
   }

   public int sub_2aa(Class_2a9 var1) {
      return this.sub_2c2() + this.sub_35d(var1) + this.sub_36e(var1) + this.sub_391(var1);
   }

   public int sub_2c2() {
      if (this.var_1df == null) {
         return 0;
      } else {
         int var1 = this.sub_1a4();
         if (this.var_1df.sub_e3(0)) {
            ++var1;
         }

         if (this.var_1df.sub_e3(11)) {
            var1 += 3;
         }

         if (this.var_1df.sub_e3(18)) {
            ++var1;
         }

         if (this.var_1df.sub_e3(27)) {
            var1 += 3;
         }

         int var2 = this.var_1df.sub_249() * var1;
         if (this.var_1df.sub_e3(6)) {
            var2 += 5;
         }

         if (this.var_1df.sub_e3(21)) {
            var2 *= 2;
         }

         if (GameScreen.gameScreen.sub_1797(this.var_1df.var_4f, 3)) {
            var2 *= 2;
         }

         var2 -= this.var_1df.sub_42e();
         return var2;
      }
   }

   public int sub_2e4() {
      int var1 = 0;
      if (this.var_1df.var_19d > 0 && this.var_1df.var_19d <= 400) {
         var1 = (400 - this.var_1df.var_19d) / 10;
      }

      if (this.var_1df.var_19d <= 0) {
         var1 = 50 + -this.var_1df.var_19d / 10;
      }

      if (var1 > 100) {
         var1 = 100;
      }

      if (var1 < 0) {
         var1 = 0;
      }

      return var1;
   }

   public int sub_330() {
      if (this.var_1df == null) {
         return 0;
      } else {
         boolean var1 = false;
         int var3;
         if (this.sub_2c2() >= 0) {
            int var2 = this.sub_2c2();
            if (var2 > this.sub_248()) {
               var2 = this.sub_248();
            }

            if (this.var_1df.sub_2ea() >= this.sub_248()) {
               var3 = 0;
            } else {
               var3 = this.sub_248() * var2;
               if (this.var_1df.var_19d <= 100) {
                  var3 = var2;
               }

               if (this.var_1df.var_19d <= 0) {
                  var3 = 0;
               }

               if (this.var_1df.jobId == 255) {
                  var3 += 4 * this.sub_35d(GameScreen.gameScreen.sub_122a(this.var_1df.var_4f)) * this.sub_2c2();
               }

               if (GameScreen.gameScreen.sub_1797(this.var_1df.var_4f, 5)) {
                  var3 += var3 / 4;
               }

               if (this.var_1df.sub_15b(4)) {
                  var3 = 1000;
               }
            }
         } else {
            var3 = 50 * this.sub_2c2();
         }

         if (var3 > 1000) {
            var3 = 1000;
         }

         return var3;
      }
   }

   public int sub_340(Class_2a9 var1) {
      int var2 = this.sub_1d1();
      if (this.var_1df.sub_e3(1)) {
         var2 += 2;
      }

      if (this.var_1df.sub_e3(12)) {
         var2 += 3;
      }

      if (this.var_1df.sub_e3(18)) {
         ++var2;
      }

      if (this.var_1df.sub_e3(27)) {
         var2 += 3;
      }

      int var3 = this.var_1df.sub_27d() * var2;
      if (this.var_1df.sub_e3(7)) {
         var3 += 20;
      }

      if (this.var_1df.sub_e3(19)) {
         var3 += 100;
      }

      if (this.var_1df.sub_e3(21)) {
         var3 *= 2;
      }

      if (GameScreen.gameScreen.sub_1797(this.var_1df.var_4f, 3)) {
         var3 *= 2;
      }

      var3 += var1.sub_90() * var3 / 100;
      return var3;
   }

   public int sub_35d(Class_2a9 var1) {
      if (this.var_1df == null) {
         return 0;
      } else {
         int var2 = this.sub_340(var1);
         var2 -= var2 * var1.var_154 / 100;
         var2 -= var2 * this.sub_2e4() / 100;
         return var2;
      }
   }

   public int sub_36e(Class_2a9 var1) {
      if (this.var_1df == null) {
         return 0;
      } else {
         int var2 = this.sub_224();
         if (this.var_1df.sub_e3(2)) {
            var2 += 2;
         }

         if (this.var_1df.sub_e3(13)) {
            var2 += 3;
         }

         if (this.var_1df.sub_e3(20)) {
            var2 += 5;
         }

         if (this.var_1df.sub_e3(27)) {
            var2 += 3;
         }

         if (this.var_1df.sub_e3(28)) {
            ++var2;
         }

         int var3 = this.var_1df.sub_28a() * var2;
         if (this.var_1df.sub_e3(8)) {
            var3 += 20;
         }

         if (this.var_1df.sub_e3(28)) {
            var3 += 100;
         }

         if (this.var_1df.sub_15b(1)) {
            var3 += 25;
         }

         if (this.var_1df.sub_e3(21)) {
            var3 *= 2;
         }

         if (GameScreen.gameScreen.sub_1797(this.var_1df.var_4f, 1)) {
            var3 += var3 / 2;
         }

         var3 += var1.sub_b1() * var3 / 100;
         var3 -= var3 * this.sub_2e4() / 100;
         return var3;
      }
   }

   public int sub_391(Class_2a9 var1) {
      if (this.var_1df == null) {
         return 0;
      } else {
         byte var2 = 0;
         int var3 = var2 + var1.var_108 * this.var_1df.sub_2ea() / 10;
         var3 += this.sub_340(var1) * var1.var_154 / 100;
         if (this.var_1df.jobId == 511) {
            var3 += this.sub_35d(var1) / 2;
         }

         if (this.var_1df.sub_15b(0)) {
            var3 += 25;
         }

         if (this.var_1df.sub_e3(3)) {
            var3 += var3 / 2;
         }

         if (this.var_1df.sub_e3(9)) {
            var3 = 2 * var3;
         }

         if (this.var_1df.sub_e3(13)) {
            var3 = 2 * var3;
         }

         if (this.var_1df.sub_e3(14)) {
            var3 += (this.sub_2c2() + this.var_1df.sub_42e()) / 4 + this.sub_35d(var1) / 4;
         }

         if (GameScreen.gameScreen.sub_1797(this.var_1df.var_4f, 1)) {
            var3 += var3 / 2;
         }

         var3 -= var3 * this.sub_2e4() / 100;
         return var3;
      }
   }

   public int sub_3b8(Class_2a9 var1) {
      if (this.var_1df == null) {
         return 0;
      } else {
         byte var2 = 0;
         int var3 = var2 + this.var_1df.sub_2ea();
         if (var1.var_108 == 0) {
            var3 += this.var_1df.sub_2ea() * 3;
         }

         var3 += this.var_1df.sub_341() * 3;
         if (this.var_1df.sub_e3(4)) {
            var3 += var3 / 2;
         }

         if (this.var_1df.sub_e3(15)) {
            var3 = 2 * var3;
         }

         if (this.var_1df.sub_e3(29)) {
            var3 = 4 * var3;
         }

         if (GameScreen.gameScreen.sub_1797(this.var_1df.var_4f, 7)) {
            var3 = 4 * var3;
         }

         if (var1.var_108 < 20) {
            var3 -= this.var_1df.sub_2ea() * var1.var_108 / 10;
         }

         if (var1.var_108 == 20) {
            var3 -= this.var_1df.sub_2ea() * var1.var_108 / 7;
         }

         if (var1.var_108 == 30 || var1.var_108 == 40) {
            var3 -= this.var_1df.sub_2ea() * var1.var_108 / 6;
         }

         if (var1.var_108 == 50) {
            var3 -= this.var_1df.sub_2ea() * var1.var_108 / 5;
         }

         if (this.sub_2c2() < 0) {
            var3 += this.sub_2c2() * this.var_1df.sub_2ea() * 10;
         }

         if (this.sub_248() == this.var_1df.sub_2ea()) {
            var3 -= this.sub_248();
         }

         if (var3 < 0) {
            var3 += GameScreen.gameScreen.sub_1592(this.getXAbsoluteSector(), this.getYAbsoluteSector()) * 3;
            if (var3 > 0) {
               var3 = 0;
            }
         }

         return var3;
      }
   }

   public int sub_3ef() {
      if (this.var_1df == null) {
         return 0;
      } else {
         int var1 = 0;

         for(int var2 = 0; var2 < 31; ++var2) {
            if (this.var_1df.sub_e3(var2)) {
               var1 += GameScreen.gameScreen.buildingDictArr[var2].var_1c1;
            }
         }

         return var1;
      }
   }

   public int sub_406() {
      if (this.var_1df == null) {
         return 0;
      } else {
         byte var1 = 10;
         if (this.var_1df.sub_e3(5)) {
            var1 = 30;
         }

         return var1;
      }
   }

   public void drawOwnedLocationTopPanel(Graphics g, int xPos, int yPos, int var4) {
      if (!this.sub_150(var4)) {//if location keep is not known
         g.drawImage(GameScreen.gameScreen.xpImg, xPos - 12, yPos - 2, 20);
         if (GameScreen.gameScreen.var_9b3 != null && GameScreen.gameScreen.var_9b3.menuId == 9) {
            GameScreen.gameScreen.sub_fcf(g, xPos + 15, yPos + 2, this.sub_96(), GameScreen.gameScreen.rMiniFront2Img);
         } else {
            GameScreen.gameScreen.sub_fcf(g, xPos + 15, yPos + 2, SomeUtilClass.getStr("НЕИЗВЕСТНО"), GameScreen.gameScreen.rMiniFront2Img);
         }
      } else if (this.var_1df == null) { // if location free
         g.drawImage(GameScreen.gameScreen.fsImg, xPos - 12, yPos - 2, 20);
         if (GameScreen.gameScreen.var_9b3 == null || GameScreen.gameScreen.var_9b3.menuId != 9 && GameScreen.gameScreen.var_9b3.menuId != 10) {
            GameScreen.gameScreen.sub_fcf(g, xPos + 15, yPos + 2, SomeUtilClass.getStr("СВОБОДНАЯ"), GameScreen.gameScreen.rMiniFront2Img);
         } else {
            GameScreen.gameScreen.sub_fcf(g, xPos + 15, yPos + 2, this.sub_96(), GameScreen.gameScreen.rMiniFront2Img);
         }
      } else { // if location claimed by some group
         Image var5 = GameScreen.gameScreen.sub_1194(this.var_1df.var_4f);
         if (GameScreen.gameScreen.var_9b3 != null && (GameScreen.gameScreen.var_9b3.menuId == 9 || GameScreen.gameScreen.var_9b3.menuId == 10)) {
            GameScreen.gameScreen.sub_fcf(g, xPos + 15, yPos + 2, this.sub_96(), GameScreen.gameScreen.rMiniFront2Img);
         } else {
            GameScreen.gameScreen.sub_fcf(g, xPos + 15, yPos + 2, GameScreen.gameScreen.sub_11e1(this.var_1df.var_4f), GameScreen.gameScreen.rMiniFront2Img);
         }

         if (var5 != null) {
        	 // draw group on location image 
            g.drawImage(var5, xPos - 12, yPos - 2, 20);
         }

         // Population of location
         String var6 = "" + this.var_1df.sub_2ea() + ".";
         var6 = var6 + this.sub_248();
         g.drawImage(GameScreen.gameScreen.np2Img, xPos + 110 - 18, yPos - 2, 20);
         GameScreen.gameScreen.sub_fcf(g, xPos + 110 - 20 - var6.length() * 5, yPos + 2, var6, GameScreen.gameScreen.rMiniFront2Img);
      }

   }

   public void sub_444(Graphics var1, String var2, String var3, int var4, int var5, int var6) {
      GameScreen.gameScreen.sub_fcf(var1, var4, var5, var2, GameScreen.gameScreen.rMiniFrontImg);
      GameScreen.gameScreen.sub_fcf(var1, var6, var5, var3, GameScreen.gameScreen.rMiniFrontImg);
   }

   public boolean drawColonyStatistics(Graphics g, int var2, int baseXPos, int var4, int var5, boolean var6) {
      int curYPos = -var2 * 7;
      byte var9 = 15;
      if (!var6) {
         var9 = 5;
      }

      if (var5 <= 70) {
         curYPos += 3;
         char var10 = '+';
         if (this.sub_330() < 0) {
            var10 = '-';
         }

         String var11;
         for(var11 = "" + this.var_1df.var_141; var11.length() < 3; var11 = "0" + var11) {
         }

         var11 = this.var_1df.sub_2ea() + "." + var11 + "(" + var10 + Math.abs(this.sub_330()) + ")";
         this.sub_444(g, SomeUtilClass.getStr("НАС:"), var11, baseXPos + 5, curYPos, baseXPos + 30);
         curYPos += 4;
         if (curYPos >= var5) {
            return true;
         }
      }

      g.setColor(4481920);
      g.setStrokeStyle(1);
      curYPos += 5;
      g.drawLine(baseXPos + 5, curYPos, baseXPos + var4 - 5, curYPos);
      curYPos += 3;
      GameScreen.gameScreen.sub_fcf(g, baseXPos + var9, curYPos, SomeUtilClass.getStr("СТРОЕНИЕ"), GameScreen.gameScreen.rMiniFrontImg);
      GameScreen.gameScreen.sub_fcf(g, baseXPos + var4 - 50 - var9, curYPos, SomeUtilClass.getStr("ПОДДЕРЖКА"), GameScreen.gameScreen.rMiniFrontImg);
      curYPos += 7;
      g.drawLine(baseXPos + 5, curYPos, baseXPos + var4 - 5, curYPos);
      curYPos += 3;
      boolean var12 = false;

      for(int var13 = 0; var13 < 31; ++var13) {
         if (this.var_1df.sub_e3(var13)) {
            if (var6) {
               this.sub_444(g, GameScreen.gameScreen.buildingDictArr[var13].var_11, "" + GameScreen.gameScreen.buildingDictArr[var13].var_1c1, baseXPos + 5, curYPos, baseXPos + var4 - 20 - var9);
            } else {
               this.sub_444(g, GameScreen.gameScreen.buildingDictArr[var13].var_68, "" + GameScreen.gameScreen.buildingDictArr[var13].var_1c1, baseXPos + 5, curYPos, baseXPos + var4 - 20 - var9);
            }

            curYPos += 7;
            if (curYPos >= var5) {
               return true;
            }

            var12 = true;
         }
      }

      if (!var12) {
         GameScreen var10000 = GameScreen.gameScreen;
         int var10004 = SomeUtilClass.getStr("ПУСТО").length();
         GameScreen var10005 = GameScreen.gameScreen;
         var10000.sub_fcf(g, baseXPos + (var4 - var10004 * 5) / 2, curYPos, SomeUtilClass.getStr("ПУСТО"), GameScreen.gameScreen.rMiniFrontImg);
         curYPos += 7;
         if (curYPos >= var5) {
            return true;
         }
      }

      g.drawLine(baseXPos + 5, curYPos, baseXPos + var4 - 5, curYPos);
      curYPos += 3;
      if (curYPos >= var5) {
         return true;
      } else {
         if (var6) {
            this.sub_444(g, SomeUtilClass.getStr("РАСХОДЫ НА СОДЕРЖАНИЕ:"), "" + this.sub_3ef(), baseXPos + 5, curYPos, baseXPos + var4 - 20 - var9);
         } else {
            this.sub_444(g, SomeUtilClass.getStr("ВСЕГО:"), "" + this.sub_3ef(), baseXPos + 5, curYPos, baseXPos + var4 - 20 - var9);
         }

         curYPos += 14;
         if (curYPos >= var5) {
            return true;
         } else {
            if (var6) {
               this.sub_444(g, SomeUtilClass.getStr("ОЧКИ МОРАЛИ:"), "" + this.var_1df.var_19d + "(" + this.sub_3b8(GameScreen.gameScreen.var_d5c) + ")", baseXPos + 5, curYPos, baseXPos + var4 - 20 - var9);
            } else {
               this.sub_444(g, SomeUtilClass.getStr("МОРАЛЬ:"), "" + this.var_1df.var_19d + "(" + this.sub_3b8(GameScreen.gameScreen.var_d5c) + ")", baseXPos + 5, curYPos, baseXPos + var4 - 20 - var9 - 15);
            }

            curYPos += 7;
            if (curYPos >= var5) {
               return true;
            } else {
               if (var6) {
                  this.sub_444(g, SomeUtilClass.getStr("КОММАНДНЫЕ ТОЧКИ:"), "" + this.sub_406(), baseXPos + 5, curYPos, baseXPos + var4 - 20 - var9);
               } else {
                  this.sub_444(g, SomeUtilClass.getStr("КМД ТОЧКИ:"), "" + this.sub_406(), baseXPos + 5, curYPos, baseXPos + var4 - 20 - var9);
               }

               curYPos += 7;
               if (curYPos >= var5) {
                  return true;
               } else {
                  this.sub_444(g, SomeUtilClass.getStr("КОРРУПЦИЯ:"), "" + this.sub_2e4() + "%", baseXPos + 5, curYPos, baseXPos + var4 - 20 - var9);
                  return false;
               }
            }
         }
      }
   }

   public void sub_470() {
      if (this.var_1df != null) {
         Class_2a9 var1 = GameScreen.gameScreen.sub_122a(this.var_1df.var_4f);
         if (var1 == null) {
            return;
         }

         if (this.var_1df.jobId != 255 && this.var_1df.jobId != 511) {
            this.sub_47c(var1);
         }

         Class_139 var10000 = this.var_1df;
         var10000.var_141 += this.sub_330();
         if (this.sub_2c2() < 0) {
            var1.sub_640(4, this.planetCoords, "");
         }

         if (this.var_1df.var_141 >= 1000) {
            this.var_1df.sub_1e(this.var_1df.sub_2ea() + 1);
            this.var_1df.var_141 -= 1000;
            var1.sub_640(1, this.planetCoords, "");
         }

         if (this.var_1df.var_141 < 0) {
            if (this.var_1df.sub_2ea() <= 1) {
               var1.sub_640(3, this.planetCoords, "");
               this.var_1df = null;
               return;
            }

            this.var_1df.sub_208();
            this.var_1df.var_141 += 1000;
            var1.sub_640(2, this.planetCoords, "");
         }

         if (this.var_1df.var_19d < 1100) {
            var10000 = this.var_1df;
            var10000.var_19d += this.sub_3b8(var1);
            if (this.var_1df.sub_15b(6)) {
               this.var_1df.var_19d = 1100;
            }
         }
      }

   }

   public void sub_47c(Class_2a9 var1) {
      Class_139 var10000 = this.var_1df;
      var10000.var_178 += this.sub_35d(var1);
      if (this.var_1df.jobId == 767 && 100 <= this.var_1df.var_178) {
         var10000 = this.var_1df;
         var10000.var_178 -= 100;
         GameScreen.gameScreen.sub_1527(var1, this.getXAbsoluteSector(), this.getYAbsoluteSector());
         this.var_1df.jobId = 511;
         var1.sub_640(5, this.planetCoords, "COLONIST");
      }

      if (this.var_1df.jobId >= 4095 && var1.projectsArr[this.var_1df.jobId - 4095].sub_601(var1.var_1c6) <= this.var_1df.var_178) {
         var10000 = this.var_1df;
         var10000.var_178 -= var1.projectsArr[this.var_1df.jobId - 4095].sub_601(var1.var_1c6);
         GameScreen.gameScreen.sub_14a6(var1, this.var_1df.jobId - 4095, this.getXAbsoluteSector(), this.getYAbsoluteSector(), this.var_1df.sub_e3(22));
         var1.sub_640(5, this.planetCoords, var1.projectsArr[this.var_1df.jobId - 4095].projectName);
         this.var_1df.jobId = 511;
      }

      if (this.var_1df.jobId < 255 && GameScreen.gameScreen.buildingDictArr[this.var_1df.jobId].var_175 <= this.var_1df.var_178) {
         var10000 = this.var_1df;
         var10000.var_178 -= GameScreen.gameScreen.buildingDictArr[this.var_1df.jobId].var_175;
         var1.sub_640(6, this.planetCoords, GameScreen.gameScreen.buildingDictArr[this.var_1df.jobId].var_11);
         if (this.var_1df.jobId == 23) {
            if (this.var_1df.sub_2ea() < this.sub_248()) {
               this.var_1df.sub_1e(this.var_1df.sub_2ea() + 1);
            }

            var10000 = this.var_1df;
            var10000.var_19d -= 100;
         } else {
            this.var_1df.sub_cd(this.var_1df.jobId);
         }

         this.var_1df.jobId = 511;
      }

   }

   public int sub_4a7(Class_2a9 var1, int var2) {
      int var3 = 0;

      for(int var4 = 0; var4 < 31; ++var4) {
         if (!this.var_1df.sub_e3(var4) && var1.sub_139(GameScreen.gameScreen.buildingDictArr[var4].var_1ed) && GameScreen.gameScreen.buildingDictArr[var4].var_225 == var2) {
            ++var3;
         }
      }

      return var3;
   }

   public int sub_4c9(Class_2a9 var1, int var2) {
      for(int var3 = 0; var3 < 31; ++var3) {
         if (!this.var_1df.sub_e3(var3) && var1.sub_139(GameScreen.gameScreen.buildingDictArr[var3].var_1ed) && GameScreen.gameScreen.buildingDictArr[var3].var_225 == var2) {
            return var3;
         }
      }

      return -1;
   }

   public int sub_51a(Class_2a9 var1, int var2, int var3, int var4, int var5) {
      int var6 = this.sub_4a7(var1, var3);
      if (var6 == 0) {
         return 0;
      } else {
         switch(var3) {
         case 0:
            if (var1.var_8c == 3) {
               var6 *= 2;
            }

            var6 = var6 * 2 * (7 - this.sub_1d1());
            break;
         case 1:
            if (var1.var_8c == 1) {
               var6 *= 2;
            }

            var6 *= var5;
            break;
         case 2:
            if (var1.var_8c == 2) {
               var6 *= 2;
            }

            var6 *= 7 - this.sub_224();
            break;
         case 3:
            var6 = var6 * this.var_1df.sub_249() * (7 - this.sub_1a4());
            if (var1.var_430) {
               var6 *= 2;
            }
            break;
         case 4:
            var6 = var6 * 2 * ((1100 - this.var_1df.var_19d) / 440);
            break;
         case 5:
            if (var4 == 0) {
               var6 *= 2;
            }

            if (var4 < 0) {
               var6 *= -var4 + 3;
            }
         }

         int var7 = this.sub_4c9(var1, var3);
         if (var7 == -1) {
            return 0;
         } else {
            var6 += 30 - this.var_1df.sub_402(var7, var2);
            return var6;
         }
      }
   }

   public int sub_53a() {
      Class_2a9 var1 = GameScreen.gameScreen.sub_122a(this.var_1df.var_4f);
      int var2 = this.sub_35d(var1);
      int var3 = GameScreen.gameScreen.sub_dda(var1);
      int var4 = GameScreen.gameScreen.sub_1db6(var1);
      int[] var5 = new int[10];

      int var6;
      for(var6 = 0; var6 < 6; ++var6) {
         var5[var6] = this.sub_51a(var1, var2, var6, var3, var4);
      }

      var5[6] = (this.sub_248() - this.var_1df.sub_2ea()) * var1.sub_c();
      if (var1.var_430) {
         var5[6] *= 2;
      }

      if (var3 < 0) {
         var5[7] = -var3;
      } else {
         var5[7] = 1;
      }

      var5[8] = GameScreen.gameScreen.sub_1e9e(this.getXAbsoluteSector(), this.getYAbsoluteSector(), GameScreen.gameScreen.sub_1e4e(var1), var1.var_3d2) * var1.sub_c();
      var5[8] += 30 - this.var_1df.sub_402(767, var2);
      var5[8] -= GameScreen.gameScreen.sub_1f92(var1) * 10;
      var5[8] -= GameScreen.gameScreen.sub_920(var1.var_1c6) - GameScreen.gameScreen.sub_931(var1.var_1c6);
      var6 = GameScreen.gameScreen.sub_920(var1.var_1c6) - GameScreen.gameScreen.sub_931(var1.var_1c6);
      if (var1.var_8c != 1) {
         --var4;
      }

      var5[9] = var4 * var6;
      var5[9] += this.var_1df.var_1e2;
      if (var3 < 0 || var6 < 0 || var1.var_f6 <= 0) {
         var5[9] = 0;
      }

      int var7 = 7;

      for(int var8 = 0; var8 < 10; ++var8) {
         if (var5[var8] > var5[var7]) {
            var7 = var8;
         }
      }

      return var7;
   }

   public int sub_554(Class_2a9 var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < 6; ++var3) {
         var2 += this.sub_4a7(var1, var3);
      }

      return var2;
   }

   public int sub_5b2() {
      Class_2a9 var1 = GameScreen.gameScreen.sub_122a(this.var_1df.var_4f);
      int var2 = this.sub_35d(var1);
      if (var2 <= 0) {
         return 0;
      } else {
         boolean var3 = false;
         int var4 = 0;
         int var5 = 0;
         byte var6 = 15;
         if (this.sub_554(var1) == 0) {
            var6 = 99;
         }

         for(int var7 = var1.projectsArr.length - 1; var7 >= 0; --var7) {
            int var9 = this.var_1df.sub_402(var7 + 4095, var2);
            if (var9 != 0 && var6 >= var9) {
               int var8 = 100 * var1.projectsArr[var7].sub_698() / var9;
               if (var8 > var4) {
                  var4 = var8;
                  var5 = var7;
               }
            }
         }

         return var5;
      }
   }

   public void sub_5d6(Class_2a9 var1) {
      if (this.var_1df.var_204) {
         int var2 = this.var_1df.sub_385();
         if (var2 <= var1.var_f6) {
            this.var_1df.sub_3b5();
         }
      }

   }

   public void sub_60d() {
      int var1 = this.sub_53a();
      if (var1 >= 0 && var1 <= 5) {
         this.var_1df.jobId = this.sub_4c9(GameScreen.gameScreen.sub_122a(this.var_1df.var_4f), var1);
      } else if (var1 == 6) {
         this.var_1df.jobId = 255;
      } else if (var1 == 7) {
         this.var_1df.jobId = 511;
      } else if (var1 == 8) {
         this.var_1df.jobId = 767;
      } else if (var1 == 9) {
         this.var_1df.jobId = 4095 + this.sub_5b2();
      }
   }

   public void sub_661() {
      this.var_1df.sub_36(0);
      this.var_1df.sub_4b(0);
      this.var_1df.sub_92(0);

      for(int var1 = 0; var1 < this.var_1df.sub_2ea() && this.sub_2c2() <= 0; ++var1) {
         this.var_1df.sub_36(var1 + 1);
      }

      byte var4 = 0;
      Class_2a9 var2 = GameScreen.gameScreen.sub_122a(this.var_1df.var_4f);
      if (this.var_1df.jobId < 255) {
         var4 = 0;
         if (var2.var_430 && this.sub_248() > this.var_1df.sub_2ea()) {
            var4 = 3;
         }
      }

      if (this.var_1df.jobId >= 4095) {
         var4 = 1;
      }

      if (this.var_1df.jobId == 767) {
         var4 = 1;
      }

      if (this.var_1df.jobId == 255) {
         var4 = 0;
      }

      if (this.var_1df.jobId == 511) {
         var4 = 0;
         if (var2.var_f6 > 0 && GameScreen.gameScreen.sub_dda(var2) > 0) {
            var4 = 2;
         }

         if (var2.var_430 && this.sub_248() > this.var_1df.sub_2ea()) {
            var4 = 3;
         }
      }

      int var3 = this.var_1df.sub_341();

      while(var3 > 0) {
         if (var4 == 0) {
            if (var3 % 2 == 0) {
               this.var_1df.sub_4b(this.var_1df.sub_27d() + 1);
            } else {
               this.var_1df.sub_92(this.var_1df.sub_28a() + 1);
            }
         }

         if (var4 == 1) {
            this.var_1df.sub_4b(this.var_1df.sub_27d() + 1);
         }

         if (var4 == 2) {
            this.var_1df.sub_92(this.var_1df.sub_28a() + 1);
         }

         if (var4 == 3) {
            if (var3 % 2 == 0) {
               this.var_1df.sub_4b(this.var_1df.sub_27d() + 1);
            } else {
               this.var_1df.sub_36(this.var_1df.sub_249() + 1);
            }
         }

         --var3;
         if (this.var_1df.jobId < 4095 && this.var_1df.var_19d < 440 && this.sub_3b8(var2) < 0) {
            break;
         }
      }

      this.sub_5d6(var2);
      GameScreen.gameScreen.sub_211c(var2);
   }
}
