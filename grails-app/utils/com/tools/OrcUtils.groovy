package com.tools

import com.mashape.unirest.http.Unirest
import org.apache.commons.lang.StringUtils

import java.security.MessageDigest

/**
 * Created by zhiqiang.zhao on 2016/10/8.
 */
class OrcUtils {

    static def orc(String username, String password, byte[] stream) {
//        def resp = Unirest.post("http://upload.chaojiying.net/Upload/Processing.php")
//                .header('Content-Type', 'multipart/form-data')
//                .field('user', username)
//                .field('pass', password)
//                .field('softid', 891064)
//                .field('codetype', 1104)
//                .field('userfile', stream)
//                .asJson()
        def resp = ChaoJiYing.PostPic(username, password, '891064', '1104', '4', '0', 'test', stream)
        StringUtils.substringBefore(StringUtils.substringAfter(resp.toString(), "\"pic_str\":\""), "\",\"")
    }

}
