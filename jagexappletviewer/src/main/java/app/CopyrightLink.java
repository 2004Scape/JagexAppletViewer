package app;

import java.awt.Rectangle;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/t")
public final class CopyrightLink {

	@OriginalMember(owner = "jagexappletviewer!app/t", name = "b", descriptor = "Ljava/awt/Rectangle;")
	public Rectangle size = new Rectangle();

	@OriginalMember(owner = "jagexappletviewer!app/t", name = "a", descriptor = "Ljava/lang/String;")
	public String url;

	@OriginalMember(owner = "jagexappletviewer!app/t", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public CopyrightLink(@OriginalArg(0) String url) {
		this.url = url;
	}
}
