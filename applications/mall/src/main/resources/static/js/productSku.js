!(function ($) {
    var defaults = {
        url: "product/sku/vo/list"
    };
    var productSku = function (element, options) {
        //TODO 该插件作用在一个select上，实现：在该select上清空所有的option后添加商品的option，并在该元素后面最佳多个select显示层级关系，并在各option上添加选中事件时罗列出子层级上的元素
        var data = [];
        $.ajax(options.url, {
            async: false,
            cache: false,
            success: function (responseData) {
                data = responseData;
            }
        });
        console.log(data);
        var selectOptions = [];
        $.each(data, function (i, e) {
            selectOptions.push('<option value="' + e.productId + '">' + e.productName + '</option>');
        });
        console.log(selectOptions);
        $(element).append(selectOptions.join(""));
    }

    $.fn.productSku = function (options) {
        var options = $.extend(defaults, options);
        return this.each(function () {
            productSku(this, options);
        });
    };
})(jQuery)
