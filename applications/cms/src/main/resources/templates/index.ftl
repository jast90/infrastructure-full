<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CMS</title>
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

</body>
</html>