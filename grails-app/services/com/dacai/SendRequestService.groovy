package com.dacai

import com.mashape.unirest.http.Unirest
import grails.transaction.Transactional

@Transactional
class SendRequestService {


    def post(String username, String password, InputStream stream) {
        def resp = Unirest.post("http://upload.chaojiying.net/Upload/Processing.php")
                    .field('user', username)
                    .field('pass', password)
                    .field('softid', 1)
                    .field('codetype', 1004)
                    .field('len_min', 4)
                    .field('userfile', stream)
                    .asJson()
        println resp
    }

    def get(String url) {

    }
}
