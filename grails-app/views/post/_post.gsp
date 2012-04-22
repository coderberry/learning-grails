<div class="post clearfix">
    <div class="avatar">
        <avatar:gravatar email="${postInstance?.user?.email?.encodeAsHTML()}" size="54" />
    </div>
    <div class="entry">
        <div class="post-title">
            <g:link action="show" id="${postInstance?.id}">${postInstance?.title?.encodeAsHTML()}</g:link>
        </div>
        <div class="post-body">
            <markdown:renderHtml text="${postInstance?.body}" />
        </div>
        <div class="post-metadata">
            <!-- at 17:50 -->
            by <a href="/users/${postInstance?.user?.username?.encodeAsHTML()}" class="userlink">${postInstance?.user?.username}</a> |
            <a href="#">Post a comment</a>
        </div>
    </div>
</div>