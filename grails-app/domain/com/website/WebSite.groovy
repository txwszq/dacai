package com.website

class WebSite {

    String name
    String url
    Login login
    List<Topic> topics
    Date dateCreated
    Date lastUpdated

    static hasMany = [topics:Topic]

    static constraints = {
    }

    static mapping = {
        table('t_web_site')
        name column: 's_name'
        url column: 's_url'
        login column: 'n_login_id'
        topics column: 'n_topic_id'
    }
}
