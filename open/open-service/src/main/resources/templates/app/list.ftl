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
        <th scope="col">操作</th>
    </tr>
    </thead>
    <tbody>
    <#list page.getContent() as app>
    <tr>
        <td>${app.domain}</td>
        <td>${app.appId}</td>
        <td>${app.appSecret}</td>
        <td><a href="javascript:void(0);" class="addSocialRef" data-app-id="${app.appId}">社交配置</a></td>
    </tr>
    </#list>
    </tbody>
</table>
<@pagination modelName="page" url="${requestContext.getContextPath()}/open/app/page/"></@pagination>
<div id="addSocialRefDiv" style="display: none">
    <div class="box-body">
        <div class="form-group row">
            <label class="col-sm-2 control-label">appId</label>
            <div class="col-sm-10">
                <input type="text" name="appId" readonly class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 control-label">社交网站</label>
            <div class="col-sm-10">
                <select class="form-control" name="social" required>
                    <option value="">请选择社交网站</option>
                    <#list socials as social>
                        <option value="${social.name()}">${social.desc}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label">appId</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="socialAppId" placeholder="社交appId" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label">appSecret</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="socialAppSecret" placeholder="社交密钥" required>
            </div>
        </div>
    </div>
</div>
</body>
<javascript>
    <script type="text/javascript">
        $(function () {
            $(".addSocialRef").on("click", function () {
                $(this).myModal({
                    "id": "addSocialRefModel",
                    "title": "社交配置",
                    "formName": "addSocialRefForm",
                    "formAction": "/app/socialRef",
                    "bodyHtml": $("#addSocialRefDiv").html()
                });
                var appId = $(this).data("app-id");
                $("form[name='addSocialRefForm']").find("input[name='appId']").val(appId);
            });
        });
    </script>
</javascript>
</html>