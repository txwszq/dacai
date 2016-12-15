package dacai

import com.HttpUtil
import com.SerializeUtil
import com.dacai.DiscuzService
import com.params.ParamsStrategiesContext
import com.website.Discuz
import org.apache.http.client.CookieStore

class SendMsgJobJob {

    DiscuzService discuzService

    static triggers = {
      simple repeatInterval: 1000000 // execute job once in 5 seconds
    }

    //收听url
    //http://bbs.pcgta.cc/home.php?mod=spacecp&ac=follow&op=add&hash=f4d3f296&fuid=10080010&infloat=yes&handlekey=followmod&inajax=1&ajaxtarget=fwin_content_followmod


    def execute() {
        // execute job
        Discuz.findAll().each {discuz ->
//            println discuz.url
            discuzService.shouting(discuz)
//            println discuz.url
//            def cookieStore = SerializeUtil.readCookies(discuz.url, discuz.username)
//            HttpUtil.get(discuz.url, cookieStore)
        }
//
//        println Discuz.count()

        //def discuz = Discuz.findById(5)
//        ParamsStrategiesContext context = new ParamsStrategiesContext()
//        def params = context.getLoginParams(discuz.url, discuz.username, discuz.password)
//        def cookieStore = HttpUtil.post("${discuz.url}/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1", params)
//        SerializeUtil.writeCookies(discuz.url, discuz.username, cookieStore)
        //def cookieStore = SerializeUtil.readCookies(discuz.url, discuz.username)
        //HttpUtil.get(discuz.url, cookieStore)
    }
}
