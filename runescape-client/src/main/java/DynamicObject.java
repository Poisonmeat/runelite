import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("v")
   Sequence field1563;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1898134511
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1945526093
   )
   int field1569;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1889787191
   )
   @Export("type")
   int type;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1645815089
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1711485319
   )
   @Export("level")
   int level;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 64664663
   )
   int field1568;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -849978763
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 3985011
   )
   @Export("sceneY")
   int sceneY;

   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1563 = class224.getAnimation(var7);
         this.field1568 = 0;
         this.field1569 = Client.gameCycle - 1;
         if(this.field1563.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(this.field1563 == var10.field1563) {
               this.field1568 = var10.field1568;
               this.field1569 = var10.field1569;
               return;
            }
         }

         if(var8 && this.field1563.frameStep != -1) {
            this.field1568 = (int)(Math.random() * (double)this.field1563.frameIDs.length);
            this.field1569 -= (int)(Math.random() * (double)this.field1563.frameLenghts[this.field1568]);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1914243094"
   )
   protected final Model getModel() {
      if(this.field1563 != null) {
         int var1 = Client.gameCycle - this.field1569;
         if(var1 > 100 && this.field1563.frameStep > 0) {
            var1 = 100;
         }

         label53: {
            do {
               do {
                  if(var1 <= this.field1563.frameLenghts[this.field1568]) {
                     break label53;
                  }

                  var1 -= this.field1563.frameLenghts[this.field1568];
                  ++this.field1568;
               } while(this.field1568 < this.field1563.frameIDs.length);

               this.field1568 -= this.field1563.frameStep;
            } while(this.field1568 >= 0 && this.field1568 < this.field1563.frameIDs.length);

            this.field1563 = null;
         }

         this.field1569 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class251.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = this.sceneX + (var2 >> 1);
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = this.sceneY + (var3 >> 1);
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var4][var6] + var8[var5][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4519(this.type, this.orientation, var8, var10, var9, var11, this.field1563, this.field1568);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "338399108"
   )
   public static void method1874(int var0, int var1) {
      Varbit var3 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var8 = Varbit.varbit_ref.getConfigData(14, var0);
         var3 = new Varbit();
         if(var8 != null) {
            var3.decode(new Buffer(var8));
         }

         Varbit.varbits.put(var3, (long)var0);
         var2 = var3;
      }

      int var4 = var2.configId;
      int var5 = var2.leastSignificantBit;
      int var6 = var2.mostSignificantBit;
      int var7 = class211.field2613[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class211.widgetSettings[var4] = class211.widgetSettings[var4] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "868881172"
   )
   static final void method1873(String var0) {
      if(var0 != null) {
         String var1 = Player.method1179(var0, Client.field928);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = Player.method1179(var4, Client.field928);
               if(class272.method4895(var0, var1, var4, var5)) {
                  --Client.friendCount;

                  for(int var6 = var2; var6 < Client.friendCount; ++var6) {
                     Client.friends[var6] = Client.friends[var6 + 1];
                  }

                  Client.field1025 = Client.field1112;
                  Client.secretPacketBuffer1.putOpcode(87);
                  Client.secretPacketBuffer1.putByte(class261.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
                  break;
               }
            }

         }
      }
   }
}