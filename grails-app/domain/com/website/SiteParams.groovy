package com.website

class SiteParams {

    String code
    String value

    static belongsTo = [Topic]

    static constraints = {

    }
    static mapping = {
        table('t_web_site_params')
        code column: 's_code'
        value column: 's_value'
    }
}
