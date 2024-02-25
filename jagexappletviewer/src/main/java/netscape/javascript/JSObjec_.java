package netscape.javascript;

import app.Class2;
import app.appletviewer;
import java.applet.Applet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!netscape/javascript/JSObjec_")
public final class JSObjec_ {

	@OriginalMember(owner = "jagexappletviewer!netscape/javascript/JSObjec_", name = "getWindow", descriptor = "(Ljava/applet/Applet;)Ljagexappletviewer!netscape/javascript/JSObjec_;")
	private static JSObjec_ getWindow(@OriginalArg(0) Applet arg0) {
		return new JSObjec_();
	}

	@OriginalMember(owner = "jagexappletviewer!netscape/javascript/JSObjec_", name = "<init>", descriptor = "()V")
	private JSObjec_() {
	}

	@OriginalMember(owner = "jagexappletviewer!netscape/javascript/JSObjec_", name = "eval", descriptor = "(Ljava/lang/String;)Ljava/lang/Object;")
	private Object eval(@OriginalArg(0) String arg0) {
		System.out.println(arg0);
		return null;
	}

	@OriginalMember(owner = "jagexappletviewer!netscape/javascript/JSObjec_", name = "call", descriptor = "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;")
	private Object call(@OriginalArg(0) String arg0, @OriginalArg(1) Object[] arg1) {
		System.out.println("Received command: " + arg0);
		if ("zap".equals(arg0)) {
			Class2.method26("yes", -124, "Member");
			Class2.method27((byte) 104);
			appletviewer.removeadvert();
			appletviewer.method17((byte) 66);
		}
		if ("unzap".equals(arg0)) {
			Class2.method26("no", -124, "Member");
			Class2.method27((byte) 110);
			appletviewer.readdadvert();
			appletviewer.method17((byte) 86);
		}
		if ("loggedout".equals(arg0)) {
			appletviewer.method1((byte) -99);
		}
		if ("resizing".equals(arg0) && arg1 != null && arg1.length > 0 && arg1[0] instanceof Integer) {
			appletviewer.doresize((Integer) arg1[0]);
		}
		return null;
	}
}
