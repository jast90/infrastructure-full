<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${social} login</title>
</head>
<link rel="stylesheet" href="/webjars/font-awesome/5.0.13/web-fonts-with-css/css/fontawesome-all.min.css">

<body>
<form id="${social}" action="${'/signin/'}${social}" method="POST">
</form>
<javascript>
<script type="text/javascript">
    $(document).ready(function() {
        $('#${social}').submit();
    });
</script>
</javascript>
</body>
</html>