<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加应用</title>
</head>
<body>
    <form action="${requestContext.getContextPath()}/open/app" method="post">
        <div class="form-group">
            <label for="appId">应用ID</label>
            <input type="text" class="form-control" name="appId" id="appId" placeholder="输入域名">
        </div>
        <div class="form-group">
            <label for="appSecret">应用密钥</label>
            <input type="text" class="form-control" name="appSecret" id="appSecret" placeholder="输入域名">
        </div>
        <div class="form-group">
            <label for="domain">应用域名</label>
            <input type="text" class="form-control" name="domain" id="domain" placeholder="输入域名">
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
    </form>
</body>
</html>