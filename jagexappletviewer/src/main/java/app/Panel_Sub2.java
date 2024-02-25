package app;

import java.awt.Graphics;
import java.awt.Panel;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/aa")
public final class Panel_Sub2 extends Panel {

	@OriginalMember(owner = "jagexappletviewer!app/aa", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics arg0) {
		arg0.clearRect(0, 0, appletviewer.aFrame1.getWidth(), appletviewer.aFrame1.getHeight());
		super.paint(arg0);
	}

	@OriginalMember(owner = "jagexappletviewer!app/aa", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void update(@OriginalArg(0) Graphics arg0) {
		this.paint(arg0);
	}
}
