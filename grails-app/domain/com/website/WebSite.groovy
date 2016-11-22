package com.website

class WebSite {

    String name
    String url
    String code
    Date dateCreated
    Date lastUpdated

    static hasMany = [topics:Topic]
    static constraints = {
    }

    static mapping = {
        table('t_web_site')
        name column: 's_name'
        url column: 's_url'
    }
}
