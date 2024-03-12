<%--
  Created by IntelliJ IDEA.
  User: 李铖
  Date: 2022/4/12
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>活动中心</title>
    <link rel="stylesheet" href="./dist/rotation/css/swiper.css">
    <link rel="stylesheet" href="./dist/HdPaging/paging.css">
    <link rel="stylesheet" href="./dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/footer.css">
    <link rel="stylesheet" href="./css/activity.css">
</head>
<body>
<header>

</header>
<section>
    <div class="swiper">
        <ul class="pic">
            <c:forEach var="item" items="${requestScope.cover}" varStatus="index">
                <li <c:if test="${index.index eq 0}">class="now"</c:if> <c:if test="${index.index eq 1}">class="next"</c:if>>
                    <a href="activity/${item.activeId}"><img src="./image/activity/${item.activePicUrl}" alt="" /></a>
                </li>
            </c:forEach>
        </ul>
        <ol class="cricle" style="bottom: -3vh"></ol>
        <div class="btns">
            <a href="javascript:;" class="leftbtn" style="float: left; margin-left: 6px;"></a>
            <a href="javascript:;" class="rightbtn" style="float: right; margin-right: 6px;"></a>
        </div>
        <div class="leftBox"></div>
        <div class="rightBox"></div>
    </div>
    <div class="col-xs-12 activity-list">

    </div>
    <div class="col-xs-12 level-center" style="height: 8vh; margin-bottom: 6vh">
        <div class="button-group">
            <div class="box level-center" id="box"></div>
        </div>
    </div>

    <div class="me level-center" data-toggle="modal" data-target="#myModal">
        <span>我的活动</span>
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">我的活动</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-bordered table-hover table-striped">
                        <tr>
                            <th>活动编号</th>
                            <th>活动标题</th>
                            <th>活动类别</th>
                            <th>活动状态</th>
                            <th>活动开始日期</th>
                            <th>活动结束日期</th>
                        </tr>
                        <c:forEach var="item" items="${requestScope.table}" varStatus="index">
                            <tr>
                                <td>${index.index}</td>
                                <td class="title"><a class="limit-one" href="activity/${item.activeId}">${item.activeTitle}</a></td>
                                <td>${item.activeCategory}</td>
                                <td>${item.activeStatus}</td>
                                <td>${item.activeStartDate1}</td>
                                <td>${item.activeEndDate1}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
</section>
<footer>

</footer>
</body>
<script src="./dist/rotation/js/swiper.js"></script>
<script src="./dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./dist/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="./dist/HdPaging/paging.js"></script>
<script src="./js/common.js"></script>
<script src="./js/header.js"></script>
<script src="./js/footer.js"></script>
<script src="./js/activity.js"></script>
</html>