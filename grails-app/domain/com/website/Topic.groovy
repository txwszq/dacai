package com.website

class Topic {

    String name

    static constraints = {
    }

    static hasMany = [siteParams: SiteParams]
    static belongsTo = [WebSite]

    static mapping = {
        table 't_topic'
        name column: 's_topic_name'
    }
}
