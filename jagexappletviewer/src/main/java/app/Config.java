package app;

import java.util.Hashtable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/m")
public final class Config {

	@OriginalMember(owner = "jagexappletviewer!app/m", name = "a", descriptor = "Ljava/util/Hashtable;")
	public Hashtable properties = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/m", name = "c", descriptor = "Ljava/util/Hashtable;")
	public Hashtable params = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/m", name = "d", descriptor = "Ljava/util/Hashtable;")
	public Hashtable localization = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/m", name = "b", descriptor = "Ljava/lang/String;")
	public String name;

	@OriginalMember(owner = "jagexappletviewer!app/m", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public Config(@OriginalArg(0) String name) {
		this.name = name;
	}
}
