import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("d")
   @Export("userHome")
   public static String userHome;
   @ObfuscatedName("g")
   static int[] field1382;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1366002557
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @Export("finished")
   boolean finished;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 217125579
   )
   int field1380;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1599757631
   )
   int field1378;
   @ObfuscatedName("v")
   Sequence field1375;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1626903793
   )
   @Export("level")
   int level;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1079143615
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -143170019
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1742573381
   )
   @Export("height")
   int height;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 215620871
   )
   @Export("startCycle")
   int startCycle;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1378 = 0;
      this.field1380 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = Renderable.getSpotAnimType(this.id).field3332;
      if(var8 != -1) {
         this.finished = false;
         this.field1375 = class224.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1914243094"
   )
   protected final Model getModel() {
      Spotanim var1 = Renderable.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4338(this.field1378);
      } else {
         var2 = var1.method4338(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "579623850"
   )
   final void method1682(int var1) {
      if(!this.finished) {
         this.field1380 += var1;

         while(this.field1380 > this.field1375.frameLenghts[this.field1378]) {
            this.field1380 -= this.field1375.frameLenghts[this.field1378];
            ++this.field1378;
            if(this.field1378 >= this.field1375.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "2012927795"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class61.tileHeights[0][var2];
                  int var11 = var4 + var2 + 932731;
                  int var12 = var5 + var3 + 556238;
                  int var13 = class48.getSmoothNoise(var11 + '넵', var12 + 91923, 4) - 128 + (class48.getSmoothNoise(var11 + 10294, var12 + '鎽', 2) - 128 >> 1) + (class48.getSmoothNoise(var11, var12, 1) - 128 >> 2);
                  var13 = (int)((double)var13 * 0.3D) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class61.overlayIds[var1][var2][var3] = var0.readByte();
               class36.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class67.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class61.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-664573438"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class82.method1626(var0.x, var0.y, var1);
   }
}