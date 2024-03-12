$(function () {
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

    //获取当前地址
    // 百度地图API功能
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function (r) {
        if (this.getStatus() == BMAP_STATUS_SUCCESS) {
            getAddress(r.point.lng, r.point.lat);
        }
        else {
            alert('failed' + this.getStatus());
        }
    }, { enableHighAccuracy: true })


//关于状态码
//BMAP_STATUS_SUCCESS	检索成功。对应数值“0”。
//BMAP_STATUS_CITY_LIST	城市列表。对应数值“1”。
//BMAP_STATUS_UNKNOWN_LOCATION	位置结果未知。对应数值“2”。
//BMAP_STATUS_UNKNOWN_ROUTE	导航结果未知。对应数值“3”。
//BMAP_STATUS_INVALID_KEY	非法密钥。对应数值“4”。
//BMAP_STATUS_INVALID_REQUEST	非法请求。对应数值“5”。
//BMAP_STATUS_PERMISSION_DENIED	没有权限。对应数值“6”。(自 1.1 新增)
//BMAP_STATUS_SERVICE_UNAVAILABLE	服务不可用。对应数值“7”。(自 1.1 新增)
//BMAP_STATUS_TIMEOUT	超时。对应数值“8”。(自 1.1 新增)
//通过经纬度获取地址信息
    function getAddress(lng, lat) {
        var myGeo = new BMap.Geocoder();
        // 根据坐标得到地址描述
        myGeo.getLocation(new BMap.Point(lng, lat), function (result) {
            if (result) {
                var province = result.addressComponents.province;
                var city = result.addressComponents.city;
                var detail = result.address;
                $(".position input").val(detail);
            }
        });
    }

    $('.date').val(getNowTime());

    // clickCard["ccTemperature"] = $('.container .content div .temperature').text();
    // console.log(clickCard);

    $(".button").click(function () {
        let formArray = $("form").serializeArray();
        let clickCard = {};
        formArray.forEach(function (item) {
            clickCard[item.name] = item.value;
        });
        $.ajax({
            type: "post",
            url: getContextPath() + "/healthClick/healthClick",
            data: clickCard,
            dataType: "json",
            sync: true,
            success: function (data) {
                if(data.status === 200) {
                    showSuccessMessage(data.data);
                } else {

                    if(data.message.indexOf('login') >= 0) {
                        window.location.href = getContextPath() + "/login";
                    }
                    showWarningMessage(data.message);
                }
            }
        })
    })
})