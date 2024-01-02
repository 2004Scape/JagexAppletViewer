package app;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Enumeration;
import java.util.Iterator;

final class GameAppletStub implements AppletStub, AppletContext {
	public final Image getImage(URL var1) {
		throw new UnsupportedOperationException();
	}

	public final void showStatus(String var1) {
		throw new UnsupportedOperationException();
	}

	public final URL getCodeBase() {
		try {
			return new URL(appletviewer.getProperty("codebase", true));
		} catch (MalformedURLException var2) {
			throw new InvalidParameterException();
		}
	}

	public final void showDocument(URL var1) {
		if (appletviewer.debug) {
			System.out.println("showdocument url:" + var1);
		}

		UrlThread.showurl(var1.toString(), (String) null);
	}

	public final Enumeration getApplets() {
		throw new UnsupportedOperationException();
	}

	public final void setStream(String var1, InputStream var2) throws IOException {
		throw new UnsupportedOperationException();
	}

	public GameAppletStub() {
	}

	public final AppletContext getAppletContext() {
		return this;
	}

	public final void showDocument(URL url, String target) {
		if (appletviewer.debug) {
			System.out.println("showdocument url:" + url + " target:" + target);
		}

		UrlThread.showurl(url.toString(), target);
	}

	public final void appletResize(int var1, int var2) {
	}

	public final Applet getApplet(String var1) {
		throw new UnsupportedOperationException();
	}

	public final String getParameter(String name) {
		String value = appletviewer.getParam((String) name, 123);

		if (appletviewer.debug && value == null) {
			System.out.println("Unavailable param:" + name);
		}

		return value;
	}

	public final Iterator getStreamKeys() {
		throw new UnsupportedOperationException();
	}

	public final URL getDocumentBase() {
		try {
			return new URL(appletviewer.getProperty("codebase", true));
		} catch (MalformedURLException ignored) {
			throw new InvalidParameterException();
		}
	}

	public final AudioClip getAudioClip(URL url) {
		throw new UnsupportedOperationException();
	}

	public final boolean isActive() {
		return true;
	}

	public final InputStream getStream(String url) {
		throw new UnsupportedOperationException();
	}
}
