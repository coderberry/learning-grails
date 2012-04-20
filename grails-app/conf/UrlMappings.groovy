class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/signup/$action?"(controller: "user", action: "signup")
        "/login/$action?"(controller: "login")
        "/logout/$action?"(controller: "logout")

        "/"(controller: "home", action: "index")
		"500"(view:'/error')
	}
}
