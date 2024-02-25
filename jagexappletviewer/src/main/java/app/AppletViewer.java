package app;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import nativeadvert.browsercontrol;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/appletviewer")
public final class AppletViewer implements ComponentListener, AdjustmentListener {

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "Ljagexappletviewer!app/g;")
	private static TopPanelBar aTopPanelBar;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "b", descriptor = "Ljava/awt/Component;")
	private static Component aComponent1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "c", descriptor = "Ljagexappletviewer!app/f;")
	private static PopupWindow aPopupWindow_1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "d", descriptor = "Ljava/applet/Applet;")
	private static Applet anApplet1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "e", descriptor = "Ljava/awt/Frame;")
	public static Frame aFrame1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "f", descriptor = "Ljagexappletviewer!app/n;")
	private static DialogPreferences aDialogPreferences_1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "g", descriptor = "Z")
	public static boolean aBoolean1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "j", descriptor = "Ljava/awt/Panel;")
	private static Panel aPanel1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "k", descriptor = "Ljagexappletviewer!app/f;")
	private static PopupWindow aPopupWindow_2;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "l", descriptor = "Z")
	private static boolean aBoolean3;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "m", descriptor = "Ljava/awt/Canvas;")
	private static Canvas aCanvas1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "s", descriptor = "[Ljava/lang/String;")
	private static String[] aStringArray1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "v", descriptor = "[I")
	private static int[] anIntArray1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "B", descriptor = "I")
	private static int anInt1;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "C", descriptor = "Z")
	private static boolean aBoolean7;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "D", descriptor = "I")
	private static int anInt2;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "i", descriptor = "Z")
	public static boolean aBoolean2 = false;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "h", descriptor = "Ljava/util/Hashtable;")
	private static Hashtable aHashtable1 = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "n", descriptor = "Ljava/util/Hashtable;")
	private static Hashtable aHashtable2 = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "o", descriptor = "Ljava/util/Hashtable;")
	public static Hashtable aHashtable3 = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "q", descriptor = "Ljagexappletviewer!app/m;")
	private static Config aConfig_1 = null;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "t", descriptor = "F")
	private static float aFloat2 = 58988.0F;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "u", descriptor = "[Ljagexappletviewer!app/m;")
	private static Config[] aConfigArray1 = null;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "x", descriptor = "Ljava/io/File;")
	private static File aFile1 = null;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "w", descriptor = "Ljava/lang/String;")
	private static String aString1 = null;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "y", descriptor = "Z")
	private static boolean aBoolean5 = false;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "r", descriptor = "Z")
	private static boolean aBoolean4 = true;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "p", descriptor = "F")
	private static float aFloat1 = 0.0F;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(B)V")
	public static void method1(@OriginalArg(0) byte arg0) {
		@Pc(1) boolean local1 = false;
		if (!aTopPanelBar.isVisible()) {
			local1 = true;
			aTopPanelBar.setVisible(true);
		}
		if (!aComponent1.isVisible()) {
			aComponent1.setVisible(true);
			local1 = true;
		}
		if (local1) {
			method3((byte) -103);
		}
		if (arg0 != -99) {
			aString1 = null;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(I)I")
	public static int method2(@OriginalArg(0) int arg0) {
		@Pc(7) boolean local7 = true;
		@Pc(11) int local11 = aPopupWindow_1.method33(-1);
		if (local11 < 0) {
			return -1;
		} else {
			Preferences.method26(Integer.toString(anIntArray1[local11]), -128, "Language");
			Preferences.method27((byte) 124);
			return local11;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "b", descriptor = "(B)V")
	private static void method3(@OriginalArg(0) byte arg0) {
		if (!aBoolean5) {
			return;
		}
		@Pc(10) int local10 = aTopPanelBar.isVisible() ? 20 : 0;
		@Pc(20) int local20 = aCanvas1 == null ? 0 : Integer.parseInt(method13("advert_height", true));
		@Pc(27) int local27 = aComponent1.isVisible() ? 40 : 0;
		@Pc(32) int local32 = Integer.parseInt(method13("applet_minwidth", true));
		@Pc(37) int local37 = Integer.parseInt(method13("applet_minheight", true));
		@Pc(42) int local42 = Integer.parseInt(method13("applet_maxwidth", true));
		@Pc(47) int local47 = Integer.parseInt(method13("applet_maxheight", true));
		@Pc(50) Dimension local50 = aPanel1.getSize();
		@Pc(60) Insets local60 = aPanel1.getInsets();
		@Pc(71) int local71 = local50.width - local60.left - local60.right;
		@Pc(82) int local82 = local50.height - local60.top - local60.bottom;
		@Pc(84) int local84 = local71;
		@Pc(94) int local94 = local82 - local10 - local20 - local27;
		if (local32 > local71) {
			local84 = local32;
		}
		@Pc(102) boolean local102 = false;
		if (local94 < local37) {
			local102 = true;
			local94 = local37;
		}
		if (local102) {
			if (aDialogPreferences_1.getParent() == null) {
				aFrame1.add(aDialogPreferences_1, "East");
				aDialogPreferences_1.setValue(0);
				aFrame1.validate();
			}
		} else if (aDialogPreferences_1.getParent() != null) {
			aFrame1.remove(aDialogPreferences_1);
			aFrame1.validate();
		}
		if (aBoolean4) {
			if (local47 < local94) {
				local94 = local47;
			}
			if (local42 < local84) {
				local84 = local42;
			}
		}
		@Pc(162) int local162 = local71;
		if (local71 < local32) {
			local162 = local32;
		}
		if (local27 + local20 + local37 + local10 > local82) {
			@Pc(193) int local193 = local20 + local37 + local27 + local10;
		}
		@Pc(196) int local196 = 0;
		if (aDialogPreferences_1.getParent() != null) {
			local196 = aDialogPreferences_1.getValue();
			@Pc(211) int local211 = local27 + local20 + local10 + local94;
			if (local82 + local196 > local211) {
				local196 = local211 - local82;
				if (local196 < 0) {
					local196 = 0;
				}
				aDialogPreferences_1.setValue(local196);
			}
			aDialogPreferences_1.setMaximum(local211);
			aDialogPreferences_1.setVisibleAmount(local82);
		}
		aTopPanelBar.setBounds((local162 - local84) / 2, -local196, local84, local10);
		if (aCanvas1 != null) {
			aCanvas1.setBounds((local162 - local84) / 2, local10 - local196, local84, local20);
		}
		anApplet1.setBounds((local162 - local84) / 2, local20 + local10 - local196, local84, local94);
		aComponent1.setBounds((local162 - local84) / 2, local10 + local20 + local94 - local196, local84, local27);
		if (aCanvas1 != null && browsercontrol.iscreated()) {
			browsercontrol.resize(aCanvas1.getSize().width, aCanvas1.getSize().height);
		}
		aFrame1.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(ILjava/lang/String;)Ljava/lang/String;")
	private static String method4(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
		if (arg0 <= 100) {
			method16(null, 53, null);
		}
		@Pc(13) String local13 = arg1;
		while (true) {
			@Pc(17) int local17 = local13.indexOf("$(");
			if (local17 < 0) {
				break;
			}
			@Pc(29) int local29 = local13.indexOf(":", local17);
			@Pc(34) int local34 = local13.indexOf(")", local29);
			if (local29 < 0 || local34 < 0) {
				break;
			}
			@Pc(49) String local49 = local13.substring(local17 + 2, local29);
			@Pc(56) String local56 = local13.substring(local29 + 1, local34);
			@Pc(60) String local60 = Preferences.method25(local49, 1);
			if (local60 != null) {
				local56 = local60;
			}
			if (local13.length() - 1 > local34) {
				local13 = local13.substring(0, local17) + local56 + local13.substring(local34 + 1);
			} else {
				local13 = local13.substring(0, local17) + local56;
			}
		}
		return local13;
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "removeadvert", descriptor = "()V")
	public static void removeadvert() {
		if (aCanvas1 == null) {
			return;
		}
		if (browsercontrol.iscreated()) {
			browsercontrol.destroy();
		}
		aPanel1.remove(aCanvas1);
		aCanvas1 = null;
		method3((byte) -123);
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "b", descriptor = "(I)V")
	public static void method5(@OriginalArg(0) int arg0) {
		if (browsercontrol.iscreated()) {
			browsercontrol.destroy();
		}
		System.exit(0);
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "readdadvert", descriptor = "()V")
	public static void readdadvert() {
		if (!aBoolean1 || aCanvas1 != null) {
			return;
		}
		aCanvas1 = new Canvas();
		aPanel1.add(aCanvas1);
		method3((byte) -116);
		while (!aCanvas1.isDisplayable() || !aCanvas1.isShowing()) {
			try {
				Thread.sleep(100L);
			} catch (@Pc(26) Exception local26) {
			}
		}
		try {
			browsercontrol.create(aCanvas1, method13("adverturl", true));
			browsercontrol.resize(aCanvas1.getSize().width, aCanvas1.getSize().height);
		} catch (@Pc(42) Throwable local42) {
			if (aBoolean2) {
				local42.printStackTrace();
			}
			DialogMessage.method29(500, method15(1555, "err_create_advertising"));
			return;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;B)[B")
	private static byte[] method6(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1, @OriginalArg(2) byte arg2) {
		@Pc(4) byte[] local4 = new byte[300000];
		@Pc(6) int local6 = 0;
		try {
			@Pc(19) InputStream local19 = (new URL(arg1 + arg0)).openStream();
			while (local4.length > local6) {
				@Pc(32) int local32 = local19.read(local4, local6, local4.length - local6);
				if (local32 < 0) {
					break;
				}
				aFloat1 += local32;
				local6 += local32;
				ComponentProgress.method19((int) (aFloat1 / aFloat2 * 100.0F), 140);
			}
			local19.close();
		} catch (@Pc(60) Exception local60) {
			if (aBoolean2) {
				local60.printStackTrace();
			}
			DialogMessage.method29(500, method15(1555, "err_downloading") + ": " + arg0);
		}
		@Pc(82) byte[] local82 = new byte[local6];
		System.arraycopy(local4, 0, local82, 0, local6);
		@Pc(96) boolean local96 = true;
		return local82;
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljava/lang/String;I)Ljava/lang/String;")
	public static String method7(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1) {
		if (aConfig_1 != null) {
			@Pc(14) String local14 = (String) aConfig_1.aHashtable7.get(arg0);
			if (local14 != null) {
				return local14;
			}
		}
		return (String) aHashtable2.get(arg0);
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljagexappletviewer!app/m;I)V")
	private static void method8(@OriginalArg(0) Config arg0, @OriginalArg(1) int arg1) {
		if (arg0 == null) {
			return;
		}
		ComponentProgress.method21(method15(1555, "loading_app"), (byte) 31);
		ComponentProgress.method19(0, 140);
		ComponentProgress.method23(2);
		ComponentProgress.method20((byte) -98);
		if (anApplet1 != null) {
			if (aComponent1.isVisible()) {
				aComponent1.setVisible(false);
				method3((byte) -96);
			}
			anApplet1.stop();
			ComponentProgress.method19(25, 140);
			ComponentProgress.method20((byte) -98);
			anApplet1.destroy();
			aPanel1.remove(anApplet1);
			anApplet1 = null;
			aPanel1.remove(aComponent1);
		}
		aConfig_1 = arg0;
		ComponentProgress.method19(50, 140);
		ComponentProgress.method20((byte) -98);
		if (aBoolean1) {
			JarWinClassLoader.method45((byte) 127);
		}
		try {
			@Pc(61) String local61 = method13("codebase", true);
			@Pc(68) byte[] local68 = method6(method13("loader_jar", true), local61, (byte) 114);
			ComponentProgress.method19(75, 140);
			ComponentProgress.method20((byte) -98);
			@Pc(78) JarClassLoader local78 = new JarClassLoader(local68);
			anApplet1 = (Applet) local78.loadClass("loader").getDeclaredConstructor().newInstance();
			if (aBoolean2) {
				System.out.println("loader_jar : " + local68.length);
			}
			ComponentProgress.method18(-1127);
		} catch (@Pc(104) Exception local104) {
			if (aBoolean2) {
				local104.printStackTrace();
			}
			ComponentProgress.method18(-1127);
			DialogMessage.method29(500, method15(1555, "err_target_applet"));
		}
		aPanel1.add(anApplet1);
		aComponent1 = new CopyrightBar(method15(1555, "tandc"));
		aPanel1.add(aComponent1);
		aBoolean4 = true;
		method3((byte) -119);
		anApplet1.setStub(new GameAppletStub());
		anApplet1.init();
		anApplet1.start();
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "c", descriptor = "(B)V")
	public static void method9(@OriginalArg(0) byte arg0) {
		@Pc(5) String local5 = method13("serverlist", true);
		@Pc(7) Config[] local7 = aConfigArray1;
		@Pc(10) int local10 = aConfigArray1.length;
		if (local5 != null) {
			local10 = 0;
			local7 = new Config[aConfigArray1.length];
			try {
				@Pc(23) BufferedReader local23 = method11(local5, true, null);
				label61: while (true) {
					@Pc(42) String[] local42;
					do {
						do {
							@Pc(26) String local26;
							do {
								local26 = local23.readLine();
								if (local26 == null) {
									local23.close();
									break label61;
								}
								local26 = local26.trim();
							} while (local26.startsWith("//"));
							local42 = local26.split(",");
						} while (local42.length < 2);
					} while (!local42[1].trim().toLowerCase().equals("true"));
					@Pc(60) String local60 = local42[0].trim();
					for (@Pc(62) int local62 = 0; local62 < aConfigArray1.length; local62++) {
						if (aConfigArray1[local62].aString9.equals(local60)) {
							local7[local10++] = aConfigArray1[local62];
						}
					}
				}
			} catch (@Pc(89) IOException local89) {
				local10 = aConfigArray1.length;
				local7 = aConfigArray1;
			}
		}
		@Pc(97) String[] local97 = new String[local10];
		@Pc(99) int local99;
		for (local99 = 0; local99 < local10; local99++) {
			local97[local99] = (String) local7[local99].aHashtable6.get("servername");
		}
		aPopupWindow_2.method34(local97, 2);
		local99 = aPopupWindow_2.method33(-1);
		if (local99 >= 0) {
			method8(local7[local99], 50);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(II)Z")
	private static boolean method10(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(3) int local3 = 0;
		aHashtable2.clear();
		Language.method41(arg1, -11712);
		if (arg0 < 12) {
			aHashtable1 = null;
		}
		aHashtable1.clear();
		aConfigArray1 = null;
		aConfig_1 = null;
		@Pc(22) int local22 = 0;
		@Pc(25) Config[] local25 = new Config[50];
		@Pc(121) int local121;
		try {
			@Pc(30) BufferedReader local30 = method11(aString1, true, aFile1);
			@Pc(32) Hashtable local32 = aHashtable2;
			@Pc(34) Hashtable local34 = aHashtable1;
			@Pc(36) Hashtable local36 = aHashtable3;
			label194: while (true) {
				@Pc(39) String local39;
				@Pc(134) String local134;
				label177: do {
					while (true) {
						while (true) {
							do {
								do {
									local39 = local30.readLine();
									if (local39 == null) {
										local30.close();
										break label194;
									}
									local39 = local39.trim();
								} while (local39.startsWith("//"));
							} while (local39.startsWith("#"));
							if (local39.startsWith("[")) {
								@Pc(64) String local64 = local39.substring(1, local39.lastIndexOf(93));
								@Pc(69) Config local69 = new Config(local64);
								if (aConfig_1 == null) {
									aConfig_1 = local69;
								}
								if (local25.length <= local22) {
									@Pc(82) Config[] local82 = new Config[local22 + 10];
									System.arraycopy(local25, 0, local82, 0, local25.length);
									local25 = local82;
								}
								local25[local22++] = local69;
								local36 = local69.aHashtable8;
								local34 = local69.aHashtable6;
								local32 = local69.aHashtable7;
							}
							@Pc(264) String local264;
							if (local39.startsWith("param=")) {
								local39 = local39.substring(6);
								local121 = local39.indexOf(61);
								if (local121 != -1) {
									local134 = local39.substring(0, local121).trim().toLowerCase();
									local264 = local39.substring(local121 + 1).trim();
									local32.put(local134, local264);
									if (aBoolean2) {
										System.out.println("Innerconfig - variable=" + local134 + " value=" + local264);
									}
								}
							} else {
								if (local39.startsWith("msg=")) {
									local39 = local39.substring(4);
									local121 = local39.indexOf(61);
									continue label177;
								}
								local121 = local39.indexOf(61);
								if (local121 != -1) {
									local134 = local39.substring(0, local121).trim().toLowerCase();
									local264 = local39.substring(local121 + 1).trim();
									local34.put(local134, local264);
									if (aBoolean2) {
										System.out.println("Ourconfig - variable=" + local134 + " value=" + local264);
									}
								}
							}
						}
					}
				} while (local121 == -1);
				local134 = local39.substring(0, local121).trim().toLowerCase();
				@Pc(144) StringBuffer local144 = new StringBuffer(local39.substring(local121 + 1).trim());
				@Pc(146) int local146 = 0;
				while (true) {
					while (true) {
						@Pc(151) int local151 = local144.indexOf("\\\\", local146);
						@Pc(156) int local156 = local144.indexOf("\\n", local146);
						if (local151 < 0 && local156 < 0) {
							if (local134.startsWith("lang")) {
								try {
									local3++;
									Integer.parseInt(local134.substring(4));
								} catch (@Pc(215) NumberFormatException local215) {
								}
							}
							local36.put(local134, local144.toString());
							if (aBoolean2) {
								System.out.println("Message - name=" + local134 + " text=" + local144.toString());
							}
							continue label194;
						}
						if (local151 >= 0 && (local156 < 0 || local151 <= local156)) {
							local146 = local151 + 1;
							local144.replace(local151, local151 + 2, "\\");
						} else {
							local144.replace(local156, local156 + 2, "\n");
							local146 = local156 + 1;
						}
					}
				}
			}
		} catch (@Pc(340) IOException local340) {
			if (aBoolean2) {
				local340.printStackTrace();
			}
			DialogMessage.method29(500, method15(1555, "err_load_config"));
		} catch (@Pc(351) Exception local351) {
			if (aBoolean2) {
				local351.printStackTrace();
			}
			DialogMessage.method29(500, method15(1555, "err_decode_config"));
		}
		if (local3 <= 0) {
			return true;
		}
		aStringArray1 = new String[local3];
		anIntArray1 = new int[local3];
		@Pc(374) int local374 = 0;
		@Pc(377) Enumeration local377 = aHashtable3.keys();
		while (true) {
			@Pc(384) String var22;
			@Pc(395) int var24;
			while (true) {
				do {
					if (!local377.hasMoreElements()) {
						aPopupWindow_1 = new PopupWindow(method15(1555, "language"));
						aPopupWindow_1.method34(aStringArray1, 2);
						if (local22 > 0) {
							aConfigArray1 = new Config[local22];
							System.arraycopy(local25, 0, aConfigArray1, 0, local22);
							aPopupWindow_2 = new PopupWindow(method15(1555, "switchserver"));
						}
						if (Preferences.method25("Language", 1) == null) {
							return method2(84) < 0;
						}
						return true;
					}
					var22 = (String) local377.nextElement();
				} while (!var22.startsWith("lang"));
				@Pc(390) boolean local390 = false;
				try {
					var24 = Integer.parseInt(var22.substring(4));
					break;
				} catch (@Pc(397) NumberFormatException local397) {
				}
			}
			for (@Pc(401) int local401 = 0; local401 <= local374; local401++) {
				if (local401 == local374 || var24 < anIntArray1[local401]) {
					for (local121 = local374; local121 > local401; local121--) {
						aStringArray1[local121] = aStringArray1[local121 - 1];
						anIntArray1[local121] = anIntArray1[local121 - 1];
					}
					anIntArray1[local401] = var24;
					aStringArray1[local401] = method15(1555, var22);
					break;
				}
			}
			local374++;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljava/lang/String;ZLjava/io/File;)Ljava/io/BufferedReader;")
	private static BufferedReader method11(@OriginalArg(0) String arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) File arg2) throws IOException {
		if (arg0 == null) {
			return arg2 == null ? null : new BufferedReader(new FileReader(arg2));
		} else {
			return new BufferedReader(new InputStreamReader((new URL(arg0)).openStream()));
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "b", descriptor = "(ILjava/lang/String;)V")
	public static void start(@OriginalArg(1) String arg1) {
		aBoolean5 = false;
		aBoolean2 = Boolean.getBoolean("com.jagex.debug");
		if (aBoolean2) {
			System.setErr(DialogDebug.method24(29, "Jagex host console"));
			System.setOut(DialogDebug.method24(27, "Jagex host console"));
			System.out.println("release #7");
			System.out.println("java.version = " + System.getProperty("java.version"));
			System.out.println("os.name = " + System.getProperty("os.name"));
			System.out.println("os.arch = " + System.getProperty("os.arch"));
		}
		Preferences.method28((byte) 109);
		@Pc(58) String local58 = Preferences.method25("Language", 1);
		@Pc(60) int local60 = 0;
		@Pc(71) String local71;
		if (local58 == null) {
			@Pc(65) Locale local65 = Locale.getDefault();
			@Pc(68) String local68 = local65.getISO3Language();
			local71 = local65.getISO3Country();
			@Pc(73) byte local73 = -1;
			if (local68 != null) {
				if (local68.equals("eng")) {
					local73 = 0;
				}
				if (local68.equals("ger") || local68.equals("deu")) {
					local73 = 1;
				}
				if (local68.equals("fre") || local68.equals("fra")) {
					local73 = 2;
				}
				if (local68.equals("por")) {
					local73 = 3;
				}
			} else if (local71 != null) {
				if (local71.equals("GB") || local71.equals("US")) {
					local73 = 0;
				}
				if (local71.equals("DE")) {
					local73 = 1;
				}
				if (local71.equals("FR")) {
					local73 = 2;
				}
				if (local71.equals("BR")) {
					local73 = 3;
				}
			}
			if (local73 >= 0) {
				Preferences.method26(Integer.toString(local73), -127, "Language");
				Preferences.method27((byte) 111);
			}
		} else {
			local60 = Integer.parseInt(local58);
		}
		Language.method41(local60, -11712);
		aFrame1 = new Frame();
		aFrame1.getToolkit().setDynamicLayout(true);
		aFrame1.setBackground(Color.BLACK);
		@Pc(186) File local186 = new File((new File(System.getProperty("user.dir"))).getParentFile(), arg1);
		@Pc(192) File local192 = new File(local186, "jagexappletviewer.png");
		System.out.println("Trying to load icon file: " + local192.getAbsolutePath());
		if (local192.exists()) {
			@Pc(212) Image local212 = Toolkit.getDefaultToolkit().getImage(local192.getAbsolutePath());
			if (local212 != null) {
				aFrame1.setIconImage(local212);
			}
		}
		ComponentProgress.method22(1);
		ComponentProgress.method23(2);
		ComponentProgress.method21(method15(1555, "loading_config"), (byte) 31);
		local71 = System.getProperty("com.jagex.config");
		@Pc(232) String local232 = System.getProperty("com.jagex.configfile");
		if (local71 == null) {
			if (local232 == null) {
				DialogMessage.method29(500, method15(1555, "err_missing_config"));
			}
			aFile1 = new File(local186, local232);
		}
		while (true) {
			if (local71 != null) {
				aString1 = method4(101, local71);
				System.out.println("Config URL is " + aString1);
			}
			if (method10(16, local60)) {
				@Pc(291) String local291 = method13("viewerversion", true);
				@Pc(298) int local298;
				if (local291 != null) {
					try {
						local298 = Integer.parseInt(local291);
						if (local298 > 110) {
							DialogMessage.method30(0, method15(1555, "new_version"));
						}
					} catch (@Pc(310) NumberFormatException local310) {
					}
				}
				local298 = Integer.parseInt(method7("modewhat", 61)) + 32;
				@Pc(321) String local321 = method13("cachesubdir", true);
				@Pc(325) String local325 = method13("codebase", true);
				@Pc(329) String local329 = System.getProperty("os.name").toLowerCase();
				@Pc(333) String local333 = System.getProperty("os.arch").toLowerCase();
				aBoolean1 = local329.startsWith("win");
				aBoolean3 = aBoolean1 && local333.startsWith("amd64") || local333.startsWith("x86_64");
				@Pc(353) String local353 = null;
				try {
					local353 = System.getProperty("user.home");
					if (local353 != null) {
						local353 = local353 + "/";
					}
				} catch (@Pc(370) Exception local370) {
				}
				if (local353 == null) {
					local353 = "~/";
				}
				ComponentProgress.method21(method15(1555, "loading_app_resources"), (byte) 31);
				@Pc(381) File local381 = null;
				@Pc(390) byte[] local390;
				try {
					@Pc(405) byte[] local405;
					if (aBoolean3) {
						local390 = method6(method13("browsercontrol_win_amd64_jar", true), local325, (byte) -73);
						local381 = method14(local353, local321, -28252, local298, "browsercontrol64.dll");
						local405 = (new JarLoader(local390)).method44(49, "browsercontrol64.dll");
						if (local405 == null) {
							DialogMessage.method29(500, method15(1555, "err_verify_bc64"));
							local381 = null;
						}
						method16(local381, -109, local405);
					} else if (aBoolean1) {
						local390 = method6(method13("browsercontrol_win_x86_jar", true), local325, (byte) 102);
						local381 = method14(local353, local321, -28252, local298, "browsercontrol.dll");
						local405 = (new JarLoader(local390)).method44(104, "browsercontrol.dll");
						if (local405 == null) {
							DialogMessage.method29(500, method15(1555, "err_verify_bc"));
							local381 = null;
						}
						method16(local381, -111, local405);
						if (aBoolean2) {
							System.out.println("dlldata : " + local390.length);
						}
					}
				} catch (@Pc(475) Exception local475) {
					if (aBoolean2) {
						local475.printStackTrace();
					}
					DialogMessage.method29(500, method15(1555, "err_load_bc"));
				}
				ComponentProgress.method21(method15(1555, "loading_app"), (byte) 31);
				if (aBoolean1) {
					JarWinClassLoader.method45((byte) 127);
				}
				try {
					local390 = method6(method13("loader_jar", true), local325, (byte) -125);
					@Pc(506) JarClassLoader local506 = new JarClassLoader(local390);
					anApplet1 = (Applet) local506.loadClass("loader").getDeclaredConstructor().newInstance();
					if (aBoolean2) {
						System.out.println("loader_jar : " + local390.length);
					}
				} catch (@Pc(528) Exception local528) {
					if (aBoolean2) {
						local528.printStackTrace();
					}
					DialogMessage.method29(500, method15(1555, "err_target_applet"));
				}
				ComponentProgress.method18(-1127);
				UrlThread.method36((byte) 42);
				aFrame1.setTitle(method13("title", true));
				@Pc(556) int local556 = aBoolean1 ? Integer.parseInt(method13("advert_height", true)) : 0;
				@Pc(566) int local566 = Integer.parseInt(method13("window_preferredwidth", true));
				@Pc(571) int local571 = Integer.parseInt(method13("window_preferredheight", true));
				@Pc(576) int local576 = Integer.parseInt(method13("applet_minwidth", true));
				@Pc(581) int local581 = Integer.parseInt(method13("applet_minheight", true));
				aFrame1.setVisible(true);
				@Pc(586) boolean local586 = true;
				aFrame1.createBufferStrategy(2);
				@Pc(592) Insets local592 = aFrame1.getInsets();
				@Pc(602) int local602 = local592.right + local566 + local592.left + 15;
				@Pc(615) int local615 = local571 + local556 + local592.top + local592.bottom + 40;
				@Pc(619) Rectangle local619 = aFrame1.getGraphicsConfiguration().getBounds();
				@Pc(624) int local624 = local619.width - 50;
				@Pc(629) int local629 = local619.height - 50;
				if (local624 < local602) {
					local602 = local592.left + local576 + local592.right + 15;
				}
				if (local629 < local615) {
					local615 = local581 + local556 + local592.top + local592.bottom + 40;
				}
				@Pc(666) boolean local666 = false;
				if (local624 < local602) {
					local602 = local624;
					local666 = true;
				}
				if (local615 > local629) {
					local666 = true;
					local615 = local629;
				}
				aFrame1.setSize(local602, local615);
				aFrame1.setLocationRelativeTo(null);
				if (local666) {
					aFrame1.setExtendedState(6);
				}
				aPanel1 = new WindowPanel();
				aPanel1.setBackground(Color.black);
				aPanel1.setLayout(null);
				aFrame1.setLayout(new BorderLayout());
				@Pc(720) AppletViewer local720 = new AppletViewer();
				aFrame1.add(aPanel1, "Center");
				aPanel1.addComponentListener(local720);
				aDialogPreferences_1 = new DialogPreferences();
				aDialogPreferences_1.addAdjustmentListener(local720);
				@Pc(744) boolean local744 = !"yes".equals(Preferences.method25("Member", 1));
				if (aBoolean1 && local744) {
					aCanvas1 = new Canvas();
					aPanel1.add(aCanvas1);
				}
				aPanel1.add(anApplet1);
				aTopPanelBar = new TopPanelBar(new DialogLanguage());
				aTopPanelBar.setBackground(Color.BLACK);
				aTopPanelBar.setForeground(Color.GRAY);
				aTopPanelBar.method35((byte) -121, method15(1555, "language"));
				if (aConfigArray1 != null && aConfigArray1.length > 1) {
					aTopPanelBar.method35((byte) -108, method15(1555, "switchserver"));
				}
				aTopPanelBar.setFont(new Font("SansSerif", 0, 10));
				aPanel1.add(aTopPanelBar);
				aComponent1 = new CopyrightBar(method15(1555, "tandc"));
				aPanel1.add(aComponent1);
				aBoolean5 = true;
				aFrame1.doLayout();
				method3((byte) -127);
				if (aBoolean1) {
					try {
						System.load(local381.toString());
					} catch (@Pc(832) Throwable local832) {
						if (aBoolean2) {
							local832.printStackTrace();
						}
						DialogMessage.method29(500, method15(1555, "err_create_advertising"));
						return;
					}
				}
				if (aBoolean1 && local744) {
					while (true) {
						if (aCanvas1.isDisplayable() && aCanvas1.isShowing()) {
							try {
								browsercontrol.create(aCanvas1, method13("adverturl", true));
								browsercontrol.resize(aCanvas1.getSize().width, aCanvas1.getSize().height);
								break;
							} catch (@Pc(876) Throwable local876) {
								if (aBoolean2) {
									local876.printStackTrace();
								}
								DialogMessage.method29(500, method15(1555, "err_create_advertising"));
								return;
							}
						}
						try {
							Thread.sleep(100L);
						} catch (@Pc(859) Exception local859) {
						}
					}
				}
				aFrame1.addWindowListener(WindowListener.method38(-21945));
				anApplet1.setStub(new GameAppletStub());
				anApplet1.init();
				anApplet1.start();
				return;
			}
			local58 = Preferences.method25("Language", 1);
			local60 = 0;
			if (local58 != null) {
				local60 = Integer.parseInt(local58);
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "doresize", descriptor = "(I)V")
	public static void doresize(@OriginalArg(0) int arg0) {
		if (arg0 == 0) {
			if (!aBoolean4) {
				aBoolean4 = true;
				method3((byte) -124);
			}
		} else if (arg0 == 1 && aBoolean4) {
			aBoolean4 = false;
			method3((byte) -127);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljava/lang/String;Z)Ljava/lang/String;")
	public static String method13(@OriginalArg(0) String arg0, @OriginalArg(1) boolean arg1) {
		if (aConfig_1 != null) {
			@Pc(8) String local8 = (String) aConfig_1.aHashtable6.get(arg0);
			if (local8 != null) {
				return local8;
			}
		}
		return (String) aHashtable1.get(arg0);
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Ljava/io/File;")
	private static File method14(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) String arg4) {
		@Pc(36) String[] local36 = new String[] { "c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", arg0, "/tmp/", "" };
		@Pc(61) String[] local61 = new String[] { ".jagex_cache_" + arg3, ".file_store_" + arg3 };
		if (arg2 != -28252) {
			method4(27, null);
		}
		for (@Pc(71) int local71 = 0; local71 < 2; local71++) {
			for (@Pc(76) int local76 = 0; local76 < local61.length; local76++) {
				for (@Pc(86) int local86 = 0; local86 < local36.length; local86++) {
					@Pc(121) String local121 = local36[local86] + local61[local76] + "/" + (arg1 == null ? "" : arg1 + "/") + arg4;
					@Pc(123) RandomAccessFile local123 = null;
					try {
						@Pc(128) File local128 = new File(local121);
						if (local71 != 0 || local128.exists()) {
							@Pc(143) String local143 = local36[local86];
							if (local71 != 1 || local143.length() <= 0 || (new File(local143)).exists()) {
								(new File(local36[local86] + local61[local76])).mkdir();
								if (arg1 != null) {
									(new File(local36[local86] + local61[local76] + "/" + arg1)).mkdir();
								}
								local123 = new RandomAccessFile(local128, "rw");
								@Pc(211) int local211 = local123.read();
								local123.seek(0L);
								local123.write(local211);
								local123.seek(0L);
								local123.close();
								return local128;
							}
						}
					} catch (@Pc(225) Exception local225) {
						if (aBoolean2) {
							System.out.println("Unable to open/write: " + local121);
						}
						try {
							if (local123 != null) {
								local123.close();
								local123 = null;
							}
						} catch (@Pc(247) Exception local247) {
						}
					}
				}
			}
		}
		if (aBoolean2) {
			throw new RuntimeException("Fatal - could not find ANY location for file: " + arg4);
		}
		throw new RuntimeException();
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "c", descriptor = "(ILjava/lang/String;)Ljava/lang/String;")
	public static String method15(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
		if (aConfig_1 != null) {
			@Pc(13) String local13 = (String) aConfig_1.aHashtable8.get(arg1);
			if (local13 != null) {
				return local13;
			}
		}
		return (String) aHashtable3.get(arg1);
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljava/io/File;I[B)Z")
	private static boolean method16(@OriginalArg(0) File arg0, @OriginalArg(1) int arg1, @OriginalArg(2) byte[] arg2) {
		try {
			@Pc(4) FileOutputStream local4 = new FileOutputStream(arg0);
			if (arg1 > -91) {
				return false;
			} else {
				local4.write(arg2, 0, arg2.length);
				local4.close();
				return true;
			}
		} catch (@Pc(20) IOException local20) {
			if (aBoolean2) {
				local20.printStackTrace();
			}
			DialogMessage.method29(500, method15(1555, "err_save_file"));
			return false;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "d", descriptor = "(B)V")
	public static void method17(@OriginalArg(0) byte arg0) {
		@Pc(1) boolean local1 = false;
		if (aConfigArray1 == null && aTopPanelBar.isVisible()) {
			local1 = true;
			aTopPanelBar.setVisible(false);
		}
		if (aComponent1.isVisible()) {
			aComponent1.setVisible(false);
			local1 = true;
		}
		if (local1) {
			method3((byte) -119);
		}
		if (arg0 <= 8) {
			aBoolean4 = true;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "<init>", descriptor = "()V")
	private AppletViewer() {
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "adjustmentValueChanged", descriptor = "(Ljava/awt/event/AdjustmentEvent;)V")
	@Override
	public void adjustmentValueChanged(@OriginalArg(0) AdjustmentEvent arg0) {
		if (arg0.getValueIsAdjusting()) {
			method3((byte) -120);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "componentShown", descriptor = "(Ljava/awt/event/ComponentEvent;)V")
	@Override
	public void componentShown(@OriginalArg(0) ComponentEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "componentResized", descriptor = "(Ljava/awt/event/ComponentEvent;)V")
	@Override
	public void componentResized(@OriginalArg(0) ComponentEvent arg0) {
		method3((byte) -127);
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "componentMoved", descriptor = "(Ljava/awt/event/ComponentEvent;)V")
	@Override
	public void componentMoved(@OriginalArg(0) ComponentEvent arg0) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "componentHidden", descriptor = "(Ljava/awt/event/ComponentEvent;)V")
	@Override
	public void componentHidden(@OriginalArg(0) ComponentEvent arg0) {
	}
}
