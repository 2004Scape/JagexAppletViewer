package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/s")
public final class DialogLanguage implements ActionListener {

	@OriginalMember(owner = "jagexappletviewer!app/s", name = "actionPerformed", descriptor = "(Ljava/awt/event/ActionEvent;)V")
	@Override
	public void actionPerformed(@OriginalArg(0) ActionEvent e) {
		@Pc(4) int id = e.getID();
		if (id == 0) {
			if (AppletViewer.method2() >= 0) {
				DialogMessage.showMessage(AppletViewer.translate("changes_on_restart"));
			}
		} else if (id == 1) {
			AppletViewer.method9();
		}
	}
}
