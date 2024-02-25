package app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sun.security.pkcs.PKCS7;
import sun.security.pkcs.SignerInfo;

@OriginalClass("jagexappletviewer!app/u")
public final class JarLoader {

	@OriginalMember(owner = "jagexappletviewer!app/u", name = "a", descriptor = "Ljava/util/Hashtable;")
	private Hashtable cache = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/u", name = "b", descriptor = "Ljava/util/Hashtable;")
	private Hashtable aHashtable10 = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/u", name = "c", descriptor = "Ljava/util/Hashtable;")
	private Hashtable aHashtable11 = new Hashtable();

	@OriginalMember(owner = "jagexappletviewer!app/u", name = "d", descriptor = "Lsun/security/pkcs/PKCS7;")
	private PKCS7 signature;

	@OriginalMember(owner = "jagexappletviewer!app/u", name = "e", descriptor = "[B")
	private byte[] aByteArray2;

	@OriginalMember(owner = "jagexappletviewer!app/u", name = "<init>", descriptor = "([B)V")
	public JarLoader(@OriginalArg(0) byte[] src) throws IOException {
		@Pc(26) ZipInputStream local26 = new ZipInputStream(new ByteArrayInputStream(src));
		@Pc(29) byte[] local29 = new byte[1000];
		while (true) {
			while (true) {
				@Pc(32) ZipEntry local32 = local26.getNextEntry();
				if (local32 == null) {
					return;
				}
				@Pc(39) String local39 = local32.getName();
				@Pc(43) ByteArrayOutputStream local43 = new ByteArrayOutputStream();
				while (true) {
					@Pc(49) int local49 = local26.read(local29, 0, 1000);
					if (local49 == -1) {
						@Pc(65) byte[] local65 = local43.toByteArray();
						if (!local39.equals("META-INF/manifest.mf") && !local39.equals("META-INF/zigbert.sf")) {
							if (local39.equals("META-INF/zigbert.rsa")) {
								this.signature = new PKCS7(local65);
							} else {
								this.cache.put(local39, local65);
							}
							break;
						}
						@Pc(95) int local95 = 0;
						@Pc(98) int[] local98 = new int[1000];
						@Pc(100) int local100;
						for (local100 = 0; local100 < local65.length - 5; local100++) {
							if (local65[local100] == 78 && local65[local100 + 1] == 97 && local65[local100 + 2] == 109 && local65[local100 + 3] == 101 && local65[local100 + 4] == 58) {
								local98[local95++] = local100;
							}
						}
						for (local100 = 0; local100 < local95; local100++) {
							@Pc(170) JarLoader_Class1 local170 = new JarLoader_Class1();
							@Pc(174) int local174 = local98[local100];
							@Pc(187) int local187;
							if (local100 + 1 < local95) {
								local187 = local98[local100 + 1] - 1;
							} else {
								local187 = local65.length;
							}
							local170.aByteArray1 = new byte[local187 - local174];
							System.arraycopy(local65, local174, local170.aByteArray1, 0, local187 - local174);
							@Pc(210) int local210 = 0;
							for (@Pc(212) int local212 = 0; local212 < local170.aByteArray1.length; local212++) {
								if (local170.aByteArray1[local212] == 10 || local170.aByteArray1[local212] == 13) {
									@Pc(245) String local245 = (new String(local170.aByteArray1, local210, local212 - local210)).trim();
									if (local245.startsWith("Name: ")) {
										local170.aString4 = local245.substring(6);
									}
									if (local245.startsWith("MD5-Digest: ")) {
										local170.aString5 = local245.substring(12);
									}
									if (local245.startsWith("SHA1-Digest: ")) {
										local170.aString6 = local245.substring(13);
									}
									local210 = local212 + 1;
								}
							}
							if (local39.equalsIgnoreCase("META-INF/manifest.mf")) {
								this.aHashtable10.put(local170.aString4, local170);
							}
							if (local39.equalsIgnoreCase("META-INF/zigbert.sf")) {
								this.aHashtable11.put(local170.aString4, local170);
							}
						}
						if (local39.equalsIgnoreCase("META-INF/zigbert.sf")) {
							this.aByteArray2 = local65;
						}
						break;
					}
					local43.write(local29, 0, local49);
				}
			}
		}
	}

	@OriginalMember(owner = "jagexappletviewer!app/u", name = "a", descriptor = "(ILjava/lang/String;)[B")
	public byte[] read(@OriginalArg(1) String name, boolean verify) {
		try {
			@Pc(8) byte[] src = (byte[]) this.cache.remove(name);
			if (src == null) {
				return null;
			}

			if (!verify) {
				return src;
			}

			@Pc(19) JarLoader_Class1 local19 = (JarLoader_Class1) this.aHashtable10.get(name);
			if (local19 == null) {
				return null;
			}

			@Pc(30) JarLoader_Class1 local30 = (JarLoader_Class1) this.aHashtable11.get(name);
			if (local30 == null) {
				return null;
			}

			@Pc(38) MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(src);
			@Pc(46) byte[] md5Digest = md5.digest();
			@Pc(58) String local58 = JarLoader_Class2.method43(md5Digest, (byte) -49);
			if (!local58.equals(local19.aString5)) {
				return null;
			}

			@Pc(68) MessageDigest sha = MessageDigest.getInstance("SHA");
			sha.reset();
			sha.update(src);
			@Pc(76) byte[] shaDigest = sha.digest();
			@Pc(80) String local80 = JarLoader_Class2.method43(shaDigest, (byte) -49);
			if (!local80.equals(local19.aString6)) {
				return null;
			}

			md5.reset();
			md5.update(local19.aByteArray1);
			md5Digest = md5.digest();
			local58 = JarLoader_Class2.method43(md5Digest, (byte) -49);
			if (!local58.equals(local30.aString5)) {
				return null;
			}

			sha.reset();
			sha.update(local19.aByteArray1);
			shaDigest = sha.digest();
			local80 = JarLoader_Class2.method43(shaDigest, (byte) -49);
			if (!local80.equals(local30.aString6)) {
				return null;
			}

			@Pc(135) SignerInfo[] local135 = this.signature.verify(this.aByteArray2);
			if (local135 == null || local135.length == 0) {
				return null;
			}

			@Pc(154) ArrayList local154 = local135[0].getCertificateChain(this.signature);
			@Pc(157) int local157 = local154.size();
			if (local157 < 2) {
				return null;
			}

			for (@Pc(164) int local164 = 0; local164 < local157; local164++) {
				@Pc(172) X509Certificate local172 = (X509Certificate) local154.get(local164);
				@Pc(176) String local176 = local172.getSubjectX500Principal().getName();
				@Pc(180) String local180 = local172.getSerialNumber().toString();
				@Pc(184) byte[] local184 = local172.getPublicKey().getEncoded();
				@Pc(188) String local188 = JarLoader_Class2.method43(local184, (byte) -49);

				if (local164 == 0) {
					@Pc(198) int local198 = local176.indexOf("CN=");
					if (local198 < 0) {
						return null;
					}

					@Pc(211) int local211 = local176.indexOf(",", local198);
					if (local211 < 0) {
						local211 = local176.length();
					}

					if (!local176.substring(local198 + 3, local211).equals("Jagex Ltd")) {
						return null;
					}

					@Pc(233) int local233 = local176.indexOf("O=");
					if (local233 < 0) {
						return null;
					}

					@Pc(242) int local242 = local176.indexOf(",", local233);
					if (local242 < 0) {
						local242 = local176.length();
					}

					if (!local176.substring(local233 + 2, local242).equals("Jagex Ltd")) {
						return null;
					}
				}

				if (local164 != local157 - 1) {
					@Pc(293) X509Certificate cert = (X509Certificate) local154.get(local164 + 1);
					try {
						local172.verify(cert.getPublicKey());
					} catch (@Pc(299) Exception local299) {
						return null;
					}
				} else if ((!local180.equals("10") || !local188.equals("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGuLknYK8L45FpZdt+je2R5qrxvtXt/m3ULH/RcHf7JplXtN0/MLjcIepojYGS/C5LkTWEIPLaSrq0/ObaiPIgxSGSCUeVoAkcpnm+sUwd/PGKblTSaaHxTJM6Qf591GR7Y0X3YGAdMR2k6dMPi/tuJiSzqP/l5ZDUtMLcUGCuWQIDAQAB")) && (!local180.equals("68316673031993696956121215362381360273") || !local188.equals("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArKDw+4BZ1JzHpM+doVlzCRBFDA0sbmjxbFtIaElZN/wLMxnCd3/MEC2VNBzm600JpxzSuMmXNgK3idQkXwbAzESUlI0CYm/rWt0RjSiaXISQEHoNvXRmL2o4oOLVVETrHQefB7pv7un9Tgsp9T6EoAHxnKv4HH6JpOih2HFlDaNRe+680iJgDblbnd+6/FFbC6+Ysuku6QToYofeK8jXTsFMZB7dz4dYukpPymgHHRydSsbVL5HMfHFyHMXAZ+sy/cmSXJTahcCbv1N9Kwn0jJ2RH5dqUsveCTakd9h7h1BE1T5uKWn7OUkmHgmlgHtALevoJ4XJ/mH9fuZ8lx3VnQIDAQAB"))) {
					return null;
				}
			}

			return src;
		} catch (@Pc(307) Exception ex) {
			ex.printStackTrace();
			DialogMessage.showError(AppletViewer.translate("err_get_file") + ":" + name + " [" + ex.toString() + "]");
			return null;
		}
	}
}
