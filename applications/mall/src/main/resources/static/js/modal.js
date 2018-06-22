!(function ($) {
    $.fn.myModal = function (options) {
        var defaults = {
            "id": "id",
            "title": "标题",
            "formName": "name",
            "formAction": "action",
            "cancelBtn": {
                "text": "取消",
                "onclick": function () {
                    alert("取消")
                }
            },
            "okBtn": {
                "text": "提交",
                "onclick": function () {
                    $('form[name="' + settings.formName + '"').submit(function () {.
                        $(this).ajaxSubmit();
                        return false;
                    })
                }
            },
            "bodyHtml": "<p>内容</p>"
        };
        var settings = $.extend({}, defaults, options);

        return this.each(function () {
            if ($(this).attr("data-target") && $(this).attr("data-toggle")) {
                $("#" + settings.id).remove();
            }
            $(this).attr("data-target", "#" + settings.id).attr("data-toggle", "modal");
            var html = '<div class="modal fade" id="' + settings.id + '">\n' +
                '  <div class="modal-dialog">\n' +
                '    <div class="modal-content">\n' +
                '    <form class="form-horizontal" name="' + settings.formName + '" data-toggle="validator" role="form" action="' + settings.formAction + '" method="post">' +
                '      <div class="modal-header">\n' +
                '        <h4 class="modal-title">' + settings.title + '</h4>' +
                '        <button type="button" class="close" data-dismiss="modal" aria-label="Close">' +
                '          <span aria-hidden="true">&times;</span>' +
                '        </button>' +
                '      </div>\n' +
                '      <div class="modal-body">\n' + settings.bodyHtml +
                '      </div>\n' +
                '      <div class="modal-footer">\n' +
                '        <button type="button" class="btn btn-secondary cancel" data-dismiss="modal">' + settings.cancelBtn.text + '</button>' +
                '        <button type="submit" class="btn btn-primary ok">' + settings.okBtn.text + '</button>' +
                '      </div>\n' +
                '</form>\n' +
                '    </div>\n' +
                '  </div>\n' +
                '</div>';
            $('body').append(html);

            $("#exampleModalLong .ok").on("click", function () {
                settings.okBtn.onclick.call(this)
            });
            $('form[name="' + settings.formName + '"]').validator()
        });
    }
})(jQuery)
