$(function () {
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


    $('.button').click(function () {
        $.ajax({
            type: "post",
            url: getContextPath() + "/activity/sign",
            dataType: "json",
            sync: true,
            data: {activeId: $('.button').attr("name")},
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