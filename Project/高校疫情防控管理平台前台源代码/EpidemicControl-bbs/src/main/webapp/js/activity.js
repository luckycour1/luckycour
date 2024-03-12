$(function () {
    onloadHeaderAndFooter();

    $.ajax({
        type: "post",
        url:  getContextPath() + "/activity/pageCount",
        sync: true,
        success: function (data) {
            $('#box').paging({
                initPageNo: 1, // 初始页码
                totalPages: data.data, //总页数
                totalCount: '合计300条数据', // 条目总数
                slideSpeed: 600, // 缓动速度。单位毫秒
                callback: function(page) { // 回调函数
                    $.ajax({
                        type: "post",
                        url:  getContextPath() + "/activity/pageData",
                        data: {page: page},
                        dataType: "json",
                        sync: true,
                        success: function (data) {
                            if(data.status === 200) {
                                let box = data.data;
                                $('.activity-list .item1').empty();
                                if(box.length % 2 === 0) {
                                    for (let i = 0; i < box.length; i+=2) {
                                        $('.activity-list').append(`
                                        <div class="col-xs-12 level-center item1">
                                            <div class="col-lg-5 activity-item">
                                                <div>
                                                    <a href="activity/${box[i].activeId}">
                                                        <img src="./image/activity/${box[i].activePicUrl}">
                                                        <div class="status ${box[i].activeCss}"><span>${box[i].activeStatus}</span></div>
                                                    </a>
                                                    <div class="content vertical-space-between">
                                                        <a class="title limit-one" href="activity/${box[i].activeId}">${box[i].activeTitle}</a>
                                                        <span class="category">${box[i].activeCategory}&nbsp;类</span>
                                                        <span>活动地点：${box[i].activeAddress}</span>
                                                        <span>报名时间：${box[i].startSign} 至 ${box[i].endSign}</span>
                                                        <span>活动点击：${box[i].activeView}</span>
                                                    </div>
                                                </div>
                                                <div>
                                                    <span>报名人数：${box[i].activeNowNum}/${box[i].activeMaxNum}</span>
                                                </div>
                                            </div>
                                            <div class="col-lg-5 activity-item">
                                                 <div>
                                                    <a href="activity/${box[i + 1].activeId}">
                                                        <img src="./image/activity/${box[i + 1].activePicUrl}">
                                                        <div class="status ${box[i + 1].activeCss}"><span>${box[i + 1].activeStatus}</span></div>
                                                    </a>
                                                    <div class="content vertical-space-between">
                                                        <a class="title limit-one" href="activity/${box[i + 1].activeId}">${box[i + 1].activeTitle}</a>
                                                        <span class="category">${box[i + 1].activeCategory}&nbsp;类</span>
                                                        <span>活动地点：${box[i + 1].activeAddress}</span>
                                                        <span>报名时间：${box[i + 1].startSign} 至 ${box[i + 1].endSign}</span>
                                                        <span>活动点击：${box[i + 1].activeView}</span>
                                                    </div>
                                                </div>
                                                <div>
                                                    <span>报名人数：${box[i + 1].activeNowNum}/${box[i + 1].activeMaxNum}</span>
                                                </div>
                                            </div>
                                        </div>
                                    `)
                                    }
                                } else {
                                    for (let i = 0; i < box.length - 1; i+=2) {
                                        $('.activity-list').append(`
                                        <div class="col-xs-12 level-center item1">
                                            <div class="col-lg-5 activity-item">
                                                <div>
                                                    <a href="activity/${box[i].activeId}">
                                                        <img src="./image/activity/${box[i].activePicUrl}">
                                                        <div class="status ${box[i].activeCss}"><span>${box[i].activeStatus}</span></div>
                                                    </a>
                                                    <div class="content vertical-space-between">
                                                        <a class="title limit-one" href="activity/${box[i].activeId}">${box[i].activeTitle}</a>
                                                        <span class="category">${box[i].activeCategory}&nbsp;类</span>
                                                        <span>活动地点：${box[i].activeAddress}</span>
                                                        <span>活动时间：${box[i].startSign} 至 ${box[i].endSign}</span>
                                                        <span>活动点击：${box[i].activeView}</span>
                                                    </div>
                                                </div>
                                                <div>
                                                    <span>报名人数：${box[i].activeNowNum}/${box[i].activeMaxNum}</span>
                                                </div>
                                            </div>
                                            <div class="col-lg-5 activity-item">
                                                 <div>
                                                    <a href="activity/${box[i + 1].activeId}">
                                                        <img src="./image/activity/${box[i + 1].activePicUrl}">
                                                        <div class="status ${box[i + 1].activeCss}"><span>${box[i + 1].activeStatus}</span></div>
                                                    </a>
                                                    <div class="content vertical-space-between">
                                                        <a class="title limit-one" href="activity/${box[i + 1].activeId}">${box[i + 1].activeTitle}</a>
                                                        <span class="category">${box[i + 1].activeCategory}&nbsp;类</span>
                                                        <span>活动地点：${box[i + 1].activeAddress}</span>
                                                        <span>活动时间：${box[i + 1].startSign} 至 ${box[i + 1].endSign}</span>
                                                        <span>活动点击：${box[i + 1].activeView}</span>
                                                    </div>
                                                </div>
                                                <div>
                                                    <span>报名人数：${box[i + 1].activeNowNum}/${box[i + 1].activeMaxNum}</span>
                                                </div>
                                            </div>
                                        </div>
                                    `)
                                    }
                                    let i = box.length - 1;
                                    $('.activity-list').append(`
                                        <div class="col-xs-12 level-center item1">
                                            <div class="col-lg-5 activity-item">
                                                <div>
                                                    <a href="activity/${box[i].activeId}">
                                                        <img src="./image/activity/${box[i].activePicUrl}">
                                                        <div class="status ${box[i].activeCss}"><span>${box[i].activeStatus}</span></div>
                                                    </a>
                                                    <div class="content vertical-space-between">
                                                        <a class="title limit-one" href="activity/${box[i].activeId}">${box[i].activeTitle}</a>
                                                        <span class="category">${box[i].activeCategory}&nbsp;类</span>
                                                        <span>活动地点：${box[i].activeAddress}</span>
                                                        <span>活动时间：${box[i].startSign} 至 ${box[i].endSign}</span>
                                                        <span>活动点击：${box[i].activeView}</span>
                                                    </div>
                                                </div>
                                                <div>
                                                    <span>报名人数：${box[i].activeNowNum}/${box[i].activeMaxNum}</span>
                                                </div>
                                            </div>
                                        </div>
                                    `)
                                }
                            } else {
                                showErrorMessage(data.message);
                            }
                        }
                    })
                }
            })
        }
    })
})