package app;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.OutputStream;
import java.io.PrintStream;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/c")
public final class DialogDebug extends OutputStream implements WindowListener {

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "e", descriptor = "Ljagexappletviewer!app/c;")
	private static DialogDebug dialog;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "c", descriptor = "Ljava/awt/Frame;")
	private Frame frame;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "a", descriptor = "Z")
	private boolean loaded = false;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "g", descriptor = "Ljava/lang/StringBuffer;")
	private StringBuffer buffer = new StringBuffer(1024);

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "f", descriptor = "Ljava/lang/String;")
	private String title;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "b", descriptor = "Ljava/awt/TextArea;")
	private TextArea textArea;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "d", descriptor = "Ljava/io/PrintStream;")
	private PrintStream ioStream;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "a", descriptor = "(ILjava/lang/String;)Ljava/io/PrintStream;")
	public static PrintStream getPrintStream(@OriginalArg(1) String title) {
		if (dialog == null) {
			dialog = new DialogDebug(title);
		}
		return dialog.ioStream;
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	private DialogDebug(@OriginalArg(0) String title) {
		this.title = title;
		this.textArea = new TextArea();
		this.textArea.setEditable(false);
		this.ioStream = new PrintStream(this, true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowActivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowActivated(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowDeactivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowDeactivated(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowClosed", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosed(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowIconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowIconified(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowOpened", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowOpened(@OriginalArg(0) WindowEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "write", descriptor = "(I)V")
	@Override
	public void write(@OriginalArg(0) int charCode) {
		synchronized (this) {
			if (charCode == 10) {
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

				this.buffer.append("\n");
				this.textArea.append(this.buffer.toString());
				this.buffer = new StringBuffer(1024);
			} else {
				this.buffer.append((char) charCode);
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosing(@OriginalArg(0) WindowEvent e) {
		this.frame.setVisible(false);
		this.loaded = false;
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowDeiconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowDeiconified(@OriginalArg(0) WindowEvent e) {
	}
}
