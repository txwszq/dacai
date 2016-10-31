package com.dacai

import com.mashape.unirest.http.Unirest
import grails.transaction.Transactional
import org.apache.http.impl.client.BasicCookieStore
import org.apache.http.impl.client.HttpClients

import java.text.SimpleDateFormat

@Transactional
class BookSessionService {

    def bookSession(def date) {
        def cookieStore = new BasicCookieStore();
        Unirest.setHttpClient(HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build());
        def login = Unirest.post("http://www.vipabc.com/program/member/member_login_exe.asp")
                .header('Referer', 'http://www.vipabc.com/')
                .field('txt_login_account', '1')
                .field('pwd_login_password', '1')
                .asString()
        println login.body.toString()
        def book = Unirest.post("http://www.vipabc.com/Center/Reservation/SetReservation")
                .header('Referer', 'http://www.vipabc.com/Center/')
                .field('data', sevenDay(date).toString())
                .asString()
        println book.body.toString()

//        println sevenDay(date)
    }

    def sevenDay(String date) {
        def list = []
        def sevenDays = getSevenDays(date)
        for (def day : sevenDays) {
            def sessionMap = '{"SstNumber":"21","SessionTime":"'+day+'"}'
            list.add(sessionMap)
        }
        return list
    }

    def getSevenDays(String date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd 07:30:00")
        Calendar c = Calendar.getInstance()
        def list = []
        if (date) {
            SimpleDateFormat sf2 = new SimpleDateFormat("yyyy/MM/dd")
            println sf2.parse(date)
            c.setTime(sf2.parse(date))
        }
        for (int i = 0; i < 7; i++) {
            c.add(c.DATE, 1)
            if (c.get(Calendar.DAY_OF_WEEK)  != Calendar.MONDAY) {
                list.add(sf.format(c.getTime()))
            }
        }
        return list
    }
}
