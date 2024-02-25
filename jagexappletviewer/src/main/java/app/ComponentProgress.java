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
	private static Dialog dialog;

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "e", descriptor = "Ljagexappletviewer!app/b;")
	private static ComponentProgress progress;

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "c", descriptor = "Ljava/awt/Font;")
	private Font activeFont;

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "g", descriptor = "Ljava/awt/FontMetrics;")
	private FontMetrics activeFontMetrics;

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "a", descriptor = "Ljava/lang/String;")
	private String text = "Loading...";

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "d", descriptor = "I")
	private int value = 0;

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "f", descriptor = "Ljava/awt/Color;")
	private Color BAR_COLOR = new Color(140, 11, 1);

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "a", descriptor = "(I)V")
	public static void hideDialog() {
		if (dialog != null) {
			dialog.setVisible(false);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "a", descriptor = "(II)V")
	public static void updateProgress(@OriginalArg(0) int value) {
		if (progress == null) {
			return;
		}

		if (value > 100) {
			value = 100;
		}

		progress.value = value;
		progress.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "a", descriptor = "(B)V")
	public static void paint() {
		progress.paint(progress.getGraphics());
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "a", descriptor = "(Ljava/lang/String;B)V")
	public static void setText(@OriginalArg(0) String text) {
		progress.text = text;
		progress.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "b", descriptor = "(I)V")
	public static void init(@OriginalArg(0) int fontStyle) {
		progress = new ComponentProgress(AppletViewer.translate("loaderbox_initial"));
		progress.activeFont = new Font("Helvetica", fontStyle, 13);
		progress.activeFontMetrics = progress.getFontMetrics(progress.activeFont);

		dialog = new Dialog(AppletViewer.frame, "Jagex Ltd.", false);
		dialog.add(progress);
		dialog.addWindowListener(WindowListener.create());
		dialog.setResizable(false);
		dialog.setSize(320, 100);
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "c", descriptor = "(I)V")
	public static void showDialog() {
		dialog.setLocationRelativeTo(AppletViewer.frame);
		dialog.setVisible(true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	private ComponentProgress(@OriginalArg(0) String text) {
		this.text = text;
	}

	@OriginalMember(owner = "jagexappletviewer!app/b", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics g) {
		try {
			if (g == null) {
				this.repaint();
			} else {
				@Pc(4) int width = this.getWidth();
				@Pc(7) int height = this.getHeight();

				g.setColor(Color.black);
				g.fillRect(0, 0, width, height);

				g.setColor(this.BAR_COLOR);
				g.drawRect(width / 2 - 152, height / 2 + -18, 303, 33);
				g.fillRect(width / 2 + 2 - 152, height / 2 + -18 + 2, this.value * 303 / 100 - 3, 30);

				@Pc(74) String str = this.text + " - " + this.value + "%";
				g.setFont(this.activeFont);
				g.setColor(Color.white);
				g.drawString(str, (width - this.activeFontMetrics.stringWidth(str)) / 2, height / 2 + 4);
			}
		} catch (@Pc(104) Exception ignored) {
		}
	}
}
