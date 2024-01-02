package app;

final class UrlThread implements Runnable {
	private String a = null;
	private static UrlThread b = null;
	private String c = null;

	public static final void showurl(String var0, String var1) {
		synchronized (b) {
			b.c = var1;
			b.a = var0;
			b.notify();
		}
	}

	static final void a(byte var0) {
		if (b == null) {
			if (var0 == 42) {
				b = new UrlThread();
				Thread var1 = new Thread(b);
				var1.setPriority(10);
				var1.setDaemon(true);
				var1.start();
			}
		}
	}

	public final void run() {
		boolean var6 = Preferences.dialogVisible;

		while (true) {
			String var1 = null;
			String url = null;
			synchronized (this) {
				while (null == this.a) {
					try {
						this.wait();
					} catch (InterruptedException var7) {
					}
				}

				var1 = this.c;
				url = this.a;
				this.a = null;
				this.c = null;
			}

			try {
				if (var1 != null && var1.equals("_top") && (url.endsWith("MAGICQUIT") || ~url.indexOf("/quit.ws") != 0 || url.indexOf(".ws") == -1 && url.endsWith("/"))) {
					appletviewer.shutdown((int) 122);
				}

				if (!appletviewer.isWindows) {
					throw new Exception("Not windows");
				}

				if (!url.startsWith("http://") && !url.startsWith("https://")) {
					throw new Exception();
				}

				String var3 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";
				int var4 = 0;

				while (var4 < url.length()) {
					if (var3.indexOf(url.charAt(var4)) == -1) {
						throw new Exception();
					}

					++var4;
					if (var6) {
						break;
					}
				}

				Runtime.getRuntime().exec("cmd /c start \"j\" \"" + url + "\"");
			} catch (Exception ex) {
				if (appletviewer.debug) {
					ex.printStackTrace();
				}

				try {
					new DialogUrl(url);
				} catch (Exception ex2) {
					if (appletviewer.debug) {
						ex2.printStackTrace();
					}
				}
			}
		}
	}

	public UrlThread() {
	}
}
