<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name='layout' content='main'/>
    <r:require modules="core"/>
    <title>Add Post</title>
</head>

<body>

<div class="row">
    <div class="span9">

        ${postInstance.errors?.inspect()}

        <h2 class="header">Post to Learning Grails</h2>

        <g:form action="save" method="post" class="well">
            <div class="control-group">
                <label class="control-label">Title:</label>
                <div class="controls">
                    <g:textField name="title" value="${postInstance?.title}" class="input-xxlarge"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">Post Content:</label>
                <div class="controls">
                    <g:textArea name="body" rows="7" cols="50" class="input-xxlarge">Foo</g:textArea>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">Live Preview:</label>
                <div class="controls" id="live-preview">
                    FOO
                </div>
            </div>
            <div class="control-buttons">
                <g:submitButton name="submit" class="btn btn-large btn-primary" value="Submit Post" />
                <g:link action="list" class="btn btn-large">Cancel</g:link>
            </div>
        </g:form>

    </div>

    <div class="span3">
        foo
    </div>
</div>
</body>
</html>