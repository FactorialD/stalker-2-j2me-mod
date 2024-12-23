import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class Class_2a9 {
   public static final String[] var_29 = new String[]{"УНИВЕРСАЛЬНАЯ", "ВОЕННАЯ", "НАУЧНАЯ", "ТЕХНИЧЕСКАЯ"};
   public byte var_8c;
   public String playerGroupName;// группировка игрока
   public int var_f6;
   public int var_108;
   public int var_154;
   public int var_1a1;
   public int var_1c6;
   public int var_1e1;
   public int var_233;
   public int var_277;
   public int var_2c3;
   public static final int[] var_327 = new int[]{0, 50, -25, -25};
   public static final int[] var_377 = new int[]{0, -25, -25, 50};
   public static final int[] var_382 = new int[]{0, -25, 50, -25};
   public boolean var_3d2 = false;
   public boolean var_430 = false;
   public Project[] projectsArr = new Project[5]; // список проектов
   public boolean var_47e;
   public byte[] var_4b4 = new byte[5];
   public byte[] var_513 = new byte[5];
   public int[] var_53b = new int[5];
   public int var_55d;
   public int var_581;
   public int var_5da;
   public int var_605;
   public int var_622;
   public int var_678;
   public Image var_6c8 = null;
   public Vector var_6d7 = null;
   public int var_6eb;
   public boolean var_723;
   public int var_76d = 0;
   public int var_7c4 = 0;
   public boolean var_7e2 = false;
   public Planet var_80a = null;
   public Planet var_821 = null;
   public int var_853 = 0;
   public int var_8b0 = 0;
   public boolean var_914 = false;
   public boolean var_96d = false;

   public Class_2a9(int var1, int var2, int var3) {
      this.var_8c = 0;
      this.var_723 = false;
      this.var_6eb = -1;
      this.var_678 = 0;
      this.var_108 = 10;
      this.var_154 = 0;
      this.var_605 = 0;
      this.var_5da = 2;
      this.var_622 = 50;
      this.var_f6 = var1;
      this.var_1a1 = var2;
      this.var_1c6 = var3;
      this.var_6c8 = GameScreen.gameScreen.groupSidesImgArr[this.var_1a1];

      int var4;
      for(var4 = 0; var4 < 5; ++var4) {
         this.projectsArr[var4] = new Project();
         this.projectsArr[var4].sub_112(var4);
      }

      this.var_47e = false;
      this.var_55d = 1;
      this.var_581 = 0;

      for(var4 = 0; var4 < this.var_4b4.length; ++var4) {
         this.var_4b4[var4] = 1;
         this.var_513[var4] = 20;
         this.var_53b[var4] = 0;
      }

      this.var_6d7 = new Vector();
   }

   public Class_2a9() {
      this.var_6d7 = new Vector();
      this.var_723 = false;
      this.var_6eb = -1;
   }

   public int sub_c() {
      return this.var_3d2 ? 2 : 1;
   }

   public int sub_6d() {
      boolean var1 = false;
      int var2 = var_327[this.var_8c];
      if (this.sub_e8(6)) {
         var2 += 50;
      }

      return var2;
   }

   public int sub_90() {
      boolean var1 = false;
      int var2 = var_377[this.var_8c];
      return var2;
   }

   public int sub_b1() {
      boolean var1 = false;
      int var2 = var_382[this.var_8c];
      return var2;
   }

   public boolean sub_e8(int var1) {
      return this.sub_139(GameScreen.gameScreen.passiveUpgradesDictArr[var1].var_1ed);
   }

   public boolean sub_139(int var1) {
      int var2;
      if (var1 < 32) {
         var2 = 1 << var1;
         return (var2 & this.var_55d) != 0;
      } else {
         var2 = 1 << var1 - 32;
         return (var2 & this.var_581) != 0;
      }
   }

   public void sub_143() {
      this.var_7c4 = 0;

      for(int var1 = 0; var1 < 64; ++var1) {
         if (this.sub_139(var1)) {
            ++this.var_7c4;
         }
      }

   }

   public int sub_16d() {
      int var1 = 0;

      for(int var2 = 0; var2 < 5; ++var2) {
         if (this.sub_139(GameScreen.gameScreen.var_1095[var2].someByte)) {
            var1 = var2;
         }
      }

      return var1;
   }

   public int sub_1c4() {
      int var1 = 0;

      for(int var2 = 0; var2 < 5; ++var2) {
         if (this.sub_139(GameScreen.gameScreen.var_1116[var2].someByte)) {
            var1 = var2;
         }
      }

      return var1;
   }

   public int sub_1d4() {
      int var1 = 0;

      for(int var2 = 0; var2 < 6; ++var2) {
         if (this.sub_139(GameScreen.gameScreen.var_10d4[var2].someByte)) {
            var1 = var2;
         }
      }

      return var1;
   }

   public int sub_213() {
      int var1 = 0;

      for(int var2 = 0; var2 < 14; ++var2) {
         if (this.sub_139(GameScreen.gameScreen.var_1171[var2].someByte)) {
            ++var1;
         }
      }

      return var1;
   }

   public int sub_272(int var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < 14; ++var3) {
         if (this.sub_139(GameScreen.gameScreen.var_1171[var3].someByte)) {
            ++var2;
            if (var2 == var1) {
               return var3;
            }
         }
      }

      return 0;
   }

   public void sub_2ac(int var1) {
      int var2;
      if (var1 < 32) {
         var2 = 1 << var1;
         this.var_55d |= var2;
      } else {
         var2 = 1 << var1 - 32;
         this.var_581 |= var2;
      }

   }

   public void sub_2c0(int var1) {
      int var2 = 1 << var1;
      this.var_678 |= var2;
   }

   public boolean sub_2cc(int var1) {
      int var2 = 1 << var1;
      return (var2 & this.var_678) != 0;
   }

   public void sub_312(int var1) {
      if (this.sub_2cc(var1)) {
         int var2 = 1 << var1;
         this.var_678 ^= var2;
      }

   }

   public void sub_367(int var1) {
      if (this.var_5da > 0 && this.var_5da < 255 && GameScreen.gameScreen.var_fc9[this.var_5da].var_16 <= this.var_605) {
         this.sub_640(20, this.var_5da, "");
         this.sub_2ac(this.var_5da);
         this.var_5da = 0;
         this.var_605 = 0;
         this.var_723 = true;
         if (this.var_47e) {
            GameScreen.gameScreen.sub_2157(this);
         }
      }

      if (this.var_5da >= 255 && this.var_5da < 265 && GameScreen.gameScreen.artifactsDictArr[this.var_5da - 255].var_175 <= this.var_605) {
         this.sub_640(21, this.var_5da - 255, "");
         this.sub_312(this.var_5da - 255);
         this.var_6eb = this.var_5da - 255;
         this.var_5da = 0;
         this.var_605 = 0;
      }

      for(int var2 = 0; var2 < this.var_53b.length; ++var2) {
         int[] var10000 = this.var_53b;
         var10000[var2] += this.var_513[var2] * var1 / 100;
         if (this.var_53b[var2] >= this.sub_3db(var2)) {
            this.sub_640(22, var2, "");
            ++this.var_4b4[var2];
            this.var_53b[var2] = 0;
         }
      }

   }

   public boolean sub_3bf(Class_4b var1) {
      for(int var2 = 0; var2 < this.var_4b4.length; ++var2) {
         if (this.var_4b4[var2] < var1.var_2d[var2]) {
            return false;
         }
      }

      return true;
   }

   public int sub_3db(int var1) {
      int var2 = 1;

      for(int var3 = 1; var3 < this.var_4b4[var1]; ++var3) {
         var2 *= 3;
      }

      return var2 * 10;
   }

   public int sub_40d(int var1) {
      int var2 = this.sub_3db(var1);
      if (var2 == 0) {
         return 0;
      } else {
         var2 = 100 * this.var_53b[var1] / var2;
         if (var2 > 100) {
            var2 = 100;
         }

         return var2;
      }
   }

   public int sub_46d(int var1, int var2) {
      var2 = var2 * this.var_513[var1] / 100;
      if (var2 == 0) {
         return 999;
      } else {
         int var3 = this.sub_3db(var1) - this.var_53b[var1];
         int var4 = var3 / var2;
         if (var4 <= 0) {
            var4 = 1;
         }

         if (var4 > 999) {
            var4 = 999;
         }

         if (var4 * var2 < var3) {
            ++var4;
         }

         return var4;
      }
   }

   public void sub_481() {
      if (this.var_622 < 100) {
         this.var_622 += 10;
      }

   }

   public void sub_4b9() {
      if (this.var_622 > 0) {
         this.var_622 -= 10;
      }

   }

   public void sub_50c(int var1) {
      for(int var2 = 0; var2 < this.var_513.length; ++var2) {
         this.var_513[var2] = 0;
      }

      this.var_513[var1] = 100;
   }

   public void sub_534(int var1) {
      int var2 = 5;
      if (this.var_513[var1] + var2 > 100) {
         var2 = 100 - this.var_513[var1];
      }

      byte[] var10000 = this.var_513;
      var10000[var1] = (byte)(var10000[var1] + var2);
      int var3 = var1 + 1;

      while(true) {
         while(var2 > 0) {
            if (var3 == 5) {
               var3 = 0;
            }

            if (var3 != var1 && this.var_513[var3] > 0) {
               --this.var_513[var3];
               --var2;
            } else {
               ++var3;
            }
         }

         return;
      }
   }

   public void sub_58f(int var1) {
      int var2 = 16;
      if (this.var_513[var1] - var2 < 0) {
         var2 = this.var_513[var1];
      }

      byte[] var10000 = this.var_513;
      var10000[var1] = (byte)(var10000[var1] - var2);
      int var3 = 4;

      while(var2 > 0) {
         if (var3 == 5) {
            var3 = 0;
         }

         if (var3 != var1) {
            ++this.var_513[var3];
            --var2;
         } else {
            ++var3;
         }
      }

   }

   public int sub_5ab() {
      byte var1 = 0;

      for(int var2 = 0; var2 < this.var_4b4.length; ++var2) {
         if (var1 < this.var_4b4[var2]) {
            var1 = this.var_4b4[var2];
         }
      }

      return var1;
   }

   public int sub_5ef() {
      switch(this.var_1a1) {
      case 0:
         return 13843735;
      case 1:
         return 4620207;
      case 2:
         return 2621629;
      case 3:
         return 16731847;
      case 4:
         return 4761146;
      case 5:
         return 8865538;
      default:
         return 0;
      }
   }

   public void sub_640(int var1, int var2, String var3) {
      Dto1 var4 = new Dto1();
      var4.someInt3 = var2;
      var4.someInt2 = var1;
      var4.someStr = var3;
      this.var_6d7.addElement(var4);
   }

   public void sub_675() {
      this.var_6d7.removeAllElements();
   }

   public int sub_6d1() {
      return this.var_6d7.size();
   }

   public int sub_72c(int var1) {
      Dto1 var2 = (Dto1)this.var_6d7.elementAt(var1);
      return var2.someInt2;
   }

   public String sub_777(int var1) {
      if (var1 >= this.var_6d7.size()) {
         return "";
      } else {
         Dto1 var2 = (Dto1)this.var_6d7.elementAt(var1);
         Planet var3 = null;
         if (var2.someInt2 < 20) {
            var3 = GameScreen.gameScreen.sub_78d(var2.someInt3);
         }

         switch(var2.someInt2) {
         case 1:
            return SomeUtilClass.getStr("УВЕЛИЧИЛОСЬ НАСЕЛЕНИЕ В ЛАГЕРЕ") + " " + var3.sub_96() + " " + SomeUtilClass.getStr("");
         case 2:
            return SomeUtilClass.getStr("УМЕНЬШИЛОСЬ НАСЛЕДЕНИЕ В ЛАГЕРЕ") + " " + var3.sub_96() + " " + SomeUtilClass.getStr("");
         case 3:
            return SomeUtilClass.getStr("ЛАГЕРЬ") + " " + var3.sub_96() + " " + SomeUtilClass.getStr("БЫЛ ЗАБРОШЕН ИЗ-ЗА ВЫМИРАНИЯ ВСЕХ СТАЛКЕРОВ");
         case 4:
            return SomeUtilClass.getStr("СТАЛКЕРЫ ИЗ ЛАГЕРЯ") + " " + var3.sub_96() + " " + SomeUtilClass.getStr("ТРЕБУЮТ ХАБАР, СРОЧНО ПРИМИТЕ МЕРЫ");
         case 5:
            return SomeUtilClass.getStr("В ЛАГЕРЕ") + " " + var3.sub_96() + " " + SomeUtilClass.getStr("СТАЛКЕР") + " " + var2.someStr + " " + SomeUtilClass.getStr("ГОТОВ К БОЮ");
         case 6:
            return SomeUtilClass.getStr("В ЛАГЕРЕ") + " " + var3.sub_96() + " " + SomeUtilClass.getStr("ТЕПЕРЬ ЕСТЬ") + " " + var2.someStr;
         case 7:
            return SomeUtilClass.getStr("НАШИ СТАЛКЕРЫ ДОСТИГЛИ НОВОГО ЛАГЕРЯ - ") + var3.sub_96();
         case 8:
            return SomeUtilClass.getStr("НАШИ СТАЛКЕРЫ ОБНАРУЖИЛИ НЕИЗВЕСТНЫЙ АРТЕФАКТ В ЛАГЕРЕ ") + var3.sub_96();
         case 9:
            return SomeUtilClass.getStr("НАШ ОТРЯД ЗАХВАТИЛ ВРАЖЕСКИЙ ЛАГЕРЬ - ") + var3.sub_96();
         case 10:
            return SomeUtilClass.getStr("НАШ ЛАГЕРЬ ") + var3.sub_96() + " " + SomeUtilClass.getStr("ЗАХВАТИЛ ВРАЖЕСКИЙ ОТРЯД");
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
         default:
            return "";
         case 20:
            String var4 = GameScreen.gameScreen.sub_19a5(var2.someInt3, 0);
            return SomeUtilClass.getStr("НАШИ УЧЕНЫЕ УСПЕШНО ИССЛЕДОВАЛИ -") + " " + var4;
         case 21:
            return SomeUtilClass.getStr("НАШИ УЧЕНЫЕ УСПЕШНО ИССЛЕДОВАЛИ ТАИНСТВЕННЫЙ АРТЕФАКТ, ОБНАРУЖИВ, ЧТО ОН -") + " " + GameScreen.gameScreen.artifactsDictArr[var2.someInt3].var_144;
         case 22:
            return SomeUtilClass.getStr("НАШИ УЧЕНЫЕ ПРОДВИНУЛИСЬ В ТЕОРИИ ДО") + " " + this.var_4b4[var2.someInt3] + " " + SomeUtilClass.getStr("УРОВНЯ") + " " + SomeUtilClass.scienceBranchNames2Arr[var2.someInt3] + ". " + SomeUtilClass.getStr("ТЕПЕРЬ МЫ МОЖЕМ ИССЛЕДОВАТЬ НОВЫЕ ПРАКТИЧЕСКИЕ ТЕХНОЛОГИИ");
         case 30:
            return SomeUtilClass.getStr("ОТРЯД ") + var2.someStr + SomeUtilClass.getStr(" ВЗБУНТОВАЛСЯ И ДЕЗЕРТИРОВАЛ");
         case 31:
            return SomeUtilClass.getStr("ЛАГЕРЬ ") + var2.someStr + SomeUtilClass.getStr(" БЫЛ ПРИНУДИТЕЛЬНО РАСПУЩЕН ИЗ-ЗА НЕХВАТКИ СРЕДСТВ");
         }
      }
   }

   public int sub_7d3() {
      int var1 = (GameScreen.gameScreen.sub_718(this.var_1c6) - 550) / 10;
      int var2 = this.sub_6d();
      return var2 + var1;
   }

   public boolean sub_82c(byte[] var1) {
      ByteArrayInputStream var2 = new ByteArrayInputStream(var1);
      DataInputStream var3 = new DataInputStream(var2);

      try {
         byte var4 = var3.readByte();
         this.var_8c = var3.readByte();
         this.playerGroupName = var3.readUTF();
         this.var_f6 = var3.readInt();
         this.var_108 = var3.readInt();
         this.var_154 = var3.readInt();
         this.var_1a1 = var3.readInt();
         this.var_1c6 = var3.readInt();
         this.var_1e1 = var3.readInt();
         this.var_233 = var3.readInt();
         this.var_277 = var3.readInt();
         this.var_2c3 = var3.readInt();
         this.var_47e = var3.readBoolean();
         this.var_6eb = var3.readInt();

         int var5;
         for(var5 = 0; var5 < this.var_4b4.length; ++var5) {
            this.var_4b4[var5] = var3.readByte();
            this.var_513[var5] = var3.readByte();
            this.var_53b[var5] = var3.readInt();
         }

         this.var_55d = var3.readInt();
         this.var_581 = var3.readInt();
         this.var_5da = var3.readInt();
         this.var_605 = var3.readInt();
         this.var_622 = var3.readInt();
         this.var_678 = var3.readInt();
         this.var_3d2 = var3.readBoolean();
         this.var_430 = var3.readBoolean();

         for(var5 = 0; var5 < 5; ++var5) {
            this.projectsArr[var5] = new Project();
            this.projectsArr[var5].projectName = var3.readUTF();
            this.projectsArr[var5].var_65 = var3.readInt();
            this.projectsArr[var5].var_8a = var3.readInt();
         }

         this.var_6c8 = GameScreen.gameScreen.groupSidesImgArr[this.var_1a1];
         var3.close();
         var2.close();
         return true;
      } catch (IOException var6) {
         return false;
      }
   }

   public boolean sub_881(RecordStore var1) {
      try {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         DataOutputStream var3 = new DataOutputStream(var2);

         try {
            byte var4 = 1;
            var3.writeByte(var4);
            var3.writeByte(this.var_8c);
            var3.writeUTF(this.playerGroupName);
            var3.writeInt(this.var_f6);
            var3.writeInt(this.var_108);
            var3.writeInt(this.var_154);
            var3.writeInt(this.var_1a1);
            var3.writeInt(this.var_1c6);
            var3.writeInt(this.var_1e1);
            var3.writeInt(this.var_233);
            var3.writeInt(this.var_277);
            var3.writeInt(this.var_2c3);
            var3.writeBoolean(this.var_47e);
            var3.writeInt(this.var_6eb);

            int var5;
            for(var5 = 0; var5 < this.var_4b4.length; ++var5) {
               var3.writeByte(this.var_4b4[var5]);
               var3.writeByte(this.var_513[var5]);
               var3.writeInt(this.var_53b[var5]);
            }

            var3.writeInt(this.var_55d);
            var3.writeInt(this.var_581);
            var3.writeInt(this.var_5da);
            var3.writeInt(this.var_605);
            var3.writeInt(this.var_622);
            var3.writeInt(this.var_678);
            var3.writeBoolean(this.var_3d2);
            var3.writeBoolean(this.var_430);

            for(var5 = 0; var5 < 5; ++var5) {
               var3.writeUTF(this.projectsArr[var5].projectName);
               var3.writeInt(this.projectsArr[var5].var_65);
               var3.writeInt(this.projectsArr[var5].var_8a);
            }

            var3.close();
            var2.close();
         } catch (IOException var6) {
         }

         byte[] var8 = var2.toByteArray();
         var1.addRecord(var8, 0, var8.length);
         return true;
      } catch (RecordStoreException var7) {
         return false;
      }
   }

   public int sub_88e() {
      byte var1 = 0;
      int var3 = var1 + GameScreen.gameScreen.sub_7d3(this);
      var3 += GameScreen.gameScreen.sub_80b(this);
      this.sub_143();
      var3 += this.var_7c4;

      for(int var2 = 0; var2 < this.var_4b4.length; ++var2) {
         var3 += this.var_4b4[var2];
      }

      var3 += GameScreen.gameScreen.sub_1dcf(this);
      var3 += GameScreen.gameScreen.sub_1fb8(this);
      return var3;
   }
}
