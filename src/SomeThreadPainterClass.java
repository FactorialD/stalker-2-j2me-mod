import javax.microedition.lcdui.Graphics;

public class SomeThreadPainterClass extends Thread {
   public int var_33;
   public Graphics g;
   public GameRect rect;
   public int var_f7 = 0;
   public boolean var_156;

   public SomeThreadPainterClass(Graphics g) {
      this.var_33 = 0;
      this.g = g;
      this.rect = new GameRect();
      this.rect.y1 = GameScreen.gameScreen.getHeight() / 2 - 3;
      this.rect.x1 = GameScreen.gameScreen.getWidth() / 2 - 45;
      this.var_f7 = 15;
      this.var_156 = false;
   }

   public SomeThreadPainterClass() {
      this.var_156 = true;
   }

   public void start() {
      Thread t = new Thread(this);
      t.start();
   }

   public void run() {
      for(; this.var_33 < 100; this.var_33 = GameScreen.gameScreen.var_d05) {
         this.var_33 = GameScreen.gameScreen.var_d05;
         this.sub_2d();

         try {
            Thread.sleep(100L);
         } catch (InterruptedException var2) {
         }
      }

   }

   public void sub_2d() {
      this.g.setColor(0);
      this.g.fillRect(0, 0, this.g.getClipWidth(), this.g.getClipHeight());
      int var2 = (GameScreen.gameScreen.getHeight() - 11) / 2;
      this.rect.y1 = var2 + 11;
      this.g.setColor(2171169);
      this.g.setStrokeStyle(0);
      this.g.drawRect(this.rect.x1, this.rect.y1, 92, 6);
      this.g.setColor(2171169);

      int var3;
      for(var3 = 0; var3 < this.var_f7; ++var3) {
         this.g.fillRect(this.rect.x1 + 2 + var3 * 6, this.rect.y1 + 2, 5, 3);
      }

      var3 = this.var_f7 * this.var_33 / 100;
      this.g.setColor(4934475);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.g.fillRect(this.rect.x1 + 2 + var4 * 6, this.rect.y1 + 2, 5, 3);
      }

      GameScreen.gameScreen.flushGraphics();
   }
}
