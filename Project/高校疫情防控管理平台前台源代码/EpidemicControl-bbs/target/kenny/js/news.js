$(function () {
    onloadHeaderAndFooter();

    $('.date').attr("value", getNowTime2());
    $.ajax({
        url: "http://api.tianapi.com/ncov/index",
        type: "get",
        data: {key: "d334721cf6eba2d619a5855420ec352c", date: $('.date').val()},
        dataType: "json",
        success: function (data) {
            if(data.code === 200) {
                let news = data.newslist[0].news;
                $('.nav').empty();
                news.forEach(function (item) {
                    $('.nav').append(`
                        <div class="item space-between">
                            <div>
                              <img src="./image/post/right_arrow.png"/>
                              <a href="${item.sourceUrl}" target="_blank">${item.title}</a>
                            </div>
                            <span>[${$('.date').val()}]</span>
                        </div>
                    `);
                })
            }
        }
    })
    let date = $('.date').val();
    setInterval(function () {
        if(date !== $('.date').val()) {
            $.ajax({
                url: "http://api.tianapi.com/ncov/index",
                type: "get",
                data: {key: "d334721cf6eba2d619a5855420ec352c", date: $('.date').val()},
                dataType: "json",
                success: function (data) {
                    if(data.code === 200) {
                        let news = data.newslist[0].news;
                        $('.nav').empty();
                        news.forEach(function (item) {
                            $('.nav').append(`
                        <div class="item space-between">
                            <div>
                              <img src="./image/post/right_arrow.png"/>
                              <a href="${item.sourceUrl}" target="_blank">${item.title}</a>
                            </div>
                            <span>[${$('.date').val()}]</span>
                        </div>
                    `);
                        })
                    }
                }
            })
            date = $('.date').val();
        }
    }, 10);


    $('input').attr("max", getNowTime2());

})
