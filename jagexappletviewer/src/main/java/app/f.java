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

final class f implements ActionListener, WindowListener {
	private List a;
	private int b;
	private Dialog c;

	public final void windowDeiconified(WindowEvent var1) {
	}

	private final void a(boolean var1) {
		this.b = -1;
		this.c.setVisible(false);
		if (!var1) {
			this.windowActivated((WindowEvent) null);
		}

	}

	public final void windowClosing(WindowEvent var1) {
		this.a(true);
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void actionPerformed(ActionEvent var1) {
		if (var1.getActionCommand().equals("ok")) {
			this.b = this.a.getSelectedIndex();
			this.c.setVisible(false);
			if (!Preferences.c) {
				return;
			}
		}

		this.a(true);
	}

	final int a(int var1) {
		this.c.setLocationRelativeTo(appletviewer.frame);
		if (var1 != -1) {
			this.a(117);
		}

		this.c.setVisible(true);
		return this.b;
	}

	f(String var1) {
		super();
		boolean var6 = Preferences.c;
		Panel var2 = new Panel();
		this.a = new List();
		var2.setLayout(new BorderLayout());
		var2.add(this.a, "Center");
		Panel var3 = new Panel();
		var3.setLayout(new GridLayout(1, 2));
		var2.add(var3, "South");
		Button var4 = new Button(appletviewer.c(1555, "ok"));
		var4.setActionCommand("ok");
		var4.addActionListener(this);
		Button var5 = new Button(appletviewer.c(1555, "cancel"));
		var5.setActionCommand("cancel");
		var5.addActionListener(this);
		var3.add(var4);
		var3.add(var5);
		this.c = new Dialog(appletviewer.frame, var1, true);
		this.c.addWindowListener(this);
		this.c.setSize(200, 150);
		this.c.add(var2);
		if (var6) {
			appletviewer.A = !appletviewer.A;
		}

	}

	final void a(String[] var1, int var2) {
		boolean var5 = Preferences.c;
		this.a.removeAll();
		if (var2 == 2) {
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
