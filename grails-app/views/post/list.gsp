<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name='layout' content='main'/>
    <r:require modules="core"/>
    <title></title>
</head>

<body>

<div class="row">
    <div class="span9">

        <g:render template="post" collection="${postInstanceList}" var="postInstance"/>

    </div>

    <div class="span3">
        FOO
    </div>
</div>

</body>
</html>