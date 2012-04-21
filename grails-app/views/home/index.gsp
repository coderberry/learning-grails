<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name='layout' content='main'/>
  <title></title>
</head>
<body>

<sec:ifLoggedIn>
    Logged in as <sec:username/>
    <g:link controller="logout">Logout</g:link>
</sec:ifLoggedIn>
<sec:ifNotLoggedIn>
    <g:link controller="login">Login</g:link>
</sec:ifNotLoggedIn>

</body>
</html>