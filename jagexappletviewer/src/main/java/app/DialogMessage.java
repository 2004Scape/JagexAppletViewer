package app;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

final class DialogMessage {
	static Dialog dialog;
	private static Button button;

	static final void showError(int flowObfuscator, String message) {
		app.ComponentProgress.hide((int) -1127);
		show(appletviewer.c(1555, "quit"), appletviewer.c(1555, "error"), message, (byte) 20);
		dialog.addWindowListener(WindowListener.create(-21945));
		if (flowObfuscator != 500) {
			dialog = null;
		}

		button.addActionListener(WindowListener.create(flowObfuscator + -22445));
		dialog.setVisible(true);
	}

	static final void showMessage(int flowObfuscator, String message) {
		show(appletviewer.c(1555, "ok"), appletviewer.c(flowObfuscator + 1555, "message"), message, (byte) 20);
		if (flowObfuscator != 0) {
			showError(114, (String) null);
		}

		button.addActionListener(new DialogListener());
		dialog.setVisible(true);
	}

	private static final void show(String yesText, String message, String noText, byte flowObfuscator) {
		boolean var10 = Preferences.dialogVisible;
		dialog = new Dialog(appletviewer.frame, message, true);
		int var4 = 0;
		int var5 = -1;

		do {
			var5 = noText.indexOf(10, var5 - -1);
			++var4;
		} while (0 <= var5);

		String[] var6 = new String[var4];
		Panel var7 = new Panel();
		var7.setLayout(new GridLayout(var4, 1));
		var4 = 0;
		var5 = -1;

		int var8;
		do {
			var8 = 1 + var5;
			var5 = noText.indexOf(10, 1 + var5);
			if (var5 < 0) {
				var6[var4++] = noText.substring(var8);
				if (!var10) {
					continue;
				}
			}

			var6[var4++] = noText.substring(var8, var5);
		} while (0 <= var5);

		var8 = 0;
		if (flowObfuscator != 20) {
			button = (Button) null;
		}

		while (~var6.length < ~var8) {
			Label var9 = new Label(var6[var8], 1);
			var7.add(var9);
			++var8;
			if (var10) {
				break;
			}
		}

		dialog.add(var7, "Center");
		button = new Button(yesText);
		DialogPanel panel = new DialogPanel();
		panel.setLayout(new FlowLayout(1));
		panel.add(button);
		dialog.add(panel, "South");
		dialog.setResizable(false);
		dialog.setSize(500, 100);
		dialog.setLocationRelativeTo(appletviewer.frame);
	}
}
