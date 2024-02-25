package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.StringTokenizer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/j")
public final class CopyrightBar extends Component implements MouseListener, MouseMotionListener {

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "c", descriptor = "Ljava/awt/Color;")
	private static Color BACKGROUND_COLOR = new Color(0x307a);

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "d", descriptor = "Ljava/awt/Color;")
	private static Color TEXT_COLOR = new Color(0xffffff);

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "e", descriptor = "Ljava/awt/Color;")
	private static Color LINK_COLOR = new Color(0xffd200);

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "a", descriptor = "[[Ljagexappletviewer!app/o;")
	private CopyrightText[][] copyrightLines = null;

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "b", descriptor = "[Ljagexappletviewer!app/t;")
	private CopyrightLink[] copyrightLinks;

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public CopyrightBar(@OriginalArg(0) String text) {
		this.setBackground(BACKGROUND_COLOR);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.load(text);

		if (this.copyrightLines != null) {
			@Pc(27) int linkCount = 0;
			for (int i = 0; i < this.copyrightLines.length; i++) {
				@Pc(39) CopyrightText[] line = this.copyrightLines[i];
				for (@Pc(41) int j = 0; j < line.length; j++) {
					if (line[j].url != null) {
						linkCount++;
					}
				}
			}

			this.copyrightLinks = new CopyrightLink[linkCount];
			linkCount = 0;
			for (@Pc(67) int i = 0; i < this.copyrightLines.length; i++) {
				@Pc(77) CopyrightText[] line = this.copyrightLines[i];
				for (@Pc(79) int j = 0; j < line.length; j++) {
					if (line[j].url != null) {
						this.copyrightLinks[linkCount++] = line[j].url;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseReleased", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseReleased(@OriginalArg(0) MouseEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseDragged", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseDragged(@OriginalArg(0) MouseEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics g) {
		@Pc(4) int width = this.getWidth();
		@Pc(7) FontMetrics metrics = g.getFontMetrics();
		@Pc(10) int height = metrics.getHeight();
		@Pc(12) int offsetY = height;

		if (this.copyrightLines == null) {
			return;
		}

		for (@Pc(19) int i = 0; i < this.copyrightLines.length; i++) {
			@Pc(29) CopyrightText[] line = this.copyrightLines[i];
			@Pc(31) int offsetX = 0;

			for (int j = 0; j < line.length; j++) {
				offsetX += metrics.stringWidth(line[j].text);
			}

			int center = (width - offsetX) / 2;
			for (@Pc(62) int j = 0; j < line.length; j++) {
				@Pc(74) CopyrightText text = line[j];
				@Pc(79) int textWidth = metrics.stringWidth(text.text);

				@Pc(82) CopyrightLink link = text.url;
				if (link == null) {
					g.setColor(TEXT_COLOR);
				} else {
					g.setColor(LINK_COLOR);

					@Pc(91) Rectangle rect = link.size;
					rect.height = height;
					rect.y = offsetY - height;
					rect.x = center;
					rect.width = textWidth;
				}

				g.drawString(text.text, center, offsetY);
				center += textWidth;
			}

			offsetY += height;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseClicked", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseClicked(@OriginalArg(0) MouseEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseEntered", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseEntered(@OriginalArg(0) MouseEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mousePressed", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mousePressed(@OriginalArg(0) MouseEvent e) {
		@Pc(4) Point point = e.getPoint();
		for (@Pc(6) int i = 0; i < this.copyrightLinks.length; i++) {
			if (this.copyrightLinks[i].size.contains(point)) {
				UrlThread.showurl(this.copyrightLinks[i].url, null);
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseExited", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseExited(@OriginalArg(0) MouseEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseMoved", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseMoved(@OriginalArg(0) MouseEvent e) {
		@Pc(4) Point point = e.getPoint();
		for (@Pc(6) int i = 0; i < this.copyrightLinks.length; i++) {
			if (this.copyrightLinks[i].size.contains(point)) {
				this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				return;
			}
		}

		this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "a", descriptor = "(BLjava/lang/String;)V")
	private void load(@OriginalArg(1) String text) {
		if (text == null) {
			return;
		}

		@Pc(18) StringTokenizer tokenizer = new StringTokenizer(text, "\\");
		this.copyrightLines = new CopyrightText[tokenizer.countTokens()][];
		@Pc(26) CopyrightText[] line = new CopyrightText[100];
		@Pc(28) int lineCount = 0;

		while (tokenizer.hasMoreTokens()) {
			@Pc(33) int count = 0;
			@Pc(36) String token = tokenizer.nextToken();

			while (true) {
				@Pc(40) int linkStartIndex = token.indexOf('[');
				if (linkStartIndex < 0) {
					line[count++] = new CopyrightText(token);
					break;
				}

				if (linkStartIndex > 0) {
					line[count++] = new CopyrightText(token.substring(0, linkStartIndex));
					token = token.substring(linkStartIndex);
				}

				@Pc(74) int urlStartIndex = token.indexOf('"');
				if (urlStartIndex < 0) {
					break;
				}

				@Pc(84) int urlEndIndex = token.indexOf('"', urlStartIndex + 1);
				if (urlEndIndex < 0) {
					break;
				}

				@Pc(95) int linkEndIndex = token.indexOf(']');
				if (linkEndIndex < 0) {
					break;
				}

				@Pc(107) String url = token.substring(urlStartIndex + 1, urlEndIndex);
				@Pc(115) String urlText = token.substring(urlEndIndex + 1, linkEndIndex).trim();

				line[count++] = new CopyrightText(urlText, url);
				if (token.length() <= linkEndIndex + 1) {
					break;
				}

				token = token.substring(linkEndIndex + 1);
			}

			this.copyrightLines[lineCount] = new CopyrightText[count];
			System.arraycopy(line, 0, this.copyrightLines[lineCount], 0, count);
			lineCount++;
		}
	}
}
