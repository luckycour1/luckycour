var testEditor;
$(function() {
    $.get("0.text", function(md){
        testEditor = editormd("test-editormd", {
            width: "98%",
            height: '76vh',
            path : './dist/editor.md/lib/',
            markdown : md,
            codeFold : true,
            saveHTMLToTextarea : true,
            searchReplace : true,
            htmlDecode : "style,script,iframe|on*",
            emoji : true,
            taskList : true,
            tocm            : true,         // Using [TOCM]
            tex : true,                   // 开启科学公式TeX语言支持，默认关闭
            flowChart : true,             // 开启流程图支持，默认关闭
            sequenceDiagram : true,       // 开启时序/序列图支持，默认关闭,
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "examples/php/upload.php",
            onload : function() {
                console.log('onload', this);
            }
        });
    });

    // $('#text1').val('sadasdassssss');
    $('.button').click(function () {
        let formData = new FormData();

        //序列化
        let form = $('form').serializeArray();
        form.forEach(function (item) {
            formData.append(item.name, item.value);
        })
        //发送请求
        $.ajax({
            url: getContextPath() + "/system/post/upload",
            type: "post",
            data: formData,
            contentType : false,
            processData : false,
            success: function (data) {
                if(data.status === 200) {
                    showSuccessMessage(data.data);
                    setTimeout(function () {
                        window.location.href = getContextPath() + "/postEdit";
                    }, 1000);
                    // location.reload(true);
                } else {
                    if(data.message === "login") window.location.href = getContextPath() + "/login";
                    showErrorMessage(data.message);
                }
            }
        })

    })

})



















