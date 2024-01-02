package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

final class k extends WindowAdapter implements ActionListener {
   private static k a;

   public final void windowClosing(WindowEvent var1) {
      appletviewer.b((int)96);
   }

   static final k a(int var0) {
      if (a == null) {
         a = new k();
      }

      if (var0 != -21945) {
         a(57);
      }

      return a;
   }

   public final void actionPerformed(ActionEvent var1) {
      appletviewer.b((int)122);
   }

   private k() {
   }
}
