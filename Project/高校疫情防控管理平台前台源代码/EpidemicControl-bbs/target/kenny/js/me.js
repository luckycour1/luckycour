$(function () {
    onloadHeaderAndFooter();

    $('.faculty').click(function () {
        $('.major').val("");
        $('.class').val("");
        $(".major").empty();
        $(".class").empty();
    })

    let major = true;
    let c = true;

    $('.major').click(function () {
        $.ajax({
            type: "post",
            url: getContextPath() + "/register/class",
            data: {pid: $('.faculty option:selected').val()},
            dataType: "json",
            sync: true,
            success: function (data) {
                if(data.status === 200) {
                    if(major) {
                        $(".major").empty();
                        for(let i = 0; i < data.data.length; i++) {
                            $(".major").append(`<option value="${data.data[i].classId}">${data.data[i].className}</option>`);
                        }
                        $('.class').val("");
                        $(".class").empty();
                        major = false;
                        c = true;
                    } else {
                        major = true;
                    }
                } else {
                    Dreamer.error(data.message);
                }
            }
        })
    })

    $('.class').click(function () {
        $.ajax({
            type: "post",
            url: getContextPath() + "/register/class",
            data: {pid: $('.major option:selected').val()},
            dataType: "json",
            sync: true,
            success: function (data) {
                if(data.status === 200) {
                    if(c) {
                        $(".class").empty();
                        for(let i = 0; i < data.data.length; i++) {
                            $(".class").append(`<option value="${data.data[i].classId}">${data.data[i].className}</option>`);
                        }
                        c = false;
                    } else {
                        c = true;
                    }
                } else {
                    Dreamer.error(data.message);
                }
            }
        })
    })

    $.ajax({
        url: getContextPath() + "/me/user",
        type: "post",
        dataType: "json",
        sync: true,
        success: function (data) {
            if(data.status === 200) {
                let user = data.data;
                $.ajax({
                    type: "post",
                    url: getContextPath() + "/register/class",
                    data: {pid: 0},
                    dataType: "json",
                    sync: true,
                    success: function (data) {
                        if(data.status === 200) {
                            $(".faculty").empty();
                            for(let i = 0; i < data.data.length; i++) {
                                $(".faculty").append(`<option value="${data.data[i].classId}">${data.data[i].className}</option>`);
                            }
                            $(".faculty").val(user.faculty);
                            $.ajax({
                                type: "post",
                                url: getContextPath() + "/register/class",
                                data: {pid: $('.faculty option:selected').val()},
                                dataType: "json",
                                sync: true,
                                success: function (data) {
                                    if(data.status === 200) {
                                        $(".major").empty();
                                        for(let i = 0; i < data.data.length; i++) {
                                            $(".major").append(`<option value="${data.data[i].classId}">${data.data[i].className}</option>`);
                                        }
                                        $(".major").val(user.major);
                                        $.ajax({
                                            type: "post",
                                            url: getContextPath() + "/register/class",
                                            data: {pid: $('.major option:selected').val()},
                                            dataType: "json",
                                            sync: true,
                                            success: function (data) {
                                                if(data.status === 200) {
                                                    $(".class").empty();
                                                    for(let i = 0; i < data.data.length; i++) {
                                                        $(".class").append(`<option value="${data.data[i].classId}">${data.data[i].className}</option>`);
                                                    }
                                                    $(".class").val(user.classId);
                                                } else {
                                                    Dreamer.error(data.message);
                                                }
                                            }
                                        })
                                    } else {
                                        Dreamer.error(data.message);
                                    }
                                }
                            })
                        } else {
                            Dreamer.error(data.message);
                        }
                    }
                })

                $("input[name='userName']").val(data.data.userName);
                // $('input:radio[name=userSex]:checked')[data.data.userSex].checked = true;
                $("input[name='userSex']")[data.data.userSex].checked = true;
                $("input[name='userNum']").val(data.data.userNum);
                $("input[name='userPhone']").val(data.data.userPhone);
                // $("input[name='birthday']").val(data.data.birthday);
                $("input[name='birthday']").attr("value", data.data.birthday);
                $("input[name='userPwd']").val(data.data.userPwd);
                $(".image img").attr("src", "./image/me/header/" + data.data.headerIcon);
                $("span.name").text(data.data.userName);
            }
        }
    })

    // if($('.faculty').)

    $('.keep').click(function () {
        let data = new FormData();
        let path = $("input[name='image']").val();

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
            data.append("image", file);
        } else {
            data.append("image", null);
        }

        //序列化
        let form = $('form').serializeArray();
        form.forEach(function (item) {
            if(item.name !== "image") {
                data.append(item.name, item.value);
            }
        })

        $.ajax({
            type: "post",
            url: getContextPath() + "/me/update",
            data: data,
            contentType: false,
            processData: false,
            success: function (data) {
                if (data.status === 200) {
                    showSuccessMessage(data.data);
                    setTimeout(function () {
                        window.location.href = getContextPath() + "/me";
                    }, 2000)
                } else {
                    showErrorMessage(data.message);
                }
            }
        })
    })

    $('.image img').click(function () {
        $('.header-icon').click();
    })
})