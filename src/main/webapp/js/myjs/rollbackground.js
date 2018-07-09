// 背景滚动效果
var slideEle = slider($('.items'));

function slider(elem) {
    var items = elem.children(),
        max = items.length - 1,
        animating = false,
        currentElem,
        nextElem,
        pos = 0;

    sync();

    return {
        next: function () {
            move(1);
        },
        prev: function () {
            move(-1);
        },
        itemsNum: items && items.length
    };

    function move(dir) {
        if (animating) {
            return;
        }
        if (dir > 0 && pos === max || dir < 0 && pos === 0) {
            if (dir > 0) {
                nextElem = elem.children('div').first().remove();
                nextElem.hide();
                elem.append(nextElem);
            } else {
                nextElem = elem.children('div').last().remove();
                nextElem.hide();
                elem.prepend(nextElem);
            }
            pos -= dir;
            sync();
        }
        animating = true;
        items = elem.children();
        currentElem = items[pos + dir];
        $(currentElem).fadeIn(400, function () {
            pos += dir;
            animating = false;
        });
    }

    function sync() {
        items = elem.children();
        for (var i = 0; i < items.length; ++i) {
            items[i].style.display = i === pos ? 'block' : '';
        }
    }

}

if (slideEle.itemsNum && slideEle.itemsNum > 1) {
    setInterval(function () {
        slideEle.next();
    }, 4000)
}