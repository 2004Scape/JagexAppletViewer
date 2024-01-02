package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;

public final class Preferences {
	private static Hashtable a = new Hashtable();
	private static File b = new File(new File(System.getProperty("user.home")), "jagexappletviewer.preferences");
	public static boolean dialogVisible;

	static final String get(String key, int flowObfuscator) {
		if (flowObfuscator != 1) {
			a = (Hashtable) null;
		}

		return (String) a.get(key);
	}

	public static final void set(String value, int flowObfuscator, String key) {
		if (flowObfuscator < -121) {
			a.put(key, value);
		}
	}

	public static final void save(byte flowObfuscator) {
		boolean var6 = Preferences.dialogVisible;
		PrintStream var1 = null;

		try {
			var1 = new PrintStream(new FileOutputStream(b));
			Enumeration var2 = a.keys();

			while (var2.hasMoreElements()) {
				String var3 = (String) var2.nextElement();
				String var4 = (String) a.get(var3);
				var1.println(var3 + "=" + var4);
				if (var6) {
					break;
				}
			}

			if (flowObfuscator <= 97) {
				b = (File) null;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (null != var1) {
				var1.close();
			}

		}

	}

	static final void load(byte flowObfuscator) {
		boolean var6 = Preferences.dialogVisible;
		BufferedReader var1 = null;
		if (flowObfuscator > 101) {
			try {
				var1 = new BufferedReader(new FileReader(b));

				do {
					String var2;
					int var3;
					do {
						if (!var1.ready()) {
							return;
						}

						var2 = var1.readLine();
						var3 = var2.indexOf("=");
					} while (0 > var3 && !var6);

					a.put(var2.substring(0, var3), var2.substring(1 + var3));
				} while (!var6);
			} catch (IOException var13) {
			} finally {
				if (var1 != null) {
					try {
						var1.close();
					} catch (IOException var12) {
					}
				}

			}

		}
	}
}
