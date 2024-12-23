import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Class_4b3 {
   public int xPos;
   public int yPos;
   
   public int menuWidth = 160;
   public int var_124;
   public int windowHeight;
   public int var_1f3 = 0;
   public int var_221;
   public int menuId;
   public String var_26e;
   public Vector menuOptions2Arr = null;
   public Vector menuOptions1Arr = null;
   public Vector var_32d = null;
   public int var_368;
   public int var_3c8;
   public int var_409;
   public Image var_42f;
   public Image var_43b;
   public int var_499 = 0;
   public Planet var_4dd = null;
   public Planet var_4f8 = null;
   public Class_2a9 var_53a = null;
   public Project var_57d = null;
   public boolean var_5d4;
   public Image curRightImg = null;
   public Image curLeftImg = null;
   public Image curUpImg = null;
   public Image curDownImg = null;
   public Image polImg = null;
   public Vector rectArr = null;
   public Random var_6f5 = null;
   public Class_2e2 var_73e = null;
   public Class_18c var_79a = null;
   public Image colBtnImg = null;
   public Image colPicImg = null;
   public Image colBuildImg = null;
   public Image btnBuildImg = null;
   public Image blueLineImg = null;
   public Image peopleImg = null;
   public Image txtListImg = null;
   public Image rPanelImg = null;
   public Image infoImg = null;
   public Image tubaImg = null;
   public Image rShipImg = null;
   public Image rHouseImg = null;
   public Image rsocImg = null;
   public Image artefact = null;
   public int var_ab3 = 0;
   public boolean var_b03 = false;
   public int var_b2b = 0;
   public boolean var_b64 = false;
   public Class_4b3 var_b77 = null;
   public int var_b81 = 0;
   public int var_bdb = 0;
   public Image var_c28 = null;
   public int var_c7c;
   public int var_caf = 0;
   public int var_cbe = 0;
   public int var_cd3;
   public int var_cea = 0;
   public int var_cf7 = 0;
   public int var_d14 = 0;
   public int var_d47;
   public Image var_d8e = null;
   public String var_de3 = "";
   public int[] var_e03 = null;
   public int[] var_e50 = null;
   public int var_e5a = -1;
   public int var_e96;
   public int var_efa;
   // Planet info colony menu bg color
   public int planetInfoMenuBgColor = 5909268;

   public Class_4b3(int menuId, int xPos, int yPos, int var4, int var5, int var6, Planet var7) {
      this.xPos = xPos;
      this.yPos = yPos;
      this.var_124 = var4;
      this.windowHeight = var5;
      this.var_1f3 = 4;
      this.menuId = menuId;
      this.var_221 = var6;
      this.menuOptions2Arr = null;
      this.var_3c8 = 0;
      this.var_368 = 0;
      this.var_26e = "";
      this.var_4dd = var7;
      this.var_cd3 = 0;
      this.var_42f = GameScreen.gameScreen.rBigFrontImg;
      this.var_43b = GameScreen.gameScreen.formZakImg;
      this.var_d47 = 0;
      this.var_5d4 = true;
      int curYPos;
      int tempInt;
      switch(this.menuId) {
      case 1: //planet view
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("ЗАКРЫТЬ").length() * 8) / 2, this.yPos + var5 - 15, SomeUtilClass.getStr("ЗАКРЫТЬ"), true);
         curYPos = this.yPos + 15;
         if (this.var_4dd != null) {
            this.var_26e = this.var_4dd.sub_96();
            this.addMenu2Option(this.xPos + 13, curYPos, SomeUtilClass.getStr("ХАБАР:"), false);
            this.addMenu2Option(this.xPos + 66, curYPos, "" + this.var_4dd.sub_1a4(), false);
            curYPos += 7;
            this.addMenu2Option(this.xPos + 13, curYPos, SomeUtilClass.getStr("ТЕХНИКА:"), false);
            this.addMenu2Option(this.xPos + 66, curYPos, "" + this.var_4dd.sub_1d1(), false);
            curYPos += 7;
            this.addMenu2Option(this.xPos + 13, curYPos, SomeUtilClass.getStr("НАУКА:"), false);
            this.addMenu2Option(this.xPos + 66, curYPos, "" + this.var_4dd.sub_224(), false);
            curYPos += 7;
            curYPos += 5;
            this.addMenu2Option(this.xPos + 13, curYPos, SomeUtilClass.getStr("НАСЕЛЕНИЕ:"), false);
            this.addMenu2Option(this.xPos + 66, curYPos, "" + this.var_4dd.sub_248(), false);
            curYPos += 7;
         }

         this.var_e5a = 16;
         break;
      case 2: // pause menu
         this.var_5d4 = false;
         curYPos = this.yPos + 8;
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("ХОД").length() * 8) / 2, curYPos, SomeUtilClass.getStr("ХОД"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("КАРТА").length() * 8) / 2, curYPos, SomeUtilClass.getStr("КАРТА"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("ОТРЯДЫ").length() * 8) / 2, curYPos, SomeUtilClass.getStr("ФЛОТ"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("НАУКА").length() * 8) / 2, curYPos, SomeUtilClass.getStr("НАУКА"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("СТАЛКЕРЫ").length() * 8) / 2, curYPos, SomeUtilClass.getStr("ПРОЕКТЫ"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("НАЛОГ").length() * 8) / 2, curYPos, SomeUtilClass.getStr("НАЛОГ"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("СЧЕТ").length() * 8) / 2, curYPos, SomeUtilClass.getStr("СЧЕТ"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("ВЫХОД").length() * 8) / 2 - 1, curYPos, SomeUtilClass.getStr("ВЫХОД"), true);
         curYPos += 10;
         this.var_e5a = 2;
         break;
      case 3:
         this.addMenu2Option(this.xPos + (var4 - SomeUtilClass.getStr("СТАЛКЕРЫ").length() * 8) / 2, this.yPos + 4, SomeUtilClass.getStr("ПРОЕКТЫ"), true);
         this.var_6f5 = new Random();
         this.var_e5a = 10;
         break;
      case 4:
         curYPos = this.yPos + 8;
         this.var_5d4 = false;
         this.addMenu1Option(this.xPos + 5, curYPos, SomeUtilClass.getStr("ИМЯ"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + 5, curYPos, SomeUtilClass.getStr("РАНГ"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + 5, curYPos, SomeUtilClass.getStr("ВЫНОСЛИВОСТЬ"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + 5, curYPos, SomeUtilClass.getStr("БРОНЯ"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + 5, curYPos, SomeUtilClass.getStr("БОЕПРИПАСЫ"), true);
         curYPos += 10;
         this.addMenu1Option(this.xPos + 5, curYPos, SomeUtilClass.getStr("ОРУЖИЕ"), true);
         curYPos += 10;
         this.var_e5a = 11;
         break;
      case 5: // create colony menu
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("ДА").length() * 8) / 2, this.yPos + var5 - 25, SomeUtilClass.getStr("ДА"), true);
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("НЕТ").length() * 8) / 2, this.yPos + var5 - 15, SomeUtilClass.getStr("НЕТ"), true);
         curYPos = this.yPos + 15;
         if (this.var_4dd != null) {
            this.addMenu2Option(this.xPos + 13 + 10, curYPos, SomeUtilClass.getStr("ХАБАР"), false);
            this.addMenu2Option(this.xPos + 66 + 10, curYPos, "" + this.var_4dd.sub_1a4(), false);
            curYPos += 7;
            this.addMenu2Option(this.xPos + 13 + 10, curYPos, SomeUtilClass.getStr("ТЕХНИКА:"), false);
            this.addMenu2Option(this.xPos + 66 + 10, curYPos, "" + this.var_4dd.sub_1d1(), false);
            curYPos += 7;
            this.addMenu2Option(this.xPos + 13 + 10, curYPos, SomeUtilClass.getStr("НАУКА:"), false);
            this.addMenu2Option(this.xPos + 66 + 10, curYPos, "" + this.var_4dd.sub_224(), false);
            curYPos += 7;
            curYPos += 5;
            this.addMenu2Option(this.xPos + 13 + 10, curYPos, SomeUtilClass.getStr("НАСЕЛЕНИЕ:"), false);
            this.addMenu2Option(this.xPos + 66 + 10, curYPos, "" + this.var_4dd.sub_248(), false);
            curYPos += 7;
         }

         this.addMenu2Option(this.xPos + (var4 - SomeUtilClass.getStr("ОСНОВАТЬ ЛАГЕРЬ").length() * 8) / 2 - 2, this.yPos + 5, SomeUtilClass.getStr("ОСНОВАТЬ ЛАГЕРЬ"), true);
         this.var_e5a = 15;
         break;
      case 6:
         this.var_124 = 82;
         this.windowHeight = 46;
         this.xPos = (GameScreen.gameScreen.getWidth() - this.var_124) / 2;
         this.yPos = (GameScreen.gameScreen.getHeight() - this.windowHeight) / 2;
         this.addMenu1Option(this.xPos + (this.var_124 - SomeUtilClass.getStr("ЗАКРЫТЬ").length() * 8) / 2, this.yPos + this.windowHeight - 15, SomeUtilClass.getStr("ЗАКРЫТЬ"), true);
         break;
      case 7:
         try {
            this.curRightImg = Image.createImage("/images/cur_right.png");
            this.curLeftImg = Image.createImage("/images/cur_left.png");
            this.curUpImg = Image.createImage("/images/cur_up.png");
            this.curDownImg = Image.createImage("/images/cur_down.png");
            this.colBtnImg = Image.createImage("/images/colbtn.png");
            this.colPicImg = Image.createImage("/images/colpic.png");
            this.colBuildImg = Image.createImage("/images/colbuild.png");
            this.btnBuildImg = Image.createImage("/images/btnbuild.png");
            this.blueLineImg = Image.createImage("/images/blueline.png");
            this.peopleImg = Image.createImage("/images/people.png");
            this.txtListImg = Image.createImage("/images/txtlist.png");
            this.rHouseImg = Image.createImage("/images/rhouse.png");
         } catch (IOException var19) {
         }

         this.var_3c8 = 4;
         this.var_e5a = 4;
         break;
      case 8:
         this.var_5d4 = false;
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("ИССЛЕДОВАТЬ").length() * 8) / 2, this.yPos + var5 - 22, SomeUtilClass.getStr("ИССЛЕДОВАТЬ"), true);
         this.addMenu1Option(this.xPos + (var4 - SomeUtilClass.getStr("ОТМЕНА").length() * 8) / 2 - 2, this.yPos + var5 - 12, SomeUtilClass.getStr("ОТМЕНА"), true);
         break;
      case 9:
         try {
            this.rShipImg = Image.createImage("/images/rship.png");
            this.rPanelImg = Image.createImage("/images/rpanel.png");
            this.artefact = Image.createImage("/images/artefact.png");
         } catch (IOException var18) {
         }

         GameScreen.gameScreen.sub_1827();
         this.var_6f5 = new Random();
         this.var_b81 = 0;
         this.var_bdb = 0;
         this.var_efa = 3;
         if (this.windowHeight <= 160) {
            this.var_efa = 2;
         }

         this.var_e96 = GameScreen.gameScreen.var_b9b * this.var_efa;
         this.var_d14 = this.var_e96;
         if (this.windowHeight <= 160) {
            this.var_d14 += 10;
         }

         this.var_e5a = 5;
         break;
      case 10:
         try {
            this.colBtnImg = Image.createImage("/images/colbtn.png");
            this.rPanelImg = Image.createImage("/images/rpanel.png");
            this.curUpImg = Image.createImage("/images/cur_up.png");
            this.curDownImg = Image.createImage("/images/cur_down.png");
            this.polImg = Image.createImage("/images/pol.png");
            this.tubaImg = Image.createImage("/images/tuba.png");
         } catch (IOException var17) {
         }

         this.var_caf = GameScreen.gameScreen.sub_132f(GameScreen.gameScreen.var_d5c.var_1c6);
         this.var_cbe = 3;
         this.var_b2b = 2;
         this.var_e96 = 5 + 30 * this.var_cbe + 6;
         this.var_53a = GameScreen.gameScreen.var_d5c;
         this.var_cea = this.var_b2b * 30 + 19;
         this.var_cf7 = this.var_e96;
         this.var_e5a = 6;
         break;
      case 11:
         curYPos = this.yPos + this.windowHeight - 32;
         int var9 = this.xPos + (this.var_124 - SomeUtilClass.getStr("СМЕНИТЬ КОМ").length() * 8) / 2;
         this.addMenu1Option(var9, curYPos, SomeUtilClass.getStr("СМЕНИТЬ КОМ"), true);
         curYPos += 10;
         var9 = this.xPos + (this.var_124 - SomeUtilClass.getStr("ПРОДАТЬ").length() * 8) / 2;
         this.addMenu1Option(var9, curYPos, SomeUtilClass.getStr("ПРОДАТЬ"), true);
         curYPos += 10;
         var9 = this.xPos + (this.var_124 - SomeUtilClass.getStr("ЗАКРЫТЬ").length() * 8) / 2;
         this.addMenu1Option(var9, curYPos, SomeUtilClass.getStr("ЗАКРЫТЬ"), true);
         break;
      case 12:
         this.var_124 = 82;
         this.windowHeight = 56;
         this.xPos = (GameScreen.gameScreen.getWidth() - this.var_124) / 2;
         this.yPos = (GameScreen.gameScreen.getHeight() - this.windowHeight) / 2;
         this.addMenu1Option(this.xPos + (this.var_124 - SomeUtilClass.getStr("ДА").length() * 8) / 2, this.yPos + this.windowHeight - 22, SomeUtilClass.getStr("ДА"), true);
         this.addMenu1Option(this.xPos + (this.var_124 - SomeUtilClass.getStr("НЕТ").length() * 8) / 2, this.yPos + this.windowHeight - 12, SomeUtilClass.getStr("НЕТ"), true);
         break;
      case 13:
         this.var_53a = GameScreen.gameScreen.var_d5c;
         this.var_b64 = this.var_53a.sub_6d1() > 0;

         try {
            this.rPanelImg = Image.createImage("/images/rpanel.png");
            this.tubaImg = Image.createImage("/images/tuba.png");
            if (this.var_b64) {
               this.infoImg = Image.createImage("/images/info.png");
               this.rShipImg = Image.createImage("/images/rship.png");
               this.rHouseImg = Image.createImage("/images/rhouse.png");
               this.rsocImg = Image.createImage("/images/rsoc.png");
               this.curUpImg = Image.createImage("/images/cur_up.png");
               this.curDownImg = Image.createImage("/images/cur_down.png");
               this.polImg = Image.createImage("/images/pol.png");
            }
         } catch (IOException var13) {
         }

         if (!this.var_b64) {
            this.var_e96 = 60;
         } else {
            this.var_e96 = this.var_124 - 3;
            this.var_b81 = this.windowHeight - 30 - this.yPos;
            this.var_e5a = 13;
         }

         this.var_caf = 0;
         break;
      case 14:
         this.var_124 = 82;
         this.windowHeight = 46;
         this.xPos = (GameScreen.gameScreen.getWidth() - this.var_124) / 2;
         this.yPos = (GameScreen.gameScreen.getHeight() - this.windowHeight) / 2;
         this.addMenu1Option(this.xPos + (this.var_124 - SomeUtilClass.getStr("ОК").length() * 8) / 2, this.yPos + this.windowHeight - 15, SomeUtilClass.getStr("ОК"), true);
         break;
      case 15:
         try {
            if (Stars.var_b9) {
               this.infoImg = Image.createImage("/mimage/main_menu_bg.png");
            }

            GameScreen.gameScreen.gameLogoMainImg = Image.createImage("/images/game_logo_main.png");
            if (Stars.var_b9) {
               GameScreen.gameScreen.ltitulImg = Image.createImage("/mimage/ltitul.png");
               GameScreen.gameScreen.gameLogoSecondary = Image.createImage("/mimage/game_logo_secondary.png");
            }

            GameScreen.gameScreen.devLogoImg = Image.createImage("/images/dev_logo.png");
            this.rPanelImg = Image.createImage("/images/rpanel.png");
            this.blueLineImg = Image.createImage("/images/blueline.png");
         } catch (IOException var14) {
         }

         tempInt = 1;
         if (GameScreen.gameScreen.var_90 || GameScreen.gameScreen.var_d5) {
            this.addMenu1Option(-1, tempInt, SomeUtilClass.getStr("ВЕРНУТЬСЯ В ЗОНУ"), true);
            ++tempInt;
         }

         this.addMenu1Option(-1, tempInt, SomeUtilClass.getStr("ОТПРАВИТЬСЯ В ЗОНУ"), true);
         ++tempInt;
         this.addMenu1Option(-1, tempInt, SomeUtilClass.getStr("НАСТРОЙКИ"), true);
         ++tempInt;
         this.addMenu1Option(-1, tempInt, SomeUtilClass.getStr("ЛЕГЕНДЫ"), true);
         ++tempInt;
         this.addMenu1Option(-1, tempInt, SomeUtilClass.getStr("ПОМОЩЬ"), true);
         ++tempInt;
         this.addMenu1Option(-1, tempInt, SomeUtilClass.getStr("ВЫХОД"), true);
         ++tempInt;
         this.var_3c8 = 0;
         break;
      case 16:
         try {
            this.rPanelImg = Image.createImage("/images/rpanel.png");
            this.blueLineImg = Image.createImage("/images/blueline.png");
            this.curRightImg = Image.createImage("/images/cur_right.png");
            this.curLeftImg = Image.createImage("/images/cur_left.png");
         } catch (IOException var16) {
         }

         this.var_e5a = 12;
         break;
      case 17:
         try {
            this.rPanelImg = Image.createImage("/images/rpanel.png");
            this.blueLineImg = Image.createImage("/images/blueline.png");
         } catch (IOException var15) {
         }

         this.var_e03 = new int[GameScreen.gameScreen.var_d39.size()];
         this.var_e50 = new int[this.var_e03.length];

         for(tempInt = 0; tempInt < this.var_e03.length; ++tempInt) {
            Class_2a9 var11 = (Class_2a9)GameScreen.gameScreen.var_d39.elementAt(tempInt);
            this.var_e03[tempInt] = var11.var_1c6;
            this.var_e50[tempInt] = var11.sub_88e();
         }

         for(tempInt = 0; tempInt < this.var_e03.length; ++tempInt) {
            for(int var20 = tempInt + 1; var20 < this.var_e03.length; ++var20) {
               if (this.var_e50[tempInt] < this.var_e50[var20]) {
                  int var12 = this.var_e50[tempInt];
                  this.var_e50[tempInt] = this.var_e50[var20];
                  this.var_e50[var20] = var12;
                  var12 = this.var_e03[tempInt];
                  this.var_e03[tempInt] = this.var_e03[var20];
                  this.var_e03[var20] = var12;
               }
            }
         }

         this.var_e5a = 14;
      case 18:
      case 19:
      default:
         break;
      case 20:
         this.addMenu1Option(this.xPos + (this.var_124 - SomeUtilClass.getStr("ЗАКРЫТЬ").length() * 8) / 2, this.yPos + this.windowHeight - 15, SomeUtilClass.getStr("ЗАКРЫТЬ"), true);
         this.addMenu1Option(this.xPos + (this.var_124 - SomeUtilClass.getStr("ДАЛЕЕ").length() * 8) / 2, this.yPos + this.windowHeight - 15, SomeUtilClass.getStr("ДАЛЕЕ"), true);
         this.var_3c8 = 0;
         break;
      case 21:
         this.addMenu1Option(this.xPos + 6, this.yPos + this.windowHeight - 15 - 22, SomeUtilClass.getStr("МУЗЫКА"), true);
         this.addMenu1Option(this.xPos + 6, this.yPos + this.windowHeight - 15 - 11, SomeUtilClass.getStr("ВИБРАЦИЯ"), true);
         this.addMenu1Option(this.xPos + (this.var_124 - SomeUtilClass.getStr("ЗАКРЫТЬ").length() * 8) / 2, this.yPos + this.windowHeight - 15, SomeUtilClass.getStr("ЗАКРЫТЬ"), true);
      }

      if (this.var_5d4) {
         this.var_c7c = this.var_124;
      } else {
         this.var_c7c = this.windowHeight;
      }

   }

   public void addMenu1Option(int xPos, int yPos, String str, boolean var4) {
      if (this.menuOptions2Arr == null) {
         this.menuOptions2Arr = new Vector();
      }

      MenuOptionDto newMenuOption = new MenuOptionDto(this);
      newMenuOption.yPos = yPos;
      newMenuOption.xPos = xPos;
      newMenuOption.str = str;
      newMenuOption.var_2f = var4;
      this.menuOptions2Arr.addElement(newMenuOption);
   }

   public void addMenu2Option(int xPos, int yPos, String str, boolean var4) {
      if (this.menuOptions1Arr == null) {
         this.menuOptions1Arr = new Vector();
      }

      MenuOptionDto newMenuOption = new MenuOptionDto(this);
      newMenuOption.yPos = yPos;
      newMenuOption.xPos = xPos;
      newMenuOption.str = str;
      newMenuOption.var_2f = var4;
      this.menuOptions1Arr.addElement(newMenuOption);
   }

   public void sub_bd() {
   }

   public void sub_108(Graphics g) {
      switch(this.menuId) {
      case 7:
         this.sub_2e2(g);
         return;
      case 8:
      case 11:
      case 12:
      case 14:
      default:
         if (this.var_c7c != this.var_1f3) {
            if (this.var_5d4) {
               GameScreen.gameScreen.sub_114f(g, this.xPos, this.yPos, this.var_1f3, this.windowHeight, this.var_221, this.var_43b);
            } else {
               GameScreen.gameScreen.sub_114f(g, this.xPos, this.yPos, this.var_124, this.var_1f3, this.var_221, this.var_43b);
            }

            this.var_1f3 += 12;
            if (this.var_1f3 > this.var_c7c) {
               this.var_1f3 = this.var_c7c;
            }

            return;
         } else {
            if (this.var_c28 == null) {
               this.var_c28 = Image.createImage(this.var_124, this.windowHeight);
               GameScreen.gameScreen.sub_114f(this.var_c28.getGraphics(), 0, 0, this.var_124, this.windowHeight, this.var_221, this.var_43b);
            }

            g.drawImage(this.var_c28, this.xPos, this.yPos, 20);
            MenuOptionDto var2;
            int var3;
            if (this.menuOptions2Arr != null) {
               for(var3 = 0; var3 < this.menuOptions2Arr.size(); ++var3) {
                  var2 = (MenuOptionDto)this.menuOptions2Arr.elementAt(var3);
                  if (this.var_3c8 == var3) {
                     g.setColor(2565927);
                     g.fillRect(this.xPos + 5, var2.yPos + 2, this.var_124 - 10, 6);
                     g.setColor(3750201);
                     g.drawLine(this.xPos + 5, var2.yPos + 8, this.xPos + 5 + this.var_124 - 11, var2.yPos + 8);
                     g.setColor(4013373);
                     g.drawLine(this.xPos + 5 + this.var_124 - 10, var2.yPos + 2, this.xPos + 5 + this.var_124 - 10, var2.yPos + 8);
                     if (this.menuId == 3) {
                        this.sub_134(g);
                     }
                  }

                  if (this.menuId == 20) {
                     if (this.var_3c8 == var3) {
                        GameScreen.gameScreen.drawFancyText(g, var2.xPos, var2.yPos, var2.str, this.var_42f);
                     }
                  } else {
                     if (this.menuId == 21 && var3 != 2) {
                        this.sub_114(g, var2.yPos, var3);
                     }

                     if (var2.var_2f) {
                        GameScreen.gameScreen.drawFancyText(g, var2.xPos, var2.yPos, var2.str, this.var_42f);
                     } else {
                        GameScreen.gameScreen.sub_fcf(g, var2.xPos, var2.yPos, var2.str, GameScreen.gameScreen.rMiniFrontImg);
                     }
                  }
               }
            }

            if (this.menuOptions1Arr != null) {
               for(var3 = 0; var3 < this.menuOptions1Arr.size(); ++var3) {
                  var2 = (MenuOptionDto)this.menuOptions1Arr.elementAt(var3);
                  if (var2.xPos == -1) {
                     var2.xPos = this.xPos + (this.var_124 - var2.str.length() * 5) / 2;
                  }

                  if (var2.var_2f) {
                     GameScreen.gameScreen.drawFancyText(g, var2.xPos, var2.yPos, var2.str, this.var_42f);
                  } else {
                     GameScreen.gameScreen.sub_fcf(g, var2.xPos, var2.yPos, var2.str, GameScreen.gameScreen.rMiniFront2Img);
                  }
               }
            }

            if (this.var_32d != null) {
               for(int var4 = 0; var4 < this.var_32d.size(); ++var4) {
                  DtoImage1 var5 = (DtoImage1)this.var_32d.elementAt(var4);
                  g.drawImage(var5.image, var5.someInt1, var5.someInt2, 20);
               }
            }

            if (this.menuId == 11) {
               if (this.var_57d == null) {
                  this.var_57d = GameScreen.gameScreen.sub_135b(this.var_53a.var_1c6, this.var_caf);
               }

               Class_4f2 var6 = (Class_4f2)this.var_57d;
               if (var6 != null) {
                  if (this.var_26e == "") {
                     this.var_26e = var6.sub_1af() + " " + var6.sub_264();
                  }

                  var6.sub_6ac(g, this.xPos, this.yPos, this.var_124);
               }
            }

            if (this.menuId == 20) {
               this.sub_c74(g);
            }

            if (this.var_26e != "") {
               GameScreen var10000 = GameScreen.gameScreen;
               int var10002 = this.xPos;
               int var10003 = this.var_124;
               int var10004 = this.var_26e.length();
               GameScreen var10005 = GameScreen.gameScreen;
               var10000.sub_fcf(g, var10002 + (var10003 - var10004 * 5) / 2, this.yPos + 4, this.var_26e, GameScreen.gameScreen.rMiniFront2Img);
            }

            if (this.menuId == 21) {
               String var7 = SomeUtilClass.getStr("НАСТРОЙКИ");
               GameScreen.gameScreen.drawFancyText(g, this.xPos + (this.var_124 - var7.length() * 8) / 2, this.yPos + 5, var7, this.var_42f);
            }

            if (this.var_57d != null && this.menuId == 4) {
               this.var_57d.sub_66a(g, this.xPos, this.yPos, this.var_124, this.windowHeight);
               this.sub_23d(g);
            }

            if (this.var_73e != null) {
               this.var_73e.sub_90(g);
            }

            if (this.var_79a != null) {
               this.var_79a.sub_40(g);
            }

            return;
         }
      case 9:
         this.sub_593(g);
         return;
      case 10:
         this.sub_72d(g);
         return;
      case 13:
         this.sub_918(g);
         return;
      case 15:
         this.drawMainMenu(g);
         return;
      case 16:
         this.sub_c45(g);
         return;
      case 17:
         this.sub_c52(g);
      }
   }

   public void sub_114(Graphics var1, int var2, int var3) {
      boolean var4 = true;
      if (var3 == 1) {
         var4 = GameScreen.gameScreen.var_16d3;
      } else {
         var4 = GameScreen.gameScreen.var_169a;
      }

      String var5 = SomeUtilClass.getStr("ВКЛ");
      if (!var4) {
         var5 = SomeUtilClass.getStr("ВЫКЛ");
      }

      GameScreen.gameScreen.drawFancyText(var1, this.xPos + this.var_124 - 5 - var5.length() * 8, var2, var5, this.var_42f);
   }

   public void sub_134(Graphics var1) {
      var1.drawImage(GameScreen.gameScreen.selShipImg, this.xPos + 6, this.yPos + 16, 20);
      var1.setColor(0);
      var1.fillRect(this.xPos + 7, this.yPos + 17, 26, 26);
      if (Math.abs(this.var_6f5.nextInt() % 3) == 0) {
         this.sub_2bf(this.xPos + 6, this.yPos + 17, 25, 25);
      }

      this.sub_2d0(var1);
      int var2 = this.var_53a.projectsArr[this.var_3c8].sub_18d(28);
      GameScreen.gameScreen.sub_240c(var1, this.xPos + 5, this.yPos + 15, var2, this.var_53a.var_1c6, 30, false, (Image)null);
      int var3 = this.yPos + 17;
      GameScreen.gameScreen.sub_fcf(var1, this.xPos + 37, var3, SomeUtilClass.getStr("АТАКА") + ":", GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, this.xPos + 37 + 47, var3, "" + this.var_53a.projectsArr[this.var_3c8].sub_582(), GameScreen.gameScreen.rMiniFront2Img);
      var3 += 7;
      GameScreen.gameScreen.sub_fcf(var1, this.xPos + 37, var3, SomeUtilClass.getStr("ЗАЩИТА") + ":", GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, this.xPos + 37 + 47, var3, "" + this.var_53a.projectsArr[this.var_3c8].sub_53b(), GameScreen.gameScreen.rMiniFront2Img);
      var3 += 7;
      GameScreen.gameScreen.sub_fcf(var1, this.xPos + 37, var3, SomeUtilClass.getStr("БОЕПРИПАСЫ") + ":", GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, this.xPos + 37 + 47, var3, "" + this.var_53a.projectsArr[this.var_3c8].sub_530(), GameScreen.gameScreen.rMiniFront2Img);
      var3 += 7;
      GameScreen.gameScreen.sub_fcf(var1, this.xPos + 37, var3, SomeUtilClass.getStr("ЦЕНА") + ": ", GameScreen.gameScreen.rMiniFront2Img);
      GameScreen.gameScreen.sub_fcf(var1, this.xPos + 37 + 47, var3, "" + this.var_53a.projectsArr[this.var_3c8].sub_601(this.var_53a.var_1c6), GameScreen.gameScreen.rMiniFront2Img);
   }

   public void sub_140() {
      if (this.var_73e != null) {
         this.var_73e.sub_1b3();
      } else if (this.var_79a != null) {
         this.var_79a.sub_4d();
      } else if (this.var_b77 != null) {
         this.var_b77.sub_140();
      } else if (this.menuId == 7) {
         if (this.var_ab3 != 0) {
            if (this.var_b2b > 0) {
               --this.var_b2b;
            }

         } else {
            if (this.var_3c8 > 0) {
               --this.var_3c8;
            }

         }
      } else {
         if (this.menuId == 9) {
            GameScreen.gameScreen.sub_1886(-1);
         }

         if (this.menuId == 10) {
            if (this.var_caf != 0) {
               this.var_3c8 -= this.var_cbe;
               if (this.var_3c8 < 0) {
                  this.var_3c8 += this.var_cbe;
               }

               if (this.var_3c8 < this.var_368 * this.var_cbe) {
                  --this.var_368;
               }

            }
         } else {
            if (this.menuId == 13) {
               if (this.var_368 > 0) {
                  this.var_368 -= 9;
               }

               if (this.var_368 < 0) {
                  this.var_368 = 0;
               }
            }

            if (this.menuId == 15 && GameScreen.gameScreen.var_173f) {
               if (this.var_3c8 > 0) {
                  --this.var_3c8;
               } else {
                  this.var_3c8 = 4;
               }

            } else if (this.menuOptions2Arr != null) {
               --this.var_3c8;
               if (this.var_3c8 < 0) {
                  this.var_3c8 = this.menuOptions2Arr.size() - 1;
               }

            }
         }
      }
   }

   public void sub_18d() {
      if (this.var_73e != null) {
         this.var_73e.sub_1bf();
      } else if (this.var_79a != null) {
         this.var_79a.sub_82();
      } else if (this.var_b77 != null) {
         this.var_b77.sub_18d();
      } else if (this.menuId == 7) {
         if (this.var_ab3 != 0) {
            if (this.var_b64) {
               ++this.var_b2b;
            }

         } else {
            if (this.var_3c8 < 4) {
               ++this.var_3c8;
            }

         }
      } else if (this.menuId == 9) {
         GameScreen.gameScreen.sub_1886(1);
      } else if (this.menuId == 10) {
         if (this.var_caf != 0) {
            this.var_3c8 += this.var_cbe;
            if (this.var_3c8 >= this.var_caf) {
               this.var_3c8 = this.var_caf - 1;
            }

            if (this.var_3c8 - this.var_368 * this.var_cbe >= this.var_cbe * this.var_b2b) {
               ++this.var_368;
            }

         }
      } else {
         if (this.menuId == 13 && this.colBtnImg != null) {
            int var1 = this.var_c28.getHeight() - 25 - 11;
            if (this.colBtnImg.getHeight() > var1 + this.var_368) {
               this.var_368 += 9;
            }
         }

         if (this.menuId == 15 && GameScreen.gameScreen.var_173f) {
            if (this.var_3c8 < 4) {
               ++this.var_3c8;
            } else {
               this.var_3c8 = 0;
            }

         } else if (this.menuOptions2Arr != null) {
            ++this.var_3c8;
            if (this.var_3c8 >= this.menuOptions2Arr.size()) {
               this.var_3c8 = 0;
            }

         }
      }
   }

   public void sub_197() {
      if (this.var_79a != null) {
         this.var_79a.sub_a6();
      } else if (this.var_73e != null) {
         this.var_73e.sub_21e();
      } else if (this.var_b77 != null) {
         this.var_b77.sub_197();
      } else {
         if (this.menuId == 4 && this.var_57d != null) {
            if (this.var_3c8 == 2) {
               this.var_57d.sub_234();
            }

            if (this.var_3c8 == 3) {
               this.var_57d.sub_276();
            }

            if (this.var_3c8 == 5) {
               this.var_57d.sub_2bd();
            }
         }

         if (this.menuId == 7) {
            if (this.var_3c8 == 0) {
               this.var_4f8 = GameScreen.gameScreen.sub_8b2(this.var_4dd);
            } else {
               if (this.var_3c8 == 1) {
                  this.var_4dd.var_1df.sub_190();
               }

               if (this.var_3c8 == 2) {
                  this.var_4dd.var_1df.sub_1a0();
               }

               if (this.var_3c8 == 3) {
                  this.var_4dd.var_1df.sub_1ca();
               }

               if (this.var_3c8 == 4) {
                  this.sub_505();
               }

            }
         } else if (this.menuId == 9) {
            GameScreen.gameScreen.sub_18d3(1);
         } else if (this.menuId == 10) {
            if (this.var_caf != 0) {
               if (this.var_3c8 < this.var_caf - 1) {
                  ++this.var_3c8;
               }

               if (this.var_3c8 - this.var_368 * this.var_cbe >= this.var_cbe * this.var_b2b) {
                  ++this.var_368;
               }

            }
         } else if (this.menuId == 16) {
            if (GameScreen.gameScreen.var_d5c.var_108 < 50) {
               Class_2a9 var10000 = GameScreen.gameScreen.var_d5c;
               var10000.var_108 += 10;
            }

         } else {
            if (this.menuId == 15 && GameScreen.gameScreen.var_173f && this.var_3c8 >= 1 && this.var_3c8 <= 3) {
               GameScreen.gameScreen.sub_9b3();
            }

         }
      }
   }

   public void sub_1ea() {
      if (this.var_79a != null) {
         this.var_79a.sub_e3();
      } else if (this.var_73e != null) {
         this.var_73e.sub_253();
      } else if (this.var_b77 != null) {
         this.var_b77.sub_1ea();
      } else {
         if (this.menuId == 4 && this.var_57d != null) {
            if (this.var_3c8 == 2) {
               this.var_57d.sub_2e8();
            }

            if (this.var_3c8 == 3) {
               this.var_57d.sub_33d();
            }

            if (this.var_3c8 == 5) {
               this.var_57d.sub_35a();
            }
         }

         if (this.menuId == 7) {
            if (this.var_3c8 == 0) {
               this.var_4f8 = GameScreen.gameScreen.sub_8e6(this.var_4dd);
            } else {
               if (this.var_3c8 == 1 && this.var_4dd.var_1df.sub_249() > 0) {
                  this.var_4dd.var_1df.sub_36(this.var_4dd.var_1df.sub_249() - 1);
               }

               if (this.var_3c8 == 2 && this.var_4dd.var_1df.sub_27d() > 0) {
                  this.var_4dd.var_1df.sub_4b(this.var_4dd.var_1df.sub_27d() - 1);
               }

               if (this.var_3c8 == 3 && this.var_4dd.var_1df.sub_28a() > 0) {
                  this.var_4dd.var_1df.sub_92(this.var_4dd.var_1df.sub_28a() - 1);
               }

            }
         } else if (this.menuId == 9) {
            if (this.var_b77 == null) {
               GameScreen.gameScreen.sub_18d3(-1);
            }
         } else if (this.menuId == 10) {
            if (this.var_caf != 0) {
               if (this.var_3c8 > 0) {
                  --this.var_3c8;
               }

               if (this.var_3c8 < this.var_368 * this.var_cbe) {
                  --this.var_368;
               }

            }
         } else if (this.menuId == 16) {
            if (GameScreen.gameScreen.var_d5c.var_108 > 0) {
               Class_2a9 var10000 = GameScreen.gameScreen.var_d5c;
               var10000.var_108 -= 10;
            }

         } else {
            if (this.menuId == 15 && GameScreen.gameScreen.var_173f) {
               if (this.var_3c8 == 1) {
                  if (GameScreen.gameScreen.var_1819.var_8c > 0) {
                     --GameScreen.gameScreen.var_1819.var_8c;
                  } else {
                     GameScreen.gameScreen.var_1819.var_8c = (byte)(Class_2a9.var_29.length - 1);
                  }
               }

               if (this.var_3c8 == 2) {
                  if (GameScreen.gameScreen.var_186d > 1) {
                     --GameScreen.gameScreen.var_186d;
                  } else {
                     GameScreen.gameScreen.var_186d = 5;
                  }
               }

               if (this.var_3c8 == 3) {
                  if (GameScreen.gameScreen.var_1899 > 0) {
                     --GameScreen.gameScreen.var_1899;
                  } else {
                     GameScreen.gameScreen.var_1899 = 2;
                  }
               }
            }

         }
      }
   }

   public boolean sub_23d(Graphics var1) {
      if (this.menuId != 4 || this.var_3c8 != 2 && this.var_3c8 != 3 && this.var_3c8 != 5) {
         return false;
      } else {
         if (this.curRightImg == null) {
            try {
               this.curRightImg = Image.createImage("/images/cur_right.png");
               this.curLeftImg = Image.createImage("/images/cur_left.png");
            } catch (IOException e) {
            }
         }

         int var10002 = this.xPos + this.var_124 - 17;
         int var10003 = this.yPos + this.windowHeight - 4;
         GameScreen var10004 = GameScreen.gameScreen;
         var1.drawImage(this.curLeftImg, var10002, var10003 - 5 - 2, 20);
         var10002 = this.xPos + this.var_124 - 11;
         var10003 = this.yPos + this.windowHeight - 4;
         var10004 = GameScreen.gameScreen;
         var1.drawImage(this.curRightImg, var10002, var10003 - 5 - 2, 20);
         var10002 = this.xPos + this.var_124;
         GameScreen var10005 = GameScreen.gameScreen;
         var10002 -= 17 + 8 * 5;
         var10003 = this.yPos + this.windowHeight - 3;
         var10004 = GameScreen.gameScreen;
         GameScreen.gameScreen.sub_fcf(var1, var10002, var10003 - 5 - 2, SomeUtilClass.getStr("УМН.УВЛ"), GameScreen.gameScreen.rMiniFront2Img);
         return true;
      }
   }

   public void sub_258() {
      int var1;
      switch(this.var_3c8) {
      case 1:
         for(var1 = 0; var1 < 5; ++var1) {
            if (GameScreen.gameScreen.var_d5c.sub_139(GameScreen.gameScreen.var_1058[var1].someByte)) {
               this.var_73e.sub_4b(GameScreen.gameScreen.var_1058[var1].someStr, var1);
            }
         }

         this.var_73e.sub_2af("РАНГ");
         break;
      case 2:
         for(var1 = 0; var1 < 5; ++var1) {
            if (GameScreen.gameScreen.var_d5c.sub_139(GameScreen.gameScreen.var_1095[var1].someByte)) {
               this.var_73e.sub_4b(GameScreen.gameScreen.var_1095[var1].someStr, var1);
            }
         }

         this.var_73e.sub_2af("ВЫНОСЛИВОСТЬ");
         break;
      case 3:
         for(var1 = 0; var1 < 6; ++var1) {
            if (GameScreen.gameScreen.var_d5c.sub_139(GameScreen.gameScreen.var_10d4[var1].someByte)) {
               this.var_73e.sub_4b(GameScreen.gameScreen.var_10d4[var1].someStr, var1);
            }
         }

         this.var_73e.sub_2af("БРОНЯ");
         break;
      case 4:
         for(var1 = 0; var1 < 5; ++var1) {
            if (GameScreen.gameScreen.var_d5c.sub_139(GameScreen.gameScreen.var_1116[var1].someByte)) {
               this.var_73e.sub_4b(GameScreen.gameScreen.var_1116[var1].someStr, var1);
            }
         }

         this.var_73e.sub_2af("БОЕПРИПАСЫ");
         break;
      case 5:
         for(var1 = 0; var1 < 14; ++var1) {
            if (GameScreen.gameScreen.var_d5c.sub_139(GameScreen.gameScreen.var_1171[var1].someByte)) {
               this.var_73e.sub_4b(GameScreen.gameScreen.var_1171[var1].someStr, var1);
            }
         }

         this.var_73e.sub_2af("ОРУЖИЕ");
      }

   }

   public void sub_266() {
      if (this.menuId == 4) {
         switch(this.var_3c8) {
         case 1:
            this.var_57d.sub_1d7(28, this.var_73e.sub_2eb());
            break;
         case 2:
            this.var_57d.sub_1d7(20, this.var_73e.sub_2eb());
            this.var_57d.sub_1d7(12, 1);
            break;
         case 3:
            this.var_57d.sub_1d7(8, this.var_73e.sub_2eb());
            this.var_57d.sub_1d7(0, 1);
            break;
         case 4:
            this.var_57d.sub_1d7(24, this.var_73e.sub_2eb());
            break;
         case 5:
            this.var_57d.sub_449(this.var_73e.sub_2eb(), 1);
         }
      }

      if (this.menuId == 7) {
         this.var_4dd.var_1df.jobId = this.var_73e.sub_2eb();
      }

   }

   public void sub_2bf(int var1, int var2, int var3, int var4) {
      if (this.rectArr == null) {
         this.rectArr = new Vector();
      }

      if (this.var_6f5 == null) {
         this.var_6f5 = new Random();
      }

      int var5 = Math.abs(this.var_6f5.nextInt() % var4) + var2;
      int var6 = Math.abs(this.var_6f5.nextInt() % 3);
      GameRect rect = new GameRect();
      rect.y1 = var6;
      rect.x1 = var1;
      rect.x2 = var1 + var3;
      rect.y2 = var5;
      this.rectArr.addElement(rect);
   }

   public void sub_2d0(Graphics g) {
      int var3 = -1;
      if (this.rectArr != null) {
         for(int i = 0; i < this.rectArr.size(); ++i) {
            GameRect var2 = (GameRect)this.rectArr.elementAt(i);
            if (var3 != var2.y1) {
               switch(var2.y1) {
               case 0:
                  g.setColor(11513775);
                  break;
               case 1:
                  g.setColor(12566461);
                  break;
               case 2:
                  g.setColor(16777215);
               }

               var3 = var2.y1;
            }

            g.drawLine(var2.x1, var2.y2, var2.x1, var2.y2);
            var2.x1 += var3 + 1;
            if (var2.x1 >= var2.x2) {
               this.rectArr.removeElementAt(i);
            }
         }

      }
   }

   public void sub_2e2(Graphics g) {
      if (this.var_4f8 != null) {
         this.var_4dd = this.var_4f8;
         this.var_4f8 = null;
         this.var_b2b = 0;
         GameScreen.gameScreen.someXCellPos = this.var_4dd.getXAbsoluteSector();
         GameScreen.gameScreen.someYCellPos = this.var_4dd.getYAbsoluteSector();
      }

      if (this.var_1f3 < 100) {
         this.var_1f3 += 12;
      }

      this.sub_2fc(g);
      if (this.var_73e != null) {
         this.var_73e.sub_90(g);
      }

      if (this.var_79a != null) {
         this.var_79a.sub_40(g);
      }

      if (this.var_b77 != null) {
         this.var_b77.sub_108(g);
      }

      int var2;
      if (this.var_b03) {
         var2 = this.windowHeight - GameScreen.gameScreen.topPanelMIng.getHeight() - 20;
         this.sub_491(g, 5, this.var_ab3 + 7, this.var_124 - 10);
         GameScreen.gameScreen.sub_1086(g, 5, this.var_ab3, this.var_124 - 10);
         this.sub_442(g, 5, this.var_ab3 + 9);
         this.drawColonyInfoBg(g, 5, 0, this.var_ab3, this.var_124 - 10);
         if (this.var_ab3 < var2) {
            this.var_ab3 += var2 / 5;
         }

         if (this.var_ab3 > var2) {
            this.var_ab3 = var2;
         }

         if (this.var_ab3 == var2) {
            this.var_b64 = this.var_4dd.drawColonyStatistics(g, this.var_b2b, 15, this.var_124 - 30, this.var_ab3 - 20, this.var_124 > 140);
            g.setStrokeStyle(0);
         } else {
            this.var_b64 = false;
            this.var_b2b = 0;
         }

         if (this.var_b64) {
            g.drawImage(this.curDownImg, this.var_124 - 25, this.var_ab3 - 10, 20);
         }

         if (this.var_b2b != 0) {
            g.drawImage(this.curUpImg, this.var_124 - 32, this.var_ab3 - 10, 20);
         }
      } else if (this.var_ab3 > 0) {
         var2 = this.windowHeight - GameScreen.gameScreen.topPanelMIng.getHeight() - 20;
         this.var_ab3 -= var2 / 5;
         if (this.var_ab3 < 0) {
            this.var_ab3 = 0;
         } else {
            this.sub_491(g, 5, this.var_ab3 + 7, this.var_124 - 10);
            GameScreen.gameScreen.sub_1086(g, 5, this.var_ab3, this.var_124 - 10);
            this.sub_442(g, 5, this.var_ab3 + 9);
            this.drawColonyInfoBg(g, 5, 0, this.var_ab3, this.var_124 - 10);
         }
      }

   }

   public void sub_2fc(Graphics var1) {
      int var2 = 7;
      int var3 = (this.windowHeight - 105) / 2;
      if (this.windowHeight < 160) {
         var3 = 14;
      }

      if (this.windowHeight > 200) {
         var3 = 49;
      }

      if (this.var_124 < 150) {
         var2 = (this.var_124 - this.colBtnImg.getWidth()) / 2;
      }

      char var5 = '+';
      if (this.var_4dd.sub_330() < 0) {
         var5 = '-';
      }

      String var4;
      for(var4 = "" + this.var_4dd.var_1df.var_141; var4.length() < 3; var4 = "0" + var4) {
      }

      var4 = SomeUtilClass.getStr("Н") + ":" + this.var_4dd.var_1df.sub_2ea() + "." + var4 + "(" + var5 + Math.abs(this.var_4dd.sub_330()) + ")";
      GameScreen.gameScreen.sub_fcf(var1, var2, this.windowHeight - 22, var4, GameScreen.gameScreen.rMiniFront2Img);
      this.sub_35e(var1, var2, var3);
      this.sub_3a3(var1, var2 + 5, var3 + 2, 0, this.var_3c8 == 1);
      this.sub_3fa(var1, var2 + 7 + 16, var3 + 2, 45, this.var_4dd.var_1df.sub_249(), 0);
      this.sub_3c7(var1, var2 + 89, var3 + 1, 0, this.var_4dd.sub_2c2(), true);
      var3 += 20;
      this.sub_35e(var1, var2, var3);
      this.sub_3a3(var1, var2 + 5, var3 + 2, 1, this.var_3c8 == 2);
      this.sub_3fa(var1, var2 + 7 + 16, var3 + 2, 45, this.var_4dd.var_1df.sub_27d(), 1);
      this.sub_3c7(var1, var2 + 89, var3 + 1, 1, this.var_4dd.sub_35d(GameScreen.gameScreen.var_d5c), true);
      var3 += 20;
      this.sub_35e(var1, var2, var3);
      this.sub_3a3(var1, var2 + 5, var3 + 2, 2, this.var_3c8 == 3);
      this.sub_3fa(var1, var2 + 7 + 16, var3 + 2, 45, this.var_4dd.var_1df.sub_28a(), 2);
      this.sub_3c7(var1, var2 + 89, var3 + 1, 2, this.var_4dd.sub_36e(GameScreen.gameScreen.var_d5c), true);
      var3 += 20;
      this.sub_35e(var1, var2, var3);
      this.sub_3c7(var1, var2 + 89 - 14 - 3, var3 + 2, 3, this.var_4dd.sub_391(GameScreen.gameScreen.var_d5c), true);
      this.sub_3c7(var1, var2 + 89 - 3, var3 + 1, 4 + this.var_4dd.var_1df.sub_483(), 0, false);
      this.sub_3fa(var1, var2 + 7, var3 + 2, 42, this.var_4dd.var_1df.sub_341(), 3);

      for(int var6 = 0; var6 < SomeUtilClass.var_19.length && this.var_4dd.var_1df.var_19d >= var6 * 100; ++var6) {
         var1.setColor(SomeUtilClass.var_19[var6]);
         var1.drawLine(var2 + 101, var3 + 12 - var6, var2 + 101, var3 + 12 - var6);
      }

      var3 += 20;
      var1.drawImage(this.colBuildImg, var2 + 71, var3, 20);
      this.sub_318(var1, var2 + 71, var3);
      var4 = this.var_4dd.var_1df.sub_402(this.var_4dd.var_1df.jobId, this.var_4dd.sub_35d(GameScreen.gameScreen.var_d5c)) + "Х";
      GameScreen var10000 = GameScreen.gameScreen;
      int var10002 = var2 + 71;
      int var10003 = this.colBuildImg.getWidth();
      int var10004 = var4.length();
      GameScreen var10005 = GameScreen.gameScreen;
      var10002 += (var10003 - var10004 * 5) / 2;
      var10003 = var3 + this.colBuildImg.getHeight();
      GameScreen var7 = GameScreen.gameScreen;
      var10000.sub_fcf(var1, var10002, var10003 - 5 * 2, var4, GameScreen.gameScreen.rMiniFront2Img);
      this.sub_3a3(var1, var2 + 5, var3 + 2, 3, this.var_3c8 == 4);
      GameScreen.gameScreen.drawFancyText(var1, var2 + 5 + 17, var3 + 6, "СТРОИТ", this.var_42f);
      if (this.windowHeight <= 160) {
         var3 += 20;
      } else {
         var3 += 22;
      }

      GameScreen.gameScreen.drawFancyText(var1, var2 + 71 - this.var_4dd.var_1df.getJobName().length() * 8 - 8, var3, this.var_4dd.var_1df.getJobName(), this.var_42f);
   }

   public void sub_318(Graphics var1, int var2, int var3) {
      if (this.var_4dd.var_1df.jobId == 255) {
         var1.drawImage(this.rHouseImg, var2 + 15, var3 + 13, 20);
         this.sub_3fa(var1, var2 + 8, var3 + 10, 20, 1, 3);
      }

      if (this.var_4dd.var_1df.jobId == 511) {
         this.sub_3c7(var1, var2 + 11, var3 + 9, 3, 0, false);
      }

      if (this.var_4dd.var_1df.jobId == 767) {
         GameScreen.gameScreen.sub_240c(var1, var2, var3, 5, GameScreen.gameScreen.var_d5c.var_1c6, 35, false, (Image)null);
      }

      if (this.var_4dd.var_1df.jobId >= 4095) {
         GameScreen.gameScreen.sub_240c(var1, var2, var3, GameScreen.gameScreen.var_d5c.projectsArr[this.var_4dd.var_1df.jobId - 4095].sub_18d(28), GameScreen.gameScreen.var_d5c.var_1c6, 35, false, (Image)null);
      }

      if (this.var_4dd.var_1df.jobId < 255) {
         var1.drawImage(this.rHouseImg, var2 + 11, var3 + 13, 20);
      }

   }

   public void sub_35e(Graphics var1, int var2, int var3) {
      var1.setClip(var2, var3, 5, this.colBtnImg.getHeight());
      var1.drawImage(this.colBtnImg, var2, var3, 20);
      var1.setClip(var2, var3, this.colBtnImg.getWidth(), 2);
      var1.drawImage(this.colBtnImg, var2, var3, 20);
      var1.setClip(var2, var3 + this.colBtnImg.getHeight() - 2, this.colBtnImg.getWidth(), 2);
      var1.drawImage(this.colBtnImg, var2, var3, 20);
      var1.setClip(var2 + this.colBtnImg.getWidth() - 5, var3, 5, this.colBtnImg.getHeight());
      var1.drawImage(this.colBtnImg, var2, var3, 20);
      var1.setClip(0, 0, this.var_124, this.windowHeight);
   }

   public void sub_389(Graphics var1, int var2, int var3, int var4, int var5) {
      if (this.colBtnImg != null) {
         boolean var6 = true;
         var1.setClip(var2, var3, 30, 1);
         var1.drawImage(this.colBtnImg, var2, var3, 20);

         int var8;
         for(var8 = var2 + 30; var8 <= var2 + var4 - 30; var8 += 5) {
            var1.setClip(var8, var3, 5, 1);
            var1.drawImage(this.colBtnImg, var8 - 30, var3, 20);
         }

         var8 = var2 + var4 - 30;
         var1.setClip(var8, var3, 30, 1);
         var1.drawImage(this.colBtnImg, var8 - this.colBtnImg.getWidth() + 30, var3, 20);
         var1.setClip(var2, var3 + 1, 4, 10);
         var1.drawImage(this.colBtnImg, var2, var3, 20);
         var1.setClip(var2 + var4 - 4, var3 + 1, 4, 10);
         var1.drawImage(this.colBtnImg, var2 - this.colBtnImg.getWidth() + var4, var3, 20);
         var1.setClip(var2, var3 + var5 - 6, 4, 5);
         var1.drawImage(this.colBtnImg, var2, var3 + var5 - this.colBtnImg.getHeight(), 20);
         var1.setClip(var2 + var4 - 4, var3 + var5 - 6, 4, 5);
         var1.drawImage(this.colBtnImg, var2 - this.colBtnImg.getWidth() + var4, var3 + var5 - this.colBtnImg.getHeight(), 20);

         int var7;
         for(var7 = var3 + 10; var7 < var3 + var5 - 6; var7 += 2) {
            var1.setClip(var2, var7, 4, 2);
            var1.drawImage(this.colBtnImg, var2, var7 - 10, 20);
            var1.setClip(var2 + var4 - 4, var7, 4, 2);
            var1.drawImage(this.colBtnImg, var2 - this.colBtnImg.getWidth() + var4, var7 - 10, 20);
         }

         var7 = var3 + var5 - 1;
         var1.setClip(var2, var7, 30, 2);
         var1.drawImage(this.colBtnImg, var2, var7 - this.colBtnImg.getHeight() + 2, 20);

         for(var8 = var2 + 30; var8 <= var2 + var4 - 30; var8 += 5) {
            var1.setClip(var8, var7, 5, 2);
            var1.drawImage(this.colBtnImg, var8 - 30, var7 - this.colBtnImg.getHeight() + 2, 20);
         }

         var8 = var2 + var4 - 30;
         var1.setClip(var8, var7, 30, 2);
         var1.drawImage(this.colBtnImg, var8 - this.colBtnImg.getWidth() + 30, var7 - this.colBtnImg.getHeight() + 2, 20);
         var1.setClip(0, 0, this.var_124, this.windowHeight);
      }
   }

   public void sub_3a3(Graphics var1, int var2, int var3, int var4, boolean var5) {
      var1.setClip(var2, var3, 14, 14);
      int var6;
      if (var4 == 3) {
         var6 = var2;
         if (!var5) {
            var6 = var2 - 16;
         }

         var1.drawImage(this.btnBuildImg, var6, var3, 20);
      } else {
         var6 = var2 - 5 - var4 * 32;
         if (!var5) {
            var6 -= 16;
         }

         var1.drawImage(this.colBtnImg, var6, var3 - 2, 20);
      }

      var1.setClip(0, 0, this.var_124, this.windowHeight);
   }

   public void sub_3c7(Graphics var1, int var2, int var3, int var4, int var5, boolean var6) {
      var1.setClip(var2, var3, 14, 14);
      if (var4 == 10) {
         if (this.rShipImg != null) {
            var1.drawImage(this.rShipImg, var2, var3 + 4, 20);
         }
      } else {
         var1.drawImage(this.colPicImg, var2 - var4 * 14, var3, 20);
      }

      if (var6) {
         String var7 = "" + var5;
         if (var5 == 65535) {
            var7 = "Х";
         }

         if (this.menuId == 9 && var4 == 2) {
            var2 += 4;
         }

         GameScreen.gameScreen.drawFancyText(var1, var2 - var7.length() * 8 - 2, var3 + 5, var7, this.var_42f);
      }

      var1.setClip(0, 0, this.var_124, this.windowHeight);
   }

   public void sub_3fa(Graphics var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      for(var7 = 7; var7 * var5 > var4; --var7) {
      }

      for(int var8 = 0; var8 < var5; ++var8) {
         var1.setClip(var2 + var8 * var7, var3, 7, 14);
         var1.drawImage(this.peopleImg, var2 - var6 * 7 + var8 * var7, var3, 20);
      }

      var1.setClip(0, 0, this.var_124, this.windowHeight);
   }

   public void sub_442(Graphics var1, int var2, int var3) {
      int var4 = var2 + 12;
      boolean var5 = true;
      byte var7 = 1;

      int var6;
      for(var6 = 0; var6 < var7; ++var6) {
         var1.drawImage(this.curLeftImg, var4, var3, 20);
         var4 += 8;
      }

      var4 = this.var_124 - 12 - var2 - this.curLeftImg.getWidth();

      for(var6 = 0; var6 < var7; ++var6) {
         var1.drawImage(this.curRightImg, var4, var3, 20);
         var4 -= 8;
      }

      var4 = (this.var_124 - this.var_4dd.sub_96().length() * 8) / 2;
      GameScreen.gameScreen.drawFancyText(var1, var4, var3, this.var_4dd.sub_96(), this.var_42f);
   }

   public void sub_491(Graphics var1, int var2, int var3, int var4) {
      var1.setClip(var2, var3, 26, 11);
      var1.drawImage(this.blueLineImg, var2, var3, 20);
      int var5 = var2 + (var4 - 26);

      for(int var6 = var2 + 26; var6 < var5; var6 += 10) {
         var1.setClip(var6, var3, 10, 11);
         var1.drawImage(this.blueLineImg, var6 - 26, var3, 20);
      }

      var1.setClip(var5, var3, 26, 11);
      var1.drawImage(this.blueLineImg, var5 - this.blueLineImg.getWidth() + 26, var3, 20);
      var1.setClip(0, 0, this.var_124, this.windowHeight);
   }

   public void drawSomeBuildingMenu() {
      if (this.var_73e == null) {
         int var1 = this.var_124 - 118 - 5;
         if (var1 < (this.var_124 - 118) / 2) {
            var1 = (this.var_124 - 118) / 2;
         }

         this.var_73e = new Class_2e2(10, var1, (this.windowHeight - 104) / 2, 118, 104, 3158064);
         this.var_73e.var_4dd = this.var_4dd;
         this.var_73e.sub_2af("ПОСТРОИТЬ");
         this.var_73e.sub_4b(SomeUtilClass.getStr("ХАБАР"), 255);
         this.var_73e.sub_4b(SomeUtilClass.getStr("ТОРГОВЛЯ"), 511);
         this.var_73e.sub_4b(SomeUtilClass.getStr("ОТРЯД"), 767);

         int var2;
         for(var2 = 0; var2 < GameScreen.gameScreen.var_d5c.projectsArr.length; ++var2) {
            this.var_73e.sub_4b(GameScreen.gameScreen.var_d5c.projectsArr[var2].projectName, 4095 + var2);
         }

         for(var2 = 0; var2 < 31; ++var2) {
            if (!this.var_4dd.var_1df.sub_e3(var2) && GameScreen.gameScreen.var_d5c.sub_139(GameScreen.gameScreen.buildingDictArr[var2].var_1ed)) {
               this.var_73e.sub_4b(GameScreen.gameScreen.buildingDictArr[var2].var_11, var2);
            }
         }

         this.var_73e.sub_30d(this.var_4dd.var_1df.jobId);
      }
   }

   public void sub_505() {
      if (this.var_4dd.var_1df.jobId != 255 && this.var_4dd.var_1df.jobId != 511) {
         int var1 = this.var_4dd.var_1df.sub_385();
         if (GameScreen.gameScreen.var_d5c.var_f6 < var1) {
            this.var_b77 = new Class_4b3(6, 0, 0, 0, 0, 3158064, (Planet)null);
            this.var_b77.var_1f3 = this.var_b77.var_124;
            this.var_b77.var_26e = this.var_4dd.var_1df.getJobName();
            this.var_b77.addMenu2Option(-1, this.var_b77.yPos + 14, SomeUtilClass.getStr("ДЛЯ ПОКУПКИ"), false);
            this.var_b77.addMenu2Option(-1, this.var_b77.yPos + 14 + 7, SomeUtilClass.getStr("НАДО ") + var1 + "MК", false);
         } else {
            this.var_b77 = new Class_4b3(12, 0, 0, 0, 0, 3158064, (Planet)null);
            this.var_b77.var_1f3 = this.var_b77.var_124;
            this.var_b77.var_26e = this.var_4dd.var_1df.getJobName();
            this.var_b77.addMenu2Option(-1, this.var_b77.yPos + 15, SomeUtilClass.getStr("ПРИОБРЕСТИ"), false);
            this.var_b77.addMenu2Option(-1, this.var_b77.yPos + 22, SomeUtilClass.getStr("ЗА") + var1 + "МК" + "?", false);
         }
      }
   }

   public void sub_514(Graphics var1, int var2, int var3, int var4, int var5) {
      var1.setColor(2171169);
      var1.fillRect(var2, var3, var4, var5);
      var1.setColor(789516);
      var1.drawLine(var2 + 1, var3 + 1, var2 + var4 - 1, var3 + 1);
      var1.setColor(1315860);
      var1.drawLine(var2 + 1, var3 + 2, var2 + 1, var3 + var5 - 2);
      var1.setColor(1776411);
      var1.drawLine(var2 + 2, var3 + 1, var2 + var4 - 1, var3 + 1);
      var1.setColor(1973790);
      var1.drawLine(var2 + 3, var3 + 2, var2 + 3, var3 + var5 - 2);
      var1.setColor(9868950);
      var1.drawLine(var2 + 1, var3 + var5, var2 + var4, var3 + var5);
      var1.setColor(5855577);
      var1.drawLine(var2 + 2, var3 + var5 - 1, var2 + var4, var3 + var5 - 1);
      var1.setColor(4144959);
      var1.drawLine(var2 + var4 - 1, var3 + 3, var2 + var4 - 1, var3 + var5 - 2);
      var1.setColor(5658198);
      var1.drawLine(var2 + var4, var3 + 2, var2 + var4, var3 + var5 - 2);
   }

   public void drawColonyInfoBg(Graphics var1, int var2, int var3, int var4, int var5) {
      var1.setColor(this.planetInfoMenuBgColor);
      var1.fillRect(var2 + 10, var3, var5 - 20, var4 - 3);
      int var6 = var3 + var4 - this.txtListImg.getHeight();
      var1.setClip(var2, var6, 17, this.txtListImg.getHeight());
      var1.drawImage(this.txtListImg, var2, var6, 20);

      for(int var7 = var2 + 17; var7 < var2 + var5 - 17 - 2; var7 += 8) {
         var1.setClip(var7, var6 + this.txtListImg.getHeight() - 3, 8, 7);
         var1.drawImage(this.txtListImg, var7 - 13, var6, 20);
      }

      var1.setClip(var2 + var5 - 17, var6, 17, this.txtListImg.getHeight());
      var1.drawImage(this.txtListImg, var2 + var5 - 17 - 17, var6, 20);

      for(var6 -= 12; var6 > -12; var6 -= 12) {
         var1.setClip(var2, var6, 10, 12);
         var1.drawImage(this.txtListImg, var2, var6, 20);
         var1.setClip(var2 + var5 - 10, var6, 10, 12);
         var1.drawImage(this.txtListImg, var2 + var5 - 10 - 24, var6, 20);
      }

      var1.setClip(0, 0, this.var_124, this.windowHeight);
   }

   public void sub_593(Graphics var1) {
      byte var2 = 20;
      if (this.windowHeight < 128) {
         var2 = 16;
      }

      byte var3 = 0;
      if (this.var_1f3 < this.var_e96) {
         this.var_1f3 += 20;
      }

      if (this.var_1f3 > this.var_e96) {
         this.var_1f3 = this.var_e96;
      }

      int var7 = var3 - this.var_e96 + this.var_1f3;
      Graphics g;
      int var5;
      int var6;
      if (this.var_c28 == null) {
         this.var_c28 = Image.createImage(this.var_e96 + 8, this.var_e96 + 22);
         g = this.var_c28.getGraphics();
         g.setColor(0);
         g.fillRect(0, 0, this.var_e96 + 8, this.var_e96 + 22);
         this.sub_788(g, 0, 0, this.var_e96 + 8, this.var_e96 + 22);
         g.setColor(2171169);
         g.drawRect(1, 10, this.var_e96, this.var_e96);
         g.setStrokeStyle(1);
         var5 = this.var_e96 / 2 + 1;
         var6 = this.var_e96 / 2 + 9;
         g.drawLine(var5, 10, var5, this.var_e96 + 10);
         g.drawLine(1, var6, 1 + this.var_e96, var6);
         var5 = this.var_e96 / 4 + 1;
         var6 = this.var_e96 / 4 + 9;
         g.drawLine(var5, 10, var5, this.var_e96 + 10);
         g.drawLine(1, var6, this.var_e96 + 1, var6);
         var5 += this.var_e96 / 2;
         var6 += this.var_e96 / 2;
         g.drawLine(var5, 10, var5, this.var_e96 + 10);
         g.drawLine(1, var6, this.var_e96 + 1, var6);
      } else {
         var1.drawImage(this.var_c28, var7, var2, 20);
      }

      var7 += 2;
      int var8 = var2 + 10;
      g = null;

      for(var6 = 0; var6 < GameScreen.gameScreen.planetsArr.size(); ++var6) {
         Planet var9 = (Planet)GameScreen.gameScreen.planetsArr.elementAt(var6);
         if (this.var_b81 == 0 && this.var_6f5.nextInt() % 15 == 1) {
            this.var_b81 = var9.planetCoords;
         }

         if (var9.sub_150(GameScreen.gameScreen.var_d5c.var_1c6)) {
            if (var9.var_1df == null) {
               var5 = 16777215;
            } else {
               var5 = GameScreen.gameScreen.sub_121c(var9.var_1df.var_4f);
            }
         } else {
            var5 = 16777215;
         }

         if (var5 != 16777215) {
            this.sub_639(var1, var7 + var9.getXAbsoluteSector() * this.var_efa, var8 + var9.getYAbsoluteSector() * this.var_efa, var5, this.var_efa, var9.getXAbsoluteSector() == GameScreen.gameScreen.someXCellPos && var9.getYAbsoluteSector() == GameScreen.gameScreen.someYCellPos, var9.planetCoords == this.var_b81);
         } else {
            this.sub_689(var1, var7 + var9.getXAbsoluteSector() * this.var_efa, var8 + var9.getYAbsoluteSector() * this.var_efa, var5, this.var_efa, var9.getXAbsoluteSector() == GameScreen.gameScreen.someXCellPos && var9.getYAbsoluteSector() == GameScreen.gameScreen.someYCellPos, var9.planetCoords == this.var_b81);
         }
      }

      if (this.var_1f3 == this.var_e96) {
         this.sub_69b(var1, 5, var8 + this.var_e96 + 13);
      }

      if (this.var_b77 != null) {
         this.var_b77.sub_108(var1);
      }

   }

   public void sub_5de(Graphics var1, int var2, int var3, byte var4) {
      while(var4 > 0) {
         this.sub_639(var1, var2, var3, 16776960, 3, false, false);
         --var4;
         var2 -= 6;
      }

   }

   public void sub_639(Graphics var1, int var2, int var3, int var4, int var5, boolean var6, boolean var7) {
      int var8 = 0;
      if (var7) {
         this.var_bdb += 10;
         if (this.var_bdb > 100) {
            var8 = 200 - this.var_bdb;
         } else {
            var8 = this.var_bdb;
         }

         if (this.var_bdb > 200) {
            this.var_bdb = 0;
            this.var_b81 = 0;
         }
      }

      if (var7) {
         var1.setColor(this.sub_6c9(var4, 120 - var8));
      } else {
         var1.setColor(this.sub_6c9(var4, 120));
      }

      var1.drawLine(var2, var3 - 3, var2, var3 + 3);
      var1.drawLine(var2 - 3, var3, var2 + 3, var3);
      var1.setColor(this.sub_6c9(var4, 120));
      var1.drawLine(var2 - 1, var3 - 1, var2 + 1, var3 + 1);
      var1.drawLine(var2 + 1, var3 - 1, var2 - 1, var3 + 1);
      if (var7) {
         var1.setColor(this.sub_6c9(var4, -var8));
      } else {
         var1.setColor(var4);
      }

      var1.drawLine(var2, var3 - 2, var2, var3 + 2);
      var1.drawLine(var2 - 2, var3, var2 + 2, var3);
      if (var7) {
         var1.setColor(this.sub_6c9(var4, -100 - var8));
      }

      var1.setColor(this.sub_6c9(var4, -100));
      var1.drawLine(var2, var3 - 1, var2, var3 + 1);
      var1.drawLine(var2 - 1, var3, var2 + 1, var3);
      var1.setColor(16777215);
      var1.drawLine(var2, var3, var2, var3);
      if (var6) {
         var1.drawImage(GameScreen.gameScreen.ugolImgArr[0], var2 - 3, var3 - 3, 20);
         var1.drawImage(GameScreen.gameScreen.ugolImgArr[2], var2 - 2, var3 - 2, 20);
      }

   }

   public void sub_689(Graphics var1, int var2, int var3, int var4, int var5, boolean var6, boolean var7) {
      boolean var8 = false;
      if (var7) {
         this.var_bdb += 10;
         int var9;
         if (this.var_bdb > 100) {
            var9 = 200 - this.var_bdb;
         } else {
            var9 = this.var_bdb;
         }

         if (this.var_bdb > 200) {
            this.var_bdb = 0;
            this.var_b81 = 0;
         }

         if (var9 > 50) {
            var1.setColor(this.sub_6c9(this.sub_6c9(this.sub_6c9(var4, 100), 100), 100 - var9));
            var1.drawLine(var2, var3 - 3, var2, var3 + 3);
            var1.drawLine(var2 - 3, var3, var2 + 3, var3);
         }

         var1.setColor(this.sub_6c9(this.sub_6c9(var4, 100), 100 - var9));
         var1.drawLine(var2, var3 - 2, var2, var3 + 2);
         var1.drawLine(var2 - 2, var3, var2 + 2, var3);
         var1.setColor(this.sub_6c9(this.sub_6c9(var4, 100), 100));
         var1.drawLine(var2 - 1, var3 - 1, var2 + 1, var3 + 1);
         var1.drawLine(var2 + 1, var3 - 1, var2 - 1, var3 + 1);
         var1.setColor(this.sub_6c9(var4, 100 - var9));
         var1.drawLine(var2, var3 - 1, var2, var3 + 1);
         var1.drawLine(var2 - 1, var3, var2 + 1, var3);
         var1.setColor(this.sub_6c9(var4, -var9));
         var1.drawLine(var2, var3, var2, var3);
      } else {
         var1.drawImage(GameScreen.gameScreen.var_1421[0], var2 - 2, var3 - 2, 20);
      }

      if (var6) {
         var1.drawImage(GameScreen.gameScreen.ugolImgArr[0], var2 - 3, var3 - 3, 20);
         var1.drawImage(GameScreen.gameScreen.ugolImgArr[2], var2 - 2, var3 - 2, 20);
      }

   }

   public void sub_69b(Graphics var1, int var2, int var3) {
      Planet var4 = GameScreen.gameScreen.sub_76d(GameScreen.gameScreen.someXCellPos, GameScreen.gameScreen.someYCellPos);
      if (var4 != null && var4.var_1df != null && var4.sub_150(GameScreen.gameScreen.var_d5c.var_1c6) && var4.var_1df.sub_184()) {
         var1.drawImage(this.artefact, this.var_e96 - 8, var3 + 4, 20);
      }

      int var5 = GameScreen.gameScreen.sub_1592(GameScreen.gameScreen.someXCellPos, GameScreen.gameScreen.someYCellPos);
      if (var5 != 0) {
         Class_4f2 var6 = GameScreen.gameScreen.sub_1648(1);
         if (var6 != null) {
            if (var6.var_27d) {
               var2 += 7;
               if (var5 > 9) {
                  var2 += 7;
               }

               if (var5 > 99) {
                  var2 += 7;
               }

               this.sub_3c7(var1, var2, var3, 10, var5, true);
               SomeUtilClass.drawSomeLittleFigure(var1, var2, var3 + 4, GameScreen.gameScreen.sub_121c(var6.sub_236()));
            }

         }
      }
   }

   public int sub_6c9(int var1, int var2) {
      return SomeUtilClass.sub_28f(var1, var2);
   }

   public void sub_72d(Graphics g2) {
      int var2 = this.var_124 - this.var_e96;
      int var3 = (this.windowHeight - this.var_b2b * 30 - 18) / 2;
      if (this.var_1f3 < this.var_e96) {
         this.var_1f3 += 20;
      }

      if (this.var_1f3 > this.var_e96) {
         this.var_1f3 = this.var_e96;
      }

      var2 = var2 + this.var_e96 - this.var_1f3;
      int var5;
      int var6;
      int var7;
      if (this.var_c28 == null) {
         this.var_c28 = Image.createImage(this.var_e96, this.var_b2b * 30 + 18);
         Graphics g = this.var_c28.getGraphics();
         g.setColor(0);
         g.fillRect(0, 0, this.var_e96, this.var_b2b * 30 + 18);
         g.setColor(1052688);
         g.fillRect(4, 9, this.var_e96 - 5, this.var_b2b * 30);
         this.sub_7e4(g, 0, 0, this.var_e96, this.var_b2b * 30 + 18);
         g.setColor(2171169);
         var5 = 4;

         for(var6 = 1; var6 <= this.var_cbe; ++var6) {
            var5 += 30;
            g.drawLine(var5, 9, var5, this.var_b2b * 30 + 8);
         }

         var6 = 9;

         for(var7 = 1; var7 < this.var_b2b; ++var7) {
            var6 += 30;
            g.drawLine(4, var6, this.var_e96 - 8, var6);
         }
      } else {
         g2.drawImage(this.var_c28, var2, var3, 20);
      }

      var5 = var3 + 9;

      int var8;
      Class_4f2 var11;
      for(var7 = this.var_368; var7 < this.var_b2b + this.var_368; ++var7) {
         var8 = var2 + 4;

         for(int var9 = 0; var9 < this.var_cbe; ++var9) {
            var6 = var7 * this.var_cbe + var9 + 1;
            if (var6 > this.var_caf) {
               break;
            }

            var11 = GameScreen.gameScreen.sub_135b(this.var_53a.var_1c6, var6);
            if (this.var_3c8 + 1 == var6) {
               g2.drawImage(GameScreen.gameScreen.selShipImg, var8 + 1, var5 + 1, 20);
               g2.setColor(0);
               g2.fillRect(var8 + 2, var5 + 2, 26, 26);
               if (var11 != null) {
                  GameScreen.gameScreen.someXCellPos = var11.sub_309();
                  GameScreen.gameScreen.someYCellPos = var11.sub_31a();
               }
            }

            if (var11 != null) {
               int var10 = var11.sub_18d(28);
               GameScreen.gameScreen.sub_240c(g2, var8, var5, var10, var11.sub_236(), 30, var11.sub_599(), (Image)null);
               GameScreen.gameScreen.sub_fcf(g2, var8 + 3, var5 + 3, "" + var11.sub_264(), GameScreen.gameScreen.rMiniFrontImg);
               this.sub_73d(g2, var8 + 4, var5 + 26, var11.var_195);
               this.sub_5de(g2, var8 + 24, var5 + 5, var11.var_1ef);
               if (var11.sub_105()) {
                  GameScreen.gameScreen.sub_fcf(g2, var8 + 5, var5 + 19, SomeUtilClass.getStr("А"), GameScreen.gameScreen.rMiniFrontImg);
               }

               if (this.var_d47 == 1 && this.var_3c8 + 1 == var6) {
                  g2.setClip(var8 + 4, var5 + 17, 13, 7);
                  if (var11.sub_6f2((Class_4f2)this.var_57d)) {
                     g2.drawImage(this.var_d8e, var8 + 4, var5 + 17, 20);
                  } else {
                     g2.drawImage(this.var_d8e, var8 + 4, var5 + 17 - 7, 20);
                  }

                  g2.setClip(0, 0, this.var_124, this.windowHeight);
               }
            }

            var8 += 30;
         }

         var5 += 30;
      }

      var7 = this.var_caf / this.var_cbe;
      if (var7 * this.var_cbe < this.var_caf) {
         ++var7;
      }

      if (var7 > this.var_b2b) {
         g2.drawImage(this.curUpImg, var2 + this.var_e96 - 6, var3 + 11, 20);
         g2.drawImage(this.curDownImg, var2 + this.var_e96 - 6, var3 + this.var_b2b * 30 + 4, 20);
         var8 = this.var_368 * (this.var_b2b * 30 - 18) / (var7 - this.var_b2b);
         g2.drawImage(this.polImg, var2 + this.var_e96 - 6, var3 + var8 + 9 + 7, 20);
      }

      var11 = this.sub_74f();
      this.sub_806(g2, var11, true);
      if (var11 != null) {
         var2 = this.var_124 - this.var_cf7;
         if (this.var_cf7 - this.var_1f3 > 0) {
            var2 = var2 + this.var_cf7 - this.var_1f3;
         }

         g2.setColor(0);
         g2.fillRect(var2, var3 + this.var_cea, this.var_cf7, 20);
         this.sub_878(g2, var2, var3 + this.var_cea, this.var_cf7);
         GameScreen.gameScreen.sub_fcf(g2, var2 + 7, var3 + this.var_cea + 8, var11.sub_64d(), GameScreen.gameScreen.rMiniFront2Img);
      }

      if (this.var_b77 != null) {
         this.var_b77.sub_108(g2);
      }

   }

   public void sub_73d(Graphics var1, int var2, int var3, byte var4) {
      if (var4 <= 30) {
         var1.setColor(0, 255, 0);
      } else if (var4 > 30 & var4 <= 60) {
         var1.setColor(255, 255, 0);
      } else if (var4 > 60) {
         var1.setColor(255, 0, 0);
      }

      int var5 = 21 * (100 - var4) / 100;
      var1.drawLine(var2, var3, var2 + var5, var3);
   }

   public Class_4f2 sub_74f() {
      return GameScreen.gameScreen.sub_135b(this.var_53a.var_1c6, this.var_3c8 + 1);
   }

   public void sub_788(Graphics var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 + var4 - 48;
      var1.setClip(var6, var3, 48, 9);
      var1.drawImage(this.rPanelImg, var6 - this.rPanelImg.getWidth() + 48, var3, 20);
      var1.setClip(var6, var3 + var5 - 9, 50, 9);
      var1.drawImage(this.rPanelImg, var6 - this.rPanelImg.getWidth() + 48, var3 + var5 - this.rPanelImg.getHeight(), 20);

      while(var6 > var2 - 4) {
         var1.setClip(var6, var3, 4, 9);
         var1.drawImage(this.rPanelImg, var6 - 45, var3, 20);
         var1.setClip(var6, var3 + var5 - 9, 4, 9);
         var1.drawImage(this.rPanelImg, var6 - 45, var5 + var3 - this.rPanelImg.getHeight(), 20);
         var6 -= 4;
      }

      for(int var7 = var3 + 9; var7 < var3 + var5 - 9; var7 += 3) {
         var1.setClip(var2 + var4 - 4, var7, 4, 3);
         var1.drawImage(this.rPanelImg, var2 + var4 - this.rPanelImg.getWidth(), var7 - 13, 20);
      }

      var1.setClip(0, 0, this.var_124, this.windowHeight);
   }

   public void sub_7e4(Graphics var1, int var2, int var3, int var4, int var5) {
      var1.setClip(var2, var3, 48, 9);
      var1.drawImage(this.rPanelImg, var2, var3, 20);
      var1.setClip(var2, var3 + var5 - 9, 48, 9);
      var1.drawImage(this.rPanelImg, var2, var3 + var5 - this.rPanelImg.getHeight(), 20);

      for(int var6 = var2 + 48; var6 <= var2 + var4; var6 += 4) {
         var1.setClip(var6, var3, 4, 9);
         var1.drawImage(this.rPanelImg, var6 - 45, var3, 20);
         var1.setClip(var6, var3 + var5 - 9, 4, 9);
         var1.drawImage(this.rPanelImg, var6 - 45, var5 + var3 - this.rPanelImg.getHeight(), 20);
      }

      for(int var7 = var3 + 9; var7 < var3 + var5 - 9; var7 += 3) {
         var1.setClip(var2, var7, 4, 3);
         var1.drawImage(this.rPanelImg, var2, var7 - 13, 20);
      }

      var1.setClip(0, 0, this.var_124, this.windowHeight);
   }

   public void sub_806(Graphics var1, Class_4f2 var2, boolean var3) {
      int var4 = GameScreen.gameScreen.var_8e4 + 5;
      if (this.menuId == 10 && this.windowHeight < 160) {
         var4 -= 2;
      }

      if (var3 && var2 != null) {
         GameScreen.gameScreen.sub_10f9(var1, 0, var4, this.var_cd3, 13, 880901, 3);
         if (this.var_cd3 < 120) {
            this.var_cd3 += 20;
         }

         if (this.var_cd3 == 120) {
            String var5 = var2.sub_1af() + " " + var2.sub_264();
            GameScreen.gameScreen.drawFancyText(var1, 120 - var5.length() * 8 - 10, var4 + 3, var5, this.var_42f);
            GameScreen.gameScreen.sub_fcf(var1, 1, var4 + 5, SomeUtilClass.getStr("ИМЯ"), GameScreen.gameScreen.rMiniFront2Img);
         }
      } else if (this.var_cd3 > 0) {
         GameScreen.gameScreen.sub_10f9(var1, 0, var4, this.var_cd3, 13, 880901, 3);
         this.var_cd3 -= 20;
      }

   }

   public void sub_82c(Graphics var1, int var2, int var3, int var4) {
      var1.setColor(3092013);
      var1.drawLine(var2, var3, var2, var3 + 11);
      var1.drawLine(var2, var3, var4, var3);
      var1.setColor(10066070);
      var1.drawLine(var2 + 1, var3 + 11, var4, var3 + 11);
      var1.setColor(11250084);
      var1.drawLine(var4 + 1, var3 + 1, var4 + 1, var3 + 11);
      var1.setColor(6381403);
      var1.drawLine(var2 + 1, var3 + 1, var2 + 1, var3 + 11);
      var1.setColor(5460302);
      var1.drawLine(var2 + 1, var3 + 1, var4, var3 + 1);
   }

   public void sub_878(Graphics var1, int var2, int var3, int var4) {
      var1.drawImage(this.tubaImg, var2, var3, 20);

      for(int var5 = var2 + 3; var5 < var4 + var2 - 3; var5 += 2) {
         var1.setClip(var5, var3, 2, 4);
         var1.drawImage(this.tubaImg, var5 - 1, var3, 20);
         var1.setClip(var5, var3 + 16, 2, 4);
         var1.drawImage(this.tubaImg, var5 - 1, var3, 20);
      }

      var1.setClip(var2 + var4 - 3, var3, 3, 20);
      var1.drawImage(this.tubaImg, var2 + var4 - 4, var3, 20);
      var1.drawImage(this.tubaImg, var2 + var4 - 1, var3, 20);
      var1.setClip(0, 0, GameScreen.gameScreen.getWidth(), GameScreen.gameScreen.getHeight());
      this.sub_82c(var1, var2 + 3, var3 + 4, var2 + var4 - 5);
   }

   public void sub_8d8(Graphics var1, int var2, int var3, int var4, Image var5) {
      int var6 = var2 + 5;

      do {
         if (var4 < 5) {
            var1.setClip(var6, var3 + 6, var4, 9);
         } else {
            var1.setClip(var6, var3 + 6, 5, 9);
         }

         var1.drawImage(var5, var6 - 25, var3 + 6, 20);
         var4 -= 5;
         var6 += 5;
      } while(var4 > 0);

      var1.setClip(0, 0, GameScreen.gameScreen.getWidth(), GameScreen.gameScreen.getHeight());
   }

   public void sub_918(Graphics var1) {
      int var2 = this.var_124 - this.var_e96;
      int var3 = this.yPos;
      if (this.var_1f3 < this.var_e96) {
         if (this.var_b03) {
            this.var_1f3 -= 20;
         } else {
            this.var_1f3 += 20;
         }
      }

      if (this.var_1f3 > this.var_e96) {
         this.var_1f3 = this.var_e96;
         if (!this.var_b64) {
            this.var_b03 = true;
         } else {
            this.var_caf = 30;
         }
      }

      if (this.var_1f3 == this.var_e96 && !this.var_b64) {
         ++this.var_caf;
         if (this.var_caf > 10) {
            --this.var_1f3;
         }
      }

      var2 = var2 + this.var_e96 - this.var_1f3;
      Graphics var4;
      if (this.var_c28 == null) {
         this.var_c28 = Image.createImage(this.var_e96, 30);
         var4 = this.var_c28.getGraphics();
         this.drawNextDateWindow(var4, 0, 0, 30);
      } else if (!this.var_b64) {
         var1.drawImage(this.var_c28, var2, var3, 20);
      } else if (this.var_caf >= 30) {
         this.var_caf += 20;
         if (this.var_caf >= this.var_b81) {
            this.var_caf = this.var_b81;
            if (this.var_c28.getHeight() != this.var_caf) {
               this.var_c28 = Image.createImage(this.var_e96, this.var_caf);
               var4 = this.var_c28.getGraphics();
               this.drawNextDateWindow(var4, 0, 0, this.var_caf);
               this.colBtnImg = this.sub_988();
            }

            var1.drawImage(this.var_c28, var2, var3, 20);
            int var6 = this.var_c28.getHeight() - 25 - 11;
            var1.setClip(var2 + 5, var3 + 26, this.var_c28.getWidth() - 5, var6);
            var1.drawImage(this.colBtnImg, var2 + 5, var3 + 26 - this.var_368, 20);
            var1.setClip(0, 0, GameScreen.gameScreen.getWidth(), GameScreen.gameScreen.getHeight());
            if (this.colBtnImg.getHeight() > var6) {
               int var5 = var6 - 10 - 5;
               var5 = this.var_368 * var5 / (this.colBtnImg.getHeight() - var6);
               var1.drawImage(this.polImg, var2 + this.var_e96 - 6, var3 + 26 + 4 + var5, 20);
            }
         } else {
            this.drawNextDateWindow(var1, var2, var3, this.var_caf);
         }
      } else {
         var1.drawImage(this.var_c28, var2, var3, 20);
      }

   }

   public void drawNextDateWindow(Graphics g, int xPos, int yPos, int height) {
      g.setColor(0);
      g.fillRect(xPos, yPos, this.var_e96, height);
      g.setColor(1052688);
      g.fillRect(xPos + 4, yPos + 9, this.var_e96 - 4, height - 18);
      this.sub_7e4(g, xPos, yPos, this.var_e96, height);
      GameScreen.gameScreen.drawFancyText(g, xPos + 8, yPos + 11, GameScreen.gameScreen.gameCurrentMonth + "." + GameScreen.gameScreen.gameCurrentYear, this.var_42f);
      if (height > 30) {
         g.setColor(0);
         int var5 = yPos + 21;
         g.drawLine(xPos + 4, var5, xPos + this.var_e96, var5);
         ++var5;
         g.setColor(3618872);
         g.drawLine(xPos + 4, var5, xPos + this.var_e96, var5);
         ++var5;
         g.setColor(5329490);
         g.drawLine(xPos + 4, var5, xPos + this.var_e96, var5);
         ++var5;
         g.setColor(2171169);
         g.drawLine(xPos + this.var_e96 - 7, var5, xPos + this.var_e96 - 7, yPos + height - 10);
         g.drawImage(this.curUpImg, xPos + this.var_e96 - 6, var5 + 1, 20);
         g.drawImage(this.curDownImg, xPos + this.var_e96 - 6, yPos + height - 10 - 4, 20);
      }

   }

   public Image sub_988() {
      int var1 = 5;
      int var2 = this.var_e96 - 8 - 5 - 19;

      int var10001;
      GameScreen var10002;
      for(int var3 = 0; var3 < this.var_53a.sub_6d1(); ++var3) {
         var10001 = SomeUtilClass.sub_1a5(this.var_53a.sub_777(var3), var2);
         var10002 = GameScreen.gameScreen;
         var1 += var10001 * (5 + 4);
         var1 += 3;
      }

      Image var7 = Image.createImage(var2 + 19, var1);
      Graphics var4 = var7.getGraphics();
      var4.setColor(1052688);
      var4.fillRect(0, 0, var2 + 19, var1);
      int var5 = 5;

      for(int var6 = 0; var6 < this.var_53a.sub_6d1(); ++var6) {
         this.sub_9a1(var4, 2, var5 - 3, this.var_53a.sub_72c(var6));
         SomeUtilClass.sub_1db(var4, this.var_53a.sub_777(var6), 19, var5, var2 + 19, var1);
         var10001 = SomeUtilClass.sub_1a5(this.var_53a.sub_777(var6), var2);
         var10002 = GameScreen.gameScreen;
         var5 += var10001 * (5 + 4);
         var5 += 3;
      }

      return var7;
   }

   public void sub_9a1(Graphics var1, int var2, int var3, int var4) {
      switch(var4) {
      case 1:
         var1.drawImage(this.rsocImg, var2, var3, 20);
         break;
      case 2:
      case 3:
      case 4:
      case 10:
      case 30:
      case 31:
         var1.setClip(var2, var3, 12, 13);
         var1.drawImage(this.infoImg, var2 - 12, var3, 20);
         var1.setClip(0, 0, GameScreen.gameScreen.getWidth(), GameScreen.gameScreen.getHeight());
         break;
      case 5:
         var1.drawImage(this.rShipImg, var2, var3 + 2, 20);
         break;
      case 6:
         var1.drawImage(this.rHouseImg, var2, var3, 20);
         break;
      case 7:
      case 8:
      case 9:
      case 20:
      case 21:
      case 22:
         var1.setClip(var2, var3, 12, 13);
         var1.drawImage(this.infoImg, var2, var3, 20);
         var1.setClip(0, 0, GameScreen.gameScreen.getWidth(), GameScreen.gameScreen.getHeight());
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      }

   }

   public void drawMainMenu(Graphics g) {
      this.windowHeight = GameScreen.gameScreen.getHeight();
      g.setColor(0);
      g.fillRect(0, 0, this.var_124, this.windowHeight);
      if (Stars.var_b9) {
         g.drawImage(this.infoImg, 0, 0, 20);
      }

      int mainMenuHeight = this.sub_a89() * 10 + 18;//высота главного меню
      int xPos = (this.var_124 - this.menuWidth) / 2;//позиция главного меню по икс
      int yPos = (this.windowHeight - mainMenuHeight) / 2;//позиция главного меню по игрек
      yPos -= 7;
      this.var_caf = 300 + yPos;
      yPos = yPos - this.var_caf + this.var_1f3;
      if (this.var_1f3 < this.var_caf) {
         this.var_1f3 += 5;
      }

      if (yPos + mainMenuHeight > 0) {
         this.var_b03 = true;
      }

      if (GameScreen.gameScreen.var_1730) {
         this.sub_b76(g);
      } else if (GameScreen.gameScreen.var_173f) {
         this.sub_bbd(g);
      } else if (GameScreen.gameScreen.var_1759 > 0) {
         SomeUtilClass.sub_1db(g, GameScreen.gameScreen.var_1807, 5, this.windowHeight - GameScreen.gameScreen.var_1759, this.var_124 - 5, this.windowHeight + 10);
      } else {
         this.drawMainMenuBackground(g);
         if (this.var_b77 != null) {
            this.var_b77.sub_108(g);
         } else {
            if (this.var_b03) {
               this.drawMainMenu(g, xPos, yPos, this.menuWidth, mainMenuHeight);
            }

         }
      }
   }

   public void drawMainMenu(Graphics g, int xPos, int yPos, int mainMenuLength, int mainMenuHeight) {//походу рисует главное меню
      g.setColor(1052688);
      g.fillRect(xPos + 4, yPos + 9, mainMenuLength - 8, mainMenuHeight - 18);
      this.sub_7e4(g, xPos, yPos, mainMenuLength - 45, mainMenuHeight);
      this.sub_788(g, xPos + mainMenuLength - 45, yPos, 45, mainMenuHeight);
      this.sub_aeb(g, xPos + 4, yPos + 9, mainMenuLength - 8);
   }

   public int sub_a89() {//возвращает количество пунктов главного меню
      return this.menuOptions2Arr == null ? 0 : this.menuOptions2Arr.size();
   }

   public void sub_aeb(Graphics var1, int var2, int var3, int var4) { //точно рисует текст главного меню
      int var5 = var3;
      if (this.menuOptions2Arr != null) {
         for(int var8 = 0; var8 < this.menuOptions2Arr.size(); ++var8) {
            MenuOptionDto var6 = (MenuOptionDto)this.menuOptions2Arr.elementAt(var8);
            int var7 = var2 + (var4 - var6.str.length() * 8) / 2; //вроде как откуда начинать рисовать по оси Х
            if (this.var_3c8 == var8) {
               this.sub_8d8(var1, var2 - 4, var5 - 6, var4 - 2, this.blueLineImg);
            }

            GameScreen.gameScreen.drawFancyText(var1, var7, var5 + 1, var6.str, this.var_42f);
            var5 += 10;
            var1.setColor(2171169);
            var1.drawLine(var2, var5 - 1, var2 + var4 - 1, var5 - 1);
         }

      }
   }

   public void drawMainMenuBackground(Graphics g) {
      int curYPos = this.windowHeight - 52;
      curYPos = this.windowHeight - 43;
      int curXpos = (this.var_124 - GameScreen.gameScreen.gameLogoMainImg.getWidth()) / 2;
      g.drawImage(GameScreen.gameScreen.gameLogoMainImg, curXpos, curYPos, 20);
//      if (GameScreen.gameScreen.ltitulImg != null) {
//         curYPos += 28;
//         curXpos = (this.var_124 - GameScreen.gameScreen.ltitulImg.getWidth()) / 2;
//         g.drawImage(GameScreen.gameScreen.ltitulImg, curXpos, curYPos, 20);
//         curYPos += 5;
//         curXpos = (this.var_124 - GameScreen.gameScreen.gameLogoSecondary.getWidth()) / 2;
//         g.drawImage(GameScreen.gameScreen.gameLogoSecondary, curXpos, curYPos, 20);
//      }
      byte var4 = 5;
      curXpos = (this.var_124 - GameScreen.gameScreen.devLogoImg.getWidth()) / 2;
      g.drawImage(GameScreen.gameScreen.devLogoImg, curXpos, var4, 20);
   }

   public void sub_b76(Graphics var1) {
      String var2 = SomeUtilClass.getStr("ЛЕГЕНДЫ ЗОНЫ");
      int var3 = (this.var_124 - var2.length() * 8) / 2;
      boolean var4 = true;
      byte var9 = 15;
      GameScreen.gameScreen.drawFancyText(var1, var3, var9, var2, this.var_42f);
      int var10 = var9 + 20;
      boolean var7 = true;

      for(int var5 = 0; var5 < GameScreen.gameScreen.var_164f.length - 1; ++var5) {
         boolean var6 = false;
         if (GameScreen.gameScreen.var_164f[var5].someInt2 > 0) {
            int var11 = GameScreen.gameScreen.var_164f[var5].someInt2;
            var2 = var5 + 1 + ". " + GameScreen.gameScreen.var_164f[var5].someStr;
         } else {
            var2 = var5 + 1 + ". " + SomeUtilClass.getStr("ПУСТО");
         }

         byte var8 = 5;
         GameScreen.gameScreen.drawFancyText(var1, var8, var10, var2, this.var_42f);
         var2 = "" + GameScreen.gameScreen.var_164f[var5].someInt2;
         var3 = this.var_124 - 5 - var2.length() * 8;
         GameScreen.gameScreen.drawFancyText(var1, var3, var10, var2, this.var_42f);
         var10 += 11;
         if (var10 >= this.windowHeight - 11) {
            break;
         }
      }

   }

   public void sub_bbd(Graphics var1) {
      String var2 = SomeUtilClass.getStr("ОТПРАВИТЬСЯ В ЗОНУ");
      int var3 = (this.var_124 - var2.length() * 8) / 2;
      byte var4 = 5;
      GameScreen.gameScreen.drawFancyText(var1, var3, var4, var2, this.var_42f);
      GameScreen.gameScreen.drawFancyText(var1, 4, this.windowHeight - 10, SomeUtilClass.getStr("НАЗАД"), this.var_42f);
      var2 = SomeUtilClass.getStr("ДАЛЕЕ");
      var3 = this.var_124 - var2.length() * 8 - 4;
      GameScreen.gameScreen.drawFancyText(var1, var3, this.windowHeight - 10, var2, this.var_42f);
      int var5 = this.var_124 - 5;
      this.var_bdb += 10;
      if (this.var_bdb >= var5) {
         this.var_bdb = var5;
      }

      var3 = 0 - var5 + this.var_bdb;
      int var6 = (this.windowHeight - 94) / 2;
      this.sub_c15(var1, var3, var6, var5);
   }

   public void sub_c15(Graphics var1, int var2, int var3, int var4) {
      byte var5 = 94;
      String var6 = "";
      var1.setColor(1052688);
      var1.fillRect(var2, var3 + 9, var4 - 4, var5 - 18);
      this.sub_788(var1, var2, var3, var4, var5);
      boolean var7 = false;
      int var8 = var3 + 10;
      GameScreen.gameScreen.drawFancyText(var1, var2 + 2 + 10, var8, SomeUtilClass.getStr("ИГРОК"), this.var_42f);
      var1.setColor(2171169);
      var1.drawLine(var2, var8 + 8, var2 + var4 - 5, var8 + 8);
      var1.setColor(5329747);
      var1.drawLine(var2, var8 + 9, var2 + var4 - 5, var8 + 9);
      var8 += 11;
      if (this.var_3c8 == 0) {
         this.sub_8d8(var1, var2 - 4, var8 - 7, var4 - 6, this.blueLineImg);
      }

      GameScreen.gameScreen.sub_fcf(var1, var2 + 2, var8 + 2, SomeUtilClass.getStr("ИМЯ"), GameScreen.gameScreen.rMiniFront2Img);
      var1.setColor(2171169);
      var1.drawLine(var2, var8 + 9, var2 + var4 - 5, var8 + 9);
      int var9 = var2 + var4 - 10 - GameScreen.gameScreen.var_1819.playerGroupName.length() * 8;
      GameScreen.gameScreen.drawFancyText(var1, var9, var8, GameScreen.gameScreen.var_1819.playerGroupName, this.var_42f);
      var8 += 11;
      if (this.var_3c8 == 1) {
         this.sub_8d8(var1, var2 - 4, var8 - 7, var4 - 6, this.blueLineImg);
      }

      GameScreen.gameScreen.sub_fcf(var1, var2 + 2, var8 + 2, SomeUtilClass.getStr("СПЕЦИАЛИЗАЦИЯ"), GameScreen.gameScreen.rMiniFront2Img);
      var6 = Class_2a9.var_29[GameScreen.gameScreen.var_1819.var_8c];
      var9 = var2 + var4 - 10 - var6.length() * 8;
      GameScreen.gameScreen.drawFancyText(var1, var9, var8, var6, this.var_42f);
      var1.setColor(5329747);
      var1.drawLine(var2, var8 + 9, var2 + var4 - 5, var8 + 9);
      var1.setColor(2171169);
      var1.drawLine(var2, var8 + 10, var2 + var4 - 5, var8 + 10);
      var8 += 11;
      GameScreen.gameScreen.drawFancyText(var1, var2 + 2 + 10, var8, SomeUtilClass.getStr("ГРУППИРОВКИ"), this.var_42f);
      var1.setColor(2171169);
      var1.drawLine(var2, var8 + 8, var2 + var4 - 5, var8 + 8);
      var1.setColor(5329747);
      var1.drawLine(var2, var8 + 9, var2 + var4 - 5, var8 + 9);
      var8 += 11;
      if (this.var_3c8 == 2) {
         this.sub_8d8(var1, var2 - 4, var8 - 7, var4 - 6, this.blueLineImg);
      }

      GameScreen.gameScreen.sub_fcf(var1, var2 + 2, var8 + 2, SomeUtilClass.getStr("КОЛИЧЕСТВО"), GameScreen.gameScreen.rMiniFront2Img);
      var6 = "" + GameScreen.gameScreen.var_186d;
      var9 = var2 + var4 - 10 - var6.length() * 8;
      GameScreen.gameScreen.drawFancyText(var1, var9, var8, var6, this.var_42f);
      var1.setColor(2171169);
      var1.drawLine(var2, var8 + 9, var2 + var4 - 5, var8 + 9);
      var8 += 11;
      if (this.var_3c8 == 3) {
         this.sub_8d8(var1, var2 - 4, var8 - 7, var4 - 6, this.blueLineImg);
      }

      GameScreen.gameScreen.sub_fcf(var1, var2 + 2, var8 + 2, SomeUtilClass.getStr("УРОВЕНЬ"), GameScreen.gameScreen.rMiniFront2Img);
      switch(GameScreen.gameScreen.var_1899) {
      case 0:
         var6 = SomeUtilClass.getStr("НОВИЧОК");
         break;
      case 1:
         var6 = SomeUtilClass.getStr("ОПЫТНЫЙ");
         break;
      case 2:
         var6 = SomeUtilClass.getStr("МАСТЕР");
      }

      var9 = var2 + var4 - 10 - var6.length() * 8;
      GameScreen.gameScreen.drawFancyText(var1, var9, var8, var6, this.var_42f);
      var1.setColor(5329747);
      var1.drawLine(var2, var8 + 9, var2 + var4 - 5, var8 + 9);
      var1.setColor(2171169);
      var1.drawLine(var2, var8 + 10, var2 + var4 - 5, var8 + 10);
      var8 += 11;
      if (this.var_3c8 == 4) {
         this.sub_8d8(var1, var2 - 4, var8 - 7, var4 - 6, this.blueLineImg);
      }

      var6 = SomeUtilClass.getStr("НАЧАТЬ ИГРУ");
      GameScreen.gameScreen.drawFancyText(var1, var2 + (var4 - 4 - var6.length() * 8) / 2, var8, var6, this.var_42f);
      if (this.var_79a != null) {
         this.var_79a.sub_40(var1);
      }

   }

   public void sub_c45(Graphics var1) {
      this.var_1f3 += 12;
      if (this.var_1f3 > this.var_c7c) {
         this.var_1f3 = this.var_c7c;
      }

      this.drawMainMenu(var1, this.xPos, this.yPos, this.var_124, this.windowHeight);
      String var2 = SomeUtilClass.getStr("НАЛОГ");
      int var3 = this.xPos + (this.var_124 - var2.length() * 8) / 2;
      GameScreen.gameScreen.drawFancyText(var1, var3, this.yPos + 11, var2, this.var_42f);
      var1.setColor(2171169);
      var1.drawLine(this.xPos + 4, this.yPos + 20, this.xPos + this.var_124 - 5, this.yPos + 20);
      var1.drawLine(this.xPos + 6 + 5, this.yPos + 20, this.xPos + 6 + 5, this.yPos + 30);
      var1.drawLine(this.xPos + this.var_124 - 5 - 7, this.yPos + 20, this.xPos + this.var_124 - 5 - 7, this.yPos + 30);
      int var4 = this.var_124 - 5 - 7 - 6 - 5;
      int var5 = var4 / 5 * (GameScreen.gameScreen.var_d5c.var_108 / 10);
      this.sub_8d8(var1, this.xPos + 6 + 1, this.yPos + 15, var5, this.blueLineImg);

      for(int var6 = 1; var6 < 6; ++var6) {
         var1.drawLine(this.xPos + 6 + 5 + var6 * (var4 / 5), this.yPos + 20, this.xPos + 6 + 5 + var6 * (var4 / 5), this.yPos + 30);
         Image var7 = GameScreen.gameScreen.rMiniFrontImg;
         if (GameScreen.gameScreen.var_d5c.var_108 / 10 >= var6) {
            var7 = GameScreen.gameScreen.rMiniFront2Img;
         }

         GameScreen.gameScreen.sub_fcf(var1, this.xPos + 6 + 5 + (var6 - 1) * (var4 / 5) + 3, this.yPos + 23, "" + var6 * 10, var7);
      }

      var1.drawImage(this.curLeftImg, this.xPos + 6, this.yPos + 12 + 11, 20);
      var1.drawImage(this.curRightImg, this.xPos + this.var_124 - 9, this.yPos + 12 + 11, 20);
   }

   public void sub_c52(Graphics var1) {
      this.var_1f3 += 12;
      if (this.var_1f3 > this.var_c7c) {
         this.var_1f3 = this.var_c7c;
      }

      this.drawMainMenu(var1, this.xPos, this.yPos, this.var_124, this.windowHeight);
      String var2 = SomeUtilClass.getStr("ТЕКУЩИЙ СЧЕТ");
      int var3 = this.xPos + (this.var_124 - var2.length() * 8) / 2;
      GameScreen.gameScreen.drawFancyText(var1, var3, this.yPos + 11, var2, this.var_42f);

      int var4;
      for(var4 = 0; var4 < this.var_e03.length + 1; ++var4) {
         var1.setColor(2171169);
         var1.drawLine(this.xPos + 4, this.yPos + 20 + var4 * 11, this.xPos + this.var_124 - 5, this.yPos + 20 + var4 * 11);
         if (var4 < this.var_e03.length) {
            Class_2a9 var5 = GameScreen.gameScreen.sub_122a(this.var_e03[var4]);
            GameScreen.gameScreen.drawFancyText(var1, this.xPos + 6, this.yPos + 20 + var4 * 11 + 2, var5.playerGroupName, this.var_42f);
            var2 = "" + this.var_e50[var4];
            var3 = this.xPos + this.var_124 - 6 - var2.length() * 8;
            GameScreen.gameScreen.drawFancyText(var1, var3, this.yPos + 20 + var4 * 11 + 2, var2, this.var_42f);
         }
      }

      var4 = this.yPos + this.windowHeight - 11 - 7;
      this.sub_8d8(var1, this.xPos, var4 - 7, this.var_124 - 10, this.blueLineImg);
      var2 = SomeUtilClass.getStr("ЗАКРЫТЬ");
      var3 = this.xPos + (this.var_124 - var2.length() * 8) / 2;
      GameScreen.gameScreen.drawFancyText(var1, var3, var4, var2, this.var_42f);
   }

   public void sub_c74(Graphics var1) {
      String var2 = SomeUtilClass.getStr("ПОМОЩЬ");
      GameScreen.gameScreen.drawFancyText(var1, this.xPos + (this.var_124 - var2.length() * 8) / 2, this.yPos + 5, var2, this.var_42f);
      this.var_cbe = this.windowHeight - 15 - 17;
      if (this.colBtnImg == null) {
         this.colBtnImg = this.sub_cd5();
      }

      var1.setClip(this.xPos + 5, this.yPos + 16, this.var_124 - 10, this.var_cbe);
      var1.drawImage(this.colBtnImg, this.xPos + 5, this.yPos + 16 - this.var_368, 20);
      var1.setClip(0, 0, GameScreen.gameScreen.getWidth(), GameScreen.gameScreen.getHeight());
      if (this.var_368 + this.var_cbe < this.colBtnImg.getHeight()) {
         this.var_3c8 = 1;
      } else {
         this.var_3c8 = 0;
      }

   }

   public Image sub_cd5() {
      int var1 = this.var_124 - 10;
      int var10000 = SomeUtilClass.sub_1a5(GameScreen.gameScreen.var_1965, var1);
      GameScreen var10001 = GameScreen.gameScreen;
      int var2 = var10000 * (5 + 4);
      Image var3 = Image.createImage(var1, var2);
      Graphics var4 = var3.getGraphics();
      var4.setColor(this.var_221);
      var4.fillRect(0, 0, var1, var2);
      SomeUtilClass.sub_1db(var4, GameScreen.gameScreen.var_1965, 0, 0, var1, var2);
      return var3;
   }
}
