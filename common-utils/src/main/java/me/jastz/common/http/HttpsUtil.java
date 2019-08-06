package me.jastz.common.http;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by zhiwen on 2017/2/20.
 */
public class HttpsUtil {

    public static <T> T getForObject(Class<T> responseType, String uri, Object... param) {
        HttpsURLConnection conn = null;
        try {
            URL url = new URL(null, uri, new sun.net.www.protocol.https.Handler());
            conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(HttpsUtil.getSSLSocketFactory());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (null == conn) {
            return null;
        }
        Object object = null;
        try {
            InputStream is = conn.getInputStream();
            System.out.println(is);
            ObjectInputStream obs = new ObjectInputStream(is);//如何将一个inputStream转化成一个对象
            object = obs.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (object == null) {
            return null;
        }
        return (T) object;

    }

    public static SSLSocketFactory getSSLSocketFactory() {
        TrustManager[] tm = {new X509TrustManager() {

            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};
        try {
            SSLContext context = SSLContext.getInstance("SSL");
            context.init(null, tm, new SecureRandom());
            return context.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }
}
