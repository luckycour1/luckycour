$(function () {
    onloadHeaderAndFooter();

    $('section .content .single .center>div').click(function () {
        if($(this).hasClass("active")) {
            $(this).removeClass("active");
            $(this).find('input').prop("checked", false);
        } else {
            $(this).siblings().removeClass("active");
            $(this).siblings().find('input').prop("checked", false);
            $(this).addClass("active");
            $(this).find('input').prop("checked", true);
        }
    })

    $('section .content .multiple .center>div').click(function () {
        if($(this).hasClass("active")) {
            $(this).removeClass("active");
            $(this).find('input').prop("checked", false);
        } else {
            $(this).addClass("active");
            $(this).find('input').prop("checked", true);
        }
    })


    let judge = true;

    //提交事件
    $('.button').click(function () {
        if(!judge) {
            showWarningMessage("不可连续提交！");
            return;
        }
        judge = false;
        setTimeout(function () {
            judge = true;
        }, 3000)
        let form = $('form').serializeArray();
        if(form.length === 0) {
            showWarningMessage("清填写好在提交！！");
            return;
        }
        let count = 0;      //计数器
        let data = [];
        let answer = [];
        answer = [];
        let temp = {};
        let e = form[0].name;
        temp["hmId"] = form[0].name;
        answer.push(form[0].value);
        for (let i = 1; i < form.length; i++) {
            if(e === form[i].name) {
                //继续入队
                answer.push(form[i].value);
            } else {
                temp["uhmAnswer"] = answer.join("");
                answer = [];
                data.push(temp);
                temp = {};
                //初始化
                temp["hmId"] = form[i].name;
                e = form[i].name;
                answer.push(form[i].value);
                count++;
            }
            if(i === form.length - 1) {
                temp["uhmAnswer"] = answer.join("");
                data.push(temp);
                count++;
            }
        }
        if(count !== 50) {
            showWarningMessage("未全部做完不得提交");
            return;
        }
        $.ajax({
            type: "post",
            url: getContextPath() + "/healthMental/keep",
            data: JSON.stringify(data),
            contentType: "application/json",
            sync: true,
            success: function (data) {
                if(data.status === 200) {
                    showSuccessMessage(data.data);
                    setTimeout(function () {
                        window.location.href = getContextPath() + "/healthMental";
                    }, 2000);
                } else {
                    if(data.message === "/login") window.location.href = getContextPath() + "/login";
                    showErrorMessage(data.message);
                }
            }
        })
    })
})