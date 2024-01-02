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

import nativeadvert.browsercontrol;

public final class appletviewer implements ComponentListener, AdjustmentListener {
	private static g a;
	private static Component b;
	private static f c;
	private static Applet mainapp;
	static Frame frame;
	private static n f;
	static boolean g;
	private static Hashtable h = new Hashtable();
	static boolean debug = false;
	private static Panel j;
	private static f k;
	private static boolean l;
	private static Canvas m;
	private static Hashtable n = new Hashtable();
	static Hashtable o = new Hashtable();
	private static float p = 0.0F;
	private static m q = null;
	private static boolean r = true;
	private static String[] s;
	private static float t = 58988.0F;
	private static m[] u = null;
	private static int[] v;
	private static String w = null;
	private static File x = null;
	private static boolean y = false;
	public static boolean A;
	public static int B;
	public static boolean C;
	public static int D;

	public static final void a(byte var0) {
		boolean var1 = false;
		if (!a.isVisible()) {
			var1 = true;
			a.setVisible(true);
		}

		if (!b.isVisible()) {
			b.setVisible(true);
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
		int var2 = c.a(-1);
		if (~var2 > -1) {
			return -1;
		} else {
			Preferences.a(Integer.toString(v[var2]), -128, "Language");
			Preferences.a((byte) 124);
			return var2;
		}
	}

	private static final void b(byte flowObfuscator) {
		if (y) {
			int var1 = !a.isVisible() ? 0 : 20;
			int var2 = 0; // null != m ? Integer.parseInt(a("advert_height", true)) : 0;
			int var3 = !b.isVisible() ? 0 : 40;
			int var4 = Integer.parseInt(a("applet_minwidth", true));
			int var5 = Integer.parseInt(a("applet_minheight", true));
			int var6 = Integer.parseInt(a("applet_maxwidth", true));
			int var7 = Integer.parseInt(a("applet_maxheight", true));
			Dimension var8 = j.getSize();
			if (flowObfuscator > -95) {
				a(1, 10);
			}

			Insets var9 = j.getInsets();
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
					if (f.getParent() == null) {
						break label89;
					}

					frame.remove(f);
					frame.validate();
					if (!Preferences.c) {
						break label89;
					}
				}

				if (null == f.getParent()) {
					frame.add(f, "East");
					f.setValue(0);
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
			if (f.getParent() != null) {
				var17 = f.getValue();
				int var18 = var3 + var2 + var1 + var13;
				if (var11 + var17 > var18) {
					var17 = var18 - var11;
					if (0 > var17) {
						var17 = 0;
					}

					f.setValue(var17);
				}

				f.setMaximum(var18);
				f.setVisibleAmount(var11);
			}

			a.setBounds((var15 - var12) / 2, -var17, var12, var1);
			if (m != null) {
				m.setBounds((var15 + -var12) / 2, var1 + -var17, var12, var2);
			}

			mainapp.setBounds((-var12 + var15) / 2, -var17 + var2 + var1, var12, var13);
			b.setBounds((-var12 + var15) / 2, -var17 + var1 - -var2 + var13, var12, var3);
			if (null != m && browsercontrol.iscreated()) {
				browsercontrol.resize(m.getSize().width, m.getSize().height);
			}

			frame.repaint();
		}
	}

	private static final String a(int var0, String var1) {
		boolean var9 = Preferences.c;
		if (var0 <= 100) {
			a((File) null, 53, (byte[]) null);
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
			String var8 = Preferences.a(var6, 1);
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

	public static void removeadvert() {
		if (null != m) {
			if (browsercontrol.iscreated()) {
				browsercontrol.destroy();
			}

			j.remove(m);
			m = null;
			b((byte) -123);
		}

	}

	public final void adjustmentValueChanged(AdjustmentEvent var1) {
		if (var1.getValueIsAdjusting()) {
			b((byte) -120);
		}

	}

	static final void b(int var0) {
		if (browsercontrol.iscreated()) {
			browsercontrol.destroy();
		}

		if (var0 >= 61) {
			System.exit(0);
		}
	}

	public static void readdadvert() {
//		if (g && null == m) {
//			m = new Canvas();
//			j.add(m);
//			b((byte) -116);
//
//			while (!m.isDisplayable() || !m.isShowing()) {
//				try {
//					Thread.sleep(100L);
//				} catch (Exception var1) {
//				}
//			}
//
//			try {
//				browsercontrol.create(m, a("adverturl", true));
//				browsercontrol.resize(m.getSize().width, m.getSize().height);
//			} catch (Throwable var2) {
//				if (debug) {
//					var2.printStackTrace();
//				}
//
//				app.DialogMessage.a(500, c(1555, "err_create_advertising"));
//				return;
//			}
//		}
	}

	private static final byte[] a(String var0, String var1, byte var2) {
		boolean var7 = Preferences.c;
		byte[] var3 = new byte[300000];
		int var4 = 0;

		int var6;
		try {
			InputStream var5 = (new URL(var1 + var0)).openStream();

			while (var3.length > var4) {
				var6 = var5.read(var3, var4, var3.length - var4);
				if (-1 < ~var6) {
					break;
				}

				p += (float) var6;
				var4 += var6;
				app.ComponentProgress.a((int) (100.0F * (p / t)), 140);
				if (var7) {
					break;
				}
			}

			var5.close();
		} catch (Exception var8) {
			if (debug) {
				var8.printStackTrace();
			}

			app.DialogMessage.a(500, c(1555, "err_downloading") + ": " + var0);
		}

		byte[] var9 = new byte[var4];
		System.arraycopy(var3, 0, var9, 0, var4);
		var6 = -47 / ((4 - var2) / 60);
		return var9;
	}

	public final void componentShown(ComponentEvent event) {
	}

	public final void componentResized(ComponentEvent event) {
		b((byte) -127);
	}

	static final String a(String var0, int var1) {
		if (var1 <= 14) {
			return (String) null;
		} else {
			if (q != null) {
				String var2 = (String) q.c.get(var0);
				if (var2 != null) {
					return var2;
				}
			}

			return (String) n.get(var0);
		}
	}

	private static final void a(m var0, int var1) {
		if (var0 != null) {
			app.ComponentProgress.a(c(1555, "loading_app"), (byte) 31);
			app.ComponentProgress.a(0, 140);
			app.ComponentProgress.c(var1 ^ 48);
			app.ComponentProgress.a((byte) -98);
			if (mainapp != null) {
				if (b.isVisible()) {
					b.setVisible(false);
					b((byte) -96);
				}

				mainapp.stop();
				app.ComponentProgress.a(25, 140);
				app.ComponentProgress.a((byte) -98);
				mainapp.destroy();
				j.remove(mainapp);
				mainapp = null;
				j.remove(b);
			}

			q = var0;
			app.ComponentProgress.a(var1, 140);
			app.ComponentProgress.a((byte) -98);
			if (g) {
				app.SystemClassLoader.a((byte) 127);
			}

			try {
				String codebase = a("codebase", true);
				byte[] jar = a(a("loader_jar", true), codebase, (byte) 114);
				app.ComponentProgress.a(75, 140);
				app.ComponentProgress.a((byte) -98);
				JarClassLoader var4 = new JarClassLoader(jar);
				mainapp = (Applet) var4.loadClass("loader").newInstance();
				if (debug) {
					System.out.println("loader_jar : " + jar.length);
				}

				app.ComponentProgress.a(var1 ^ -1109);
			} catch (Exception var5) {
				if (debug) {
					var5.printStackTrace();
				}

				app.ComponentProgress.a((int) -1127);
				app.DialogMessage.a(500, c(var1 + 1505, "err_target_applet"));
			}

			j.add(mainapp);
			b = new CopyrightBar(c(1555, "tandc"));
			j.add(b);
			r = true;
			b((byte) -119);
			mainapp.setStub(new GameAppletStub());
			mainapp.init();
			mainapp.start();
		}
	}

	static final void c(byte var0) {
		boolean var9 = Preferences.c;
		String var1 = a("serverlist", true);
		m[] var2 = u;
		int var3 = u.length;
		if (var1 != null) {
			var3 = 0;
			var2 = new m[u.length];

			try {
				BufferedReader var4 = a(var1, true, (File) null);

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

						while (u.length > var8) {
							if (u[var8].b.equals(var7)) {
								var2[var3++] = u[var8];
							}

							++var8;
							if (var9) {
								break;
							}
						}
					}
				} while (!var9);

				var4.close();
			} catch (IOException var10) {
				var3 = u.length;
				var2 = u;
			}
		}

		String[] var11 = new String[var3];
		int var12 = 0;

		while (var3 > var12) {
			var11[var12] = (String) var2[var12].a.get("servername");
			++var12;
			if (var9) {
				break;
			}
		}

		k.a(var11, 2);
		var12 = k.a(-1);
		if (var0 == -90) {
			if (var12 >= 0) {
				a(var2[var12], var0 ^ -108);
			}

		}
	}

	private static final boolean a(int var0, int var1) {
		boolean var16 = Preferences.c;
		int var2 = 0;
		n.clear();
		app.Language.a(var1, -11712);
		if (var0 < 12) {
			h = (Hashtable) null;
		}

		h.clear();
		u = null;
		q = null;
		int var3 = 0;
		m[] var4 = new m[50];

		int var25;
		try {
			BufferedReader var5 = a(w, true, x);
			Hashtable var6 = n;
			Hashtable var7 = h;
			Hashtable var8 = o;

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
					m var11 = new m(var10);
					if (q == null) {
						q = var11;
					}

					if (var4.length <= var3) {
						m[] var12 = new m[10 + var3];
						System.arraycopy(var4, 0, var12, 0, var4.length);
						var4 = var12;
					}

					var4[var3++] = var11;
					var8 = var11.d;
					var7 = var11.a;
					var6 = var11.c;
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

			app.DialogMessage.a(500, c(1555, "err_load_config"));
		} catch (Exception var20) {
			if (debug) {
				var20.printStackTrace();
			}

			app.DialogMessage.a(500, c(1555, "err_decode_config"));
		}

		if (~var2 < -1) {
			s = new String[var2];
			v = new int[var2];
			int var21 = 0;
			Enumeration var22 = o.keys();

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
							s[var26] = c(1555, var23);
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

			c = new f(c(1555, "language"));
			c.a(s, 2);
			if (0 < var3) {
				u = new m[var3];
				System.arraycopy(var4, 0, u, 0, var3);
				k = new f(c(1555, "switchserver"));
			}

			if (Preferences.a("Language", 1) == null) {
				return -1 < ~a((int) 84);
			}
		}

		return true;
	}

	private static final BufferedReader a(String var0, boolean var1, File var2) throws IOException {
		if (var0 != null) {
			return new BufferedReader(new InputStreamReader((new URL(var0)).openStream()));
		} else if (null == var2) {
			if (!var1) {
				b = (Component) null;
			}

			return null;
		} else {
			return new BufferedReader(new FileReader(var2));
		}
	}

	public static final void b(int var0, String var1) {
		boolean var32 = Preferences.c;
		y = false;
		debug = Boolean.getBoolean("com.jagex.debug");
		if (debug) {
			System.setErr(app.DialogDebug.a(29, "Jagex host console"));
			System.setOut(app.DialogDebug.a(27, "Jagex host console"));
			System.out.println("release #7");
			System.out.println("java.version = " + System.getProperty("java.version"));
			System.out.println("os.name = " + System.getProperty("os.name"));
			System.out.println("os.arch = " + System.getProperty("os.arch"));
		}

		String var2;
		int var3;
		String var6;
		label297:
		{
			Preferences.b((byte) 109);
			var2 = Preferences.a("Language", 1);
			var3 = 0;
			if (null == var2) {
				byte var7;
				label315:
				{
					Locale var4 = Locale.getDefault();
					String var5 = var4.getISO3Language();
					var6 = var4.getISO3Country();
					var7 = -1;
					if (null == var5) {
						if (var6 == null) {
							break label315;
						}

						if (var6.equals("GB") || var6.equals("US")) {
							var7 = 0;
						}

						if (var6.equals("DE")) {
							var7 = 1;
						}

						if (var6.equals("FR")) {
							var7 = 2;
						}

						if (!var6.equals("BR")) {
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
					Preferences.a(Integer.toString(var7), -127, "Language");
					Preferences.a((byte) 111);
				}

				if (!var32) {
					break label297;
				}
			}

			var3 = Integer.parseInt(var2);
		}

		app.Language.a(var3, -11712);
		frame = new Frame();
		frame.getToolkit().setDynamicLayout(true);
		frame.setBackground(Color.BLACK);
		File var40 = new File((new File(System.getProperty("user.dir"))).getParentFile(), var1);
		File var41 = new File(var40, "jagexappletviewer.png");
		System.out.println("Trying to load icon file: " + var41.getAbsolutePath());
		if (var41.exists()) {
			Image var42 = Toolkit.getDefaultToolkit().getImage(var41.getAbsolutePath());
			if (var42 != null) {
				frame.setIconImage(var42);
			}
		}

		app.ComponentProgress.b(1);
		app.ComponentProgress.c(2);
		app.ComponentProgress.a(c(1555, "loading_config"), (byte) 31);
		var6 = System.getProperty("com.jagex.config");
		String var43 = System.getProperty("com.jagex.configfile");
		if (null == var6) {
			if (null == var43) {
				app.DialogMessage.a(500, c(1555, "err_missing_config"));
			}

			x = new File(var40, var43);
		}

		while (true) {
			if (var6 != null) {
				w = a(101, var6);
				System.out.println("Config URL is " + w);
			}

			if (a(16, var3)) {
				break;
			}

			var2 = Preferences.a("Language", 1);
			var3 = 0;
			if (null != var2) {
				var3 = Integer.parseInt(var2);
				if (var32) {
					break;
				}
			}
		}

		String var8 = a("viewerversion", true);
		int modewhat;
		if (null != var8) {
			try {
				modewhat = Integer.parseInt(var8);
				if (-111 > ~modewhat) {
					app.DialogMessage.b(0, c(1555, "new_version"));
				}
			} catch (NumberFormatException var34) {
			}
		}

		modewhat = Integer.parseInt(a((String) "modewhat", 61)) + 32;
		String cachesubdir = a("cachesubdir", true);
		String codebase = a("codebase", true);
		String osName = System.getProperty("os.name").toLowerCase();
		String osArch = System.getProperty("os.arch").toLowerCase();
		g = osName.startsWith("win");
		l = g && osArch.startsWith("amd64") || osArch.startsWith("x86_64");
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

		app.ComponentProgress.a(c(1555, "loading_app_resources"), (byte) 31);
		File file = null;

		byte[] data;
//		try {
//			byte[] var17;
//			if (l) {
//				data = a(a("browsercontrol_win_amd64_jar", true), codebase, (byte) -73);
//				file = load(userHome, cachesubdir, -28252, modewhat, "browsercontrol64.dll");
//				var17 = (new JarLoader(data)).read(49, "browsercontrol64.dll");
//				if (null == var17) {
//					app.DialogMessage.a(500, c(1555, "err_verify_bc64"));
//					file = null;
//				}
//
//				a(file, -109, var17);
//			} else if (g) {
//				data = a(a("browsercontrol_win_x86_jar", true), codebase, (byte) 102);
//				file = load(userHome, cachesubdir, -28252, modewhat, "browsercontrol.dll");
//				var17 = (new JarLoader(data)).read(104, "browsercontrol.dll");
//				if (var17 == null) {
//					app.DialogMessage.a(500, c(1555, "err_verify_bc"));
//					file = null;
//				}
//
//				a(file, -111, var17);
//				if (debug) {
//					System.out.println("dlldata : " + data.length);
//				}
//			}
//		} catch (Exception var39) {
//			if (debug) {
//				var39.printStackTrace();
//			}
//
//			app.DialogMessage.a(500, c(1555, "err_load_bc"));
//		}

		app.ComponentProgress.a(c(1555, "loading_app"), (byte) 31);
		if (g) {
			app.SystemClassLoader.a((byte) 127);
		}

		try {
			data = a(a("loader_jar", true), codebase, (byte) -125);
			JarClassLoader loader = new JarClassLoader(data);
			mainapp = (Applet) loader.loadClass("loader").newInstance();
			if (debug) {
				System.out.println("loader_jar : " + data.length);
			}
		} catch (Exception ex) {
			if (debug) {
				ex.printStackTrace();
			}

			app.DialogMessage.a(500, c(1555, "err_target_applet"));
		}

		app.ComponentProgress.a((int) -1127);
		app.i.a((byte) 42);
		frame.setTitle(a("title", true));
		int var44 = 0; // !g ? 0 : Integer.parseInt(a("advert_height", true));
		if (var0 < 11) {
			g = true;
		}

		int preferredWidth = Integer.parseInt(a("window_preferredwidth", true));
		int preferredHeight = Integer.parseInt(a("window_preferredheight", true));
		int minWidth = Integer.parseInt(a("applet_minwidth", true));
		int minheight = Integer.parseInt(a("applet_minheight", true));
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

		j = new aa();
		j.setBackground(Color.black);
		j.setLayout((LayoutManager) null);
		frame.setLayout(new BorderLayout());
		appletviewer viewer = new appletviewer();
		frame.add(j, "Center");
		j.addComponentListener(viewer);
		f = new n();
		f.addAdjustmentListener(viewer);
		boolean var30 = !"yes".equals(Preferences.a("Member", 1));
		if (g && var30) {
			m = new Canvas();
			j.add(m);
		}

		j.add(mainapp);
		a = new g(new DialogLanguage());
		a.setBackground(Color.BLACK);
		a.setForeground(Color.GRAY);
		a.a((byte) -121, c(1555, "language"));
		if (null != u && -2 > ~u.length) {
			a.a((byte) -108, c(1555, "switchserver"));
		}

		a.setFont(new Font("SansSerif", 0, 10));
		j.add(a);
		b = new CopyrightBar(c(1555, "tandc"));
		j.add(b);
		y = true;
		frame.doLayout();
		b((byte) -127);

//		if (g) {
//			try {
//				System.load(file.toString());
//			} catch (Throwable var36) {
//				if (debug) {
//					var36.printStackTrace();
//				}
//
//				app.DialogMessage.a(500, c(1555, "err_create_advertising"));
//				return;
//			}
//		}

//		if (g && var30) {
//			while (!m.isDisplayable() || !m.isShowing() || var32) {
//				try {
//					Thread.sleep(100L);
//				} catch (Exception var37) {
//					if (var32) {
//						break;
//					}
//				}
//			}
//
//			try {
//				browsercontrol.create(m, a("adverturl", true));
//				browsercontrol.resize(m.getSize().width, m.getSize().height);
//			} catch (Throwable var35) {
//				if (debug) {
//					var35.printStackTrace();
//				}
//
//				app.DialogMessage.a(500, c(1555, "err_create_advertising"));
//				return;
//			}
//		}

		frame.addWindowListener(app.k.a(-21945));
		mainapp.setStub(new GameAppletStub());
		mainapp.init();
		mainapp.start();
	}

	public static void doresize(int var0) {
		if (~var0 == -1) {
			if (!r) {
				r = true;
				b((byte) -124);
			}
		} else if (-2 == ~var0 && r) {
			r = false;
			b((byte) -127);
		}

	}

	public final void componentMoved(ComponentEvent var1) {
	}

	static final String a(String name, boolean var1) {
		if (null != q) {
			String var2 = (String) q.a.get(name);
			if (null != var2) {
				return var2;
			}
		}

		return !var1 ? (String) null : (String) h.get(name);
	}

	private static final File load(String var0, String var1, int flowObfuscator, int var3, String filename) {
		boolean var15 = Preferences.c;
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

	static final String c(int var0, String var1) {
		if (var0 != 1555) {
			return (String) null;
		} else {
			if (q != null) {
				String var2 = (String) q.d.get(var1);
				if (null != var2) {
					return var2;
				}
			}

			return (String) o.get(var1);
		}
	}

	public final void componentHidden(ComponentEvent var1) {
	}

	private static final boolean a(File var0, int var1, byte[] var2) {
		try {
			FileOutputStream var3 = new FileOutputStream(var0);
			if (var1 > -91) {
				return false;
			} else {
				var3.write(var2, 0, var2.length);
				var3.close();
				return true;
			}
		} catch (IOException var4) {
			if (debug) {
				var4.printStackTrace();
			}

			app.DialogMessage.a(500, c(1555, "err_save_file"));
			return false;
		}
	}

	public static final void d(byte var0) {
		boolean var1 = false;
		if (null == u && a.isVisible()) {
			var1 = true;
			a.setVisible(false);
		}

		if (b.isVisible()) {
			b.setVisible(false);
			var1 = true;
		}

		if (var1) {
			b((byte) -119);
		}

		if (var0 <= 8) {
			r = true;
		}

	}
}
