package com.dacai

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

/**
 * Created by zhiqiang.zhao on 2016/10/8.
 */
@Integration
@Rollback
class SendRequestServiceTest extends Specification {

    def sendRequestService = new SendRequestService()

    def 'test get request'() {
        when:
        sendRequestService.get('http://www.baidu.com')
        then:
        noExceptionThrown()
    }
}
