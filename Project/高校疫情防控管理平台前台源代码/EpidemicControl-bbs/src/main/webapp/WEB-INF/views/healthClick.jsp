<%--
  Created by IntelliJ IDEA.
  User: 李铖
  Date: 2022/4/6
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>健康打卡</title>
  <link rel="stylesheet" href="./dist/bootstrap-3.4.1-dist/css/bootstrap.css">
  <link rel="stylesheet" href="./css/common.css">
  <link rel="stylesheet" href="./css/layout.css">
  <link rel="stylesheet" href="./css/header.css">
  <!--  <link rel="stylesheet" href="./css/footer.css">-->
  <link rel="stylesheet" href="./css/healthClick.css">
</head>
<body>
<header></header>
<div class="container level-center">
  <div class="col-lg-4 level-center">
    <form method="post">
      <div class="content col-lg-10" style="padding-left: 2vw">
        <p class="title">健康打卡</p>
        <div class="col-lg-12 nav">
          <p>今日体温</p>
          <input class="input" name="ccTemperature" placeholder="请填写" />
        </div>
        <div class="col-lg-12 nav">
          <p>症状选择</p>
          <select class="input" name="symptomId">
            <c:forEach items="${requestScope.symptom}" var="item" varStatus="index">
              <option value="${item.symptomId}">${item.symptomName}</option>
            </c:forEach>
          </select>
        </div>
        <div class="check col-lg-12">
          <p>是否去过中高风险地区</p>
          <div>
            <input type="radio" name="ccIsGodanger" value="1">
            <span>是</span>
          </div>
          <div>
            <input checked type="radio" name="ccIsGodanger" value="0">
            <span>否</span>
          </div>
        </div>
        <div class="check col-lg-12">
          <p>是否接种新冠疫苗</p>
          <div>
            <input type="radio" name="ccIsVacc" value="1">
            <span>是</span>
          </div>
          <div>
            <input checked type="radio" name="ccIsVacc" value="0">
            <span>否</span>
          </div>
        </div>
        <div class="col-lg-12 symptom nav">
          <p>健康码颜色</p>
          <select class="input" name="ccCard">
            <option value="0">绿码</option>
            <option value="1">黄码</option>
            <option value="2">红码</option>
          </select>
        </div>
        <div class="check col-lg-12">
          <p>是否处于隔离状态</p>
          <div>
            <input type="radio" name="ccIsGap" value="0">
            <span>是</span>
          </div>
          <div>
            <input checked type="radio" name="ccIsGap" value="1">
            <span>否</span>
          </div>
        </div>
        <div class="nav position col-lg-12">
          <p>当前位置</p>
          <input disabled value="湖南工业大学" class="input" />
          <input value="湖南工业大学" type="hidden" name="ccAddress" >
        </div>
        <div class="col-lg-12 nav">
          <p>打卡日期</p>
          <input disabled value="2022/4/7 16:14:23"  class="input date"/>
        </div>
        <div class="col-lg-12 level-center">
          <div class="button level-center">
            <span>提交</span>
          </div>
        </div>
      </div>
    </form>
  </div>
</div>
<footer></footer>
</body>
<script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=TETGlmuqGGNH82WkgAHDgTaEbAV6KSuA"></script>
<script src="./dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./dist/Dream-Msg/dream-msg.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/header.js"></script>
<!--<script src="./js/footer.js"></script>-->
<script src="./js/healthClick.js"></script>
</html>

