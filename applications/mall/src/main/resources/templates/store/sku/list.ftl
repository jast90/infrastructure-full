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
        <th>库存</th>
        <th>售价</th>
    </tr>
    </thead>
    <tbody>
        <#list list as sku>
        <tr>
            <td>${sku.skuId}</td>
            <td>${sku.skuProductVo.product.productName!""}</td>
            <td>${sku.skuStock}</td>
            <td>${sku.skuPrice}</td>
        </tr>
        </#list>
    </tbody>
</table>
</body>
</html>