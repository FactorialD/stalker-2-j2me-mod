import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class IntroPainter {
   public Image wardreamsImg = null;
   public Image playfonImg = null;
   public int var_c1 = 0;
   public int var_11b = 150;
   public String presentsStr = null;
   public static boolean var_1ad = true;
   public boolean var_208 = false;
   public int var_224 = 0;

   public IntroPainter() {
      try {
         this.wardreamsImg = Image.createImage("/images/dev_logo.png");
         if (var_1ad) {
            this.playfonImg = Image.createImage("/mimage/playfon.png");
            this.var_11b = 300;
         }
      } catch (IOException var2) {
      }

      this.presentsStr = SomeUtilClass.getStr("ПРЕДСТАВЛЯЕТ");
   }

   // Draw intro screen
   public void showIntro(Graphics g) {
	   //Drawing black background
      g.setColor(0);
      g.fillRect(0, 0, g.getClipWidth(), g.getClipHeight());
      if (this.var_c1 <= 150 && var_1ad) {
    	  // and then draws first logo
         g.drawImage(this.playfonImg, (g.getClipWidth() - this.playfonImg.getWidth()) / 2, (g.getClipHeight() - this.playfonImg.getHeight()) / 2, 20);
         GameScreen.gameScreen.flushGraphics();
         ++this.var_c1;
      } else {
         int var2 = (g.getClipWidth() - this.wardreamsImg.getWidth()) / 2;
         int var3 = (g.getClipHeight() - this.wardreamsImg.getHeight()) / 2;
         byte var4 = 0;
         int var5 = this.var_224 - 28;
         if (var5 > var2) {
            var5 = var2;
            ++var4;
         }

         //draws developer logo left part
         g.setClip(var5, var3, 28, 16);
         g.drawImage(this.wardreamsImg, var5, var3, 20);
         var5 = GameScreen.gameScreen.getWidth() - this.var_224;
         if (var5 < var2 + 28) {
            var5 = var2 + 28;
            ++var4;
         }

       //draws developer logo right part
         g.setClip(var5, var3, 57, 16);
         g.drawImage(this.wardreamsImg, var5 - 28, var3, 20);
         g.setClip(0, 0, GameScreen.gameScreen.getWidth(), GameScreen.gameScreen.getHeight());
         GameScreen.gameScreen.flushGraphics();
         ++this.var_c1;
         this.var_224 += 3;
      }
   }
}
