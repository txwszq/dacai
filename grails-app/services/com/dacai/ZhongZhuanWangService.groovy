package com.dacai

import com.mashape.unirest.http.Unirest
import com.mashape.unirest.request.GetRequest
import com.tools.OrcUtils
import com.website.WebSite
import grails.transaction.Transactional
import org.apache.commons.lang.StringUtils
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.protocol.HttpClientContext
import org.apache.http.impl.client.BasicCookieStore
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.protocol.BasicHttpContext
import org.apache.http.protocol.HttpContext
import org.apache.http.util.EntityUtils
import org.apache.tomcat.util.http.fileupload.FileUtils
import org.springframework.util.FileCopyUtils

@Transactional
class ZhongZhuanWangService {

    def sendRequestService
    def login(String username, String password) {
        def cookieStore = new BasicCookieStore();
        Unirest.setHttpClient(HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build());

//        WebSite.findByCode


//        String html = Unirest.get("http://www.you85.cn/member.php")
//                            .queryString("mod","logging")
//                            .queryString("action", "login")
//                            .queryString("infloat", "yes")
//                            .queryString("handlekey", "login")
//                            .queryString("inajax", "1")
//                            .queryString("ajaxtarget", "fwin_content_login").asString().body
//        def formhash = StringUtils.substringBefore(StringUtils.substringAfter(html, "<input type=\"hidden\" name=\"formhash\" value=\""), "\" />")
//        def loginhash = StringUtils.substringBefore(StringUtils.substringAfter(html, "main_messaqge_"), "\">")
//        def sechash = StringUtils.substringBefore(StringUtils.substringAfter(html, "<input name=\"sechash\" type=\"hidden\" value=\""), "\" />")
//        def idhash = cookieStore.cookies.get(3).value
//        def resp2 = Unirest.get("http://www.you85.cn/misc.php?mod=seccode&action=update&idhash=SA${idhash}0&inajax=1&ajaxtarget=seccode_SA${idhash}0")
//                    .header('Referer', 'http://www.you85.cn/')
//                    .asString()
//        def vcodeUrl = resp2.body.replace('" class="vm" alt="" />]]></root>', '').split('src="')[1]
//        def vcodeImage = Unirest.get("http://www.you85.cn/${vcodeUrl}")
//                    .header('Referer', 'http://www.you85.cn/')
//                    .asBinary()
//        def imageBytes = vcodeImage.body.getBytes()
//
//        def vcode = OrcUtils.orc('txwszq', '19881013asd', imageBytes)
//        def afterLogin = Unirest.post("http://www.you85.cn/member.php")
//                .header('Referer', 'http://www.you85.cn/')
//                .queryString("mod", "logging")
//                .queryString("action", "login")
//                .queryString("loginsubmit", "yes")
//                .queryString("handlekey", "login")
//                .queryString("loginhash", loginhash)
//                .field("formhash", formhash)
//                .field("referer", "http://www.you85.cn/member.php")
//                .field("loginfield", "username")
//                .field("username", username)
//                .field("password", password)
//                .field("questionid", 0)
//                .field("answer", "")
//                .field("sechash", sechash)
//                .field("seccodeverify", vcode)
//                .field("loginsubmit", "true").asString().body
//
//
//        File file = new File("d:/filename.txt");
//
//        // if file doesnt exists, then create it
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//
//        FileWriter fw = new FileWriter(file.getAbsoluteFile());
//        BufferedWriter bw = new BufferedWriter(fw);
//        bw.write(cookieStore.toString());
//        bw.close();
//
//        System.out.println("Done");
    }



}
