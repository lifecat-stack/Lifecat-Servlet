// homePage顶部栏切换
$(function () {

    $("div[status]").hide();
    $("div[status=diary-list]").show();
    console.log("运行隐藏和显示表格");

    $("a[status]").click(function () {
        var status = $(this).attr("status");
        console.log(status);
        $("div[status]").hide();
        $("div[status=" + status + "]").show();
        //由于双引号没加，造成编译错误
        $("div.dataType li").removeClass("active");
        $(this).parent("li").addClass("active");
    });
});