package com.dacai

import com.HttpUtil
import com.SerializeUtil
import com.params.ParamsStrategiesContext
import com.website.Discuz
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
//        service.shouting(1265518, null, "http://bbs.xs163.net", "txwszq", "19881013asd")
//        service.visitMainPage("http://bbs.xs163.net")
//        service.login("http://bbs.xs163.net", "txwszq", "19881013asd")
//        service.getFromHash(null)
        println service.getUid(null, "http://bbs.xs163.net", "txwszq", "19881013asd")
        then:
        noExceptionThrown()
    }

    void "test serials" () {
        when:
//        ParamsStrategiesContext context = new ParamsStrategiesContext()
//        def params = context.getLoginParams("http://bbs.exrpg.com", "txws114", "tt998aa11")
//        HttpUtil.post("http://bbs.exrpg.com", "txws114", params)
        def cookieStore = SerializeUtil.readCookies("http://bbs.exrpg.com", "txws114")
        HttpUtil.get("http://bbs.exrpg.com", cookieStore)
        then:
        noExceptionThrown()
    }
}
