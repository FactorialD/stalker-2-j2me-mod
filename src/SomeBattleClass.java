import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class SomeBattleClass {
   public int var_1d;
   public int var_47;
   public int var_ab;
   public int var_fb;
   public int var_132;
   public int var_15e;
   public Vector var_1ab = null;
   public Vector var_1cd = null;
   public Vector var_223 = null;
   public boolean var_266 = true;
   public boolean var_281 = false;
   public boolean var_2b0 = false;
   public boolean var_2ba = false;
   public Class_4b3 var_2da = null;
   public int var_326;
   public int var_37d;
   public int var_3ba;
   public int var_408;
   public Image[] var_468 = new Image[6];
   public Random var_4cc;
   public Image var_4f3;
   public Image var_551 = null;
   public int var_59f;
   public Image var_5b8 = null;
   public Image var_5ce = null;
   public Image var_5f2 = null;
   public Image var_5fe = null;
   public Image var_60d = null;
   public boolean var_640;

   public SomeBattleClass(boolean var1, int var2, int var3, int var4, int var5) {
      this.var_266 = var1;
      this.var_132 = var2;
      this.var_15e = var3;
      this.var_1d = var4;
      this.var_47 = var5;
      this.var_ab = GameScreen.gameScreen.sub_122a(var4).sub_7d3();
      this.var_fb = GameScreen.gameScreen.sub_122a(var5).sub_7d3();
      this.var_1cd = new Vector();
      this.var_223 = new Vector();
      int var6 = GameScreen.gameScreen.sub_1592(var2, var3);
      this.var_1ab = new Vector();

      int var9;
      for(var9 = 0; var9 < var6; ++var9) {
         Class_4f2 var7 = GameScreen.gameScreen.sub_15d8(var2, var3, var9 + 1);
         if (var7.sub_582() > 0) {
            Class_556 var8 = new Class_556(var7);
            if (var7.sub_236() == var4) {
               var8.var_157 = true;
            } else {
               var8.var_157 = false;
            }

            this.var_1ab.addElement(var8);
         }
      }

      this.var_640 = this.sub_1ba();
      this.var_2b0 = this.var_640;
      this.var_326 = var4;
      this.var_408 = (GameScreen.gameScreen.getHeight() - 32) / 32;
      this.var_37d = 32;
      this.var_3ba = GameScreen.gameScreen.getWidth() - 32;
      this.sub_399();
      this.var_4cc = new Random();
      if (this.var_640) {
         for(var9 = 0; var9 < 6; ++var9) {
            this.var_468[var9] = this.sub_6f(var9);
         }

         try {
            this.var_5b8 = Image.createImage("/images/mexpl.png");
            this.var_4f3 = Image.createImage("/images/rship.png");
            this.var_551 = this.sub_29(Image.createImage("/images/rpanel.png"), GameScreen.gameScreen.getWidth(), 21, GameScreen.gameScreen.sub_11e1(var4), GameScreen.gameScreen.sub_11e1(var5));
            this.var_5ce = Image.createImage("/images/rocket.png");
            this.var_5f2 = this.sub_7f(this.var_5ce);
            this.var_5fe = Image.createImage("/images/plasma.png");
         } catch (IOException var10) {
         }

         if (GameScreen.gameScreen.musicManager != null) {
        	 //set battle music
            GameScreen.gameScreen.musicManager.changeMusicId(2);
         }
      }

      this.var_59f = 21;
   }

   public Image sub_29(Image var1, int var2, int var3, String var4, String var5) {
      Image var6 = Image.createImage(var2, var3);
      Graphics var7 = var6.getGraphics();
      var7.setColor(1052688);
      var7.fillRect(0, 0, var2, var3);
      var7.setColor(1052688);
      var7.fillRect(4, 9, var2 - 8, var3 - 9);
      if (var1 == null) {
         return var6;
      } else {
         var7.setClip(0, 0, 48, 9);
         var7.drawImage(var1, 0, 0, 20);
         int var8 = 48;

         for(boolean var9 = false; var8 <= var2 - 40; var8 += 4) {
            var7.setClip(var8, 0, 4, 9);
            var7.drawImage(var1, var8 - 45, 0, 20);
         }

         var7.setClip(var2 - 48, 0, 48, 9);
         var7.drawImage(var1, var2 - var1.getWidth(), 0, 20);

         for(int var11 = 9; var11 < var3; var11 += 3) {
            var7.setClip(0, var11, 4, 3);
            var7.drawImage(var1, 0, var11 - 13, 20);
            var7.setClip(var2 - 4, var11, 4, 3);
            var7.drawImage(var1, var2 - var1.getWidth(), var11 - 13, 20);
         }

         String var10 = var4 + " " + SomeUtilClass.getStr("И") + " " + var5;
         if (var2 > 128) {
            var8 = (var2 - var10.length() * 8) / 2;
            GameScreen.gameScreen.drawFancyText(var7, var8, 11, var10, GameScreen.gameScreen.rBigFrontImg);
         } else {
            var8 = (var2 - var10.length() * 5) / 2;
            GameScreen.gameScreen.sub_fcf(var7, var8, 12, var10, GameScreen.gameScreen.rMiniFront2Img);
         }

         return var6;
      }
   }

   public Image sub_6f(int var1) {
      return Image.createImage(GameScreen.gameScreen.shipImgArr[var1], 0, 0, GameScreen.gameScreen.shipImgArr[var1].getWidth(), GameScreen.gameScreen.shipImgArr[var1].getHeight(), 2);
   }

   public Image sub_7f(Image var1) {
      return Image.createImage(var1, 0, 0, var1.getWidth(), var1.getHeight(), 2);
   }

   public Image sub_d7(Image var1) {
      return Image.createImage(var1, 0, 0, var1.getWidth(), var1.getHeight(), 2);
   }

   public void sub_16f() {
      int var1 = this.sub_378();
      int var2 = this.var_1d;
      if (var2 == var1) {
         var2 = this.var_47;
      }

      GameScreen.gameScreen.sub_bfc(this.var_132, this.var_15e, var1, var2);
   }

   public boolean sub_1ba() {
      return !GameScreen.gameScreen.sub_122a(this.var_1d).var_47e || !GameScreen.gameScreen.sub_122a(this.var_47).var_47e;
   }

   public void sub_1da() {
      if (GameScreen.gameScreen.gameActionState.fire) {
         if (this.var_2da != null && this.var_2b0) {
            this.var_2da = null;
            this.var_2b0 = false;
         }

         if (this.var_2da != null && this.var_2ba) {
            this.var_2da = null;
            this.var_2ba = false;
            this.var_281 = true;
            if (GameScreen.gameScreen.musicManager != null) {
            	//maybe set default music after battle
               GameScreen.gameScreen.musicManager.changeMusicId(3);
            }
         }

         GameScreen.gameScreen.gameActionState.fire = false;
      }

   }

   public void someBattleMethod(Graphics g) {
      if (!this.var_281) {
         if (this.var_640) {
            g.setColor(0);
            g.fillRect(0, 0, g.getClipWidth(), g.getClipHeight());
            GameScreen.gameScreen.someDrawingFunction2(g, true);
            g.drawImage(this.var_551, 0, g.getClipHeight() - this.var_551.getHeight() + this.var_59f, 20);
            this.sub_31d(g);
         }

         if (this.var_2b0) {
            if (this.var_2da == null) {
               this.var_2da = new Class_4b3(6, 0, 0, 0, 0, 3158064, (Planet)null);
               this.var_2da.addMenu2Option(-1, this.var_2da.yPos + 8, GameScreen.gameScreen.sub_11e1(this.var_326), false);
               this.var_2da.addMenu2Option(-1, this.var_2da.yPos + 8 + 7, SomeUtilClass.getStr("АТАКУЮТ"), false);
               if (this.var_326 != this.var_47) {
                  this.var_2da.addMenu2Option(-1, this.var_2da.yPos + 8 + 7 + 7, GameScreen.gameScreen.sub_11e1(this.var_47), false);
               } else {
                  this.var_2da.addMenu2Option(-1, this.var_2da.yPos + 8 + 7 + 7, GameScreen.gameScreen.sub_11e1(this.var_1d), false);
               }

               this.var_2da.var_1f3 = this.var_2da.var_124;
            }

            this.var_2da.sub_108(g);
            if (this.var_59f > 0) {
               --this.var_59f;
            }

         } else if (this.var_2ba) {
            if (this.var_2da == null) {
               this.var_2da = new Class_4b3(6, 0, 0, 0, 0, 3158064, (Planet)null);
               this.var_2da.addMenu2Option(-1, this.var_2da.yPos + 12, SomeUtilClass.getStr("ПОБЕДИТЕЛЬ"), false);
               this.var_2da.addMenu2Option(-1, this.var_2da.yPos + 12 + 7, GameScreen.gameScreen.sub_11e1(this.sub_378()), false);
               this.var_2da.var_1f3 = this.var_2da.var_124;
            }

            this.var_2da.sub_108(g);
         } else {
            if (this.var_640) {
               this.var_59f = 0;
               this.sub_453();
            } else {
               while(!this.sub_29b()) {
                  this.sub_453();
               }
            }

            if (this.sub_29b()) {
               this.sub_16f();
               if (this.var_640) {
                  this.var_2ba = true;
               } else {
                  this.var_281 = true;
               }

            }
         }
      }
   }

   public boolean sub_29b() {
      return this.sub_2e6(this.var_1d) == 0 || this.sub_2e6(this.var_47) == 0;
   }

   public int sub_2e6(int var1) {
      int var3 = 0;

      for(int var4 = 0; var4 < this.var_1ab.size(); ++var4) {
         Class_556 var2 = (Class_556)this.var_1ab.elementAt(var4);
         if (var2.var_64.sub_236() == var1) {
            ++var3;
         }
      }

      return var3;
   }

   public void sub_31d(Graphics var1) {
      if (!this.var_2ba) {
         this.sub_605(var1);
      }

      for(int var3 = 0; var3 < this.var_1ab.size(); ++var3) {
         Class_556 var2 = (Class_556)this.var_1ab.elementAt(var3);
         this.sub_36d(var1, var2);
      }

      this.sub_355(var1);
      this.sub_581(var1);
   }

   public void sub_355(Graphics var1) {
      String var2 = "" + this.sub_2e6(this.var_1d);
      byte var3 = 3;
      byte var4 = 5;
      var1.drawImage(this.var_4f3, var4, var3, 20);
      SomeUtilClass.drawSomeLittleFigure(var1, var4, var3, GameScreen.gameScreen.sub_121c(this.var_1d));
      GameScreen.gameScreen.drawFancyText(var1, var4 + 16, var3, var2, GameScreen.gameScreen.rBigFrontImg);
      int var5 = GameScreen.gameScreen.getWidth() - 5 - 13;
      var1.drawImage(this.var_4f3, var5, var3, 20);
      SomeUtilClass.drawSomeLittleFigure(var1, var5, var3, GameScreen.gameScreen.sub_121c(this.var_47));
      var2 = "" + this.sub_2e6(this.var_47);
      var5 = var5 - 3 - var2.length() * 8;
      GameScreen.gameScreen.drawFancyText(var1, var5, var3, var2, GameScreen.gameScreen.rBigFrontImg);
   }

   public void sub_36d(Graphics var1, Class_556 var2) {
      if (!var2.sub_2b()) {
         if (var2.var_2e6) {
            if (this.var_60d != null) {
               var1.drawImage(this.var_60d, var2.var_b6 + this.var_60d.getWidth() / 2, var2.var_f9 + this.var_60d.getHeight() / 2, 20);
            }
         } else {
            int var3 = var2.var_64.sub_18d(28);
            if (var2.var_157) {
               GameScreen.gameScreen.sub_240c(var1, var2.var_b6, var2.var_f9, var3, var2.var_64.sub_236(), 32, var2.var_b6 != var2.var_105, this.var_468[var3]);
            } else {
               GameScreen.gameScreen.sub_240c(var1, var2.var_b6, var2.var_f9, var3, var2.var_64.sub_236(), 32, var2.var_b6 != var2.var_105, (Image)null);
            }

         }
      }
   }

   public int sub_378() {
      int var1 = this.var_1d;
      if (this.sub_2e6(this.var_1d) == 0) {
         var1 = this.var_47;
      }

      return var1;
   }

   public void sub_399() {
      int var2 = Math.min(this.sub_2e6(this.var_1d), this.var_408);
      int var3 = 11 + (this.var_408 - var2) * 32 / 2;
      int var4 = 0;
      int var5 = 0;

      Class_556 var1;
      while(var4 < var2 && var5 < this.var_1ab.size()) {
         var1 = (Class_556)this.var_1ab.elementAt(var5);
         ++var5;
         if (var1.var_64.sub_236() == this.var_1d) {
            var1.var_b6 = 0;
            var1.var_f9 = var3;
            var1.sub_9f();
            var3 += 32;
            ++var4;
         }
      }

      var2 = Math.min(this.sub_2e6(this.var_47), this.var_408);
      var3 = 11 + (this.var_408 - var2) * 32 / 2;
      var4 = 0;
      var5 = 0;

      while(var4 < var2 && var5 < this.var_1ab.size()) {
         var1 = (Class_556)this.var_1ab.elementAt(var5);
         ++var5;
         if (var1.var_64.sub_236() == this.var_47) {
            var1.var_b6 = this.var_3ba;
            var1.var_f9 = var3;
            var1.sub_9f();
            var3 += 32;
            ++var4;
         }
      }

      this.sub_3e5();
   }

   public void sub_3e5() {
      boolean var1 = true;
      Planet var2 = GameScreen.gameScreen.sub_76d(this.var_132, this.var_15e);
      if (var2 != null) {
         if (var2.var_1df != null && var2.var_1df.sub_e3(10)) {
            if (var2.var_1df.var_4f == this.var_1d) {
               var1 = false;
            }

            int var3 = this.var_37d;
            if (var1) {
               var3 = this.var_3ba - 32;
            }

            Class_556 var4 = new Class_556(this.sub_43a(var2.var_1df.var_4f));
            var4.var_b6 = var3;
            var4.var_f9 = 11;
            var4.var_157 = var1;
            var4.var_2e6 = true;
            var4.sub_9f();
            this.var_1ab.addElement(var4);
            var4 = new Class_556(this.sub_43a(var2.var_1df.var_4f));
            var4.var_b6 = var3;
            var4.var_f9 = 11 + (this.var_408 - 1) * 32;
            var4.var_157 = var1;
            var4.var_2e6 = true;
            var4.sub_9f();
            this.var_1ab.addElement(var4);

            try {
               this.var_60d = Image.createImage("/images/sputnik.png");
               if (var1) {
                  this.var_60d = this.sub_d7(this.var_60d);
               }
            } catch (IOException var6) {
            }
         }

      }
   }

   public Class_4f2 sub_43a(int var1) {
      Class_2a9 var2 = GameScreen.gameScreen.sub_122a(var1);
      Class_4f2 var3 = new Class_4f2();
      var3.sub_449(0, 3);
      var3.sub_1d7(28, 1);
      var3.sub_1d7(20, 0);
      var3.sub_1d7(8, var2.sub_1d4());
      var3.sub_1d7(0, 1);
      var3.sub_1d7(24, var2.sub_1c4());
      var3.var_3e = var1;
      return var3;
   }

   public void sub_453() {
      this.sub_466(this.var_1d);
      this.sub_466(this.var_47);
      this.sub_5b5();
   }

   public void sub_466(int var1) {
      int var2 = this.var_1d;
      if (var2 == var1) {
         var2 = this.var_47;
      }

      for(int var5 = 0; var5 < this.var_1ab.size(); ++var5) {
         Class_556 var3 = (Class_556)this.var_1ab.elementAt(var5);
         if (var3.var_64.sub_236() == var1 && !var3.sub_2b()) {
            var3.sub_c6();
            int var6 = var3.var_64.sub_400();
            if (var3.sub_51()) {
               while(var6 > 0) {
                  Class_556 var4 = this.sub_49b(var3, var2);
                  if (var4 == null) {
                     break;
                  }

                  int var7 = var3.sub_1ee(var4);
                  if (var7 >= var6) {
                     var7 = var6;
                     var3.var_64.sub_3c(var4.var_64.sub_18d(28));
                  }

                  var6 -= var7;
                  this.sub_565(var3, var4, var3.var_64.sub_400());
               }

               var3.sub_80();
            }
         }
      }

   }

   public Class_556 sub_49b(Class_556 var1, int var2) {
      int var3 = 0;
      Class_556 var4 = null;

      for(int var6 = 0; var6 < this.var_1ab.size(); ++var6) {
         Class_556 var5 = (Class_556)this.var_1ab.elementAt(var6);
         if (var5.var_64.sub_236() == var2 && !var5.sub_2b() && !this.sub_4c0(var5)) {
            int var7 = var5.sub_157(var1);
            if (var4 == null) {
               var4 = var5;
               var3 = var7;
            } else if (var7 > var3) {
               var4 = var5;
               var3 = var7;
            }
         }
      }

      return var4;
   }

   public boolean sub_4c0(Class_556 var1) {
      int var2 = 0;

      for(int var4 = 0; var4 < this.var_1cd.size(); ++var4) {
         Class_3b0 var3 = (Class_3b0)this.var_1cd.elementAt(var4);
         Class_556 var5 = this.sub_554(var3.var_60, var3.var_bf);
         if (var5 == var1) {
            var2 += var3.var_1dd;
         }
      }

      if (var2 >= var1.var_22b) {
         return true;
      } else {
         return false;
      }
   }

   public Class_556 sub_4f0(int var1) {
      for(int var3 = 0; var3 < this.var_1ab.size(); ++var3) {
         Class_556 var2 = (Class_556)this.var_1ab.elementAt(var3);
         if (var2.var_64.sub_236() == var1 && var2.sub_2b()) {
            return var2;
         }
      }

      return null;
   }

   public Class_556 sub_554(int var1, int var2) {
      for(int var4 = 0; var4 < this.var_1ab.size(); ++var4) {
         Class_556 var3 = (Class_556)this.var_1ab.elementAt(var4);
         if (!var3.sub_2b() && var3.var_b6 < var1 && var3.var_f9 < var2 && var3.var_b6 + 32 > var1 && var3.var_f9 + 32 > var2) {
            return var3;
         }
      }

      return null;
   }

   public void sub_565(Class_556 var1, Class_556 var2, int var3) {
      if (var2 != null) {
         Class_3b0 var4 = new Class_3b0(var1.var_b6 + 16, var1.var_f9 + 16);
         var4.var_60 = var2.var_b6 + 16;
         var4.var_bf = var2.var_f9 + 16;
         var4.var_1dd = var1.var_64.sub_59e(var3);
         if (var4.var_1dd != 0) {
            var4.var_167 = (byte)var1.var_64.sub_3a5();
            int var5 = 1 + var4.var_1dd - var3 * GameScreen.gameScreen.var_11cd[var1.var_64.sub_3a5()];
            var5 -= var1.var_64.var_1ef * 30 * var5 / 100;
            if (var5 > 0) {
               var4.var_1dd -= Math.abs(this.var_4cc.nextInt() % var5);
            }

            int var6 = this.var_ab;
            if (var1.var_64.sub_236() == this.var_47) {
               var6 = this.var_fb;
            }

            var4.var_1dd += var4.var_1dd * var6 / 100;
            if (this.var_640) {
               if (var4.sub_222()) {
                  if (var1.var_157) {
                     var4.var_272 = this.var_5f2;
                  } else {
                     var4.var_272 = this.var_5ce;
                  }
               }

               if (var4.var_167 == 7 || var4.var_167 == 8) {
                  var4.var_272 = this.var_5fe;
               }
            }

            this.var_1cd.addElement(var4);
         }
      }
   }

   public void sub_573(int var1, int var2) {
      Class_3b0 var3 = new Class_3b0(var1, var2);
      var3.var_1dd = 0;
      this.var_223.addElement(var3);
      if (GameScreen.gameScreen.var_16d3) {
         Stars.thisStars.sub_111(500);
      }

   }

   public void sub_581(Graphics var1) {
      boolean var3 = false;
      boolean var4 = false;

      for(int var5 = 0; var5 < this.var_223.size(); ++var5) {
         Class_3b0 var2 = (Class_3b0)this.var_223.elementAt(var5);
         var1.setClip(var2.var_32, var2.var_49, 32, 32);
         int var6 = var2.var_1dd / 4;
         int var7;
         byte var8;
         if (var6 >= 3) {
            var7 = (var6 - 3) * 32;
            var8 = 32;
         } else {
            var7 = var6 * 32;
            var8 = 0;
         }

         var1.drawImage(this.var_5b8, var2.var_32 - var7, var2.var_49 - var8, 20);
         ++var2.var_1dd;
         if (var2.var_1dd / 4 >= 6) {
            this.var_223.removeElementAt(var5);
         }
      }

      var1.setClip(0, 0, GameScreen.gameScreen.getWidth(), GameScreen.gameScreen.getHeight());
   }

   public void sub_5b5() {
      for(int var2 = 0; var2 < this.var_1cd.size(); ++var2) {
         Class_3b0 var1 = (Class_3b0)this.var_1cd.elementAt(var2);
         if (var1.sub_2f()) {
            Class_556 var3 = this.sub_554(var1.var_60, var1.var_bf);
            if (var3 != null) {
               var3.sub_19d(var1.var_1dd);
               if (var3.var_64.var_195 >= 100) {
                  if (this.sub_1ba()) {
                     this.sub_573(var3.var_b6, var3.var_f9);
                  }

                  Class_556 var4 = this.sub_4f0(var3.var_64.sub_236());
                  if (var3.var_2e6) {
                     var4 = null;
                  }

                  if (var4 != null) {
                     var4.var_105 = var3.var_b6;
                     var4.var_111 = var3.var_f9;
                     var4.var_f9 = var3.var_f9;
                     if (var4.var_157) {
                        var4.var_b6 = var3.var_b6 - 32;
                     } else {
                        var4.var_b6 = var3.var_b6 + 32;
                     }
                  }

                  this.var_1ab.removeElement(var3);
                  if (!var3.var_2e6) {
                     GameScreen.gameScreen.sub_1601(var3.var_64);
                  }
               }
            }

            this.var_1cd.removeElementAt(var2);
         }
      }

   }

   public void sub_605(Graphics var1) {
      for(int var3 = 0; var3 < this.var_1cd.size(); ++var3) {
         Class_3b0 var2 = (Class_3b0)this.var_1cd.elementAt(var3);
         var2.sub_8c(var1);
      }

   }
}
