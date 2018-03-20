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
                    <form role="form" method="post" action="/user/save">
                        <div class="form-group">
                            <label>名字</label>
                            <input name="userName" type="text" class="form-control" value="${(userInfo.userName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="text" class="form-control" value="${(userInfo.password)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>年龄</label>
                            <input name="age" type="number" class="form-control" value="${(userInfo.age)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>性别</label>
                            <input name="sex" type="text" class="form-control" value="${(userInfo.sex)!''}"/>
                        </div>
                        <input hidden type="text" name="id" value="${(userInfo.id)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>