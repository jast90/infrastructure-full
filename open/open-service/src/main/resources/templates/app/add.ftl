<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加应用</title>
</head>
<body>
    <form action="${requestContext.getContextPath()}/open/app" method="post">
        <div class="form-group">
            <label for="domain">应用域名</label>
            <input type="text" class="form-control" name="domain" id="domain" placeholder="输入域名">
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
    </form>
</body>
</html>