package com.learninggrails

class Post {

    static belongsTo = [user: SecUser]

    String title
    String body

    static constraints = {
        title blank: false
        body blank: false
    }

    static mapping = {
        version false
        body type: 'text'
    }
}
