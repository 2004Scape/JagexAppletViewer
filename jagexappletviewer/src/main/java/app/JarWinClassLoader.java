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
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/v")
public final class JarWinClassLoader extends ClassLoader {

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "a", descriptor = "Ljava/lang/ClassLoader;")
	private static ClassLoader loader;

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "b", descriptor = "Ljagexappletviewer!app/v;")
	private static JarWinClassLoader winLoader;

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "a", descriptor = "(B)V")
	public static void method45() {
		winLoader = new JarWinClassLoader();
		winLoader.method46();
	}

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "<init>", descriptor = "()V")
	private JarWinClassLoader() {
	}

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "loadClass", descriptor = "(Ljava/lang/String;)Ljava/lang/Class;")
	@Override
	public Class loadClass(@OriginalArg(0) String name) throws ClassNotFoundException {
		if ("netscape.javascript.JSObject".equals(name)) {
			@Pc(13) CodeSource source = new CodeSource(null, (Certificate[]) null);
			@Pc(17) Permissions perm = new Permissions();
			perm.add(new AllPermission());
			@Pc(28) ProtectionDomain domain = new ProtectionDomain(source, perm);

			try {
				@Pc(34) URL local34 = this.getClass().getClassLoader().getResource("netscape/javascript/JSObjec_.class");
				@Pc(37) URLConnection local37 = local34.openConnection();
				@Pc(40) InputStream local40 = local37.getInputStream();
				@Pc(44) byte[] local44 = new byte[local37.getContentLength()];
				for (@Pc(46) int local46 = 0; local46 < local44.length; local46 += local40.read(local44, local46, local44.length - local46)) {
				}

				for (@Pc(69) int local69 = 0; local69 < local44.length; local69++) {
					@Pc(83) int local83 = local44[local69] & 0xFF;
					if ("JSObject".charAt(0) == local83) {
						for (@Pc(90) int local90 = 1; local69 + local90 < local44.length; local90++) {
							if ("JSObject".length() - 1 == local90) {
								local44[local69 + local90] = (byte) "JSObject".charAt(local90);
								break;
							}
							local83 = local44[local90 + local69] & 0xFF;
							if (local83 != "JSObject".charAt(local90)) {
								break;
							}
						}
					}
				}

				return this.defineClass(name, local44, 0, local44.length, domain);
			} catch (@Pc(149) IOException ex) {
				ex.printStackTrace();
			}
		}

		try {
			return this.getClass().getClassLoader().loadClass(name);
		} catch (@Pc(158) Exception ignored) {
			return loader.loadClass(name);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "b", descriptor = "(B)V")
	private void method46() {
		try {
			loader = ClassLoader.getSystemClassLoader();

			@Pc(12) Field sclField = ClassLoader.class.getDeclaredField("scl");
			sclField.setAccessible(true);
			sclField.set(loader, this);
			sclField.setAccessible(false);
		} catch (@Pc(28) Throwable ignored) {
		}
	}
}
