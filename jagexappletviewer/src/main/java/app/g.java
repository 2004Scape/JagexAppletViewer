package app;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

final class g extends Canvas implements MouseListener, MouseMotionListener {
	private ActionListener a;
	private int[] b = null;
	private int c = 0;
	private int d = 0;
	private int e = -1;
	private String[] f = new String[10];

	public final void mouseReleased(MouseEvent var1) {
		boolean var4 = Preferences.c;
		this.d = var1.getX();
		var1.getY();
		int var2 = this.e;
		if (null != this.b) {
			this.e = -1;
			int var3 = 0;

			while (var3 < -1 + this.b.length) {
				if (this.b[var3] <= this.d && ~(this.d - -10) > ~this.b[1 + var3]) {
					this.e = var3;
					if (!var4) {
						break;
					}
				}

				++var3;
				if (var4) {
					break;
				}
			}

			if (~var2 != ~this.e) {
				this.repaint();
			}
		}

	}

	public final void mousePressed(MouseEvent var1) {
		boolean var4 = Preferences.c;
		this.d = var1.getX();
		var1.getY();
		int var2 = this.e;
		if (this.b != null) {
			this.e = -1;
			int var3 = 0;

			while (-1 + this.b.length > var3) {
				if (this.b[var3] <= this.d && ~(10 + this.d) > ~this.b[var3 + 1]) {
					this.e = -1;
					this.d = 0;
					this.repaint();
					this.a.actionPerformed(new ActionEvent(this, var3, ""));
					if (!var4) {
						break;
					}
				}

				++var3;
				if (var4) {
					break;
				}
			}

			if (~this.e != ~var2) {
				this.repaint();
			}
		}

	}

	public final void paint(Graphics var1) {
		boolean var9 = Preferences.c;
		int var2 = this.getWidth();
		int var3 = this.getHeight();
		var1.setColor(Color.BLACK);
		var1.fillRect(0, 0, var2, var3);
		var1.setFont(this.getFont());
		FontMetrics var4 = var1.getFontMetrics();
		int var5 = 10;
		int var6 = var4.getAscent() + (var3 - var4.getHeight()) / 2;
		if (this.b == null || ~(1 + this.c) != ~this.b.length) {
			this.b = new int[this.c + 1];
		}

		int var7 = 0;

		while (~this.c < ~var7) {
			int var8;
			label37:
			{
				var8 = var5;
				this.b[var7] = var5;
				var5 += var4.stringWidth(this.f[var7]);
				if (~this.d > ~var8 || var5 <= this.d) {
					var1.setColor(this.getForeground());
					if (!var9) {
						break label37;
					}
				}

				var1.setColor(Color.YELLOW);
			}

			var1.drawString(this.f[var7], var8, var6);
			var5 += 10;
			++var7;
			if (var9) {
				break;
			}
		}

		this.b[this.c] = var5;
	}

	public final void mouseExited(MouseEvent var1) {
		this.d = 0;
		this.e = -1;
		this.repaint();
	}

	public final void mouseMoved(MouseEvent var1) {
		boolean var4 = Preferences.c;
		this.d = var1.getX();
		var1.getY();
		int var2 = this.e;
		if (this.b != null) {
			this.e = -1;
			int var3 = 0;

			while (var3 < -1 + this.b.length) {
				if (~this.d <= ~this.b[var3] && 10 + this.d < this.b[1 + var3]) {
					this.e = var3;
					if (!var4) {
						break;
					}
				}

				++var3;
				if (var4) {
					break;
				}
			}

			if (~this.e != ~var2) {
				this.repaint();
			}
		}

	}

	public final void mouseClicked(MouseEvent var1) {
	}

	public final void mouseEntered(MouseEvent var1) {
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	final void a(byte var1, String var2) {
		if (~this.f.length >= ~this.c) {
			String[] var3 = new String[this.f.length - -5];
			System.arraycopy(this.f, 0, var3, 0, this.f.length);
			this.f = var3;
		}

		this.f[this.c++] = var2;
		if (var1 >= -75) {
			this.e = 122;
		}

	}

	public final void mouseDragged(MouseEvent var1) {
		boolean var4 = Preferences.c;
		this.d = var1.getX();
		var1.getY();
		int var2 = this.e;
		if (null != this.b) {
			this.e = -1;
			int var3 = 0;

			while (~var3 > ~(this.b.length + -1)) {
				if (this.b[var3] <= this.d && ~(10 + this.d) > ~this.b[var3 + 1]) {
					this.e = var3;
					if (!var4) {
						break;
					}
				}

				++var3;
				if (var4) {
					break;
				}
			}

			if (~var2 != ~this.e) {
				this.repaint();
			}
		}

	}

	g(ActionListener var1) {
		this.a = var1;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
}
