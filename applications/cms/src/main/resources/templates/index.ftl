<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CMS</title>
</head>
<body>
<div class="row">
    <#list page.getContent() as post>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <a href="/post/${post.id}">
                        <p>${post.postTitle}</p>
                        <p>${post.createdTime?datetime}</p>
                        <p>${post.postContent}</p>
                    </a>
                </div>

            </div>
        </div>
    </#list>
</div>
<div>
    <@pagination modelName="page" url="${requestContext.getContextPath()}/?page="></@pagination>
</div>

</body>
</html>