<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link rel="stylesheet" href="/webjars/font-awesome/5.0.13/web-fonts-with-css/css/fontawesome-all.min.css">

<body>
    <#if Session.accountId?exists>
    欢迎用户${Session.username}<a href="${requestContext.getContextPath()}/account/logout">退出</a>
    <#else >
        <form id="linkedin" action="${'/signin/linkedin'}" method="POST">

            <a href="javascript:void(0);" onclick="document.getElementById('linkedin').submit();">
                <i class="fab fa-linkedin-in fa-3x"></i>
            </a>
        </form>

        <form id="github" action="${'/signin/github'}" method="POST">
            <a href="javascript:void(0);" onclick="document.getElementById('github').submit();">
                <i class="fab fa-github fa-3x"></i>
            </a>
        </form>
    </#if>

</body>
</html>