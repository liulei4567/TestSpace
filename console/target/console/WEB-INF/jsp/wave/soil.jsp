<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>后台管理模板</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/plugins/font-awesome/css/font-awesome.min.css">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/ceshi.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/echarts.min.js"></script>
<style>
    /* 重置轮播样式 */
    div.block-carousel {
        height: 185px !important;
        background-color: #fff;
    }

    div.ele-center {
        text-align: center
    }
</style>
<body style="background-color: aliceblue">
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
            <div class="layui-row layui-col-space12">
                <div class="layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header">快捷方式1</div>
                        <div class="layui-card-body">
                            <div class="layui-carousel block-carousel">
                                <div class="layui-col-md6 ele-center">
                                    <img src="${pageContext.request.contextPath}/assets/images/img_humidity.png">
                                    <span style="display: block;">湿度</span>
                                    <span class="data-value">
                                        <span id="Ta_Avg">℃</span>
                                    </span>
                                </div>
                                <div class="layui-col-md6 ele-center">
                                    <img src="${pageContext.request.contextPath}/assets/images/img_rainfall.png">
                                    <span style="display: block;">降雨量</span>
                                    <span class="data-value">212
                                        <span id="2">mm</span>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header">快捷方式2</div>
                        <div class="layui-card-body">
                            <div class="layui-carousel block-carousel">
                                <div class="layui-col-md6 ele-center">
                                    <img src="${pageContext.request.contextPath}/assets/images/img_temperature.png">
                                    <span style="display: block;">温度</span>
                                    <span class="data-value">
                                        <span id="3">℃</span>
                                    </span>
                                </div>
                                <div class="layui-col-md6 ele-center">
                                    <img src="${pageContext.request.contextPath}/assets/images/img_seasurface_temperature.png">
                                    <span style="display: block;">体感温度</span>
                                    <span class="data-value">
                                        <span id="4">℃</span>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">
                            <span style="float: left">快捷方式3</span>
                            <div style="float: right">
                                <form class="layui-form" action="" style="width: 10%;height: 10%;display: inline">
                                    <div class="layui-inline">
                                        <div class="layui-form-item">
                                            <div class="layui-input-inline">
                                                <select name="modules" lay-verify="required" lay-filter="chooseTime">
                                                    <option value="">直接选择或搜索选择</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="layui-card-body">
                            <div class="layui-carousel block-carousel">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">
                            <span style="float: left">快捷方式3</span>
                            <div class="layui-form" style="float: right">
                                <form class="layui-form" action="">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <div class="layui-input-inline">
                                                <input type="text" lay-filter="date" class="layui-input" id="date" placeholder=" - ">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="layui-card-body">
                            <div class="layui-carousel block-carousel" style="height: 100%">
                                <table class="layui-hide" id="test"></table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-col-md4">




            <div   class="layui-card">
                <div class="layui-card-header">快捷方式4</div>
                <div class="layui-card-body">
                    <div id="laycard"  class="layui-carousel block-carousel" left="60px" top="10px">
                    </div>
                </div>
            </div>

            <div class="layui-card">
                <div class="layui-card-header">快捷方式5</div>
                <div class="layui-card-body">
                    <div class="layui-carousel block-carousel">
                    </div>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-header">快捷方式6</div>
                <div class="layui-card-body">
                    <div class="layui-carousel block-carousel">
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    $("#laycard").click(function () {
        begin(this);
    });
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/layui-v2.4.5/layui.js"></script>
<!--  <script type="text/javascript" src="datas/nav.js"></script>
  <script src="js/index.js"></script>-->
<script>
    layui.use(['form', 'layer', 'jquery','table'], function () {
        var $ = layui.jquery,
            layer = layui.layer,
            form = layui.form,
            table=layui.table;
        form.on('select(chooseTime)', function (data) {
            console.log(data.value); //得到被选中的值
        });
        var dom = "     <option value=\"layer\">layer</option>\n" +
            "            <option value=\"form\">form</option>\n" +
            "            <option value=\"layim\">layim</option>\n" +
            "            <option value=\"element\">element</option>";
        $("select").append(dom)
        form.render();
        //表格
        table.render({
            elem: '#test'
            ,url:'/data/flux_outside/'
            ,request:{
                pageName:'curr',
                limitName:'nums',
            }
            ,height:312
            ,page: true
            ,cols: [[
                {field:'tmStamp', minWidth:120, title: 'ID', sort: true,templet:"<div>{{layui.util.toDateString(d.tmStamp, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
                ,{field:'recNum', width:120, title: '用户名'}
                ,{field:'albedoAvg', width:120, title: '性别', sort: true}
                ,{field:'rSwInAvg', width:120, title: '城市'}
                ,{field:'rSwOutAvg', title: '签名', width: 120}
            ]]
        });

    });
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //日期范围
        laydate.render({
            elem: '#date'
            , range: true,
            value: '2018-09-09 - 2018-12-12',
            change: function (val, date) {
                console.log(val);
            }
        });
    });
</script>
</body>

</html>
