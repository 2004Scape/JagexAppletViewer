package app;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.OutputStream;
import java.io.PrintStream;

final class DialogDebug extends OutputStream implements WindowListener {
	private boolean loaded = false;
	private TextArea textArea;
	private Frame frame;
	private PrintStream stream;
	private static DialogDebug e;
	private String title;
	private StringBuffer lines = new StringBuffer(1024);

	public final void windowActivated(WindowEvent event) {
	}

	public final void windowDeactivated(WindowEvent event) {
	}

	public final void windowClosed(WindowEvent event) {
	}

	public final void windowIconified(WindowEvent event) {
	}

	static final PrintStream getPrintStream(int flowObfuscator, String title) {
		if (null == e) {
			e = new DialogDebug(title);
		}

		if (flowObfuscator <= 0) {
			e = null;
		}

		return e.stream;
	}

	public final void windowOpened(WindowEvent event) {
	}

	public final void write(int value) {
		synchronized (this) {
			if (10 != value) {
				this.lines.append(String.valueOf((char) value));
				if (!Preferences.dialogVisible) {
					return;
				}
			}

			if (!this.loaded) {
				this.frame = new Frame();
				this.frame.add(this.textArea, "Center");
				this.frame.setVisible(true);
				this.frame.setTitle(this.title);
				this.frame.setLocation(320, 240);
				this.frame.setSize(720, 260);
				this.frame.addWindowListener(this);
				this.loaded = true;
			}

			this.lines.append("\n");
			this.textArea.append(this.lines.toString());
			this.lines = new StringBuffer(1024);
		}
	}

	public final void windowClosing(WindowEvent event) {
		this.frame.setVisible(false);
		this.loaded = false;
	}

	public final void windowDeiconified(WindowEvent event) {
	}

	private DialogDebug(String title) {
		this.title = title;
		this.textArea = new TextArea();
		this.textArea.setEditable(false);
		this.stream = new PrintStream(this, true);
	}
}
