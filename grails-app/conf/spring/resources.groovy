
// Place your Spring DSL code here
beans = {
    myAuthenticationProvider(com.security.MyAuthenticationProvider)
    myAuthenticationFailureHandler(com.security.MyAuthenticationFailureHandler)
    myAuthenticationSuccessHandler(com.security.MyAuthenticationSuccessHandler)
    authenticationProcessingFilter(com.security.MyAuthonticationFilter) {
        authenticationManager = ref("authenticationManager")
        authenticationSuccessHandler = ref('myAuthenticationSuccessHandler')
        authenticationFailureHandler = ref('myAuthenticationFailureHandler')
    }
}
