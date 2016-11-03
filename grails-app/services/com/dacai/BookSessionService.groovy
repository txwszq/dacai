package com.dacai

import com.mashape.unirest.http.Unirest
import grails.transaction.Transactional
import org.apache.http.impl.client.BasicCookieStore
import org.apache.http.impl.client.HttpClients

import java.text.SimpleDateFormat

@Transactional
class BookSessionService {

    def username = "1"
    def password = ""

    def bookSession(def date) {
        def cookieStore = new BasicCookieStore();
        Unirest.setHttpClient(HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build());
        def login = Unirest.post("http://www.vipabc.com/program/member/member_login_exe.asp")
                .header('Referer', 'http://www.vipabc.com/')
                .field('txt_login_account', username)
                .field('pwd_login_password', password)
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
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        Calendar c = Calendar.getInstance()
        def list = []
        if (date) {
            SimpleDateFormat sf2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
            println sf2.parse(date)
            c.setTime(sf2.parse(date))
        }
        for (int i = 0; i < 7; i++) {
            if (c.get(Calendar.DAY_OF_WEEK)  != Calendar.MONDAY) {
                if (c.get(Calendar.DAY_OF_WEEK)  == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK)  == Calendar.SUNDAY) {
                    for (int j = 0; j < 3; j++) {
                        list.add(sf.format(c.getTime()))
                        c.add(c.HOUR, 1)
                    }
                    c.add(c.HOUR, -3)
                } else {
                    list.add(sf.format(c.getTime()))
                }
            }

            c.add(c.DATE, 1)
        }
        return list
    }

    def bookSessionWeekend(def date) {
        def cookieStore = new BasicCookieStore();
        Unirest.setHttpClient(HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build());
        def login = Unirest.post("http://www.vipabc.com/program/member/member_login_exe.asp")
                .header('Referer', 'http://www.vipabc.com/')
                .field('txt_login_account', username)
                .field('pwd_login_password', password)
                .asString()
        println login.body.toString()
        def book = Unirest.post("http://www.vipabc.com/Center/Reservation/SetReservation")
                .header('Referer', 'http://www.vipabc.com/Center/')
                .field('data', weekend(date).toString())
                .asString()
        println book.body.toString()

//        println sevenDay(date)
    }

    def weekend(String date) {
        def list = []
        def fourSessions = getFourSessionTime(date)
        for (def day : fourSessions) {
            def sessionMap = '{"SstNumber":"21","SessionTime":"'+day+'"}'
            list.add(sessionMap)
        }
        return list
    }

    def getFourSessionTime(String date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        Calendar c = Calendar.getInstance()
        def list = []
        if (date) {
            SimpleDateFormat sf2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
            println sf2.parse(date)
            c.setTime(sf2.parse(date))
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                list.add(sf.format(c.getTime()))
                c.add(c.HOUR, 1)
            }
            c.add(c.HOUR, -3);
            c.add(c.DATE, 1)
        }
        return list
    }
}
