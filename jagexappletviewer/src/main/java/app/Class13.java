package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/s")
public final class Class13 implements ActionListener {

	@OriginalMember(owner = "jagexappletviewer!app/s", name = "actionPerformed", descriptor = "(Ljava/awt/event/ActionEvent;)V")
	@Override
	public void actionPerformed(@OriginalArg(0) ActionEvent arg0) {
		@Pc(4) int local4 = arg0.getID();
		if (local4 == 0) {
			if (appletviewer.method2(113) >= 0) {
				Class4.method30(0, appletviewer.method15(1555, "changes_on_restart"));
			}
		} else if (local4 == 1) {
			appletviewer.method9((byte) -90);
		}
	}
}
