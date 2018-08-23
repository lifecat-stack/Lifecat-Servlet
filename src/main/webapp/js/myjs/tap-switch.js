var userTap = function () {
    $.ajax({
        url: 'tap/user.action',
        type: 'GET',
        dataType: "html",
        success: function (html) {
            var text = $('#home-tap-div');
            text.html(html);
        },
        error: function () {
            layer.msg("请求失败:(")
        }
    })
};

var diaryTap = function () {
    $.ajax({
        url: 'tap/diary.action',
        type: 'GET',
        dataType: "html",
        success: function (html) {
            var text = $('#home-tap-div');
            text.html(html);
        },
        error: function () {
            layer.msg("请求失败:(")
        }
    })

};

var imageTap = function () {
    $.ajax({
        url: 'tap/image.action',
        type: 'GET',
        dataType: "html",
        success: function (html) {
            var text = $('#home-tap-div');
            text.html(html);
        },
        error: function () {
            layer.msg("请求失败:(")
        }
    })

};

var albumTap = function () {
    $.ajax({
        url: 'tap/album.action',
        type: 'GET',
        dataType: "html",
        success: function (html) {
            var text = $('#home-tap-div');
            text.html(html);
        },
        error: function () {
            layer.msg("请求失败:(")
        }
    })

};

var classifyTap = function () {
    $.ajax({
        url: 'tap/classify.action',
        type: 'GET',
        dataType: "html",
        success: function (html) {
            var text = $('#home-tap-div');
            text.html(html);
        },
        error: function () {
            layer.msg("请求失败:(")
        }
    })

};

// 获取用户资料
$(document).on('click', '#get-user-page', function () {
    $.ajax({
        url: "user_property_query.do",
        type: 'get',
        contentType: 'charset=utf-8',
        data: {"userId": userId},
        success: function () {
            userTap();
        },
        error: function (error) {
            layer.msg('用户资料接口不通' + error);
        }
    });
});

// 获取日记列表
$(document).on('click', '#get-diary-page', function () {
    $.ajax({
        url: "diary_list_query.do",
        type: 'get',
        contentType: 'charset=utf-8',
        data: {"userId": userId},
        success: function () {
            diaryTap()
        },
        error: function (error) {
            layer.msg('日记接口不通' + error);
        }
    });
});

// 获取图片列表
$(document).on('click', '#get-image-page', function () {
    $.ajax({
        url: "image_list_query.do",
        type: 'get',
        contentType: 'charset=utf-8',
        data: {"userId": userId},
        success: function () {
            imageTap()
        },
        error: function (error) {
            layer.msg('图片列表接口不通' + error);
        }
    });
});

// 获取相册列表
$(document).on('click', '#get-album-page', function () {
    $.ajax({
        url: "image_list_query.do",
        type: 'get',
        contentType: 'charset=utf-8',
        data: {"userId": userId},
        success: function () {
            albumTap()
        },
        error: function (error) {
            layer.msg('相册接口不通' + error);
        }
    });
});

// 获取智能分类相册列表
$(document).on('click', '#get-classify-page', function () {
    $.ajax({
        url: "image_list_query.do",
        type: 'get',
        contentType: 'charset=utf-8',
        data: {"userId": userId},
        success: function () {
            classifyTap()
        },
        error: function (error) {
            layer.msg('智能相册接口不通' + error);
        }
    });
});


