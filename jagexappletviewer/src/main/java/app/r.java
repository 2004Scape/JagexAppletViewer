package app;

final class r {
	private static char[] a = new char[64];
	private static char[] b;
	private static int[] c;

	private static final String a(int var0, int var1, int var2, byte[] var3) {
		boolean var9 = ca.c;
		StringBuffer var4 = new StringBuffer();
		int var5 = var0;
		if (var1 != -53) {
			c = (int[]) null;
		}

		while (~var5 > ~(var0 + var2)) {
			label27:
			{
				int var6 = var3[var5] & 255;
				var4.append(a[var6 >>> 1472792290]);
				if (-1 + var2 > var5) {
					label24:
					{
						int var7 = var3[1 + var5] & 255;
						var4.append(a[var6 << 1749888004 & 48 | var7 >>> -1174889148]);
						if (~var5 > ~(var2 + -2)) {
							int var8 = 255 & var3[2 + var5];
							var4.append(a[(15 & var7) << 644175042 | var8 >>> -983423418]).append(a[63 & var8]);
							if (!var9) {
								break label24;
							}
						}

						var4.append(a[(15 & var7) << 1709910690]).append("=");
					}

					if (!var9) {
						break label27;
					}
				}

				var4.append(a[(var6 & 3) << 2093988612]).append("==");
			}

			var5 += 3;
			if (var9) {
				break;
			}
		}

		return var4.toString();
	}

	static final String a(byte[] var0, byte var1) {
		return var1 != -49 ? (String) null : a(0, -53, var0.length, var0);
	}

	static {
		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			a[var0] = (char) (var0 + 65);
		}

		for (var0 = 26; ~var0 > -53; ++var0) {
			a[var0] = (char) (71 - -var0);
		}

		for (var0 = 52; ~var0 > -63; ++var0) {
			a[var0] = (char) (48 + (var0 - 52));
		}

		a[63] = '/';
		a[62] = '+';
		b = new char[64];

		for (var0 = 0; ~var0 > -27; ++var0) {
			b[var0] = (char) (65 + var0);
		}

		for (var0 = 26; -53 < ~var0; ++var0) {
			b[var0] = (char) (97 + (var0 - 26));
		}

		for (var0 = 52; -63 < ~var0; ++var0) {
			b[var0] = (char) (48 - (-var0 + 52));
		}

		b[63] = '-';
		b[62] = '*';
		c = new int[128];

		for (var0 = 0; ~c.length < ~var0; ++var0) {
			c[var0] = -1;
		}

		for (var0 = 65; ~var0 >= -91; ++var0) {
			c[var0] = -65 + var0;
		}

		for (var0 = 97; -123 <= ~var0; ++var0) {
			c[var0] = -97 + (var0 - -26);
		}

		for (var0 = 48; -58 <= ~var0; ++var0) {
			c[var0] = var0 - 48 - -52;
		}

		c[42] = c[43] = 62;
		c[45] = c[47] = 63;
	}
}
