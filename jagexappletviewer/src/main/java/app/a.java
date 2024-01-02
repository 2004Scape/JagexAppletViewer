package app;

import java.awt.Graphics;
import java.awt.Panel;

final class a extends Panel {
   public final void paint(Graphics var1) {
      var1.setColor(this.getBackground());
      var1.fillRect(0, 0, this.getWidth(), this.getHeight());
      super.paint(var1);
   }

   public a() {
   }
}
