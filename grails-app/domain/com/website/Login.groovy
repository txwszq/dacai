package com.website

class Login {

    String loginUrl
    Map<String, String> params

    static constraints = {
    }

    static belongsTo = [webSite: WebSite]

    static mapping = {
        table 't_login'
        loginUrl column: 's_login_url'
        params joinTable: 't_login_params'
    }
}
