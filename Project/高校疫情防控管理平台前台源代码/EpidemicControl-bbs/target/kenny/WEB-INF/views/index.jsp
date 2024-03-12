<%--
  Created by IntelliJ IDEA.
  User: 李铖
  Date: 2022/4/5
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主界面</title>
    <link rel="stylesheet" href="./dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="./css/footer.css">
    <link rel="stylesheet" href="./css/index.css">
</head>
<body>
<div class="header space-between">
    <div class="left">
        <img src="image/logo2.png" />
        <a href="index"><span>首页</span></a>
    </div>
    <div class="right">
        <img src="image/logo2.png" style="opacity: 0" />
        <a href="me" style="margin-right: 2vw"><span>个人中心</span></a>
    </div>
</div>
<div class="content">
    <div class="nav-big top-center">
        <div class="col-lg-9">
            <div class="top top-space-between">
                <div class="left vertical-space-between">
                    <div>
                        <img src="./image/index/title.png">
                    </div>
                    <span>疫情终将过去，静候春暖花开</span>
                    <span>总有人在危险面前保护我们，虽然我们</span>
                    <span>素未谋面，但你一定要平平安安</span>
                </div>
                <div class="right">
                    <img src="./image/index/big_icon.png">
                </div>
            </div>
            <div class="bottom space-between">
                <div class="vertical-center">
                    <img src="./image/index/nav-1.png">
                    <a href="healthClick"><span><strong>健康打卡</strong></span></a>
                    <span>今天你打卡了吗</span>
                    <span>每日一打卡，安全你我他</span>
                </div>
                <div class="vertical-center">
                    <img src="./image/index/nav-2.png">
                    <a href="activity">
                        <span><strong>校园活动</strong></span>
                    </a>
                    <span>线上活动</span>
                    <span>保障你我的安全</span>
                </div>
                <div class="vertical-center">
                    <img src="./image/index/nav-3.png">
                    <a href="healthMental"><span><strong>心健中心</strong></span></a>
                    <span>心理测试</span>
                    <span>不让疫情影响心情</span>
                </div>
                <div class="vertical-center">
                    <img src="./image/index/nav-4.png">
                    <a href="feedback"><span><strong>反馈中心</strong></span></a>
                    <span>表达的情绪会被在意</span>
                    <span>发出的信息可以收到回复</span>
                </div>
            </div>
        </div>
    </div>
    <div style="height: 12vh"></div>
    <div class="level-center">
        <div class="col-lg-9 news">
            <div class="col-lg-7 left">
                <div class="top space-between">
                    <span>疫情动态</span>
                    <div style="display: flex">
                        <a href="news"><span>更多</span></a>
                        <img src="./image/index/right_arrow.png" />
                    </div>
                </div>
                <div class="left-image">
                    <a href="news"><img src="./image/index/1.png" /></a>
                </div>

            </div>
            <div class="col-lg-5 right">
                <div class="top space-between">
                    <span>思政教育</span>
                    <div style="display: flex">
                        <a href="education"><span>更多</span></a>
                        <img src="./image/index/right_arrow.png" />
                    </div>
                </div>
                <div class="right-image">
                    <a href="#"><img src="./image/index/2.png" /></a>
                </div>
                <c:forEach varStatus="index" items="${requestScope.post1}" var="post">
                    <div class="list">
                        <a href="post/${post.postId}">
                            <span>${post.postTitle}</span>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <div class="school col-lg-12">
                <div class="top space-between">
                    <span>校园公告</span>
                    <div style="display: flex">
                        <a href="announcement"><span>更多</span></a>
                        <img src="./image/index/right_arrow.png" />
                    </div>
                </div>
                <div class="space-between school-content">
                    <img src="./image/index/3.png" />
                    <div class="vertical-space-between">
                        <c:forEach varStatus="index" items="${requestScope.post2}" var="post">
                            <div class="list">
                                <a href="post/${post.postId}" class="space-between">
                                    <span>${post.postTitle}</span>
                                    <span>[${post.date}]</span>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="propaganda">
        <div class="icon">
            <span>疫情小贴士</span>
        </div>
        <div class="level-center">
            <img src="./image/index/tip-1.png" />
            <img src="./image/index/tip-2.png" />
            <img src="./image/index/tip-3.png" />
            <img src="./image/index/tip-4.png" />
            <img src="./image/index/tip-5.png" />
        </div>
    </div>
    <div class="special level-center">
        <span>专题网站</span>
    </div>
    <div class="web level-center">
        <a href="https://www.xuexi.cn/" target="_blank">
            <img src="./image/index/country.png">
            <div class="level-center"><span>学习强国专题网</span></div>
        </a>
        <a href="http://dangshi.people.cn/" target="_blank">
            <img src="./image/index/party.png">
            <div class="level-center"><span>党史学习教育</span></div>
        </a>
        <a href="http://llxx.hut.edu.cn/" target="_blank">
            <img src="./image/index/study.png">
            <div class="level-center"><span>理论学习专题网</span></div>
        </a>
        <a href="https://www.sizhengwang.cn/" target="_blank">
            <img src="./image/index/think.png">
            <div class="level-center"><span>思想政治教育</span></div>
        </a>
    </div>
</div>
<footer>

</footer>
</body>
<script src="./dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./js/common.js"></script>
<script src="./js/footer.js"></script>
<script src="./js/index.js"></script>
</html>