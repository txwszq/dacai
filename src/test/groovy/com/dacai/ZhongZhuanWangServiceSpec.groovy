package com.dacai

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ZhongZhuanWangService)
@Mock(SendRequestService)
class ZhongZhuanWangServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        when:
        service.login('txwszq', '19881013.zzq')
        then:
        noExceptionThrown()
    }
}
