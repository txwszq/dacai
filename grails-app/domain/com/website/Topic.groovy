package com.website

class Topic {

    String topicName
    String topicUrl
    Map<String, String> params

    static constraints = {
    }

    static belongsTo = [webSite: WebSite]

    static mapping = {
        table 't_topic'
        topicName column: 's_topic_name'
        topicUrl column: 's_topic_url'
        params joinTable: 't_topic_params'
    }
}
