public class Class_556 {
   public Class_4f2 var_64;
   public int var_b6 = 0;
   public int var_f9 = 0;
   public int var_105 = 0;
   public int var_111 = 0;
   public boolean var_157;
   public int var_198 = 0;
   public int var_22b = 0;
   public int var_28d = 0;
   public int var_2d0 = 0;
   public boolean var_2e6 = false;

   public Class_556(Class_4f2 var1) {
      this.var_64 = var1;
      this.var_22b = this.var_64.sub_53b();
      Planet var2 = GameScreen.gameScreen.sub_76d(this.var_64.sub_309(), this.var_64.sub_31a());
      if (var2 != null && var2.var_1df != null && var2.var_1df.var_4f == this.var_64.sub_236() && var2.var_1df.sub_15b(5)) {
         this.var_22b *= 2;
      }

      this.var_28d = this.var_22b;
      this.var_22b = this.var_22b * (100 - this.var_64.var_195) / 100;
   }

   public boolean sub_2b() {
      return this.var_b6 == 0 && this.var_f9 == 0;
   }

   public boolean sub_51() {
      if (this.var_198 <= 0 && this.var_105 == this.var_b6) {
         return true;
      } else {
         --this.var_198;
         return false;
      }
   }

   public void sub_80() {
      this.var_198 = 60 - GameScreen.gameScreen.var_1116[this.var_64.sub_18d(24)].someInt3;
   }

   public void sub_9f() {
      this.var_105 = this.var_b6;
      this.var_111 = this.var_f9;
   }

   public void sub_c6() {
      if (!this.var_2e6) {
         if (this.var_105 != this.var_b6) {
            if (this.var_105 > this.var_b6) {
               ++this.var_b6;
            } else {
               --this.var_b6;
            }
         }

      }
   }

   public int sub_112(Class_556 var1) {
      return SomeUtilClass.sub_2ed((this.var_b6 - var1.var_b6) * (this.var_b6 - var1.var_b6) + (this.var_f9 - var1.var_f9) * (this.var_f9 - var1.var_f9));
   }

   public int sub_157(Class_556 var1) {
      return this.var_64.sub_582() - this.sub_112(var1);
   }

   public void sub_19d(int var1) {
      this.var_22b -= var1;
      if (this.var_22b < 0) {
         this.var_22b = 0;
      }

      if (this.var_28d == 0) {
         this.var_64.var_195 = 100;
      } else {
         this.var_64.var_195 = (byte)((this.var_28d - this.var_22b) * 100 / this.var_28d);
      }
   }

   public int sub_1ee(Class_556 var1) {
      int var2 = GameScreen.gameScreen.var_11cd[this.var_64.sub_3a5()];
      if (var2 == 0) {
         return var1.var_22b / 1;
      } else {
         int var3 = var1.var_22b / var2;
         if (var3 <= 0) {
            var3 = 1;
         }

         return var3;
      }
   }
}
