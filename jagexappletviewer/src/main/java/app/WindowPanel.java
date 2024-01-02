package app;

import java.awt.Graphics;
import java.awt.Panel;

final class WindowPanel extends Panel {
	public final void paint(Graphics g) {
		g.clearRect(0, 0, appletviewer.frame.getWidth(), appletviewer.frame.getHeight());
		super.paint(g);
	}

	public final void update(Graphics g) {
		this.paint(g);
	}
}
