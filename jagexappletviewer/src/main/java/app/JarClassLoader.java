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
	private Hashtable cache = new Hashtable();
	private JarLoader loader;
	private ProtectionDomain domain;

	protected final synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
		Class instance = (Class) this.cache.get(name);
		if (instance != null) {
			return instance;
		}

		byte[] src = this.loader.read(90, name.replace('.', '/') + ".class");
		if (src == null) {
			return super.findSystemClass(name);
		}

		instance = this.defineClass(name, src, 0, src.length, this.domain);
		if (resolve) {
			this.resolveClass(instance);
		}

		this.cache.put(name, instance);
		return instance;
	}

	public final InputStream getResourceAsStream(String name) {
		byte[] src = this.loader.read(118, name);
		return (InputStream) (src != null ? new ByteArrayInputStream(src) : ClassLoader.getSystemResourceAsStream(name));
	}

	JarClassLoader(byte[] src) throws IOException {
		this.loader = new JarLoader(src);
		CodeSource source = new CodeSource((URL) null, (Certificate[]) null);
		Permissions perms = new Permissions();
		perms.add(new AllPermission());
		this.domain = new ProtectionDomain(source, perms);
	}
}
