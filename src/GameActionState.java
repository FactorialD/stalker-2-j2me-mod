/**
 * Keeps state of button actions pressed
 */
public class GameActionState {
   public boolean up;
   public boolean down;
   public boolean left;
   public boolean right;
   public boolean fire;
   public boolean num7;
   public boolean num1;
   public boolean num3;
   public boolean num9;
   public boolean numStar;
   public boolean numPound;
   private final GameScreen gameScreen;

   public GameActionState(GameScreen gameScreen) {
      this.gameScreen = gameScreen;
   }

   public void clearAllStates() {
      this.up = false;
      this.down = false;
      this.left = false;
      this.right = false;
      this.fire = false;
      this.num7 = false;
      this.num1 = false;
      this.num3 = false;
      this.num9 = false;
      this.numStar = false;
      this.numPound = false;
   }
}
