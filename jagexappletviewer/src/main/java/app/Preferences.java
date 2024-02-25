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
	private static Hashtable prefs = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "b", descriptor = "Ljava/io/File;")
	private static File preferencesFile = new File(new File(System.getProperty("user.home")), "jagexappletviewer.preferences");

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "a", descriptor = "(Ljava/lang/String;I)Ljava/lang/String;")
	public static String get(@OriginalArg(0) String key) {
		return (String) prefs.get(key);
	}

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;)V")
	public static void set(@OriginalArg(0) String value, @OriginalArg(2) String key) {
		prefs.put(key, value);
	}

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "a", descriptor = "(B)V")
	public static void save() {
		@Pc(3) PrintStream stream = null;
		try {
			stream = new PrintStream(new FileOutputStream(preferencesFile));
			@Pc(14) Enumeration local14 = prefs.keys();
			while (local14.hasMoreElements()) {
				@Pc(21) String local21 = (String) local14.nextElement();
				@Pc(26) String local26 = (String) prefs.get(local21);
				stream.println(local21 + "=" + local26);
			}
		} catch (@Pc(53) IOException ex) {
			ex.printStackTrace();
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/ca", name = "b", descriptor = "(B)V")
	public static void load() {
		@Pc(3) BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(preferencesFile));
			while (reader.ready()) {
				@Pc(21) String line = reader.readLine();
				@Pc(25) int separatorIndex = line.indexOf("=");
				if (separatorIndex >= 0) {
					prefs.put(line.substring(0, separatorIndex), line.substring(separatorIndex + 1));
				}
			}
		} catch (@Pc(52) IOException ignored) {
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (@Pc(66) IOException ignored) {
				}
			}
		}
	}
}
