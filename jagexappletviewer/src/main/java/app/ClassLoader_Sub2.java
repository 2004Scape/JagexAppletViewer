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
public final class ClassLoader_Sub2 extends ClassLoader {

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "a", descriptor = "Ljava/lang/ClassLoader;")
	private static ClassLoader aClassLoader1;

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "b", descriptor = "Ljagexappletviewer!app/v;")
	private static ClassLoader_Sub2 aClassLoader_Sub2_1;

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "a", descriptor = "(B)V")
	public static void method45(@OriginalArg(0) byte arg0) {
		aClassLoader_Sub2_1 = new ClassLoader_Sub2();
		aClassLoader_Sub2_1.method46((byte) -122);
	}

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "<init>", descriptor = "()V")
	private ClassLoader_Sub2() {
	}

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "loadClass", descriptor = "(Ljava/lang/String;)Ljava/lang/Class;")
	@Override
	public Class loadClass(@OriginalArg(0) String arg0) throws ClassNotFoundException {
		if ("netscape.javascript.JSObject".equals(arg0)) {
			@Pc(13) CodeSource local13 = new CodeSource(null, (Certificate[]) null);
			@Pc(17) Permissions local17 = new Permissions();
			local17.add(new AllPermission());
			@Pc(28) ProtectionDomain local28 = new ProtectionDomain(local13, local17);
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
				return this.defineClass(arg0, local44, 0, local44.length, local28);
			} catch (@Pc(149) IOException local149) {
				local149.printStackTrace();
			}
		}
		try {
			return this.getClass().getClassLoader().loadClass(arg0);
		} catch (@Pc(158) Exception local158) {
			return aClassLoader1.loadClass(arg0);
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/v", name = "b", descriptor = "(B)V")
	private void method46(@OriginalArg(0) byte arg0) {
		try {
			aClassLoader1 = ClassLoader.getSystemClassLoader();
			@Pc(12) Field local12 = ClassLoader.class.getDeclaredField("scl");
			local12.setAccessible(true);
			local12.set(aClassLoader1, this);
			local12.setAccessible(false);
		} catch (@Pc(28) Throwable local28) {
		}
	}
}
