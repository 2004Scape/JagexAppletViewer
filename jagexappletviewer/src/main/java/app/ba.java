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

final class ba implements AppletStub, AppletContext {
   public final Image getImage(URL var1) {
      throw new UnsupportedOperationException();
   }

   public final void showStatus(String var1) {
      throw new UnsupportedOperationException();
   }

   public final URL getCodeBase() {
      try {
         return new URL(appletviewer.a("codebase", true));
      } catch (MalformedURLException var2) {
         throw new InvalidParameterException();
      }
   }

   public final void showDocument(URL var1) {
      if (appletviewer.i) {
         System.out.println("showdocument url:" + var1);
      }

      i.showurl(var1.toString(), (String)null);
   }

   public final Enumeration getApplets() {
      throw new UnsupportedOperationException();
   }

   public final void setStream(String var1, InputStream var2) throws IOException {
      throw new UnsupportedOperationException();
   }

   public ba() {
   }

   public final AppletContext getAppletContext() {
      return this;
   }

   public final void showDocument(URL var1, String var2) {
      if (appletviewer.i) {
         System.out.println("showdocument url:" + var1 + " target:" + var2);
      }

      i.showurl(var1.toString(), var2);
   }

   public final void appletResize(int var1, int var2) {
   }

   public final Applet getApplet(String var1) {
      throw new UnsupportedOperationException();
   }

   public final String getParameter(String var1) {
      String var2 = appletviewer.a((String)var1, 123);
      if (appletviewer.i && null == var2) {
         if ("force64mb".equals(var1)) {
            System.out.println("Returning false for force64mb");
            return "false";
         }

         System.out.println("Unavailable param:" + var1);
      }

      return var2;
   }

   public final Iterator getStreamKeys() {
      throw new UnsupportedOperationException();
   }

   public final URL getDocumentBase() {
      try {
         return new URL(appletviewer.a("codebase", true));
      } catch (MalformedURLException var2) {
         throw new InvalidParameterException();
      }
   }

   public final AudioClip getAudioClip(URL var1) {
      throw new UnsupportedOperationException();
   }

   public final boolean isActive() {
      return true;
   }

   public final InputStream getStream(String var1) {
      throw new UnsupportedOperationException();
   }
}
