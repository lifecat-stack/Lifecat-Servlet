<%--
  Created by IntelliJ IDEA.
  User: 59682
  Date: 2018/7/10
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <!--引用库：jQuery-->
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <!--引入库：layer-->
    <script src="js/layer/layer.js"></script>
</head>
<body>

<button id="test1">弹出一个提示层</button>
<button id="test2">弹出一个页面层</button>
<button id="parentIframe">弹出一个iframe层</button>
<button id="test4">弹出一个loading层</button>
<button id="test5">弹出一个tips层</button>

<script>

    //弹出一个提示层
    $('#test1').on('click', function () {
        layer.msg('hello');
    });

    //弹出一个页面层
    $('#test2').on('click', function () {
        layer.open({
            type: 1,
            area: ['600px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: '\<\div style="padding:20px;">自定义内容\<\/div>'
        });
    });

    //弹出一个iframe层
    $('#parentIframe').on('click', function () {
        layer.open({
            type: 2,
            title: 'iframe父子操作',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', '520px'],
            content: 'test/iframe.html'
        });
    });

    //弹出一个loading层
    $('#test4').on('click', function () {
        var ii = layer.load();
        //此处用setTimeout演示ajax的回调
        setTimeout(function () {
            layer.close(ii);
        }, 1000);
    });

    //弹出一个tips层
    $('#test5').on('click', function () {
        layer.tips('Hello tips!', '#test5');
    });
</script>

</body>
</html>
