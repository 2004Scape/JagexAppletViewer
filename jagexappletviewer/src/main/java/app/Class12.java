package app;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/r")
public final class Class12 {

	@OriginalMember(owner = "jagexappletviewer!app/r", name = "a", descriptor = "[C")
	private static char[] aCharArray1 = new char[64];

	@OriginalMember(owner = "jagexappletviewer!app/r", name = "b", descriptor = "[C")
	private static char[] aCharArray2;

	@OriginalMember(owner = "jagexappletviewer!app/r", name = "c", descriptor = "[I")
	private static int[] anIntArray3;

	static {
		@Pc(4) int local4;
		for (local4 = 0; local4 < 26; local4++) {
			aCharArray1[local4] = (char) (local4 + 65);
		}
		for (local4 = 26; local4 < 52; local4++) {
			aCharArray1[local4] = (char) (local4 + 71);
		}
		for (local4 = 52; local4 < 62; local4++) {
			aCharArray1[local4] = (char) (local4 + 48 - 52);
		}
		aCharArray1[63] = '/';
		aCharArray1[62] = '+';
		aCharArray2 = new char[64];
		for (local4 = 0; local4 < 26; local4++) {
			aCharArray2[local4] = (char) (local4 + 65);
		}
		for (local4 = 26; local4 < 52; local4++) {
			aCharArray2[local4] = (char) (local4 + 97 - 26);
		}
		for (local4 = 52; local4 < 62; local4++) {
			aCharArray2[local4] = (char) (local4 + 48 - 52);
		}
		aCharArray2[63] = '-';
		aCharArray2[62] = '*';
		anIntArray3 = new int[128];
		for (local4 = 0; local4 < anIntArray3.length; local4++) {
			anIntArray3[local4] = -1;
		}
		for (local4 = 65; local4 <= 90; local4++) {
			anIntArray3[local4] = local4 - 65;
		}
		for (local4 = 97; local4 <= 122; local4++) {
			anIntArray3[local4] = local4 + 26 - 97;
		}
		for (local4 = 48; local4 <= 57; local4++) {
			anIntArray3[local4] = local4 + 52 - 48;
		}
		anIntArray3[42] = anIntArray3[43] = 62;
		anIntArray3[45] = anIntArray3[47] = 63;
	}

	@OriginalMember(owner = "jagexappletviewer!app/r", name = "a", descriptor = "(III[B)Ljava/lang/String;")
	private static String method42(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) byte[] arg3) {
		@Pc(5) StringBuffer local5 = new StringBuffer();
		for (@Pc(7) int local7 = 0; local7 < arg2; local7 += 3) {
			@Pc(28) int local28 = arg3[local7] & 0xFF;
			local5.append(aCharArray1[local28 >>> 2]);
			if (arg2 - 1 > local7) {
				@Pc(49) int local49 = arg3[local7 + 1] & 0xFF;
				local5.append(aCharArray1[(local28 & 0x3) << 4 | local49 >>> 4]);
				if (local7 < arg2 - 2) {
					@Pc(80) int local80 = arg3[local7 + 2] & 0xFF;
					local5.append(aCharArray1[(local49 & 0xF) << 2 | local80 >>> 6]).append(aCharArray1[local80 & 0x3F]);
				} else {
					local5.append(aCharArray1[(local49 & 0xF) << 2]).append("=");
				}
			} else {
				local5.append(aCharArray1[(local28 & 0x3) << 4]).append("==");
			}
		}
		return local5.toString();
	}

	@OriginalMember(owner = "jagexappletviewer!app/r", name = "a", descriptor = "([BB)Ljava/lang/String;")
	public static String method43(@OriginalArg(0) byte[] arg0, @OriginalArg(1) byte arg1) {
		return method42(0, -53, arg0.length, arg0);
	}
}
