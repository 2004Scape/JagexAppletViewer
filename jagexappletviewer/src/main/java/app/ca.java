package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;

public final class ca {
   private static Hashtable a = new Hashtable();
   private static File b = new File(new File(System.getProperty("user.home")), "jagexappletviewer.preferences");
   public static boolean c;

   static final String a(String var0, int var1) {
      if (var1 != 1) {
         a = (Hashtable)null;
      }

      return (String)a.get(var0);
   }

   public static final void a(String var0, int var1, String var2) {
      if (var1 < -121) {
         a.put(var2, var0);
      }
   }

   public static final void a(byte var0) {
      boolean var6 = c;
      PrintStream var1 = null;

      try {
         var1 = new PrintStream(new FileOutputStream(b));
         Enumeration var2 = a.keys();

         while(var2.hasMoreElements()) {
            String var3 = (String)var2.nextElement();
            String var4 = (String)a.get(var3);
            var1.println(var3 + "=" + var4);
            if (var6) {
               break;
            }
         }

         if (var0 <= 97) {
            b = (File)null;
         }
      } catch (IOException var9) {
         var9.printStackTrace();
      } finally {
         if (null != var1) {
            var1.close();
         }

      }

   }

   static final void b(byte var0) {
      boolean var6 = c;
      BufferedReader var1 = null;
      if (var0 > 101) {
         try {
            var1 = new BufferedReader(new FileReader(b));

            do {
               String var2;
               int var3;
               do {
                  if (!var1.ready()) {
                     return;
                  }

                  var2 = var1.readLine();
                  var3 = var2.indexOf("=");
               } while(0 > var3 && !var6);

               a.put(var2.substring(0, var3), var2.substring(1 + var3));
            } while(!var6);
         } catch (IOException var13) {
         } finally {
            if (var1 != null) {
               try {
                  var1.close();
               } catch (IOException var12) {
               }
            }

         }

      }
   }
}
