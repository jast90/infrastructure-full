<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login </title>
</head>
<link rel="stylesheet" href="/webjars/font-awesome/5.0.13/web-fonts-with-css/css/fontawesome-all.min.css">

<body>
<form action="${'/login'}" method="POST">
    username:<input type="text" name="username">
    password:<input type="password" name="password">
    <button type="submit">登入</button>
</form>
<a href="${'/login/wechat'}">
    <i class="fab fa-weixin fa-3x"></i>
</a>
<a href="${'/login/github'}">
    <i class="fab fa-github fa-3x"></i>
</a>
</body>
</html>