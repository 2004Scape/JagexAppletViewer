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
	private Dialog aDialog5 = new Dialog(AppletViewer.aFrame1, AppletViewer.method15(1555, "information"), true);

	@OriginalMember(owner = "jagexappletviewer!app/w", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public DialogUrl(@OriginalArg(0) String arg0) {
		@Pc(17) TextArea local17 = new TextArea();
		local17.setText(AppletViewer.method15(1555, "copy_paste_url") + ":\n" + arg0);
		local17.setEditable(false);
		this.aDialog5.add(local17);
		@Pc(46) Button local46 = new Button(AppletViewer.method15(1555, "ok"));
		local46.addActionListener(this);
		@Pc(53) DialogPanel local53 = new DialogPanel();
		local53.setLayout(new FlowLayout(1));
		local53.add(local46);
		this.aDialog5.addWindowListener(this);
		this.aDialog5.add(local53, "South");
		this.aDialog5.setResizable(false);
		this.aDialog5.setSize(400, 150);
		this.aDialog5.setLocationRelativeTo(AppletViewer.aFrame1);
		this.aDialog5.setVisible(true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/w", name = "actionPerformed", descriptor = "(Ljava/awt/event/ActionEvent;)V")
	@Override
	public void actionPerformed(@OriginalArg(0) ActionEvent arg0) {
		this.aDialog5.setVisible(false);
	}

	@OriginalMember(owner = "jagexappletviewer!app/w", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosing(@OriginalArg(0) WindowEvent arg0) {
		this.aDialog5.setVisible(false);
	}
}
