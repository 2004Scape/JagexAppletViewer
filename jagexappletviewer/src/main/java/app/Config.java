package app;

import java.util.Hashtable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("jagexappletviewer!app/m")
public final class Config {

	@OriginalMember(owner = "jagexappletviewer!app/m", name = "a", descriptor = "Ljava/util/Hashtable;")
	public Hashtable aHashtable6 = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/m", name = "c", descriptor = "Ljava/util/Hashtable;")
	public Hashtable aHashtable7 = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/m", name = "d", descriptor = "Ljava/util/Hashtable;")
	public Hashtable aHashtable8 = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/m", name = "b", descriptor = "Ljava/lang/String;")
	public String aString9;

	@OriginalMember(owner = "jagexappletviewer!app/m", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public Config(@OriginalArg(0) String arg0) {
		this.aString9 = arg0;
	}
}
