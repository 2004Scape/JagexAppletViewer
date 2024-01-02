package app;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.OutputStream;
import java.io.PrintStream;

final class c extends OutputStream implements WindowListener {
	private boolean a = false;
	private TextArea b;
	private Frame c;
	private PrintStream d;
	private static c e;
	private String f;
	private StringBuffer g = new StringBuffer(1024);

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	static final PrintStream a(int var0, String var1) {
		if (null == e) {
			e = new c(var1);
		}

		if (var0 <= 0) {
			e = (c) null;
		}

		return e.d;
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public final void write(int var1) {
		synchronized (this) {
			if (10 != var1) {
				this.g.append(String.valueOf((char) var1));
				if (!ca.c) {
					return;
				}
			}

			if (!this.a) {
				this.c = new Frame();
				this.c.add(this.b, "Center");
				this.c.setVisible(true);
				this.c.setTitle(this.f);
				this.c.setLocation(320, 240);
				this.c.setSize(720, 260);
				this.c.addWindowListener(this);
				this.a = true;
			}

			this.g.append("\n");
			this.b.append(this.g.toString());
			this.g = new StringBuffer(1024);
		}
	}

	public final void windowClosing(WindowEvent var1) {
		this.c.setVisible(false);
		this.a = false;
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	private c(String var1) {
		this.f = var1;
		this.b = new TextArea();
		this.b.setEditable(false);
		this.d = new PrintStream(this, true);
	}
}
