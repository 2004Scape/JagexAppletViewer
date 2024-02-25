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
	private static DialogDebug aDialogDebug;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "c", descriptor = "Ljava/awt/Frame;")
	private Frame aFrame2;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "a", descriptor = "Z")
	private boolean aBoolean8 = false;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "g", descriptor = "Ljava/lang/StringBuffer;")
	private StringBuffer aStringBuffer1 = new StringBuffer(1024);

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "f", descriptor = "Ljava/lang/String;")
	private String aString3;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "b", descriptor = "Ljava/awt/TextArea;")
	private TextArea aTextArea1;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "d", descriptor = "Ljava/io/PrintStream;")
	private PrintStream aPrintStream1;

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "a", descriptor = "(ILjava/lang/String;)Ljava/io/PrintStream;")
	public static PrintStream getPrintStream(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
		if (aDialogDebug == null) {
			aDialogDebug = new DialogDebug(arg1);
		}
		if (arg0 <= 0) {
			aDialogDebug = null;
		}
		return aDialogDebug.aPrintStream1;
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	private DialogDebug(@OriginalArg(0) String arg0) {
		this.aString3 = arg0;
		this.aTextArea1 = new TextArea();
		this.aTextArea1.setEditable(false);
		this.aPrintStream1 = new PrintStream(this, true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowActivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowActivated(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowDeactivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowDeactivated(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowClosed", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosed(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowIconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowIconified(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowOpened", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowOpened(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "write", descriptor = "(I)V")
	@Override
	public void write(@OriginalArg(0) int arg0) {
		synchronized (this) {
			if (arg0 == 10) {
				if (!this.aBoolean8) {
					this.aFrame2 = new Frame();
					this.aFrame2.add(this.aTextArea1, "Center");
					this.aFrame2.setVisible(true);
					this.aFrame2.setTitle(this.aString3);
					this.aFrame2.setLocation(320, 240);
					this.aFrame2.setSize(720, 480);
					this.aFrame2.addWindowListener(this);
					this.aBoolean8 = true;
				}
				this.aStringBuffer1.append("\n");
				this.aTextArea1.append(this.aStringBuffer1.toString());
				this.aStringBuffer1 = new StringBuffer(1024);
			} else {
				this.aStringBuffer1.append(String.valueOf((char) arg0));
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowClosing(@OriginalArg(0) WindowEvent arg0) {
		this.aFrame2.setVisible(false);
		this.aBoolean8 = false;
	}

	@OriginalMember(owner = "jagexappletviewer!app/c", name = "windowDeiconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public void windowDeiconified(@OriginalArg(0) WindowEvent arg0) {
	}
}
