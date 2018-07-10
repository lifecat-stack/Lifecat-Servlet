// 弹出一个iframe层
$("#nav-diary-button").on('click', function () {
    layer.open({
        type: 2,
        title: 'diary日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: 'layerform/diaryUpload.html'
    });
});

// 弹出一个iframe层
$("#nav-image-button").on('click', function () {
    layer.open({
        type: 2,
        title: 'diary日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: 'layerform/imageUpload.html'
    });
});

// 弹出一个iframe层
$("#nav-property-button").on('click', function () {
    layer.open({
        type: 2,
        title: 'diary日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: 'layerform/propertyModify.html'
    });
});

// 弹出一个iframe层
$("#nav-password-button").on('click', function () {
    layer.open({
        type: 2,
        title: 'diary日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: 'layerform/passwordModify.html'
    });
});