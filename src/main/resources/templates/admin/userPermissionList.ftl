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
                    员工权限信息
                </h3>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>
                            用户名
                        </th>
                        <th>
                            部门
                        </th>
                        <th>
                            角色
                        </th>

                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <#list userPermissionContent as userPermission>
                    <tr>
                        <td>${userPermission.userName}</td>
                        <td>${userPermission.departmentName!}</td>
                        <td>${userPermission.roleName!}</td>
                        <td><a href="/admin/userPermissionIndex?userId=${userPermission.userId!}">修改</a></td>
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
                        <li><a href="/admin/userPermissionList?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..userPermissionPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/admin/userPermissionList?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte userPermissionPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/admin/userPermissionList?page=${currentPage + 1}&size=${size}">下一页</a></li>
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