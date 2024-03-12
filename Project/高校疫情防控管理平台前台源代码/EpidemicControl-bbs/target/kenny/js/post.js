$(function () {
    onloadHeaderAndFooter();


    $.ajax({
        url: getContextPath() + "/post/count",
        type: "post",
        dataType: "json",
        data: {categoryId: $('.title').attr("name")},
        sync: true,
        success: function (data) {
            if(data.status === 200) {
                $('#box').paging({
                    initPageNo: 1, // 初始页码
                    totalPages: data.data, //总页数
                    totalCount: '合计300条数据', // 条目总数
                    slideSpeed: 600, // 缓动速度。单位毫秒
                    callback: function(page) { // 回调函数
                        $.ajax({
                            url: getContextPath() + "/post/data",
                            type: "post",
                            dataType: "json",
                            data: {categoryId: $('.title').attr("name"), page: page},
                            sync: true,
                            success: function (data) {
                                if(data.status === 200) {
                                    $('.nav').empty();
                                    data.data.forEach(function (item) {
                                        $('.nav').append(`
                                            <div class="item space-between">
                                                <div>
                                                    <img src="./image/post/right_arrow.png" />
                                                    <a href="post/${item.postId}">${item.postTitle}</a>
                                                </div>
                                                <span>[${item.postDate}]</span>
                                            </div>
                                        `)
                                    })
                                    // for(let i = 0; i < data.data.length; i++) {
                                    //
                                    // }
                                }  else {
                                    showSuccessMessage(data.message);
                                }
                            }
                        })
                    }
                })
            } else {
                showWarningMessage(data.message);
            }
        }
    })



})