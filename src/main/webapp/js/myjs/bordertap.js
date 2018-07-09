// 动态边框变化
function f() {
    var topTextes = document.getElementsByClassName("top-text");
    for (topText in topTextes) {
        topText.onmouseover = function () {
            alert("hhh")
            topText.style.borderBottom = "none";
            topText.style.borderRight = "none";
            topText.style.borderTop = "1px solid";
            topText.style.borderLeft = "1px solid";
        }
    }
}