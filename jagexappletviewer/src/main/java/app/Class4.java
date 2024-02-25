package app;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/e")
public final class Class4 {

	@OriginalMember(owner = "jagexappletviewer!app/e", name = "a", descriptor = "Ljava/awt/Dialog;")
	public static Dialog aDialog3;

	@OriginalMember(owner = "jagexappletviewer!app/e", name = "b", descriptor = "Ljava/awt/Button;")
	private static Button aButton1;

	@OriginalMember(owner = "jagexappletviewer!app/e", name = "a", descriptor = "(ILjava/lang/String;)V")
	public static void method29(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
		Component_Sub1.method18(-1127);
		method31(appletviewer.method15(1555, "quit"), appletviewer.method15(1555, "error"), arg1, (byte) 20);
		aDialog3.addWindowListener(WindowAdapter_Sub1.method38(-21945));
		aButton1.addActionListener(WindowAdapter_Sub1.method38(-21945));
		aDialog3.setVisible(true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/e", name = "b", descriptor = "(ILjava/lang/String;)V")
	public static void method30(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
		method31(appletviewer.method15(1555, "ok"), appletviewer.method15(1555, "message"), arg1, (byte) 20);
		aButton1.addActionListener(new Class3());
		aDialog3.setVisible(true);
	}

	@OriginalMember(owner = "jagexappletviewer!app/e", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V")
	private static void method31(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1, @OriginalArg(2) String arg2, @OriginalArg(3) byte arg3) {
		aDialog3 = new Dialog(appletviewer.aFrame1, arg1, true);
		@Pc(10) int local10 = 0;
		@Pc(12) int local12 = -1;
		do {
			local12 = arg2.indexOf(10, local12 + 1);
			local10++;
		} while (local12 >= 0);
		@Pc(26) String[] local26 = new String[local10];
		@Pc(30) Panel local30 = new Panel();
		local30.setLayout(new GridLayout(local10, 1));
		local10 = 0;
		local12 = -1;
		@Pc(45) int local45;
		do {
			local45 = local12 + 1;
			local12 = arg2.indexOf(10, local12 + 1);
			if (local12 < 0) {
				local26[local10++] = arg2.substring(local45);
			} else {
				local26[local10++] = arg2.substring(local45, local12);
			}
		} while (local12 >= 0);
		for (local45 = 0; local45 < local26.length; local45++) {
			@Pc(98) Label local98 = new Label(local26[local45], 1);
			local30.add(local98);
		}
		aDialog3.add(local30, "Center");
		aButton1 = new Button(arg0);
		@Pc(118) Panel_Sub1 local118 = new Panel_Sub1();
		local118.setLayout(new FlowLayout(1));
		local118.add(aButton1);
		aDialog3.add(local118, "South");
		aDialog3.setResizable(false);
		aDialog3.setSize(500, 100);
		aDialog3.setLocationRelativeTo(appletviewer.aFrame1);
	}
}
