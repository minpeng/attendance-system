<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--导航栏-->
<#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <hr>
                    <form role="form" method="post" action="/admin/userPermissionSave">
                        <div class="form-group">
                            <label>名字</label>
                            <input name="userName" type="text" class="form-control"  readonly="true" value="${(userPermission.userName)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>部门</label>
                            <select name="departmentId" class="form-control">
                            <#list departmentList as department>
                                <option value="${department.id}"
                                    <#if (userPermission.departmentId)?? && userPermission.departmentId == department.id>
                                        selected
                                    </#if>
                                >${department.departmentName}
                                </option>
                            </#list>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>角色</label>
                            <select name="roleId" class="form-control">
                            <#list roleList as role>
                                <option value="${role.id}"
                                    <#if (userPermission.roleId)?? && userPermission.roleId == role.id>
                                        selected
                                    </#if>
                                >${role.roleName}
                                </option>
                            </#list>
                        </div>

                        <input hidden type="text" name="userId" value="${(userPermission.userId)!''}">
                        <input hidden type="text" name="id" value="${(userPermission.id)!''}">
                        <br>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>