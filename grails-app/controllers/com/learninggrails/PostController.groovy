package com.learninggrails

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured

class PostController {

    def springSecurityService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [postInstanceList: Post.list(params), postInstanceTotal: Post.count()]
    }

    @Secured(['ROLE_USER'])
    def create() {
        [postInstance: new Post(params)]
    }

    @Secured(['ROLE_USER'])
    def save() {
        def postInstance = new Post(params)
        postInstance.user = (SecUser)springSecurityService.currentUser
        if (!postInstance.save(flush: true)) {
            render(view: "create", model: [postInstance: postInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'post.label', default: 'Post'), postInstance.id])
        redirect(action: "show", id: postInstance.id)
    }

    def show() {
        def postInstance = Post.get(params.id)
        if (!postInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])
            redirect(action: "list")
            return
        }

        [postInstance: postInstance]
    }

    @Secured(['ROLE_USER', 'ROLE_ADMIN'])
    def edit() {
        def postInstance = Post.get(params.id)
        if (!postInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])
            redirect(action: "list")
            return
        }

        [postInstance: postInstance]
    }

    @Secured(['ROLE_USER', 'ROLE_ADMIN'])
    def update() {
        def postInstance = Post.get(params.id)
        if (!postInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])
            redirect(action: "list")
            return
        }

        postInstance.properties = params

        if (!postInstance.save(flush: true)) {
            render(view: "edit", model: [postInstance: postInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'post.label', default: 'Post'), postInstance.id])
        redirect(action: "show", id: postInstance.id)
    }

    @Secured(['ROLE_ADMIN'])
    def delete() {
        def postInstance = Post.get(params.id)
        if (!postInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])
            redirect(action: "list")
            return
        }

        try {
            postInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'post.label', default: 'Post'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'post.label', default: 'Post'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
