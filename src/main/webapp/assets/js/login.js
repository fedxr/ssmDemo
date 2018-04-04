$(function () {
    var basePath = '';
    var localObj = window.location;
    var contextPath = localObj.pathname.split("/")[1];
    basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;

    var userName = $('#account').val();
    var password = $('#password').val();

    $.ajax({
        url: basePath + '/login.action',
        type: 'POST',
        data: JSON.stringify({'userName':userName,'password':password}),
        contentType: 'application/json;charset=utf-8',
        async: true, //或false,是否异步
        dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
        success: function (data, textStatus, jqXHR) {

        },
        error: function (xhr, textStatus) {
        }
    });
});