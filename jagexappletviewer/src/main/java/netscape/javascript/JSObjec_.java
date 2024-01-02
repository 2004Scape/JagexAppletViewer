package netscape.javascript;

import app.appletviewer;
import app.Preferences;

import java.applet.Applet;

public class JSObjec_ {
	public Object eval(String var1) {
		System.out.println(var1);
		return null;
	}

	public Object call(String var1, Object[] var2) {
		System.out.println("Received command: " + var1);
		if ("zap".equals(var1)) {
			Preferences.a("yes", -124, "Member");
			Preferences.a((byte) 104);
			appletviewer.removeadvert();
			appletviewer.d((byte) 66);
		}

		if ("unzap".equals(var1)) {
			Preferences.a("no", -124, "Member");
			Preferences.a((byte) 110);
			appletviewer.readdadvert();
			appletviewer.d((byte) 86);
		}

		if ("loggedout".equals(var1)) {
			appletviewer.a((byte) -99);
		}

		if ("resizing".equals(var1) && null != var2 && -1 > ~var2.length && var2[0] instanceof Integer) {
			appletviewer.doresize((Integer) var2[0]);
		}

		return null;
	}

	public static JSObjec_ getWindow(Applet var0) {
		return new JSObjec_();
	}
}
