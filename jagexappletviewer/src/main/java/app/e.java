package app;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

final class e {
   static Dialog a;
   private static Button b;

   static final void a(int var0, String var1) {
      app.b.a((int)-1127);
      a(appletviewer.c(1555, "quit"), appletviewer.c(1555, "error"), var1, (byte)20);
      a.addWindowListener(k.a(-21945));
      if (var0 != 500) {
         a = (Dialog)null;
      }

      b.addActionListener(k.a(var0 + -22445));
      a.setVisible(true);
   }

   static final void b(int var0, String var1) {
      a(appletviewer.c(1555, "ok"), appletviewer.c(var0 + 1555, "message"), var1, (byte)20);
      if (var0 != 0) {
         a(114, (String)null);
      }

      b.addActionListener(new d());
      a.setVisible(true);
   }

   private static final void a(String var0, String var1, String var2, byte var3) {
      boolean var10 = ca.c;
      a = new Dialog(appletviewer.e, var1, true);
      int var4 = 0;
      int var5 = -1;

      do {
         var5 = var2.indexOf(10, var5 - -1);
         ++var4;
      } while(0 <= var5);

      String[] var6 = new String[var4];
      Panel var7 = new Panel();
      var7.setLayout(new GridLayout(var4, 1));
      var4 = 0;
      var5 = -1;

      int var8;
      do {
         var8 = 1 + var5;
         var5 = var2.indexOf(10, 1 + var5);
         if (var5 < 0) {
            var6[var4++] = var2.substring(var8);
            if (!var10) {
               continue;
            }
         }

         var6[var4++] = var2.substring(var8, var5);
      } while(0 <= var5);

      var8 = 0;
      if (var3 != 20) {
         b = (Button)null;
      }

      while(~var6.length < ~var8) {
         Label var9 = new Label(var6[var8], 1);
         var7.add(var9);
         ++var8;
         if (var10) {
            break;
         }
      }

      a.add(var7, "Center");
      b = new Button(var0);
      a var11 = new a();
      var11.setLayout(new FlowLayout(1));
      var11.add(b);
      a.add(var11, "South");
      a.setResizable(false);
      a.setSize(500, 100);
      a.setLocationRelativeTo(appletviewer.e);
   }
}
