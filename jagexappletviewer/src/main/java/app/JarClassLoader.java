package app;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.Hashtable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/l")
public final class JarClassLoader extends ClassLoader {

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "a", descriptor = "Ljava/util/Hashtable;")
	private Hashtable cache = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "b", descriptor = "Ljagexappletviewer!app/u;")
	private JarLoader loader;

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "c", descriptor = "Ljava/security/ProtectionDomain;")
	private ProtectionDomain domain;

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "<init>", descriptor = "([B)V")
	public JarClassLoader(@OriginalArg(0) byte[] src) throws IOException {
		this.loader = new JarLoader(src);
		@Pc(19) CodeSource source = new CodeSource(null, (Certificate[]) null);
		@Pc(23) Permissions perms = new Permissions();
		perms.add(new AllPermission());
		this.domain = new ProtectionDomain(source, perms);
	}

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "loadClass", descriptor = "(Ljava/lang/String;Z)Ljava/lang/Class;")
	@Override
	protected synchronized Class loadClass(@OriginalArg(0) String name, @OriginalArg(1) boolean resolve) throws ClassNotFoundException {
		@Pc(5) Class instance = (Class) this.cache.get(name);
		if (instance != null) {
			return instance;
		}

		@Pc(23) byte[] src = this.loader.read(name.replace('.', '/') + ".class", false);
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

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "getResourceAsStream", descriptor = "(Ljava/lang/String;)Ljava/io/InputStream;")
	@Override
	public InputStream getResourceAsStream(@OriginalArg(0) String name) {
		@Pc(5) byte[] src = this.loader.read(name, false);
		return src == null ? ClassLoader.getSystemResourceAsStream(name) : new ByteArrayInputStream(src);
	}
}
