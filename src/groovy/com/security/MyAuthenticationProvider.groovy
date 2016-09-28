package com.security

import com.account.User
import com.tools.EncryptUtil
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException

/**
 * Created by zhiqiang.zhao on 2016/8/17.
 */
class MyAuthenticationProvider implements AuthenticationProvider{

    /**
     * Authenticates the application user and returns a populated
     * Authentication object if successful.
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    Authentication authenticate(Authentication auth) throws AuthenticationException {

        String userName = (auth as UsernamePasswordAuthenticationToken).getPrincipal(),
            password = (auth as UsernamePasswordAuthenticationToken).getCredentials()
        User user = getUserByUserNameAndPassword(userName?.trim(), password)

        if(!user){
            throw new BadCredentialsException("用户名或密码错误")
        }

        if(!user.enabled){
            throw new BadCredentialsException("该账号已禁用，请联系管理员")
        }
        def authorities = getUserAuthorities(user)
        return new UsernamePasswordAuthenticationToken(user, auth.credentials, authorities)
    }

    private def getUserByUserNameAndPassword = { username, password ->
        if (!username || !password) {
            return  null
        }
        def encodePassword = EncryptUtil.encode(username+password)
        User.withTransaction {
            User user = User.findByUsernameAndPassword(username, encodePassword)
            return user
        }
    }

    private def getUserAuthorities = { User user ->
        User.withTransaction {
            user.getAuthorities()
        }

    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}