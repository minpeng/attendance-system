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
                <h3>
                    员工打卡记录
                </h3>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>
                            用户名
                        </th>
                        <th>
                            日期
                        </th>
                        <th>
                            上班签到时间
                        </th>
                        <th>
                            下班签退时间
                        </th>

                    </tr>
                    </thead>
                    <tbody>

                    <#list userAttendanceContent as userAttendance>

                    <tr>
                        <td>${userAttendance.userName}</td>
                        <td>${(userAttendance.dateTime)?string('yyyy-MM-dd')}</td>
                        <td>${userAttendance.signInTime!}</td>
                        <td>${userAttendance.signOffTime!}</td>

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
                        <li><a href="/attendance/getUserInfo?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..userAttendancePage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/attendance/getUserInfo?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte userAttendancePage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/attendance/getUserInfo?page=${currentPage + 1}&size=${size}">下一页</a></li>
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