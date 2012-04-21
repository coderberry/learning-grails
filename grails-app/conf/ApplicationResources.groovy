modules = {

    bootstrap {
        resource 'css/bootstrap.min.css'
        resource 'css/bootstrap-responsive.min.css'
        resource 'js/bootstrap.min.js'
    }

    core {
        dependsOn 'jquery'
        dependsOn 'bootstrap'

        resource 'css/style.css'
    }
}