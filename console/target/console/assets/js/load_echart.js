
/**
 * 加载普通仪表盘
 * @param elementIdStr
 * @param optionData
 * @param value
 */
function loadGauge(elementIdStr, optionData, value) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(elementIdStr));
    // 指定图表的配置项和数据
    option = {
        series: [{
            name: '速度',
            type: 'gauge',
            min: optionData.min,
            max: optionData.max,
            splitNumber: 10,
            radius: '80%',
            axisLine: { // 坐标轴线
                lineStyle: { // 属性lineStyle控制线条样式
                    color: [
                        [1, '#1ce25f']
                    ],
                    width: 2
                }
            },
            axisLabel: { // 坐标轴小标记
                show: false,
                textStyle: { // 属性lineStyle控制线条样式
                    fontWeight: 'bolder',
                    color: '#39e298'
                }
            },
            axisTick: { // 坐标轴小标记
                length: 5, // 属性length控制线长
                lineStyle: { // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: { // 分隔线
                length: 10, // 属性length控制线长
                lineStyle: { // 属性lineStyle（详见lineStyle）控制线条样式
                    width: 3,
                    color: '#23262e'
                }
            },
            pointer: { //指针
                length: '60%',
                width: 5
            },
            itemStyle: {
                color: [
                    [1, '#FFB751']
                ]
            },
            title: {
                offsetCenter: [0, '-30%'],
                textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontSize: 14,
                    color: '#23262e'
                }
            },
            detail: {
                offsetCenter: [0, '110%'], // x, y，单位px
                textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    color: '#23262e',
                    fontSize: 20,
                },
                formatter: function (value) {
                    return value + ' ' + optionData.unitStr;
                }
            },
            data: [{
                value: value,
                name: optionData.unitStr
            }]
        },
            //刻度盘
            {
                name: '速度',
                type: 'gauge',
                radius: '70%',
                splitNumber: 10,//刻度数量
                min: optionData.min,
                max: optionData.max,
                axisLine: {
                    show: true,
                    lineStyle: {
                        width: 0,
                        shadowBlur: 0,
                        color: [
                            [1, '#23262efff']
                        ]
                    }
                },
                axisLabel: {
                    show: true,
                    textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontSize: 10,
                        color: '#23262e'
                    }
                },
                axisTick: {
                    show: false,
                    lineStyle: {
                        color: '#23262efff',
                        width: 1
                    },
                    length: 5,
                },
                splitLine: {
                    show: false,
                    length: 0,
                    lineStyle: {
                        color: '#23262efff'
                    }
                },
                detail: {
                    show: false
                },
                pointer: {
                    show: false
                },
                title: {
                    offsetCenter: [0, '90%'],
                    textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontSize: 12,
                        color: '#23262e'
                    }
                },
                data: [{
                    name: optionData.title
                }]
            }
        ]
    };

    myChart.setOption(option);
}

/**
 * Created by xuxin on 2019/03/16 0021.
 * @version 1.0
 * @Description 加载展示方向的仪表盘
 */
function loadDirectionGauge(elementIdStr, optionData, value) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(elementIdStr));
    // 指定图表的配置项和数据
    option = {
        series: [
            {
                name: '业务指标',
                type: 'gauge',
                radius: '90%',
                detail: {
                    textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontSize: 20
                    }
                },
                title: {
                    offsetCenter: [0, '-30%'],
                    textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontSize: 14,
                        color: '#23262e'
                    }
                },
                data: [{value: value, name: optionData.title}],
                splitNumber: 8,
                startAngle: 90,
                endAngle: -269,
                min: 0,                     // 最小值
                max: 360,
                axisLine: {            // 坐标轴线
                    show: true,        // 默认显示，属性show控制显示与否
                    lineStyle: {       // 属性lineStyle控制线条样式
                        color: [
                            [0.125, 'lightgreen'],
                            [0.375, 'orange'],
                            [0.625, 'skyblue'],
                            [0.875, 'pink'],
                            [1, 'lightgreen']
                        ],
                        width: 2
                    }
                },
                axisLabel: {
                    show: true,
                    textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontSize: 10,
                        color: '#23262e'
                    },
                    formatter: function (value) {
                        if (value == 0) {
                            return 'N';
                        } else if (value == 90) {
                            return 'E';
                        } else if (value == 180) {
                            return 'S';
                        } else if (value == 270) {
                            return 'W'
                        } else if (value == 360) {
                            return '';
                        } else {
                            return value;
                        }
                    }
                },
                splitLine: { // 分隔线
                    length: 10, // 属性length控制线长
                    lineStyle: { // 属性lineStyle（详见lineStyle）控制线条样式
                        width: 3,
                        color: '#23262e'
                    }
                },
                pointer: { //指针
                    length: '60%',
                    width: 5
                }
            }
        ]
    };

    myChart.setOption(option);
}

/**
 * Created by LHQ on 2018/8/21 0021.
 * @version 1.0
 * @Description 加载风玫瑰图
 */
function loadRadar(elementIdStr, dataArr) {


    var maxData = 20;

    for (var i = 0; i < dataArr.length; i++) {
        if (dataArr[i] > maxData) {
            maxData = dataArr[i];
        }
    }


    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(elementIdStr));
    // 指定图表的配置项和数据
    var option = {
        radar: [
            {
                indicator: [
                    {text: 'N', max: maxData},
                    {text: 'NW', max: maxData},
                    {text: 'W', max: maxData},
                    {text: 'SW', max: maxData},
                    {text: 'S', max: maxData},
                    {text: 'SE', max: maxData},
                    {text: 'E', max: maxData},
                    {text: 'NE', max: maxData}
                ],
                center: ['50%', '50%'],
                radius: 90
            }
        ],
        series: [
            {
                type: 'radar',
                itemStyle: {normal: {areaStyle: {type: 'default'}}},
                data: [
                    {
                        value: dataArr,
                        name: '风玫瑰图'
                    }
                ]
            }
        ]
    };


    myChart.setOption(option);
}
/**
 * Created by xuxin on 2019/03/16 0021.
 * @version 1.0
 * @Description 加载简单的
 */
function loadLine(elementIdStr, data, splitNumber) {
    var xDataArr = [];
    var valueArr = [];
    for (var i = 0; i < data.commonDataList.length; i++) {
        xDataArr.push(converXAxisData(data.commonDataList[i].tmStamp));
        valueArr.push(data.commonDataList[i].data);
    }

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(elementIdStr));
    // 指定图表的配置项和数据
    var option = {
        grid: {
            top: '15%',
            left: '5%',
            right: '5%',
            bottom: '15%'
        },
        xAxis: {
            type: 'category',
            data: xDataArr,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#23262e'
                }
            }
        },
        yAxis: {
            type: 'value',
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#23262e'
                }
            },
            scale: true,//不强制包含0刻度
            splitNumber: splitNumber ? splitNumber : 5,
            name: data.unitStr,
            // min: 'dataMin'
            min: null
            // max:function(value) {
            //     return value.max + 20;
            // }
        },
        series: [{
            data: valueArr,
            type: 'line',
            padding: 0,
            smooth: true,
            radius: '100%',
            itemStyle: {
                normal: {
                    color: '#41D7DC',
                    lineStyle: {
                        width: 2,
                        type: 'solid'
                    }
                }
            }
        }]
    };

    myChart.setOption(option);
}

/**
 * Created by LHQ on 2019/3/16.
 * @version 1.0
 * @Description 加载多条数据
 */
function loadMultipleLine(elementIdStr, data) {
    var lineData = data.multipleDataList;
    var xDataArr = [];
    var awsField = [];
    var gradientField = [];
    var cpecField = [];

    //封装数据
    for (var i in lineData) {
        /*xDataArr.push(converXAxisData(lineData[i].tmStamp));*/
        xDataArr.push(getFormatDate(lineData[i].tmStamp))
        awsField.push(lineData[i].awsField);
        gradientField.push(lineData[i].gradientField);
        cpecField.push(lineData[i].cpecField);
    }

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(elementIdStr));
    // 指定图表的配置项和数据
    var option = {
        grid: {
            top: '5%',
            left: '10%',
            right: '5%',
            bottom: '8%'
        },
        xAxis: {
            type: 'category',
            data: xDataArr,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#23262e'
                }
            }
        },
        yAxis: {
            type: 'value',
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#23262e'
                }
            },
            scale: true,//不强制包含0刻度
            splitNumber: 0,
            name: data.unitStr
        },
        series: [{
            data: awsField,
            type: 'line',
            padding: 0,
            smooth: true,
            radius: '100%',
            itemStyle: {
                normal: {
                    color: '#EBB4FF',
                    lineStyle: {
                        width: 2,
                        type: 'solid'
                    }
                }
            }
        }, {
            data: gradientField,
            type: 'line',
            padding: 0,
            smooth: true,
            radius: '100%',
            itemStyle: {
                normal: {
                    color: '#FFDF78',
                    lineStyle: {
                        width: 2,
                        type: 'solid'
                    }
                }
            }
        }/*, {
            data: cpecField,
            type: 'line',
            padding: 0,
            smooth: true,
            radius: '100%',
            itemStyle: {
                normal: {
                    color: '#41D7DC',
                    lineStyle: {
                        width: 2,
                        type: 'solid'
                    }
                }
            }
        }*/]
    };

    myChart.setOption(option);
}

/**
 * Created by xuxin on 2019/03/16 0021.
 * @version 1.0
 * @Description 加载垂直坐标轴
 */
function loadVerticalLine(elementIdStr, xDataArr, yDataArr, optionData) {

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(elementIdStr));
    // 指定图表的配置项和数据
    var option = {
        grid: {
            top: '3%',
            left: '20px',
            right: '8%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value',
            // name: optionData.xUnit,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#32ff3f'
                }
            },
            axisLabel: {
                formatter: '{value}\n' + optionData.xUnit
            },
            scale: true,//不强制包含0刻度,
            splitNumber: optionData.splitNumber ? optionData.splitNumber : 5
        },
        yAxis: {
            type: 'category',
            // name: optionData.yUnit,
            data: yDataArr,
            scale: true,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#65ff59'
                }
            },
            axisLabel: {
                formatter: '{value} ' + optionData.yUnit
            }
        },
        series: [{
            data: xDataArr,
            type: 'line',
            padding: 0,
            smooth: true,
            radius: '100%',
            itemStyle: {
                normal: {
                    color: '#41D7DC',
                    lineStyle: {
                        width: 2,
                        type: 'solid'
                    }
                }
            }
        }]
    };

    myChart.setOption(option);
}

/**
 * Created by xuxin on 2019/03/16 0021.
 * * @version 1.0
 * @Description 加载极坐标
 */
function loadLinePolar(elementIdStr, data) {

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(elementIdStr));
    // 指定图表的配置项和数据
    var option = {
        polar: {},
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#58ff6b',
                }
            },
            formatter: '{c0}°'
        },
        angleAxis: {
            type: 'value',
            startAngle: 90,
            min: 0,
            max: 360,
            axisLine: {
                lineStyle: {
                    color: '#29ffb7'
                }
            },
            axisLabel: {
                formatter: '{value} °'
            }
        },
        radiusAxis: {
            axisLine: {
                lineStyle: {
                    color: '#6cff82'
                }
            },
            axisLabel: {
                formatter: '{value} m'
            }
        },
        series: [{
            coordinateSystem: 'polar',
            type: 'line',
            data: data,
            itemStyle: {
                normal: {
                    color: '#41D7DC',
                    lineStyle: {
                        width: 2,
                        type: 'solid'
                    }
                }
            }
        }]
    };


    myChart.setOption(option);
}


/**
 * Created by xuxin on 2019/03/16 0021.
 * @version 1.0
 * @Description 加载热力图
 */
function loadHeatmap(elementIdStr, xDataArr, yDataArr, valueArr) {


    var valueData = [];


    //封装图表需要的值数据[(x0,y0,v0),(x1,y1,v1)]
    // valueDate是 一个时间对应1024个range km数据、再下一个时间对应1024个range km数据
    var yLen = yDataArr.length;
    for (var i = 0; i < xDataArr.length; i++) {
        for (var j = 0; j < yLen; j++) {
            var value = valueArr[i * yLen + j];
            if (value >= 0) {
                valueData.push([xDataArr[i], yDataArr[j], Math.log10(value)-1]);
            } else {
                valueData.push([xDataArr[i], yDataArr[j], -Math.log10(-value)+1]);
            }

        }
    }



    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(elementIdStr));

    var option = {
        tooltip: {
            position: 'top'
        },
        animation: false,//是否开启动画。
        grid: {
            height: '80%',
            y: '10%',
            left: '10%',
            right: '16%'
        },
        xAxis: {
            type: 'category',
            data: xDataArr,
            splitArea: {
                show: true
            },
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#23262e'
                }
            }
        },
        yAxis: {
            type: 'category',
            data: yDataArr,
            name: 'km',
            splitArea: {
                show: true
            },
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#23262e'
                }
            },
            axisLabel: {
                formatter: function (value) {
                    return value * 15;
                }
            }
        },
        visualMap: {
            min: -7,
            max: 7,
            calculable: true,//是否显示拖拽用的手柄（手柄能拖拽调整选中范围）
            orient: 'vertical',
            top: '15%',
            right: '0%',
            inRange: {
                color: ['#000099', '#0000ff', '#00ffff', '#4AFFB3', '#00ff00',  '#99ff00',
                    '#23262ef00', '#ff9900', '#ff6600', '#ff3300'],/*, '#ff0000', '#990000'*/
                symbolSize: [-7, 7]
            },
            text: ['1.0e8', '-1.0e8'],
            textStyle: {
                color: 'white'
            },
            formatter: function (value) {
                var num = Math.pow(10, Math.abs(value)+1);
                var p = Math.floor(Math.log(num) / Math.LN10);
                var n = num * Math.pow(10, -p);
                return (value >= 0 ? "" : "-" ) +  n.toFixed(1) + 'e' + p  ;// 范围标签显示内容。
            }

        },
        series: [{
            name: '信号强度',
            type: 'heatmap',
            data: valueData,
            label: {
                normal: {
                    show: false//是否显示方块里面的标签。
                }
            }
        }]
    };


    myChart.setOption(option);
}


/**
 * Created by xuxin on 2019/03/16 0021..
 * @version 1.0
 * @Description 加载垂直坐标轴-区域
 */
function loadVerticalAreaLine(elementIdStr, xDataArr, yDataArr, optionData) {

    //对x轴数据进行处理
    var xDataArrTemp = [];
    for(var i = 0; i < xDataArr.length; i++) {
        if(xDataArr[i] >= 0) {
            //为正数
            xDataArrTemp.push(Math.log10(xDataArr[i]) + 8);
        } else {
            //为负数
            xDataArrTemp.push(-Math.log10(-xDataArr[i]) + 8);
        }
    }
    xDataArr = xDataArrTemp;

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(elementIdStr));
    // 指定图表的配置项和数据
    var option = {
        grid: {
            top: '3%',
            left: '3%',
            right: '8%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            min:0,
            max:16,
            type: 'value',
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#23262e'
                }
            },
            axisLabel: {
                formatter: function (value) {
                    value = value - 8;
                    var num = Math.pow(10, Math.abs(value));
                    var p = Math.floor(Math.log(num) / Math.LN10);
                    var n = num * Math.pow(10, -p);
                    return (value >= 0 ? "" : "-" ) +  n.toFixed(1) + 'e' + p  ;// 范围标签显示内容。
                }
            }
        },
        yAxis: {
            type: 'category',
            data: yDataArr,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#19ff4c'
                }
            },
            axisLabel: {
                formatter: function (value) {
                    return value * 15 + " " + optionData.yUnit;
                }
            }
        },
        series: [{
            data: xDataArr,
            type: 'line',
            padding: 0,
            // smooth: true,
            itemStyle: {
                normal: {
                    color: '#45dc50'

                }
            },
            areaStyle: {
                normal: {
                    color: 'rgba(65, 215, 220, 1)',
                    origin: 'start',
                    opacity: 1
                }

            }
        }]
    };

    myChart.setOption(option);
}




/**
 * Created by xuxin on 2019/03/16 0021.
 * @version 1.0
 * @Description 加载多条数据line
 */
function loadBCMultipleLine(elementIdStr, lineData,tmStampList) {
    //各个line对应的颜色
    var colorArr = { "bc1":"#EBB4FF", "bc2":"#FFDF78", "bc3":"#41D7DC",
        "bc4":"#1E90FF", "bc5":"#00FF7F", "bc6":"#ADFF2F",  "bc7":"#FF7F50",
        "bc8":"#808080", "bc9":"#556B2F", "bc10":"#8A2BE2"};
    //封装x轴数据
    var xDataArr = [];
    for (var i in tmStampList) {
        xDataArr.push(converXAxisData(tmStampList[i]));
    }
    //封装图表series
    var bcSeries = [];
    for (var i in lineData) {
        bcSeries.push({
            data: lineData[i],
            type: 'line',
            padding: 0,
            smooth: true,
            radius: '100%',
            itemStyle: {
                normal: {
                    color: colorArr[i],
                    lineStyle: {
                        width: 2,
                        type: 'solid'
                    }
                }
            }
        })
    }
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(elementIdStr));
    // 指定图表的配置项和数据
    var option = {
        grid: {
            top: '5%',
            left: '5%',
            right: '5%',
            bottom: '8%'
        },
        xAxis: {
            type: 'category',
            data: xDataArr,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#65ff7c'
                }
            }
        },
        yAxis: {
            type: 'value',
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#40ff8a'
                }
            },
            scale: true,//不强制包含0刻度
            splitNumber: 15,
            name: "ng/m3"
        },
        series: bcSeries
    };

    myChart.setOption(option);
}

/**
 * Created by XuXin on 2018/12/18.
 * @version 1.0
 * @Description 加载新建站点多条数据line
 */
//自定义查询加载的图表
function getServalLine(data) {
    var  dom=document.getElementById("querychart");
    var myChart = echarts.init(dom,'westeros');
    myChart.showLoading({
        text:'正在加载数据...',
    });
    //先把时间确定，在确定曲线数据
    //var xDataArr = [];

    var xDataArr=[];//
    var series=[];//数据series
    var name=[];
    Object.keys(data).forEach(function (key) {
        var unit="";
        var DataList=[];
        var tmStamp=[];
        var detail=data[key];
        Object.keys(detail).forEach(function (value) {
            if (value==='unit'){
                unit=detail[value];
            }else {
                var JSONobj=detail[value];
                for (var k=0;k<JSONobj.length;k++) {
                    var TmStamp= getFormatDate(JSONobj[k].TmStamp);
                    var data2= JSONobj[k].data;
                    DataList.push(data2);
                    tmStamp.push(TmStamp);
                }
            }
        })

        series.push({
            name:key+'('+unit+')',
            type:'line',
           /* stack:'总量',*/
            data:DataList,
        });
        name.push(key+'('+unit+')');//这里是写顶部的信息
        xDataArr=tmStamp;
    });

   var option = {
        title: {
            text: '',
            textStyle: {color:'#23262e'}
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:name,//顶部标志
            orient:'vertical',//行显示  horizontal  vertical
            y:'center',//延Y轴居中
            x:'right',//居右
            selectMode:'single',
            padding:10, //调节legand位置
            icon:'circle',
            itemWidth:10,//设置宽度
            itemHeight:10,//设置高度
            itemGap:10 //设置间距
           /* /!*data:['邮件营销123'],*!/
            textStyle:{color:'#23262e'}*/
        },
        grid: {
            left: '2%',
            right: '4%',
            bottom: '10%',
            containLabel: true,
            height:'80%',
            /*x:55,
            y:45,
            x2:5,
            y2:5,*/
            borderWidth:1,
            width:'90%'
        },
        toolbox: {
           /* feature: {
                saveAsImage: {
                    backgroundColor:'#183e6f'
                }
            }*/
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            },
            x:'right',
            y:'top'

        },
        calculable : true,
        dataZoom : {
            show : true,
            realtime : true,

            textStyle: {color:'#23262e'},
            start : 20,
            end : 80
        },
        xAxis: {
            name:'',//单位
            type: 'category',
            boundaryGap: false,
            data: xDataArr,
            axisLine:{
                lineStyle:{color:'#89ff7b'},
                axisLabel: {
                    color:'#77ffb8'
                }
            },
            splitLine:{show:false}
        },
        yAxis: {
            type: 'value',
            name:'',//单位
            axisLine:{
                lineStyle:{color:'#50ff4c'},
                axisLabel: {
                    color:'#6cff98'
                }
            },
            splitLine:{show:false}//去掉背景水平网格线
        },
        series:series
    };

   if (option && typeof option === "object") {
       myChart.hideLoading();//取消显示加载
        myChart.setOption(option,true);
        window.onresize=myChart.resize;
    }

}


/**
 * 加载混合查询图表
 * @param id
 * @param startTime
 * @param endTime
 * @param data
 */
function multiStationAndPara(id,startTime,endTime,data) {
    var  dom=document.getElementById(id);
    var myChart = echarts.init(dom,'westeros');
    myChart.showLoading({
        text:'正在加载数据...',
    });
    //先把时间确定，在确定曲线数据
    //var xDataArr = [];

    var xDataArr=[];//
    var series=[];//数据series
    var name=[];
    Object.keys(data).forEach(function (key) {
        var unit="";
        var DataList=[];
        var tmStamp=[];
        var detail=data[key];
        Object.keys(detail).forEach(function (value) {
            if (value==='unit'){
                unit=detail[value];
            }else {
                var JSONobj=detail[value];
                for (var k=0;k<JSONobj.length;k++) {
                    var TmStamp= getFormatDate(JSONobj[k].TmStamp);
                    var data2= JSONobj[k].data;
                    DataList.push(data2);
                    tmStamp.push(TmStamp);
                }
            }
        })

        series.push({
            name:key+'('+unit+')',
            type:'line',
            /* stack:'总量',*/
            data:DataList,
        });
        name.push(key+'('+unit+')');//这里是写顶部的信息
        xDataArr=tmStamp;
    });

    var option = {
        title: {
            text: '',
            textStyle: {color:'#77ff80'}
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:name,//顶部标志
            orient:'vertical',//行显示  horizontal  vertical
            y:'center',//延Y轴居中
            x:'right',//居右
            selectMode:'single',
            padding:10, //调节legand位置
            icon:'circle',
            itemWidth:10,//设置宽度
            itemHeight:10,//设置高度
            itemGap:10 //设置间距
            /* /!*data:['邮件营销123'],*!/
             textStyle:{color:'#23262e'}*/
        },
        grid: {
            left: '2%',
            right: '4%',
            bottom: '10%',
            containLabel: true,
            height:'80%',
            /*x:55,
            y:45,
            x2:5,
            y2:5,*/
            borderWidth:1,
            width:'90%'
        },
        toolbox: {
            /* feature: {
                 saveAsImage: {
                     backgroundColor:'#183e6f'
                 }
             }*/
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            },
            x:'right',
            y:'top'

        },
        calculable : true,
        dataZoom : {
            show : true,
            realtime : true,

            textStyle: {color:'#23262e'},
            start : 20,
            end : 80
        },
        xAxis: {
            name:'',//单位
            type: 'category',
            boundaryGap: false,
            data: xDataArr,
            axisLine:{
                lineStyle:{color:'#45ff5c'},
                axisLabel: {
                    color:'#23262e'
                }
            },
            splitLine:{show:false}
        },
        yAxis: {
            type: 'value',
            name:'',//单位
            axisLine:{
                lineStyle:{color:'#5cff7f'},
                axisLabel: {
                    color:'#96ff79'
                }
            },
            splitLine:{show:false}//去掉背景水平网格线
        },
        series:series
    };
    if (option && typeof option === "object") {
        myChart.hideLoading();//取消显示加载
        myChart.setOption(option,true);
        window.onresize=myChart.resize;
    }
}



