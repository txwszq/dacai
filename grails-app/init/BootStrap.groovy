import com.DiscuzShoutingStatus
import com.multhread.Shouting
import com.website.Discuz

class BootStrap {

    def discuzService

    def init = { servletContext ->
        def discuzs = Discuz.findAllByShoutingStatus(DiscuzShoutingStatus.NORMAL)
        discuzs.each {discuz ->
            Shouting s = new Shouting(discuzService, discuz)
            Thread thread = new Thread(s)
            thread.start()
        }
    }
    def destroy = {
    }
}
