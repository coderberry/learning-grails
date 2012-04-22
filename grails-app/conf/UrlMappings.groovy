class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/signup"(controller: "user", action: "signup")
        "/login/$action?"(controller: "login")
        "/logout/$action?"(controller: "logout")

        "/"(controller: "post", action: "list")
		"500"(view:'/error')
	}
}
