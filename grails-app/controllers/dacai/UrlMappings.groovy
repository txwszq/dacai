package dacai

class UrlMappings {

    static mappings = {

        "500"(view:'/error')
        "404"(view:'/notFound')

        "/denied"(view:'/denied')
        "/login"(view:'/login')
        "/index"(controller:"mainPage", action: "index")
        "/denied"(view: '/error')

        "/users"(controller: "users", action: "index", method: "GET")
    }
}
