<!DOCTYPE html>
<html>

<#include "../common/header.ftl">

<body>
<#--导航栏-->
<#include "../common/nav.ftl">

<div class="container">

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <hr>
                <h3>
                    下属用户信息
                </h3>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>
                            用户名
                        </th>
                        <th>
                            年龄
                        </th>
                        <th>
                            性别
                        </th>

                        <th >考勤记录</th>
                    </tr>
                    </thead>
                    <tbody>

                    <#list userInfoContent as userInfo>
                    <tr>
                        <td>${userInfo.userName}</td>
                        <td>${userInfo.age!}</td>
                        <td>${userInfo.sex!}</td>
                        <td><a href="/manager/getUserAttendance/${userInfo.id}">打卡详情</a></td>

                    </tr>
                    </#list>
                    </tbody>
                </table>
                <!-- 分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/manager/getUserInfo/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..userInfoPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/manager/getUserInfo?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte userInfoPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/manager/getUserInfo?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
<!--底部-->
<#include "../common/footer.ftl">
</body>
</html>