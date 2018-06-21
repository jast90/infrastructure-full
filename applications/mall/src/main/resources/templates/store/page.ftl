<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Store</title>
</head>
<body>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">名称</th>
        <th scope="col">地址</th>
        <th scope="col">操作</th>
    </tr>
    </thead>
    <tbody>
<#list page.getContent() as store>
<tr>
    <td>${store?index}</td>
    <td>${store.storeName}</td>
    <td>${store.address}</td>
    <td><a href="javascript:void(0);" onclick="showAddSku(this,'${store.storeName}','${store.storeId}')">添加sku</a></td>
</tr>
</#list>
    </tbody>
</table>
<div id="addStoreSkuForm" style="display: none">
    <div class="box-body">
        <input type="hidden" name="storeId">
        <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 control-label">点位名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="storeName" placeholder="点位名称">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 control-label">SKU</label>
            <div class="col-sm-10">
                <select name="productId" ></select>
            </div>
        </div>
    </div>
</div>
<javascript>
    <script type="text/javascript">
        function showAddSku(element, storeName, storeId) {
            var id = "addStoreSkuModal";
            var formName = "addStoreSkuForm";
            var formAction = "${requestContext.getContextPath()}/";
            $(element).myModal({
                "id": id,
                "title": "添加点位SKU",
                "formName": formName,
                "formAction": formAction,
                "bodyHtml": $("#addStoreSkuForm").html()
            });
            $("form[name='" + formName + "']").find("input[name='storeId']").val(storeId);
            $("form[name='" + formName + "']").find("input[name='storeName']").val(storeName).prop("disabled", true);
            $("form[name='" + formName + "']").find("select[name='productId']").productSku();
        }

    </script>
</javascript>
</body>
</html>