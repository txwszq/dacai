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
    Integer shoutingStatus
    Integer leaveMsgStatus
    Integer sendMsgStatus

    static constraints = {
        maxId nullable: true
        currentId nullable: true
    }

    static mapping = {
        shoutingStatus defaultValue: 1
        leaveMsgStatus defaultValue: 1
        sendMsgStatus defaultValue: 1
    }

}
