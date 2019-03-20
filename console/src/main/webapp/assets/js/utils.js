
//根据时间戳 格式化当前日期 yyyy-MM-dd HH:mm:ss
function getFormatDate(time){
    if(typeof(time)==="undefined"){
        return "";
    }
    var oTime;
    var oDate = new Date(time),

        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime =getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间
    return oTime;
}

//格式化当前日期yyyy-MM-dd
function getFormatSimpleDate(time){
    if(typeof(time)=="undefined"){
        return "";
    }
    var oDate = new Date(time),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay);//最后拼接时间

    return oTime;
};

//格式化当前日期 HH:mm
function getFormatHHmmssDate(time){
    if(typeof(time)=="undefined"){
        return "";
    }
    var oDate = new Date(time),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = getzf(oHour) +':'+ getzf(oMin) + ':'+getzf(oSen);//最后拼接时间

    return oTime;
};

//补0操作,当时间数据小于10的时候，给该数据前面加一个0
function getzf(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}

//格式化x轴数据
function converXAxisData(time){
    if(typeof(time)=="undefined"){
        return "";
    }
    var oDate = new Date(time),
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oTime = getzf(oDay) +'_'+ getzf(oHour) +':'+ getzf(oMin);//最后拼接时间
        // oTime = getzf(oDay)+ '' + getzf(oHour);//最后拼接时间
    return oTime;
}


//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}



/**
 * Created by LHQ on 2018/8/22 0022.
 * @version 1.0
 * @Description 经纬度转换
 */
function convertDegree(integer,decimal) {

    var minute = parseFloat("0." + decimal) * 60;
    var minutePartArr = (minute + "").split(".");
    var second = parseFloat("0." + minutePartArr[1]) * 60;
    var str = integer + "°" + minutePartArr[0] + "′" + second.toFixed(2) + "″";
    return str;
}

