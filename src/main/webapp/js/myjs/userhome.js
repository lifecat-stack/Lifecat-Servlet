


// 日记删除
$("button[name='diary-delete']").on("click",
    function (obj) {
        // 弹出loading框
        var ii = layer.load();

        var tr = $(this).parent().parent();
        var id = tr.children("td[class='diary-id']").text();

        // 利用ajax将数据提交到后台
        $.ajax({
            url: "diary_delete.do",
            type: 'get',
            contentType: 'charset=utf-8',
            data: {diaryId: id},
            success: function () {
                layer.close(ii);
                layer.msg("删除成功");
                setTimeout(function () {
                    window.location.reload()
                }, 1000)
            },
            error: function (error) {
                layer.close(ii);
                layer.msg("删除失败");
                console.log('接口不通' + error);
            }
        });


    }
);

// 新写日记
$("#diary-insert").on('click', function () {
    layer.open({
        type: 2,
        title: 'diary日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: 'layerform/diaryUpload.html'
    });
});

// 日记更新-button
$("button[name='diary-update']").on('click', function () {
    var tr = $(this).parent().parent();
    var id = tr.children("td[class='diary-id']").text();
    var name = tr.children("td[class='diary-name']").text();
    var text = tr.children("td[class='diary-text']").text();

    console.log("当前修改日记 id:" + id + " name:" + name + " text:" + text);

    layer.open({
        type: 2,
        title: '修改日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: 'layerform/diaryUpdate.html?id=' + id + "&name=" + name + "&text=" + text
    });
});