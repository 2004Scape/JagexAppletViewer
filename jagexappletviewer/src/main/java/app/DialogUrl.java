package app;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/w")
public final class DialogUrl extends WindowAdapter implements ActionListener {

	@OriginalMember(owner = "jagexappletviewer!app/w", name = "a", descriptor = "Ljava/awt/Dialog;")
	private Dialog dialog = new Dialog(AppletViewer.frame, AppletViewer.translate("information"), true);

	@OriginalMember(owner = "jagexappletviewer!app/w", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public DialogUrl(@OriginalArg(0) String arg0) {
		@Pc(17) TextArea textArea = new TextArea();
		textArea.setText(AppletViewer.translate("copy_paste_url") + ":\n" + arg0);
		textArea.setEditable(false);
		this.dialog.add(textArea);

		@Pc(46) Button button = new Button(AppletViewer.translate("ok"));
		button.addActionListener(this);

		@Pc(53) DialogPanel panel = new DialogPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(button);

		this.dialog.addWindowListener(this);
		this.dialog.add(panel, "South");
		this.dialog.setResizable(false);
		this.dialog.setSize(400, 150);
		this.dialog.setLocationRelativeTo(AppletViewer.frame);
		this.dialog.setVisible(true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/w", name = "actionPerformed", descriptor = "(Ljava/awt/event/ActionEvent;)V")
	@Override
	public void actionPerformed(@OriginalArg(0) ActionEvent e) {
		this.dialog.setVisible(false);
	}

	@OriginalMember(owner = "jagexappletviewer!app/w", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosing(@OriginalArg(0) WindowEvent e) {
		this.dialog.setVisible(false);
	}
}
