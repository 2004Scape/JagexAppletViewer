package app;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/i")
public final class UrlThread implements Runnable {

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "b", descriptor = "Ljagexappletviewer!app/i;")
	private static UrlThread thread = null;

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "a", descriptor = "Ljava/lang/String;")
	private String url = null;

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "c", descriptor = "Ljava/lang/String;")
	private String target = null;

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "showurl", descriptor = "(Ljava/lang/String;Ljava/lang/String;)V")
	public static void showurl(@OriginalArg(0) String url, @OriginalArg(1) String target) {
		@Pc(2) UrlThread urlThread = thread;
		synchronized (urlThread) {
			thread.target = target;
			thread.url = url;
			thread.notify();
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "a", descriptor = "(B)V")
	public static void method36() {
		if (thread != null) {
			return;
		}

		thread = new UrlThread();

		@Pc(16) Thread temp = new Thread(thread);
		temp.setPriority(10);
		temp.setDaemon(true);
		temp.start();
	}

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "<init>", descriptor = "()V")
	private UrlThread() {
	}

	@OriginalMember(owner = "jagexappletviewer!app/i", name = "run", descriptor = "()V")
	@Override
	public void run() {
		while (true) {
			@Pc(3) String local3;
			@Pc(5) String local5;

			synchronized (this) {
				while (this.url == null) {
					try {
						this.wait();
					} catch (@Pc(31) InterruptedException ignored) {
					}
				}

				local3 = this.target;
				local5 = this.url;
				this.url = null;
				this.target = null;
			}

			try {
				if (local3 != null && local3.equals("_top") && (local5.endsWith("MAGICQUIT") || local5.indexOf("/quit.ws") != -1 || local5.indexOf(".ws") == -1 && local5.endsWith("/"))) {
					AppletViewer.close();
				}

				if (!AppletViewer.WIN32) {
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
			} catch (@Pc(125) Exception ex) {
				if (AppletViewer.VERBOSE) {
					ex.printStackTrace();
				}

				try {
					new DialogUrl(local5);
				} catch (@Pc(137) Exception ex2) {
					if (AppletViewer.VERBOSE) {
						ex2.printStackTrace();
					}
				}
			}
		}
	}
}
