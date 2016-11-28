package com.dacai

import com.mashape.unirest.http.Unirest
import grails.transaction.Transactional
import org.apache.commons.httpclient.HttpState
import org.apache.commons.httpclient.methods.GetMethod
import org.apache.commons.httpclient.params.HttpMethodParams

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

@Transactional
class DiscuzService {

    static final String LOGON_SITE = "www.cbrx.com";

    static final int LOGON_PORT = 80;


    def login() {
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);
        PostMethod post = new PostMethod("http://www.cbrx.com/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1");
        NameValuePair username = new NameValuePair("username", "txwszq");
        NameValuePair password = new NameValuePair("password", "6e764438782bcb966bbede02812f9670");
        NameValuePair referer = new NameValuePair("referer", "http://www.cbrx.com/home.php");
        NameValuePair questionid = new NameValuePair("quickforward", "yes");
        NameValuePair answer = new NameValuePair("handlekey", "Is");
        NameValuePair cookietime = new NameValuePair("cookietime", "2592000");
        NameValuePair[] params = [ username, password, referer, questionid, answer, cookietime];
        post.setRequestBody(params);
            client.executeMethod(post);
        String responseString = new String(
                    post.getResponseBodyAsString().getBytes(
                            "utf-8"));
        System.out.println(responseString);
        Cookie[] cookies = client.getState().getCookies();
        client.getState().addCookies(cookies);
        post.releaseConnection();

        return cookies
//
//        def afterLogin = Unirest.post("http://www.cbrx.com/member.php")
//                .header('Referer', 'http://www.cbrx.com/home.php')
//                .header('Host', 'www.cbrx.com')
//                .header('Accept', 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8')
//                .header('User-Agent', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:50.0) Gecko/20100101 Firefox/50.0')
//                .header('Accept-Encoding', 'gzip, deflate')
//                .header('Accept-Language', 'en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4')
//                .header('Cache-Control', 'max-age=0')
//                .header('Connection', 'keep-alive')
//                .header('Content-Type', 'application/x-www-form-urlencoded')
//                .header('Content-Length', '87')
//                .header('Origin', 'http://www.cbrx.com')
//                .queryString("mod", "logging")
//                .queryString("action", "login")
//                .queryString("loginsubmit", "yes")
//                .queryString("infloat", "yes")
//                .queryString("lssubmit", "yes")
//                .queryString("inajax", "1")
//                .field("username", "txwszq")
//                .field("password", "6e764438782bcb966bbede02812f9670")
//                .field("quickforward", "yes")
//                .field("handlekey", "Is").asString().body
//        def vcode = OrcUtils.orc('txwszq', '19881013asd', imageBytes)
//        println afterLogin
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

    def msg = "你好";
    def sendMsg(targetId, cookies) {
        if (!cookies) {
            cookies = login()
        }
//        cookies = visitSpace(cookies, targetId)
        while (targetId > 1286940) {
            HttpClient client = new HttpClient();
            client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);
            PostMethod post = new PostMethod("http://www.cbrx.com/home.php?mod=spacecp&ac=comment&inajax=1");
            post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "gbk")
            HttpState initialState = new HttpState();
            initialState.addCookies(cookies);
            client.setState(initialState);
            NameValuePair message = new NameValuePair("message", msg);
            NameValuePair referer = new NameValuePair("referer", "home.php?mod=space&uid=&do=wall");
            NameValuePair id = new NameValuePair("id", targetId.toString());
            NameValuePair idtype = new NameValuePair("idtype", "uid");
            NameValuePair handlekey = new NameValuePair("handlekey", "qcwall_${targetId}");
            NameValuePair commentsubmit = new NameValuePair("commentsubmit", "true");
            NameValuePair quickcomment = new NameValuePair("quickcomment", "true");
            NameValuePair formhash = new NameValuePair("formhash", getFormHash(cookies));
            NameValuePair[] params = [message, referer, id, idtype, handlekey, commentsubmit, quickcomment, formhash];
            post.setRequestBody(params);
            post.setRequestHeader("Referer", "http://www.cbrx.com/home.php?mod=space&uid=${targetId}&do=wall&from=space")
//        post.setRequestHeader("Host", "www.cbrx.com")
            client.executeMethod(post);
            String responseString = new String(
                    post.getResponseBodyAsString().getBytes(
                            "utf-8"));
            println responseString
            if(responseString.indexOf("操作成功") > 0) {
                Thread.sleep(13000)
            }
            post.releaseConnection();
            targetId--;
        }
    }

    def visitSpace(cookies, targetId) {
        if (!cookies) {
            cookies = login()
        }
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);
        GetMethod get = new GetMethod("http://www.cbrx.com/home.php?mod=space&uid=${targetId}&do=wall&from=space");
        HttpState initialState = new HttpState();
        initialState.addCookies(cookies);
        client.setState(initialState);
        client.executeMethod(get);
        cookies = client.getState().getCookies();
        client.getState().addCookies(cookies);
        get.releaseConnection();

        return cookies

    }

    def getFormHash(cookies) {
        if (!cookies) {
            cookies = login()
        }
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);
        GetMethod get = new GetMethod("http://www.cbrx.com/home.php");
        HttpState initialState = new HttpState();
        initialState.addCookies(cookies);
        client.setState(initialState);
        client.executeMethod(get);
        def responseString = new String(
                get.getResponseBodyAsString().getBytes(
                        "utf-8"));
        return responseString.split("formhash=")[1].substring(0, 8)
    }
}
