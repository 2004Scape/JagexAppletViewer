package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.StringTokenizer;

final class j extends Component implements MouseListener, MouseMotionListener {
   private o[][] a;
   private t[] b;
   private static Color c = new Color(12410);
   private static Color d = new Color(16777215);
   private static Color e = new Color(16765440);

   public final void mouseReleased(MouseEvent var1) {
   }

   public final void mouseDragged(MouseEvent var1) {
   }

   public final void paint(Graphics var1) {
      boolean var15 = ca.c;
      int var2 = this.getWidth();
      FontMetrics var3 = var1.getFontMetrics();
      int var4 = var3.getHeight();
      int var5 = var4;
      if (this.a != null) {
         int var6 = 0;

         while(this.a.length > var6) {
            o[] var7 = this.a[var6];
            int var8 = 0;
            int var9 = 0;

            while(~var9 > ~var7.length) {
               var8 += var3.stringWidth(var7[var9].b);
               ++var9;
               if (var15) {
                  break;
               }
            }

            var9 = (var2 + -var8) / 2;
            int var10 = 0;

            while(~var7.length < ~var10) {
               o var11;
               int var12;
               label32: {
                  var11 = var7[var10];
                  var12 = var3.stringWidth(var11.b);
                  t var13 = var11.a;
                  if (null != var13) {
                     var1.setColor(e);
                     Rectangle var14 = var13.b;
                     var14.height = var4;
                     var14.y = -var4 + var5;
                     var14.x = var9;
                     var14.width = var12;
                     if (!var15) {
                        break label32;
                     }
                  }

                  var1.setColor(d);
               }

               var1.drawString(var11.b, var9, var5);
               var9 += var12;
               ++var10;
               if (var15) {
                  break;
               }
            }

            var5 += var4;
            ++var6;
            if (var15) {
               break;
            }
         }

      }
   }

   public final void mouseClicked(MouseEvent var1) {
   }

   public final void mouseEntered(MouseEvent var1) {
   }

   public final void mousePressed(MouseEvent var1) {
      boolean var4 = ca.c;
      Point var2 = var1.getPoint();
      int var3 = 0;

      while(~var3 > ~this.b.length) {
         if (this.b[var3].b.contains(var2)) {
            i.showurl(this.b[var3].a, (String)null);
         }

         ++var3;
         if (var4) {
            break;
         }
      }

   }

   public final void mouseExited(MouseEvent var1) {
   }

   public final void mouseMoved(MouseEvent var1) {
      boolean var4 = ca.c;
      Point var2 = var1.getPoint();
      int var3 = 0;

      while(this.b.length > var3) {
         if (this.b[var3].b.contains(var2)) {
            this.setCursor(Cursor.getPredefinedCursor(12));
            return;
         }

         ++var3;
         if (var4) {
            break;
         }
      }

      this.setCursor(Cursor.getPredefinedCursor(0));
   }

   private final void a(byte var1, String var2) {
      boolean var14 = ca.c;
      if (null != var2) {
         if (var1 < 113) {
            this.mouseClicked((MouseEvent)null);
         }

         StringTokenizer var3 = new StringTokenizer(var2, "\\");
         this.a = new o[var3.countTokens()][];
         o[] var4 = new o[100];
         int var5 = 0;

         while(var3.hasMoreTokens()) {
            int var6 = 0;
            String var7 = var3.nextToken();

            do {
               int var8 = var7.indexOf(91);
               if (var8 < 0) {
                  var4[var6++] = new o(var7);
                  if (!var14) {
                     break;
                  }
               }

               if (var8 > 0) {
                  var4[var6++] = new o(var7.substring(0, var8));
                  var7 = var7.substring(var8);
               }

               int var9 = var7.indexOf(34);
               if (0 > var9) {
                  break;
               }

               int var10 = var7.indexOf(34, var9 + 1);
               if (~var10 > -1 && !var14) {
                  break;
               }

               int var11 = var7.indexOf(93);
               if (-1 < ~var11) {
                  break;
               }

               String var12 = var7.substring(1 + var9, var10);
               String var13 = var7.substring(var10 - -1, var11).trim();
               var4[var6++] = new o(var13, var12);
               if (var7.length() <= 1 + var11) {
                  break;
               }

               var7 = var7.substring(var11 + 1);
            } while(!var14);

            this.a[var5] = new o[var6];
            System.arraycopy(var4, 0, this.a[var5], 0, var6);
            ++var5;
            if (var14) {
               break;
            }
         }

      }
   }

   j(String var1) {
      super();
      boolean var7 = ca.c;
      this.a = (o[][])null;
      this.setBackground(c);
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.a((byte)123, var1);
      if (this.a != null) {
         int var2 = 0;
         int var3 = 0;

         while(var3 < this.a.length) {
            o[] var4 = this.a[var3];
            int var5 = 0;

            while(var5 < var4.length) {
               if (null != var4[var5].a) {
                  ++var2;
               }

               ++var5;
               if (var7) {
                  break;
               }
            }

            ++var3;
            if (var7) {
               break;
            }
         }

         this.b = new t[var2];
         var3 = 0;
         int var8 = 0;

         while(this.a.length > var8) {
            o[] var9 = this.a[var8];
            int var6 = 0;

            while(var9.length > var6) {
               if (var9[var6].a != null) {
                  this.b[var3++] = var9[var6].a;
               }

               ++var6;
               if (var7) {
                  break;
               }
            }

            ++var8;
            if (var7) {
               break;
            }
         }

      }
   }
}
