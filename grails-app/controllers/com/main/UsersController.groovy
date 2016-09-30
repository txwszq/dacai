package com.main

import com.emum.RoleTypes
import grails.plugin.springsecurity.annotation.Secured

@Secured([RoleTypes.Constants.SUPER_ADMIN])
class UsersController extends AbstractController{

    def index() {
        println "test"
        buildSuccessResponse()
    }
}
