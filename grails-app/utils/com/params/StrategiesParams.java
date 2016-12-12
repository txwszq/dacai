package com.params;



import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by michael on 11/12/2016.
 */
public interface StrategiesParams {

    List<NameValuePair> loginParams(String url, String username, String password);
    List<NameValuePair> leaveMsgParams(String msg, String targetId, String formHash);
    List<NameValuePair> signParams(String formHash);
    List<NameValuePair> updateInfo(String formhash, String siteInfo, String bio);
}
