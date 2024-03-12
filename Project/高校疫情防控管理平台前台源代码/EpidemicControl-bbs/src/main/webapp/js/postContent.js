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

    var wordsView;
    wordsView = editormd.markdownToHTML("wordsView", {
        htmlDecode      : "style,script,iframe",  // you can filter tags decode
        emoji           : true,
        taskList        : true,
        tex             : true,  // 默认不解析
        flowChart       : true,  // 默认不解析
        sequenceDiagram : true,  // 默认不解析
    });

})