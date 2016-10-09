package com.dacai

import com.mashape.unirest.http.Unirest
import com.mashape.unirest.request.GetRequest
import com.tools.OrcUtils
import grails.transaction.Transactional
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.protocol.HttpClientContext
import org.apache.http.impl.client.BasicCookieStore
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.protocol.BasicHttpContext
import org.apache.http.protocol.HttpContext
import org.apache.http.util.EntityUtils

@Transactional
class ZhongZhuanWangService {

    def sendRequestService
    def login(String username, String password) {
        def cookieStore = new BasicCookieStore();
//        HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
//        HttpGet request = new HttpGet("http://www.you85.cn/member.php?mod=logging&action=login&infloat=yes&handlekey=login&inajax=1&ajaxtarget=fwin_content_login");
//        def response = client.execute(request);
//
//        def idhash = cookieStore.cookies.get(3).value
//        request = new HttpGet("http://www.you85.cn/misc.php?mod=seccode&action=update&idhash=SA${idhash}0&inajax=1&ajaxtarget=seccode_SA${idhash}0");
//        response = client.execute(request);
//
//       // localContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
//        def resp2 =  EntityUtils.toString(response.getEntity())
//        def vcodeUrl = resp2.replace('" class="vm" alt="" />]]></root>', '').split('src="')[1]
//        request = new HttpGet("http://www.you85.cn/${vcodeUrl}");
//        request.setHeader('Referer', 'http://www.you85.cn/')
//        response = client.execute(request);
//        println EntityUtils.toString(response.getEntity())
        Unirest.setHttpClient(HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build());
        Unirest.get("http://www.you85.cn/member.php")
                            .queryString("mod","logging")
                            .queryString("action", "login")
                            .queryString("infloat", "yes")
                            .queryString("handlekey", "login")
                            .queryString("inajax", "1")
                            .queryString("ajaxtarget", "fwin_content_login").asString()

        def idhash = cookieStore.cookies.get(3).value
        def resp2 = Unirest.get("http://www.you85.cn/misc.php?mod=seccode&action=update&idhash=SA${idhash}0&inajax=1&ajaxtarget=seccode_SA${idhash}0")
                    .header('Referer', 'http://www.you85.cn/')
                    .asString()
        def vcodeUrl = resp2.body.replace('" class="vm" alt="" />]]></root>', '').split('src="')[1]
        def vcode = Unirest.get("http://www.you85.cn/${vcodeUrl}")
                    .header('Referer', 'http://www.you85.cn/')
                    .asBinary()
        def imageBytes = vcode.body.getBytes()

        OrcUtils.orc('txwszq', '19881013asd', imageBytes)
        println vcode.status
        println vcode.body
    }



}
