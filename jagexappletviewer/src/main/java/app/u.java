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
import sun.security.pkcs.PKCS7;
import sun.security.pkcs.SignerInfo;

final class u {
   private Hashtable a;
   private Hashtable b;
   private Hashtable c;
   private PKCS7 d;
   private byte[] e;

   final byte[] a(int var1, String var2) {
      boolean var25 = ca.c;

      try {
         byte[] var3 = (byte[])((byte[])this.a.remove(var2));
         if (null == var3) {
            return null;
         } else {
            h var4 = (h)this.b.get(var2);
            if (null == var4) {
               return null;
            } else {
               h var5 = (h)this.c.get(var2);
               if (null == var5) {
                  return null;
               } else {
                  MessageDigest var6 = MessageDigest.getInstance("MD5");
                  var6.reset();
                  var6.update(var3);
                  byte[] var7 = var6.digest();
                  int var9 = -39 % ((-25 - var1) / 42);
                  String var8 = r.a(var7, (byte)-49);
                  if (!var8.equals(var4.b)) {
                     return null;
                  } else {
                     MessageDigest var28 = MessageDigest.getInstance("SHA");
                     var28.reset();
                     var28.update(var3);
                     byte[] var10 = var28.digest();
                     String var11 = r.a(var10, (byte)-49);
                     if (!var11.equals(var4.d)) {
                        return null;
                     } else {
                        var6.reset();
                        var6.update(var4.c);
                        var7 = var6.digest();
                        var8 = r.a(var7, (byte)-49);
                        if (!var8.equals(var5.b)) {
                           return null;
                        } else {
                           var28.reset();
                           var28.update(var4.c);
                           var10 = var28.digest();
                           var11 = r.a(var10, (byte)-49);
                           if (!var11.equals(var5.d)) {
                              return null;
                           } else {
                              SignerInfo[] var12 = this.d.verify(this.e);
                              if (null != var12 && -1 != ~var12.length) {
                                 ArrayList var13 = var12[0].getCertificateChain(this.d);
                                 int var14 = var13.size();
                                 if (2 > var14) {
                                    return null;
                                 } else {
                                    int var15 = 0;

                                    while(var15 < var14) {
                                       X509Certificate var16 = (X509Certificate)var13.get(var15);
                                       String var17 = var16.getSubjectX500Principal().getName();
                                       String var18 = var16.getSerialNumber().toString();
                                       byte[] var19 = var16.getPublicKey().getEncoded();
                                       String var20 = r.a(var19, (byte)-49);
                                       if (-1 == ~var15) {
                                          int var21 = var17.indexOf("CN=");
                                          if (~var21 > -1) {
                                             return null;
                                          }

                                          int var22 = var17.indexOf(",", var21);
                                          if (0 > var22) {
                                             var22 = var17.length();
                                          }

                                          if (!var17.substring(var21 - -3, var22).equals("Jagex Ltd")) {
                                             return null;
                                          }

                                          int var23 = var17.indexOf("O=");
                                          if (var23 < 0) {
                                             return null;
                                          }

                                          int var24 = var17.indexOf(",", var23);
                                          if (var24 < 0) {
                                             var24 = var17.length();
                                          }

                                          if (!var17.substring(2 + var23, var24).equals("Jagex Ltd")) {
                                             return null;
                                          }
                                       }

                                       if (~var15 == ~(var14 - 1)) {
                                          if ((!var18.equals("10") || !var20.equals("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGuLknYK8L45FpZdt+je2R5qrxvtXt/m3ULH/RcHf7JplXtN0/MLjcIepojYGS/C5LkTWEIPLaSrq0/ObaiPIgxSGSCUeVoAkcpnm+sUwd/PGKblTSaaHxTJM6Qf591GR7Y0X3YGAdMR2k6dMPi/tuJiSzqP/l5ZDUtMLcUGCuWQIDAQAB")) && (!var18.equals("68316673031993696956121215362381360273") || !var20.equals("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArKDw+4BZ1JzHpM+doVlzCRBFDA0sbmjxbFtIaElZN/wLMxnCd3/MEC2VNBzm600JpxzSuMmXNgK3idQkXwbAzESUlI0CYm/rWt0RjSiaXISQEHoNvXRmL2o4oOLVVETrHQefB7pv7un9Tgsp9T6EoAHxnKv4HH6JpOih2HFlDaNRe+680iJgDblbnd+6/FFbC6+Ysuku6QToYofeK8jXTsFMZB7dz4dYukpPymgHHRydSsbVL5HMfHFyHMXAZ+sy/cmSXJTahcCbv1N9Kwn0jJ2RH5dqUsveCTakd9h7h1BE1T5uKWn7OUkmHgmlgHtALevoJ4XJ/mH9fuZ8lx3VnQIDAQAB"))) {
                                             return null;
                                          }
                                       } else {
                                          X509Certificate var29 = (X509Certificate)var13.get(var15 - -1);

                                          try {
                                             var16.verify(var29.getPublicKey());
                                          } catch (Exception var26) {
                                             return null;
                                          }
                                       }

                                       ++var15;
                                       if (var25) {
                                          break;
                                       }
                                    }

                                    return var3;
                                 }
                              } else {
                                 return null;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      } catch (Exception var27) {
         var27.printStackTrace();
         app.e.a(500, appletviewer.c(1555, "err_get_file") + ":" + var2 + " [" + var27.toString() + "]");
         return null;
      }
   }

   u(byte[] var1) throws IOException {
      super();
      boolean var17 = ca.c;
      this.a = new Hashtable();
      this.b = new Hashtable();
      this.c = new Hashtable();
      ZipInputStream var2 = new ZipInputStream(new ByteArrayInputStream(var1));
      byte[] var3 = new byte[1000];

      do {
         ZipEntry var4 = var2.getNextEntry();
         if (var4 == null && !var17) {
            break;
         }

         String var5 = var4.getName();
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();

         do {
            int var7 = var2.read(var3, 0, 1000);
            if (~var7 == 0 && !var17) {
               break;
            }

            var6.write(var3, 0, var7);
         } while(!var17);

         byte[] var18 = var6.toByteArray();
         if (!var5.equals("META-INF/manifest.mf") && !var5.equals("META-INF/zigbert.sf")) {
            if (var5.equals("META-INF/zigbert.rsa")) {
               this.d = new PKCS7(var18);
               if (!var17) {
                  continue;
               }
            }

            this.a.put(var5, var18);
            if (!var17) {
               continue;
            }
         }

         int var8 = 0;
         int[] var9 = new int[1000];
         int var10 = 0;

         while(var10 < var18.length - 5) {
            if (-79 == ~var18[var10] && -98 == ~var18[1 + var10] && -110 == ~var18[var10 - -2] && -102 == ~var18[var10 - -3] && -59 == ~var18[4 + var10]) {
               var9[var8++] = var10;
            }

            ++var10;
            if (var17) {
               break;
            }
         }

         var10 = 0;

         while(~var10 > ~var8) {
            h var11;
            int var12;
            int var13;
            label84: {
               var11 = new h();
               var12 = var9[var10];
               if (1 + var10 < var8) {
                  var13 = -1 + var9[1 + var10];
                  if (!var17) {
                     break label84;
                  }
               }

               var13 = var18.length;
            }

            var11.c = new byte[var13 - var12];
            System.arraycopy(var18, var12, var11.c, 0, -var12 + var13);
            int var14 = 0;
            int var15 = 0;

            while(~var15 > ~var11.c.length) {
               if (10 == var11.c[var15] || var11.c[var15] == 13) {
                  String var16 = (new String(var11.c, var14, var15 - var14)).trim();
                  if (var16.startsWith("Name: ")) {
                     var11.a = var16.substring(6);
                  }

                  if (var16.startsWith("MD5-Digest: ")) {
                     var11.b = var16.substring(12);
                  }

                  if (var16.startsWith("SHA1-Digest: ")) {
                     var11.d = var16.substring(13);
                  }

                  var14 = 1 + var15;
               }

               ++var15;
               if (var17) {
                  break;
               }
            }

            if (var5.equalsIgnoreCase("META-INF/manifest.mf")) {
               this.b.put(var11.a, var11);
            }

            if (var5.equalsIgnoreCase("META-INF/zigbert.sf")) {
               this.c.put(var11.a, var11);
            }

            ++var10;
            if (var17) {
               break;
            }
         }

         if (var5.equalsIgnoreCase("META-INF/zigbert.sf")) {
            this.e = var18;
         }
      } while(!var17);

   }
}
