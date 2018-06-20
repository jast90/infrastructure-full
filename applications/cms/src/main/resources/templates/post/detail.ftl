<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Post Detail</title>
</head>
<body>
<#include "../common/common.ftl"/>
<p>${post.postTitle}</p>
<p><i class="far fa-clock"></i>${post.createdTime?datetime}</p>
<p>${post.postContent}</p>
</body>
</html>