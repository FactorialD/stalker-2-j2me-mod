import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Class_35d extends Class_4b3 {
   public int var_a = 0;
   public int var_3a;
   public Image var_8e;
   public Image var_f2;
   public int var_153;
   public int var_194;
   public int var_1a3;
   public Class_4b3 var_1d8;
   public int var_20a;
   public boolean var_217;
   public int var_262;
   public int var_2b3;
   public int var_303;
   public Image var_313;

   public Class_35d(int var1, int var2) {
      super(0, 0, 0, var1, var2, 0, (Planet)null);
      this.var_3a = GameScreen.gameScreen.var_d5c.sub_5ab();
      this.var_8e = null;
      this.var_f2 = null;
      this.var_153 = 1;
      this.var_194 = 0;
      this.var_1a3 = -1;
      this.var_1d8 = null;
      this.var_20a = 0;
      this.var_217 = false;
      this.var_262 = 0;
      this.var_313 = null;

      try {
         super.curRightImg = Image.createImage("/images/cur_right.png");
         super.curLeftImg = Image.createImage("/images/cur_left.png");
         super.curUpImg = Image.createImage("/images/cur_up.png");
         super.curDownImg = Image.createImage("/images/cur_down.png");
         super.colBtnImg = Image.createImage("/images/colbtn.png");
         super.colPicImg = Image.createImage("/images/colpic.png");
         super.blueLineImg = Image.createImage("/images/blueline.png");
         super.rShipImg = Image.createImage("/images/rship.png");
         super.rHouseImg = Image.createImage("/images/rhouse.png");
         super.rsocImg = Image.createImage("/images/rsoc.png");
         super.colPicImg = Image.createImage("/images/colpic.png");
         if (Stars.var_b9) {
            this.var_8e = Image.createImage("/mimage/clock.png");
         }

         super.tubaImg = Image.createImage("/images/tuba.png");
         this.var_f2 = Image.createImage("/images/tvsp.png");
         this.var_313 = Image.createImage("/images/tuba_pr.png");
         super.artefact = Image.createImage("/images/artefact.png");
      } catch (IOException var4) {
      }

      super.var_3c8 = 0;
      this.var_194 = this.var_194 = 52;
      if (super.windowHeight > 200) {
         this.var_194 = 74;
      }

      if (super.windowHeight <= 128) {
         this.var_194 = 39;
      }

      this.var_2b3 = GameScreen.gameScreen.sub_d38(GameScreen.gameScreen.var_d5c);
      this.var_303 = GameScreen.gameScreen.sub_d73(GameScreen.gameScreen.var_d5c);
   }

   public boolean sub_62() {
      return this.var_217 || this.var_262 != 0;
   }

   public void sub_81() {
      if (!this.sub_62()) {
         if (this.var_1d8 != null) {
            this.var_1d8.sub_140();
         } else {
            if (super.var_3c8 > 0) {
               --super.var_3c8;
            } else if (this.var_3a == 0) {
               super.var_3c8 = 6;
            }

            if (this.var_3a == 0) {
               if (super.windowHeight <= 128) {
                  this.var_153 = super.var_3c8 - 1;
                  if (this.var_153 < 1) {
                     this.var_153 = 1;
                  }

                  if (this.var_153 > 3) {
                     this.var_153 = 3;
                  }
               }
            } else if (super.var_3c8 < this.var_153) {
               --this.var_153;
            }

         }
      }
   }

   public void sub_e1() {
      if (!this.sub_62()) {
         if (this.var_1d8 != null) {
            this.var_1d8.sub_18d();
         } else {
            int var1 = this.sub_2f8();
            if (super.var_3c8 < var1) {
               ++super.var_3c8;
            } else if (this.var_3a == 0) {
               super.var_3c8 = 0;
            }

            int var2 = (this.var_194 - 8) / 11;
            if (super.windowHeight <= 128) {
               var2 = (this.var_194 - 6) / 11;
            }

            if (this.var_3a == 0) {
               if (super.windowHeight <= 128) {
                  this.var_153 = super.var_3c8 - 2;
                  if (this.var_153 < 1) {
                     this.var_153 = 1;
                  }

                  if (this.var_153 > 3) {
                     this.var_153 = 3;
                  }
               }
            } else if (super.var_3c8 >= this.var_153 + var2) {
               ++this.var_153;
            }

         }
      }
   }

   public void sub_13b() {
      if (!this.sub_62()) {
         if (this.var_1d8 == null) {
            if (this.var_3a == 0 && super.var_3c8 > 0) {
               if (super.var_3c8 < 6) {
                  GameScreen.gameScreen.var_d5c.sub_534(super.var_3c8 - 1);
               } else {
                  GameScreen.gameScreen.var_d5c.sub_481();
               }

               this.var_2b3 = GameScreen.gameScreen.sub_d38(GameScreen.gameScreen.var_d5c);
               this.var_303 = GameScreen.gameScreen.sub_d73(GameScreen.gameScreen.var_d5c);
            } else {
               super.var_3c8 = 0;
               this.var_153 = 1;
               if (this.var_3a == 10) {
                  this.var_3a = 0;
                  this.var_262 = super.var_124;
               } else {
                  if (this.var_3a == 0) {
                     this.var_262 = 1;
                  }

                  ++this.var_3a;
                  if (this.var_3a > GameScreen.gameScreen.var_d5c.sub_5ab()) {
                     this.var_3a = 10;
                  }
               }
            }
         }
      }
   }

   public void sub_164() {
      if (!this.sub_62()) {
         if (this.var_1d8 == null) {
            if (this.var_3a == 0 && super.var_3c8 > 0) {
               if (super.var_3c8 < 6) {
                  GameScreen.gameScreen.var_d5c.sub_58f(super.var_3c8 - 1);
               } else {
                  GameScreen.gameScreen.var_d5c.sub_4b9();
               }

               this.var_2b3 = GameScreen.gameScreen.sub_d38(GameScreen.gameScreen.var_d5c);
               this.var_303 = GameScreen.gameScreen.sub_d73(GameScreen.gameScreen.var_d5c);
            } else {
               super.var_3c8 = 0;
               this.var_153 = 1;
               if (this.var_3a == 10) {
                  this.var_3a = GameScreen.gameScreen.var_d5c.sub_5ab();
               } else if (this.var_3a == 0) {
                  this.var_3a = 10;
                  this.var_262 = 1;
               } else {
                  --this.var_3a;
                  if (this.var_3a == 0) {
                     this.var_262 = super.var_124;
                  }

               }
            }
         }
      }
   }

   public void sub_1c4(GameScreen var1, Graphics var2) {
      if (super.var_1f3 < 100) {
         super.var_1f3 += 12;
      }

      byte var3 = 23;
      if (super.var_3c8 == 0) {
         this.sub_491(var2, 5, this.var_a - var3 + 7, super.var_124 - 10);
      }

      var1.sub_1086(var2, 5, this.var_a - var3, super.var_124 - 10);
      this.sub_2a7(var2, 5, this.var_a - var3 + 9);
      if (this.var_a < var3) {
         this.var_a += 5;
         if (this.var_a > var3) {
            this.var_a = var3;
         }
      }

      this.sub_223(var2);
      if (this.var_1d8 != null) {
         this.var_1d8.sub_108(var2);
         this.sub_514(var2, this.var_1d8.xPos + 4, this.var_1d8.yPos + 11, this.var_1d8.var_124 - 8, 30);
         String var4 = GameScreen.gameScreen.sub_19a5(this.var_1a3, 1);
         String var5 = "";
         if (GameScreen.gameScreen.sub_19a5(this.var_1a3, 2) != "OK") {
            this.var_1d8 = null;
            return;
         }

         if (var4 == "A") {
            var5 = SomeUtilClass.getStr("ЗАЩИТА НОВОЙ БРОНИ ДЛЯ СТАЛКЕРОВ БУДЕТ ") + GameScreen.gameScreen.var_10d4[GameScreen.gameScreen.var_1d2e].someInt3;
         }

         if (var4 == "B") {
            var5 = GameScreen.gameScreen.passiveUpgradesDictArr[GameScreen.gameScreen.var_1d2e].var_144;
         }

         if (var4 == "BU") {
            var5 = GameScreen.gameScreen.buildingDictArr[GameScreen.gameScreen.var_1d2e].var_144;
         }

         if (var4 == "C") {
            var5 = SomeUtilClass.getStr("МОЩНОСТЬ НОВЫХ БОЕПРИПАСОВ БУДЕТ ") + GameScreen.gameScreen.var_1116[GameScreen.gameScreen.var_1d2e].someInt3;
         }

         if (var4 == "E") {
            var5 = SomeUtilClass.getStr("ВЫНОСЛИВОСТЬ СТАЛКЕРОВ БУДЕТ ") + GameScreen.gameScreen.var_1095[GameScreen.gameScreen.var_1d2e].someInt3;
         }

         if (var4 == "W") {
            var5 = SomeUtilClass.getStr("УРОН ОРУЖИЯ ") + GameScreen.gameScreen.var_1171[GameScreen.gameScreen.var_1d2e].someInt3;
         }

         if (var4 == "ART") {
            var5 = SomeUtilClass.getStr("ТАИНСТВЕННЫЙ АРТЕФАКТ НАЙДЕННЫЙ В ЛАГЕРЕ ") + GameScreen.gameScreen.artifactsDictArr[GameScreen.gameScreen.var_1d2e].var_68;
         }

         SomeUtilClass.sub_1db(var2, var5, this.var_1d8.xPos + 7, this.var_1d8.yPos + 11 + 5, this.var_1d8.xPos + this.var_1d8.var_124 - 5, this.var_1d8.yPos + 11 + 5 + 30);
      }

      if (this.var_3a > 0 && this.var_3a < 10) {
         super.var_e5a = 7;
      }

      if (this.var_3a == 0) {
         super.var_e5a = 8;
      }

      if (this.var_3a == 10) {
         super.var_e5a = 9;
      }

   }

   public void sub_223(Graphics var1) {
      int var3;
      byte var4;
      int var6;
      if (this.var_3a > 0 && this.var_262 == 0) {
         byte var9 = 26;
         var4 = 5;
         this.sub_389(var1, var4, var9, super.var_124 - var4 * 2, this.var_194);
         int var11 = var9 + 6;
         var6 = 0;
         boolean var7 = false;
         String var2;
         int var8;
         if (this.var_3a != 10) {
            for(var8 = 0; var8 < 64; ++var8) {
               if (this.sub_2eb(var8)) {
                  if (var11 >= this.var_194 + var9 - 11) {
                     var7 = true;
                     break;
                  }

                  ++var6;
                  if (var6 >= this.var_153) {
                     if (var6 == super.var_3c8) {
                        this.sub_491(var1, var4 + 20, var11 - 3, super.var_124 - var4 * 2 - 25);
                        if (super.var_3c8 > 0) {
                           this.var_20a = var11 - 3;
                        }
                     }

                     var2 = GameScreen.gameScreen.sub_19a5(var8, 0);
                     GameScreen.gameScreen.sub_fcf(var1, var4 + 22, var11, var2, GameScreen.gameScreen.rMiniFront2Img);
                     this.sub_254(var1, GameScreen.gameScreen.sub_19a5(var8, 1), var4 + 6, var11 - 2);
                     var11 += 11;
                  }
               }
            }
         }

         if (this.var_3a == 10) {
            for(var8 = 0; var8 < 10; ++var8) {
               if (GameScreen.gameScreen.var_d5c.sub_2cc(var8) && GameScreen.gameScreen.var_d5c.var_5da != 255 + var8) {
                  if (var11 >= this.var_194 + var9 - 11) {
                     var7 = true;
                     break;
                  }

                  ++var6;
                  if (var6 >= this.var_153) {
                     if (var6 == super.var_3c8) {
                        this.sub_491(var1, var4 + 20, var11 - 3, super.var_124 - var4 * 2 - 25);
                        if (super.var_3c8 > 0) {
                           this.var_20a = var11 - 3;
                        }
                     }

                     var2 = SomeUtilClass.getStr("АРТЕФАТК") + " " + (var8 + 1);
                     GameScreen.gameScreen.sub_fcf(var1, var4 + 22, var11, var2, GameScreen.gameScreen.rMiniFront2Img);
                     this.sub_254(var1, "ART", var4 + 6, var11 - 2);
                     var11 += 11;
                  }
               }
            }
         }

         if (this.var_153 > 1) {
            var1.drawImage(super.curUpImg, var4 + super.var_124 - var4 * 2 - 14, var9 + 6, 20);
         }

         if (var7) {
            var1.drawImage(super.curDownImg, var4 + super.var_124 - var4 * 2 - 14, var9 + this.var_194 - 11, 20);
         }

         var3 = var9 + this.var_194 + 4;
         this.sub_389(var1, var4, var3, super.var_124 - var4 * 2, 20);
         if (GameScreen.gameScreen.var_d5c.var_5da == 0) {
            var2 = SomeUtilClass.getStr("ПУСТО");
            this.sub_3c7(var1, var4 + 5, var3 + 3, 2, 0, false);
            GameScreen.gameScreen.drawFancyText(var1, var4 + (super.var_124 - var4 * 2 - var2.length() * 8) / 2, var3 + 7, var2, super.var_42f);
         } else {
            this.sub_3c7(var1, var4 + 5, var3 + 3, 2, 0, false);
            var2 = GameScreen.gameScreen.sub_19a5(GameScreen.gameScreen.var_d5c.var_5da, 0);
            if (this.var_217) {
               this.sub_491(var1, var4 + 20, this.var_20a, super.var_124 - var4 * 2 - 25);
               GameScreen.gameScreen.sub_fcf(var1, var4 + 22, this.var_20a + 3, var2, GameScreen.gameScreen.rMiniFront2Img);
               this.var_20a += 10;
               if (this.var_20a >= var3) {
                  this.var_217 = false;
               }
            } else {
               GameScreen.gameScreen.sub_fcf(var1, var4 + 22, var3 + 8, var2, GameScreen.gameScreen.rMiniFront2Img);
               this.sub_254(var1, GameScreen.gameScreen.sub_19a5(GameScreen.gameScreen.var_d5c.var_5da, 1), var4 + super.var_124 - var4 * 2 - 20, var3 + 6);
               var3 += 24;
               if (this.var_8e != null) {
                  var1.drawImage(this.var_8e, var4 + 3, var3, 20);
               }

               var2 = GameScreen.gameScreen.sub_d1d(GameScreen.gameScreen.var_d5c, GameScreen.gameScreen.var_d5c.var_5da, this.var_2b3) + " " + SomeUtilClass.getStr("ХОДОВ");
               GameScreen.gameScreen.drawFancyText(var1, var4 + 24, var3 + 3, var2, super.var_42f);
               var2 = "+" + this.var_2b3 + " " + SomeUtilClass.getStr("ИТ") + " (";
               var2 = var2 + GameScreen.gameScreen.sub_cd0(GameScreen.gameScreen.var_d5c.var_5da) + " " + SomeUtilClass.getStr("ИТ") + ")";
               GameScreen.gameScreen.sub_fcf(var1, var4 + 24, var3 + 3 + 9, var2, GameScreen.gameScreen.rMiniFront2Img);
            }
         }
      } else {
         var3 = 24;
         var4 = 5;
         byte var5 = var4;
         int var10 = var4 + this.var_262;
         if (this.var_262 > 0) {
            if (this.var_3a == 0) {
               this.var_262 -= 20;
               if (this.var_262 < 0) {
                  this.var_262 = 0;
               }
            } else {
               this.var_262 += 20;
               if (this.var_262 >= super.var_124) {
                  this.var_262 = 0;
                  return;
               }
            }
         }

         if (super.var_c28 == null) {
            this.sub_3fa(super.var_124 - var4, 85);
         }

         for(var6 = 0; var6 < 5; ++var6) {
            this.sub_4b3(var1, var10, var3, super.var_124 - var5, 85, GameScreen.gameScreen.var_d5c.var_513[var6], SomeUtilClass.scienceBranchNamesArr[var6], GameScreen.gameScreen.var_d5c.var_4b4[var6], var6 + 1 == super.var_3c8, GameScreen.gameScreen.var_d5c.sub_46d(var6, this.var_303), GameScreen.gameScreen.var_d5c.sub_40d(var6));
            if (super.windowHeight > 200) {
               var3 += 21;
            } else {
               var3 += 17;
            }
         }

         this.sub_4cb(var1, var5, var3, super.var_124 - var5 * 2);
      }

   }

   public void sub_254(Graphics var1, String var2, int var3, int var4) {
      if (var2 == "A" || var2 == "C" || var2 == "E" || var2 == "W") {
         var1.drawImage(super.rShipImg, var3, var4, 20);
      }

      if (var2 == "B") {
         var1.drawImage(super.rsocImg, var3, var4, 20);
      }

      if (var2 == "BU") {
         var1.drawImage(super.rHouseImg, var3, var4, 20);
      }

      if (var2 == "ART") {
         var1.drawImage(super.artefact, var3, var4, 20);
      }

   }

   public void sub_2a7(Graphics var1, int var2, int var3) {
      int var4 = var2 + 12;
      boolean var5 = true;
      byte var7 = 1;

      int var6;
      for(var6 = 0; var6 < var7; ++var6) {
         var1.drawImage(super.curLeftImg, var4, var3, 20);
         var4 += 8;
      }

      var4 = super.var_124 - 12 - var2 - super.curLeftImg.getWidth();

      for(var6 = 0; var6 < var7; ++var6) {
         var1.drawImage(super.curRightImg, var4, var3, 20);
         var4 -= 8;
      }

      String var8 = SomeUtilClass.getStr("УРОВЕНЬ") + " " + this.var_3a;
      if (this.var_3a == 0) {
         var8 = SomeUtilClass.getStr("ТЕОРИЯ");
      }

      if (this.var_3a == 10) {
         var8 = SomeUtilClass.getStr("АРТЕФАКТЫ");
      }

      var4 = (super.var_124 - var8.length() * 8) / 2;
      GameScreen.gameScreen.drawFancyText(var1, var4, var3, var8, super.var_42f);
   }

   public boolean sub_2eb(int var1) {
      return var1 >= 0 && var1 < GameScreen.gameScreen.var_fc9.length && !GameScreen.gameScreen.var_d5c.sub_139(var1) && GameScreen.gameScreen.var_d5c.sub_3bf(GameScreen.gameScreen.var_fc9[var1]) && this.sub_315(var1) == this.var_3a && GameScreen.gameScreen.var_d5c.var_5da != var1;
   }

   public int sub_2f8() {
      if (this.var_3a == 0) {
         return 6;
      } else {
         int var1 = 0;
         int var2;
         if (this.var_3a != 10) {
            for(var2 = 0; var2 < 64; ++var2) {
               if (this.sub_2eb(var2)) {
                  ++var1;
               }
            }
         }

         if (this.var_3a == 10) {
            for(var2 = 0; var2 < 10; ++var2) {
               if (GameScreen.gameScreen.var_d5c.sub_2cc(var2) && GameScreen.gameScreen.var_d5c.var_5da != 255 + var2) {
                  ++var1;
               }
            }
         }

         return var1;
      }
   }

   public int sub_315(int var1) {
      byte var2 = 0;
      Class_4b var3 = GameScreen.gameScreen.var_fc9[var1];
      if (var3 == null) {
         return 0;
      } else {
         for(int var4 = 0; var4 < var3.var_2d.length; ++var4) {
            if (var2 < var3.var_2d[var4]) {
               var2 = var3.var_2d[var4];
            }
         }

         return var2;
      }
   }

   public void sub_33c() {
      if (this.var_1d8 == null) {
         this.var_1d8 = new Class_4b3(8, (super.var_124 - 118) / 2, (super.windowHeight - 67) / 2, 118, 67, 3158064, (Planet)null);
         this.var_1d8.var_1f3 = 67;
         this.var_1a3 = this.sub_38e();
         if (this.var_1a3 == -1) {
            this.var_1d8 = null;
         } else {
            this.var_1d8.var_26e = GameScreen.gameScreen.sub_19a5(this.var_1a3, 0);
         }
      }
   }

   public int sub_38e() {
      int var1 = 0;
      int var2;
      if (this.var_3a > 0 && this.var_3a < 6) {
         for(var2 = 0; var2 < 64; ++var2) {
            if (this.sub_2eb(var2)) {
               ++var1;
               if (var1 == super.var_3c8) {
                  return var2;
               }
            }
         }
      }

      if (this.var_3a == 10) {
         for(var2 = 0; var2 < 10; ++var2) {
            if (GameScreen.gameScreen.var_d5c.sub_2cc(var2) && GameScreen.gameScreen.var_d5c.var_5da != 255 + var2) {
               ++var1;
               if (var1 == super.var_3c8) {
                  return var2 + 255;
               }
            }
         }
      }

      return -1;
   }

   public void sub_39f() {
      GameScreen.gameScreen.var_d5c.var_5da = this.var_1a3;
      super.var_3c8 = 0;
      this.var_153 = 1;
      this.var_217 = true;
   }

   public void sub_3fa(int var1, int var2) {
      var2 -= 20;
      super.var_c28 = Image.createImage(var1, super.tubaImg.getHeight());
      Graphics var3 = super.var_c28.getGraphics();
      var3.fillRect(0, 0, var1, super.tubaImg.getHeight());
      byte var4 = 0;
      var3.setClip(var4, 0, 3, 20);
      var3.drawImage(super.tubaImg, var4, 0, 20);

      for(int var5 = var4 + 3; var5 < var1; var5 += 2) {
         if (var5 > var2 && var5 < var2 + 4) {
            var3.setClip(var5, 0, 2, 20);
            var3.drawImage(super.tubaImg, var5 - 1, 0, 20);
         } else {
            var3.setClip(var5, super.yPos, 2, 4);
            var3.drawImage(super.tubaImg, var5 - 1, super.yPos, 20);
            var3.setClip(var5, super.yPos + 16, 2, 4);
            var3.drawImage(super.tubaImg, var5 - 1, super.yPos, 20);
         }
      }

      var3.setClip(0, 0, var1, super.tubaImg.getHeight());
      this.sub_82c(var3, 3, 4, var2);
      this.sub_82c(var3, var2 + 4, 4, var1);
   }

   public void sub_45b(Graphics var1, int var2, int var3, int var4, int var5) {
      int var6 = var4 + var2 + 6;
      int var7 = (super.var_124 - (var2 + var4 + 5)) * var5 / 100;
      var1.setClip(var6, var3 + 6, var7, 9);

      do {
         var1.drawImage(this.var_313, var6, var3, 20);
         var7 -= 2;
         var6 += 2;
      } while(var7 > 0);

      var1.setClip(0, 0, super.var_124, super.windowHeight);
   }

   public void sub_4b3(Graphics var1, int var2, int var3, int var4, int var5, int var6, String var7, int var8, boolean var9, int var10, int var11) {
      if (var2 < super.var_124) {
         var5 -= 20;
         var1.drawImage(super.var_c28, var2, var3, 20);
         this.sub_45b(var1, var2, var3, var5, var6);
         if (var9) {
            this.sub_8d8(var1, var2, var3, var5 - 4, super.blueLineImg);
         }

         GameScreen.gameScreen.sub_fcf(var1, var2 + 7, var3 + 8, var7, GameScreen.gameScreen.rMiniFront2Img);
         GameScreen.gameScreen.drawFancyText(var1, var2 + var5 - 6, var3 + 7, "" + var8, super.var_42f);
         GameScreen.gameScreen.sub_fcf(var1, var5 + var2 + 8, var3 + 8, var10 + " " + SomeUtilClass.getStr("ХОДОВ"), GameScreen.gameScreen.rMiniFront2Img);
         int var12 = (super.var_124 - var2 + 3) * var11 / 100;
         if (var12 > 2) {
            var1.setColor(697098);
            var1.drawLine(var2 + 3, var3 + 1, var2 + 3 + var12, var3 + 1);
            var1.setColor(0);
            var1.drawLine(var2 + 3, var3 + 2, var2 + 3 + var12, var3 + 2);
         }

      }
   }

   public void sub_4cb(Graphics var1, int var2, int var3, int var4) {
      int var5 = var4 / 2;
      if (super.var_3c8 == 6) {
         this.sub_491(var1, var2 + 1, var3 + 6, var4 - 2);
      }

      int var6 = var3 + 19;
      int var7 = var2 + 4;
      var1.setClip(var7, var6, 4, 9);
      var1.drawImage(this.var_f2, var7, var6, 20);
      var7 = var2 + var4 - 3 - 4;
      var1.setClip(var7, var6, 4, 9);
      var1.drawImage(this.var_f2, var7 - 6, var6, 20);
      int var8 = (100 - GameScreen.gameScreen.var_d5c.var_622) * (var4 - 14) / 100;

      for(var7 = var2 + 8; var7 < var2 + var4 - 7; ++var7) {
         var1.setClip(var7, var6, 1, 7);
         if (var7 < var2 + var8 + 8) {
            var1.drawImage(this.var_f2, var7 - 4, var6, 20);
         } else {
            var1.drawImage(this.var_f2, var7 - 5, var6, 20);
         }
      }

      String var9 = "+" + this.var_303 + " " + SomeUtilClass.getStr("ИТ");
      GameScreen.gameScreen.sub_fcf(var1, var2 + 10, var6 + 11, var9, GameScreen.gameScreen.rMiniFront2Img);
      var9 = "+" + this.var_2b3 + " " + SomeUtilClass.getStr("ИТ");
      var7 = var2 + var4 - 6 - var9.length() * 5;
      GameScreen.gameScreen.sub_fcf(var1, var7, var6 + 11, var9, GameScreen.gameScreen.rMiniFront2Img);
      var1.setClip(var2, var3, 3, 20);
      var1.drawImage(super.tubaImg, var2, var3, 20);

      for(var7 = var2 + 3; var7 < var2 + var4 - 3; var7 += 2) {
         if (var7 >= var2 + var5 - 3 && var7 <= var2 + var5 + 3) {
            var1.setClip(var7, var3, 2, 20);
            var1.drawImage(super.tubaImg, var7 - 1, var3, 20);
         } else {
            var1.setClip(var7, var3, 2, 4);
            var1.drawImage(super.tubaImg, var7 - 1, var3, 20);
            var1.setClip(var7, var3 + 16, 2, 4);
            var1.drawImage(super.tubaImg, var7 - 1, var3, 20);
         }
      }

      var1.setClip(var7, var3, 2, 20);
      var1.drawImage(super.tubaImg, var7 - 1, var3, 20);
      var7 += 2;
      var1.setClip(var7, var3, 1, 20);
      var1.drawImage(super.tubaImg, var7, var3, 20);
      var1.setClip(0, 0, super.var_124, super.windowHeight);
      this.sub_82c(var1, var2 + 3, var3 + 4, var2 + var5 - 4);
      this.sub_82c(var1, var5 + var2 + 4, var3 + 4, var2 + var4 - 5);
      var7 = var2 + 3 + (var5 - SomeUtilClass.getStr("ТЕОРИЯ").length() * 5) / 2;
      GameScreen.gameScreen.sub_fcf(var1, var7, var3 + 8, SomeUtilClass.getStr("ТЕОРИЯ"), GameScreen.gameScreen.rMiniFront2Img);
      var7 = var2 - 3 + var5 + (var5 - SomeUtilClass.getStr("ПРАКТИКА").length() * 5) / 2;
      GameScreen.gameScreen.sub_fcf(var1, var7, var3 + 8, SomeUtilClass.getStr("ПРАКТИКА"), GameScreen.gameScreen.rMiniFront2Img);
      var1.drawImage(super.curLeftImg, var2 + 7, var3 + 8, 20);
      var1.drawImage(super.curRightImg, var2 + var4 - 10, var3 + 8, 20);
   }
}
