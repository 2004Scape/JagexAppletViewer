package app;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/e")
public final class DialogMessage {

	@OriginalMember(owner = "jagexappletviewer!app/e", name = "a", descriptor = "Ljava/awt/Dialog;")
	public static Dialog dialog;

	@OriginalMember(owner = "jagexappletviewer!app/e", name = "b", descriptor = "Ljava/awt/Button;")
	private static Button button;

	@OriginalMember(owner = "jagexappletviewer!app/e", name = "a", descriptor = "(ILjava/lang/String;)V")
	public static void showError(@OriginalArg(1) String text) {
		ComponentProgress.hideDialog();
		show(AppletViewer.translate("quit"), AppletViewer.translate("error"), text);
		dialog.addWindowListener(WindowListener.create());
		button.addActionListener(WindowListener.create());
		dialog.setVisible(true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/e", name = "b", descriptor = "(ILjava/lang/String;)V")
	public static void showMessage(@OriginalArg(1) String text) {
		show(AppletViewer.translate("ok"), AppletViewer.translate("message"), text);
		button.addActionListener(new DialogListener());
		dialog.setVisible(true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/e", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V")
	private static void show(@OriginalArg(0) String buttonText, @OriginalArg(1) String title, @OriginalArg(2) String text) {
		dialog = new Dialog(AppletViewer.frame, title, true);

		@Pc(10) int local10 = 0;
		@Pc(12) int local12 = -1;
		do {
			local12 = text.indexOf(10, local12 + 1);
			local10++;
		} while (local12 >= 0);
		@Pc(26) String[] local26 = new String[local10];
		@Pc(30) Panel local30 = new Panel();
		local30.setLayout(new GridLayout(local10, 1));
		local10 = 0;
		local12 = -1;
		@Pc(45) int local45;
		do {
			local45 = local12 + 1;
			local12 = text.indexOf(10, local12 + 1);
			if (local12 < 0) {
				local26[local10++] = text.substring(local45);
			} else {
				local26[local10++] = text.substring(local45, local12);
			}
		} while (local12 >= 0);
		for (local45 = 0; local45 < local26.length; local45++) {
			@Pc(98) Label local98 = new Label(local26[local45], 1);
			local30.add(local98);
		}
		dialog.add(local30, "Center");

		button = new Button(buttonText);
		@Pc(118) DialogPanel panel = new DialogPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(button);
		dialog.add(panel, "South");

		dialog.setResizable(false);
		dialog.setSize(500, 100);
		dialog.setLocationRelativeTo(AppletViewer.frame);
	}
}
