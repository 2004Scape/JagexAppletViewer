package app;

import java.awt.Graphics;
import java.awt.Panel;

final class DialogPanel extends Panel {
	public final void paint(Graphics g) {
		g.setColor(this.getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		super.paint(g);
	}

	public DialogPanel() {
	}
}
