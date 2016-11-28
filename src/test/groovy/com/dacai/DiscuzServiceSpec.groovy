package com.dacai

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(DiscuzService)
class DiscuzServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        when:
        service.sendMsg(3287615, null)
//        service.getFromHash(null)
        then:
        noExceptionThrown()
    }
}
