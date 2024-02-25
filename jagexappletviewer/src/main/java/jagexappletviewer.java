import app.AppletViewer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!jagexappletviewer")
public class jagexappletviewer {

	@OriginalMember(owner = "jagexappletviewer!jagexappletviewer", name = "main", descriptor = "([Ljava/lang/String;)V")
	public static void main(@OriginalArg(0) String[] args) {
		if (args.length < 1) {
			System.exit(0);
		}

		AppletViewer.start(args[0]);
	}

	@OriginalMember(owner = "jagexappletviewer!jagexappletviewer", name = "<init>", descriptor = "()V")
	public jagexappletviewer() {
	}
}
