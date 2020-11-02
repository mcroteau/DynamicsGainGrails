package vanilla

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"{ 
            controller = "resource"
            action = "home"
        }
		
        "500"(view:"/error")
        "404"(view:"/notFound")
    }
}
