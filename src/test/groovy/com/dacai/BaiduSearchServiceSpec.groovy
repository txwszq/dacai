package com.dacai

import grails.test.mixin.TestFor
import spock.lang.Specification

import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BaiduSearchService)
class BaiduSearchServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        when:
        Set<String> set = new HashSet<>()
//        Files.lines(Paths.get("/Users/michael/search/url.txt")).each {line->
//            set.add(line.replace("http://", "").split("/")[0]+"\r\n")
//        }
//        Path file = Paths.get("/Users/michael/search/url-result.txt");
//        Files.write(file, set, Charset.forName("UTF-8"));
        //service.baiduparser(service.getHtml("http://www.baidu.com/s?wd=中国"))
//        String[][] str = service.parseHTML("单机游戏 powered by discuz")
//        for(int i=0;i<str.length;i++) {
//
//            System.out.println("第"+(i+1)+"条结果：");
//            System.out.println("URL:"+str[i][0]);
//            System.out.println("标题:"+str[i][1]);
//            System.out.println("摘要:"+str[i][2]);
//        }
        //service.parseHTML(html)
//        service.getFromHash(null)
        then:
        noExceptionThrown()
    }



}
