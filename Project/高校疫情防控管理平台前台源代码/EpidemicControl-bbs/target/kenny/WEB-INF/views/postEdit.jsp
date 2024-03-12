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
    <title>公告填写</title>
    <link rel="stylesheet" href="./dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./dist/editor.md/css/editormd.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="./css/postEdit.css">
</head>
<body>
<form class="form-inline">
    <div style="width: 100%;" class="level-center">
        <div class="top">
            <div class="form-group">
                <label class="control-label">帖子标题：</label>
                <input class="form-control input" name="postTitle" value="${requestScope.vo.postTitle}" placeholder="请输入帖子标题">
                <input name="postId" value="${requestScope.vo.postId}" style="display: none">
                <input name="postUrl" value="${requestScope.vo.postUrl}" style="display: none">
            </div>
<%--            ${requestScope.vo.postCategory == 1 ? "cheked"}--%>
            <label class="radio-inline" style="margin-left: 2vw">

                <input type="radio" name="postCategory" <c:if test="${requestScope.vo.postCategory eq 1}">checked</c:if> value="1"> 思政教育
            </label>
            <label class="radio-inline">
                <input type="radio" name="postCategory" <c:if test="${requestScope.vo.postCategory eq 2}">checked</c:if> value="2"> 校园公告
            </label>
            <button style="background-color: rgb(63,145,238);margin-left: 2vw; padding: .8vh 1vw" type="button" class="btn button btn-info">提交</button>
        </div>
    </div>
    <div id="test-editormd" style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
        <textarea id="text1" name="content" style="display:none;">${requestScope.content}</textarea>
    </div>
</form>
</body>
<script src="./dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./dist/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="./dist/Dream-Msg/dream-msg.min.js"></script>
<script src="./dist/editor.md/lib/marked.min.js"></script>
<script src="./dist/editor.md/lib/prettify.min.js"></script>
<script src="./dist/editor.md/lib/raphael.min.js"></script>
<script src="./dist/editor.md/lib/underscore.min.js"></script>
<script src="./dist/editor.md/lib/sequence-diagram.min.js"></script>
<script src="./dist/editor.md/lib/flowchart.min.js"></script>
<script src="./dist/editor.md/lib/jquery.flowchart.min.js"></script>
<script src="./dist/editor.md/editormd.js" type="text/javascript"></script>
<script src="./js/common.js"></script>
<script src="./js/postEdit.js"></script>
</html>