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

final class CopyrightBar extends Component implements MouseListener, MouseMotionListener {
	private CopyrightText[][] lines;
	private CopyrightLink[] links;
	private static Color c = new Color(0x00307a);
	private static Color d = new Color(0xffffff);
	private static Color e = new Color(0xffd200);

	public final void mouseReleased(MouseEvent var1) {
	}

	public final void mouseDragged(MouseEvent var1) {
	}

	public final void paint(Graphics var1) {
		boolean var15 = Preferences.dialogVisible;
		int var2 = this.getWidth();
		FontMetrics var3 = var1.getFontMetrics();
		int var4 = var3.getHeight();
		int var5 = var4;
		if (this.lines != null) {
			int var6 = 0;

			while (this.lines.length > var6) {
				CopyrightText[] var7 = this.lines[var6];
				int var8 = 0;
				int var9 = 0;

				while (~var9 > ~var7.length) {
					var8 += var3.stringWidth(var7[var9].text);
					++var9;
					if (var15) {
						break;
					}
				}

				var9 = (var2 + -var8) / 2;
				int var10 = 0;

				while (~var7.length < ~var10) {
					CopyrightText var11;
					int var12;
					label32:
					{
						var11 = var7[var10];
						var12 = var3.stringWidth(var11.text);
						CopyrightLink var13 = var11.link;
						if (null != var13) {
							var1.setColor(e);
							Rectangle var14 = var13.bounds;
							var14.height = var4;
							var14.y = -var4 + var5;
							var14.x = var9;
							var14.width = var12;
							if (!var15) {
								break label32;
							}
						}

						var1.setColor(d);
					}

					var1.drawString(var11.text, var9, var5);
					var9 += var12;
					++var10;
					if (var15) {
						break;
					}
				}

				var5 += var4;
				++var6;
				if (var15) {
					break;
				}
			}

		}
	}

	public final void mouseClicked(MouseEvent var1) {
	}

	public final void mouseEntered(MouseEvent var1) {
	}

	public final void mousePressed(MouseEvent var1) {
		boolean var4 = Preferences.dialogVisible;
		Point var2 = var1.getPoint();
		int var3 = 0;

		while (~var3 > ~this.links.length) {
			if (this.links[var3].bounds.contains(var2)) {
				UrlThread.showurl(this.links[var3].url, (String) null);
			}

			++var3;
			if (var4) {
				break;
			}
		}

	}

	public final void mouseExited(MouseEvent var1) {
	}

	public final void mouseMoved(MouseEvent var1) {
		boolean var4 = Preferences.dialogVisible;
		Point var2 = var1.getPoint();
		int var3 = 0;

		while (this.links.length > var3) {
			if (this.links[var3].bounds.contains(var2)) {
				this.setCursor(Cursor.getPredefinedCursor(12));
				return;
			}

			++var3;
			if (var4) {
				break;
			}
		}

		this.setCursor(Cursor.getPredefinedCursor(0));
	}

	private final void a(byte var1, String var2) {
		boolean var14 = Preferences.dialogVisible;
		if (null != var2) {
			if (var1 < 113) {
				this.mouseClicked((MouseEvent) null);
			}

			StringTokenizer var3 = new StringTokenizer(var2, "\\");
			this.lines = new CopyrightText[var3.countTokens()][];
			CopyrightText[] var4 = new CopyrightText[100];
			int var5 = 0;

			while (var3.hasMoreTokens()) {
				int var6 = 0;
				String var7 = var3.nextToken();

				do {
					int var8 = var7.indexOf(91);
					if (var8 < 0) {
						var4[var6++] = new CopyrightText(var7);
						if (!var14) {
							break;
						}
					}

					if (var8 > 0) {
						var4[var6++] = new CopyrightText(var7.substring(0, var8));
						var7 = var7.substring(var8);
					}

					int var9 = var7.indexOf(34);
					if (0 > var9) {
						break;
					}

					int var10 = var7.indexOf(34, var9 + 1);
					if (~var10 > -1 && !var14) {
						break;
					}

					int var11 = var7.indexOf(93);
					if (-1 < ~var11) {
						break;
					}

					String var12 = var7.substring(1 + var9, var10);
					String var13 = var7.substring(var10 - -1, var11).trim();
					var4[var6++] = new CopyrightText(var13, var12);
					if (var7.length() <= 1 + var11) {
						break;
					}

					var7 = var7.substring(var11 + 1);
				} while (!var14);

				this.lines[var5] = new CopyrightText[var6];
				System.arraycopy(var4, 0, this.lines[var5], 0, var6);
				++var5;
				if (var14) {
					break;
				}
			}

		}
	}

	CopyrightBar(String var1) {
		super();
		boolean var7 = Preferences.dialogVisible;
		this.lines = (CopyrightText[][]) null;
		this.setBackground(c);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.a((byte) 123, var1);
		if (this.lines != null) {
			int var2 = 0;
			int var3 = 0;

			while (var3 < this.lines.length) {
				CopyrightText[] var4 = this.lines[var3];
				int var5 = 0;

				while (var5 < var4.length) {
					if (null != var4[var5].link) {
						++var2;
					}

					++var5;
					if (var7) {
						break;
					}
				}

				++var3;
				if (var7) {
					break;
				}
			}

			this.links = new CopyrightLink[var2];
			var3 = 0;
			int var8 = 0;

			while (this.lines.length > var8) {
				CopyrightText[] var9 = this.lines[var8];
				int var6 = 0;

				while (var9.length > var6) {
					if (var9[var6].link != null) {
						this.links[var3++] = var9[var6].link;
					}

					++var6;
					if (var7) {
						break;
					}
				}

				++var8;
				if (var7) {
					break;
				}
			}

		}
	}
}
