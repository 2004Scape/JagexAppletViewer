package app;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/o")
public final class CopyrightText {

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "a", descriptor = "Ljagexappletviewer!app/t;")
	public CopyrightLink url = null;

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "b", descriptor = "Ljava/lang/String;")
	public String text;

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public CopyrightText(@OriginalArg(0) String text) {
		this.text = text;
	}

	@OriginalMember(owner = "jagexappletviewer!app/o", name = "<init>", descriptor = "(Ljava/lang/String;Ljava/lang/String;)V")
	public CopyrightText(@OriginalArg(0) String text, @OriginalArg(1) String url) {
		this.text = text;
		this.url = new CopyrightLink(url);
	}
}
