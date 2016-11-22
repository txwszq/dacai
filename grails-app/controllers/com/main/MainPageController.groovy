package com.main

import com.emum.RoleTypes
import com.website.SiteParams
import com.website.Topic
import com.website.WebSite
import grails.plugin.springsecurity.annotation.Secured

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Secured([RoleTypes.Constants.SUPER_ADMIN])
class MainPageController extends AbstractController{


    def index() {
        println "mainPage"
       render(view: "/index")
    }

    def save() {

        SiteParams siteParams = new SiteParams(code:'mod', value:'logging')
        SiteParams siteParams2 = new SiteParams(code:'action', value:'login')
        SiteParams siteParams3 = new SiteParams(code:'infloat', value: 'yes')
        SiteParams siteParams4 = new SiteParams(code:'handlekey', value:'login')
        SiteParams siteParams5 = new SiteParams(code:'inajax', value:'1')
        SiteParams siteParams6 = new SiteParams(code:'ajaxtarget', value:'fwin_content_login')
        Topic topic = new Topic(name:'preLogin').addToSiteParams(siteParams)
                        .addToSiteParams(siteParams2).addToSiteParams(siteParams3)
                        .addToSiteParams(siteParams4).addToSiteParams(siteParams5)
                        .addToSiteParams(siteParams6).save()
        WebSite webSite = new WebSite(code:'zhongzhuan', name:'中赚网').addToTopics(topic).save()
        render status:HttpServletResponse.SC_OK
    }
}
