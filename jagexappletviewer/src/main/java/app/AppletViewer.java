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
	private static TopPanelBar topBar;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "b", descriptor = "Ljava/awt/Component;")
	private static Component copyright;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "c", descriptor = "Ljagexappletviewer!app/f;")
	private static PopupWindow languageWindow;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "d", descriptor = "Ljava/applet/Applet;")
	private static Applet mainapp;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "e", descriptor = "Ljava/awt/Frame;")
	public static Frame frame;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "f", descriptor = "Ljagexappletviewer!app/n;")
	private static DialogPreferences dialogPreferences;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "g", descriptor = "Z")
	public static boolean WIN32;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "j", descriptor = "Ljava/awt/Panel;")
	private static Panel mainPanel;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "k", descriptor = "Ljagexappletviewer!app/f;")
	private static PopupWindow switchServerWindow;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "l", descriptor = "Z")
	private static boolean WIN64;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "m", descriptor = "Ljava/awt/Canvas;")
	private static Canvas canvas;

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
	public static boolean VERBOSE = false;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "h", descriptor = "Ljava/util/Hashtable;")
	private static Hashtable properties = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "n", descriptor = "Ljava/util/Hashtable;")
	private static Hashtable params = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "o", descriptor = "Ljava/util/Hashtable;")
	public static Hashtable localization = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "q", descriptor = "Ljagexappletviewer!app/m;")
	private static Config currentConfig = null;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "t", descriptor = "F")
	private static float progressLimit = 58988.0F;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "u", descriptor = "[Ljagexappletviewer!app/m;")
	private static Config[] configs = null;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "x", descriptor = "Ljava/io/File;")
	private static File aFile1 = null;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "w", descriptor = "Ljava/lang/String;")
	private static String aString1 = null;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "y", descriptor = "Z")
	private static boolean loaded = false;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "r", descriptor = "Z")
	private static boolean resize = true;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "p", descriptor = "F")
	private static float progress = 0.0F;

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(B)V")
	public static void method1(@OriginalArg(0) byte arg0) {
		@Pc(1) boolean local1 = false;
		if (!topBar.isVisible()) {
			local1 = true;
			topBar.setVisible(true);
		}

		if (!copyright.isVisible()) {
			copyright.setVisible(true);
			local1 = true;
		}

		if (local1) {
			method3();
		}

		if (arg0 != -99) {
			aString1 = null;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(I)I")
	public static int method2() {
		@Pc(11) int local11 = languageWindow.method33(-1);
		if (local11 < 0) {
			return -1;
		} else {
			Preferences.set(Integer.toString(anIntArray1[local11]), -128, "Language");
			Preferences.save();
			return local11;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "b", descriptor = "(B)V")
	private static void method3() {
		if (!loaded) {
			return;
		}
		@Pc(10) int local10 = topBar.isVisible() ? 20 : 0;
		@Pc(20) int local20 = canvas == null ? 0 : Integer.parseInt(getProperty("advert_height"));
		@Pc(27) int local27 = copyright.isVisible() ? 40 : 0;
		@Pc(32) int local32 = Integer.parseInt(getProperty("applet_minwidth"));
		@Pc(37) int local37 = Integer.parseInt(getProperty("applet_minheight"));
		@Pc(42) int local42 = Integer.parseInt(getProperty("applet_maxwidth"));
		@Pc(47) int local47 = Integer.parseInt(getProperty("applet_maxheight"));
		@Pc(50) Dimension local50 = mainPanel.getSize();
		@Pc(60) Insets local60 = mainPanel.getInsets();
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
			if (dialogPreferences.getParent() == null) {
				frame.add(dialogPreferences, "East");
				dialogPreferences.setValue(0);
				frame.validate();
			}
		} else if (dialogPreferences.getParent() != null) {
			frame.remove(dialogPreferences);
			frame.validate();
		}
		if (resize) {
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
		if (dialogPreferences.getParent() != null) {
			local196 = dialogPreferences.getValue();
			@Pc(211) int local211 = local27 + local20 + local10 + local94;
			if (local82 + local196 > local211) {
				local196 = local211 - local82;
				if (local196 < 0) {
					local196 = 0;
				}
				dialogPreferences.setValue(local196);
			}
			dialogPreferences.setMaximum(local211);
			dialogPreferences.setVisibleAmount(local82);
		}
		topBar.setBounds((local162 - local84) / 2, -local196, local84, local10);
		if (canvas != null) {
			canvas.setBounds((local162 - local84) / 2, local10 - local196, local84, local20);
		}
		mainapp.setBounds((local162 - local84) / 2, local20 + local10 - local196, local84, local94);
		copyright.setBounds((local162 - local84) / 2, local10 + local20 + local94 - local196, local84, local27);
		if (canvas != null && browsercontrol.iscreated()) {
			browsercontrol.resize(canvas.getSize().width, canvas.getSize().height);
		}
		frame.repaint();
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(ILjava/lang/String;)Ljava/lang/String;")
	private static String method4(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
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
		if (canvas == null) {
			return;
		}
		if (browsercontrol.iscreated()) {
			browsercontrol.destroy();
		}
		mainPanel.remove(canvas);
		canvas = null;
		method3();
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
		if (!WIN32 || canvas != null) {
			return;
		}
		canvas = new Canvas();
		mainPanel.add(canvas);
		method3();
		while (!canvas.isDisplayable() || !canvas.isShowing()) {
			try {
				Thread.sleep(100L);
			} catch (@Pc(26) Exception local26) {
			}
		}
		try {
			browsercontrol.create(canvas, getProperty("adverturl"));
			browsercontrol.resize(canvas.getSize().width, canvas.getSize().height);
		} catch (@Pc(42) Throwable ex) {
			if (VERBOSE) {
				ex.printStackTrace();
			}

			DialogMessage.showError(translate("err_create_advertising"));
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;B)[B")
	private static byte[] download(@OriginalArg(0) String file, @OriginalArg(1) String host) {
		@Pc(4) byte[] dest = new byte[300000];
		@Pc(6) int offset = 0;

		try {
			@Pc(19) InputStream stream = new URL(new URL(host), file).openStream();

			while (dest.length > offset) {
				@Pc(32) int read = stream.read(dest, offset, dest.length - offset);
				if (read < 0) {
					break;
				}

				progress += read;
				offset += read;
				ComponentProgress.updateProgress((int) (progress / progressLimit * 100.0F), 140);
			}

			stream.close();
		} catch (@Pc(60) Exception ex) {
			if (VERBOSE) {
				ex.printStackTrace();
			}

			DialogMessage.showError(translate("err_downloading") + ": " + file);
		}

		@Pc(82) byte[] data = new byte[offset];
		System.arraycopy(dest, 0, data, 0, offset);
		return data;
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljava/lang/String;I)Ljava/lang/String;")
	public static String getParameter(@OriginalArg(0) String name) {
		if (currentConfig != null) {
			@Pc(14) String value = (String) currentConfig.params.get(name);
			if (value != null) {
				return value;
			}
		}

		return (String) params.get(name);
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljagexappletviewer!app/m;I)V")
	private static void switchToServer(@OriginalArg(0) Config arg0, @OriginalArg(1) int arg1) {
		if (arg0 == null) {
			return;
		}
		ComponentProgress.setText(translate("loading_app"), (byte) 31);
		ComponentProgress.updateProgress(0, 140);
		ComponentProgress.show(2);
		ComponentProgress.method20((byte) -98);
		if (mainapp != null) {
			if (copyright.isVisible()) {
				copyright.setVisible(false);
				method3();
			}
			mainapp.stop();
			ComponentProgress.updateProgress(25, 140);
			ComponentProgress.method20((byte) -98);
			mainapp.destroy();
			mainPanel.remove(mainapp);
			mainapp = null;
			mainPanel.remove(copyright);
		}
		currentConfig = arg0;
		frame.setTitle(getProperty("title"));

		ComponentProgress.updateProgress(50, 140);
		ComponentProgress.method20((byte) -98);
		if (WIN32) {
			JarWinClassLoader.method45((byte) 127);
		}
		try {
			@Pc(61) String local61 = getProperty("codebase");
			@Pc(68) byte[] local68 = download(getProperty("loader_jar"), local61);
			ComponentProgress.updateProgress(75, 140);
			ComponentProgress.method20((byte) -98);
			@Pc(78) JarClassLoader local78 = new JarClassLoader(local68);
			mainapp = (Applet) local78.loadClass("loader").getDeclaredConstructor().newInstance();
			if (VERBOSE) {
				System.out.println("loader_jar : " + local68.length);
			}
			ComponentProgress.method18(-1127);
		} catch (@Pc(104) Exception local104) {
			if (VERBOSE) {
				local104.printStackTrace();
			}
			ComponentProgress.method18(-1127);
			DialogMessage.showError(translate("err_target_applet"));
		}
		mainPanel.add(mainapp);
		copyright = new CopyrightBar(translate("tandc"));
		mainPanel.add(copyright);
		resize = true;
		method3();
		mainapp.setStub(new GameAppletStub());
		mainapp.init();
		mainapp.start();
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "c", descriptor = "(B)V")
	public static void method9(@OriginalArg(0) byte arg0) {
		@Pc(5) String local5 = getProperty("serverlist");
		@Pc(7) Config[] local7 = configs;
		@Pc(10) int local10 = configs.length;
		if (local5 != null) {
			local10 = 0;
			local7 = new Config[configs.length];
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
					for (@Pc(62) int local62 = 0; local62 < configs.length; local62++) {
						if (configs[local62].name.equals(local60)) {
							local7[local10++] = configs[local62];
						}
					}
				}
			} catch (@Pc(89) IOException local89) {
				local10 = configs.length;
				local7 = configs;
			}
		}
		@Pc(97) String[] local97 = new String[local10];
		@Pc(99) int local99;
		for (local99 = 0; local99 < local10; local99++) {
			local97[local99] = (String) local7[local99].properties.get("servername");
		}
		switchServerWindow.method34(local97, 2);
		local99 = switchServerWindow.method33(-1);
		if (local99 >= 0) {
			switchToServer(local7[local99], 50);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(II)Z")
	private static boolean method10(@OriginalArg(1) int lang) {
		@Pc(3) int local3 = 0;
		params.clear();
		Language.load(lang);
		properties.clear();
		configs = null;
		currentConfig = null;
		@Pc(22) int local22 = 0;
		@Pc(25) Config[] local25 = new Config[50];
		@Pc(121) int local121;
		try {
			@Pc(30) BufferedReader local30 = method11(aString1, true, aFile1);
			@Pc(32) Hashtable local32 = params;
			@Pc(34) Hashtable local34 = properties;
			@Pc(36) Hashtable local36 = localization;
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
								if (currentConfig == null) {
									currentConfig = local69;
								}
								if (local25.length <= local22) {
									@Pc(82) Config[] local82 = new Config[local22 + 10];
									System.arraycopy(local25, 0, local82, 0, local25.length);
									local25 = local82;
								}
								local25[local22++] = local69;
								local36 = local69.localization;
								local34 = local69.properties;
								local32 = local69.params;
							}
							@Pc(264) String local264;
							if (local39.startsWith("param=")) {
								local39 = local39.substring(6);
								local121 = local39.indexOf(61);
								if (local121 != -1) {
									local134 = local39.substring(0, local121).trim().toLowerCase();
									local264 = local39.substring(local121 + 1).trim();
									local32.put(local134, local264);
									if (VERBOSE) {
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
									if (VERBOSE) {
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
								} catch (@Pc(215) NumberFormatException ignored) {
								}
							}
							local36.put(local134, local144.toString());
							if (VERBOSE) {
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
		} catch (@Pc(340) IOException ex) {
			if (VERBOSE) {
				ex.printStackTrace();
			}

			DialogMessage.showError(translate("err_load_config"));
		} catch (@Pc(351) Exception ex) {
			if (VERBOSE) {
				ex.printStackTrace();
			}

			DialogMessage.showError(translate("err_decode_config"));
		}

		if (local3 <= 0) {
			return true;
		}

		aStringArray1 = new String[local3];
		anIntArray1 = new int[local3];
		@Pc(374) int local374 = 0;
		@Pc(377) Enumeration local377 = localization.keys();
		while (true) {
			@Pc(384) String var22;
			@Pc(395) int var24;
			while (true) {
				do {
					if (!local377.hasMoreElements()) {
						languageWindow = new PopupWindow(translate("language"));
						languageWindow.method34(aStringArray1, 2);
						if (local22 > 0) {
							configs = new Config[local22];
							System.arraycopy(local25, 0, configs, 0, local22);
							switchServerWindow = new PopupWindow(translate("switchserver"));
						}
						if (Preferences.method25("Language", 1) == null) {
							return method2() < 0;
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
					aStringArray1[local401] = translate(var22);
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
		loaded = false;
		VERBOSE = Boolean.getBoolean("com.jagex.debug");

		if (VERBOSE) {
			System.setErr(DialogDebug.getPrintStream(29, "Jagex host console"));
			System.setOut(DialogDebug.getPrintStream(27, "Jagex host console"));
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
				Preferences.set(Integer.toString(local73), -127, "Language");
				Preferences.save();
			}
		} else {
			local60 = Integer.parseInt(local58);
		}
		Language.load(local60);
		frame = new Frame();
		frame.getToolkit().setDynamicLayout(true);
		frame.setBackground(Color.BLACK);
		@Pc(186) File local186 = new File((new File(System.getProperty("user.dir"))).getParentFile(), arg1);
		@Pc(192) File local192 = new File(local186, "jagexappletviewer.png");
		System.out.println("Trying to load icon file: " + local192.getAbsolutePath());
		if (local192.exists()) {
			@Pc(212) Image local212 = Toolkit.getDefaultToolkit().getImage(local192.getAbsolutePath());
			if (local212 != null) {
				frame.setIconImage(local212);
			}
		}
		ComponentProgress.init(1);
		ComponentProgress.show(2);
		ComponentProgress.setText(translate("loading_config"), (byte) 31);
		local71 = System.getProperty("com.jagex.config");
		@Pc(232) String local232 = System.getProperty("com.jagex.configfile");
		if (local71 == null) {
			if (local232 == null) {
				DialogMessage.showError(translate("err_missing_config"));
			}
			aFile1 = new File(local186, local232);
		}

		while (true) {
			if (local71 != null) {
				aString1 = method4(101, local71);
				System.out.println("Config URL is " + aString1);
			}

			if (method10(local60)) {
				@Pc(291) String local291 = getProperty("viewerversion");
				@Pc(298) int local298;
				if (local291 != null) {
					try {
						local298 = Integer.parseInt(local291);
						if (local298 > 110) {
							DialogMessage.showMessage(translate("new_version"));
						}
					} catch (@Pc(310) NumberFormatException local310) {
					}
				}

				int modeWhat = 32;
				try {
					modeWhat = Integer.parseInt(getParameter("modewhat")) + 32;
				} catch (Exception ignored) {
				}

				@Pc(321) String local321 = getProperty("cachesubdir");
				@Pc(325) String local325 = getProperty("codebase");
				@Pc(329) String local329 = System.getProperty("os.name").toLowerCase();
				@Pc(333) String local333 = System.getProperty("os.arch").toLowerCase();
				WIN32 = local329.startsWith("win");
				WIN64 = WIN32 && local333.startsWith("amd64") || local333.startsWith("x86_64");
				@Pc(353) String local353 = null;
				try {
					local353 = System.getProperty("user.home");
					if (local353 != null) {
						local353 = local353 + "/";
					}
				} catch (@Pc(370) Exception ignored) {
				}

				if (local353 == null) {
					local353 = "~/";
				}

				ComponentProgress.setText(translate("loading_app_resources"), (byte) 31);

				@Pc(381) File local381 = null;
				@Pc(390) byte[] local390;
				try {
					@Pc(405) byte[] local405;

					String jar64Url = getProperty("browsercontrol_win_amd64_jar");
					String jar32Url = getProperty("browsercontrol_win_x86_jar");
					if ((WIN64 || WIN32) && jar64Url == null && jar32Url == null) {
						WIN64 = false;
						WIN32 = false;
					}

					if (WIN64) {
						local390 = download(getProperty("browsercontrol_win_amd64_jar"), local325);
						local381 = method14(local353, local321, -28252, modeWhat, "browsercontrol64.dll");
						local405 = (new JarLoader(local390)).read("browsercontrol64.dll", false);

						if (local405 == null) {
							DialogMessage.showError(translate("err_verify_bc64"));
							local381 = null;
						}

						save(local381, local405);
					} else if (WIN32) {
						local390 = download(getProperty("browsercontrol_win_x86_jar"), local325);
						local381 = method14(local353, local321, -28252, modeWhat, "browsercontrol.dll");
						local405 = (new JarLoader(local390)).read("browsercontrol.dll", false);

						if (local405 == null) {
							DialogMessage.showError(translate("err_verify_bc"));
							local381 = null;
						}

						save(local381, local405);

						if (VERBOSE) {
							System.out.println("dlldata : " + local390.length);
						}
					}
				} catch (@Pc(475) Exception ex) {
					if (VERBOSE) {
						ex.printStackTrace();
					}

					DialogMessage.showError(translate("err_load_bc"));
				}

				ComponentProgress.setText(translate("loading_app"), (byte) 31);
				if (WIN32) {
					JarWinClassLoader.method45((byte) 127);
				}

				try {
					local390 = download(getProperty("loader_jar"), local325);
					@Pc(506) JarClassLoader loader = new JarClassLoader(local390);
					mainapp = (Applet) loader.loadClass("loader").getDeclaredConstructor().newInstance();

					if (VERBOSE) {
						System.out.println("loader_jar : " + local390.length);
					}
				} catch (@Pc(528) Exception ex) {
					if (VERBOSE) {
						ex.printStackTrace();
					}

					DialogMessage.showError(translate("err_target_applet"));
				}

				ComponentProgress.method18(-1127);
				UrlThread.method36((byte) 42);
				frame.setTitle(getProperty("title"));
				@Pc(556) int local556 = WIN32 ? Integer.parseInt(getProperty("advert_height")) : 0;
				@Pc(566) int local566 = Integer.parseInt(getProperty("window_preferredwidth"));
				@Pc(571) int local571 = Integer.parseInt(getProperty("window_preferredheight"));
				@Pc(576) int local576 = Integer.parseInt(getProperty("applet_minwidth"));
				@Pc(581) int local581 = Integer.parseInt(getProperty("applet_minheight"));
				frame.setVisible(true);
				frame.createBufferStrategy(2);
				@Pc(592) Insets local592 = frame.getInsets();
				@Pc(602) int local602 = local592.right + local566 + local592.left + 15;
				@Pc(615) int local615 = local571 + local556 + local592.top + local592.bottom + 40;
				@Pc(619) Rectangle local619 = frame.getGraphicsConfiguration().getBounds();
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

				frame.setSize(local602, local615);
				frame.setLocationRelativeTo(null);

				if (local666) {
					frame.setExtendedState(6);
				}

				mainPanel = new WindowPanel();
				mainPanel.setBackground(Color.black);
				mainPanel.setLayout(null);
				frame.setLayout(new BorderLayout());

				@Pc(720) AppletViewer local720 = new AppletViewer();
				frame.add(mainPanel, "Center");
				mainPanel.addComponentListener(local720);

				dialogPreferences = new DialogPreferences();
				dialogPreferences.addAdjustmentListener(local720);

				@Pc(744) boolean local744 = !"yes".equals(Preferences.method25("Member", 1));
				if (WIN32 && local744) {
					canvas = new Canvas();
					mainPanel.add(canvas);
				}

				mainPanel.add(mainapp);
				topBar = new TopPanelBar(new DialogLanguage());
				topBar.setBackground(Color.BLACK);
				topBar.setForeground(Color.GRAY);
				topBar.method35((byte) -121, translate("language"));

				if (configs != null && configs.length > 1) {
					topBar.method35((byte) -108, translate("switchserver"));
				}

				topBar.setFont(new Font("SansSerif", 0, 10));
				mainPanel.add(topBar);
				copyright = new CopyrightBar(translate("tandc"));
				mainPanel.add(copyright);
				loaded = true;

				frame.doLayout();
				method3();

				if (WIN32) {
					try {
						System.load(local381.toString());
					} catch (@Pc(832) Throwable local832) {
						if (VERBOSE) {
							local832.printStackTrace();
						}
						DialogMessage.showError(translate("err_create_advertising"));
						return;
					}
				}

				if (WIN32 && local744) {
					while (true) {
						if (canvas.isDisplayable() && canvas.isShowing()) {
							try {
								browsercontrol.create(canvas, getProperty("adverturl"));
								browsercontrol.resize(canvas.getSize().width, canvas.getSize().height);
								break;
							} catch (@Pc(876) Throwable ex) {
								if (VERBOSE) {
									ex.printStackTrace();
								}

								DialogMessage.showError(translate("err_create_advertising"));
								return;
							}
						}
						try {
							Thread.sleep(100L);
						} catch (@Pc(859) Exception local859) {
						}
					}
				}

				frame.addWindowListener(WindowListener.create(-21945));
				mainapp.setStub(new GameAppletStub());
				mainapp.init();
				mainapp.start();
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
	public static void doresize(@OriginalArg(0) int type) {
		if (type == 0) {
			if (!resize) {
				resize = true;
				method3();
			}
		} else if (type == 1 && resize) {
			resize = false;
			method3();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljava/lang/String;Z)Ljava/lang/String;")
	public static String getProperty(@OriginalArg(0) String name) {
		if (currentConfig != null) {
			@Pc(8) String value = (String) currentConfig.properties.get(name);
			if (value != null) {
				return value;
			}
		}

		return (String) properties.get(name);
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
						if (VERBOSE) {
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
		if (VERBOSE) {
			throw new RuntimeException("Fatal - could not find ANY location for file: " + arg4);
		}
		throw new RuntimeException();
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "c", descriptor = "(ILjava/lang/String;)Ljava/lang/String;")
	public static String translate(@OriginalArg(1) String name) {
		if (currentConfig != null) {
			@Pc(13) String value = (String) currentConfig.localization.get(name);
			if (value != null) {
				return value;
			}
		}

		return (String) localization.get(name);
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "a", descriptor = "(Ljava/io/File;I[B)Z")
	private static boolean save(@OriginalArg(0) File file, @OriginalArg(2) byte[] src) {
		try {
			@Pc(4) FileOutputStream stream = new FileOutputStream(file);
			stream.write(src, 0, src.length);
			stream.close();
			return true;
		} catch (@Pc(20) IOException ex) {
			if (VERBOSE) {
				ex.printStackTrace();
			}

			DialogMessage.showError(translate("err_save_file"));
			return false;
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "d", descriptor = "(B)V")
	public static void method17() {
		@Pc(1) boolean local1 = false;
		if (configs == null && topBar.isVisible()) {
			local1 = true;
			topBar.setVisible(false);
		}

		if (copyright.isVisible()) {
			copyright.setVisible(false);
			local1 = true;
		}

		if (local1) {
			method3();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "<init>", descriptor = "()V")
	private AppletViewer() {
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "adjustmentValueChanged", descriptor = "(Ljava/awt/event/AdjustmentEvent;)V")
	@Override
	public void adjustmentValueChanged(@OriginalArg(0) AdjustmentEvent e) {
		if (e.getValueIsAdjusting()) {
			method3();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "componentShown", descriptor = "(Ljava/awt/event/ComponentEvent;)V")
	@Override
	public void componentShown(@OriginalArg(0) ComponentEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "componentResized", descriptor = "(Ljava/awt/event/ComponentEvent;)V")
	@Override
	public void componentResized(@OriginalArg(0) ComponentEvent e) {
		method3();
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "componentMoved", descriptor = "(Ljava/awt/event/ComponentEvent;)V")
	@Override
	public void componentMoved(@OriginalArg(0) ComponentEvent e) {
	}

	@OriginalMember(owner = "jagexappletviewer!app/appletviewer", name = "componentHidden", descriptor = "(Ljava/awt/event/ComponentEvent;)V")
	@Override
	public void componentHidden(@OriginalArg(0) ComponentEvent e) {
	}
}
