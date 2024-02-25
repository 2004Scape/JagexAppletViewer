package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/ca")
public final class Preferences {

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "a", descriptor = "Ljava/util/Hashtable;")
	private static Hashtable aHashtable4 = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "b", descriptor = "Ljava/io/File;")
	private static File aFile2 = new File(new File(System.getProperty("user.home")), "jagexappletviewer.preferences");

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "a", descriptor = "(Ljava/lang/String;I)Ljava/lang/String;")
	public static String method25(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1) {
		if (arg1 != 1) {
			aHashtable4 = null;
		}
		return (String) aHashtable4.get(arg0);
	}

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;)V")
	public static void set(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2) {
		aHashtable4.put(arg2, arg0);
	}

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "a", descriptor = "(B)V")
	public static void save() {
		@Pc(3) PrintStream local3 = null;
		try {
			local3 = new PrintStream(new FileOutputStream(aFile2));
			@Pc(14) Enumeration local14 = aHashtable4.keys();
			while (local14.hasMoreElements()) {
				@Pc(21) String local21 = (String) local14.nextElement();
				@Pc(26) String local26 = (String) aHashtable4.get(local21);
				local3.println(local21 + "=" + local26);
			}
		} catch (@Pc(53) IOException local53) {
			local53.printStackTrace();
		} finally {
			if (local3 != null) {
				local3.close();
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "b", descriptor = "(B)V")
	public static void method28(@OriginalArg(0) byte arg0) {
		@Pc(3) BufferedReader local3 = null;
		if (arg0 <= 101) {
			return;
		}
		try {
			local3 = new BufferedReader(new FileReader(aFile2));
			while (local3.ready()) {
				@Pc(21) String local21 = local3.readLine();
				@Pc(25) int local25 = local21.indexOf("=");
				if (local25 >= 0) {
					aHashtable4.put(local21.substring(0, local25), local21.substring(local25 + 1));
				}
			}
		} catch (@Pc(52) IOException local52) {
		} finally {
			if (local3 != null) {
				try {
					local3.close();
				} catch (@Pc(66) IOException local66) {
				}
			}
		}
	}
}
