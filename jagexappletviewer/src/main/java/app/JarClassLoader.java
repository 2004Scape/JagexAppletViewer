package app;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.Hashtable;

final class JarClassLoader extends ClassLoader {
	private Hashtable a = new Hashtable();
	private JarLoader b;
	private ProtectionDomain c;

	protected final synchronized Class loadClass(String var1, boolean var2) throws ClassNotFoundException {
		Class var3 = (Class) this.a.get(var1);
		if (null != var3) {
			return var3;
		} else {
			byte[] var4 = this.b.a(90, var1 + ".class");
			if (null != var4) {
				var3 = this.defineClass(var1, var4, 0, var4.length, this.c);
				if (var2) {
					this.resolveClass(var3);
				}

				this.a.put(var1, var3);
				return var3;
			} else {
				return super.findSystemClass(var1);
			}
		}
	}

	public final InputStream getResourceAsStream(String var1) {
		byte[] var2 = this.b.a(118, var1);
		return (InputStream) (var2 != null ? new ByteArrayInputStream(var2) : ClassLoader.getSystemResourceAsStream(var1));
	}

	JarClassLoader(byte[] var1) throws IOException {
		this.b = new JarLoader(var1);
		CodeSource var2 = new CodeSource((URL) null, (Certificate[]) null);
		Permissions var3 = new Permissions();
		var3.add(new AllPermission());
		this.c = new ProtectionDomain(var2, var3);
	}
}
