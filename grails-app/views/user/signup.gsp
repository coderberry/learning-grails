<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Signup</title>
</head>
<body>

<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>

<g:form action="save">
    <g:textField value="${user?.username}" name="username" />
    <g:textField value="${user?.email}" name="email" />
    <g:passwordField value="" name="password" />
    <g:submitButton name="submit" value="Create Account" />
</g:form>

</body>
</html>