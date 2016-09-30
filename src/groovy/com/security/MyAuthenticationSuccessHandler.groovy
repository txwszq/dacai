package com.security

import com.account.User
import com.tools.IpUtils
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * Created by zhiqiang.zhao on 2016/8/19.
 */
class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                 Authentication authentication) throws IOException, ServletException {
        User user = authentication.getPrincipal()
        User.withTransaction {
            User updateUser = User.get(user.id)
            updateUser.lastLoginTime = new Date()
            updateUser.lastLoginIP = IpUtils.getIpAddr(request)
            updateUser.save(flush: true, failOnError: true)
        }
        response.sendRedirect('/index')
    }

}
