package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/k")
public final class WindowListener extends WindowAdapter implements ActionListener {

	@OriginalMember(owner = "jagexappletviewer!app/k", name = "a", descriptor = "Ljagexappletviewer!app/k;")
	private static WindowListener aWindowAdapter_Sub1_1;

	@OriginalMember(owner = "jagexappletviewer!app/k", name = "a", descriptor = "(I)Ljagexappletviewer!app/k;")
	public static WindowListener create(@OriginalArg(0) int arg0) {
		if (aWindowAdapter_Sub1_1 == null) {
			aWindowAdapter_Sub1_1 = new WindowListener();
		}
		return aWindowAdapter_Sub1_1;
	}

	@OriginalMember(owner = "jagexappletviewer!app/k", name = "<init>", descriptor = "()V")
	private WindowListener() {
	}

	@OriginalMember(owner = "jagexappletviewer!app/k", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosing(@OriginalArg(0) WindowEvent arg0) {
		AppletViewer.method5(96);
	}

	@OriginalMember(owner = "jagexappletviewer!app/k", name = "actionPerformed", descriptor = "(Ljava/awt/event/ActionEvent;)V")
	@Override
	public void actionPerformed(@OriginalArg(0) ActionEvent arg0) {
		AppletViewer.method5(122);
	}
}