<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>cms</title>
    <link rel="stylesheet" href="/webjars/font-awesome/5.0.13/web-fonts-with-css/css/fontawesome-all.min.css">
</head>
<body>
<#if Session.accountId?exists>
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