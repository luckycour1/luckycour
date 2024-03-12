<%--
  Created by IntelliJ IDEA.
  User: 李铖
  Date: 2022/4/12
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link rel="stylesheet" href="./dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/footer.css">
    <link rel="stylesheet" href="./css/me.css">
</head>
<body>
<header></header>
<section>
    <form>
        <div class="container">
            <div class="image col-lg-12 vertical-center">
                <img src="./image/me/default.png">
                <span class="name">李铖</span>
                <input class="header-icon" name="image" style="display: none" accept="image/*" type="file">
            </div>
            <div class="col-lg-12 level-center">
                <div class="col-lg-9">
                    <div class="info">
                        <span>昵称</span>
                        <input value="李铖" name="userName"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 level-center">
                <div class="col-lg-9">
                    <div class="info">
                        <span>性别</span>
                        <label class="radio-inline" style="margin-right: 2vw">
                            <input type="radio" name="userSex" value="0"> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="userSex" value="1"> 女
                        </label>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 level-center">
                <div class="col-lg-9">
                    <div class="info">
                        <span>学号</span>
                        <input readonly name="userNum" value="20408000910" placeholder="请设置学号"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 level-center">
                <div class="col-lg-9">
                    <div class="info">
                        <span>联系方式</span>
                        <input name="userPhone" placeholder="请设置电话号码"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 level-center">
                <div class="col-lg-9">
                    <div class="info">
                        <span>生日</span>
                        <input name="birthday" value="2022-02-06" type="date"/>
                    </div>
                </div>
            </div>
<%--            <div class="col-lg-12 level-center">--%>
<%--                <div class="col-lg-9">--%>
<%--                    <div class="info" style="display: flex">--%>
<%--                        <span>健康码</span>--%>
<%--                        <select class="input">--%>
<%--                            <option>绿码</option>--%>
<%--                            <option>黄码</option>--%>
<%--                            <option>红码</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="col-lg-12 level-center">
                <div class="col-lg-9">
                    <div class="info" style="display: flex">
                        <span>学院/部门</span>
                        <select class="input faculty">
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 level-center">
                <div class="col-lg-9">
                    <div class="info" style="display: flex">
                        <span>专业</span>
                        <select class="input major">
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 level-center">
                <div class="col-lg-9">
                    <div class="info" style="display: flex">
                        <span>班级</span>
                        <select class="input class" name="classId">
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 level-center">
                <div class="col-lg-9">
                    <div class="info">
                        <span>密码</span>
                        <input name="userPwd" placeholder="请设置密码"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 level-center">
                <div class="col-lg-9">
                    <div class="keep button level-center">
                        <span>保存</span>
                    </div>
                </div>
            </div>
        </div>
    </form>
</section>
<footer></footer>
</body>
<script src="./dist/Dream-Msg/dream-msg.min.js"></script>
<script src="./dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./dist/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/header.js"></script>
<script src="./js/footer.js"></script>
<script src="./js/me.js"></script>
</html>