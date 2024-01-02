package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

final class ComponentProgress extends Component {
	private String text = "Loading...";
	private static Dialog dialog;
	private Font font;
	private int percent = 0;
	private static ComponentProgress progress;
	private Color barColor = new Color(140, 11, 1);
	private FontMetrics fontMetrics;

	static final void hide(int flowObfuscator) {
		if (flowObfuscator != -1127) {
			setProgress(62, 4);
		}

		if (null != dialog) {
			dialog.setVisible(false);
		}
	}

	static final void setProgress(int percent, int flowObfuscator) {
		if (progress != null) {
			if (percent > 100) {
				percent = 100;
			}

			progress.percent = percent;
			if (flowObfuscator != 140) {
				progress = null;
			}

			progress.repaint();
		}
	}

	static final void refresh(byte flowObfuscator) {
		if (flowObfuscator == -98) {
			progress.paint(progress.getGraphics());
		}
	}

	static final void setText(String text, byte flowObfuscator) {
		progress.text = text;
		progress.repaint();
		if (flowObfuscator != 31) {
			dialog = (Dialog) null;
		}
	}

	static final void init(int flowObfuscator) {
		progress = new ComponentProgress(appletviewer.getLocalization(1555, "loaderbox_initial"));
		progress.font = new Font("Helvetica", 1, 13);
		progress.fontMetrics = progress.getFontMetrics(progress.font);
		dialog = new Dialog(appletviewer.frame, "Jagex Ltd.", false);
		dialog.add(progress);
		dialog.addWindowListener(WindowListener.create(-21945));
		dialog.setResizable(false);
		dialog.setSize(320, 100);
	}

	static final void show(int flowObfuscator) {
		if (flowObfuscator != 2) {
			init(-122);
		}

		dialog.setLocationRelativeTo(appletviewer.frame);
		dialog.setVisible(true);
	}

	private ComponentProgress(String text) {
		this.text = text;
	}

	public final void paint(Graphics g) {
		try {
			if (g != null) {
				int width = this.getWidth();
				int height = this.getHeight();

				g.setColor(Color.black);
				g.fillRect(0, 0, width, height);
				g.setColor(this.barColor);
				g.drawRect(-152 + width / 2, -18 + height / 2, 303, 33);
				g.fillRect(2 + width / 2 + -152, -18 + height / 2 + 2, -3 + this.percent * 303 / 100, 30);

				String str = this.text + " - " + this.percent + "%";
				g.setFont(this.font);
				g.setColor(Color.white);
				g.drawString(str, (width + -this.fontMetrics.stringWidth(str)) / 2, height / 2 - -4);
				if (!Preferences.dialogVisible) {
					return;
				}
			}

			this.repaint();
		} catch (Exception ignored) {
		}
	}
}
