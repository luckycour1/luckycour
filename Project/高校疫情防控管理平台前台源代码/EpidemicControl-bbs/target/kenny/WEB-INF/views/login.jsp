<%--
  Created by IntelliJ IDEA.
  User: 李铖
  Date: 2022/4/5
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="./dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
<div class="container level-center">
    <div class="center top-space-between">
        <div class="left">
            <div class="logo">
                <img src="./image/logo.png" />
            </div>
            <div class="portrait level-center">
                <img src="./image/login/icon.png">
            </div>
        </div>
        <div class="right level-center">
            <div class="vertical-space-between">
                <div class="title">
                    <span>用户登录</span>
                </div>
                <div class="input">
                    <img src="./image/login/username.png">
                    <input placeholder="用户名" class="username">
                </div>
                <div class="input">
                    <img src="./image/login/password.png">
                    <input placeholder="密码" type="password" class="pwd">
                </div>
                <div class="text space-between">
                    <a href="register"><span>注册</span></a>
                    <span style="opacity: 0">忘记密码？</span>
                </div>
                <div class="button level-center">
                    <span>登</span>
                    <span>录</span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%--<script src="https://unpkg.com/axios/dist/axios.min.js"></script>--%>
<script src="./dist/Dream-Msg/dream-msg.min.js"></script>
<script src="./dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/login.js"></script>
</html>