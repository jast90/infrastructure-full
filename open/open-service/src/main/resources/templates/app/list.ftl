<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>应用列表</title>
</head>
<body>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">域名</th>
        <th scope="col">appId</th>
        <th scope="col">密钥</th>
    </tr>
    </thead>
    <tbody>
    <#list page.getContent() as app>
    <tr>
        <td>${app.domain}</td>
        <td>${app.appId}</td>
        <td>${app.appSecret}</td>
    </tr>
    </#list>
    </tbody>
</table>
<@pagination modelName="page" url="${requestContext.getContextPath()}/open/app/page/"></@pagination>
</body>
</html>