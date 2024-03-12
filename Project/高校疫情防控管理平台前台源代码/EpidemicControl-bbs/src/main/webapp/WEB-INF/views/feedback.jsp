<%--
  Created by IntelliJ IDEA.
  User: 李铖
  Date: 2022/4/12
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>反馈中心</title>
    <link rel="stylesheet" href="./dist/bootstrap-3.4.1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="./dist/HdPaging/paging.css">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/footer.css">
    <link rel="stylesheet" href="./css/feedback.css">
</head>
<body>
<header></header>
<section>
    <div class="col-lg-12 level-center content">
        <div class="col-lg-2">
            <img src="./image/feedback/1.png" style="margin-left: 1.6vw">
        </div>
        <div class="col-lg-6 content-table">
            <div type="button" class="button level-center"  data-toggle="modal" data-target="#myModal">
                <span>我要反馈</span>
            </div>
            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">反馈列表</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" id="form">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">反馈标题</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" name="fdTitle" placeholder="请输入需要反馈的标题">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">电话号码</label>
                                    <div class="col-sm-10">
                                        <input type="tel" class="form-control" name="userPhone" placeholder="请输入电话号码">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">反馈类别</label>
                                    <div class="col-sm-10">
                                        <select class="form-control" name="fdCategoryId">
                                            <c:forEach items="${requestScope.feedCategory}" var="item">
                                                <option value="${item.fdCategoryId}">${item.categoryName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">反馈日期</label>
                                    <div class="col-sm-10">
                                        <input class="form-control date" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">反馈内容</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" name="fdContent" rows="6"></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">添加图片</label>
                                    <input type="file" id="exampleInputFile" name="image" style="margin-top: .4vh;">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary submit">提交反馈</button>
                        </div>
                    </div>
                </div>
            </div>

            <table class="table table-bordered table-hover table-striped">
                <tr>
                    <th>反馈编号</th>
                    <th>反馈标题</th>
                    <th>反馈类别</th>
                    <th>反馈日期</th>
                    <th>反馈状态</th>
                </tr>
            </table>
        </div>
        <div class="col-lg-2">
            <img src="./image/feedback/2.png" style="margin-top: 2vh">
        </div>
    </div>
    <div class="col-xs-12 level-center" style="height: 6vh; margin-bottom: 3vh">
        <div class="button-group">
            <div class="box level-center" id="box"></div>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">反馈列表</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">反馈标题</label>
                            <div class="col-sm-10">
                                <input class="form-control input1" readonly placeholder="请输入需要反馈的标题">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">电话号码</label>
                            <div class="col-sm-10">
                                <input type="tel" class="form-control input2" readonly placeholder="请输入电话号码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">反馈类别</label>
                            <div class="col-sm-10">
                                <input class="form-control input3" readonly value="生活日常">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">反馈日期</label>
                            <div class="col-sm-10">
                                <input type="tel" class="form-control input4" readonly value="2022/4/11 22:19">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">反馈状态</label>
                            <div class="col-sm-10">
                                <input type="tel" class="form-control input5" readonly value="未受理">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">反馈内容</label>
                            <div class="col-sm-10">
                                <textarea class="form-control input6" readonly rows="6">asdasdasdasd</textarea>
                            </div>
                        </div>

                        <div class="form-group input7">
                            <label class="col-sm-2 control-label">反馈图片</label>
                            <img style="width: 8vw" src="./image/feedback/1.png">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="revoke btn btn-primary">撤销反馈</button>
                </div>
            </div>
        </div>
    </div>
</section>
<footer></footer>
</body>
<script src="./dist/jQuery3.4.1/jquery-3.4.1.min.js"></script>
<script src="./dist/Dream-Msg/dream-msg.min.js"></script>
<script src="./dist/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="./dist/HdPaging/paging.js"></script>
<script src="./js/common.js"></script>
<script src="./js/header.js"></script>
<script src="./js/footer.js"></script>
<script src="./js/feedback.js"></script>
</html>












