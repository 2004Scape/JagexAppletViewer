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
public final class Component_Sub2 extends Component implements MouseListener, MouseMotionListener {

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "c", descriptor = "Ljava/awt/Color;")
	private static Color aColor2 = new Color(12410);

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "d", descriptor = "Ljava/awt/Color;")
	private static Color aColor3 = new Color(16777215);

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "e", descriptor = "Ljava/awt/Color;")
	private static Color aColor4 = new Color(16765440);

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "a", descriptor = "[[Ljagexappletviewer!app/o;")
	private Class9[][] aClass9ArrayArray1 = (Class9[][]) null;

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "b", descriptor = "[Ljagexappletviewer!app/t;")
	private Class14[] aClass14Array1;

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public Component_Sub2(@OriginalArg(0) String arg0) {
		this.setBackground(aColor2);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.method37((byte) 123, arg0);
		if (this.aClass9ArrayArray1 != null) {
			@Pc(27) int local27 = 0;
			@Pc(29) int local29;
			for (local29 = 0; local29 < this.aClass9ArrayArray1.length; local29++) {
				@Pc(39) Class9[] local39 = this.aClass9ArrayArray1[local29];
				for (@Pc(41) int local41 = 0; local41 < local39.length; local41++) {
					if (local39[local41].aClass14_1 != null) {
						local27++;
					}
				}
			}
			this.aClass14Array1 = new Class14[local27];
			local29 = 0;
			for (@Pc(67) int local67 = 0; local67 < this.aClass9ArrayArray1.length; local67++) {
				@Pc(77) Class9[] local77 = this.aClass9ArrayArray1[local67];
				for (@Pc(79) int local79 = 0; local79 < local77.length; local79++) {
					if (local77[local79].aClass14_1 != null) {
						this.aClass14Array1[local29++] = local77[local79].aClass14_1;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseReleased", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseReleased(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseDragged", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseDragged(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics arg0) {
		@Pc(4) int local4 = this.getWidth();
		@Pc(7) FontMetrics local7 = arg0.getFontMetrics();
		@Pc(10) int local10 = local7.getHeight();
		@Pc(12) int local12 = local10;
		if (this.aClass9ArrayArray1 == null) {
			return;
		}
		for (@Pc(19) int local19 = 0; local19 < this.aClass9ArrayArray1.length; local19++) {
			@Pc(29) Class9[] local29 = this.aClass9ArrayArray1[local19];
			@Pc(31) int local31 = 0;
			@Pc(33) int local33;
			for (local33 = 0; local33 < local29.length; local33++) {
				local31 += local7.stringWidth(local29[local33].aString10);
			}
			local33 = (local4 - local31) / 2;
			for (@Pc(62) int local62 = 0; local62 < local29.length; local62++) {
				@Pc(74) Class9 local74 = local29[local62];
				@Pc(79) int local79 = local7.stringWidth(local74.aString10);
				@Pc(82) Class14 local82 = local74.aClass14_1;
				if (local82 == null) {
					arg0.setColor(aColor3);
				} else {
					arg0.setColor(aColor4);
					@Pc(91) Rectangle local91 = local82.aRectangle1;
					local91.height = local10;
					local91.y = local12 - local10;
					local91.x = local33;
					local91.width = local79;
				}
				arg0.drawString(local74.aString10, local33, local12);
				local33 += local79;
			}
			local12 += local10;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseClicked", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseClicked(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseEntered", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseEntered(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mousePressed", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mousePressed(@OriginalArg(0) MouseEvent arg0) {
		@Pc(4) Point local4 = arg0.getPoint();
		for (@Pc(6) int local6 = 0; local6 < this.aClass14Array1.length; local6++) {
			if (this.aClass14Array1[local6].aRectangle1.contains(local4)) {
				Class7.showurl(this.aClass14Array1[local6].aString11, null);
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseExited", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseExited(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "mouseMoved", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public void mouseMoved(@OriginalArg(0) MouseEvent arg0) {
		@Pc(4) Point local4 = arg0.getPoint();
		for (@Pc(6) int local6 = 0; local6 < this.aClass14Array1.length; local6++) {
			if (this.aClass14Array1[local6].aRectangle1.contains(local4)) {
				this.setCursor(Cursor.getPredefinedCursor(12));
				return;
			}
		}
		this.setCursor(Cursor.getPredefinedCursor(0));
	}

	@OriginalMember(owner = "jagexappletviewer!app/j", name = "a", descriptor = "(BLjava/lang/String;)V")
	private void method37(@OriginalArg(0) byte arg0, @OriginalArg(1) String arg1) {
		if (arg1 == null) {
			return;
		}
		@Pc(18) StringTokenizer local18 = new StringTokenizer(arg1, "\\");
		this.aClass9ArrayArray1 = new Class9[local18.countTokens()][];
		@Pc(26) Class9[] local26 = new Class9[100];
		@Pc(28) int local28 = 0;
		while (local18.hasMoreTokens()) {
			@Pc(33) int local33 = 0;
			@Pc(36) String local36 = local18.nextToken();
			while (true) {
				@Pc(40) int local40 = local36.indexOf(91);
				if (local40 < 0) {
					local26[local33++] = new Class9(local36);
					break;
				}
				if (local40 > 0) {
					local26[local33++] = new Class9(local36.substring(0, local40));
					local36 = local36.substring(local40);
				}
				@Pc(74) int local74 = local36.indexOf(34);
				if (local74 < 0) {
					break;
				}
				@Pc(84) int local84 = local36.indexOf(34, local74 + 1);
				if (local84 < 0) {
					break;
				}
				@Pc(95) int local95 = local36.indexOf(93);
				if (local95 < 0) {
					break;
				}
				@Pc(107) String local107 = local36.substring(local74 + 1, local84);
				@Pc(115) String local115 = local36.substring(local84 + 1, local95).trim();
				local26[local33++] = new Class9(local115, local107);
				if (local36.length() <= local95 + 1) {
					break;
				}
				local36 = local36.substring(local95 + 1);
			}
			this.aClass9ArrayArray1[local28] = new Class9[local33];
			System.arraycopy(local26, 0, this.aClass9ArrayArray1[local28], 0, local33);
			local28++;
		}
	}
}
