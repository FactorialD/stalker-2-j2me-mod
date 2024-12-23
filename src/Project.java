import javax.microedition.lcdui.Graphics;

public class Project { //как минимум это проект корабля, а может и сам корабль
   public int var_2a = 0;
   public String projectName = "STALKER";
   public int var_65;
   public int var_8a;

   public Project() {
      this.sub_1d7(28, 1);
   }

   public void sub_62(int var1) {
      int var2 = 1 << var1;
      this.var_2a |= var2;
   }

   public boolean sub_c6(int var1) {
      int var2 = 1 << var1;
      return (this.var_2a & var2) != 0;
   }

   public boolean sub_105() {
      return this.var_2a != 0;
   }

   public void sub_112(int var1) {
      switch(var1) {
      case 0:
         this.projectName = SomeUtilClass.getStr("ТОЛИК");
         this.var_8a = 4097;
         this.var_65 = 1;
         break;
      case 1:
         this.projectName = SomeUtilClass.getStr("ВОЛК");
         this.var_8a = 268443650;
         this.var_65 = 7;
         break;
      case 2:
         this.projectName = SomeUtilClass.getStr("ШУСТРЫЙ");
         this.var_8a = 536883203;
         this.var_65 = 17;
         break;
      case 3:
         this.projectName = SomeUtilClass.getStr("МЕЧЕНЫЙ");
         this.var_8a = 805330947;
         this.var_65 = 35;
         break;
      case 4:
         this.projectName = SomeUtilClass.getStr("ДЕГТЯРЕВ");
         this.var_8a = 805330946;
         this.var_65 = 131089;
      }

   }

   public void sub_14c(Class_2a9 var1) {
      this.var_65 = 0;
      this.var_8a = 0;
      this.projectName = SomeUtilClass.getStr("ОТРЯД");
      this.sub_1d7(28, 5);
      this.sub_1d7(20, var1.sub_16d());
      this.sub_1d7(12, 1);
   }

   public int sub_18d(int var1) {
      short var2 = 15;
      if (var1 == 0 || var1 == 12) {
         var2 = 255;
      }

      return this.var_8a >> var1 & var2;
   }

   public void sub_1d7(int var1, int var2) {
      short var3 = 15;
      if (var1 == 0 || var1 == 12) {
         var3 = 255;
      }

      this.var_8a &= ~(var3 << var1);
      this.var_8a |= var2 << var1;
   }

   public void sub_234() {
      int var1 = this.sub_18d(12);
      if (var1 < 99) {
         this.sub_1d7(12, var1 + 1);
      }

   }

   public void sub_276() {
      int var1 = this.sub_18d(0);
      if (var1 < 99) {
         this.sub_1d7(0, var1 + 1);
      }

   }

   public void sub_2bd() {
      int var1 = this.sub_400();
      if (var1 < 99) {
         this.sub_449(this.sub_3a5(), var1 + 1);
      }

   }

   public void sub_2e8() {
      int var1 = this.sub_18d(12);
      if (var1 > 1) {
         this.sub_1d7(12, var1 - 1);
      }

   }

   public void sub_33d() {
      int var1 = this.sub_18d(0);
      if (var1 > 1) {
         this.sub_1d7(0, var1 - 1);
      }

   }

   public void sub_35a() {
      int var1 = this.sub_400();
      if (var1 > 1) {
         this.sub_449(this.sub_3a5(), var1 - 1);
      }

   }

   public int sub_3a5() {
      return this.var_65 >> 16;
   }

   public int sub_400() {
      return this.var_65 & '\uffff';
   }

   public void sub_449(int var1, int var2) {
      this.var_65 = var1 << 16 | var2;
   }

   public int sub_492() {
      int var1 = GameScreen.gameScreen.var_1058[this.sub_18d(28)].someInt1 / 100;
      if (var1 <= 0) {
         var1 = 1;
      }

      int var2 = GameScreen.gameScreen.var_1095[this.sub_18d(20)].someInt1 * this.sub_18d(12);
      var2 += GameScreen.gameScreen.var_10d4[this.sub_18d(8)].someInt1 * this.sub_18d(0) * var1;
      var2 += GameScreen.gameScreen.var_1116[this.sub_18d(24)].someInt1;
      var2 += GameScreen.gameScreen.var_1171[this.sub_3a5()].someInt1 * this.sub_400();
      return var2;
   }

   public int sub_4d4() {
      return GameScreen.gameScreen.var_1058[this.sub_18d(28)].someInt1 - this.sub_492();
   }

   public int sub_530() {
      if (this.sub_4d4() < 0) {
         return 0;
      } else if (this.sub_18d(28) == 5) {
         return GameScreen.gameScreen.var_1095[this.sub_18d(20)].someInt3;
      } else {
         int var1 = GameScreen.gameScreen.var_1095[this.sub_18d(20)].someInt3 * this.sub_18d(12) * 100 / this.sub_492();
         if (this.sub_c6(2)) {
            var1 *= 4;
         }

         return var1;
      }
   }

   public int sub_53b() {
      if (this.sub_4d4() < 0) {
         return 0;
      } else {
         int var1 = GameScreen.gameScreen.var_1058[this.sub_18d(28)].someInt1 / 100;
         if (var1 <= 0) {
            var1 = 1;
         }

         int var2 = GameScreen.gameScreen.var_10d4[this.sub_18d(8)].someInt3 * this.sub_18d(0) * var1;
         if (this.sub_c6(3)) {
            var2 *= 4;
         }

         return var2;
      }
   }

   public int sub_582() {
      return this.sub_4d4() < 0 ? 0 : this.sub_59e(this.sub_400());
   }

   public int sub_59e(int var1) {
      if (this.sub_4d4() < 0) {
         return 0;
      } else {
         int var2 = GameScreen.gameScreen.var_1171[this.sub_3a5()].someInt3 * var1;
         if (this.sub_c6(8)) {
            var2 *= 4;
         }

         return var2;
      }
   }

   public int sub_601(int var1) {
      int var2 = GameScreen.gameScreen.var_1058[this.sub_18d(28)].someInt1 / 100;
      int var3 = GameScreen.gameScreen.var_1095[this.sub_18d(20)].someInt2 * this.sub_18d(12);
      var3 += GameScreen.gameScreen.var_10d4[this.sub_18d(8)].someInt2 * this.sub_18d(0) * var2;
      var3 += GameScreen.gameScreen.var_1116[this.sub_18d(24)].someInt2;
      var3 += GameScreen.gameScreen.var_1171[this.sub_3a5()].someInt2 * this.sub_400();
      var3 += GameScreen.gameScreen.var_1058[this.sub_18d(28)].someInt2;
      if (GameScreen.gameScreen.sub_1797(var1, 2)) {
         var3 -= var3 / 4;
      }

      return var3;
   }

   public void sub_62f(Graphics var1, int var2, int var3, int var4, int var5) {
      GameScreen var10001;
      int var6;
      if (this.sub_4d4() < 0) {
         var6 = var3 + 5;
         int var10002 = SomeUtilClass.getStr("НЕВОЗМОЖНО").length();
         GameScreen var10003 = GameScreen.gameScreen;
         int var7 = var2 + (var4 - var10002 * 5) / 2;
         GameScreen.gameScreen.sub_fcf(var1, var7, var6, SomeUtilClass.getStr("НЕВОЗМОЖНО"), GameScreen.gameScreen.rMiniFront2Img);
         var10001 = GameScreen.gameScreen;
         var6 += 5 + 3;
         var10002 = SomeUtilClass.getStr("ПРОЕКТ").length();
         var10003 = GameScreen.gameScreen;
         var7 = var2 + (var4 - var10002 * 5) / 2;
         GameScreen.gameScreen.sub_fcf(var1, var7, var6, SomeUtilClass.getStr("ПРОЕКТ"), GameScreen.gameScreen.rMiniFront2Img);
         var10001 = GameScreen.gameScreen;
         var6 += 5 + 3;
      } else {
         GameScreen.gameScreen.sub_fcf(var1, var2, var3, SomeUtilClass.getStr("ВЫНОСЛИВОСТЬ") + ":", GameScreen.gameScreen.rMiniFront2Img);
         GameScreen.gameScreen.sub_fcf(var1, var2 + 50, var3, "" + this.sub_530(), GameScreen.gameScreen.rMiniFront2Img);
         var10001 = GameScreen.gameScreen;
         var6 = var3 + 5 + 3;
         GameScreen.gameScreen.sub_fcf(var1, var2, var6, SomeUtilClass.getStr("АТАКА") + ":", GameScreen.gameScreen.rMiniFront2Img);
         GameScreen.gameScreen.sub_fcf(var1, var2 + 50, var6, "" + this.sub_582(), GameScreen.gameScreen.rMiniFront2Img);
         var10001 = GameScreen.gameScreen;
         var6 += 5 + 3;
         GameScreen.gameScreen.sub_fcf(var1, var2, var6, SomeUtilClass.getStr("ЗАЩИТА") + ":", GameScreen.gameScreen.rMiniFront2Img);
         GameScreen.gameScreen.sub_fcf(var1, var2 + 50, var6, "" + this.sub_53b(), GameScreen.gameScreen.rMiniFront2Img);
         var10001 = GameScreen.gameScreen;
         var6 += 5 + 3;
      }

   }

   public void sub_66a(Graphics var1, int var2, int var3, int var4, int var5) {
      int var7 = var3 + 8 + 2;
      int var8 = var2 + var4 - this.projectName.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var8, var7, this.projectName, GameScreen.gameScreen.rMiniFront2Img);
      var7 += 10;
      var8 = var2 + var4 - GameScreen.gameScreen.var_1058[this.sub_18d(28)].someStr.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var8, var7, GameScreen.gameScreen.var_1058[this.sub_18d(28)].someStr, GameScreen.gameScreen.rMiniFront2Img);
      var7 += 10;
      String var6 = this.sub_18d(12) + "-" + GameScreen.gameScreen.var_1095[this.sub_18d(20)].someStr;
      var8 = var2 + var4 - var6.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var8, var7, var6, GameScreen.gameScreen.rMiniFront2Img);
      var7 += 10;
      var6 = this.sub_18d(0) + "-" + GameScreen.gameScreen.var_10d4[this.sub_18d(8)].someStr;
      var8 = var2 + var4 - var6.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var8, var7, var6, GameScreen.gameScreen.rMiniFront2Img);
      var7 += 10;
      var6 = GameScreen.gameScreen.var_1116[this.sub_18d(24)].someStr;
      var8 = var2 + var4 - var6.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var8, var7, var6, GameScreen.gameScreen.rMiniFront2Img);
      var7 += 10;
      var6 = this.sub_400() + "-" + GameScreen.gameScreen.var_1171[this.sub_3a5()].someStr;
      var8 = var2 + var4 - var6.length() * 5 - 5;
      GameScreen.gameScreen.sub_fcf(var1, var8, var7, var6, GameScreen.gameScreen.rMiniFront2Img);
      var7 += 10;
      var1.setColor(2565927);
      var7 = var3 + var5 - 40;
      var1.fillRect(var2 + 5, var7, var4 - 10, 27);
      var7 += 3;
      var8 = var2 + 6;
      GameScreen.gameScreen.sub_fcf(var1, var8, var7, SomeUtilClass.getStr("СКОРОСТЬ") + ":", GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, var8 + 45, var7, "" + this.sub_530(), GameScreen.gameScreen.rMiniFront2Img);
      GameScreen var10001 = GameScreen.gameScreen;
      var7 += 5 + 3;
      GameScreen.gameScreen.sub_fcf(var1, var8, var7, SomeUtilClass.getStr("ЦЕНА") + ":", GameScreen.gameScreen.rMiniFront2Img);
      int var9 = this.sub_601(GameScreen.gameScreen.var_d5c.var_1c6);
      if (var9 <= 99) {
         GameScreen.gameScreen.sub_fcf(var1, var8 + 45, var7, "" + this.sub_601(GameScreen.gameScreen.var_d5c.var_1c6), GameScreen.gameScreen.rMiniFront2Img);
      } else {
         GameScreen.gameScreen.sub_fcf(var1, var8 + 40, var7, "" + this.sub_601(GameScreen.gameScreen.var_d5c.var_1c6), GameScreen.gameScreen.rMiniFront2Img);
      }

      var10001 = GameScreen.gameScreen;
      var7 += 5 + 3;
      var6 = SomeUtilClass.getStr("СВОБОДНО МЕСТА") + ": " + this.sub_4d4();
      GameScreen var10000 = GameScreen.gameScreen;
      int var10004 = var6.length();
      GameScreen var10005 = GameScreen.gameScreen;
      var10000.sub_fcf(var1, var2 + (var4 - var10004 * 5) / 2, var7, var6, GameScreen.gameScreen.rMiniFront2Img);
      int var10 = var3 + var5 - 4;
      var10001 = GameScreen.gameScreen;
      var7 = var10 - 5 - 2;
      if (this.sub_4d4() >= 0) {
         GameScreen.gameScreen.sub_fcf(var1, var8, var7, SomeUtilClass.getStr("МОЖНО СОЗДАТЬ"), GameScreen.gameScreen.rMiniFront2Img);
      } else {
         GameScreen.gameScreen.sub_fcf(var1, var8, var7, SomeUtilClass.getStr("НЕВОЗМОЖНО"), GameScreen.gameScreen.rMiniFront2Img);
      }

      var8 = var2 + 6 + var4 / 2;
      var7 = var3 + var5 - 40 + 3;
      GameScreen.gameScreen.sub_fcf(var1, var8, var7, SomeUtilClass.getStr("АТК") + ":", GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, var8 + 25, var7, "" + this.sub_582(), GameScreen.gameScreen.rMiniFront2Img);
      var10001 = GameScreen.gameScreen;
      var7 += 5 + 3;
      GameScreen.gameScreen.sub_fcf(var1, var8, var7, SomeUtilClass.getStr("ЗЩТ") + ":", GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, var8 + 25, var7, "" + this.sub_53b(), GameScreen.gameScreen.rMiniFront2Img);
      var10001 = GameScreen.gameScreen;
      var7 += 5 + 3;
   }

   public int sub_698() {
      return this.sub_53b() + this.sub_582();
   }
}
