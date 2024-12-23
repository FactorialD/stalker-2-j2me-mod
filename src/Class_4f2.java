import javax.microedition.lcdui.Graphics;

public class Class_4f2 extends Project {
   public int var_3e;
   public int var_6e;
   public int var_cb;
   public int var_15d;
   public byte var_195;
   public byte var_1ef;
   public byte var_21d;
   private int var_253;
   public boolean var_261;
   public boolean var_27d;
   public boolean var_2d9;

   public Class_4f2(int var1, int var2, Project var3, int var4, int var5) {
      this.var_195 = 0;
      this.var_1ef = 0;
      this.var_21d = 0;
      this.var_3e = var1 | var2 << 8;
      super.var_8a = var3.var_8a;
      super.projectName = "";
      this.sub_16d(var3.projectName);
      super.var_65 = var3.var_65;
      this.sub_2c4(var4, var5);
      this.var_cb = this.var_6e;
      this.var_253 = 0;
      this.var_261 = false;
      this.var_27d = false;
      this.var_2d9 = false;
   }

   public Class_4f2() {
      this.var_253 = 0;
      this.var_261 = false;
      this.var_27d = false;
      this.var_2d9 = false;
      super.projectName = "";
   }

   public void sub_3c(int var1) {
      if (this.var_1ef < 4) {
         int var2 = var1 - this.sub_18d(28) + 1;
         if (var2 > 0) {
            var2 *= var2;
            this.var_21d = (byte)(this.var_21d + var2);
            if (this.var_21d >= 2) {
               ++this.var_1ef;
               this.var_21d = 0;
            }

         }
      }
   }

   public void sub_f0() {
      this.var_195 = (byte)(this.var_195 - 20);
      if (this.var_195 < 0) {
         this.var_195 = 0;
      }

   }

   public void sub_12d(int var1) {
      this.var_3e = var1 | this.sub_264() << 8;
   }

   public void sub_16d(String var1) {
      this.var_15d = GameScreen.gameScreen.sub_18f9(var1);
      if (this.var_15d == -1) {
         this.var_15d = GameScreen.gameScreen.sub_1941(var1);
      }

   }

   public String sub_1af() {
      return this.var_15d >= 0 && this.var_15d < GameScreen.gameScreen.var_dc6.size() ? (String)GameScreen.gameScreen.var_dc6.elementAt(this.var_15d) : "XS";
   }

   public int sub_1f2() {
      return this.var_253;
   }

   public void sub_20e(int var1) {
      this.var_253 = var1;
   }

   public int sub_236() {
      return this.var_3e & 255;
   }

   public int sub_264() {
      return this.var_3e >> 8;
   }

   public void sub_2c4(int var1, int var2) {
      this.var_6e = var1 | var2 << 16;
   }

   public void sub_2d0(int var1, int var2) {
      this.var_cb = var1 | var2 << 16;
   }

   public int sub_309() {
      return this.var_6e & '\uffff';
   }

   public int sub_31a() {
      return this.var_6e >> 16;
   }

   public int sub_362() {
      return this.var_cb & '\uffff';
   }

   public int sub_3a1() {
      return this.var_cb >> 16;
   }

   public int sub_3eb() {
      return (this.var_6e & '\uffff') * 20;
   }

   public int sub_445() {
      return (this.var_6e >> 16) * 20;
   }

   public void sub_499(Graphics var1, int var2, int var3, int var4) {
      var1.setColor(var4);
      var1.drawLine(var2 + 1, var3 + 1, var2 + 4, var3 + 1);
      var4 = sub_53d(var4);
      var1.setColor(var4);
      var1.drawLine(var2 + 1, var3, var2 + 2, var3);
      var1.drawLine(var2 + 1, var3 + 2, var2 + 2, var3 + 2);
      var1.drawLine(var2 + 4, var3 + 1, var2 + 5, var3 + 1);
      var4 = sub_53d(var4);
      var1.setColor(var4);
      var1.drawLine(var2, var3 + 2, var2, var3 + 2);
   }

   public void sub_4dc(Graphics var1, int var2, int var3, int var4, int var5, int var6) {
      var6 >>= 3;
      int var7 = var2;
      int var8 = var3;

      while(var7 != var4 && var8 != var5) {
         int var9 = var4 - var2;
         int var10 = var5 - var3;
         if (var2 == var4) {
            if (var5 > var3) {
               ++var8;
            }

            if (var5 < var3) {
               --var8;
            }
         }

         if (var3 == var5) {
            if (var4 > var2) {
               ++var7;
            }

            if (var4 < var2) {
               --var7;
            }
         }

         if (var9 != 0 && var10 != 0) {
            if (Math.abs(var9) > Math.abs(var10)) {
               if (var4 > var2) {
                  ++var7;
               }

               if (var4 < var2) {
                  --var7;
               }

               var8 = var3 + var10 * (var7 - var2) / var9;
            } else {
               if (var5 > var3) {
                  ++var8;
               }

               if (var5 < var3) {
                  --var8;
               }

               var7 = var2 + var9 * (var8 - var3) / var10;
            }
         }

         var1.setColor(this.sub_528(var6));
         var1.drawLine(var7, var8, var7, var8);
         --var6;
         if (var6 < 0) {
            var6 = 5;
         }
      }

   }

   public int sub_528(int var1) {
      switch(var1) {
      case 0:
      case 1:
         return 65280;
      case 2:
      case 3:
         return 1751296;
      case 4:
      case 5:
         return 1144576;
      default:
         return 0;
      }
   }

   public static int sub_53d(int var0) {
      int var1 = var0 >> 16 & 255;
      int var2 = var0 >> 8 & 255;
      int var3 = var0 & 255;
      if (var1 > var2 && var1 > var3) {
         var1 -= 50;
         var2 -= 20;
         var3 -= 20;
      } else if (var2 > var1 && var2 > var3) {
         var2 -= 50;
         var1 -= 20;
         var3 -= 20;
      } else if (var3 > var1 && var3 > var2) {
         var3 -= 50;
         var1 -= 20;
         var2 -= 20;
      }

      if (var1 < 0) {
         var1 = 0;
      }

      if (var2 < 0) {
         var2 = 0;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      return var1 << 16 | var2 << 8 | var3;
   }

   public boolean sub_599() {
      return this.sub_309() != this.sub_362() || this.sub_31a() != this.sub_3a1();
   }

   public void sub_5d2() {
      if (this.sub_599()) {
         int var1 = this.sub_309();
         int var2 = this.sub_31a();
         int var3 = this.sub_362() - this.sub_309();
         int var4 = this.sub_3a1() - this.sub_31a();
         int var5 = GameScreen.gameScreen.sub_145e(this.sub_1f2());
         if (GameScreen.gameScreen.sub_1778(this, this.sub_362(), this.sub_3a1())) {
            var5 = 1;
         }

         if (var3 == 0) {
            if (Math.abs(var4) < var5) {
               var5 = Math.abs(var4);
            }

            if (var4 > 0) {
               var2 += var5;
            }

            if (var4 < 0) {
               var2 -= var5;
            }

            this.sub_2c4(var1, var2);
         } else if (var4 == 0) {
            if (Math.abs(var3) < var5) {
               var5 = Math.abs(var3);
            }

            if (var3 > 0) {
               var1 += var5;
            }

            if (var3 < 0) {
               var1 -= var5;
            }

            this.sub_2c4(var1, var2);
         } else {
            if (Math.abs(var3) > Math.abs(var4)) {
               if (Math.abs(var3) < var5) {
                  var5 = Math.abs(var3);
               }

               if (var3 > 0) {
                  var1 += var5;
               }

               if (var3 < 0) {
                  var1 -= var5;
               }

               var2 += var4 * (var1 - this.sub_309()) / var3;
            } else {
               if (Math.abs(var4) < var5) {
                  var5 = Math.abs(var4);
               }

               if (var4 > 0) {
                  var2 += var5;
               }

               if (var4 < 0) {
                  var2 -= var5;
               }

               var1 += var3 * (var2 - this.sub_31a()) / var4;
            }

            this.sub_2c4(var1, var2);
         }
      }
   }

   public boolean sub_613() {
      return this.sub_18d(28) == 5;
   }

   public String sub_64d() {
      return SomeUtilClass.getStr("А:") + this.sub_582() + " " + SomeUtilClass.getStr("З:") + this.sub_53b() + " " + SomeUtilClass.getStr("С:") + this.sub_530();
   }

   public void sub_6ac(Graphics var1, int var2, int var3, int var4) {
      int var6 = var3 + 12;
      GameScreen.gameScreen.sub_fcf(var1, var2 + 7, var6, SomeUtilClass.getStr("РАНГ") + ":", GameScreen.gameScreen.rMiniFrontImg);
      int var7 = var2 + var4 - GameScreen.gameScreen.var_1058[this.sub_18d(28)].someStr.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var7, var6, GameScreen.gameScreen.var_1058[this.sub_18d(28)].someStr, GameScreen.gameScreen.rMiniFront2Img);
      var6 += 8;
      String var5 = this.sub_18d(12) + "-" + GameScreen.gameScreen.var_1095[this.sub_18d(20)].someStr;
      var7 = var2 + var4 - var5.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var7, var6, var5, GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, var2 + 7, var6, SomeUtilClass.getStr("ВЫНОСЛИВОСТЬ") + ":", GameScreen.gameScreen.rMiniFrontImg);
      var6 += 8;
      var5 = this.sub_18d(0) + "-" + GameScreen.gameScreen.var_10d4[this.sub_18d(8)].someStr;
      var7 = var2 + var4 - var5.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var7, var6, var5, GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, var2 + 7, var6, SomeUtilClass.getStr("БРОНЯ") + ":", GameScreen.gameScreen.rMiniFrontImg);
      var6 += 8;
      var5 = GameScreen.gameScreen.var_1116[this.sub_18d(24)].someStr;
      var7 = var2 + var4 - var5.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var7, var6, var5, GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, var2 + 7, var6, SomeUtilClass.getStr("БОЕПРИПАСЫ") + ":", GameScreen.gameScreen.rMiniFrontImg);
      var6 += 8;
      var5 = this.sub_400() + "-" + GameScreen.gameScreen.var_1171[this.sub_3a5()].someStr;
      var7 = var2 + var4 - var5.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var7, var6, var5, GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, var2 + 7, var6, SomeUtilClass.getStr("ОРУЖИЕ") + ":", GameScreen.gameScreen.rMiniFrontImg);
      var6 += 8;
   }

   public int sub_6df() {
      int var1 = this.sub_601(this.sub_236());
      var1 = var1 * (100 - this.var_195) / 100;
      Planet var2 = GameScreen.gameScreen.sub_76d(this.sub_309(), this.sub_31a());
      if (var2 != null && var2.var_1df != null && var2.var_1df.var_4f == this.sub_236()) {
         return var1;
      } else {
         var1 /= 10;
         return var1;
      }
   }

   public boolean sub_6f2(Class_4f2 var1) {
      if (this.sub_18d(28) != var1.sub_18d(28)) {
         return false;
      } else if (var1.sub_264() == this.sub_264()) {
         return false;
      } else if (var1.sub_236() != this.sub_236()) {
         return false;
      } else {
         return var1.var_6e == this.var_6e;
      }
   }

   public void sub_73f(Class_4f2 var1) {
      byte var2 = this.var_1ef;
      this.var_1ef = var1.var_1ef;
      var1.var_1ef = var2;
   }

   public boolean sub_78d(int var1, int var2, int var3) {
      return this.sub_309() > var1 - var3 && this.sub_309() < var1 + var3 && this.sub_31a() > var2 - var3 && this.sub_31a() < var2 + var3;
   }
}
