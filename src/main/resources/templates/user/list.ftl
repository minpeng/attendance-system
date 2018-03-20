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
                    员工用户信息  |
                    <a href="/user/index">增加新员工</a>
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

                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <#list userInfoPage.content as userInfo>
                    <tr>
                        <td>${userInfo.userName}</td>
                        <td>${userInfo.age!}</td>
                        <td>${userInfo.sex!}</td>
                        <td><a href="/user/index?id=${userInfo.id}">修改</a></td>
                        <td><a href="/user/deleteUser?id=${userInfo.id}">删除</a></td>
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
                        <li><a href="/user/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..userInfoPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/user/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte userInfoPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/user/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
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