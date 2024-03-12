<%--
  Created by IntelliJ IDEA.
  User: 李铖
  Date: 2022/4/16
  Time: 8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>贴子列表</title>
    <link rel="stylesheet" href="./dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./dist/HdPaging/paging.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/footer.css">
    <link rel="stylesheet" href="./css/post.css">
</head>
<body>
<div class="content">
    <header></header>
    <div class="container">
        <div class="title" name="${requestScope.title eq "校园公告" ? 2 : 1}">${requestScope.title}</div>
        <div class="nav">

        </div>
        <div class="col-xs-12 level-center" style="height: 6vh; margin-bottom: 4vh; margin-top: 2vh">
            <div class="button-group">
                <div class="box level-center" id="box"></div>
            </div>
        </div>
    </div>
</div>
<footer></footer>
</body>
<script src="./dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./dist/Dream-Msg/dream-msg.min.js"></script>
<script src="./dist/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="./dist/HdPaging/paging.js"></script>
<script src="./js/common.js"></script>
<script src="./js/header.js"></script>
<script src="./js/footer.js"></script>
<script src="./js/post.js"></script>
</html>