package com.learninggrails

class UserController {

    def springSecurityService

    def signup() {
        def user = new SecUser(
                username: 'foo'
        )
        [user: user]
    }

    def save() {
        def user = new SecUser()
        user.properties = params
        if (!user.hasErrors() && user.save(flush: true)) {
            springSecurityService.reauthenticate(user.username, user.password)
            flash.message = "Your account has been created. Thank you for joining us!"
            redirect controller: 'home', action: 'index'
        }
        else {
            flash.message = "Please correct the errors below"
            flash.next()
            render view: 'signup', model: [user: user]
        }
    }
}
