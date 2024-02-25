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
	private Hashtable aHashtable5 = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "b", descriptor = "Ljagexappletviewer!app/u;")
	private JarLoader aJarLoader_1;

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "c", descriptor = "Ljava/security/ProtectionDomain;")
	private ProtectionDomain aProtectionDomain1;

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "<init>", descriptor = "([B)V")
	public JarClassLoader(@OriginalArg(0) byte[] arg0) throws IOException {
		this.aJarLoader_1 = new JarLoader(arg0);
		@Pc(19) CodeSource local19 = new CodeSource(null, (Certificate[]) null);
		@Pc(23) Permissions local23 = new Permissions();
		local23.add(new AllPermission());
		this.aProtectionDomain1 = new ProtectionDomain(local19, local23);
	}

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "loadClass", descriptor = "(Ljava/lang/String;Z)Ljava/lang/Class;")
	@Override
	protected synchronized Class loadClass(@OriginalArg(0) String arg0, @OriginalArg(1) boolean arg1) throws ClassNotFoundException {
		@Pc(5) Class local5 = (Class) this.aHashtable5.get(arg0);
		if (local5 != null) {
			return local5;
		}
		@Pc(23) byte[] local23 = this.aJarLoader_1.method44(90, arg0 + ".class");
		if (local23 == null) {
			return super.findSystemClass(arg0);
		}
		local5 = this.defineClass(arg0, local23, 0, local23.length, this.aProtectionDomain1);
		if (arg1) {
			this.resolveClass(local5);
		}
		this.aHashtable5.put(arg0, local5);
		return local5;
	}

	@OriginalMember(owner = "jagexappletviewer!app/l", name = "getResourceAsStream", descriptor = "(Ljava/lang/String;)Ljava/io/InputStream;")
	@Override
	public InputStream getResourceAsStream(@OriginalArg(0) String arg0) {
		@Pc(5) byte[] local5 = this.aJarLoader_1.method44(118, arg0);
		return local5 == null ? ClassLoader.getSystemResourceAsStream(arg0) : new ByteArrayInputStream(local5);
	}
}
