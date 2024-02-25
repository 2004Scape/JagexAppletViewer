package app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/p")
public final class Class10 implements Runnable, MouseListener, MouseMotionListener {

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "b", descriptor = "I")
	private int anInt18 = -1;

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "c", descriptor = "I")
	private int anInt19 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "d", descriptor = "I")
	private int anInt20 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "a", descriptor = "I")
	private int anInt17 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "e", descriptor = "Ljagexappletviewer!app/n;")
	private Canvas_Sub2 aCanvas_Sub2_2;

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "<init>", descriptor = "(Ljagexappletviewer!app/n;)V")
	public Class10(@OriginalArg(0) Canvas_Sub2 arg0) {
		this.aCanvas_Sub2_2 = arg0;
		@Pc(21) Thread local21 = new Thread(this);
		local21.setDaemon(true);
		local21.start();
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "run", descriptor = "()V")
	@Override
	public void run() {
		while (true) {
			@Pc(4) int local4 = this.anInt17;
			if (local4 == 0) {
				try {
					synchronized (this) {
						this.wait();
					}
				} catch (@Pc(46) InterruptedException local46) {
				}
			} else if (local4 == 1) {
				try {
					Thread.sleep(550L);
				} catch (@Pc(51) InterruptedException local51) {
				}
				if (this.anInt17 == 1) {
					this.anInt17 = 2;
					this.aCanvas_Sub2_2.setValue(this.aCanvas_Sub2_2.getValue() - this.anInt20);
				}
			} else if (local4 == 2) {
				try {
					Thread.sleep(50L);
				} catch (@Pc(75) InterruptedException local75) {
				}
				this.aCanvas_Sub2_2.setValue(this.aCanvas_Sub2_2.getValue() - this.anInt20);
			} else if (local4 == 3) {
				try {
					Thread.sleep(550L);
				} catch (@Pc(90) InterruptedException local90) {
				}
				if (this.anInt17 == 3) {
					this.anInt17 = 4;
					this.aCanvas_Sub2_2.setValue(this.aCanvas_Sub2_2.getValue() + this.anInt20);
				}
			} else if (local4 == 4) {
				try {
					Thread.sleep(50L);
				} catch (@Pc(113) InterruptedException local113) {
				}
				this.aCanvas_Sub2_2.setValue(this.aCanvas_Sub2_2.getValue() + this.anInt20);
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mouseDragged", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseDragged(@OriginalArg(0) MouseEvent arg0) {
		if (this.anInt18 >= 0) {
			@Pc(7) int local7 = arg0.getY();
			this.aCanvas_Sub2_2.setValue(this.anInt19 + (this.aCanvas_Sub2_2.anInt12 - this.aCanvas_Sub2_2.anInt9) * (local7 - this.anInt18) / this.aCanvas_Sub2_2.anInt14);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mouseMoved", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseMoved(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mousePressed", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mousePressed(@OriginalArg(0) MouseEvent arg0) {
		if (!this.aCanvas_Sub2_2.isEnabled()) {
			return;
		}
		this.aCanvas_Sub2_2.aBoolean10 = true;
		@Pc(13) int local13 = this.aCanvas_Sub2_2.getHeight();
		@Pc(16) int local16 = arg0.getY();
		if (local16 < 15) {
			this.aCanvas_Sub2_2.setValue(this.aCanvas_Sub2_2.getValue() - this.aCanvas_Sub2_2.anInt13);
			this.anInt20 = this.aCanvas_Sub2_2.anInt13;
			this.anInt17 = 1;
			synchronized (this) {
				this.notifyAll();
			}
		} else if (local13 - 15 < local16) {
			this.aCanvas_Sub2_2.setValue(this.aCanvas_Sub2_2.getValue() + this.aCanvas_Sub2_2.anInt13);
			this.anInt17 = 3;
			this.anInt20 = this.aCanvas_Sub2_2.anInt13;
			synchronized (this) {
				this.notifyAll();
			}
		} else if (local16 < this.aCanvas_Sub2_2.anInt16 + 15) {
			this.aCanvas_Sub2_2.setValue(this.aCanvas_Sub2_2.getValue() - this.aCanvas_Sub2_2.anInt11);
			this.anInt17 = 1;
			this.anInt20 = this.aCanvas_Sub2_2.anInt11;
			synchronized (this) {
				this.notifyAll();
			}
		} else if (this.aCanvas_Sub2_2.anInt16 + this.aCanvas_Sub2_2.anInt15 + 15 > local16) {
			this.anInt18 = local16;
			this.anInt19 = this.aCanvas_Sub2_2.getValue();
		} else {
			this.aCanvas_Sub2_2.setValue(this.aCanvas_Sub2_2.getValue() + this.aCanvas_Sub2_2.anInt11);
			this.anInt20 = this.aCanvas_Sub2_2.anInt11;
			this.anInt17 = 3;
			synchronized (this) {
				this.notifyAll();
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mouseExited", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseExited(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mouseClicked", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseClicked(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mouseReleased", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseReleased(@OriginalArg(0) MouseEvent arg0) {
		this.anInt18 = -1;
		this.anInt17 = 0;
		this.aCanvas_Sub2_2.aBoolean10 = false;
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mouseEntered", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseEntered(@OriginalArg(0) MouseEvent arg0) {
	}
}
