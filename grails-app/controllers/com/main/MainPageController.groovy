package com.main

import com.emum.RoleTypes
import grails.plugin.springsecurity.annotation.Secured

@Secured([RoleTypes.Constants.SUPER_ADMIN])
class MainPageController extends AbstractController{


    def index() {
        println "mainPage"
       render(view: "mainPage")
    }
}
