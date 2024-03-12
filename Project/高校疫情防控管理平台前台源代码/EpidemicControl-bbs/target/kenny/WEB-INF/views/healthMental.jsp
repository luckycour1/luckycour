<%--
  Created by IntelliJ IDEA.
  User: 李铖
  Date: 2022/4/12
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>心健中心</title>
    <link rel="stylesheet" href="./dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/footer.css">
    <link rel="stylesheet" href="./css/healthMental.css">
</head>
<body>
<header>

</header>
<section>
    <div class="image level-center">
        <img src="./image/healthMental/top.png" class="col-lg-9">
    </div>
    <div class="title level-center">
        <span>心理健康问卷</span>
    </div>
    <div class="content level-center">
        <div class="col-lg-8">
            <form>
                <c:forEach items="${requestScope.test.singleMental}" var="item" varStatus="index">
                    <div class="single question">
                        <div class="top">
                            <span class="num">${index.index + 1}</span>
                            <span class="ques"><strong>【单选题】</strong>${item.hmTitle}</span>
                        </div>
                        <div class="center">
                            <c:if test="${not empty item.hmQa}">
                                <div>
                                    <div><input type="radio" name="${item.hmId}" value="1"></div>
                                    <span><strong>A</strong>${item.hmQa}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQb}">
                                <div>
                                    <div><input type="radio" name="${item.hmId}" value="2"></div>
                                    <span><strong>B</strong>${item.hmQb}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQc}">
                                <div>
                                    <div><input type="radio" name="${item.hmId}" value="3"></div>
                                    <span><strong>C</strong>${item.hmQc}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQd}">
                                <div>
                                    <div><input type="radio" name="${item.hmId}" value="4"></div>
                                    <span><strong>D</strong>${item.hmQd}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQe}">
                                <div>
                                    <div><input type="radio" name="${item.hmId}" value="5"></div>
                                    <span><strong>E</strong>${item.hmQe}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQf}">
                                <div>
                                    <div><input type="radio" name="${item.hmId}" value="6"></div>
                                    <span><strong>F</strong>${item.hmQf}</span>
                                </div>
                            </c:if>

                        </div>
                    </div>
                </c:forEach>

                <c:forEach items="${requestScope.test.multipleMental}" var="item" varStatus="index">
                    <div class="multiple question">
                        <div class="top">
                            <span class="num">${index.index + 31}</span>
                            <span class="ques"><strong>【多选题】</strong>${item.hmTitle}</span>
                        </div>
                        <div class="center">
                            <c:if test="${not empty item.hmQa}">
                                <div>
                                    <div><input type="checkbox" name="${item.hmId}" value="1"></div>
                                    <span><strong>A</strong>${item.hmQa}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQb}">
                                <div>
                                    <div><input type="checkbox" name="${item.hmId}" value="2"></div>
                                    <span><strong>B</strong>${item.hmQb}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQc}">
                                <div>
                                    <div><input type="checkbox" name="${item.hmId}" value="3"></div>
                                    <span><strong>C</strong>${item.hmQc}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQd}">
                                <div>
                                    <div><input type="checkbox" name="${item.hmId}" value="4"></div>
                                    <span><strong>D</strong>${item.hmQd}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQe}">
                                <div>
                                    <div><input type="checkbox" name="${item.hmId}" value="5"></div>
                                    <span><strong>E</strong>${item.hmQe}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQf}">
                                <div>
                                    <div><input type="checkbox" name="${item.hmId}" value="6"></div>
                                    <span><strong>F</strong>${item.hmQf}</span>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>


                <c:forEach items="${requestScope.test.judgeMental}" var="item" varStatus="index">
                    <div class="judge single question">
                        <div class="top">
                            <span class="num">${index.index + 41}</span>
                            <span class="ques"><strong>【判断题】</strong>${item.hmTitle}</span>
                        </div>
                        <div class="center">
                            <c:if test="${not empty item.hmQa}">
                                <div>
                                    <div><input type="radio" name="${item.hmId}" value="1"></div>
                                    <span><strong>A</strong>${item.hmQa}</span>
                                </div>
                            </c:if>
                            <c:if test="${not empty item.hmQb}">
                                <div>
                                    <div><input type="radio" name="${item.hmId}" value="2"></div>
                                    <span><strong>B</strong>${item.hmQb}</span>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </form>
            <div class="button level-center">
                <div>提交</div>
            </div>
        </div>
    </div>
</section>
<footer>

</footer>
</body>
<script src="./dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./dist/Dream-Msg/dream-msg.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/header.js"></script>
<script src="./js/footer.js"></script>
<script src="./js/healthMental.js"></script>
</html>