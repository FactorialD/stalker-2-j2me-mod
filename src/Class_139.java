public class Class_139 {
   public int var_4f;
   public int var_5f;
   public int var_bd;
   public int jobId;
   public int var_136 = 0;
   public int var_141;
   public int var_178;
   public int var_19d;
   public int var_1e2 = 0;
   public boolean var_204 = false;

   public Class_139(int var1) {
      this.var_4f = var1;
      this.var_5f = 0;
      this.var_bd = 0;
      this.jobId = 511;
      this.var_141 = 0;
      this.var_178 = 0;
      this.var_19d = 100 * SomeUtilClass.var_19.length / 2;
      this.sub_1e(3);
      this.sub_36(1);
      this.sub_4b(1);
      this.sub_92(1);
   }

   public void sub_1e(int var1) {
      int var2 = -16777216 & this.var_5f;
      this.var_5f ^= var2;
      this.var_5f |= var1 << 24;
   }

   public void sub_36(int var1) {
      int var2 = 16711680 & this.var_5f;
      this.var_5f ^= var2;
      this.var_5f |= var1 << 16;
   }

   public void sub_4b(int var1) {
      int var2 = '\uff00' & this.var_5f;
      this.var_5f ^= var2;
      this.var_5f |= var1 << 8;
   }

   public void sub_92(int var1) {
      int var2 = 255 & this.var_5f;
      this.var_5f ^= var2;
      this.var_5f |= var1;
   }

   public void sub_cd(int var1) {
      int var2 = 1 << var1;
      this.var_bd |= var2;
   }

   public boolean sub_e3(int var1) {
      int var2 = 1 << var1;
      return (this.var_bd & var2) != 0;
   }

   public int sub_125() {
      int var1 = 0;

      for(int var2 = 0; var2 < 31; ++var2) {
         if (this.sub_e3(var2)) {
            ++var1;
         }
      }

      return var1;
   }

   public void sub_12f(int var1) {
      int var2 = 1 << var1;
      this.var_136 |= var2;
   }

   public boolean sub_15b(int var1) {
      int var2 = 1 << var1;
      return (this.var_136 & var2) != 0;
   }

   public boolean sub_184() {
      return this.var_136 != 0;
   }

   public void sub_190() {
      if (this.sub_341() > 0) {
         this.sub_36(this.sub_249() + 1);
      } else if (this.sub_27d() > 0) {
         this.sub_4b(this.sub_27d() - 1);
         this.sub_36(this.sub_249() + 1);
      } else if (this.sub_28a() > 0) {
         this.sub_92(this.sub_28a() - 1);
         this.sub_36(this.sub_249() + 1);
      }

   }

   public void sub_1a0() {
      if (this.sub_341() > 0) {
         this.sub_4b(this.sub_27d() + 1);
      } else if (this.sub_28a() > 0) {
         this.sub_92(this.sub_28a() - 1);
         this.sub_4b(this.sub_27d() + 1);
      } else if (this.sub_249() > 0) {
         this.sub_36(this.sub_249() - 1);
         this.sub_4b(this.sub_27d() + 1);
      }

   }

   public void sub_1ca() {
      if (this.sub_341() > 0) {
         this.sub_92(this.sub_28a() + 1);
      } else if (this.sub_27d() > 0) {
         this.sub_4b(this.sub_27d() - 1);
         this.sub_92(this.sub_28a() + 1);
      } else if (this.sub_249() > 0) {
         this.sub_36(this.sub_249() - 1);
         this.sub_92(this.sub_28a() + 1);
      }

   }

   public void sub_208() {
      this.sub_1e(this.getCurrentPopulation() - 1);
      if (this.sub_341() < 0) {
         if (this.sub_28a() > 0) {
            this.sub_92(this.sub_28a() - 1);
         } else if (this.sub_27d() > 0) {
            this.sub_4b(this.sub_27d() - 1);
         } else if (this.sub_249() > 0) {
            this.sub_36(this.sub_249() - 1);
         }
      }

      this.var_19d -= 200;
   }

   public int sub_249() {
      return this.var_5f >> 16 & 255;
   }

   public int sub_27d() {
      return this.var_5f >> 8 & 255;
   }

   public int sub_28a() {
      return this.var_5f & 255;
   }

   public int getCurrentPopulation() {
      return this.var_5f >> 24 & 255;
   }

   public int sub_341() {
      return this.getCurrentPopulation() - this.sub_27d() - this.sub_28a() - this.sub_249();
   }

   public String getJobName() {
      if (this.jobId == 255) {
         return SomeUtilClass.getStr("ХАБАР");
      } else if (this.jobId == 511) {
         return SomeUtilClass.getStr("ТОРГОВЛЯ");
      } else if (this.jobId == 767) {
         return SomeUtilClass.getStr("ОТРЯД");
      } else if (this.jobId >= 4095) {
         return GameScreen.gameScreen.var_d5c.projectsArr[this.jobId - 4095].projectName;
      } else {
         return this.jobId < 255 ? GameScreen.gameScreen.buildingDictArr[this.jobId].var_68 : "NULL";
      }
   }

   public int sub_385() {
      int var1 = 7 - this.getCurrentPopulation();
      if (this.sub_e3(1)) {
         --var1;
      }

      if (this.sub_e3(7)) {
         --var1;
      }

      if (this.sub_e3(12)) {
         --var1;
      }

      int var2 = 0;
      if (this.jobId == 767) {
         var2 = 100 - this.var_178;
      }

      if (this.jobId >= 4095) {
         var2 = GameScreen.gameScreen.var_d5c.projectsArr[this.jobId - 4095].sub_601(this.var_4f) - this.var_178;
      }

      if (this.jobId < 255) {
         var2 = GameScreen.gameScreen.buildingDictArr[this.jobId].var_175 - this.var_178;
      }

      if (var1 <= 0) {
         var1 = 1;
      }

      return var2 * var1;
   }

   public void sub_3b5() {
      int var1 = this.sub_385();
      Class_2a9 var10000 = GameScreen.gameScreen.sub_122a(this.var_4f);
      var10000.var_f6 -= var1;
      this.var_178 += var1;
   }

   public int sub_402(int var1, int var2) {
      int var3 = 0;
      if (var2 == 0) {
         return 999;
      } else if (var1 != 255 && var1 != 511) {
         if (var1 == 767) {
            var3 = (100 - this.var_178) / var2;
         }

         if (var1 >= 4095) {
            var3 = (GameScreen.gameScreen.var_d5c.projectsArr[var1 - 4095].sub_601(this.var_4f) - this.var_178) / var2;
         }

         if (var1 < 255) {
            var3 = (GameScreen.gameScreen.buildingDictArr[var1].var_175 - this.var_178) / var2;
         }

         if (var3 < 0) {
            var3 = 1;
         } else {
            ++var3;
         }

         if (var3 > 999) {
            var3 = 999;
         }

         return var3;
      } else {
         return 0;
      }
   }

   public int sub_42e() {
      return GameScreen.gameScreen.sub_1797(this.var_4f, 7) ? 0 : this.getCurrentPopulation();
   }

   public int sub_483() {
      if (this.var_19d <= 300) {
         return 2;
      } else {
         return this.var_19d >= 900 ? 0 : 1;
      }
   }
}
