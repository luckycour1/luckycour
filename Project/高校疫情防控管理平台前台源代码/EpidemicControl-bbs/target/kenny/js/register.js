let data = [
    {
        faculty: ["计算机学院", "包设学院"]
    }
];

$(function () {

    let facultyJudge = false;
    let faculty = $('.faculty');
    faculty.click(function () {
        if(!facultyJudge) {
            $('.faculty .dropdowns').attr("style", "display:block");
            $.ajax({
                type: "post",
                url: getContextPath() + "/register/class",
                data: {pid: 0},
                dataType: "json",
                sync: true,
                success: function (data) {
                    if(data.status === 200) {
                        for(let i = 0; i < data.data.length; i++) {
                            $('.faculty .dropdowns .scroll').append(`<p name="${data.data[i].classId}">${data.data[i].className}</p>`);
                        }
                        $('.faculty .dropdowns .scroll p').click(function () {
                            $('.faculty input').val($(this).text());
                            $('.faculty input').attr("fname", $(this).attr("name"));
                        });
                        $('.major input').val("");
                        $('.class input').val("");
                        facultyJudge = true;
                    } else {
                        Dreamer.error(data.message);
                    }
                }
            })
        } else {
            // console.log($('.faculty input').val());
            $('.faculty .dropdowns').attr("style", "display:none");
            $('.faculty .dropdowns .scroll').empty();
            // $('.faculty .dropdowns .scroll p').unbind();
            // $('.faculty input').val($(this).text());
            facultyJudge = false;
        }
    });


    let majorJudge = false;
    let major = $('.major');
    major.click(function () {
        if(!majorJudge && $('.faculty input').val() !== "") {
            $('.major .dropdowns').attr("style", "display:block");
            console.log($('.faculty input').prop("faname"))
            $.ajax({
                type: "post",
                url: getContextPath() + "/register/class",
                data: {pid: $('.faculty input').attr("fname")},
                dataType: "json",
                sync: true,
                success: function (data) {
                    if(data.status === 200) {
                        for(let i = 0; i < data.data.length; i++) {
                            $('.major .dropdowns .scroll').append(`<p name="${data.data[i].classId}">${data.data[i].className}</p>`);
                        }
                        $('.major .dropdowns .scroll p').click(function (e) {
                            $('.major input').val($(this).text());
                            $('.major input').attr("mname", $(this).attr("name"));
                            // console.log($(this).text());
                        });
                        $('.class input').val("");
                        majorJudge = true;
                    } else {
                        Dreamer.error(data.message);
                    }
                }
            })

        } else {
            $('.major .dropdowns').attr("style", "display:none");
            $('.major .dropdowns .scroll').empty();
            // $('.faculty .dropdowns .scroll p').unbind();
            // $('.faculty input').val($(this).text());
            majorJudge = false;
        }
    });

    let classJudge = false;
    let classAttr = $('.class');
    classAttr.click(function () {
        if(!classJudge && $('.major input').val() !== "") {
            $('.class .dropdowns').attr("style", "display:block");

            $.ajax({
                type: "post",
                url: getContextPath() + "/register/class",
                data: {pid: $('.major input').attr("mname")},
                dataType: "json",
                sync: true,
                success: function (data) {
                    if(data.status === 200) {
                        for(let i = 0; i < data.data.length; i++) {
                            $('.class .dropdowns .scroll').append(`<p name="${data.data[i].classId}">${data.data[i].className}</p>`);
                        }
                        $('.class .dropdowns .scroll p').click(function (e) {
                            $('.class input').val($(this).text());
                            $('.class input').attr("cname", $(this).attr("name"));
                            // console.log($(this).text());
                        });
                        classJudge = true;
                    } else {
                        Dreamer.error(data.message);
                        classJudge = true;
                    }
                }
            })
        } else {
            $('.class .dropdowns').attr("style", "display:none");
            $('.class .dropdowns .scroll').empty();
            // $('.faculty .dropdowns .scroll p').unbind();
            // $('.faculty input').val($(this).text());
            classJudge = false;
        }
    });

    //提交事件
    $('.button').click(function () {
        let val = $(".code input").val().toLowerCase();
        let num = getShowNum();
        if(val === ''){
            // alert('请输入验证码！');
            Dreamer.warning('请输入验证码！');
        }else if(val === num){
            let formArray = $("form").serializeArray();
            let user = {};
            formArray.forEach(function (item) {
                user[item.name] = item.value;
            });
            user['classId'] = $('.class input').attr("cname");
            console.log(user);
            $.ajax({
                type: "post",
                url: getContextPath() + "/register/register",
                data: JSON.stringify(user),
                contentType: "application/json;charset=utf-8",
                sync: true,
                success: function(data){
                    if(data.status === 200) {
                        showSuccessMessage(data.message);
                        window.location.href = getContextPath() + "/login";
                    } else {
                        showErrorMessage(data.message);
                    }
                }
            });
        }else{
            Dreamer.error('验证码验证错误！');
            $(".code input").val('');
            draw(show_num);
        }
    })

    // $('.dropdowns .scroll p').click(function (e) {
    //
    //     console.log($(this).text());
    // });

});