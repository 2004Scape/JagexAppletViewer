package app;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/d")
public final class DialogListener implements ActionListener {

	@OriginalMember(owner = "jagexappletviewer!app/d", name = "a", descriptor = "Ljava/awt/Dialog;")
	private Dialog aDialog2 = DialogMessage.dialog;

	@OriginalMember(owner = "jagexappletviewer!app/d", name = "actionPerformed", descriptor = "(Ljava/awt/event/ActionEvent;)V")
	@Override
	public void actionPerformed(@OriginalArg(0) ActionEvent arg0) {
		this.aDialog2.setVisible(false);
	}
}