$(function () {
    // $('footer').load('footer.jsp');

    // axios.post("/footer").then(function (response) {
    //     $('footer').load(response.data);
    // })
    $.ajax({
        type: "get",
        // url:  "http://localhost:8080/bbs/footer",
        url:  getContextPath() + "/footer",
        dataType: "text",
        sync: true,
        success: function (data) {
            $('footer').html(data);
        }
    })

    $.ajax({
        url: "http://api.tianapi.com/ncov/index",
        type: "get",
        data: {key: "d334721cf6eba2d619a5855420ec352c", date: getNowTime2()},
        dataType: "json",
        success: function (data) {
            console.log("sss")
            if(data.code === 200) {
                let news = data.newslist[0].news;
                for(let i = 0; i < 2; i++) {
                    $('.news .left').append(`
                        <div class="list">
                            <a href="${news[i].sourceUrl}" target="_blank" class="space-between">
                                <span class="limit-one">${news[i].title}</span>
                                <span>[${news[i].pubDateStr}]</span>
                            </a>
                        </div>
                    `)
                }
            }
        }
    })
})