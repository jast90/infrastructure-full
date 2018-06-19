<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CMS</title>
    <link rel="stylesheet"
          href="${requestContext.getContextPath()}/webjars/font-awesome/5.0.13/web-fonts-with-css/css/fontawesome-all.min.css">
    <link rel="stylesheet"
          href="${requestContext.getContextPath()}/webjars/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
    <#list page.getContent() as post>
    <p>${post.postTitle}</p>
    <p>${post.createdTime?datetime}</p>
    <p>${post.postContent}</p>
    </#list>
<div>
    <@pagination modelName="page" url="${requestContext.getContextPath()}/?page="></@pagination>
</div>

<div>
<#if Session.currentAccountId?exists>
    欢迎用户${Session.username}<a href="${requestContext.getContextPath()}/logout">退出</a>
<#else >
<a href="${'/login/wechat'}">
    <i class="fab fa-weixin fa-3x"></i>
</a>
<a href="${'/login/github'}">
    <i class="fab fa-github fa-3x"></i>
</a>
</#if>
</div>
<script src="/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="/webjars/popper.js/1.14.1/umd/popper.min.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</body>
</html>