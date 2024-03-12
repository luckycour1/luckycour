<%--
  Created by IntelliJ IDEA.
  User: 李铖
  Date: 2022/4/12
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="vo" scope="request" value="${requestScope.vo}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>活动详情</title>
    <link rel="stylesheet" href="../dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/layout.css">
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/footer.css">
    <link rel="stylesheet" href="../css/activityContent.css">
</head>
<body>
<header>
    <div class="header space-between">
        <div class="left">
            <img src="../image/logo2.png" />
            <a href="../index"><span>首页</span></a>
            <a href="../healthClick"><span>健康打卡</span></a>
            <a href="../activity"><span>校园活动</span></a>
            <a href="../healthMental"><span>心健中心</span></a>
            <a href="../feedback"><span>反馈中心</span></a>
        </div>
        <div class="right">
            <img src="../image/logo2.png" style="opacity: 0" />
            <a href="../me" style="margin-right: 2vw"><span>个人中心</span></a>
        </div>
    </div>
</header>
<section>
    <div class="col-lg-12 level-center content">
        <div class="col-lg-9">
            <img src="../image/activity/joinus.png" />
            <div class="nav vertical-end-left" style="background-image: url('../image/activity/${vo.activePicUrl}');">
                <!--        <img src="../image/activity/overlay.png">-->
                <div class="title">活动名称：${vo.activeTitle}</div>
                <div class="position">活动地点：${vo.activeAddress}</div>
            </div>
            <div class="act-con">
                <p class="intro">活动介绍</p>
                <div class="act-intro">
                    <div class="image">
                        <img src="../image/activity/rule.png">
                        <span>具体规则</span>
                    </div>
                    <div>
                        <p>参与范围：学院内 湖南工业大学</p>
                        <p>报名时间：${vo.startSign1} ~ ${vo.endSign1}</p>
                        <p>报名方式：报名制</p>
                        <p>报名人数：${vo.activeNowNum}/${vo.activeMaxNum}</p>
                    </div>
                </div>
                <div class="act-intro">
                    <div class="image">
                        <img src="../image/activity/content.png">
                        <span>活动信息</span>
                    </div>
                    <div>
                        <p>活动地点：${vo.activeAddress}</p>
                        <p>活动类别：${vo.activeCategory}&nbsp;类</p>
                        <p>活动时间：${vo.activeStartDate1} ~ ${vo.activeEndDate1}</p>
                        <p>活动状态：${vo.activeStatus}</p>
                    </div>
                </div>
                <div class="act-intro">
                    <div class="image">
                        <img src="../image/activity/join.png">
                        <span>参与须知</span>
                    </div>
                    <div>
                        <p>${vo.activeContent}</p>
                    </div>
                </div>
                <div class="button level-center" name="${vo.activeId}">
                    <span>报名</span>
                </div>
            </div>
        </div>
    </div>
</section>
<footer>

</footer>
</body>
<script src="../dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="../dist/Dream-Msg/dream-msg.min.js"></script>
<script src="../js/common.js"></script>
<script src="../js/header.js"></script>
<script src="../js/footer.js"></script>
<script src="../js/activityContent.js"></script>
</html>

