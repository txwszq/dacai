package com.multhread

import com.dacai.DiscuzService
import com.website.Discuz

import java.util.concurrent.ThreadPoolExecutor

/**
 * Created by michael on 17/12/2016.
 */
class Shouting implements Runnable {

    DiscuzService discuzService

    Discuz discuz

    public Shouting(DiscuzService discuzService, Discuz discuz) {
        this.discuzService = discuzService
        this.discuz = discuz
    }

    @Override
    void run() {
        while (discuz.currentId <= 1000) {
            discuzService.shouting(discuz)
        }
    }
}
