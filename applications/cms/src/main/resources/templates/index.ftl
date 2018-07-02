<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CMS</title>
    <css>
        <style type="text/css">
            /*.tag_header {
                display: block;
                font-size: 0;
                color: #32D3C3;
                height: 0.48rem;
                border-bottom: 1px solid #ddd;
                position: relative;
                margin: 0 0.5rem;
            }*/
        </style>
    </css>
</head>
<#include "common/common.ftl"/>
<body>
<div class="tag_header"><span>最新文章</span></div>
<div class="card-columns">
    <#list page.getContent() as post>
        <div class="card">
            <div class="card-body">
                <article>
                    <p><a href="/post/${post.id}">${post.postTitle}</a></p>
                    <p>${post.createdTime?datetime}</p>
                    <p>${post.postDescription!""}</p>
                </article>
            </div>

        </div>
    </#list>
</div>
<div>
    <@pagination modelName="page" url="${requestContext.getContextPath()}/?page="></@pagination>
</div>

<javascript>
    <script type="text/javascript">
        $(function () {
            $(".card").on("click", function () {
                window.location.href = $(this).find("a").attr("href");
            })
        });
    </script>
</javascript>
</body>
</html>