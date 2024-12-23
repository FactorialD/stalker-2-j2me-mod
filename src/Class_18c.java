import javax.microedition.lcdui.Graphics;

public class Class_18c extends Class_4b3 {
   public int var_54 = 10;
   public String var_6d;
   public String var_c0;
   public int var_113;
   public int colonyInfoLineColor = 2565927;

   public Class_18c(String var1, int var2, int var3, String var4, int var5) {
      super(0, var2, var3, 106, 32, var5, (Planet)null);
      super.var_5d4 = false;
      super.var_1f3 = 32;
      super.var_c7c = 32;
      this.var_c0 = var1;
      this.var_6d = var4.toUpperCase();
      this.addMenu2Option(super.xPos + (super.var_124 - SomeUtilClass.getStr(var1).length() * 8) / 2, super.yPos + 4, SomeUtilClass.getStr(var1), true);
      this.var_113 = 0;

      for(int var6 = this.var_6d.length(); var6 < this.var_54; ++var6) {
         this.var_6d = this.var_6d + " ";
      }

   }

   public void sub_40(Graphics g) {
      boolean var2 = false;
      this.sub_108(g);
      g.setColor(colonyInfoLineColor);
      g.fillRect(super.xPos + 5, super.yPos + 4 + 10, super.var_124 - 10, 13);

      for(int var5 = 0; var5 < this.var_54; ++var5) {
         g.setColor(65280);
         int var3 = super.xPos + 8 + var5 * 9;
         if (var5 == super.var_3c8) {
            if (this.var_113 > 5) {
               g.drawLine(var3, super.yPos + 16 + 9, var3 + 6, super.yPos + 16 + 9);
            }
         } else {
            g.drawLine(var3, super.yPos + 16 + 9, var3 + 6, super.yPos + 16 + 9);
         }

         if (var5 < this.var_6d.length()) {
            ++var3;
            this.var_6d.charAt(var5);
            GameScreen.gameScreen.drawFancyText(g, var3, super.yPos + 16, this.var_6d.substring(var5, var5 + 1), super.var_42f);
         }

         if (var5 == super.var_3c8) {
            if (this.var_113 > 10) {
               this.var_113 = 0;
            }

            ++this.var_113;
         }
      }

   }

   public void sub_4d() {
      char var1 = this.var_6d.charAt(super.var_3c8);
      if (var1 == ' ') {
         var1 = 1071;
      } else {
         --var1;
         if (var1 < 1040) {
            var1 = ' ';
         }
      }

      String var2 = "";
      if (super.var_3c8 > 0) {
         var2 = this.var_6d.substring(0, super.var_3c8);
      }

      var2 = var2 + var1;
      if (super.var_3c8 + 1 < this.var_6d.length()) {
         var2 = var2 + this.var_6d.substring(super.var_3c8 + 1);
      }

      this.var_6d = var2;
   }

   public void sub_82() {
      char var1 = this.var_6d.charAt(super.var_3c8);
      if (var1 == ' ') {
         var1 = 1040;
      } else {
         ++var1;
         if (var1 > 1071) {
            var1 = ' ';
         }
      }

      String var2 = "";
      if (super.var_3c8 > 0) {
         var2 = this.var_6d.substring(0, super.var_3c8);
      }

      var2 = var2 + var1;
      if (super.var_3c8 + 1 < this.var_6d.length()) {
         var2 = var2 + this.var_6d.substring(super.var_3c8 + 1);
      }

      this.var_6d = var2;
   }

   public void sub_a6() {
      ++super.var_3c8;
      if (super.var_3c8 >= this.var_54) {
         super.var_3c8 = 0;
      }

   }

   public void sub_e3() {
      --super.var_3c8;
      if (super.var_3c8 < 0) {
         super.var_3c8 = this.var_54 - 1;
      }

   }
}
