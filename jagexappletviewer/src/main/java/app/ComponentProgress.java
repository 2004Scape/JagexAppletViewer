package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/b")
public final class ComponentProgress extends Component {

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "b", descriptor = "Ljava/awt/Dialog;")
	private static Dialog aDialog1;

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "e", descriptor = "Ljagexappletviewer!app/b;")
	private static ComponentProgress aComponent_Progress;

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "c", descriptor = "Ljava/awt/Font;")
	private Font aFont1;

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "g", descriptor = "Ljava/awt/FontMetrics;")
	private FontMetrics aFontMetrics1;

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "a", descriptor = "Ljava/lang/String;")
	private String aString2 = "Loading...";

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "d", descriptor = "I")
	private int anInt3 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "f", descriptor = "Ljava/awt/Color;")
	private Color aColor1 = new Color(140, 11, 1);

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "a", descriptor = "(I)V")
	public static void method18(@OriginalArg(0) int arg0) {
		if (aDialog1 != null) {
			aDialog1.setVisible(false);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "a", descriptor = "(II)V")
	public static void method19(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		if (aComponent_Progress == null) {
			return;
		}
		if (arg0 > 100) {
			arg0 = 100;
		}
		aComponent_Progress.anInt3 = arg0;
		aComponent_Progress.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "a", descriptor = "(B)V")
	public static void method20(@OriginalArg(0) byte arg0) {
		aComponent_Progress.paint(aComponent_Progress.getGraphics());
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "a", descriptor = "(Ljava/lang/String;B)V")
	public static void method21(@OriginalArg(0) String arg0, @OriginalArg(1) byte arg1) {
		aComponent_Progress.aString2 = arg0;
		aComponent_Progress.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "b", descriptor = "(I)V")
	public static void method22(@OriginalArg(0) int arg0) {
		aComponent_Progress = new ComponentProgress(AppletViewer.method15(arg0 + 1554, "loaderbox_initial"));
		aComponent_Progress.aFont1 = new Font("Helvetica", arg0, 13);
		aComponent_Progress.aFontMetrics1 = aComponent_Progress.getFontMetrics(aComponent_Progress.aFont1);
		aDialog1 = new Dialog(AppletViewer.aFrame1, "Jagex Ltd.", false);
		aDialog1.add(aComponent_Progress);
		aDialog1.addWindowListener(WindowListener.method38(-21945));
		aDialog1.setResizable(false);
		aDialog1.setSize(320, 100);
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "c", descriptor = "(I)V")
	public static void method23(@OriginalArg(0) int arg0) {
		aDialog1.setLocationRelativeTo(AppletViewer.aFrame1);
		aDialog1.setVisible(true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	private ComponentProgress(@OriginalArg(0) String arg0) {
		this.aString2 = arg0;
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics arg0) {
		try {
			if (arg0 == null) {
				this.repaint();
			} else {
				@Pc(4) int local4 = this.getWidth();
				@Pc(7) int local7 = this.getHeight();
				arg0.setColor(Color.black);
				arg0.fillRect(0, 0, local4, local7);
				arg0.setColor(this.aColor1);
				arg0.drawRect(local4 / 2 - 152, local7 / 2 + -18, 303, 33);
				arg0.fillRect(local4 / 2 + 2 - 152, local7 / 2 + -18 + 2, this.anInt3 * 303 / 100 - 3, 30);
				@Pc(74) String local74 = this.aString2 + " - " + this.anInt3 + "%";
				arg0.setFont(this.aFont1);
				arg0.setColor(Color.white);
				arg0.drawString(local74, (local4 - this.aFontMetrics1.stringWidth(local74)) / 2, local7 / 2 + 4);
			}
		} catch (@Pc(104) Exception local104) {
		}
	}
}
