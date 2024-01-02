package nativeadvert;

import java.awt.Canvas;

public class browsercontrol {
	private static boolean iscreated = false;
	private static boolean error = false;

	public static boolean create(Canvas var0, String var1) {
		if (iscreated) {
			throw new IllegalStateException();
		} else if (error) {
			return false;
		} else {
			boolean var2 = browsercontrol0(var0, var1);
			if (!var2) {
				error = true;
			} else {
				iscreated = true;
			}

			return var2;
		}
	}

	private static native boolean browsercontrol0(Canvas var0, String var1);

	private static native void destroy0();

	public static void destroy() {
		if (!iscreated) {
			throw new IllegalStateException();
		} else {
			destroy0();
			iscreated = false;
		}
	}

	private static native void resize0(int var0, int var1);

	public static void navigate(String var0) {
		if (!iscreated) {
			throw new IllegalStateException();
		} else {
			navigate0(var0);
		}
	}

	private static native void navigate0(String var0);

	public static boolean iscreated() {
		return iscreated;
	}

	private browsercontrol() {
	}

	public static void resize(int var0, int var1) {
		if (iscreated) {
			resize0(var0, var1);
		} else {
			throw new IllegalStateException();
		}
	}
}
