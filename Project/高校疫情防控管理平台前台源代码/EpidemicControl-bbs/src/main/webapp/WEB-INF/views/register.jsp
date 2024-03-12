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
    <title>注册界面</title>
    <link rel="stylesheet" href="./dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="./css/register.css">
</head>
<body>
<form>
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
                        <span>注册</span>
                    </div>
                    <div class="input username">
                        <img src="./image/login/username.png">
                        <input name="userName" placeholder="用户名"/>
                    </div>
                    <div class="input">
                        <img src="./image/login/password.png">
                        <input name="userPwd" placeholder="密码" type="password"/>
                    </div>
                    <div class="input">
                        <img src="./image/login/user_num.png" alt="">
                        <input name="userNum" placeholder="学号/工号"/>
                    </div>
                    <div class="input faculty" style="position: relative">
                        <img src="./image/login/department.png">
                        <input placeholder="院系/部门" name="faculty" disabled style="cursor: pointer"/>
                        <div class="dropdowns">
                            <div class="scroll"></div>
                        </div>
                    </div>
                    <div class="input major" style="position: relative">
                        <img src="./image/login/department.png">
                        <input placeholder="专业" name="major" disabled style="cursor: pointer"/>
                        <div class="dropdowns">
                            <div class="scroll"></div>
                        </div>
                    </div>
                    <div class="input class" style="position: relative">
                        <img src="./image/login/department.png">
                        <input placeholder="班级" name="class" disabled style="cursor: pointer"/>
                        <div class="dropdowns">
                            <div class="scroll"></div>
                        </div>
                    </div>
                    <div class="input">
                        <img src="./image/login/phone.png">
                        <input name="userPhone" placeholder="手机号"/>
                    </div>
                    <div class="code">
                        <div class="input">
                            <img src="./image/login/code.png">
                            <input placeholder="验证码"/>
                        </div>
                        <canvas id="canvas" class="canvas"></canvas>
                        <!--                    <div class="code level-center">-->
                        <!--                        <span>验证码</span>-->
                        <!--                    </div>-->
                    </div>
                    <div class="button level-center">
                        <span>注</span>
                        <span>册</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<script src="./dist/Dream-Msg/dream-msg.min.js"></script>
<script src="./dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/code.js"></script>
<script src="./js/register.js"></script>
</html>
