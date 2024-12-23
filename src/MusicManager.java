import java.io.IOException;
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

public class MusicManager extends Thread {
   public Player mediaPlayer = null;
   public int currentMusicCode;
   public boolean var_e4 = true;
   public boolean var_13f = false;
   public boolean var_181;
   public int musicId;

   public void start() {
      this.var_e4 = true;
      Thread var1 = null;
      var1 = new Thread(this);
      var1.start();
   }

   public void sub_19() {
      this.var_e4 = false;
   }

   public void run() {
      while(this.var_e4) {
         if (this.var_181) {
            this.var_181 = false;
            this.stopMusic();
         }

         if (this.var_13f) {
            this.var_13f = false;
            this.playMusic(this.musicId);
         }

         try {
            Thread.sleep(100L);
         } catch (InterruptedException var2) {
         }
      }

      this.stopMusic();
   }

   public void changeMusicId(int newMusicId) {
      this.musicId = newMusicId;
      this.var_13f = true;
   }

   public void sub_59() {
      this.var_181 = true;
   }

   public MusicManager() {
      this.var_e4 = true;
      this.currentMusicCode = 0;
   }

   private void playMusic(int musicCode) {
      if (Stars.var_b9) {
         try {
        	  /*String supportedTypes[] = Manager.getSupportedContentTypes(null);
        	  for (int i = 0; i < supportedTypes.length; i++) {
        	     if (supportedTypes[i].startsWith("audio")) {
        	        System.out.println("Device supports " + supportedTypes[i]);
        	     }
        	  }*/
        	 
            this.stopMusic();
            
            switch(musicCode) {
            case 1:
            	this.mediaPlayer = createMediaPlayerFor("music/main.mid", "audio/midi");
               break;
            case 2:
            	this.mediaPlayer = createMediaPlayerFor("music/battle.mid", "audio/midi");
               break;
            case 3:
            	this.mediaPlayer = createMediaPlayerFor("music/stalker_main_menu.amr", "audio/amr");
               break;
            case 4:
            	this.mediaPlayer = createMediaPlayerFor("music/dj_piska.amr", "audio/amr");

          }
            this.mediaPlayer.realize();
            this.mediaPlayer.prefetch();
            this.mediaPlayer.setLoopCount(-1);
            this.mediaPlayer.start();
            this.currentMusicCode = musicCode;
         } catch (Exception e) {
         }
      }
   }
   
   private Player createMediaPlayerFor(String musicName, String musicType) throws Exception {
	   InputStream inputStream = this.getClass().getResourceAsStream(musicName);
	   return Manager.createPlayer(inputStream, musicType);
   }

   private void stopMusic() {
      if (this.mediaPlayer != null) {
         try {
            if (this.mediaPlayer.getState() == 400) {
               this.mediaPlayer.stop();
            }

            this.mediaPlayer.deallocate();
            this.mediaPlayer.close();
            this.mediaPlayer = null;
            this.currentMusicCode = 0;
         } catch (MediaException e) {
         }
      }

   }
}
