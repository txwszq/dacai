package com.website

import org.grails.datastore.mapping.query.Query

class Discuz {

    String url
    String username
    String password
    Integer loginType //1是登录方式
    Integer maxId
    Integer currentId
    Integer sendType //1是留言 2是发送消息
    Integer accountStatus

    static constraints = {
        maxId nullable: true
        currentId nullable: true
    }

}
