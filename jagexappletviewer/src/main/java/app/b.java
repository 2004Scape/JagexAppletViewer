package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

final class b extends Component {
   private String a = "Loading...";
   private static Dialog b;
   private Font c;
   private int d = 0;
   private static b e;
   private Color f = new Color(140, 11, 1);
   private FontMetrics g;

   static final void a(int var0) {
      if (var0 != -1127) {
         a(62, 4);
      }

      if (null != b) {
         b.setVisible(false);
      }

   }

   static final void a(int var0, int var1) {
      if (e != null) {
         if (var0 > 100) {
            var0 = 100;
         }

         e.d = var0;
         if (var1 != 140) {
            e = (b)null;
         }

         e.repaint();
      }
   }

   static final void a(byte var0) {
      if (var0 == -98) {
         e.paint(e.getGraphics());
      }
   }

   static final void a(String var0, byte var1) {
      e.a = var0;
      e.repaint();
      if (var1 != 31) {
         b = (Dialog)null;
      }

   }

   static final void b(int var0) {
      e = new b(appletviewer.c(var0 + 1554, "loaderbox_initial"));
      e.c = new Font("Helvetica", var0, 13);
      e.g = e.getFontMetrics(e.c);
      b = new Dialog(appletviewer.e, "Jagex Ltd.", false);
      b.add(e);
      b.addWindowListener(k.a(-21945));
      b.setResizable(false);
      b.setSize(320, 100);
   }

   static final void c(int var0) {
      if (var0 != 2) {
         b(-122);
      }

      b.setLocationRelativeTo(appletviewer.e);
      b.setVisible(true);
   }

   private b(String var1) {
      this.a = var1;
   }

   public final void paint(Graphics var1) {
      try {
         if (var1 != null) {
            int var2 = this.getWidth();
            int var3 = this.getHeight();
            var1.setColor(Color.black);
            var1.fillRect(0, 0, var2, var3);
            var1.setColor(this.f);
            var1.drawRect(-152 + var2 / 2, -18 + var3 / 2, 303, 33);
            var1.fillRect(2 + var2 / 2 + -152, -18 + var3 / 2 + 2, -3 + this.d * 303 / 100, 30);
            String var4 = this.a + " - " + this.d + "%";
            var1.setFont(this.c);
            var1.setColor(Color.white);
            var1.drawString(var4, (var2 + -this.g.stringWidth(var4)) / 2, var3 / 2 - -4);
            if (!ca.c) {
               return;
            }
         }

         this.repaint();
      } catch (Exception var5) {
      }

   }
}
