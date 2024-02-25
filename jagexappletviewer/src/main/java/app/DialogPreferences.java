package app;

import java.awt.Adjustable;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Iterator;
import java.util.LinkedList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/n")
public final class DialogPreferences extends Canvas implements Adjustable {

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "j", descriptor = "I")
	public int anInt14;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "k", descriptor = "I")
	public int anInt15;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "l", descriptor = "I")
	public int anInt16;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "b", descriptor = "I")
	private int anInt8 = 20;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "h", descriptor = "I")
	public int anInt13 = 10;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "f", descriptor = "I")
	public int anInt11 = 100;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "g", descriptor = "I")
	public int anInt12 = 100;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "c", descriptor = "I")
	public int anInt9 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "a", descriptor = "Z")
	public boolean aBoolean10 = false;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "d", descriptor = "I")
	private int anInt10 = 0;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "e", descriptor = "Ljava/util/LinkedList;")
	private LinkedList aLinkedList1 = new LinkedList();

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "i", descriptor = "Ljava/awt/Image;")
	private Image anImage1 = null;

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "<init>", descriptor = "()V")
	public DialogPreferences() {
		this.setMinimumSize(new Dimension(15, 40));
		this.setPreferredSize(new Dimension(15, Integer.MAX_VALUE));
		this.setMaximumSize(new Dimension(15, Integer.MAX_VALUE));
		this.setBackground(Color.BLACK);
		@Pc(59) PreferencesListener local59 = new PreferencesListener(this);
		this.addMouseListener(local59);
		this.addMouseMotionListener(local59);
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "setValue", descriptor = "(I)V")
	@Override
	public void setValue(@OriginalArg(0) int arg0) {
		if (arg0 < this.anInt9) {
			arg0 = this.anInt9;
		}
		if (this.anInt12 - this.anInt8 < arg0) {
			arg0 = this.anInt12 - this.anInt8;
		}
		this.anInt10 = arg0;
		this.repaint();
		this.method40(-91, new AdjustmentEvent(this, 601, 5, this.anInt10, this.aBoolean10));
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "getMaximum", descriptor = "()I")
	@Override
	public int getMaximum() {
		return this.anInt12;
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "setVisibleAmount", descriptor = "(I)V")
	@Override
	public void setVisibleAmount(@OriginalArg(0) int arg0) {
		this.anInt8 = arg0;
		this.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "getBlockIncrement", descriptor = "()I")
	@Override
	public int getBlockIncrement() {
		return this.anInt11;
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "setMinimum", descriptor = "(I)V")
	@Override
	public void setMinimum(@OriginalArg(0) int arg0) {
		this.anInt9 = arg0;
		this.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "getMinimum", descriptor = "()I")
	@Override
	public int getMinimum() {
		return this.anInt9;
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "getOrientation", descriptor = "()I")
	@Override
	public int getOrientation() {
		return 1;
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "a", descriptor = "(I)Z")
	private boolean method39(@OriginalArg(0) int arg0) {
		@Pc(4) boolean local4 = this.isEnabled();
		@Pc(7) int local7 = this.getHeight();
		if (local7 == 0) {
			return false;
		}
		if (this.anImage1 == null || this.anImage1.getHeight(null) != local7) {
			this.anImage1 = this.createImage(15, local7);
		}
		if (this.anImage1 == null) {
			return false;
		}
		@Pc(38) Graphics local38 = this.anImage1.getGraphics();
		this.anInt14 = local7 - 30;
		local38.setColor(Color.BLACK);
		local38.fillRect(3, 15, 9, this.anInt14);
		if (local4) {
			local38.setColor(Color.GRAY);
		} else {
			local38.setColor(Color.DARK_GRAY);
		}
		local38.drawRoundRect(0, 0, 14, local7 - 1, 3, 3);
		for (@Pc(75) int local75 = 0; local75 < 3; local75++) {
			local38.drawLine(7 - local75, local75 + 5, local75 + 7, local75 + 5);
			local38.drawLine(7 - local75, local7 - -1 + -7 - local75, local75 + 7, -local75 + 1 + -7 + local7);
		}
		if (local4) {
			this.anInt16 = this.anInt10 * this.anInt14 / (this.anInt12 - this.anInt9);
			this.anInt15 = this.anInt14 * this.anInt8 / (this.anInt12 - this.anInt9);
		} else {
			this.anInt16 = 0;
			this.anInt15 = this.anInt14;
		}
		local38.fillRect(3, this.anInt16 + 2 + 15, 9, this.anInt15 - 4);
		local38.drawLine(4, this.anInt16 + 15 + 1, 10, this.anInt16 + 16);
		local38.drawLine(4, this.anInt16 + this.anInt15 + 15 - 2, 10, this.anInt15 + this.anInt16 + 15 - 2);
		local38.drawLine(6, this.anInt16 + 15, 8, this.anInt16 + 15);
		local38.drawLine(6, this.anInt15 + this.anInt16 + 15 - 1, 8, this.anInt16 + this.anInt15 + 15 - 1);
		local38.dispose();
		return true;
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "addAdjustmentListener", descriptor = "(Ljava/awt/event/AdjustmentListener;)V")
	@Override
	public void addAdjustmentListener(@OriginalArg(0) AdjustmentListener arg0) {
		this.aLinkedList1.add(arg0);
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "setUnitIncrement", descriptor = "(I)V")
	@Override
	public void setUnitIncrement(@OriginalArg(0) int arg0) {
		this.anInt13 = arg0;
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void update(@OriginalArg(0) Graphics arg0) {
		this.paint(arg0);
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "setMaximum", descriptor = "(I)V")
	@Override
	public void setMaximum(@OriginalArg(0) int arg0) {
		this.anInt12 = arg0;
		this.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics arg0) {
		if (this.method39(-1)) {
			arg0.drawImage(this.anImage1, 0, 0, null);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "a", descriptor = "(ILjava/awt/event/AdjustmentEvent;)V")
	private void method40(@OriginalArg(0) int arg0, @OriginalArg(1) AdjustmentEvent arg1) {
		@Pc(5) Iterator local5 = this.aLinkedList1.iterator();
		@Pc(13) boolean local13 = false;
		while (local5.hasNext()) {
			@Pc(20) AdjustmentListener local20 = (AdjustmentListener) local5.next();
			local20.adjustmentValueChanged(arg1);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "removeAdjustmentListener", descriptor = "(Ljava/awt/event/AdjustmentListener;)V")
	@Override
	public void removeAdjustmentListener(@OriginalArg(0) AdjustmentListener arg0) {
		this.aLinkedList1.remove(this.anInt8);
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "setBlockIncrement", descriptor = "(I)V")
	@Override
	public void setBlockIncrement(@OriginalArg(0) int arg0) {
		this.anInt11 = arg0;
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "setEnabled", descriptor = "(Z)V")
	@Override
	public void setEnabled(@OriginalArg(0) boolean arg0) {
		super.setEnabled(arg0);
		this.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "getUnitIncrement", descriptor = "()I")
	@Override
	public int getUnitIncrement() {
		return this.anInt13;
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "getValue", descriptor = "()I")
	@Override
	public int getValue() {
		return this.anInt10;
	}

	@OriginalMember(owner = "jagexappletviewer!app/n", name = "getVisibleAmount", descriptor = "()I")
	@Override
	public int getVisibleAmount() {
		return this.anInt8;
	}
}
