package app;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/o")
public final class Class9 {

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "a", descriptor = "Ljagexappletviewer!app/t;")
	public Class14 aClass14_1 = null;

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "b", descriptor = "Ljava/lang/String;")
	public String aString10;

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public Class9(@OriginalArg(0) String arg0) {
		this.aString10 = arg0;
	}

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "<init>", descriptor = "(Ljava/lang/String;Ljava/lang/String;)V")
	public Class9(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1) {
		this.aString10 = arg0;
		this.aClass14_1 = new Class14(arg1);
	}
}
