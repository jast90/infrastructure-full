!(function ($) {
    var defaults = {
        url: "/product/sku/vo/list"
    };
    var productSku = function (element, options) {
        // 该插件作用在一个select上，实现：在该select上清空所有的option后添加商品的option，并在该元素后面最佳多个select显示层级关系，并在各option上添加选中事件时罗列出子层级上的元素
        var data = [];
        $.ajax(options.url, {
            async: false,
            cache: false,
            success: function (responseData) {
                data = responseData;
            }
        });
        // console.log(data);
        var selectOptions = [];
        $.each(data, function (i, e) {
            selectOptions.push('<option value="">请选择产品</option>');
            selectOptions.push('<option value="' + e.productId + '">' + e.productName + '</option>');
        });
        // console.log(selectOptions);
        $(element).empty().append(selectOptions.join(""));
        var skuSelect = [];
        if ($(element).parent().next().find("select").length == 1) {
            $(element).parent().next().remove();
        }
        skuSelect.push('<div class="col">');
        skuSelect.push('<select name="skuId" class="form-control"><option>请选择SKU</option></select>');
        skuSelect.push('</div>');
        $(element).parent().after(skuSelect.join(""))
        $(element).change(function () {
            var productId = $(element).find("option:selected").val();
            // console.log(productId);
            var skus = [];
            $.each(data, function (index, value) {
                if (value.productId == productId) {
                    skus = value.skuList;
                }
            });
            // console.log(skus);
            var skuOptions = [];
            skuOptions.push('<option value="">请选择SKU</option>')
            $.each(skus, function (index, value) {
                // console.log(value);
                skuOptions.push('<option value="' + value.skuId + '">' + value.skuCode + ':' + value.price + '</option>')
            });
            var skuSelect = $(element).parent().next().find("select[name='skuId']");
            $(skuSelect).empty().append(skuOptions.join(""));
        });
    }

    $.fn.productSku = function (options) {
        var options = $.extend(defaults, options);
        return this.each(function () {
            productSku(this, options);
        });
    };
})(jQuery)
