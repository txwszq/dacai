package com

import org.apache.commons.httpclient.params.HttpParams
import org.apache.http.Consts
import org.apache.http.HttpResponse
import org.apache.http.client.CookieStore
import org.apache.http.client.HttpClient
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.protocol.HttpClientContext
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

/**
 * Created by michael on 11/12/2016.
 */
class HttpUtil {

    def static get(url, cookieStore) {
        HttpClient client
        if (cookieStore) {
            client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        } else {
            client = HttpClientBuilder.create().build()
        }
        final HttpGet request = new HttpGet(url)
        request.setHeader("Referer", "${url}/home.php?mod=space&do=home");
        request.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:50.0) Gecko/20100101 Firefox/50.0");

        def response = client.execute(request)
        def entity = response.getEntity()
        String responseString = EntityUtils.toString(entity, "UTF-8");
        return responseString
    }

    def static post(url, params, cookieStore) {
        HttpClient httpclient
        if (cookieStore) {
            httpclient = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        } else {
            httpclient = HttpClients.createDefault();
        }
        HttpClientContext context = HttpClientContext.create();
        HttpPost httpost = new HttpPost(url);
        httpost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        def response = httpclient.execute(httpost, context);
        def entity = response.getEntity()
        String responseString = EntityUtils.toString(entity, "UTF-8");
        println responseString
        cookieStore = context.getCookieStore()
        return cookieStore
    }
}
