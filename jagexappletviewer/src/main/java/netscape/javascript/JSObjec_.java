package netscape.javascript;

import app.Preferences;
import app.AppletViewer;
import java.applet.Applet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!netscape/javascript/JSObjec_")
public final class JSObjec_ {

	@OriginalMember(owner = "jagexappletviewer!netscape/javascript/JSObjec_", name = "getWindow", descriptor = "(Ljava/applet/Applet;)Ljagexappletviewer!netscape/javascript/JSObjec_;")
	private static JSObjec_ getWindow(@OriginalArg(0) Applet app) {
		return new JSObjec_();
	}

	@OriginalMember(owner = "jagexappletviewer!netscape/javascript/JSObjec_", name = "<init>", descriptor = "()V")
	private JSObjec_() {
	}

	@OriginalMember(owner = "jagexappletviewer!netscape/javascript/JSObjec_", name = "eval", descriptor = "(Ljava/lang/String;)Ljava/lang/Object;")
	private Object eval(@OriginalArg(0) String str) {
		System.out.println(str);
		return null;
	}

	@OriginalMember(owner = "jagexappletviewer!netscape/javascript/JSObjec_", name = "call", descriptor = "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;")
	private Object call(@OriginalArg(0) String command, @OriginalArg(1) Object[] args) {
		System.out.println("Received command: " + command);

		if ("zap".equals(command)) {
			Preferences.set("yes", -124, "Member");
			Preferences.save();
			AppletViewer.removeadvert();
			AppletViewer.method17();
		} else if ("unzap".equals(command)) {
			Preferences.set("no", -124, "Member");
			Preferences.save();
			AppletViewer.readdadvert();
			AppletViewer.method17();
		} else if ("loggedout".equals(command)) {
			AppletViewer.method1((byte) -99);
		} else if ("resizing".equals(command) && args != null && args.length > 0 && args[0] instanceof Integer) {
			AppletViewer.doresize((Integer) args[0]);
		}

		return null;
	}
}
