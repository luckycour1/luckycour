let table = [
    {
        id: 1,
        title: "为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了",
        category: "生活日常",
        date: "2022/4/11",
        status: "未受理"
    },
    {
        id: 2,
        title: "为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了",
        category: "生活日常",
        date: "2022/4/11",
        status: "未受理"
    },
    {
        id: 3,
        title: "为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了",
        category: "生活日常",
        date: "2022/4/11",
        status: "未受理"
    },
    {
        id: 1,
        title: "为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了",
        category: "生活日常",
        date: "2022/4/11",
        status: "未受理"
    },
    {
        id: 1,
        title: "为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了",
        category: "生活日常",
        date: "2022/4/11",
        status: "未受理"
    },
    {
        id: 1,
        title: "为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了",
        category: "生活日常",
        date: "2022/4/11",
        status: "未受理"
    },
    {
        id: 1,
        title: "为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了",
        category: "生活日常",
        date: "2022/4/11",
        status: "未受理"
    },
    {
        id: 1,
        title: "为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了",
        category: "生活日常",
        date: "2022/4/11",
        status: "未受理"
    },
    {
        id: 1,
        title: "为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了",
        category: "生活日常",
        date: "2022/4/11",
        status: "未受理"
    },
    {
        id: 1,
        title: "为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了为什么西苑又停水了",
        category: "生活日常",
        date: "2022/4/11",
        status: "未受理"
    }
]


$(function () {
    onloadHeaderAndFooter();


    $('.date').val(getNowTime());

    $('.submit').click(function () {
        // let image = $("input[name='image']");

        let path = $("input[name='image']").val();
        let formData = new FormData();
        if (path.length !== 0) {
            let extStart = path.lastIndexOf('.'),
                ext = path.substring(extStart, path.length).toUpperCase();
            if (ext !== '.PNG' && ext !== '.JPG' && ext !== '.JPEG' && ext !== '.GIF') {
                showWarningMessage("请上传正确图片格式！");
                return;
            }
            //获取文件数据
            let file = $("input[name='image']")[0].files[0];
            //添加表单数据
            formData.append("image", file);
        } else {
            formData.append("image", null);
        }
        //序列化
        let form = $('#form').serializeArray();
        form.forEach(function (item) {
            if(item.name !== "image") {
                formData.append(item.name, item.value);
            }
        })

        //发送请求
        $.ajax({
            url: getContextPath() + "/feedback/keep",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            success: function (data) {
                if(data.status === 200) {
                    showSuccessMessage(data.data);
                    location.reload(true);
                } else {
                    if(data.message === "login") window.location.href = getContextPath() + "/login";
                    showErrorMessage(data.message);
                }
            }
        })
    })


    $.ajax({
        type: "post",
        url: getContextPath() + "/feedback/table/count",
        dataType: "json",
        sync: true,
        success: function (data) {
            if(data.status === 200) {
                $('#box').paging({
                    initPageNo: 1, // 初始页码
                    totalPages: data.data, //总页数
                    totalCount: '合计300条数据', // 条目总数
                    slideSpeed: 600, // 缓动速度。单位毫秒
                    callback: function(page) { // 回调函数
                        // $('.button').click();
                        $('.table .tr').empty();
                        $.ajax({
                            type: "post",
                            url: getContextPath() + "/feedback/table",
                            dataType: "json",
                            data: {page: page},
                            sync: true,
                            success: function (data) {
                                if(data.status === 200) {
                                    for (let i = 0; i < data.data.length; i++) {
                                        let table = data.data;
                                        $('.table tbody').append(`
                                            <tr class="tr">
                                               <td>${i + 1}</td>
                                               <td class="title"  data-toggle="modal" data-target="#myModal1" ><span class="limit-one fd-content" name="${table[i].fdId}">${table[i].fdTitle}</span></td>
                                               <td>${table[i].fdCategory}</td>
                                               <td>${table[i].date}</td>
                                               <td>${table[i].fdStatus}</td>
                                            </tr>
                                        `);
                                    }

                                    $('.fd-content').click(function () {
                                        $.ajax({
                                            type: "post",
                                            url: getContextPath() + "/feedback/table/data",
                                            dataType: "json",
                                            data: {fdId: $(this).attr("name")},
                                            sync: true,
                                            success: function (data) {
                                                if(data.status === 200) {
                                                    $('.input1').val(data.data.fdTitle);
                                                    $('.input2').val(data.data.userPhone);
                                                    $('.input3').val(data.data.fdCategory);
                                                    $('.input4').val(data.data.date);
                                                    $('.input5').val(data.data.fdStatus);
                                                    $('.input6').val(data.data.fdContent);
                                                    $('.revoke').attr("name", data.data.fdId);
                                                    if(data.data.fdPicUrl === null || data.data.fdPicUrl === undefined || data.data.fdPicUrl === "") {
                                                        $('.input7').css("display", "none");
                                                    } else {
                                                        $('.input7').css("display", "block");
                                                        $('.input7 img').attr("src", "./image/feedback/" + data.data.fdPicUrl);
                                                        // $('.input7 img').attr("src", "./image/feedback/1.png");
                                                    }

                                                } else {
                                                    showErrorMessage(data.message);
                                                }
                                            }
                                        })
                                    })

                                } else {
                                    showErrorMessage(data.message);
                                }
                            }
                        })
                    }
                })
            } else {
                showErrorMessage(data.message);
            }
        }
    })

    $('.revoke').click(function () {
        $.ajax({
            type: "post",
            url: getContextPath() + "/feedback/table/revoke",
            data: {fdId: $('.revoke').attr("name")},
            dataType: "json",
            sync: true,
            success: function (data) {
                if(data.status === 200) {
                    showSuccessMessage(data.data);
                } else {
                    showWarningMessage(data.message);
                }
            }
        })
    })


})