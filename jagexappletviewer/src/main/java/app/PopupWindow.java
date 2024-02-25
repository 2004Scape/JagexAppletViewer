package app;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/f")
public final class PopupWindow implements ActionListener, WindowListener {

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "b", descriptor = "I")
	private int anInt4;

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "a", descriptor = "Ljava/awt/List;")
	private List aList1;

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "c", descriptor = "Ljava/awt/Dialog;")
	private Dialog aDialog4;

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public PopupWindow(@OriginalArg(0) String arg0) {
		@Pc(7) Panel local7 = new Panel();
		this.aList1 = new List();
		local7.setLayout(new BorderLayout());
		local7.add(this.aList1, "Center");
		@Pc(26) Panel local26 = new Panel();
		local26.setLayout(new GridLayout(1, 2));
		local7.add(local26, "South");
		@Pc(44) Button local44 = new Button(AppletViewer.translate("ok"));
		local44.setActionCommand("ok");
		local44.addActionListener(this);
		@Pc(57) Button local57 = new Button(AppletViewer.translate("cancel"));
		local57.setActionCommand("cancel");
		local57.addActionListener(this);
		local26.add(local44);
		local26.add(local57);
		this.aDialog4 = new Dialog(AppletViewer.frame, arg0, true);
		this.aDialog4.addWindowListener(this);
		this.aDialog4.setSize(200, 150);
		this.aDialog4.add(local7);
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowDeiconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowDeiconified(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "a", descriptor = "(Z)V")
	private void method32(@OriginalArg(0) boolean arg0) {
		this.anInt4 = -1;
		this.aDialog4.setVisible(false);
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosing(@OriginalArg(0) WindowEvent arg0) {
		this.method32(true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowClosed", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosed(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowIconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowIconified(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowDeactivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowDeactivated(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowOpened", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowOpened(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowActivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowActivated(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "actionPerformed", descriptor = "(Ljava/awt/event/ActionEvent;)V")
	@Override
	public void actionPerformed(@OriginalArg(0) ActionEvent arg0) {
		if (arg0.getActionCommand().equals("ok")) {
			this.anInt4 = this.aList1.getSelectedIndex();
			this.aDialog4.setVisible(false);
		} else {
			this.method32(true);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "a", descriptor = "(I)I")
	public int method33(@OriginalArg(0) int arg0) {
		this.aDialog4.setLocationRelativeTo(AppletViewer.frame);
		this.aDialog4.setVisible(true);
		return this.anInt4;
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "a", descriptor = "([Ljava/lang/String;I)V")
	public void method34(@OriginalArg(0) String[] arg0, @OriginalArg(1) int arg1) {
		this.aList1.removeAll();
		for (@Pc(10) int local10 = 0; local10 < arg0.length; local10++) {
			@Pc(22) String local22 = arg0[local10];
			if (local22 != null) {
				this.aList1.add(local22);
			}
		}
	}
}
