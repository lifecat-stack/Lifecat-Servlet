// “书写寄语”
$(document).on('click', "#nav-diary-button", function () {
    layer.open({
        type: 2,
        title: '书写日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: 'layerform/diaryUpload.html'
    });
});

// “上传图片”
$(document).on('click', "#nav-image-button", function () {
    layer.open({
        type: 2,
        title: '选择图片',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: 'layerform/imageUpload.html'
    });
});

// 用户资料更新
$(document).on('click', "#nav-property-button", function () {
    layer.open({
        type: 2,
        title: '填写资料',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: 'layerform/propertyModify.html'
    });
});

// 密码更新
$(document).on('click', "#nav-password-button", function () {
    layer.open({
        type: 2,
        title: '修改密码',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: 'layerform/passwordModify.html'
    });
});