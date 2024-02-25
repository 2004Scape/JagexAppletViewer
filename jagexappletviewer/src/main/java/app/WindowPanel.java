package app;

import java.awt.Graphics;
import java.awt.Panel;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/aa")
public final class WindowPanel extends Panel {

	@OriginalMember(owner = "jagexappletviewer!app/aa", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics g) {
		g.clearRect(0, 0, AppletViewer.frame.getWidth(), AppletViewer.frame.getHeight());
		super.paint(g);
	}

	@OriginalMember(owner = "jagexappletviewer!app/aa", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void update(@OriginalArg(0) Graphics g) {
		this.paint(g);
	}
}
