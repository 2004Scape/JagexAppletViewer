package app;

import java.awt.Graphics;
import java.awt.Panel;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/a")
public final class DialogPanel extends Panel {

	@OriginalMember(owner = "jagexappletviewer!app/a", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics arg0) {
		arg0.setColor(this.getBackground());
		arg0.fillRect(0, 0, this.getWidth(), this.getHeight());
		super.paint(arg0);
	}
}
