/**
 * 获取上下文路径
 */
function getContextPath() {
    let uri = window.location.pathname;
    let pos = uri.indexOf("/", uri.indexOf("/") + 1);   //获取字符串中第二个 / 的下标
    let contextPath = uri.substring(0, pos);
    return contextPath;
}

function showSuccessMessage(message) {
    Dreamer.success(message);
}

function showInfoMessage(message) {
    Dreamer.info(message);
}

function showWarningMessage(message) {
    Dreamer.warning(message);
}

function showErrorMessage(message) {
    Dreamer.error(message);
}

function showLoadingMessage(message) {
    Dreamer.success(message);
}

function showCloseAllMessage(message) {
    Dreamer.closeAll(message);
}


function onloadHeaderAndFooter() {
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
    $.ajax({
        type: "get",
        // url:  "http://localhost:8080/bbs/footer",
        url:  getContextPath() + "/header",
        dataType: "text",
        sync: true,
        success: function (data) {
            $('header').html(data);
        }
    })
}


//判断是否在前面加0
function getNow(s) {
    return s < 10 ? '0' + s: s;
}

function getNowTime() {
    var myDate = new Date();
    var year=myDate.getFullYear();        //获取当前年
    var month=myDate.getMonth()+1;   //获取当前月
    var date=myDate.getDate();            //获取当前日
    var h=myDate.getHours();              //获取当前小时数(0-23)
    var m=myDate.getMinutes();          //获取当前分钟数(0-59)
    var s=myDate.getSeconds();
    var now=year+'-'+getNow(month)+"-"+getNow(date)+" "+getNow(h)+':'+getNow(m)+":"+getNow(s);
    return now;
}

function getNowTime2() {
    var myDate = new Date();
    var year=myDate.getFullYear();        //获取当前年
    var month=myDate.getMonth()+1;   //获取当前月
    var date=myDate.getDate();            //获取当前日
    var now=year+'-'+getNow(month)+"-"+getNow(date);
    return now;
}