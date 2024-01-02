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

final class JarLoader {
	private Hashtable<String, byte[]> cache = new Hashtable<String, byte[]>();

	final byte[] read(int flowObfuscator, String name) {
		try {
			return this.cache.remove(name);
		} catch (Exception ex) {
			ex.printStackTrace();
			app.DialogMessage.showError(500, appletviewer.c(1555, "err_get_file") + ":" + name + " [" + ex.toString() + "]");
			return null;
		}
	}

	JarLoader(byte[] src) throws IOException {
		boolean dialogVisible = Preferences.dialogVisible;
		ZipInputStream zip = new ZipInputStream(new ByteArrayInputStream(src));
		byte[] chunk = new byte[1000];

		do {
			ZipEntry next = zip.getNextEntry();
			if (next == null && !dialogVisible) {
				break;
			}

			String name = next.getName();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();

			do {
				int read = zip.read(chunk, 0, 1000);
				if (~read == 0 && !dialogVisible) {
					break;
				}

				stream.write(chunk, 0, read);
			} while (!dialogVisible);

			this.cache.put(name, stream.toByteArray());
		} while (!dialogVisible);
	}
}
