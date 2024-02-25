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
	private int selectedIndex;

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "a", descriptor = "Ljava/awt/List;")
	private List list;

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "c", descriptor = "Ljava/awt/Dialog;")
	private Dialog dialog;

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public PopupWindow(@OriginalArg(0) String title) {
		@Pc(7) Panel centerPanel = new Panel();
		this.list = new List();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(this.list, "Center");

		@Pc(26) Panel southPanel = new Panel();
		southPanel.setLayout(new GridLayout(1, 2));
		centerPanel.add(southPanel, "South");

		@Pc(44) Button okButton = new Button(AppletViewer.translate("ok"));
		okButton.setActionCommand("ok");
		okButton.addActionListener(this);

		@Pc(57) Button cancelButton = new Button(AppletViewer.translate("cancel"));
		cancelButton.setActionCommand("cancel");
		cancelButton.addActionListener(this);

		southPanel.add(okButton);
		southPanel.add(cancelButton);

		this.dialog = new Dialog(AppletViewer.frame, title, true);
		this.dialog.addWindowListener(this);
		this.dialog.setSize(200, 150);
		this.dialog.add(centerPanel);
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowDeiconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowDeiconified(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "a", descriptor = "(Z)V")
	private void close() {
		this.selectedIndex = -1;
		this.dialog.setVisible(false);
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosing(@OriginalArg(0) WindowEvent e) {
		this.close();
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowClosed", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosed(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowIconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowIconified(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowDeactivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowDeactivated(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowOpened", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowOpened(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "windowActivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowActivated(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "actionPerformed", descriptor = "(Ljava/awt/event/ActionEvent;)V")
	@Override
	public void actionPerformed(@OriginalArg(0) ActionEvent e) {
		if (e.getActionCommand().equals("ok")) {
			this.selectedIndex = this.list.getSelectedIndex();
			this.dialog.setVisible(false);
		} else {
			this.close();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "a", descriptor = "(I)I")
	public int getSelectedIndex() {
		this.dialog.setLocationRelativeTo(AppletViewer.frame);
		this.dialog.setVisible(true);
		return this.selectedIndex;
	}

	@OriginalMember(owner = "jagexappletviewer!app/f", name = "a", descriptor = "([Ljava/lang/String;I)V")
	public void add(@OriginalArg(0) String[] list) {
		this.list.removeAll();

		for (@Pc(10) int i = 0; i < list.length; i++) {
			@Pc(22) String value = list[i];
			if (value != null) {
				this.list.add(value);
			}
		}
	}
}
