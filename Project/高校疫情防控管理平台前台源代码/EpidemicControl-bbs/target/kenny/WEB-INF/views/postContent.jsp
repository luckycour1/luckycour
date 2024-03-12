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
    <link rel="stylesheet" href="../dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../dist/HdPaging/paging.css">
    <link rel="stylesheet" href="../dist/editor.md/css/editormd.min.css">
    <link rel="stylesheet" href="../css/layout.css">
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/footer.css">
    <link rel="stylesheet" href="../css/postContent.css">
</head>
<body>
<div class="content">
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
    <div class="container">
        <div class="title1">${requestScope.vo.postCategory eq 1 ? "思政教育" : "校园公告"}</div>
        <div class="post">
            <div class="title">
                <div style="background-color: white; margin-left: .8vw;padding-top: 1.4vh">
                    <span>${requestScope.vo.date}</span>
                    <span>游览量：${requestScope.vo.postView}</span>
                </div>
            </div>
            <div style="width: 100%">
                <div id="wordsView">
                    <textarea style="display:none; list-style: disc; " name="editormd-markdown-doc">${requestScope.content}</textarea>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>

</footer>
</body>
<script src="../dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./dist/Dream-Msg/dream-msg.min.js"></script>
<script src="../dist/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="../dist/HdPaging/paging.js"></script>
<script src="../dist/editor.md/lib/marked.min.js"></script>
<script src="../dist/editor.md/lib/prettify.min.js"></script>
<script src="../dist/editor.md/lib/raphael.min.js"></script>
<script src="../dist/editor.md/lib/underscore.min.js"></script>
<script src="../dist/editor.md/lib/sequence-diagram.min.js"></script>
<script src="../dist/editor.md/lib/flowchart.min.js"></script>
<script src="../dist/editor.md/lib/jquery.flowchart.min.js"></script>
<script src="../dist/editor.md/editormd.min.js" type="text/javascript"></script>
<script src="../js/common.js"></script>
<script src="../js/header.js"></script>
<script src="../js/footer.js"></script>
<script src="../js/postContent.js"></script>
</html>