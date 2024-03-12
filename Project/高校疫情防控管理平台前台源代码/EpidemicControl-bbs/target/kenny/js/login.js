$(function () {
    // console.log(getContextPath());



    $('.button').click(function () {
        if($('.username').val() === "" || $(".pwd").val() === "") {
            Dreamer.warning("账号或密码不可以为空！");
        } else {
            let data = {
                userNum: $('.username').val(),
                userPwd: $(".pwd").val()
            };


            $.ajax({
                url: getContextPath() + "/login",
                type: "post",
                data: data,
                sync: true,
                dataType: "json",
                success: function (data) {
                    if(data.status === 200) {
                        window.location.href = getContextPath() + "/index";
                    } else {
                        Dreamer.error(data.message);
                    }
                }
            })
        }

    })
})