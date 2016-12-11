// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.account.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.account.UserRole'
grails.plugin.springsecurity.authority.className = 'com.account.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/index',          access: ['ROLE_SUPER_ADMIN']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]
grails.plugin.springsecurity.auth.loginFormUrl ='/login'
grails.plugin.springsecurity.auth.ajaxLoginFormUrl ='/login'
//grails.plugin.springsecurity.logout.filterProcessesUrl ='/logout'
//grails.plugin.springsecurity.logout.afterLogoutUrl ='/login'
grails.plugin.springsecurity.providerNames = ['myAuthenticationProvider',
                                              'anonymousAuthenticationProvider',
                                              'rememberMeAuthenticationProvider']
grails.plugin.springsecurity.adh.errorPage = '/denied'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/index'
