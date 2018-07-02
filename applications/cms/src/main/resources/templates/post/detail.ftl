<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Post Detail</title>
</head>
<body>
<#include "../common/common.ftl"/>
<p>${post.postTitle}</p>
<p><i class="far fa-clock"></i>${post.createdTime?datetime}</p>
<div id="test-editormd-view2">
    <textarea id="append-test" style="display:none;">

${post.postContent}

    </textarea>
</div>
<javascript>
    <script src="/webjars/editor.md/1.5.0/lib/marked.min.js"></script>
    <script src="/webjars/editor.md/1.5.0/lib/prettify.min.js"></script>

    <script src="/webjars/editor.md/1.5.0/lib/raphael.min.js"></script>
    <script src="/webjars/editor.md/1.5.0/lib/underscore.min.js"></script>
    <script src="/webjars/editor.md/1.5.0/lib/sequence-diagram.min.js"></script>
    <script src="/webjars/editor.md/1.5.0/lib/flowchart.min.js"></script>
    <script src="/webjars/editor.md/1.5.0/lib/jquery.flowchart.min.js"></script>
    <script src="/webjars/editor.md/1.5.0/editormd.min.js"></script>
    <script type="text/javascript">
        testEditormdView2 = editormd.markdownToHTML("test-editormd-view2", {
            htmlDecode: "style,script,iframe",  // you can filter tags decode
            emoji: true,
            taskList: true,
            tex: true,  // 默认不解析
            flowChart: true,  // 默认不解析
            sequenceDiagram: true,  // 默认不解析
        });
    </script>
</javascript>
</body>
</html>