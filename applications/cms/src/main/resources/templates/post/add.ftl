<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Post</title>
    <css>
        <link rel="stylesheet" href="/webjars/editor.md/1.5.0/css/editormd.min.css"/>
    </css>
</head>
<body>
<form method="post" action="/post">
    <input type="text" name="postTitle">
    <div id="editormd">
        <textarea name="postContent"></textarea>
    </div>
    <button type="submit">提交</button>
</form>
<javascript>
    <script src="/webjars/editor.md/1.5.0/editormd.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var editor = editormd("editormd", {
                path: "/webjars/editor.md/1.5.0/lib/",
                height: 640,
                imageUpload: true,
                imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                imageUploadURL: "./php/upload.php?test=dfdf"
                /*
                 上传的后台只需要返回一个 JSON 数据，结构如下：
                 {
                    success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
                    message : "提示的信息，上传成功或上传失败及错误信息等。",
                    url     : "图片地址"        // 上传成功时才返回
                 }
                 */
            });
        });
    </script>
</javascript>
</body>
</html>