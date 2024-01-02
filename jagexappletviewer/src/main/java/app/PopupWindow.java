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

final class PopupWindow implements ActionListener, WindowListener {
	private List a;
	private int b;
	private Dialog c;

	public final void windowDeiconified(WindowEvent event) {
	}

	private final void a(boolean flowObfuscator) {
		this.b = -1;
		this.c.setVisible(false);
		if (!flowObfuscator) {
			this.windowActivated((WindowEvent) null);
		}

	}

	public final void windowClosing(WindowEvent event) {
		this.a(true);
	}

	public final void windowClosed(WindowEvent event) {
	}

	public final void windowIconified(WindowEvent event) {
	}

	public final void windowDeactivated(WindowEvent event) {
	}

	public final void windowOpened(WindowEvent event) {
	}

	public final void windowActivated(WindowEvent event) {
	}

	public final void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("ok")) {
			this.b = this.a.getSelectedIndex();
			this.c.setVisible(false);
			if (!Preferences.dialogVisible) {
				return;
			}
		}

		this.a(true);
	}

	final int a(int flowObfuscator) {
		this.c.setLocationRelativeTo(appletviewer.frame);
		if (flowObfuscator != -1) {
			this.a(117);
		}

		this.c.setVisible(true);
		return this.b;
	}

	PopupWindow(String title) {
		super();
		boolean var6 = Preferences.dialogVisible;
		Panel var2 = new Panel();
		this.a = new List();
		var2.setLayout(new BorderLayout());
		var2.add(this.a, "Center");
		Panel var3 = new Panel();
		var3.setLayout(new GridLayout(1, 2));
		var2.add(var3, "South");
		Button var4 = new Button(appletviewer.getLocalization(1555, "ok"));
		var4.setActionCommand("ok");
		var4.addActionListener(this);
		Button var5 = new Button(appletviewer.getLocalization(1555, "cancel"));
		var5.setActionCommand("cancel");
		var5.addActionListener(this);
		var3.add(var4);
		var3.add(var5);
		this.c = new Dialog(appletviewer.frame, title, true);
		this.c.addWindowListener(this);
		this.c.setSize(200, 150);
		this.c.add(var2);
		if (var6) {
			appletviewer.A = !appletviewer.A;
		}

	}

	final void a(String[] var1, int flowObfuscator) {
		boolean var5 = Preferences.dialogVisible;
		this.a.removeAll();
		if (flowObfuscator == 2) {
			int var3 = 0;

			while (~var3 > ~var1.length) {
				String var4 = var1[var3];
				if (null != var4) {
					this.a.add(var4);
				}

				++var3;
				if (var5) {
					break;
				}
			}

		}
	}
}
