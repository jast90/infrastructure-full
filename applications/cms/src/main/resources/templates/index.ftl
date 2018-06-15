<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CMS</title>
    <link rel="stylesheet"
          href="${requestContext.getContextPath()}/webjars/font-awesome/5.0.13/web-fonts-with-css/css/fontawesome-all.min.css">
</head>
<body>
    <#list page.getContent() as post>
    <p>${post.postTitle}</p>
    <p>${post.createdTime?datetime}</p>
    <p>${post.postContent}</p>
    </#list>
    <@pagination modelName="page" url="${requestContext.getContextPath()}/post/page"></@pagination>
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
</body>
</html>