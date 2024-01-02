package app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

final class p implements Runnable, MouseListener, MouseMotionListener {
	private int a = 0;
	private int b = -1;
	private int c = 0;
	private int d = 0;
	private n e;

	public final void run() {
		boolean var3 = ca.c;

		while (true) {
			while (true) {
				int var1 = this.a;
				if (0 == var1 && !var3) {
					try {
						synchronized (this) {
							this.wait();
						}
					} catch (InterruptedException var5) {
					}
				} else if (-2 == ~var1 && !var3) {
					try {
						Thread.sleep(550L);
					} catch (InterruptedException var9) {
					}

					if (-2 == ~this.a) {
						this.a = 2;
						this.e.setValue(this.e.getValue() - this.d);
					}
				} else if (2 == var1 && !var3) {
					try {
						Thread.sleep(50L);
					} catch (InterruptedException var8) {
					}

					this.e.setValue(this.e.getValue() + -this.d);
				} else if (-4 != ~var1) {
					if (4 == var1) {
						try {
							Thread.sleep(50L);
						} catch (InterruptedException var6) {
						}

						this.e.setValue(this.e.getValue() - -this.d);
					}
				} else {
					try {
						Thread.sleep(550L);
					} catch (InterruptedException var7) {
					}

					if (3 == this.a) {
						this.a = 4;
						this.e.setValue(this.e.getValue() - -this.d);
					}
				}
			}
		}
	}

	public final void mouseDragged(MouseEvent var1) {
		if (this.b >= 0) {
			int var2 = var1.getY();
			this.e.setValue(this.c - -((this.e.g + -this.e.c) * (var2 - this.b) / this.e.j));
		}
	}

	public final void mouseMoved(MouseEvent var1) {
	}

	public final void mousePressed(MouseEvent var1) {
		if (this.e.isEnabled()) {
			this.e.a = true;
			int var2 = this.e.getHeight();
			int var3 = var1.getY();
			if (~var3 <= -16) {
				if (~(-15 + var2) > ~var3) {
					this.e.setValue(this.e.getValue() - -this.e.h);
					this.a = 3;
					this.d = this.e.h;
					synchronized (this) {
						this.notifyAll();
					}
				} else if (var3 < this.e.l + 15) {
					this.e.setValue(this.e.getValue() - this.e.f);
					this.a = 1;
					this.d = this.e.f;
					synchronized (this) {
						this.notifyAll();
					}
				} else if (~(this.e.l + 15 + this.e.k) < ~var3) {
					this.b = var3;
					this.c = this.e.getValue();
				} else {
					this.e.setValue(this.e.getValue() + this.e.f);
					this.d = this.e.f;
					this.a = 3;
					synchronized (this) {
						this.notifyAll();
					}
				}
			} else {
				this.e.setValue(this.e.getValue() - this.e.h);
				this.d = this.e.h;
				this.a = 1;
				synchronized (this) {
					this.notifyAll();
				}
			}
		}
	}

	public final void mouseExited(MouseEvent var1) {
	}

	public final void mouseClicked(MouseEvent var1) {
	}

	p(n var1) {
		this.e = var1;
		Thread var2 = new Thread(this);
		var2.setDaemon(true);
		var2.start();
	}

	public final void mouseReleased(MouseEvent var1) {
		this.b = -1;
		this.a = 0;
		this.e.a = false;
	}

	public final void mouseEntered(MouseEvent var1) {
	}
}
