package app;

import java.awt.Graphics;
import java.awt.Panel;

final class aa extends Panel {
	public final void paint(Graphics var1) {
		var1.clearRect(0, 0, appletviewer.e.getWidth(), appletviewer.e.getHeight());
		super.paint(var1);
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}
}
