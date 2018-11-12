<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>门店SKU列表</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>编号</th>
        <th>商品名称</th>
        <th>描述</th>
        <th>库存</th>
        <th>售价</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
        <#list list as sku>
        <tr>
            <td>${sku.skuId}</td>
            <td>${sku.skuProductVo.product.productName!""}</td>
            <td>${sku.skuDes!""}</td>
            <td>${sku.skuStock}</td>
            <td>${sku.skuPrice}</td>
            <td><a href="javascript:void(0);"
                   onclick="showUpdateSkuStock(this,'${sku.storeId}','${sku.productId}','${sku.skuId}','${sku.skuDes}')">上库存</a>|<a
                    href=" javascript:void(0);"
                    onclick="showUpdateSkuPrice(this,'${sku.storeId}','${sku.productId}','${sku.skuId}','${sku.skuDes}','${sku.skuPrice}')">改价</a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
<div id="updateSkuStock" style="display: none">
    <div class="box-body">
        <input type="hidden" name="storeId">
        <input type="hidden" name="productId">
        <input type="hidden" name="skuId">
        <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 control-label">sku描述</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="skuDesc" placeholder="sku描述">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 control-label">上架库存数</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="skuStock" placeholder="上架库存数">
            </div>
        </div>
    </div>
</div>
<div id="updateSkuPrice" style="display: none">
    <div class="box-body">
        <input type="hidden" name="storeId">
        <input type="hidden" name="productId">
        <input type="hidden" name="skuId">
        <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 control-label">sku描述</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="skuDesc" placeholder="sku描述">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 control-label">价格</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="price" placeholder="价格">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 control-label">新价格</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="skuPrice" placeholder="新价格">
            </div>
        </div>
    </div>
</div>
</body>
<javascript>
    <script type="text/javascript">
        function showUpdateSkuStock(element, storeId, productId, skuId, skuDesc) {
            var id = "updateSkuStockModal";
            var formName = "updateSkuStockForm";
            var formAction = "${requestContext.getContextPath()}/store/sku/stock/updateSkuStock";
            $(element).myModal({
                "id": id,
                "title": "添加点位SKU",
                "formName": formName,
                "formAction": formAction,
                "bodyHtml": $("#updateSkuStock").html()
            });
            $("form[name='" + formName + "']").find("input[name='storeId']").val(storeId);
            $("form[name='" + formName + "']").find("input[name='productId']").val(productId);
            $("form[name='" + formName + "']").find("input[name='skuId']").val(skuId);
            $("form[name='" + formName + "']").find("input[name='skuDesc']").val(skuDesc).prop("disabled", true);
        }

        function showUpdateSkuPrice(element, storeId, productId, skuId, skuDesc, price) {
            var id = "updateSkuPriceModal";
            var formName = "updateSkuPriceForm";
            var formAction = "${requestContext.getContextPath()}/store/sku/stock/updateSkuPrice";
            $(element).myModal({
                "id": id,
                "title": "添加点位SKU",
                "formName": formName,
                "formAction": formAction,
                "bodyHtml": $("#updateSkuPrice").html()
            });
            $("form[name='" + formName + "']").find("input[name='storeId']").val(storeId);
            $("form[name='" + formName + "']").find("input[name='productId']").val(productId);
            $("form[name='" + formName + "']").find("input[name='skuId']").val(skuId);
            $("form[name='" + formName + "']").find("input[name='skuDesc']").val(skuDesc).prop("disabled", true);
            $("form[name='" + formName + "']").find("input[name='price']").val(price).prop("disabled", true);
        }
    </script>
</javascript>
</html>