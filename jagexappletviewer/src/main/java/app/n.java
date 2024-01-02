package app;

import java.awt.Adjustable;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.LinkedList;

final class n extends Canvas implements Adjustable {
	boolean a = false;
	private int b = 20;
	int c = 0;
	private int d = 0;
	private LinkedList e = new LinkedList();
	int f = 100;
	int g = 100;
	int h = 10;
	private Image i = null;
	int j;
	int k;
	int l;

	public final void setValue(int var1) {
		if (var1 < this.c) {
			var1 = this.c;
		}

		if (~(this.g + -this.b) > ~var1) {
			var1 = -this.b + this.g;
		}

		this.d = var1;
		this.repaint();
		this.a(-91, new AdjustmentEvent(this, 601, 5, this.d, this.a));
	}

	public final int getMaximum() {
		return this.g;
	}

	public final void setVisibleAmount(int var1) {
		this.b = var1;
		this.repaint();
	}

	public final int getBlockIncrement() {
		return this.f;
	}

	public final void setMinimum(int var1) {
		this.c = var1;
		this.repaint();
	}

	public final int getMinimum() {
		return this.c;
	}

	public final int getOrientation() {
		return 1;
	}

	private final boolean a(int var1) {
		boolean var6 = Preferences.c;
		boolean var2 = this.isEnabled();
		int var3 = this.getHeight();
		if (var3 == 0) {
			return false;
		} else {
			if (this.i == null || this.i.getHeight((ImageObserver) null) != var3) {
				this.i = this.createImage(15, var3);
			}

			if (null == this.i) {
				return false;
			} else {
				Graphics var4;
				label40:
				{
					var4 = this.i.getGraphics();
					this.j = var3 - 30;
					var4.setColor(Color.BLACK);
					var4.fillRect(3, 15, 9, this.j);
					if (var2) {
						var4.setColor(Color.GRAY);
						if (!var6) {
							break label40;
						}
					}

					var4.setColor(Color.DARK_GRAY);
				}

				var4.drawRoundRect(0, 0, 14, var3 - 1, 3, 3);
				int var5 = 0;

				while (var5 < 3) {
					var4.drawLine(7 - var5, var5 + 5, 7 - -var5, var5 + 5);
					var4.drawLine(-var5 + 7, -7 + (var3 - -1) - var5, 7 - -var5, -var5 + 1 + -7 + var3);
					++var5;
					if (var6) {
						break;
					}
				}

				label28:
				{
					if (!var2) {
						this.l = 0;
						this.k = this.j;
						if (!var6) {
							break label28;
						}
					}

					this.l = this.d * this.j / (this.g - this.c);
					this.k = this.j * this.b / (this.g - this.c);
				}

				var4.fillRect(3, 2 + this.l - -15, 9, this.k + -4);
				var4.drawLine(4, this.l - -15 + 1, 10, 16 + this.l);
				var4.drawLine(4, -2 + 15 + this.l + this.k, 10, -2 + this.k + 15 + this.l);
				var4.drawLine(6, 15 + this.l, 8, 15 + this.l);
				var4.drawLine(6, -1 + this.k + (this.l - -15), 8, var1 + this.l - (-15 - this.k));
				var4.dispose();
				return true;
			}
		}
	}

	public final void addAdjustmentListener(AdjustmentListener var1) {
		this.e.add(var1);
	}

	public final void setUnitIncrement(int var1) {
		this.h = var1;
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	public final void setMaximum(int var1) {
		this.g = var1;
		this.repaint();
	}

	public final void paint(Graphics var1) {
		if (this.a(-1)) {
			var1.drawImage(this.i, 0, 0, (ImageObserver) null);
		}

	}

	private final void a(int var1, AdjustmentEvent var2) {
		boolean var6 = Preferences.c;
		Iterator var3 = this.e.iterator();
		int var4 = 1 / ((12 - var1) / 48);

		while (var3.hasNext()) {
			AdjustmentListener var5 = (AdjustmentListener) var3.next();
			var5.adjustmentValueChanged(var2);
			if (var6) {
				break;
			}
		}

	}

	public final void removeAdjustmentListener(AdjustmentListener var1) {
		this.e.remove(this.b);
	}

	public final void setBlockIncrement(int var1) {
		this.f = var1;
	}

	public final void setEnabled(boolean var1) {
		super.setEnabled(var1);
		this.repaint();
	}

	public final int getUnitIncrement() {
		return this.h;
	}

	public final int getValue() {
		return this.d;
	}

	public final int getVisibleAmount() {
		return this.b;
	}

	public n() {
		this.setMinimumSize(new Dimension(15, 40));
		this.setPreferredSize(new Dimension(15, Integer.MAX_VALUE));
		this.setMaximumSize(new Dimension(15, Integer.MAX_VALUE));
		this.setBackground(Color.BLACK);
		p var1 = new p(this);
		this.addMouseListener(var1);
		this.addMouseMotionListener(var1);
	}
}
