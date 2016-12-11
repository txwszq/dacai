package com.params;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 11/12/2016.
 */
public class DefaultParams implements StrategiesParams {

    @Override
    public List<NameValuePair> loginParams(String url, String username, String password) {
        List params = new ArrayList();
        params.add(new BasicNameValuePair("fastloginfield", "username"));
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("referer", url+"/home.php"));
        params.add(new BasicNameValuePair("quickforward", "yes"));
        params.add(new BasicNameValuePair("handlekey", "Is"));
        return params;
    }

    @Override
    public List<NameValuePair> leaveMsgParams(String msg, String targetId, String formHash) {
        List params = new ArrayList();
        params.add(new BasicNameValuePair("message", msg));
        params.add(new BasicNameValuePair("referer", "home.php?mod=space&uid=&do=wall"));
        params.add(new BasicNameValuePair("id", targetId));
        params.add(new BasicNameValuePair("idtype", "uid"));
        params.add(new BasicNameValuePair("handlekey", "qcwall_"+targetId));
        params.add(new BasicNameValuePair("commentsubmit", "true"));
        params.add(new BasicNameValuePair("quickcomment", "true"));
        params.add(new BasicNameValuePair("formhash", formHash));
        return params;
    }

    @Override
    public List<NameValuePair> signParams(String formhash) {
        List params = new ArrayList();
        params.add(new BasicNameValuePair("formhash", formhash));
        params.add(new BasicNameValuePair("qdxq", "ch"));
        params.add(new BasicNameValuePair("qdmode", "1"));
        params.add(new BasicNameValuePair("todaysay", "无聊寂寞孤单冷。。。。。"));
        params.add(new BasicNameValuePair("fastreply", "0"));
        return params;
    }
}
