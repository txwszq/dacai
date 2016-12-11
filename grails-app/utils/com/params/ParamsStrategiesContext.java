package com.params;

import java.util.List;

/**
 * Created by michael on 11/12/2016.
 */
public class ParamsStrategiesContext {

    private StrategiesParams strategiesParams;

    public ParamsStrategiesContext(StrategiesParams strategiesParams) {
        if (strategiesParams != null) {
            this.strategiesParams = strategiesParams;
        } else {
            this.strategiesParams = new DefaultParams();
        }
    }

    public ParamsStrategiesContext() {
        this(null);
    }

    public List getLoginParams(String url, String username, String password) {
        return strategiesParams.loginParams(url, username, password);
    }

    public List getLeaveMsgParams(String msg, String targetId, String formHash) {
        return strategiesParams.leaveMsgParams(msg, targetId, formHash);
    }

    public List getSignParams(String formHash) {
        return strategiesParams.signParams(formHash);
    }
}
