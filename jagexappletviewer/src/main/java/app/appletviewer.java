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
import java.awt.LayoutManager;
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

public final class appletviewer implements ComponentListener, AdjustmentListener {
	private static TopPanelBar topBar;
	private static Component copyright;
	private static PopupWindow languageWindow;
	private static Applet mainapp;
	static Frame frame;
	private static DialogPreferences dialogPreferences;
	static boolean isWindows;
	private static Hashtable properties = new Hashtable();
	static boolean debug = false;
	private static Panel mainPanel;
	private static PopupWindow switchServerWindow;
	private static boolean isWindows64;
	private static Hashtable params = new Hashtable();
	static Hashtable localization = new Hashtable();
	private static float progress = 0.0F;
	private static Config currentConfig = null;
	private static boolean r = true;
	private static String[] s;
	private static float maxProgress = 58988.0F;
	private static Config[] configs = null;
	private static int[] v;
	private static String w = null;
	private static File localConfig = null;
	private static boolean loaded = false;
	public static boolean A;
	public static int B;
	public static boolean C;
	public static int D;

	public static final void a(byte var0) {
		boolean var1 = false;
		if (!topBar.isVisible()) {
			var1 = true;
			topBar.setVisible(true);
		}

		if (!copyright.isVisible()) {
			copyright.setVisible(true);
			var1 = true;
		}

		if (var1) {
			b((byte) -103);
		}

		if (var0 != -99) {
			w = (String) null;
		}

	}

	static final int a(int var0) {
		int var1 = -117 / ((0 - var0) / 54);
		int var2 = languageWindow.a(-1);
		if (~var2 > -1) {
			return -1;
		} else {
			Preferences.set(Integer.toString(v[var2]), -128, "Language");
			Preferences.save((byte) 124);
			return var2;
		}
	}

	private static final void b(byte action) {
		if (loaded) {
			int var1 = !topBar.isVisible() ? 0 : 20;
			int var2 = 0;
			int var3 = !copyright.isVisible() ? 0 : 40;
			int var4 = Integer.parseInt(getProperty("applet_minwidth", true));
			int var5 = Integer.parseInt(getProperty("applet_minheight", true));
			int var6 = Integer.parseInt(getProperty("applet_maxwidth", true));
			int var7 = Integer.parseInt(getProperty("applet_maxheight", true));
			Dimension var8 = mainPanel.getSize();
			if (action > -95) {
				a(1, 10);
			}

			Insets var9 = mainPanel.getInsets();
			int var10 = var8.width + -var9.left + -var9.right;
			int var11 = -var9.top + var8.height + -var9.bottom;
			int var12 = var10;
			int var13 = -var1 + -var2 + (var11 - var3);
			if (var4 > var10) {
				var12 = var4;
			}

			boolean var14 = false;
			if (~var13 > ~var5) {
				var14 = true;
				var13 = var5;
			}

			label89:
			{
				if (!var14) {
					if (dialogPreferences.getParent() == null) {
						break label89;
					}

					frame.remove(dialogPreferences);
					frame.validate();
					if (!Preferences.dialogVisible) {
						break label89;
					}
				}

				if (null == dialogPreferences.getParent()) {
					frame.add(dialogPreferences, "East");
					dialogPreferences.setValue(0);
					frame.validate();
				}
			}

			if (r) {
				if (~var7 > ~var13) {
					var13 = var7;
				}

				if (~var6 > ~var12) {
					var12 = var6;
				}
			}

			int var15 = var10;
			if (~var10 > ~var4) {
				var15 = var4;
			}

			if (var3 + (var2 + var5 - -var1) > var11) {
				int var10000 = var2 - -var5 - (-var3 - var1);
			}

			int var17 = 0;
			if (dialogPreferences.getParent() != null) {
				var17 = dialogPreferences.getValue();
				int var18 = var3 + var2 + var1 + var13;
				if (var11 + var17 > var18) {
					var17 = var18 - var11;
					if (0 > var17) {
						var17 = 0;
					}

					dialogPreferences.setValue(var17);
				}

				dialogPreferences.setMaximum(var18);
				dialogPreferences.setVisibleAmount(var11);
			}

			topBar.setBounds((var15 - var12) / 2, -var17, var12, var1);

			mainapp.setBounds((-var12 + var15) / 2, -var17 + var2 + var1, var12, var13);
			copyright.setBounds((-var12 + var15) / 2, -var17 + var1 - -var2 + var13, var12, var3);

			frame.repaint();
		}
	}

	private static final String a(int var0, String var1) {
		boolean var9 = Preferences.dialogVisible;
		if (var0 <= 100) {
			save((File) null, 53, (byte[]) null);
		}

		String var2 = var1;

		do {
			int var3 = var2.indexOf("$(");
			if (-1 < ~var3 && !var9) {
				break;
			}

			int var4 = var2.indexOf(":", var3);
			int var5 = var2.indexOf(")", var4);
			if (~var4 > -1 || 0 > var5) {
				break;
			}

			String var6 = var2.substring(2 + var3, var4);
			String var7 = var2.substring(var4 + 1, var5);
			String var8 = Preferences.get(var6, 1);
			if (var8 != null) {
				var7 = var8;
			}

			if (~(-1 + var2.length()) < ~var5) {
				var2 = var2.substring(0, var3) + var7 + var2.substring(var5 + 1);
				if (!var9) {
					continue;
				}
			}

			var2 = var2.substring(0, var3) + var7;
		} while (!var9);

		return var2;
	}

	public final void adjustmentValueChanged(AdjustmentEvent var1) {
		if (var1.getValueIsAdjusting()) {
			b((byte) -120);
		}

	}

	static final void shutdown(int flowObfuscator) {
		if (flowObfuscator >= 61) {
			System.exit(0);
		}
	}

	private static final byte[] downloadFile(String file, String url, byte flowObfuscator) {
		boolean var7 = Preferences.dialogVisible;
		byte[] buf = new byte[300000];
		int offset = 0;

		int read;
		try {
			InputStream stream = (new URL(url + file)).openStream();

			while (buf.length > offset) {
				read = stream.read(buf, offset, buf.length - offset);
				if (-1 < ~read) {
					break;
				}

				progress += (float) read;
				offset += read;
				ComponentProgress.setProgress((int) (100.0F * (progress / maxProgress)), 140);
				if (var7) {
					break;
				}
			}

			stream.close();
		} catch (Exception ex) {
			if (debug) {
				ex.printStackTrace();
			}

			DialogMessage.showError(500, getLocalization(1555, "err_downloading") + ": " + file);
		}

		byte[] data = new byte[offset];
		System.arraycopy(buf, 0, data, 0, offset);
		read = -47 / ((4 - flowObfuscator) / 60);
		return data;
	}

	public final void componentShown(ComponentEvent event) {
	}

	public final void componentResized(ComponentEvent event) {
		b((byte) -127);
	}

	static final String getParam(String name, int flowObfuscator) {
		if (flowObfuscator <= 14) {
			return (String) null;
		} else {
			if (currentConfig != null) {
				String value = (String) currentConfig.params.get(name);
				if (value != null) {
					return value;
				}
			}

			return (String) params.get(name);
		}
	}

	private static final void switchToServer(Config config, int flowObfuscator) {
		if (config != null) {
			ComponentProgress.setText(getLocalization(1555, "loading_app"), (byte) 31);
			ComponentProgress.setProgress(0, 140);
			ComponentProgress.show(flowObfuscator ^ 48);
			ComponentProgress.refresh((byte) -98);

			if (mainapp != null) {
				if (copyright.isVisible()) {
					copyright.setVisible(false);
					b((byte) -96);
				}

				mainapp.stop();
				ComponentProgress.setProgress(25, 140);
				ComponentProgress.refresh((byte) -98);
				mainapp.destroy();
				mainPanel.remove(mainapp);
				mainapp = null;
				mainPanel.remove(copyright);
			}

			currentConfig = config;
			ComponentProgress.setProgress(flowObfuscator, 140);
			ComponentProgress.refresh((byte) -98);

			try {
				String codebase = getProperty("codebase", true);
				byte[] jar = downloadFile(getProperty("loader_jar", true), codebase, (byte) 114);
				ComponentProgress.setProgress(75, 140);
				ComponentProgress.refresh((byte) -98);
				JarClassLoader loader = new JarClassLoader(jar);
				mainapp = (Applet) loader.loadClass("loader").newInstance();
				if (debug) {
					System.out.println("loader_jar : " + jar.length);
				}

				ComponentProgress.hide(flowObfuscator ^ -1109);
			} catch (Exception ex) {
				if (debug) {
					ex.printStackTrace();
				}

				ComponentProgress.hide((int) -1127);
				DialogMessage.showError(500, getLocalization(flowObfuscator + 1505, "err_target_applet"));
			}

			mainPanel.add(mainapp);
			copyright = new CopyrightBar(getLocalization(1555, "tandc"));
			mainPanel.add(copyright);
			r = true;
			b((byte) -119);
			mainapp.setStub(new GameAppletStub());
			mainapp.init();
			mainapp.start();
		}
	}

	static final void c(byte var0) {
		boolean var9 = Preferences.dialogVisible;
		String serverlist = getProperty("serverlist", true);
		Config[] var2 = configs;
		int var3 = configs.length;
		if (serverlist != null) {
			var3 = 0;
			var2 = new Config[configs.length];

			try {
				BufferedReader var4 = a(serverlist, true, (File) null);

				label68:
				do {
					String[] var6;
					do {
						String var5;
						do {
							var5 = var4.readLine();
							if (null == var5 && !var9) {
								break label68;
							}

							var5 = var5.trim();
						} while (var5.startsWith("//"));

						var6 = var5.split(",");
					} while (2 > var6.length);

					if (var6[1].trim().toLowerCase().equals("true")) {
						String var7 = var6[0].trim();
						int var8 = 0;

						while (configs.length > var8) {
							if (configs[var8].name.equals(var7)) {
								var2[var3++] = configs[var8];
							}

							++var8;
							if (var9) {
								break;
							}
						}
					}
				} while (!var9);

				var4.close();
			} catch (IOException ignored) {
				var3 = configs.length;
				var2 = configs;
			}
		}

		String[] var11 = new String[var3];
		int var12 = 0;

		while (var3 > var12) {
			var11[var12] = (String) var2[var12].properties.get("servername");
			++var12;
			if (var9) {
				break;
			}
		}

		switchServerWindow.a(var11, 2);
		var12 = switchServerWindow.a(-1);
		if (var0 == -90) {
			if (var12 >= 0) {
				switchToServer(var2[var12], var0 ^ -108);
			}
		}
	}

	private static final boolean a(int var0, int var1) {
		boolean var16 = Preferences.dialogVisible;
		int var2 = 0;
		params.clear();
		Language.a(var1, -11712);
		if (var0 < 12) {
			properties = (Hashtable) null;
		}

		properties.clear();
		configs = null;
		currentConfig = null;
		int serverCount = 0;
		Config[] var4 = new Config[50];

		int var25;
		try {
			BufferedReader var5 = a(w, true, localConfig);
			Hashtable var6 = params;
			Hashtable var7 = properties;
			Hashtable var8 = localization;

			label200:
			do {
				String var9;
				do {
					do {
						var9 = var5.readLine();
						if (null == var9) {
							break label200;
						}

						var9 = var9.trim();
					} while (var9.startsWith("//"));
				} while (var9.startsWith("#"));

				if (var9.startsWith("[")) {
					String var10 = var9.substring(1, var9.lastIndexOf(93));
					Config var11 = new Config(var10);
					if (currentConfig == null) {
						currentConfig = var11;
					}

					if (var4.length <= serverCount) {
						Config[] var12 = new Config[10 + serverCount];
						System.arraycopy(var4, 0, var12, 0, var4.length);
						var4 = var12;
					}

					var4[serverCount++] = var11;
					var8 = var11.localization;
					var7 = var11.properties;
					var6 = var11.params;
				}

				String var27;
				String var29;
				if (!var9.startsWith("param=")) {
					if (var9.startsWith("msg=")) {
						var9 = var9.substring(4);
						var25 = var9.indexOf(61);
						if (0 != ~var25) {
							var27 = var9.substring(0, var25).trim().toLowerCase();
							StringBuffer var28 = new StringBuffer(var9.substring(var25 - -1).trim());
							int var13 = 0;

							do {
								int var14 = var28.indexOf("\\\\", var13);
								int var15 = var28.indexOf("\\n", var13);
								if (var14 < 0 && var15 < 0 && !var16) {
									break;
								}

								if (var14 >= 0 && (0 > var15 || ~var14 >= ~var15)) {
									var13 = 1 + var14;
									var28.replace(var14, 2 + var14, "\\");
									if (!var16) {
										continue;
									}
								}

								var28.replace(var15, 2 + var15, "\n");
								var13 = var15 + 1;
							} while (!var16);

							if (var27.startsWith("lang")) {
								try {
									++var2;
									Integer.parseInt(var27.substring(4));
								} catch (NumberFormatException var17) {
								}
							}

							var8.put(var27, var28.toString());
							if (debug) {
								System.out.println("Message - name=" + var27 + " text=" + var28.toString());
							}
						}

						if (!var16) {
							continue;
						}
					}

					var25 = var9.indexOf(61);
					if (0 != ~var25) {
						var27 = var9.substring(0, var25).trim().toLowerCase();
						var29 = var9.substring(1 + var25).trim();
						var7.put(var27, var29);
						if (debug) {
							System.out.println("Ourconfig - variable=" + var27 + " value=" + var29);
						}
					}

					if (!var16) {
						continue;
					}
				}

				var9 = var9.substring(6);
				var25 = var9.indexOf(61);
				if (-1 != var25) {
					var27 = var9.substring(0, var25).trim().toLowerCase();
					var29 = var9.substring(var25 + 1).trim();
					var6.put(var27, var29);
					if (debug) {
						System.out.println("Innerconfig - variable=" + var27 + " value=" + var29);
					}
				}
			} while (!var16);

			var5.close();
		} catch (IOException var19) {
			if (debug) {
				var19.printStackTrace();
			}

			DialogMessage.showError(500, getLocalization(1555, "err_load_config"));
		} catch (Exception var20) {
			if (debug) {
				var20.printStackTrace();
			}

			DialogMessage.showError(500, getLocalization(1555, "err_decode_config"));
		}

		if (~var2 < -1) {
			s = new String[var2];
			v = new int[var2];
			int var21 = 0;
			Enumeration var22 = localization.keys();

			label143:
			do {
				while (true) {
					if (!var22.hasMoreElements()) {
						break label143;
					}

					String var23 = (String) var22.nextElement();
					if (!var23.startsWith("lang")) {
						break;
					}

					int var24 = 0;

					try {
						var24 = Integer.parseInt(var23.substring(4));
					} catch (NumberFormatException var18) {
						if (!var16) {
							continue;
						}
					}

					int var26 = 0;

					while (var21 >= var26) {
						if (var26 == var21 || ~var24 > ~v[var26]) {
							var25 = var21;

							while (var26 < var25) {
								s[var25] = s[var25 - 1];
								v[var25] = v[var25 - 1];
								--var25;
								if (var16) {
									break;
								}
							}

							v[var26] = var24;
							s[var26] = getLocalization(1555, var23);
							if (!var16) {
								break;
							}
						}

						++var26;
						if (var16) {
							break;
						}
					}

					++var21;
					break;
				}
			} while (!var16);

			languageWindow = new PopupWindow(getLocalization(1555, "language"));
			languageWindow.a(s, 2);
			if (serverCount > 0) {
				configs = new Config[serverCount];
				System.arraycopy(var4, 0, configs, 0, serverCount);
				switchServerWindow = new PopupWindow(getLocalization(1555, "switchserver"));
			}

			if (Preferences.get("Language", 1) == null) {
				return -1 < ~a((int) 84);
			}
		}

		return true;
	}

	private static final BufferedReader a(String remote, boolean flowObfuscator, File local) throws IOException {
		if (remote != null) {
			return new BufferedReader(new InputStreamReader((new URL(remote)).openStream()));
		} else if (null == local) {
			if (!flowObfuscator) {
				copyright = (Component) null;
			}

			return null;
		} else {
			return new BufferedReader(new FileReader(local));
		}
	}

	public static final void b(int var0, String var1) {
		boolean var32 = Preferences.dialogVisible;
		loaded = false;
		debug = Boolean.getBoolean("com.jagex.debug");
		if (debug) {
			System.setErr(DialogDebug.getPrintStream(29, "Jagex host console"));
			System.setOut(DialogDebug.getPrintStream(27, "Jagex host console"));

			System.out.println("release #1");
			System.out.println("java.version = " + System.getProperty("java.version"));
			System.out.println("os.name = " + System.getProperty("os.name"));
			System.out.println("os.arch = " + System.getProperty("os.arch"));
		}

		String var2;
		int var3;
		String configuri;
		label297:
		{
			Preferences.load((byte) 109);
			var2 = Preferences.get("Language", 1);
			var3 = 0;
			if (null == var2) {
				byte var7;
				label315:
				{
					Locale var4 = Locale.getDefault();
					String var5 = var4.getISO3Language();
					configuri = var4.getISO3Country();
					var7 = -1;
					if (null == var5) {
						if (configuri == null) {
							break label315;
						}

						if (configuri.equals("GB") || configuri.equals("US")) {
							var7 = 0;
						}

						if (configuri.equals("DE")) {
							var7 = 1;
						}

						if (configuri.equals("FR")) {
							var7 = 2;
						}

						if (!configuri.equals("BR")) {
							break label315;
						}

						var7 = 3;
						if (!var32) {
							break label315;
						}
					}

					if (var5.equals("eng")) {
						var7 = 0;
					}

					if (var5.equals("ger") || var5.equals("deu")) {
						var7 = 1;
					}

					if (var5.equals("fre") || var5.equals("fra")) {
						var7 = 2;
					}

					if (var5.equals("por")) {
						var7 = 3;
					}
				}

				if (~var7 <= -1) {
					Preferences.set(Integer.toString(var7), -127, "Language");
					Preferences.save((byte) 111);
				}

				if (!var32) {
					break label297;
				}
			}

			var3 = Integer.parseInt(var2);
		}

		Language.a(var3, -11712);
		frame = new Frame();
		frame.getToolkit().setDynamicLayout(true);
		frame.setBackground(Color.BLACK);
		File configpath = new File((new File(System.getProperty("user.dir"))).getParentFile(), var1);
		File var41 = new File(configpath, "jagexappletviewer.png");
		System.out.println("Trying to load icon file: " + var41.getAbsolutePath());
		if (var41.exists()) {
			Image var42 = Toolkit.getDefaultToolkit().getImage(var41.getAbsolutePath());
			if (var42 != null) {
				frame.setIconImage(var42);
			}
		}

		ComponentProgress.init(1);
		ComponentProgress.show(2);
		ComponentProgress.setText(getLocalization(1555, "loading_config"), (byte) 31);
		configuri = System.getProperty("com.jagex.config");
		String configfile = System.getProperty("com.jagex.configfile");
		if (null == configuri) {
			if (null == configfile) {
				DialogMessage.showError(500, getLocalization(1555, "err_missing_config"));
			}

			localConfig = new File(configpath, configfile);
		}

		while (true) {
			if (configuri != null) {
				w = a(101, configuri);
				System.out.println("Config URL is " + w);
			}

			if (a(16, var3)) {
				break;
			}

			var2 = Preferences.get("Language", 1);
			var3 = 0;
			if (null != var2) {
				var3 = Integer.parseInt(var2);
				if (var32) {
					break;
				}
			}
		}

		String var8 = getProperty("viewerversion", true);
		int modewhat;
		if (null != var8) {
			try {
				modewhat = Integer.parseInt(var8);
				if (-111 > ~modewhat) {
					DialogMessage.showMessage(0, getLocalization(1555, "new_version"));
				}
			} catch (NumberFormatException ignored) {
			}
		}

		modewhat = Integer.parseInt(getParam((String) "modewhat", 61)) + 32;
		String cachesubdir = getProperty("cachesubdir", true);
		String codebase = getProperty("codebase", true);
		String osName = System.getProperty("os.name").toLowerCase();
		String osArch = System.getProperty("os.arch").toLowerCase();
		isWindows = osName.startsWith("win");
		isWindows64 = isWindows && osArch.startsWith("amd64") || osArch.startsWith("x86_64");
		String userHome = null;

		try {
			userHome = System.getProperty("user.home");
			if (userHome != null) {
				userHome = userHome + "/";
			}
		} catch (Exception ignored) {
		}

		if (userHome == null) {
			userHome = "~/";
		}

		ComponentProgress.setText(getLocalization(1555, "loading_app_resources"), (byte) 31);
		File file = null;

		byte[] data;
		ComponentProgress.setText(getLocalization(1555, "loading_app"), (byte) 31);

		try {
			data = downloadFile(getProperty("loader_jar", true), codebase, (byte) -125);
			JarClassLoader loader = new JarClassLoader(data);
			mainapp = (Applet) loader.loadClass("loader").newInstance();
			if (debug) {
				System.out.println("loader_jar : " + data.length);
			}
		} catch (Exception ex) {
			if (debug) {
				ex.printStackTrace();
			}

			DialogMessage.showError(500, getLocalization(1555, "err_target_applet"));
		}

		ComponentProgress.hide((int) -1127);
		UrlThread.a((byte) 42);
		frame.setTitle(getProperty("title", true));
		int var44 = 0;
		if (var0 < 11) {
			isWindows = true;
		}

		int preferredWidth = Integer.parseInt(getProperty("window_preferredwidth", true));
		int preferredHeight = Integer.parseInt(getProperty("window_preferredheight", true));
		int minWidth = Integer.parseInt(getProperty("applet_minwidth", true));
		int minheight = Integer.parseInt(getProperty("applet_minheight", true));
		frame.setVisible(true);
		byte var21 = 40;
		frame.createBufferStrategy(2);
		Insets var22 = frame.getInsets();
		int var23 = var22.right + preferredWidth + (var22.left - -15);
		int var24 = var21 + (preferredHeight + var44 + var22.top - -var22.bottom);
		Rectangle var25 = frame.getGraphicsConfiguration().getBounds();
		int var26 = -50 + var25.width;
		int var27 = var25.height + -50;
		if (var26 < var23) {
			var23 = var22.left - -minWidth - -var22.right - -15;
		}

		if (~var27 > ~var24) {
			var24 = minheight + var44 + (var22.top + var21 - -var22.bottom);
		}

		boolean var28 = false;
		if (~var26 > ~var23) {
			var23 = var26;
			var28 = true;
		}

		if (~var24 < ~var27) {
			var28 = true;
			var24 = var27;
		}

		frame.setSize(var23, var24);
		frame.setLocationRelativeTo((Component) null);
		if (var28) {
			frame.setExtendedState(6);
		}

		mainPanel = new WindowPanel();
		mainPanel.setBackground(Color.black);
		mainPanel.setLayout((LayoutManager) null);
		frame.setLayout(new BorderLayout());
		appletviewer viewer = new appletviewer();
		frame.add(mainPanel, "Center");
		mainPanel.addComponentListener(viewer);
		dialogPreferences = new DialogPreferences();
		dialogPreferences.addAdjustmentListener(viewer);

		mainPanel.add(mainapp);
		topBar = new TopPanelBar(new DialogLanguage());
		topBar.setBackground(Color.BLACK);
		topBar.setForeground(Color.GRAY);
		topBar.a((byte) -121, getLocalization(1555, "language"));
		if (null != configs && -2 > ~configs.length) {
			topBar.a((byte) -108, getLocalization(1555, "switchserver"));
		}

		topBar.setFont(new Font("SansSerif", 0, 10));
		mainPanel.add(topBar);
		copyright = new CopyrightBar(getLocalization(1555, "tandc"));
		mainPanel.add(copyright);
		loaded = true;
		frame.doLayout();
		b((byte) -127);

		frame.addWindowListener(WindowListener.create(-21945));
		mainapp.setStub(new GameAppletStub());
		mainapp.init();
		mainapp.start();
	}

	public static void doresize(int type) {
		if (~type == -1) {
			if (!r) {
				r = true;
				b((byte) -124);
			}
		} else if (-2 == ~type && r) {
			r = false;
			b((byte) -127);
		}
	}

	public final void componentMoved(ComponentEvent event) {
	}

	static final String getProperty(String name, boolean flowObfuscator) {
		if (null != currentConfig) {
			String value = (String) currentConfig.properties.get(name);
			if (null != value) {
				return value;
			}
		}

		return !flowObfuscator ? (String) null : (String) properties.get(name);
	}

	private static final File load(String var0, String var1, int flowObfuscator, int var3, String filename) {
		boolean var15 = Preferences.dialogVisible;
		String[] var5 = new String[] { System.getenv("user.home"), "C:/", "~/", "/tmp/", "" };
		String[] var6 = new String[] { ".lostcity" };
		if (flowObfuscator != -28252) {
			a(27, (String) null);
		}

		int var7 = 0;

		while (2 > var7) {
			int var8 = 0;

			label105:
			while (~var8 > ~var6.length) {
				int var9 = 0;

				while (true) {
					if (var9 < var5.length) {
						String var10 = var5[var9] + var6[var8] + "/" + (null == var1 ? "" : var1 + "/") + filename;
						RandomAccessFile var11 = null;

						label115:
						{
							label116:
							{
								File var12;
								boolean var10001;
								label96:
								{
									try {
										var12 = new File(var10);
										if (~var7 != -1 || var12.exists()) {
											break label96;
										}
									} catch (Exception var19) {
										var10001 = false;
										break label116;
									}

									if (!var15) {
										break label115;
									}
								}

								label88:
								{
									try {
										String var13 = var5[var9];
										if (~var7 != -2 || -1 <= ~var13.length() || (new File(var13)).exists()) {
											break label88;
										}
									} catch (Exception var18) {
										var10001 = false;
										break label116;
									}

									if (!var15) {
										break label115;
									}
								}

								try {
									(new File(var5[var9] + var6[var8])).mkdir();
									if (var1 != null) {
										(new File(var5[var9] + var6[var8] + "/" + var1)).mkdir();
									}

									var11 = new RandomAccessFile(var12, "rw");
									int var14 = var11.read();
									var11.seek(0L);
									var11.write(var14);
									var11.seek(0L);
									var11.close();
									return var12;
								} catch (Exception var17) {
									var10001 = false;
								}
							}

							if (debug) {
								System.out.println("Unable to open/write: " + var10);
							}

							try {
								if (var11 != null) {
									var11.close();
									var11 = null;
								}
							} catch (Exception var16) {
							}
						}

						++var9;
						if (!var15) {
							continue;
						}
					}

					++var8;
					if (!var15) {
						break;
					}
					break label105;
				}
			}

			++var7;
			if (var15) {
				break;
			}
		}

		if (debug) {
			throw new RuntimeException("Fatal - could not find ANY location for file: " + filename);
		} else {
			throw new RuntimeException();
		}
	}

	static final String getLocalization(int flowObfuscator, String name) {
		if (flowObfuscator != 1555) {
			return (String) null;
		} else {
			if (currentConfig != null) {
				String value = (String) currentConfig.localization.get(name);
				if (null != value) {
					return value;
				}
			}

			return (String) localization.get(name);
		}
	}

	public final void componentHidden(ComponentEvent event) {
	}

	private static final boolean save(File file, int flowObfuscator, byte[] src) {
		try {
			FileOutputStream stream = new FileOutputStream(file);
			if (flowObfuscator > -91) {
				return false;
			} else {
				stream.write(src, 0, src.length);
				stream.close();
				return true;
			}
		} catch (IOException ex) {
			if (debug) {
				ex.printStackTrace();
			}

			DialogMessage.showError(500, getLocalization(1555, "err_save_file"));
			return false;
		}
	}

	public static final void d(byte flowObfuscator) {
		boolean var1 = false;
		if (null == configs && topBar.isVisible()) {
			var1 = true;
			topBar.setVisible(false);
		}

		if (copyright.isVisible()) {
			copyright.setVisible(false);
			var1 = true;
		}

		if (var1) {
			b((byte) -119);
		}

		if (flowObfuscator <= 8) {
			r = true;
		}

	}
}
