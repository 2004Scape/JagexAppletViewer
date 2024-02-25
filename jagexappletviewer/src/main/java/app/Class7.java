package app;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/i")
public final class Class7 implements Runnable {

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "b", descriptor = "Ljagexappletviewer!app/i;")
	private static Class7 aClass7_1 = null;

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "a", descriptor = "Ljava/lang/String;")
	private String aString7 = null;

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "c", descriptor = "Ljava/lang/String;")
	private String aString8 = null;

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "showurl", descriptor = "(Ljava/lang/String;Ljava/lang/String;)V")
	public static void showurl(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1) {
		@Pc(2) Class7 local2 = aClass7_1;
		synchronized (aClass7_1) {
			aClass7_1.aString8 = arg1;
			aClass7_1.aString7 = arg0;
			aClass7_1.notify();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "a", descriptor = "(B)V")
	public static void method36(@OriginalArg(0) byte arg0) {
		if (aClass7_1 != null || arg0 != 42) {
			return;
		}
		aClass7_1 = new Class7();
		@Pc(16) Thread local16 = new Thread(aClass7_1);
		local16.setPriority(10);
		local16.setDaemon(true);
		local16.start();
	}

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "<init>", descriptor = "()V")
	private Class7() {
	}

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "run", descriptor = "()V")
	@Override
	public void run() {
		while (true) {
			@Pc(3) String local3 = null;
			@Pc(5) String local5 = null;
			synchronized (this) {
				while (this.aString7 == null) {
					try {
						this.wait();
					} catch (@Pc(31) InterruptedException local31) {
					}
				}
				local3 = this.aString8;
				local5 = this.aString7;
				this.aString7 = null;
				this.aString8 = null;
			}
			try {
				if (local3 != null && local3.equals("_top") && (local5.endsWith("MAGICQUIT") || local5.indexOf("/quit.ws") != -1 || local5.indexOf(".ws") == -1 && local5.endsWith("/"))) {
					appletviewer.method5(122);
				}
				if (!appletviewer.aBoolean1) {
					throw new Exception("Not windows");
				}
				if (!local5.startsWith("http://") && !local5.startsWith("https://")) {
					throw new Exception();
				}
				@Pc(83) String local83 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";
				for (@Pc(85) int local85 = 0; local85 < local5.length(); local85++) {
					if (local83.indexOf(local5.charAt(local85)) == -1) {
						throw new Exception();
					}
				}
				Runtime.getRuntime().exec("cmd /c start \"j\" \"" + local5 + "\"");
			} catch (@Pc(125) Exception local125) {
				if (appletviewer.aBoolean2) {
					local125.printStackTrace();
				}
				try {
					new WindowAdapter_Sub2(local5);
				} catch (@Pc(137) Exception local137) {
					if (appletviewer.aBoolean2) {
						local137.printStackTrace();
					}
				}
			}
		}
	}
}
