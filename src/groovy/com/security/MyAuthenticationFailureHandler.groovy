package com.security

import groovy.json.JsonBuilder
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by zhiqiang.zhao on 2016/8/19.
 */
class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        def status = HttpServletResponse.SC_UNAUTHORIZED
        def builder = new JsonBuilder()
        builder.error {
            errorID (status)
            errorMessage (exception.message)
        }

        if (exception.message.isInteger()) {
            builder.content.error.errorID = HttpServletResponse.SC_FORBIDDEN
        }
        def username = request.getParameter('username')
        request.setAttribute('errorMsg', exception.message)
        request.getRequestDispatcher("/login").forward(request, response)
    }
}
