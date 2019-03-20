<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>农大武威数据管理平台</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/global.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/font-awesome/css/font-awesome.min.css">
</head>
<body>
<div class="layui-layout layui-layout-admin" style="border-bottom: solid 5px #1aa094;">
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <div class="admin-login-box">
                <a class="logo" style="left: 0;" >
                    <span style="font-size: 22px;">数据显示系统</span>
                </a>
                <div class="admin-side-toggle">
                    <i class="fa fa-bars" aria-hidden="true" style="margin-top: 9px;"></i>
                </div>
                <div class="admin-side-full">
                    <i class="fa fa-life-bouy" aria-hidden="true" style="margin-top: 9px;"></i>
                </div>
            </div>
            <ul class="layui-nav admin-header-item">
                <li class="layui-nav-item">
                    <a href="javascript:;" class="admin-header-user">
                        <img src="${pageContext.request.contextPath}/assets/images/0.jpg" />
                        <span>beginner</span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;"><i class="fa fa-user-circle" aria-hidden="true"></i> 个人信息</a>
                        </dd>
                        <dd>
                            <a onclick="logout()"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-side layui-bg-black" id="admin-side">
        <div class="layui-side-scroll" id="admin-navbar-side" lay-filter="side"></div>
    </div>
    <div class="layui-body" style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
        <div class="layui-tab admin-nav-card layui-tab-brief" lay-filter="admin-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">
                    <i class="fa fa-dashboard" aria-hidden="true"></i>
                    <cite>控制面板</cite>
                </li>
            </ul>
            <div class="layui-tab-content" style="min-height: 150px; padding: 5px 0 0 0;">
                <div class="layui-tab-item layui-show">
                    <iframe src="/system/outside/flux/"></iframe>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-footer footer footer-demo" id="admin-footer">
        <div class="layui-main">
            <p>Copyright ©2019
                <a href="http://www.technosolutions.cn/">江苏天诺基业生态科技有限公司</a>
            </p>
        </div>
    </div>
    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <script type="text/template" id="lock-temp">
        <div class="admin-header-lock" id="lock-box">
            <div class="admin-header-lock-img">
                <img src="${pageContext.request.contextPath}/assets/images/0.jpg"/>
            </div>
            <div class="admin-header-lock-name" id="lockUserName">beginner</div>
        </div>
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/datas/nav.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/navbar.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/index.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css">
    <script>
        layui.use(["element","jquery"],function () {
            var element=layui.element;
            var $ = layui.jquery;
        });
        function logout() {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.confirm('确认退出系统？', function (index) {
                    window.location.href = "/logout";
                    layer.close(index);
                });
            })}
        var tab;

        layui.config({
            base: '${pageContext.request.contextPath}/assets/js/',
            version: new Date().getTime()
        }).use(['element', 'layer', 'navbar', 'tab'], function () {
            var element = layui.element(),
                $ = layui.jquery,
                layer = layui.layer,
                navbar = layui.navbar();
            tab = layui.tab({
                elem: '.admin-nav-card' //设置选项卡容器
                ,
                //maxSetting: {
                //	max: 5,
                //	tipMsg: '只能开5个哇，不能再开了。真的。'
                //},
                contextMenu: true,
                onSwitch: function (data) {
                    console.log(data.id); //当前Tab的Id
                    console.log(data.index); //得到当前Tab的所在下标
                    console.log(data.elem); //得到当前的Tab大容器

                    console.log(tab.getCurrentTabId())
                },
                closeBefore: function (obj) { //tab 关闭之前触发的事件
                    console.log(obj);
                    //obj.title  -- 标题
                    //obj.url    -- 链接地址
                    //obj.id     -- id
                    //obj.tabId  -- lay-id
                    if (obj.title === 'BTable') {
                        layer.confirm('确定要关闭' + obj.title + '吗?', { icon: 3, title: '系统提示' }, function (index) {
                            //因为confirm是非阻塞的，所以这里关闭当前tab需要调用一下deleteTab方法
                            tab.deleteTab(obj.tabId);
                            layer.close(index);
                        });
                        //返回true会直接关闭当前tab
                        return false;
                    }else if(obj.title==='表单'){
                        layer.confirm('未保存的数据可能会丢失哦，确定要关闭吗?', { icon: 3, title: '系统提示' }, function (index) {
                            tab.deleteTab(obj.tabId);
                            layer.close(index);
                        });
                        return false;
                    }
                    return true;
                }
            });
            //iframe自适应
            $(window).on('resize', function () {
                var $content = $('.admin-nav-card .layui-tab-content');
                $content.height($(this).height() - 147);
                $content.find('iframe').each(function () {
                    $(this).height($content.height());
                });
            }).resize();

            //设置navbar
            navbar.set({
                spreadOne: true,
                elem: '#admin-navbar-side',
                cached: true,
                data: navs
                /*cached:true,
                url: 'datas/nav.json'*/
            });
            //渲染navbar
            navbar.render();
            //监听点击事件
            navbar.on('click(side)', function (data) {
                tab.tabAdd(data.field);
            });
            //清除缓存
            $('#clearCached').on('click', function () {
                navbar.cleanCached();
                layer.alert('清除完成!', { icon: 1, title: '系统提示' }, function () {
                    location.reload();//刷新
                });
            });
        });
    </script>
</div>
</body>

</html>