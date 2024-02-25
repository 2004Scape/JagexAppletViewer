package app;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/o")
public final class CopyrightText {

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "a", descriptor = "Ljagexappletviewer!app/t;")
	public CopyrightLink aCopyrightLink_1 = null;

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "b", descriptor = "Ljava/lang/String;")
	public String aString10;

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public CopyrightText(@OriginalArg(0) String arg0) {
		this.aString10 = arg0;
	}

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "<init>", descriptor = "(Ljava/lang/String;Ljava/lang/String;)V")
	public CopyrightText(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1) {
		this.aString10 = arg0;
		this.aCopyrightLink_1 = new CopyrightLink(arg1);
	}
}
