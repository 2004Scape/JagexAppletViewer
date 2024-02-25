package app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/p")
public final class PreferencesListener implements Runnable, MouseListener, MouseMotionListener {

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "b", descriptor = "I")
	private int anInt18 = -1;

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "c", descriptor = "I")
	private int anInt19 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "d", descriptor = "I")
	private int anInt20 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "a", descriptor = "I")
	private int anInt17 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "e", descriptor = "Ljagexappletviewer!app/n;")
	private DialogPreferences aDialogPreferences;

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "<init>", descriptor = "(Ljagexappletviewer!app/n;)V")
	public PreferencesListener(@OriginalArg(0) DialogPreferences arg0) {
		this.aDialogPreferences = arg0;
		@Pc(21) Thread thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
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
					this.aDialogPreferences.setValue(this.aDialogPreferences.getValue() - this.anInt20);
				}
			} else if (local4 == 2) {
				try {
					Thread.sleep(50L);
				} catch (@Pc(75) InterruptedException local75) {
				}
				this.aDialogPreferences.setValue(this.aDialogPreferences.getValue() - this.anInt20);
			} else if (local4 == 3) {
				try {
					Thread.sleep(550L);
				} catch (@Pc(90) InterruptedException local90) {
				}
				if (this.anInt17 == 3) {
					this.anInt17 = 4;
					this.aDialogPreferences.setValue(this.aDialogPreferences.getValue() + this.anInt20);
				}
			} else if (local4 == 4) {
				try {
					Thread.sleep(50L);
				} catch (@Pc(113) InterruptedException local113) {
				}
				this.aDialogPreferences.setValue(this.aDialogPreferences.getValue() + this.anInt20);
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mouseDragged", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseDragged(@OriginalArg(0) MouseEvent e) {
		if (this.anInt18 >= 0) {
			@Pc(7) int local7 = e.getY();
			this.aDialogPreferences.setValue(this.anInt19 + (this.aDialogPreferences.maximum - this.aDialogPreferences.minimum) * (local7 - this.anInt18) / this.aDialogPreferences.anInt14);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mouseMoved", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseMoved(@OriginalArg(0) MouseEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mousePressed", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mousePressed(@OriginalArg(0) MouseEvent e) {
		if (!this.aDialogPreferences.isEnabled()) {
			return;
		}

		this.aDialogPreferences.aBoolean10 = true;

		@Pc(13) int local13 = this.aDialogPreferences.getHeight();
		@Pc(16) int local16 = e.getY();
		if (local16 < 15) {
			this.aDialogPreferences.setValue(this.aDialogPreferences.getValue() - this.aDialogPreferences.unitIncrement);
			this.anInt20 = this.aDialogPreferences.unitIncrement;
			this.anInt17 = 1;
			synchronized (this) {
				this.notifyAll();
			}
		} else if (local13 - 15 < local16) {
			this.aDialogPreferences.setValue(this.aDialogPreferences.getValue() + this.aDialogPreferences.unitIncrement);
			this.anInt17 = 3;
			this.anInt20 = this.aDialogPreferences.unitIncrement;
			synchronized (this) {
				this.notifyAll();
			}
		} else if (local16 < this.aDialogPreferences.anInt16 + 15) {
			this.aDialogPreferences.setValue(this.aDialogPreferences.getValue() - this.aDialogPreferences.blockIncrement);
			this.anInt17 = 1;
			this.anInt20 = this.aDialogPreferences.blockIncrement;
			synchronized (this) {
				this.notifyAll();
			}
		} else if (this.aDialogPreferences.anInt16 + this.aDialogPreferences.anInt15 + 15 > local16) {
			this.anInt18 = local16;
			this.anInt19 = this.aDialogPreferences.getValue();
		} else {
			this.aDialogPreferences.setValue(this.aDialogPreferences.getValue() + this.aDialogPreferences.blockIncrement);
			this.anInt20 = this.aDialogPreferences.blockIncrement;
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
		this.aDialogPreferences.aBoolean10 = false;
	}

	@OriginalMember(owner = "jagexappletviewer!app/p", name = "mouseEntered", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseEntered(@OriginalArg(0) MouseEvent arg0) {
	}
}
