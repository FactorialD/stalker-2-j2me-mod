import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Class_3b0 {
   public int var_32;
   public int var_49;
   public int var_60;
   public int var_bf;
   public int var_d9;
   public int var_137;
   public byte var_167;
   public int var_1dd;
   public int var_23f;
   public Image var_272 = null;
   public Random var_2cd = null;

   public Class_3b0(int var1, int var2) {
      this.var_32 = var1;
      this.var_49 = var2;
      this.var_d9 = this.var_32;
      this.var_137 = this.var_49;
      this.var_23f = 0;
   }

   public boolean sub_2f() {
      return this.sub_66(GameScreen.gameScreen.var_1185[this.var_167]);
   }

   public boolean sub_66(int var1) {
      if (this.var_d9 == this.var_60 && this.var_137 == this.var_bf) {
         return true;
      } else if (this.var_d9 == this.var_60) {
         if (Math.abs(this.var_137 - this.var_bf) < var1) {
            var1 = Math.abs(this.var_137 - this.var_bf);
         }

         if (this.var_bf > this.var_137) {
            this.var_137 += var1;
         }

         if (this.var_bf < this.var_137) {
            this.var_137 -= var1;
         }

         return false;
      } else if (this.var_137 == this.var_bf) {
         if (Math.abs(this.var_d9 - this.var_60) < var1) {
            var1 = Math.abs(this.var_d9 - this.var_60);
         }

         if (this.var_60 > this.var_d9) {
            this.var_d9 += var1;
         }

         if (this.var_60 < this.var_d9) {
            this.var_d9 -= var1;
         }

         return false;
      } else {
         if (Math.abs(this.var_d9 - this.var_60) > Math.abs(this.var_137 - this.var_bf)) {
            if (Math.abs(this.var_d9 - this.var_60) < var1) {
               var1 = Math.abs(this.var_d9 - this.var_60);
            }

            if (this.var_60 > this.var_d9) {
               this.var_d9 += var1;
            }

            if (this.var_60 < this.var_d9) {
               this.var_d9 -= var1;
            }

            this.var_137 = this.var_49 + (this.var_bf - this.var_49) * (this.var_d9 - this.var_32) / (this.var_60 - this.var_32);
         } else {
            if (Math.abs(this.var_137 - this.var_bf) < var1) {
               var1 = Math.abs(this.var_137 - this.var_bf);
            }

            if (this.var_bf > this.var_137) {
               this.var_137 += var1;
            }

            if (this.var_bf < this.var_137) {
               this.var_137 -= var1;
            }

            this.var_d9 = this.var_32 + (this.var_60 - this.var_32) * (this.var_137 - this.var_49) / (this.var_bf - this.var_49);
         }

         return false;
      }
   }

   public void sub_8c(Graphics var1) {
      if (this.sub_222()) {
         this.sub_f7(var1);
      } else {
         switch(this.var_167) {
         case 0:
            this.sub_99(var1, 16749591, false, 10);
            break;
         case 1:
            this.sub_99(var1, 16749591, true, 10);
            break;
         case 2:
         case 5:
         case 10:
         case 11:
         default:
            var1.setColor(255, 0, 0);
            var1.drawLine(this.var_d9, this.var_137, this.var_d9, this.var_137);
            break;
         case 3:
            this.sub_99(var1, 4617983, false, 10);
            break;
         case 4:
            this.sub_99(var1, 4617983, true, 10);
            break;
         case 6:
            this.sub_13f(var1);
            break;
         case 7:
         case 8:
            this.sub_174(var1);
            break;
         case 9:
            this.sub_99(var1, 7995554, true, 30);
            break;
         case 12:
            this.sub_1be(var1, 19302);
            break;
         case 13:
            this.sub_1be(var1, 16731906);
         }

      }
   }

   public void sub_99(Graphics var1, int var2, boolean var3, int var4) {
      int var9 = var4 + this.var_1dd;
      if (var9 > 40) {
         var9 = 40;
      }

      if (this.var_23f < var9) {
         ++this.var_23f;
      }

      int var5 = this.var_d9;
      int var6 = this.var_137;

      for(int var10 = 0; var10 < this.var_23f / 3; ++var10) {
         int var7 = this.var_d9;
         int var8 = this.var_137;
         this.sub_66(3);
         var1.setColor(SomeUtilClass.sub_28f(var2, (this.var_23f / 3 - var10) * 10));
         var1.drawLine(var7, var8, this.var_d9, this.var_137);
         if (var3) {
            var1.setColor(SomeUtilClass.sub_28f(var2, (this.var_23f / 3 - var10) * 20));
            var1.drawLine(var7, var8 + 1, this.var_d9, this.var_137 + 1);
         }
      }

      this.var_d9 = var5;
      this.var_137 = var6;
   }

   public void sub_f7(Graphics var1) {
      if (this.var_272 != null) {
         var1.drawImage(this.var_272, this.var_d9, this.var_137 - 1, 20);
      }
   }

   public void sub_13f(Graphics var1) {
      var1.setColor(38404);
      var1.drawLine(this.var_d9 - 1, this.var_137 - 1, this.var_d9 + 1, this.var_137 - 1);
      var1.drawLine(this.var_d9 - 1, this.var_137 + 1, this.var_d9 + 1, this.var_137 + 1);
      var1.setColor(59910);
      var1.drawLine(this.var_d9, this.var_137 - 1, this.var_d9, this.var_137 + 1);
      var1.setColor(49413);
      var1.drawLine(this.var_d9, this.var_137, this.var_d9, this.var_137);
      if (this.var_32 < this.var_60) {
         var1.setColor(65286);
         var1.drawLine(this.var_d9 + 1, this.var_137, this.var_d9 + 1, this.var_137);
         var1.setColor(261);
         var1.drawLine(this.var_d9 - 1, this.var_137, this.var_d9 - 1, this.var_137);
      } else {
         var1.setColor(65286);
         var1.drawLine(this.var_d9 - 1, this.var_137, this.var_d9 - 1, this.var_137);
         var1.setColor(261);
         var1.drawLine(this.var_d9 + 1, this.var_137, this.var_d9 + 1, this.var_137);
      }

   }

   public void sub_174(Graphics var1) {
      var1.setClip(this.var_d9 - 10, this.var_137 - 10, 20, 20);
      var1.drawImage(this.var_272, this.var_d9 - 10 - this.var_23f / 3 * 20, this.var_137 - 10, 20);
      ++this.var_23f;
      if (this.var_23f / 3 >= 3) {
         this.var_23f = 0;
      }

      var1.setClip(0, 0, GameScreen.gameScreen.getWidth(), GameScreen.gameScreen.getHeight());
   }

   public void sub_1be(Graphics var1, int var2) {
      if (this.var_2cd == null) {
         this.var_2cd = new Random();
      }

      int var3 = this.var_d9;
      int var4 = this.var_137;
      this.var_d9 = this.var_32;
      this.var_137 = this.var_49;

      while(!this.sub_66(1)) {
         for(int var5 = -2; var5 < 2; ++var5) {
            if (Math.abs(this.var_2cd.nextInt() % 2) == 0) {
               int var6 = SomeUtilClass.sub_28f(var2, this.var_2cd.nextInt() % 50);
               if (var5 == -2 || var5 == 1) {
                  var6 = SomeUtilClass.sub_28f(var2, 40);
               }

               var1.setColor(var6);
               var1.drawLine(this.var_d9, this.var_137 + var5, this.var_d9, this.var_137 + var5);
            }
         }

         if (this.var_d9 == var3 && this.var_137 == var4) {
            break;
         }
      }

      this.var_d9 = var3;
      this.var_137 = var4;
   }

   public boolean sub_222() {
      return this.var_167 == 2 || this.var_167 == 5 || this.var_167 == 9 || this.var_167 == 11;
   }
}
