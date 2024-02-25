import app.appletviewer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!jagexappletviewer")
public final class jagexappletviewer {

	@OriginalMember(owner = "jagexappletviewer!jagexappletviewer", name = "main", descriptor = "([Ljava/lang/String;)V")
	private static void main(@OriginalArg(0) String[] arg0) {
		if (arg0.length < 1) {
			System.exit(0);
		}
		appletviewer.method12(65, arg0[0]);
	}

	@OriginalMember(owner = "jagexappletviewer!jagexappletviewer", name = "<init>", descriptor = "()V")
	private jagexappletviewer() {
	}
}
