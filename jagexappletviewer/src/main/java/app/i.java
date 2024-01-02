package app;

final class i implements Runnable {
	private String a = null;
	private static i b = null;
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
				b = new i();
				Thread var1 = new Thread(b);
				var1.setPriority(10);
				var1.setDaemon(true);
				var1.start();
			}
		}
	}

	public final void run() {
		boolean var6 = Preferences.c;

		while (true) {
			String var1 = null;
			String var2 = null;
			synchronized (this) {
				while (null == this.a) {
					try {
						this.wait();
					} catch (InterruptedException var7) {
					}
				}

				var1 = this.c;
				var2 = this.a;
				this.a = null;
				this.c = null;
			}

			try {
				if (var1 != null && var1.equals("_top") && (var2.endsWith("MAGICQUIT") || ~var2.indexOf("/quit.ws") != 0 || var2.indexOf(".ws") == -1 && var2.endsWith("/"))) {
					appletviewer.b((int) 122);
				}

				if (!appletviewer.g) {
					throw new Exception("Not windows");
				}

				if (!var2.startsWith("http://") && !var2.startsWith("https://")) {
					throw new Exception();
				}

				String var3 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";
				int var4 = 0;

				while (var4 < var2.length()) {
					if (var3.indexOf(var2.charAt(var4)) == -1) {
						throw new Exception();
					}

					++var4;
					if (var6) {
						break;
					}
				}

				Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var2 + "\"");
			} catch (Exception var10) {
				if (appletviewer.i) {
					var10.printStackTrace();
				}

				try {
					new DialogUrl(var2);
				} catch (Exception var9) {
					if (appletviewer.i) {
						var9.printStackTrace();
					}
				}
			}
		}
	}

	public i() {
	}
}
