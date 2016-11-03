package com.dacai

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BookSessionService)
class BookSessionServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        when:
        service.bookSession('2016/11/03')
        then:
        noExceptionThrown()
    }

    void "test weekend"() {
        when:
        service.bookSessionWeekend('2016/11/05 08:30:00')
        then:
        noExceptionThrown()
    }
}
