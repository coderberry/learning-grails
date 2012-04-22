<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <r:layoutResources/>
    <link href="${resource(dir: 'css', file: 'style.css')}" type="text/css" rel="stylesheet"
          media="screen, projection"/>
</head>

<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Learning Grails</a>

            <div class="nav-collapse">
                <ul class="nav pull-right">
                    <li <g:if test="${controllerName == 'post' && actionName == 'list'}">class="active"</g:if>>
                        <g:link controller="post" action="list">Home</g:link></li>
                    <li <g:if test="${controllerName == 'post' && actionName == 'create'}">class="active"</g:if>>
                        <g:link controller="post" action="create">Submit</g:link></li>
                    <sec:ifLoggedIn>
                        <li><g:link url="#"><sec:username/></g:link></li>
                        <li><g:link controller="logout">Logout</g:link></li>
                    </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                        <li <g:if test="${controllerName == 'user' && actionName == 'signup'}">class="active"</g:if>>
                            <g:link controller="user" action="signup">Signup</g:link></li>
                        <li <g:if test="${controllerName == 'login'}">class="active"</g:if>>
                            <g:link controller="login">Login</g:link></li>
                    </sec:ifNotLoggedIn>
                    <li><a href="#contact">Leaders</a></li>
                    <li><a href="#contact">Feed</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">
    <g:layoutBody/>
</div>

<r:layoutResources/>
</body>
</html>