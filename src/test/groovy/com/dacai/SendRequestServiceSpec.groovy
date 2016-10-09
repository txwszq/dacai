package com.dacai

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SendRequestService)
class SendRequestServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test get request"() {
        when:
        service.get("http://www.you85.cn/member.php?mod=logging&action=login&infloat=yes&handlekey=login&inajax=1&ajaxtarget=fwin_content_login")
        then:
        noExceptionThrown()
    }

    void "test post request"() {

    }
}
