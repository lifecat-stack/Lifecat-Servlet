$(document).ready(function () {
    $('#get-user-page').on('click', function () {
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
    });

    $('#get-diary-page').on('click', function () {
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

    });

    $('#get-image-page').on('click', function () {
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

    });

    $('#get-album-page').on('click', function () {
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

    });

    $('#get-classify-page').on('click', function () {
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

    });
});
