package com.kavakci.btcturk.client;

import com.kavakci.btcturk.data.AuthenticationResult;
import com.kavakci.btcturk.settings.Constants;
import org.apache.http.NameValuePair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class Common {
    /**
     *
     * @param sURL
     * @param authenticationResult
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    protected static HttpURLConnection makeGetRequest(String sURL, AuthenticationResult authenticationResult)
            throws MalformedURLException, IOException {
        URL url = new URL(sURL);

        HttpURLConnection request = (HttpURLConnection) url.openConnection();

        request.setRequestMethod("GET");
        request.setRequestProperty("X-PCK", Constants.API_PUBLIC_KEY);
        request.setRequestProperty("X-Stamp", authenticationResult.getTimestamp());
        request.setRequestProperty("X-Signature", authenticationResult.getAuthenticationSignature());
        request.setRequestProperty("User-Agent", "Mozilla/5.0");
        request.setReadTimeout(60 * 1000);
        request.setConnectTimeout(60 * 1000);
        request.setUseCaches(false);
        request.setDoOutput(true);
        request.setDoInput(true);
        request.connect();

        return request;
    }

    /**
     *
     * @param sURL
     * @param authenticationResult
     * @param params
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    protected static HttpURLConnection makePostRequest(String sURL,
                                                       AuthenticationResult authenticationResult,
                                                       List<NameValuePair> params)
            throws MalformedURLException, IOException {
        URL url = new URL(sURL);

        HttpURLConnection request = (HttpURLConnection) url.openConnection();

        request.setRequestMethod("POST");
        request.setRequestProperty("X-PCK", Constants.API_PUBLIC_KEY);
        request.setRequestProperty("X-Stamp", authenticationResult.getTimestamp());
        request.setRequestProperty("X-Signature", authenticationResult.getAuthenticationSignature());
        request.setRequestProperty("User-Agent", "Mozilla/5.0");
        request.setReadTimeout(60 * 1000);
        request.setConnectTimeout(60 * 1000);
        request.setUseCaches(false);
        request.setDoOutput(true);
        request.setDoInput(true);

        OutputStream os = request.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        writer.write(getQuery(params));
        writer.flush();
        writer.close();
        os.close();

        request.connect();

        return request;
    }

    /**
     *
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
